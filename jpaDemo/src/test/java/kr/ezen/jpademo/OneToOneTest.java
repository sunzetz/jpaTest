package kr.ezen.jpademo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OneToOneTest {
    @Autowired
    private BbsRepository bbsRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void oneToOnneTest() {
        Member member = new Member();
        member.setId(1L);
        member.setName("홍길동");
        member.setEmail("hong@gmail.com");
        member.setPassword("1212");

        memberRepository.save(member);

        Cart cart = new Cart();
        cart.setId(1L);
        cart.setMember(member);
        cartRepository.save(cart);

        cart = cartRepository.findById(cart.getId()).orElse(null);
        assertTrue(cart != null);
        System.out.println("cart = " + cart);

        // 양방향 연결
        memberRepository.findById(member.getId()).orElse(null);
        System.out.println("member = " + member);
        assertTrue(member != null);
    }
}
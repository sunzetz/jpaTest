package kr.ezen.jpademo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @Column(name = "member_id")
    private Long id;
    private String password;
    private String name;
    private String email;

    // @OneToOne
    // 관계형 데이터베이스에서는 FK가 하나면
    // 양항향이 된다.

    // FK가 만들어짐
    // @JoinColumn(name = "cart_id")
    // 두개의 FK가 만들어짐

    // FK를 안만든다.
    @OneToOne(mappedBy = "member")
    private Cart cart;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cart=" + cart +
                '}';
    }
}

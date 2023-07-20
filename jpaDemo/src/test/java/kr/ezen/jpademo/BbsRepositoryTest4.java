//package kr.ezen.jpademo;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.core.Tuple;
//import com.querydsl.jpa.impl.JPAQuery;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.persistence.EntityManager;
//import java.util.Date;
//import java.util.List;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class BbsRepositoryTest4 {
//    @Autowired
//    private BbsRepository bbsRepository;
//
//    @Autowired
//    private EntityManager em;
//
//    @BeforeEach
//    public void dummyData() {
//        for (int i = 1; i <= 100; i++) {
//            Bbs bbs = new Bbs();
//            bbs.setBno((long) i);
//            bbs.setTitle("title" + i);
//            bbs.setContent("content" + i);
//            bbs.setWriter("writer" + (i % 10)); // writer1 ~ 10
//            bbs.setViewCnt((long) (Math.random()*100)); // 0 ~ 99
//            bbs.setRegDate(new Date());
//            bbs.setUpDate(new Date());
//
//            bbsRepository.save(bbs);
//        }
//    }
//
//    QBbs bbs = QBbs.bbs;
//
//    @Test
//    @DisplayName("queryDSL 테스트 1")
//    public void querydslTest() {
//
//        // 1. JPAQueryFactory() 생성
//        JPAQueryFactory qf = new JPAQueryFactory(em);
//
//        // 2. 쿼리 작성
//        JPAQuery<Bbs> query = qf.selectFrom(bbs)
//                .where(bbs.title.eq("title7"));
//
//        // 3. 쿼리 실행해서 조회결과 얻기
//        List<Bbs> list = query.fetch();
////        list.forEach(b -> System.out.println(b));
//        list.forEach(System.out::println);
//    }
//
//    @Test
//    @DisplayName("queryDSL 테스트 - 복잡한 쿼리")
//    public void querydslTest2() {
//        JPAQueryFactory qf = new JPAQueryFactory(em);
//
//        JPAQuery<Tuple> query = qf.select(bbs.writer, bbs.viewCnt.sum()).from(bbs)
//                .where(bbs.title.notLike("title1"))
//                .where(bbs.writer.eq("writer1"))
//                .where(bbs.content.contains("content"))
//                .where(bbs.content.isNotNull())
//                .groupBy(bbs.writer)
//                .having(bbs.viewCnt.sum().gt(50))
//                .orderBy(bbs.writer.asc())
//                .orderBy(bbs.viewCnt.sum().desc());
//
//        List<Tuple> list = query.fetch();
//        list.forEach(System.out::println);
//    }
//
//    @Test
//    @DisplayName("queryDSL 테스트 - 동적 쿼리")
//    public void querydslTest3() {
//        String searchType = "T"; // 제목에서 검색
//        String keyword = "7";
//        keyword = "%" + keyword + "%";
//
//        BooleanBuilder builder = new BooleanBuilder();
//
//        // 조건에 따른 쿼리 작성(동적쿼리)
//        if(searchType.equalsIgnoreCase("T")) {
//            builder.and(bbs.title.like(keyword));
//        } else if (searchType.equalsIgnoreCase("C")) {
//            builder.and(bbs.content.like((keyword)));
//        } else if (searchType.equalsIgnoreCase("TC")) {
//            builder.and(bbs.title.like(keyword).or(bbs.content.like(keyword)));
//        }
//
//        JPAQueryFactory qf = new JPAQueryFactory(em);
//        JPAQuery<Bbs> query = qf.selectFrom(bbs)
//                .where(builder)
//                .orderBy(bbs.upDate.desc());
//
//        List<Bbs> list = query.fetch();
//        list.forEach(System.out::println);
//    }
//}
package kr.ezen.jpademo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

public interface BbsRepository extends CrudRepository<Bbs, Long> {
//    ////////////// 쿼리 메서드 사용 하기 ////////////
//
//    // SELECT count(*) FROM bbs WHERER writer = :writer
//    int countAllByWriter(String writer);
//
//    // SELECT * FROM bbs WHERE writer = :writer
//    List<Bbs> findByWriter(String writer);
//
//    // SELECT * FROM bbs WHERE title = :title AND writer = :writer
//    List<Bbs> findByTitleAndWriter(String title, String writer);
//
//    @Transactional
//    // DELETE FROM bbs WHERE writer = :writer
//    int deleteByWriter(String writer);
//
//    ///////// @Query를 이용한 JPQL 작성
//    @Query("SELECT b FROM Bbs b")
//    List<Bbs> finaAll();
//
//    @Query("SELECT b FROM Bbs b WHERE b.title=?1 AND b.writer=?2")
//    List<Bbs> findByTitleAndWriter2(String title, String writer);
//
//    @Query("SELECT b FROM Bbs b WHERE b.title= :title AND b.writer= :writer")
//    List<Bbs> findByTitleAndWriter3(String title, String writer);
//
//    ///////// 네이티브 쿼리 작성
//    @Query(value = "SELECT * FROM bbs", nativeQuery = true)
//    List<Bbs> findAllBySQL();
//
//    @Query(value = "SELECT title, writer FROM bbs", nativeQuery = true)
//    List<Object[]> findAllBySQL2();

}

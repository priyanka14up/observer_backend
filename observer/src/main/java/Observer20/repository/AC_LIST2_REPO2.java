package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Observer20.Model.AC_LIST2;
@Repository
public interface AC_LIST2_REPO2 extends JpaRepository<AC_LIST2,Long> {
	AC_LIST2 findByAcNo(String acNo);
	 AC_LIST2 findByStCode(String stCode);
	 List<AC_LIST2> findAllByStCodeAndAcNo(String stCode, String acNo);
}

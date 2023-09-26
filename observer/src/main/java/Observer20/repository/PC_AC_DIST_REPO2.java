package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.PC_AC_DIST2;

public interface PC_AC_DIST_REPO2 extends JpaRepository<PC_AC_DIST2,Long>{

	//PC_AC_DIST2 findByST_CODEAndAC_NO(String stCode, String acNo);

   
	List<PC_AC_DIST2> findAllByStCodeAndAcNo(String stCode, String acNo);
}

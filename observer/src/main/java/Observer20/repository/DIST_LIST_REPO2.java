package Observer20.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.DIST_LIST2;

public interface DIST_LIST_REPO2 extends JpaRepository<DIST_LIST2,Long>{

	DIST_LIST2 findByStCode(String stCode);

	//DIST_LIST2 findByDistNo(String distNoHdqtr);

	DIST_LIST2 findByDistNoAndStCode(String distNoHdqt, String stCode);

}

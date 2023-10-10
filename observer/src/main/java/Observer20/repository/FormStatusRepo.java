package Observer20.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import Observer20.Model.FormStatus;


public interface FormStatusRepo extends JpaRepository<FormStatus, Long>{
	FormStatus findByFid(Long fid);
	List<FormStatus> findAllBySubmittedBy(String submittedBy);
	
	FormStatus findByFidAndSubmittedBy(Long fid,String submittedBy);
	//FormStatus findByFidAndSubmittedByAndConstituency(Long fid,String submittedBy,String constituency);
	@Query("SELECT fs FROM FormStatus fs WHERE fs.fid = :fid AND fs.submittedBy = :submittedBy AND fs.constituency = :constituency")
	//@Query(value = "SELECT * FROM FormStatus WHERE fid = ?1 AND submittedBy = ?2 AND constituency = ?3", nativeQuery = true)
    FormStatus findByFidAndSubmittedByAndConstituency(
            @Param("fid") Long fid,
            @Param("submittedBy") String submittedBy,
            @Param("constituency") String constituency
    );
}

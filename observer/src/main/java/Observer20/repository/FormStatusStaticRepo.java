
package Observer20.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import Observer20.Model.FormStatus;
import Observer20.Model.FormStatusStatic;


public interface FormStatusStaticRepo extends JpaRepository<FormStatusStatic, Long>{
	FormStatusStatic findByFid(Long fid);
	List<FormStatusStatic> findAllBySubmittedBy(String submittedBy);
	
	FormStatusStatic findByFidAndSubmittedBy(Long fid,String submittedBy);
	//FormStatus findByFidAndSubmittedByAndConstituency(Long fid,String submittedBy,String constituency);
	@Query("SELECT fs FROM FormStatus fs WHERE fs.fid = :fid AND fs.submittedBy = :submittedBy AND fs.constituency = :constituency")
	//@Query(value = "SELECT * FROM FormStatus WHERE fid = ?1 AND submittedBy = ?2 AND constituency = ?3", nativeQuery = true)
	FormStatusStatic findByFidAndSubmittedByAndConstituency(
            @Param("fid") Long fid,
            @Param("submittedBy") String submittedBy,
            @Param("constituency") String constituency
    );
	
	@org.springframework.data.jpa.repository.Query(value = "SELECT tbl1.stat_id, tbl1.constituency,tbl1.status,tbl2.st_code, tbl1.date_modified,tbl1.f_id,tbl1.submitted_by FROM status tbl1 join obs_allot tbl2 on tbl2.obscode=tbl1.submitted_by where tbl2.st_code =:st_code GROUP by tbl1.stat_id,tbl2.st_code " , nativeQuery = true)
	List<FormStatusStatic> getAllBySubmittedBy(@Param("st_code") String st_code);

}

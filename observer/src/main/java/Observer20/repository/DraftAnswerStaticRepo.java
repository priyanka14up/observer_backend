

package Observer20.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import Observer20.Model.DraftAnswer;
import Observer20.Model.DraftAnswerStatic;
import Observer20.Model.FinalSubmitAnswer;
import Observer20.Model.Question;

public interface DraftAnswerStaticRepo extends JpaRepository<DraftAnswerStatic, Long>{
	
	DraftAnswerStatic findByQid(Long qid);
	//List<DraftAnswerStatic> findAllBySid(Long sid);
	List<DraftAnswerStatic> findAllByFid(Long fid);
	
	@Query("SELECT das FROM DraftAnswerStatic das WHERE das.fid = :formId ORDER BY das.fid")
    List<DraftAnswerStatic> findByFidOrderByFid(Long formId);
	 
	List<DraftAnswerStatic> findAllBySubmittedBy(String submittedBy);
	//List<DraftAnswerStatic> findBySidAndSubmittedBy(Long sid,String submittedBy);
	 List<DraftAnswerStatic> findByFidAndSubmittedBy(Long fid, String submittedBy);
	 //List<DraftAnswerStatic> findByFidAndSidAndSubmittedBy(Long fid,Long sid,String submittedBy);
	 DraftAnswerStatic findByFidAndQidAndSubmittedBy(Long fid,Long qid,String submittedBy );
	
	 // Custom query method to delete all draft answers by form ID
	 @Transactional 
	    @Modifying
	    @Query("DELETE FROM DraftAnswer da WHERE da.form.id = :fid")
	    void deleteByFid(@Param("fid") Long fid);
	 
	 
	 void deleteAllBySubmittedByAndFid(String obsCode,Long fid);
	 
//	 @Query("SELECT DISTINCT a.subformId FROM Answer a " +
//	           "WHERE a.formId = ?1 AND a.submittedBy = ?2")
//	    List<Long> findDistinctSubformIdsByFormIdAndSubmittedBy(Long formId, String submittedBy);
}

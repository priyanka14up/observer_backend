
package Observer20.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;
import Observer20.Model.FinalSubmitAnswerStatic;

public interface FinalSubmitAnswerStaticRepo extends JpaRepository<FinalSubmitAnswerStatic, Long>{
	//List<FinalSubmitAnswerStatic> findAllBySid(Long sid);
	//List<FinalSubmitAnswerStatic> findBySidAndSubmittedBy(Long sid,String submittedBy);
	 @Query("SELECT fsas FROM FinalSubmitAnswerStatic fsas WHERE fsas.fid = :formId ORDER BY fsas.fid")
	    List<FinalSubmitAnswerStatic> findByFidOrderByFid(Long formId);
	 
	List<FinalSubmitAnswerStatic> findAllBySubmittedBy(String submittedBy);
	//List<FinalSubmitAnswerStatic> findByFidAndSidAndSubmittedBy(Long fid,Long sid,String submittedBy);
	List<FinalSubmitAnswerStatic> findByFidAndSubmittedBy(Long fid, String submittedBy);
	 @Query("SELECT DISTINCT a.subformId FROM Answer a " +
	           "WHERE a.formId = ?1 AND a.submittedBy = ?2")
	    List<Long> findDistinctSIdsByFidAndSubmittedBy(Long fid, String submittedBy);
	// List<FinalSubmitAnswerStatic> findAllByFidAndOrderByFid(Long fid);
	 //List<FinalSubmitAnswer> findBySid(Long sid);
	 void deleteAllBySubmittedByAndFid(String obsCode,Long fid);
}

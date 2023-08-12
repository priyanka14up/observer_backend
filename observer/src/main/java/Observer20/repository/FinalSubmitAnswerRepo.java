package Observer20.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;

public interface FinalSubmitAnswerRepo extends JpaRepository<FinalSubmitAnswer, Long>{
	List<FinalSubmitAnswer> findAllBySid(Long sid);
	List<FinalSubmitAnswer> findAllBySubmittedBy(String submittedBy);
	List<FinalSubmitAnswer> findByFidAndSidAndSubmittedBy(Long fid,Long sid,String submittedBy);
	List<FinalSubmitAnswer> findByFidAndSubmittedBy(Long fid, String submittedBy);
	 @Query("SELECT DISTINCT a.subformId FROM Answer a " +
	           "WHERE a.formId = ?1 AND a.submittedBy = ?2")
	    List<Long> findDistinctSIdsByFidAndSubmittedBy(Long fid, String submittedBy);
	 List<FinalSubmitAnswer> findAllByFid(Long fid);
	 //List<FinalSubmitAnswer> findBySid(Long sid);
}

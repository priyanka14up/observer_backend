package Observer20.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;


import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;

public interface DraftAnswerRepo extends JpaRepository<DraftAnswer, Long>{
	
	DraftAnswer findByQid(Long qid);
	List<DraftAnswer> findAllBySid(Long sid);
	List<DraftAnswer> findAllByFid(Long fid);
	
	List<DraftAnswer> findAllBySubmittedBy(String submittedBy);
	 List<DraftAnswer> findByFidAndSubmittedBy(Long fid, String submittedBy);
	 List<DraftAnswer> findByFidAndSidAndSubmittedBy(Long fid,Long sid,String submittedBy);
//	 @Query("SELECT DISTINCT a.subformId FROM Answer a " +
//	           "WHERE a.formId = ?1 AND a.submittedBy = ?2")
//	    List<Long> findDistinctSubformIdsByFormIdAndSubmittedBy(Long formId, String submittedBy);
}

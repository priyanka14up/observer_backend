package Observer20.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;

public interface DraftAnswerRepo extends JpaRepository<DraftAnswer, Long>{
	
	DraftAnswer findByQid(Long qid);
	List<DraftAnswer> findAllBySid(Long sid);
	List<DraftAnswer> findAllByFid(Long fid);
	
	List<DraftAnswer> findAllBySubmittedBy(String submittedBy);
	 List<DraftAnswer> findByFidAndSubmittedBy(Long fid, String submittedBy);
	 List<DraftAnswer> findByFidAndSidAndSubmittedBy(Long fid,Long sid,String submittedBy);
	 DraftAnswer findByFidAndQidAndSubmittedBy(Long fid,Long qid,String submittedBy );
	 
	 // Custom query method to delete all draft answers by form ID
	 @Transactional 
	    @Modifying
	    @Query("DELETE FROM DraftAnswer da WHERE da.form.id = :fid")
	    void deleteByFid(@Param("fid") Long fid);
	    
//	 @Query("SELECT DISTINCT a.subformId FROM Answer a " +
//	           "WHERE a.formId = ?1 AND a.submittedBy = ?2")
//	    List<Long> findDistinctSubformIdsByFormIdAndSubmittedBy(Long formId, String submittedBy);
}

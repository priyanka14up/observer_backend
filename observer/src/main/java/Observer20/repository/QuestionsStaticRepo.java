

package Observer20.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Observer20.Dto.QuestionProjection;
import Observer20.Dto.QuestionProjectionSubform;
import Observer20.Dto.QuestionStaticArrivalDto;
import Observer20.Model.Question;
import Observer20.Model.QuestionStatic;

@Repository
public interface QuestionsStaticRepo extends JpaRepository<QuestionStatic, Long>{
//	 @Query("SELECT q FROM Question q JOIN q.subform s WHERE s.sid = :subformId ORDER BY q.qid")
//	List<Question> findQuestionsBySubformSidAndOrderByQid(@Param("subformId")Long sid);
//	 
//	 @Query("SELECT q.subform.sid FROM Question q WHERE q.qid = :qid")
//	    Long findSubformSidByQid(@Param("qid") Long qid);
//	 
	QuestionStatic findByQid(Long qid);
	
	//@Query("SELECT * FROM QuestionStatic WHERE qid <= 10")
	//@Query("SELECT q FROM QuestionStatic q WHERE q.fid = :fid AND q.qid <= 10")
   // List<QuestionStatic> findRecordsWithQidUpTo10(@Param("fid") Long fid);
	
	List<QuestionStatic> findByFid(Long fid);
	
	List<QuestionProjectionSubform> findAllByFid(Long fid);
	//SELECT * FROM QuestionStatic WHERE qid <= 10;
	
	List<QuestionStatic> findBytName(String tName);

	@Query("SELECT new Observer20.Dto.QuestionProjection ( q.qid,q.qtext,q.type,q.fid) FROM QuestionStatic q WHERE q.fid = :fid AND q.qid <= 10 ORDER BY q.qid")
	List<QuestionProjection> findRecordsWithQidUpTo10(Long fid);

	//@Query("SELECT q FROM QuestionStatic q WHERE q.fid = :fid AND q.qid > 10 ORDER BY q.qid")
	 @Query("SELECT new Observer20.Dto.QuestionProjection ( q.qid,q.qtext,q.type,q.fid) FROM QuestionStatic q WHERE q.fid = :fid AND q.qid > 10 ORDER BY q.qid")
	List<QuestionProjection> findRecordsWithQidGreater10(@Param("fid") Long fid);
	
	 @Query("SELECT new Observer20.Dto.QuestionProjection ( q.qid,q.qtext,q.type,q.fid) FROM QuestionStatic q WHERE q.fid = :fid AND q.qid <= 10 ORDER BY q.qid")
		List<QuestionProjection> findRecordsWithQidUpTo4(Long fid);
	
	 @Query("SELECT q.sid, q FROM QuestionStatic q WHERE q.fid = :fid")
	    List<Map<Long, QuestionStatic>> findAllCategorizedBySid(@Param("fid") Long fid);
//	 @Query("SELECT e FROM QuestionStatic e WHERE e.qid = :qid")
//	 QuestionStatic findByQid(@Param("qid") Long qid);
}

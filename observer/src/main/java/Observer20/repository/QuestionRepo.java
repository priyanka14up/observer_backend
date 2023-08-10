
package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import Observer20.Model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{
	List<Question> findQuestionsBySubformSid(Long sid);
	 @Query("SELECT q.subform.sid FROM Question q WHERE q.qid = :qid")
	    Long findSubformSidByQid(@Param("qid") Long qid);
	 Question findByQid(Long qid);
}

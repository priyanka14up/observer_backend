//
//package Observer20.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Repository;
//
//import Observer20.Dto.QuestionRequest;
//import Observer20.Model.Form;
//import Observer20.Model.Question;
//import Observer20.Model.Question1;
//import Observer20.Model.SubForm;
//
//@Repository
//public interface QuestionRepo1 extends JpaRepository<Question1, Long>{
//	
//	//List<Question> findAllByfid(Long fid);
//	//List<Question> findByQid(Long qid);
//	//List<Question> findAllBySubform(Long sid);
//	List<Question1> findQuestionsBySubformSid(Long sid);
//	 Long findSubformSidByQid(Long qid);
////	 @Query("SELECT q FROM Question q JOIN q.subform s WHERE s.subformId = :subformId")
////	    List<Question> findQuestionsBySubformId(@Param("subform_Id") Long subform_Id);
//}

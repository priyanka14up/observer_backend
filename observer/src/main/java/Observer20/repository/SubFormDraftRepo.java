//
//package Observer20.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import Observer20.Model.SubForm;
//import Observer20.Model.SubFormDraft;
//
//@Repository
//public interface SubFormDraftRepo extends JpaRepository<SubFormDraft, Long>{
//	
//	
//	
//	List<SubForm> findSubFormsByFormId(Long id);
//	 @Query("SELECT s.form.id FROM SubForm s WHERE s.sid = :sid")
//	    Long findFormIdBySid(@Param("sid") Long sid);
//	
//	
//	
//}

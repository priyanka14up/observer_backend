package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.Answer;
import Observer20.Model.DraftAnswer;

public interface DraftAnswerRepo extends JpaRepository<DraftAnswer, Long>{
	DraftAnswer findByQid(Long qid);
	List<DraftAnswer> findAllBySid(Long sid);
	List<DraftAnswer> findAllByFid(Long fid);
	List<DraftAnswer> findAllBySubmittedBy(String submittedBy);
}

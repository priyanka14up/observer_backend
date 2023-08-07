package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;

public interface FinalSubmitAnswerRepo extends JpaRepository<FinalSubmitAnswer, Long>{
	List<FinalSubmitAnswer> findAllBySid(Long sid);
}

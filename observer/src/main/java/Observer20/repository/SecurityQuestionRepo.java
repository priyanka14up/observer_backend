package Observer20.repository;

import Observer20.Model.SecurityQuestion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityQuestionRepo extends JpaRepository<SecurityQuestion, Integer> {
	

	Optional<SecurityQuestion> findById(Integer questionId);
}

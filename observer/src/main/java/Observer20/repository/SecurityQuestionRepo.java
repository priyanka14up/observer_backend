package Observer20.repository;

import Observer20.Model.SecurityQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityQuestionRepo extends JpaRepository<SecurityQuestion, Long> {
}

package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.ObserverUser;
import Observer20.Model.SecurityQuestion;
import Observer20.Model.UserSecurityQuestion;


public interface UserSecurityQuestionRepo extends JpaRepository<UserSecurityQuestion, Long> {
    List<UserSecurityQuestion> findByObserveruserAndQuestion(ObserverUser observerUser, SecurityQuestion question);

	List<UserSecurityQuestion> findByObserveruser(ObserverUser observerUser);
}

package Observer20.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Model.ObserverUser;
import Observer20.Model.UserSecurityQuestion;
import Observer20.repository.UserSecurityQuestionRepo;

@Service
public class SecurityQuestionService {

    @Autowired
    private UserSecurityQuestionRepo userSecurityQuestionRepo;

    public boolean validateUserAnswers(ObserverUser observerUser, List<UserSecurityQuestion> userAnswers) {
        List<UserSecurityQuestion> userSecurityQuestions = userSecurityQuestionRepo.findByObserveruserAndQuestion(observerUser, userAnswers.get(0).getQuestion());

        for (UserSecurityQuestion userSecurityQuestion : userSecurityQuestions) {
            for (UserSecurityQuestion userAnswer : userAnswers) {
                if (userSecurityQuestion.getQuestion().getQ_id().equals(userAnswer.getQuestion().getQ_id())) {
                    if (userSecurityQuestion.getAnswer().equals(userAnswer.getAnswer())) {
                        return true; // Return true if any answer matches
                    }
                }
            }
        }
        return false; // Return false if no answer matches
    }
}
	
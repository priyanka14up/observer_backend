package Observer20.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Model.ObserverUser;
import Observer20.Model.UserSecurityQuestion;
import Observer20.Services.SecurityQuestionService;
import Observer20.repository.ObserverUserRepo;

@RestController
@RequestMapping("/api/observers")
public class SecurityQuestionController {

    @Autowired
    private SecurityQuestionService securityQuestionService;

    @Autowired
    private ObserverUserRepo observerUserRepo; // Inject the ObserverUserRepository

    @PostMapping("/{userId}/validate-answers")
    public boolean validateAnswers(@PathVariable Integer userId, @RequestBody List<UserSecurityQuestion> userAnswers) {
        // Fetch the observer user based on userId
        ObserverUser observerUser = observerUserRepo.findById(userId).orElse(null);
        
        if (observerUser == null) {
            // Handle the case where ObserverUser is not found based on userId
            // You can return an error, throw an exception, or handle it as per your requirements.
            return false;
        }
     // Validate the user's answers
        return securityQuestionService.validateUserAnswers(observerUser, userAnswers);
    }
}



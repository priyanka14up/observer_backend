package Observer20.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Model.ObserverUser;
import Observer20.Model.SecurityQuestion;
import Observer20.Model.UserSecurityQuestion;
import Observer20.Model.UserSecurityQuestionRequest;
import Observer20.Services.SecurityQuestionService;
import Observer20.repository.ObserverUserRepo;
import Observer20.repository.SecurityQuestionRepo;
import Observer20.repository.UserSecurityQuestionRepo;

@RestController
@RequestMapping("/api/observers")
public class SecurityQuestionController {

    @Autowired
    private SecurityQuestionService securityQuestionService;

    @Autowired
    private ObserverUserRepo observerUserRepo;
    @Autowired
    SecurityQuestionRepo securityQuestionRepo;
    @Autowired
    UserSecurityQuestionRepo userSecurityQuestionRepo;
    
    @PostMapping("/{obscode}/add-answer")
    public ResponseEntity<String> addAnswer(@PathVariable String obscode, @RequestBody UserSecurityQuestionRequest request) {
        // Fetch the observer user based on userId
        ObserverUser observerUser = observerUserRepo.findByObscode(obscode);

        if (observerUser == null) {
            // Handle the case where ObserverUser is not found based on userId
            // You can return an error, throw an exception, or handle it as per your requirements.
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
         // Fetch the security question based on questionId
            SecurityQuestion question = securityQuestionRepo.findById(request.getQuestionId()).orElse(null);

            if (question == null) {
                // Handle the case where SecurityQuestion is not found based on questionId
                // You can return an error, throw an exception, or handle it as per your requirements.
                return new ResponseEntity<>("Security question not found", HttpStatus.NOT_FOUND);
            }

            // Create a new UserSecurityQuestion object and set its properties
            UserSecurityQuestion userSecurityQuestion = new UserSecurityQuestion();
            userSecurityQuestion.setObserveruser(observerUser);
            userSecurityQuestion.setQuestion(question);
            userSecurityQuestion.setAnswer(request.getAnswer());

            // Save the UserSecurityQuestion to the database
            userSecurityQuestionRepo.save(userSecurityQuestion);
            return new ResponseEntity<>("Answer added successfully", HttpStatus.OK);
        }
    


    @PostMapping("/{obscode}/validate-answers")
    public boolean validateAnswers(@PathVariable String obscode, @RequestBody List<UserSecurityQuestion> userAnswers) {
        // Fetch the observer user based on userId
        ObserverUser observerUser = observerUserRepo.findByObscode(obscode);
        
        if (observerUser == null) {
            // Handle the case where ObserverUser is not found based on userId
            // You can return an error, throw an exception, or handle it as per your requirements.
            return false;
        }
     // Validate the user's answers
        return securityQuestionService.validateUserAnswers(observerUser, userAnswers);
    }
    
}



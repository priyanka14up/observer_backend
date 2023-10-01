package Observer20.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Exception.ApiException;
import Observer20.Model.ChangePasswordRequest;
import Observer20.Model.ObserverLocalInfo;
import Observer20.Model.ObserverLocalInfoRequest;
import Observer20.Model.ObserverUser;
import Observer20.Response.ApiResponse;
import Observer20.Services.ObserverService;
import Observer20.payloads.ChangeProfileStatusRequest;
import Observer20.payloads.LoginProfileStatusResponse;
import Observer20.payloads.LoginRequest;
import Observer20.payloads.ObserverUserDto;
import Observer20.payloads.ObserverUserDtoUpdation;
import Observer20.repository.ObserverLocalInfoRepository;
import Observer20.repository.ObserverUserRepo;




@RestController
@CrossOrigin
@RequestMapping("/api/observers")
public class ObserverUserController {
	
	
		@Autowired
		private ObserverService observerService;
		//private ObserverUserDtoUpdation ObserverUserDtoUpdation;
		@Autowired
	    private ObserverLocalInfoRepository observerLocalInfoRepository;
		@Autowired
		private ObserverUserRepo observerUserRepo;
		
	    

		@PostMapping("/profilelogin")
		public LoginProfileStatusResponse login(@RequestBody LoginRequest loginRequest, HttpSession session) {
		    // Fetch the user based on the provided obscode
		    ObserverUser observerUser = observerUserRepo.getObserverUserByobscode(loginRequest.getObscode());

		    LoginProfileStatusResponse response = new LoginProfileStatusResponse();

		    if (observerUser == null) {
		        response.setProfileStatus(true);
		        return response;
		    }

		    String storedMd5Password = observerUser.getPassword();
		    String oldPasswordMd5 = DigestUtils.md5DigestAsHex(loginRequest.getPassword().getBytes());

		    if (!storedMd5Password.equals(oldPasswordMd5)) {
		        // Invalid credentials, throw custom exception
		    	throw new ApiException("Invalid username or password");
		    } else {
		        response.setProfileStatus(observerUser.getProfileStatus());
		        
		        // Convert Long to String, then extract the last 3 digits
		        String fullMobileNumber = String.valueOf(observerUser.getMobnum());
		        int length = fullMobileNumber.length();
		        String last3Digits = length <= 3 ? fullMobileNumber : fullMobileNumber.substring(length - 3);

		        // Convert back to Long and set in the response object
		        response.setMobnum(Long.parseLong(last3Digits));
		        
		        response.setEmail(observerUser.getEmail());
		        return response;
		    }
		}



		@PutMapping("/change-profile-status")
		public String changeProfileStatus(@RequestBody ChangeProfileStatusRequest request) {
		    // Fetch the user based on the provided obscode
		    ObserverUser observerUser = observerUserRepo.getObserverUserByobscode(request.getObscode());

		    if (observerUser == null) {
		        return "User does not exist.";
		    }

		    // Update the profile status
		    observerUser.setProfileStatus(request.getNewProfileStatus());
		    observerUserRepo.save(observerUser);

		    return "Profile status changed successfully.";
		}

		
		//POST -create user
		@PreAuthorize("hasRole('ADMIN')")
		@PostMapping("/save")
		public ResponseEntity<ObserverUserDto> createUser(@Valid @RequestBody ObserverUserDto observerUserDto)
		{
			ObserverUserDto createUserDto= observerService.createObserver(observerUserDto);
			return new ResponseEntity<>(createUserDto ,HttpStatus.CREATED);
			
		}
			
		
		//get all
		@GetMapping("/")
		public ResponseEntity<List<ObserverUserDto>> getAllUsers()
		{
			
			return  ResponseEntity.ok(observerService.getAllUsers());
			
		}
		//get by one
		@GetMapping("/{ObsCode}")
		public ResponseEntity<ObserverUserDto> getSingleObserverUser(@PathVariable String ObsCode)
		{
			return ResponseEntity.ok(observerService.getObserverUserById(ObsCode));
			
		}
		// delete
		@PreAuthorize("hasRole('ADMIN')")
		@DeleteMapping("/{obscode}")
		public ResponseEntity<ApiResponse> deleteObserverUser(@PathVariable String obscode)
		{
			
			return ResponseEntity.ok(observerService.deleteObserverUser(obscode));
		
		}
		
		
		@PutMapping("/{ObsCode}")
		public ResponseEntity<ObserverUserDto> updateUser(
		        @Valid @RequestBody ObserverUserDtoUpdation observerUserDtoUpdation,
		        @PathVariable String ObsCode) {
		    
		    ObserverUserDto updatedUser = observerService.updateObserverUser(observerUserDtoUpdation, ObsCode);
		    return ResponseEntity.ok(updatedUser);
		}
		
		
		
	
	
}



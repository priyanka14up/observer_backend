package Observer20.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Services.ObserverService;
import Observer20.payloads.ApiResponse;
import Observer20.payloads.LoginDto;
import Observer20.payloads.ObserverUserDto;



@RestController
@CrossOrigin
@RequestMapping("/api/observers")
public class ObserverUserController {
	
	
		@Autowired
		private ObserverService observerService;
		
		//POST -create user

		@PostMapping("/save")
		public ResponseEntity<ObserverUserDto> createUser(@Valid @RequestBody ObserverUserDto observerUserDto)
		{
			ObserverUserDto createUserDto= observerService.createObserver(observerUserDto);
			return new ResponseEntity<>(createUserDto ,HttpStatus.CREATED);
			
		}
			
		//login user
		@PostMapping("/login")
		public ResponseEntity<?> loginObserver(@RequestBody LoginDto  loginDto)
		{
			ApiResponse apiResponse=observerService.loginObserver(loginDto);
			return ResponseEntity.ok(apiResponse);
			
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
		@DeleteMapping("/{obscode}")
		public ResponseEntity<ApiResponse> deleteObserverUser(@PathVariable String obscode)
		{
			
			return ResponseEntity.ok(observerService.deleteObserverUser(obscode));
		
		}
		
		
		
		
		
		
	
	
}



package Observer20.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import Observer20.Response.ApiResponse;
import Observer20.Services.ObserverService;


import Observer20.payloads.ObserverUserDto;
import Observer20.payloads.ObserverUserDtoUpdation;




@RestController
@CrossOrigin
@RequestMapping("/api/observers")
public class ObserverUserController {
	
	
		@Autowired
		private ObserverService observerService;
		private ObserverUserDtoUpdation ObserverUserDtoUpdation;
		
		//POST -create user

		@PostMapping("/save")
		public ResponseEntity<ObserverUserDto> createUser(@Valid @RequestBody ObserverUserDto observerUserDto)
		{
			ObserverUserDto createUserDto= observerService.createObserver(observerUserDto);
			return new ResponseEntity<>(createUserDto ,HttpStatus.CREATED);
			
		}
			
		//login user
	/*
	 * @PostMapping("/login") public ResponseEntity<?> loginObserver(@RequestBody
	 * LoginDto loginDto) { ApiResponse
	 * apiResponse=observerService.loginObserver(loginDto); return
	 * ResponseEntity.ok(apiResponse);
	 * 
	 * }
	 */
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
		//@PreAuthorize("hasRole('ADMIN')")
		@DeleteMapping("/{obscode}")
		public ResponseEntity<ApiResponse> deleteObserverUser(@PathVariable String obscode)
		{
			
			return ResponseEntity.ok(observerService.deleteObserverUser(obscode));
		
		}
		//Put-update- user
		/*
		 * @PutMapping("/{ObsCode}") public ResponseEntity<ObserverUserDto> updateUser(
		 * 
		 * @Valid @RequestBody ObserverUserDto observerUserDto,
		 * 
		 * @PathVariable String ObsCode) {
		 * 
		 * ObserverUserDto updatedUser =
		 * observerService.updateObserverUser(ObserverUserDtoUpdation, ObsCode); return
		 * ResponseEntity.ok(updatedUser); }
		 */
		
		
		
		
		
		@PutMapping("/{ObsCode}")
		public ResponseEntity<ObserverUserDto> updateUser(
		        @Valid @RequestBody ObserverUserDtoUpdation observerUserDtoUpdation,
		        @PathVariable String ObsCode) {
		    
		    ObserverUserDto updatedUser = observerService.updateObserverUser(observerUserDtoUpdation, ObsCode);
		    return ResponseEntity.ok(updatedUser);
		}
	
	
}



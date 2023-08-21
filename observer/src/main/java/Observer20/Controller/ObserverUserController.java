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

import Observer20.Model.ObserverLocalInfo;
import Observer20.Model.ObserverLocalInfoRequest;
import Observer20.Model.ObserverUser;
import Observer20.Response.ApiResponse;
import Observer20.Services.ObserverService;


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
		
		//POST -create user

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
		//@PreAuthorize("hasRole('ADMIN')")
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
		
		
		
		/*
		 * @PostMapping("/update-local-info") public ResponseEntity<String>
		 * updateLocalInfo(@RequestBody ObserverLocalInfoRequest request) {
		 * ObserverLocalInfo localInfo = new ObserverLocalInfo(); ObserverUser
		 * observerUser = observerUserRepo.findByObscode(request.getObscode());
		 * 
		 * if (observerUser == null) { return
		 * ResponseEntity.status(HttpStatus.NOT_FOUND).body("Observer not found"); }
		 * 
		 * localInfo.setObserverUser(observerUser);
		 * localInfo.setLocalAddress(request.getLocalAddress());
		 * localInfo.setLocalMobile(request.getLocalMobile());
		 * observerLocalInfoRepository.save(localInfo);
		 * 
		 * // Link local info to the observer user observerUser.addLocalInfo(localInfo);
		 * observerUserRepo.save(observerUser); return
		 * ResponseEntity.ok("Local info updated successfully"); }
		 */
	
	
}



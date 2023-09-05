package Observer20.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import Observer20.Services.ObserverLocalInfoService;
import Observer20.Services.ObserverService;
import Observer20.payloads.ObserverLocalInfoDTO;
import Observer20.payloads.ObserverUserDto;
import Observer20.payloads.ObserverUserDtoUpdation;

@RestController
@RequestMapping("/api/observers/auth")
public class ObserverLocalInfoController {


@Autowired
private  ObserverService observerService;
@Autowired
ObserverLocalInfoService observerLocalInfoService;

	

    @PostMapping("/add-local-info")
    public ResponseEntity<String> addLocalInfo(@Valid @RequestBody ObserverLocalInfoRequest localInfoRequest) {
        
    	String obsCode = localInfoRequest.getObscode();
        String localAddress = localInfoRequest.getLocalAddress();
        String localMobileNumber = localInfoRequest.getLocalMobile();

       
        ApiResponse observerUserDto = observerLocalInfoService.addLocalInfo(obsCode, localAddress, localMobileNumber);

        return ResponseEntity.ok("Local information added successfully for obscode: " + obsCode);
    
    }
  //get by one
  		@GetMapping("/{ObsCode}")
  		public ResponseEntity<ObserverLocalInfoDTO> getSingleObserverUser(@PathVariable String ObsCode)
  		{
  			return ResponseEntity.ok(observerLocalInfoService.getObserverLocalInfoByObscode(ObsCode));
  			
  		}
  		@PutMapping("/{ObsCode}")
		public ResponseEntity<ObserverLocalInfoDTO> updateUser(
				@Valid  @RequestBody ObserverLocalInfoDTO observerLocalInfoDTO,
		        @PathVariable String ObsCode) {
		    
  			ObserverLocalInfoDTO updatedObserverLocalInfo = observerLocalInfoService.updateObserverLocalInfo(observerLocalInfoDTO, ObsCode);
		    return ResponseEntity.ok(updatedObserverLocalInfo);
		}
  		
}



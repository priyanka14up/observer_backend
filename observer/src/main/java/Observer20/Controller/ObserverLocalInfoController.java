package Observer20.Controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Exception.ApiException;
import Observer20.Model.Obs_Allot;
import Observer20.Model.ObserverLocalInfo;
import Observer20.Model.ObserverLocalInfoRequest;
import Observer20.Model.ObserverUser;
import Observer20.Response.ApiResponse;
import Observer20.Response.DistrictStateResponse;
import Observer20.Services.ObserverLocalInfoService;
import Observer20.Services.ObserverService;
import Observer20.Services.T_Allot_Group_Servcie;
import Observer20.payloads.ACRequest;
import Observer20.payloads.MElectionDetailsDataDTO;
import Observer20.payloads.ObsAllotDTO;
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
@Autowired
T_Allot_Group_Servcie t_Allot_Group_Servcie;

	

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
  		public ResponseEntity<List<ObserverLocalInfoDTO>> getSingleObserverUser(@PathVariable String ObsCode)
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
  		//@PreAuthorize("hasRole('ADMIN')")
  		@GetMapping("/allot/{ObsCode}")
  		public ResponseEntity<List<Obs_Allot>> getSingleObsAllot(@PathVariable String ObsCode)
  		{
  			return ResponseEntity.ok(t_Allot_Group_Servcie.getObsAllotByObscode(ObsCode));
  			
  		}
  		
  	
		
		  @GetMapping("/electionDetails/{obsCode}") public MElectionDetailsDataDTO
		  getElectionData(@PathVariable String obsCode) { return
		  t_Allot_Group_Servcie.getElectionData(obsCode); }
		  
		  @PostMapping("/get-district-state")
		  public ResponseEntity<DistrictStateResponse> getDistrictAndStateNames(@RequestBody ACRequest acRequest) {
		      try {
		          Map<String, String> result = t_Allot_Group_Servcie.getDistrictAndStateNames(acRequest.getObsCode(), acRequest.getAcNameEn());
		          String stateName = result.get("stateName");
		          String districtName = result.get("districtName");
		          String stateCode = result.get("stateCode");
		          String districtCode = result.get("distNoHdqt"); // Assuming distNoHdqt is the district code

		          DistrictStateResponse response = new DistrictStateResponse();
		          response.setStateName(stateName);
		          response.setDistrictName(districtName);
		          response.setStateCode(stateCode);
		          response.setDistrictCode(districtCode);

		          return ResponseEntity.ok(response);
		      } catch (Exception e) {
		          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		      }
		  }
		  @GetMapping("DeployStatus/{obsCode}")
		    public ResponseEntity<List<ObsAllotDTO>> getObsAllotByObscode1(@PathVariable String obsCode) {
		       
		            List<ObsAllotDTO> obsAllotList = t_Allot_Group_Servcie.getObsAllotByObscode1(obsCode);
		            return ResponseEntity.ok(obsAllotList);
		        }
		  
}
		



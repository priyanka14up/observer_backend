package Observer20.Services.ServiceIMPL;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import Observer20.Exception.ApiException;
import Observer20.Model.ObserverLocalInfo;
import Observer20.Model.ObserverUser;
import Observer20.Response.ApiResponse;
import Observer20.Services.ObserverLocalInfoService;
import Observer20.payloads.ObserverLocalInfoDTO;
import Observer20.payloads.ObserverUserDto;
import Observer20.payloads.ObserverUserDtoUpdation;
import Observer20.repository.ObserverLocalInfoRepository;
import Observer20.repository.ObserverUserRepo;

@Service
public class ObserverLocalInfoServiceIMPL implements ObserverLocalInfoService{
	@Autowired
	ObserverUserRepo observerUserRepo;
	@Autowired
    ObserverLocalInfoRepository observerLocalInfoRepository;
	
// Add Local information of Observer
	@Override
	public ApiResponse addLocalInfo(String obsCode, String localAddress, String localMobileNumber) {
	    ObserverUser observerUser = observerUserRepo.findByObscode(obsCode);
	    String message;
	    boolean success;

	    if (observerUser != null ) {
	    	
	    	Optional<ObserverLocalInfo> existingLocalInfoOptional=observerLocalInfoRepository.findByObserverUserObscode(obsCode);
	    	if (existingLocalInfoOptional.isPresent()) {
	    		 
	    		 throw new ApiException("Observer with obscode " + obsCode + " is already exist.");
	    	}
	    	else {
	        ObserverLocalInfo localInfo = new ObserverLocalInfo();
	        localInfo.setObserverUser(observerUser);
	        localInfo.setLocalAddress(localAddress);
			 localInfo.setLocalMobile(localMobileNumber);
	        
			
	       
	            observerLocalInfoRepository.save(localInfo);
	            
	        
	       //return userToApiResponse(observerUser); 
	       return new ApiResponse(message = "Localinfo Added ...", success = true);
	    } }else {
	        throw new ApiException("Observer with obscode " + obsCode + " not found.");
	    }
		

	}
	private ObserverLocalInfo dtoToUser(ObserverLocalInfoDTO observerLocalInfoDTO) {

		ObserverLocalInfo observerLocalInfo = new ObserverLocalInfo();

		observerLocalInfo.setId(observerLocalInfoDTO.getId());
		observerLocalInfo.setLocalAddress(observerLocalInfoDTO.getLocalAddress());
		observerLocalInfo.setLocalMobile(observerLocalInfoDTO.getLocalMobile());
		
		return observerLocalInfo;
	}
	public ObserverLocalInfoDTO userToDto(ObserverLocalInfo observerLocalInfo) {

		ObserverLocalInfoDTO observerLocalInfoDTO = new ObserverLocalInfoDTO();
		observerLocalInfoDTO.setId(observerLocalInfo.getId());
		observerLocalInfoDTO.setLocalAddress(observerLocalInfo.getLocalAddress());
		observerLocalInfoDTO.setLocalMobile(observerLocalInfo.getLocalMobile());
		

		return observerLocalInfoDTO;
	}
	

// get Local Information of Observer by Obscode
	@Override
	public ObserverLocalInfoDTO getObserverLocalInfoByObscode(String obsCode) {
		ObserverLocalInfo observerLocalInfo=observerLocalInfoRepository.findByObserverUser_Obscode(obsCode);
		
		if (observerLocalInfo != null)

		{
			return userToDto(observerLocalInfo);
			
		}
		else {

			//return new ApiResponse(message = "User does not exist", status = false);
			  throw new ApiException("usercode does not exist") ; }

		}
	@Override
	public ObserverLocalInfoDTO updateObserverLocalInfo(ObserverLocalInfoDTO observerLocalInfoDTO, String obsCode) {
		ObserverLocalInfo observerLocalInfo=observerLocalInfoRepository.findByObserverUser_Obscode(obsCode);
		if (observerLocalInfo != null)
		{
			//ObserverLocalInfo.setId(observerLocalInfoDTO.getId());
			
			observerLocalInfo.setLocalAddress(observerLocalInfoDTO.getLocalAddress());
			    observerLocalInfo.setLocalMobile(observerLocalInfoDTO.getLocalMobile());
			    ObserverLocalInfo updateLocalInfo=observerLocalInfoRepository.save(observerLocalInfo);
			    ObserverLocalInfoDTO observerLocalInfoDTO1 = userToDto(updateLocalInfo);
			    return observerLocalInfoDTO1;
		}else
		{
			throw new ApiException("usercode does not exist");}
		}
		
	
	
		
	}

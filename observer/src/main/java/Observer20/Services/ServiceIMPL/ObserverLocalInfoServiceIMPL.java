package Observer20.Services.ServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import Observer20.Exception.ApiException;
import Observer20.Model.AC_LIST2;
import Observer20.Model.ObserverLocalInfo;
import Observer20.Model.ObserverLocalInfoRequest;
import Observer20.Model.ObserverUser;
import Observer20.Model.STATE_LIST2;
import Observer20.Response.ApiResponse;
import Observer20.Services.ObserverLocalInfoService;
import Observer20.payloads.ObserverLocalInfoDTO;
import Observer20.payloads.ObserverUserDto;
import Observer20.payloads.ObserverUserDtoUpdation;
import Observer20.repository.AC_LIST2_REPO2;
import Observer20.repository.ObserverLocalInfoRepository;
import Observer20.repository.ObserverUserRepo;
import Observer20.repository.STATE_LIST2_Repo;

@Service
public class ObserverLocalInfoServiceIMPL implements ObserverLocalInfoService {
	@Autowired
	ObserverUserRepo observerUserRepo;
	@Autowired
	ObserverLocalInfoRepository observerLocalInfoRepository;
	@Autowired
	STATE_LIST2_Repo sTATE_LIST2_Repo;
	@Autowired
	AC_LIST2_REPO2 aC_LIST2_REPO2;

	
	  @Override public ApiResponse addLocalInfo(String obsCode, String
	  localAddress, String localMobileNumber)
	  
	  { ObserverUser observerUser =observerUserRepo.findByObscode(obsCode);
	  
	  String message; boolean success;
	  
	  
	  if (observerUser != null ) {
	  
	  
	  Optional<ObserverLocalInfo>
	  existingLocalInfoOptional=observerLocalInfoRepository.
	  findOneByObserverUser_Obscode(obsCode);
	  if(existingLocalInfoOptional.isPresent()) {
	  
	  throw new ApiException("Observer with obscode " + obsCode
	  +" is already exist."); } else { ObserverLocalInfo localInfo = new
	  ObserverLocalInfo(); localInfo.setObserverUser(observerUser);
	  localInfo.setLocalAddress(localAddress);
	  localInfo.setLocalMobile(localMobileNumber);
	  
	  
	  
	  observerLocalInfoRepository.save(localInfo);
	  
	  
	  
	  //return userToApiResponse(observerUser);
	  
	  return new ApiResponse(message ="Localinfo Added ...", success = true); }}
	  else { throw new ApiException("Observer with obscode " + obsCode +
	  " not found."); }
	  
	  
	  }
	 

	
	/*
	 * @Override public ApiResponse addLocalInfo(String obsCode, String
	 * localAddress, String localMobileNumber) { Optional<ObserverLocalInfo>
	 * existingLocalInfoOptional =
	 * observerLocalInfoRepository.findOneByObserverUser_Obscode(obsCode); String
	 * message; boolean success;
	 * 
	 * if (existingLocalInfoOptional.isPresent()) { ObserverLocalInfo localInfo =
	 * existingLocalInfoOptional.get(); localInfo.setLocalAddress(localAddress);
	 * localInfo.setLocalMobile(localMobileNumber);
	 * 
	 * observerLocalInfoRepository.save(localInfo);
	 * 
	 * return new ApiResponse(message = "Localinfo Updated ...", success = true); }
	 * else { throw new ApiException("Observer with obscode " + obsCode +
	 * " not found."); } }
	 */
	 

	private ObserverLocalInfo dtoToUser(ObserverLocalInfoDTO observerLocalInfoDTO) {

		ObserverLocalInfo observerLocalInfo = new ObserverLocalInfo();

		observerLocalInfo.setId(observerLocalInfoDTO.getId());
		observerLocalInfo.setLocalAddress(observerLocalInfoDTO.getLocalAddress());
		observerLocalInfo.setLocalMobile(observerLocalInfoDTO.getLocalMobile());
		//observerLocalInfo.setOb_From_Date(observerLocalInfoDTO.getOb_From_Date());
		//observerLocalInfo.setOb_To_Date(observerLocalInfoDTO.getOb_To_Date());
		

		return observerLocalInfo;
	}

	public ObserverLocalInfoDTO userToDto(ObserverLocalInfo observerLocalInfo) {

		ObserverLocalInfoDTO observerLocalInfoDTO = new ObserverLocalInfoDTO();
		observerLocalInfoDTO.setId(observerLocalInfo.getId());
		observerLocalInfoDTO.setLocalAddress(observerLocalInfo.getLocalAddress());
		observerLocalInfoDTO.setLocalMobile(observerLocalInfo.getLocalMobile());
		//observerLocalInfoDTO.setOb_From_Date(observerLocalInfo.getOb_From_Date());
		//observerLocalInfoDTO.setOb_To_Date(observerLocalInfo.getOb_To_Date());
		

		return observerLocalInfoDTO;
	}

// get Local Information of Observer by Obscode
	@Override
	public List<ObserverLocalInfoDTO> getObserverLocalInfoByObscode(String obsCode) {
	    List<ObserverLocalInfo> observerLocalInfoList = observerLocalInfoRepository
	            .findAllByObserverUser_Obscode(obsCode);
	    if (observerLocalInfoList != null && !observerLocalInfoList.isEmpty()) {
	        List<ObserverLocalInfoDTO> observerLocalInfoDTOList = new ArrayList<>();
	        for (ObserverLocalInfo observerLocalInfo : observerLocalInfoList) {
	            ObserverLocalInfoDTO observerLocalInfoDTO = new ObserverLocalInfoDTO();
	            observerLocalInfoDTO.setId(observerLocalInfo.getId());
	            observerLocalInfoDTO.setLocalAddress(observerLocalInfo.getLocalAddress());
	            observerLocalInfoDTO.setLocalMobile(observerLocalInfo.getLocalMobile());
	            observerLocalInfoDTOList.add(observerLocalInfoDTO);
	        }
	        return observerLocalInfoDTOList;
	    } else {
	        throw new ApiException("Observer with obscode " + obsCode + " not found.");
	    }
	}

	@Override
	public ObserverLocalInfoDTO updateObserverLocalInfo(ObserverLocalInfoDTO observerLocalInfoDTO, String obsCode) {
		ObserverLocalInfo observerLocalInfo = observerLocalInfoRepository.findByObserverUser_Obscode(obsCode);
		if (observerLocalInfo != null) {
			// ObserverLocalInfo.setId(observerLocalInfoDTO.getId());

			observerLocalInfo.setLocalAddress(observerLocalInfoDTO.getLocalAddress());
			observerLocalInfo.setLocalMobile(observerLocalInfoDTO.getLocalMobile());
			ObserverLocalInfo updateLocalInfo = observerLocalInfoRepository.save(observerLocalInfo);
			ObserverLocalInfoDTO observerLocalInfoDTO1 = userToDto(updateLocalInfo);
			return observerLocalInfoDTO1;
		} else {
			throw new ApiException("usercode does not exist");
		}
	}

}

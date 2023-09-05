package Observer20.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import Observer20.Model.ObserverLocalInfo;
import Observer20.Response.ApiResponse;
import Observer20.payloads.ObserverLocalInfoDTO;
import Observer20.payloads.ObserverUserDto;
import Observer20.payloads.ObserverUserDtoUpdation;
import Observer20.repository.ObserverLocalInfoRepository;


public interface ObserverLocalInfoService {

	ApiResponse addLocalInfo(String obsCode, String localAddress, String localMobileNumber);
	//ObserverUserDto getObserverUserById(String obsCode);
	ObserverLocalInfoDTO getObserverLocalInfoByObscode(String obsCode);
	//ObserverUserDto updateObserverUser(ObserverUserDtoUpdation user, String obsCode);
	ObserverLocalInfoDTO updateObserverLocalInfo(ObserverLocalInfoDTO user, String obsCode);

}

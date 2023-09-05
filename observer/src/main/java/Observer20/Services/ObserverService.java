package Observer20.Services;


import java.util.List;

import Observer20.Model.ObserverUser;
import Observer20.Response.ApiResponse;

import Observer20.payloads.ObserverUserDto;
import Observer20.payloads.ObserverUserDtoUpdation;


public interface ObserverService {

	ObserverUserDto createObserver(ObserverUserDto user);
	
	List<ObserverUserDto> getAllUsers();
	
	ObserverUserDto getObserverUserById(String obsCode);
	
	//ObserverUserDto updateObserverUser(ObserverUserDto user,String obscode)	;
	
	ApiResponse deleteObserverUser(String obscode);

	ObserverUserDto updateObserverUser(ObserverUserDtoUpdation user, String obsCode);
	

	
	
	

	
		
	
	
	
}

package Observer20.Services;


import java.util.List;

import Observer20.payloads.ApiResponse;
import Observer20.payloads.LoginDto;
import Observer20.payloads.ObserverUserDto;


public interface ObserverService {

	ObserverUserDto createObserver(ObserverUserDto user);

	//ApiResponse loginObserver(LoginDto loginDto) ;
	
	List<ObserverUserDto> getAllUsers();
	
	ObserverUserDto getObserverUserById(String obsCode);
	
	ObserverUserDto updateObserverUserById(ObserverUserDto user,String obscode)	;
	
	ApiResponse deleteObserverUser(String obscode);
	
	

	
		
	
	
	
}

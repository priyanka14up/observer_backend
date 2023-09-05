package Observer20.Services.ServiceIMPL;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Validation;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import Observer20.Exception.ApiException;
import Observer20.Model.ObserverLocalInfo;
import Observer20.Model.ObserverUser;
import Observer20.Response.ApiResponse;
import Observer20.Security.CustomUserDetailsService;
import Observer20.Security.JwtTokenHelper;
import Observer20.Services.ObserverService;
import Observer20.payloads.ObserverUserDto;
import Observer20.payloads.ObserverUserDtoUpdation;
import Observer20.repository.ObserverUserRepo;

@Service
public class ObserverServiceIMPL implements ObserverService {
	@Autowired
	private ObserverUserRepo observerUserRepo;
	@Autowired
	JwtTokenHelper jwtTokenHelper;
	
	 @Autowired private CustomUserDetailsService userDetailsService;
	 @Autowired
	  Observer20.repository.ObserverLocalInfoRepository observerLocalInfoRepository;
	

	@Override
// add observer
	public ObserverUserDto createObserver(ObserverUserDto observerUserDto) {

		ObserverUser observerUser = dtoToUser(observerUserDto);
		ObserverUser SavedObserverUser = observerUserRepo.save(observerUser);
		return userToDto(SavedObserverUser);
	}

	
	@Override// get all observer
	public List<ObserverUserDto> getAllUsers() {
		List<ObserverUser> observerusers = observerUserRepo.findAll();
		List<ObserverUserDto> observeruserDtos = observerusers.stream().map(user -> userToDto(user))
				.collect(Collectors.toList());

		return observeruserDtos;
	}

	private ObserverUser dtoToUser(ObserverUserDto observerUserDto) {

		ObserverUser observerUser = new ObserverUser();

		observerUser.setId(observerUserDto.getId());
		observerUser.setObscode(observerUserDto.getObscode());
		observerUser.setName(observerUserDto.getName());
		observerUser.setEmail(observerUserDto.getEmail());
		observerUser.setHomeState(observerUserDto.getHomeState());
		observerUser.setMobnum(observerUserDto.getMobnum());
		observerUser.setService(observerUserDto.getService());
		observerUser.setWorkexperience(observerUserDto.getWorkexperience());
		observerUser.setRole(observerUserDto.getRole());
		// observerUser.setPassword(passwordEncoder.encode(observerUserDto.getPassword()));
		observerUser.setPassword(DigestUtils.md5DigestAsHex(observerUserDto.getPassword().getBytes()));

		return observerUser;
	}

	public ObserverUserDto userToDto(ObserverUser observerUser) {

		ObserverUserDto observerUserDto = new ObserverUserDto();
		observerUserDto.setId(observerUser.getId());
		observerUserDto.setEmail(observerUser.getEmail());
		observerUserDto.setObscode(observerUser.getObscode());
		observerUserDto.setName(observerUser.getName());
		observerUserDto.setHomeState(observerUser.getHomeState());
		observerUserDto.setMobnum(observerUser.getMobnum());
		observerUserDto.setService(observerUser.getService());
		observerUserDto.setWorkexperience(observerUser.getWorkexperience());
		observerUserDto.setRole(observerUser.getRole());
		// observerUserDto.setPassword(passwordEncoder.encode(observerUser.getPassword()));
		observerUserDto.setPassword(DigestUtils.md5DigestAsHex(observerUser.getPassword().getBytes()));

		return observerUserDto;
	}

	
	

	
	

	  @Override //get one observer by id
	  public ObserverUserDto getObserverUserById(String obsCode) {
	  ObserverUser observerUser = observerUserRepo.findByObscode(obsCode);
	  
	  //return userToDto(observerUser); 
	  //String message;
		//boolean status;
		if (observerUser != null)

		{
			return userToDto(observerUser);
			//return new ApiResponse(message = "User deleted Successfully ...", status = true);
		} else {

			//return new ApiResponse(message = "User does not exist", status = false);
			  throw new ApiException("usercode does not exist") ; }

		}
	 
	 
	

	@Override// update observer by id
	public ObserverUserDto updateObserverUser(ObserverUserDtoUpdation observerUserDtoUpdation, String obsCode) {
		
		ObserverUser observerUser = observerUserRepo.findByObscode(obsCode);
		if (observerUser != null) {
		    // Update specific fields
		    observerUser.setName(observerUserDtoUpdation.getName());
		    observerUser.setEmail(observerUserDtoUpdation.getEmail());
		    observerUser.setHomeState(observerUserDtoUpdation.getHomeState());
		    observerUser.setMobnum(observerUserDtoUpdation.getMobnum());
		    observerUser.setService(observerUserDtoUpdation.getService());
		    observerUser.setWorkexperience(observerUserDtoUpdation.getWorkexperience());

		    // Save the updated entity back to the database
		    ObserverUser updatedUser = observerUserRepo.save(observerUser);
		    // Return the updated user as DTO
		    ObserverUserDto observerUserDto1 = userToDto(updatedUser);
		    return observerUserDto1;
		} else {
		    throw new ApiException("usercode does not exist");}
		}
		
	

	@Override// delete observer
	public ApiResponse deleteObserverUser(String obscode) {

		ObserverUser observerUser = observerUserRepo.findByObscode(obscode);
		String message;
		boolean status;
		if (observerUser != null)

		{
			observerUserRepo.delete(observerUser);
			return new ApiResponse(message = "User deleted Successfully ...", status = true);
		} else {

			return new ApiResponse(message = "User does not exist", status = false);

		}

	}



	
	


	
	}


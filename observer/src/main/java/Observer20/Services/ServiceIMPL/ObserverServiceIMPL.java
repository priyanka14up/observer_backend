package Observer20.Services.ServiceIMPL;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import Observer20.Exception.ApiException;
import Observer20.Model.ObserverUser;
import Observer20.Response.ApiResponse;
import Observer20.Security.CustomUserDetailsService;
import Observer20.Security.JwtTokenHelper;
import Observer20.Services.ObserverService;
import Observer20.payloads.ObserverUserDto;
import Observer20.repository.ObserverUserRepo;

@Service
public class ObserverServiceIMPL implements ObserverService {
	@Autowired
	private ObserverUserRepo observerUserRepo;
	@Autowired
	JwtTokenHelper jwtTokenHelper;
	
	 @Autowired private CustomUserDetailsService userDetailsService;
	

	@Override

	public ObserverUserDto createObserver(ObserverUserDto observerUserDto) {

		ObserverUser observerUser = dtoToUser(observerUserDto);
		ObserverUser SavedObserverUser = observerUserRepo.save(observerUser);
		return userToDto(SavedObserverUser);
	}

	
	@Override
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

	
	/*
	 * @Override public ApiResponse1 loginObserver(JwtAuthRequest jwtAuthRequest) {
	 * 
	 * 
	 * 
	 * ObserverUser
	 * observerUser1=observerUserRepo.findByObscode(jwtAuthRequest.getObscode()); //
	 * UserDetails userDetails =
	 * userDetailsService.loadUserByUsername(jwtAuthRequest.getObscode());
	 * 
	 * 
	 * String message; boolean status; String token; if(observerUser1!=null) {
	 * 
	 * String
	 * password=DigestUtils.md5DigestAsHex(jwtAuthRequest.getPassword().getBytes());
	 * String encodedPassword=observerUser1.getPassword(); // Boolean //
	 * //isPwdRight=passwordEncoder.matches(password,encodedPassword); Boolean
	 * isPwdRight = password.equals(encodedPassword);
	 * //System.out.println(password); //System.out.println(encodedPassword);
	 * //System.out.println(isPwdRight);
	 * 
	 * if(isPwdRight) { Optional<ObserverUser>
	 * observerUser=observerUserRepo.findOneByObscodeAndPassword(jwtAuthRequest.
	 * getObscode(),encodedPassword); if(observerUser.isPresent()) { String token1
	 * =jwtTokenHelper.generateToken(observerUser1);
	 * 
	 * return new ApiResponse1(message="Login success", status=true,token=token1);
	 * 
	 * 
	 * }
	 * 
	 * else { return new ApiResponse1(message ="Login unsuccess", status
	 * =false,token=null); } }
	 * 
	 * else { return new ApiResponse1(message ="Password not match", status
	 * =false,token=null);}
	 * 
	 * } else { return new ApiResponse1(message ="observer code not exist",
	 * status=false, token=null); }
	 * 
	 * 
	 * }
	 */
	 

	
	

	  @Override 
	  public ObserverUserDto getObserverUserById(String obsCode) {
	  ObserverUser observerUser = observerUserRepo.findByObscode(obsCode);
	  
	  //return userToDto(observerUser); 
	  //String message;
		boolean status;
		if (observerUser != null)

		{
			return userToDto(observerUser);
			//return new ApiResponse(message = "User deleted Successfully ...", status = true);
		} else {

			//return new ApiResponse(message = "User does not exist", status = false);
			  throw new ApiException("usercode does not exist") ; }

		}
	 
	 
	

	@Override
	public ObserverUserDto updateObserverUser(ObserverUserDto observerUserDto, String obsCode) {
		// observerUserRepo.
		ObserverUser observerUser = observerUserRepo.findByObscode(obsCode);
		if (observerUser != null) {
		    // Update specific fields
		    observerUser.setName(observerUserDto.getName());
		    observerUser.setEmail(observerUserDto.getEmail());
		    observerUser.setHomeState(observerUserDto.getHomeState());
		    observerUser.setMobnum(observerUserDto.getMobnum());
		    observerUser.setService(observerUserDto.getService());
		    observerUser.setWorkexperience(observerUserDto.getWorkexperience());

		    // Save the updated entity back to the database
		    ObserverUser updatedUser = observerUserRepo.save(observerUser);
		    // Return the updated user as DTO
		    ObserverUserDto observerUserDto1 = userToDto(updatedUser);
		    return observerUserDto1;
		} else {
		    throw new ApiException("usercode does not exist");}
		}
		
	

	@Override
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

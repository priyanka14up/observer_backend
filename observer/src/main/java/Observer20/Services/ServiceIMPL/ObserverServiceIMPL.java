package Observer20.Services.ServiceIMPL;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import Observer20.Model.ObserverUser;
import Observer20.Services.ObserverService;
import Observer20.payloads.ApiResponse;
import Observer20.payloads.LoginDto;
import Observer20.payloads.ObserverUserDto;
import Observer20.repository.ObserverUserRepo;






@Service
public class ObserverServiceIMPL implements ObserverService{
	@Autowired
	private ObserverUserRepo observerUserRepo;
	/*
	 * @Autowired private PasswordEncoder Md5PasswordEncoder;
	 */
	
	  @Autowired
	 PasswordEncoder passwordEncoder;
	  
	/*
	 * public PasswordEncoder passwordEncoder () { return Md5PasswordEncoder; }
	 */
	 
	
	@Override	

	public ObserverUserDto createObserver(ObserverUserDto observerUserDto) {
	
	ObserverUser observerUser=dtoToUser(observerUserDto);
	ObserverUser SavedObserverUser=observerUserRepo.save(observerUser);
	  return userToDto(SavedObserverUser);
	}

	/*
	 * @Override public ObserverUserDto createObserver(ObserverUserDto
	 * observerUserDto) { String message; boolean status;
	 * 
	 * ObserverUser observerUser=dtoToUser(observerUserDto);
	 * if(observerUser!=observerUser) { ObserverUser
	 * SavedObserverUser=observerUserRepo.save(observerUser); return new
	 * ApiResponse(message ="User saved successfully...", status =true);}
	 * 
	 * } else
	 * 
	 * ObserverUser SavedObserverUser=observerUserRepo.save(observerUser); return
	 * userToDto(SavedObserverUser);
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	@Override
	public List<ObserverUserDto> getAllUsers() {
		 List<ObserverUser> observerusers=observerUserRepo.findAll();
		  List<ObserverUserDto> observeruserDtos=observerusers.stream().map(user->userToDto(user)).collect(Collectors.toList( )); 
		 
		return observeruserDtos;
	}

	

	





		private  ObserverUser dtoToUser(ObserverUserDto observerUserDto)
		{
		
			
			
			
			  ObserverUser observerUser =new ObserverUser();
			  
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
			  //observerUser.setPassword(Md5PasswordEncoder.encode(observerUserDto.getPassword())); 
			  
			  
			 
			  
			 
			return observerUser;
		}
		public ObserverUserDto userToDto(ObserverUser observerUser)
		{
			
			
			ObserverUserDto observerUserDto=new ObserverUserDto(); 
			observerUserDto.setId(observerUser.getId());
			observerUserDto.setEmail(observerUser.getEmail());
			observerUserDto.setObscode(observerUser.getObscode());
			observerUserDto.setName(observerUser.getName());
			observerUserDto.setHomeState(observerUser.getHomeState());
			observerUserDto.setMobnum(observerUser.getMobnum());
			observerUserDto.setService(observerUser.getService());
			observerUserDto.setWorkexperience(observerUser.getWorkexperience());
			observerUserDto.setRole(observerUser.getRole());
			//observerUserDto.setPassword(passwordEncoder.encode(observerUser.getPassword()));
			observerUserDto.setPassword(DigestUtils.md5DigestAsHex(observerUser.getPassword().getBytes())); 
			 //observerUserDto.setPassword(Md5PasswordEncoder.encode(observerUser.getPassword())); 
			  
			
			return observerUserDto;
		}

	@Override
	public ApiResponse loginObserver(LoginDto loginDto) {
		
				ObserverUser observerUser1=observerUserRepo.findByObscode(loginDto.getObscode());
				
				
				String message;
				boolean status;
				if(observerUser1!=null) {
					
					String password=loginDto.getPassword();
					String encodedPassword=observerUser1.getPassword();
					Boolean isPwdRight=passwordEncoder.matches(password,encodedPassword);
					//Boolean isPwdRight=DigestUtils.md5DigestAsHex matches(password,encodedPassword);
					if(isPwdRight)
					{
						Optional<ObserverUser> observerUser=observerUserRepo.findOneByObscodeAndPassword(loginDto.getObscode(), encodedPassword);
								if(observerUser.isPresent())
								{
									return new ApiResponse(message ="login success", status =true);
									
									
								}
								else
								{
									return new ApiResponse(message ="Login unsuccess", status =false);
								}
						}
					
					else
					{
						return new ApiResponse(message ="Password not match", status =false);
					}
				}
				else
				{
					
					return new ApiResponse(message ="observer code not exist", status=  false);
				}
				
				
			}
	
	  @Override
	  public ObserverUserDto getObserverUserById(String obsCode)
	  {
	  ObserverUser observerUser=observerUserRepo.findByObscode(obsCode);
	  
	  return userToDto(observerUser);
	  }
	@Override
	public ObserverUserDto updateObserverUserById(ObserverUserDto user, String obscode) {
		//observerUserRepo.
		return null;
	}
	

	  @Override public ApiResponse deleteObserverUser(String obscode) {
	  
	  ObserverUser observerUser=observerUserRepo.findByObscode(obscode);
	  String message;
		boolean status;
	  if(observerUser!=null)
		  
	  {
		  observerUserRepo.delete(observerUser);
		  return new ApiResponse(message ="User deleted Successfully ...", status =true);}
	  else
	  {
	
	
		  return new ApiResponse(message ="User does not exist", status =false);
			
	
	  }
	




	
	}}



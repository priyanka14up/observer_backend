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
		observerUser.setECI_OBSID(observerUserDto.getECI_OBSID());
        observerUser.setID_NO(observerUserDto.getID_NO());
		observerUser.setOB_TITLE(observerUserDto.getOB_TITLE());
		observerUser.setOB_CADRE(observerUserDto.getOB_CADRE());
		observerUser.setOB_YEAR(observerUserDto.getOB_YEAR());
		observerUser.setOB_SEX(observerUserDto.getOB_SEX());
		observerUser.setOB_DOB(observerUserDto.getOB_DOB());
		observerUser.setOB_STATUS(observerUserDto.getOB_STATUS());
		observerUser.setOB_LANG(observerUserDto.getOB_LANG());
		observerUser.setOB_DESIG(observerUserDto.getOB_DESIG());
		observerUser.setO_ADR_L1(observerUserDto.getO_ADR_L1());
		observerUser.setO_CITY(observerUserDto.getO_CITY());
		observerUser.setO_STATE(observerUserDto.getO_STATE());
		observerUser.setO_STD(observerUserDto.getO_STD());
		observerUser.setO_FAX(observerUserDto.getO_FAX());
		observerUser.setR_PIN(observerUserDto.getR_PIN());
		observerUser.setR_STD(observerUserDto.getR_STD());
		observerUser.setR_TNO(observerUserDto.getR_TNO());
		observerUser.setR_FAX(observerUserDto.getR_FAX());
		observerUser.setEMG_NAME(observerUserDto.getEMG_NAME());
		observerUser.setSPONSOR(observerUserDto.getSPONSOR());
		observerUser.setAGE(observerUserDto.getAGE());
		observerUser.setO_AccountNo(observerUserDto.getO_AccountNo());
		observerUser.setO_IFCSCode(observerUserDto.getO_IFCSCode());
		observerUser.setO_BankName(observerUserDto.getO_BankName());
		observerUser.setO_BranchName(observerUserDto.getO_BranchName());
		observerUser.setO_AccountHolderName(observerUserDto.getO_AccountHolderName());
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
		observerUserDto.setECI_OBSID(observerUser.getECI_OBSID());
		observerUserDto.setID_NO(observerUser.getID_NO());
		observerUserDto.setOB_TITLE(observerUser.getOB_TITLE());
		observerUserDto.setWorkexperience(observerUser.getWorkexperience());
		observerUserDto.setOB_CADRE(observerUser.getOB_CADRE());
		observerUserDto.setOB_YEAR(observerUser.getOB_YEAR());
		observerUserDto.setOB_SEX(observerUser.getOB_SEX());
		observerUserDto.setOB_DOB(observerUser.getOB_DOB());
		observerUserDto.setOB_STATUS(observerUser.getOB_STATUS());
		observerUserDto.setOB_LANG(observerUser.getOB_LANG());
		observerUserDto.setOB_DESIG(observerUser.getOB_DESIG());
		observerUserDto.setO_ADR_L1(observerUser.getO_ADR_L1());
		observerUserDto.setO_CITY(observerUser.getO_CITY());
		observerUserDto.setO_STATE(observerUser.getO_STATE());
		observerUserDto.setO_STD(observerUser.getO_STD());
		observerUserDto.setO_FAX(observerUser.getO_FAX());
		observerUserDto.setR_PIN(observerUser.getR_PIN());
		observerUserDto.setR_TNO(observerUser.getR_TNO());
		observerUserDto.setR_FAX(observerUser.getR_FAX());
		observerUserDto.setR_STD(observerUser.getR_STD());
		observerUserDto.setEMG_NAME(observerUser.getEMG_NAME());
		observerUserDto.setSPONSOR(observerUser.getSPONSOR());
		observerUserDto.setAGE(observerUser.getAGE());
		observerUserDto.setO_AccountNo(observerUser.getO_AccountNo());

		observerUserDto.setO_IFCSCode(observerUser.getO_IFCSCode());
		observerUserDto.setO_BankName(observerUser.getO_BankName());
		observerUserDto.setO_BranchName(observerUser.getO_BranchName());
		observerUserDto.setO_AccountHolderName(observerUser.getO_AccountHolderName());
		
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
		    observerUser.setOB_LANG(observerUserDtoUpdation.getOB_LANG());
		    observerUser.setO_ADR_L1(observerUserDtoUpdation.getO_ADR_L1());
		    observerUser.setO_CITY(observerUserDtoUpdation.getO_CITY());
		    observerUser.setO_STATE(observerUserDtoUpdation.getO_STATE());
		    
		    observerUser.setO_PIN(observerUserDtoUpdation.getO_PIN());
		    observerUser.setO_STD(observerUserDtoUpdation.getO_STD());
		    observerUser.setO_FAX(observerUserDtoUpdation.getO_FAX());
		    observerUser.setO_AccountNo(observerUserDtoUpdation.getO_AccountNo());
		    observerUser.setO_IFCSCode(observerUserDtoUpdation.getO_IFCSCode());
		    
		    observerUser.setO_BankName(observerUserDtoUpdation.getO_BankName());
		    observerUser.setO_BranchName(observerUserDtoUpdation.getO_BranchName());
		    observerUser.setO_AccountHolderName(observerUserDtoUpdation.getO_AccountHolderName());
		    

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

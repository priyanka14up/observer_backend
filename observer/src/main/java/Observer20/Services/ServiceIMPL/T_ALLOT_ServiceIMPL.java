package Observer20.Services.ServiceIMPL;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Exception.ApiException;
import Observer20.Model.AC_LIST2;
import Observer20.Model.DIST_LIST2;
import Observer20.Model.Obs_Allot;
import Observer20.Model.ObserverUser;
import Observer20.Model.PC_AC_DIST2;
import Observer20.Model.STATE_LIST2;
import Observer20.Model1.T_ALLOT_GROUP;
import Observer20.Repo1.T_ALLOT_GROUP_REPO;
import Observer20.Security.CustomUserDetailsService;
import Observer20.Security.JwtTokenHelper;
import Observer20.Services.T_Allot_Group_Servcie;
import Observer20.payloads.MElectionDetailsDataDTO;
import Observer20.payloads.ObsAllotDTO;
import Observer20.payloads.ObserverUserDto;
import Observer20.repository.AC_LIST2_REPO2;
import Observer20.repository.DIST_LIST_REPO2;
import Observer20.repository.MElectionDetailsREPO2;
import Observer20.repository.MElectionScheduleREPO2;
import Observer20.repository.Obs_AllotREPO;
import Observer20.repository.ObserverUserRepo;
import Observer20.repository.PC_AC_DIST_REPO2;
import Observer20.repository.STATE_LIST2_Repo;
import Observer20.Model.MElectionSchedule2;
import Observer20.Model.M_ELECTION_DETAILS2;


@Service
public class T_ALLOT_ServiceIMPL implements T_Allot_Group_Servcie {
	@Autowired
	T_ALLOT_GROUP_REPO t_ALLOT_GROUP_REPO;
	@Autowired
	Obs_AllotREPO obs_AllotREPO;
	@Autowired
	ObserverUserRepo observerUserRepo;
	@Autowired
	STATE_LIST2_Repo sTATE_LIST2_Repo;
	@Autowired
	AC_LIST2_REPO2 aC_LIST2_REPO2;
	@Autowired
	PC_AC_DIST_REPO2 pC_AC_DIST_REPO2; 
	@Autowired
	DIST_LIST_REPO2 dIST_LIST_REPO2;

	  @Autowired MElectionScheduleREPO2 mElectionScheduleREPO2;
	  
	  @Autowired MElectionDetailsREPO2 mElectionDetailsREPO2;
	  @Autowired
		JwtTokenHelper jwtTokenHelper;
		
		 @Autowired private CustomUserDetailsService userDetailsService;
		 @Autowired
	  
	 

	@Override
	public void migrateT_allot_group_Service() {
		List<T_ALLOT_GROUP> sourceData = t_ALLOT_GROUP_REPO.findAll();
		List<Obs_Allot> newData = sourceData.stream().map(this::mapToNewEntity).collect(Collectors.toList());
		obs_AllotREPO.saveAll(newData);
	}

	private Obs_Allot mapToNewEntity(T_ALLOT_GROUP source) {
		Obs_Allot newEntity = new Obs_Allot();
		newEntity.setSt_Code(source.getST_CODE());
		newEntity.setConst_Group_No(source.getCONST_GROUP_NO());
		newEntity.setAc_No(source.getCONST_COVERED());
		newEntity.setObscode(source.getOBS_CODE());
		newEntity.setStatePhaseNo(source.getStatePhaseNo());
		newEntity.setCURRENTELECTION(source.getCURRENTELECTION());
		newEntity.setObscode(source.getOBS_CODE());
		newEntity.setStatePhaseNo(source.getStatePhaseNo());
		newEntity.setCURRENTELECTION(source.getCURRENTELECTION());

		return newEntity;
	}

	private Obs_Allot dtoToUser(ObsAllotDTO obsAllotDTO) {

		Obs_Allot obs_Allot = new Obs_Allot();
		obs_Allot.setObscode(obsAllotDTO.getObscode());
		obs_Allot.setConstType(obsAllotDTO.getConstType());
		obs_Allot.setElectionType(obsAllotDTO.getElectionType());
		obs_Allot.setDatePoll(obsAllotDTO.getDatePoll());
		obs_Allot.setSt_Code(obsAllotDTO.getStCode());
		obs_Allot.setScheduleID(obsAllotDTO.getScheduleID());
		obs_Allot.setOBFromDate(obsAllotDTO.getOBFromDate());
		obs_Allot.setOBToDate(obsAllotDTO.getOBToDate());
		obs_Allot.setAc_No(obsAllotDTO.getAcNo());
		obs_Allot.setDIST_NAME(obsAllotDTO.getDistName());
		
		obs_Allot.setStName(obsAllotDTO.getStName());
		
		obs_Allot.setAcNameEn(obsAllotDTO.getAcName());
		obs_Allot.setDistNo(obsAllotDTO.getDistNo());
		
		
		
		
		

		return obs_Allot;
	}

	public ObsAllotDTO userToDto(Obs_Allot obs_Allot) {

		ObsAllotDTO obsAllotDTO = new ObsAllotDTO();
		obsAllotDTO.setObscode(obs_Allot.getObscode());
		obsAllotDTO.setConstType(obs_Allot.getConstType());
		obsAllotDTO.setElectionType(obs_Allot.getElectionType());
		obsAllotDTO.setDatePoll(obs_Allot.getDatePoll());
		
		obsAllotDTO.setStCode(obs_Allot.getSt_Code());
		obsAllotDTO.setScheduleID(obs_Allot.getScheduleID());
		
		obsAllotDTO.setOBFromDate(obs_Allot.getOBFromDate());
		obsAllotDTO.setOBToDate(obs_Allot.getOBToDate());
		obsAllotDTO.setAcNo(obs_Allot.getAc_No());
		obsAllotDTO.setDistName(obs_Allot.getDistNameEn());
		
		obsAllotDTO.setStName(obs_Allot.getStName());
		obsAllotDTO.setAcName(obs_Allot.getAcNameEn());
		obsAllotDTO.setDistNo(obs_Allot.getDistNo());
		
		

		return obsAllotDTO;
	}

	

	@Override
	public List<Obs_Allot> getObsAllotByObscode(String obsCode) {
	    List<Obs_Allot> obsAllotList = obs_AllotREPO.findAllByObscode(obsCode);

	    if (obsAllotList != null && !obsAllotList.isEmpty()) {
	        

	        // Iterate through obsAllotList and update other fields
	        for (Obs_Allot obsAllot : obsAllotList) {
	            String stCode1 = obsAllot.getSt_Code();
	            String acNo1 = obsAllot.getAc_No();

	            // Fetch the AC names using the AC_NO and St_Code
	            List<AC_LIST2> acList = aC_LIST2_REPO2.findAllByStCodeAndAcNo(stCode1, acNo1);
	            StringBuilder acNames = new StringBuilder();

	            if (acList != null && !acList.isEmpty()) {
	                for (AC_LIST2 ac : acList) {
	                    acNames.append(ac.getAcNameEn()).append(", ");
	                }
	                
	                if (acNames.length() > 0) {
	                    acNames.setLength(acNames.length() - 2);
	                    obsAllot.setAc_No(acNames.toString());
	                } else {
	                    obsAllot.setAc_No("AC Name Not Found");
	                }
	                
	                // Fetch dist_no from AC_LIST2 table
	                String distNo = acList.get(0).getDistNoHdqtr();

	                // Fetch dist_name based on dist_no and st_code
	                DIST_LIST2 distList = dIST_LIST_REPO2.findByDistNoAndStCode(distNo, stCode1);

	                if (distList != null) {
	                    obsAllot.setDIST_NAME(distList.getDistNameEn());
	                } else {
	                    obsAllot.setDIST_NAME("District Name Not Found");
	                }
	            } else {
	                obsAllot.setAc_No("AC No. Not Found");
	            }

	            // Fetch the state name using the ST_CODE
	            STATE_LIST2 stateList2 = sTATE_LIST2_Repo.findByStCode(stCode1);
	            if (stateList2 != null) {
	                obsAllot.setSt_Code(stateList2.getStName());
	            } else {
	                obsAllot.setSt_Code("State Not Found");
	            }

	            // Fetch columns from eci_observers table
	            ObserverUser observerUser = observerUserRepo.findByObscode(obsCode);
	            if (observerUser != null) {
	                obsAllot.setName(observerUser.getName());
	                obsAllot.setService(observerUser.getService());
	                obsAllot.setOBFromDate(observerUser.getOBFromDate());
	                obsAllot.setOBToDate(observerUser.getOBToDate());
	                obsAllot.setRole(observerUser.getRole());
	                obsAllot.setOB_image(observerUser.getOB_image());
	            } else {
	                obsAllot.setName("Observer Name Not Found");
	                obsAllot.setService("Service Not Found");
	            }
	        }

	        // Update pc_NAME and dist_NAME only for the first record
	        //obsAllotList.get(0).setPC_NAME(pcName);
	        //obsAllotList.get(0).setDIST_NAME(distName);

	        return obsAllotList;
	    } else {
	        throw new ApiException("Observer with obscode " + obsCode + " not found.");
	    }
	}



	
	
	
	@Override
	public MElectionDetailsDataDTO getElectionData(String obsCode) {
	    List<Object[]> electionDetailsList = mElectionDetailsREPO2.findDetailsByObsCode(obsCode);
	    List<Object[]> datePollAndCurrentElectionList = mElectionScheduleREPO2.findDatePollAndCurrentElectionByObsCode(obsCode);
	    ObserverUser observerUser = observerUserRepo.findDEPStatusCountingByObscode(obsCode);
	    
	    MElectionDetailsDataDTO mElectionDetailsDataDTO = new MElectionDetailsDataDTO();

	    if (electionDetailsList != null && !electionDetailsList.isEmpty() &&
	        datePollAndCurrentElectionList != null && !datePollAndCurrentElectionList.isEmpty() &&
	        observerUser != null) {

	        // Handle multiple results by iterating through the list
	        for (Object[] electionDetails : electionDetailsList) {
	            mElectionDetailsDataDTO.setConstType((String) electionDetails[0]);
	            mElectionDetailsDataDTO.setElectionType((String) electionDetails[1]);

	            // Convert Object to Integer
	            int statePhaseNo = (Integer) electionDetails[2];
	            mElectionDetailsDataDTO.setStatePhaseNO(statePhaseNo);

	            // Convert Object to Integer
	            int phaseNo = (Integer) electionDetails[3];
	            mElectionDetailsDataDTO.setPhaseNo(phaseNo);

	            // Extract datePoll and currentElection from the list of Object arrays
	            Object[] datePollAndCurrentElection = datePollAndCurrentElectionList.get(0);

	            // Handle Timestamp object properly (convert to Date)
	            Timestamp timestamp = (Timestamp) datePollAndCurrentElection[0];
	            Date datePoll = new Date(timestamp.getTime());
	            mElectionDetailsDataDTO.setDatePoll(datePoll);

	            // Assuming currentElection is a String, cast it accordingly
	            String currentElection = (String) datePollAndCurrentElection[1];
	            mElectionDetailsDataDTO.setCurrentElection(currentElection);

	            // Get depStatusCounting from ObserverUser object
	            String depStatusCounting = observerUser.getDEPSTATUS_COUNTING();
	            mElectionDetailsDataDTO.setDEPSTATUS_COUNTING(depStatusCounting);

	            // Break the loop after processing the first result if you only want one result
	            break;
	        }
	    }

	    return mElectionDetailsDataDTO;
	}

	
		@Override
		public Map<String, String> getDistrictAndStateNames(String obsCode, String acNameEn) {
	        Map<String, String> resultMap = new HashMap<>();

	        // Fetch AC_LIST details based on acNameEn
	        AC_LIST2 acDetails = aC_LIST2_REPO2.findByAcNameEn(acNameEn);

	        if (acDetails != null) {
	            // Assuming you have dist_no_hdqt in AC_LIST
	            String distNoHdqt = acDetails.getDistNoHdqtr();

	            // Fetch dist_name based on dist_no_hdqt from dist_list
	            DIST_LIST2 distDetails = dIST_LIST_REPO2.findByDistNoAndStCode(distNoHdqt, acDetails.getStCode());

	            if (distDetails != null) {
	                resultMap.put("distNoHdqt", distDetails.getDistNo());
	                resultMap.put("districtName", distDetails.getDistNameEn());

	                // Fetch state details based on state code from STATE_LIST2
	                STATE_LIST2 stateDetails = sTATE_LIST2_Repo.findByStCode(acDetails.getStCode());

	                if (stateDetails != null) {
	                    resultMap.put("stateCode", stateDetails.getStCode());
	                    resultMap.put("stateName", stateDetails.getStName());
	                } else {
	                    resultMap.put("stateCode", "State Code Not Found");
	                    resultMap.put("stateName", "State Name Not Found");
	                }
	            } else {
	                resultMap.put("districtName", "District Name Not Found");
	                resultMap.put("stateCode", "State Code Not Found");
	                resultMap.put("stateName", "State Name Not Found");
	                resultMap.put("districtCode", "District Code Not Found");
	            }
	        } else {
	            resultMap.put("districtName", "District Name Not Found");
	            resultMap.put("stateCode", "State Code Not Found");
	            resultMap.put("stateName", "State Name Not Found");
	            resultMap.put("districtCode", "District Code Not Found");
	        }

	        return resultMap;
	    }

			  
		
		

		 public List<ObsAllotDTO> getObsAllotByObscode1(String obsCode) {
		        List<Obs_Allot> obsAllotList = obs_AllotREPO.findAllByObscode(obsCode);
		        List<ObsAllotDTO> obsAllotDTOList = new ArrayList<>();

		        if (obsAllotList != null && !obsAllotList.isEmpty()) {
		            for (Obs_Allot obsAllot : obsAllotList) {
		                ObsAllotDTO obsAllotDTO = new ObsAllotDTO();

		                // Populate ObsAllotDTO fields
		                obsAllotDTO.setObscode(obsAllot.getObscode());
		                obsAllotDTO.setAcNo(obsAllot.getAc_No());
		                // ... populate other fields of ObsAllotDTO ...

		                // Fetch additional data and populate ObsAllotDTO
		                String stCode1 = obsAllot.getSt_Code();
		                String acNo1 = obsAllot.getAc_No();

		                // Fetch AC names using AC_NO and St_Code
		                List<AC_LIST2> acList = aC_LIST2_REPO2.findAllByStCodeAndAcNo(stCode1, acNo1);
		                StringBuilder acNames = new StringBuilder();

		                if (acList != null && !acList.isEmpty()) {
		                    for (AC_LIST2 ac : acList) {
		                        acNames.append(ac.getAcNameEn()).append(", ");
		                    }

		                    if (acNames.length() > 0) {
		                        acNames.setLength(acNames.length() - 2);
		                        obsAllotDTO.setAcNo(acNames.toString());
		                    } else {
		                        obsAllotDTO.setAcNo("AC Name Not Found");
		                    }

		                    // Fetch dist_no from AC_LIST2 table
		                    String distNo = acList.get(0).getDistNoHdqtr();

		                    // Fetch dist_name based on dist_no and st_code
		                    DIST_LIST2 distList = dIST_LIST_REPO2.findByDistNoAndStCode(distNo, stCode1);

		                    if (distList != null) {
		                        obsAllotDTO.setDistName(distList.getDistNameEn());
		                    } else {
		                        obsAllotDTO.setDistName("District Name Not Found");
		                    }
		                } else {
		                    obsAllotDTO.setAcNo("AC No. Not Found");
		                }

		                // Fetch state name using ST_CODE
		                STATE_LIST2 stateList2 = sTATE_LIST2_Repo.findByStCode(stCode1);
		                if (stateList2 != null) {
		                    obsAllotDTO.setStName(stateList2.getStName());
		                } else {
		                    obsAllotDTO.setStName("State Not Found");
		                }

		                // Fetch data from observerUserRepo and populate ObsAllotDTO
		                ObserverUser observerUser1 = observerUserRepo.findByObscode(obsCode);
		                if (observerUser1 != null) {
		                    obsAllotDTO.setOBFromDate(observerUser1.getOBFromDate());
		                    obsAllotDTO.setOBToDate(observerUser1.getOBToDate());
		                    //obsAllotDTO.setOBImage(observerUser1.getOB_image());
		                    // ... populate other fields of ObsAllotDTO from observerUser1 ...
		                } else {
		                    obsAllotDTO.setOBFromDate(null);
		                    obsAllotDTO.setOBToDate(null);
		                }

		                // Fetch data from M_election_schedule and populate ObsAllotDTO
		                Long scheduleId = obsAllot.getScheduleID();
		                MElectionSchedule2 electionSchedule = mElectionScheduleREPO2.findByScheduleID(scheduleId);
		                if (electionSchedule != null) {
		                    obsAllotDTO.setDatePoll(electionSchedule.getDatePoll());
		                } else {
		                    obsAllotDTO.setDatePoll(null);
		                }

		                // Fetch data from M_election_details2 and populate ObsAllotDTO
		                M_ELECTION_DETAILS2 electionDetails = mElectionDetailsREPO2.findByScheduleID(scheduleId);
		                if (electionDetails != null) {
		                    obsAllotDTO.setConstType(electionDetails.getConstType());
		                    obsAllotDTO.setElectionType(electionDetails.getElectionType());
		                } else {
		                    obsAllotDTO.setConstType("Const Type Not Found");
		                    obsAllotDTO.setElectionType("Election Type Not Found");
		                }

		                obsAllotDTOList.add(obsAllotDTO);
		            }
		            return obsAllotDTOList;
		        } else {
		            throw new ApiException("Observer with obscode " + obsCode + " not found.");
		        }
		    }
		}

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import Observer20.payloads.ObsAllotDTO1;
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
		//obs_Allot.setConstType(obsAllotDTO.getConstType());
		//obs_Allot.setElectionType(obsAllotDTO.getElectionType());
		//obs_Allot.setDatePoll(obsAllotDTO.getDatePoll());
		obs_Allot.setSt_Code(obsAllotDTO.getStCode());
		obs_Allot.setScheduleID(obsAllotDTO.getScheduleID());
		//obs_Allot.setOBFromDate(obsAllotDTO.getOBFromDate());
		//obs_Allot.setOBToDate(obsAllotDTO.getOBToDate());
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
		//obsAllotDTO.setConstType(obs_Allot.getConstType());
		//obsAllotDTO.setElectionType(obs_Allot.getElectionType());
		//obsAllotDTO.setDatePoll(obs_Allot.getDatePoll());
		
		obsAllotDTO.setStCode(obs_Allot.getSt_Code());
		obsAllotDTO.setScheduleID(obs_Allot.getScheduleID());
		
		//obsAllotDTO.setOBFromDate(obs_Allot.getOBFromDate());
		//obsAllotDTO.setOBToDate(obs_Allot.getOBToDate());
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
	public ResponseEntity<Object> getElectionData(String obsCode) {
	    List<Object[]> electionDetailsList = mElectionDetailsREPO2.findDetailsByObsCode(obsCode);
	    List<Object[]> datePollAndCurrentElectionList = mElectionScheduleREPO2.findDatePollAndCurrentElectionByObsCode(obsCode);
	    ObserverUser observerUser = observerUserRepo.findDEPStatusCountingByObscode(obsCode);

	    MElectionDetailsDataDTO mElectionDetailsDataDTO = new MElectionDetailsDataDTO();

	    if (electionDetailsList != null && !electionDetailsList.isEmpty() &&
	        datePollAndCurrentElectionList != null && !datePollAndCurrentElectionList.isEmpty() &&
	        observerUser != null) {

	        Object[] electionDetails = electionDetailsList.get(0); // Assuming you want the first result

	        if (electionDetails.length >= 4) {
	            mElectionDetailsDataDTO.setConstType((String) electionDetails[0]);
	            mElectionDetailsDataDTO.setElectionType((String) electionDetails[1]);
	            mElectionDetailsDataDTO.setStatePhaseNO((Integer) electionDetails[2]);
	            mElectionDetailsDataDTO.setPhaseNo((Integer) electionDetails[3]);
	        }

	        if (datePollAndCurrentElectionList.size() > 0) {
	            Object[] datePollAndCurrentElection = datePollAndCurrentElectionList.get(0);
	            if (datePollAndCurrentElection.length >= 2) {
	                Timestamp timestamp = (Timestamp) datePollAndCurrentElection[0];
	                Date datePoll = new Date(timestamp.getTime());
	                mElectionDetailsDataDTO.setDatePoll(datePoll);
	                mElectionDetailsDataDTO.setCurrentElection((String) datePollAndCurrentElection[1]);
	            }
	        }

	        if (observerUser.getDEPSTATUS_COUNTING() != null) {
	            mElectionDetailsDataDTO.setDEPSTATUS_COUNTING(observerUser.getDEPSTATUS_COUNTING());
	        }

	        return ResponseEntity.ok(mElectionDetailsDataDTO);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Election data not found for obsCode: " + obsCode);
	    }
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
		                obsAllotDTO.setStCode(obsAllot.getSt_Code());
		                obsAllotDTO.setAcNo(obsAllot.getAc_No());
		                

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
		                        obsAllotDTO.setAcName(acNames.toString());
		                    } else {
		                        obsAllotDTO.setAcName("AC Name Not Found");
		                    }

		                    // Fetch dist_no from AC_LIST2 table
		                    String distNo = acList.get(0).getDistNoHdqtr();

		                    // Fetch dist_name based on dist_no and st_code
		                    DIST_LIST2 distList = dIST_LIST_REPO2.findByDistNoAndStCode(distNo, stCode1);

		                    if (distList != null) {
		                    	obsAllotDTO.setDistNo(distList.getDistNo());
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
		                    //obsAllotDTO.setOBFromDate(observerUser1.getOBFromDate());
		                    //obsAllotDTO.setOBToDate(observerUser1.getOBToDate());
		                    obsAllotDTO.setObscode(observerUser1.getObscode());
		                    obsAllotDTO.setName(observerUser1.getName());
		                    obsAllotDTO.setEmail(observerUser1.getEmail());
		                    obsAllotDTO.setMobnum(observerUser1.getMobnum());
		                    obsAllotDTO.setO_FAX(observerUser1.getO_FAX());
		                    //obsAllotDTO.setO_FAX(observerUser1.getO_FAX());
		                    //obsAllotDTO.setO_FAX(observerUser1.getO_FAX());
		                    //obsAllotDTO.setO_FAX(observerUser1.getO_FAX());
		                   
		                } else {
		                    obsAllotDTO.setObscode(null);
		                    obsAllotDTO.setName(null);
		                }

		                obsAllotDTO.setConstMob(null);
		                obsAllotDTO.setConstTelNo(null);
		                obsAllotDTO.setConstFaxNo(null);
		                obsAllotDTO.setWhetherObName(null);
		                
		                //List<String> localAdressMobile = new ArrayList<>();
		                //localAdressMobile.add("null");
		                //localAdressMobile.add("null");
		                String localAddress = "null";
		                String localMobile = "null";
		                obsAllotDTO.setLocalAdressMobile(localAddress + " , " + localMobile);
		                //obsAllotDTO.setConstFaxNo(localAdressMobile);
		                obsAllotDTOList.add(obsAllotDTO);
		                
		            }
		            return obsAllotDTOList;
		        } else {
		            throw new ApiException("Observer with obscode " + obsCode + " not found.");
		        }
		 }
		 @Override
		 public List<ObsAllotDTO1> getObsAllotByObscode2(String obsCode) {
		        List<Obs_Allot> obsAllotList = obs_AllotREPO.findAllByObscode(obsCode);
		        List<ObsAllotDTO1> obsAllotDTOList = new ArrayList<>();

		        if (obsAllotList != null && !obsAllotList.isEmpty()) {
		            for (Obs_Allot obsAllot : obsAllotList) {
		                ObsAllotDTO1 obsAllotDTO1 = new ObsAllotDTO1();

		                // Populate ObsAllotDTO fields
		                obsAllotDTO1.setObscode(obsAllot.getObscode());
		                obsAllotDTO1.setStCode(obsAllot.getSt_Code());
		                obsAllotDTO1.setAcNo(obsAllot.getAc_No());
		                

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
		                        obsAllotDTO1.setAcName(acNames.toString());
		                    } else {
		                    	obsAllotDTO1.setAcName("AC Name Not Found");
		                    }

		                    // Fetch dist_no from AC_LIST2 table
		                    String distNo = acList.get(0).getDistNoHdqtr();

		                    // Fetch dist_name based on dist_no and st_code
		                    DIST_LIST2 distList = dIST_LIST_REPO2.findByDistNoAndStCode(distNo, stCode1);

		                    if (distList != null) {
		                    	obsAllotDTO1.setDistNo(distList.getDistNo());
		                    	obsAllotDTO1.setDistName(distList.getDistNameEn());
		                    } else {
		                    	obsAllotDTO1.setDistName("District Name Not Found");
		                    }
		                } else {
		                	obsAllotDTO1.setAcNo("AC No. Not Found");
		                }

		                // Fetch state name using ST_CODE
		                STATE_LIST2 stateList2 = sTATE_LIST2_Repo.findByStCode(stCode1);
		                if (stateList2 != null) {
		                	obsAllotDTO1.setStName(stateList2.getStName());
		                } else {
		                	obsAllotDTO1.setStName("State Not Found");
		                }

		                // Fetch data from observerUserRepo and populate ObsAllotDTO
		                ObserverUser observerUser1 = observerUserRepo.findByObscode(obsCode);
		                if (observerUser1 != null) {
		                    obsAllotDTO1.setOBFromDate(observerUser1.getOBFromDate());
		                    obsAllotDTO1.setOBToDate(observerUser1.getOBToDate());
		                	obsAllotDTO1.setObscode(observerUser1.getObscode());
		                	obsAllotDTO1.setName(observerUser1.getName());
		                	obsAllotDTO1.setService(observerUser1.getService());
		                	obsAllotDTO1.setOB_image(observerUser1.getOB_image());
		                	obsAllotDTO1.setRole(observerUser1.getRole());
		                	
		                	
		                } else {
		                	obsAllotDTO1.setObscode(null);
		                	obsAllotDTO1.setName(null);
		                }

		               
		                obsAllotDTOList.add(obsAllotDTO1);
		                
		            }
		            return obsAllotDTOList;
		        } else {
		            throw new ApiException("Observer with obscode " + obsCode + " not found.");
		        }
		 }}
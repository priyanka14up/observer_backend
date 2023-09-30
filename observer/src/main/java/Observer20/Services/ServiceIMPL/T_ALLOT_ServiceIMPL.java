package Observer20.Services.ServiceIMPL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Exception.ApiException;
import Observer20.Model.AC_LIST2;
import Observer20.Model.MElectionSchedule2;
import Observer20.Model.M_ELECTION_DETAILS2;
import Observer20.Model.Obs_Allot;
import Observer20.Model.ObserverUser;
import Observer20.Model.PC_AC_DIST2;
import Observer20.Model.STATE_LIST2;
import Observer20.Model1.T_ALLOT_GROUP;
import Observer20.Repo1.T_ALLOT_GROUP_REPO;
import Observer20.Services.T_Allot_Group_Servcie;
import Observer20.payloads.MElectionDetailsDataDTO;
import Observer20.repository.AC_LIST2_REPO2;
import Observer20.repository.MElectionDetailsREPO2;
import Observer20.repository.MElectionScheduleREPO2;
import Observer20.repository.Obs_AllotREPO;
import Observer20.repository.ObserverUserRepo;
import Observer20.repository.PC_AC_DIST_REPO2;
import Observer20.repository.STATE_LIST2_Repo;

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
	PC_AC_DIST_REPO2 pC_AC_DIST_REPO2; // Inject the PC_AC_DIST repository
	@Autowired
	MElectionScheduleREPO2 mElectionScheduleREPO2;
	@Autowired
	MElectionDetailsREPO2 mElectionDetailsREPO2;

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

		return newEntity;
	}

	@Override
	public List<Obs_Allot> getObsAllotByObscode(String obsCode) {
		List<Obs_Allot> obsAllotList = obs_AllotREPO.findAllByObscode(obsCode);

		if (obsAllotList != null && !obsAllotList.isEmpty()) {
			String stCode = obsAllotList.get(0).getSt_Code();
			String acNo = obsAllotList.get(0).getAc_No();
			List<PC_AC_DIST2> pcAcDistList = pC_AC_DIST_REPO2.findAllByStCodeAndAcNo(stCode, acNo);
			String pcName = "PC Name Not Found";
			String distName = "District Name Not Found";

			if (pcAcDistList != null && !pcAcDistList.isEmpty()) {
				Set<String> uniquePcNames = new HashSet<>();
				Set<String> uniqueDistNames = new HashSet<>();

				for (PC_AC_DIST2 pcAcDist : pcAcDistList) {
					uniquePcNames.add(pcAcDist.getPC_NAME());
					uniqueDistNames.add(pcAcDist.getDIST_NAME());
				}

				// Convert unique names back to a comma-separated string
				pcName = String.join(", ", uniquePcNames);
				distName = String.join(", ", uniqueDistNames);
			}

			// Set PC_NAME and DIST_NAME outside the loop
			for (Obs_Allot obsAllot : obsAllotList) {
				obsAllot.setPC_NAME(pcName);
				obsAllot.setDIST_NAME(distName);
			}

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
					// Remove the trailing comma and space
					if (acNames.length() > 0) {
						acNames.setLength(acNames.length() - 2);
						obsAllot.setAc_No(acNames.toString());
					} else {
						obsAllot.setAc_No("AC Name Not Found");
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
					obsAllot.setOb_From_Date(observerUser.getOB_FromDate());
					obsAllot.setOb_To_Date(observerUser.getOB_ToDate());
				} else {
					obsAllot.setName("Observer Name Not Found");
					obsAllot.setService("Service Not Found");
				}
			}

			// Update pc_NAME and dist_NAME only for the first record
			obsAllotList.get(0).setPC_NAME(pcName);
			obsAllotList.get(0).setDIST_NAME(distName);

			return obsAllotList;
		} else {
			throw new ApiException("Observer with obscode " + obsCode + " not found.");
		}
	}

	/*
	 * @Override public MElectionDetailsDataDTO getElectionData(String obsCode) {
	 * Object[] electionDetails =
	 * mElectionDetailsREPO2.findDetailsByObsCode(obsCode); String datePoll =
	 * mElectionScheduleREPO2.findDatePollByObsCode(obsCode);
	 * 
	 * MElectionDetailsDataDTO mElectionDetailsDataDTO = new
	 * MElectionDetailsDataDTO(); if (electionDetails != null &&
	 * electionDetails.length >= 4 && datePoll != null) {
	 * mElectionDetailsDataDTO.setConstType((String) electionDetails[0]);
	 * mElectionDetailsDataDTO.setElectionType((String) electionDetails[1]);
	 * mElectionDetailsDataDTO.setStatePHASE_NO((String) electionDetails[2]);
	 * mElectionDetailsDataDTO.setPhaseNO((String) electionDetails[3]);
	 * mElectionDetailsDataDTO.setDatePoll(datePoll); }
	 * 
	 * return mElectionDetailsDataDTO; }
	 */
	@Override
	public MElectionDetailsDataDTO getElectionData(String obsCode) {
	    List<Object[]> electionDetailsList = mElectionDetailsREPO2.findDetailsByObsCode(obsCode);
	    List<String> datePollStrings = mElectionScheduleREPO2.findDatePollByObsCode(obsCode);

	    MElectionDetailsDataDTO mElectionDetailsDataDTO = new MElectionDetailsDataDTO();

	    if (electionDetailsList != null && !electionDetailsList.isEmpty() && datePollStrings != null && !datePollStrings.isEmpty()) {
	        // Handle multiple results by iterating through the list
	        for (Object[] electionDetails : electionDetailsList) {
	            mElectionDetailsDataDTO.setConstType((String) electionDetails[0]);
	            mElectionDetailsDataDTO.setElectionType((String) electionDetails[1]);

	            // Convert String to int
	            //int statePhaseNo = Integer.parseInt((String) electionDetails[2]);
	            int statePhaseNo = (int) electionDetails[2];
	            

	            mElectionDetailsDataDTO.setStatePhaseNO(statePhaseNo);

	            // Convert String to int
	           // int phaseNo = Integer.parseInt((String) electionDetails[3]);
	            int phaseNo = (int) electionDetails[3];
	            mElectionDetailsDataDTO.setPhaseNo(phaseNo);

	            // Parse String date to Date object
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the format according to your date string
	            try {
	                Date datePoll = dateFormat.parse(datePollStrings.get(0)); // Assuming you want the first datePoll value from the list
	                mElectionDetailsDataDTO.setDatePoll(datePoll);
	            } catch (ParseException e) {
	                // Handle the exception according to your needs
	                e.printStackTrace();
	            }

	            // Break the loop after processing the first result if you only want one result
	            break;
	        }
	    }

	    return mElectionDetailsDataDTO;
	}}





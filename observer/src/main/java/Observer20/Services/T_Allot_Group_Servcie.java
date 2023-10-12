package Observer20.Services;

import java.util.List;
import java.util.Map;

import Observer20.Model.Obs_Allot;
import Observer20.payloads.MElectionDetailsDataDTO;



public interface T_Allot_Group_Servcie {
	void migrateT_allot_group_Service();
	List<Obs_Allot> getObsAllotByObscode(String obsCode);
	MElectionDetailsDataDTO getElectionData(String obsCode);
	
	Map<String, String> getDistrictAndStateNames(String obsCode, String acNameEn);
	
	

	
}

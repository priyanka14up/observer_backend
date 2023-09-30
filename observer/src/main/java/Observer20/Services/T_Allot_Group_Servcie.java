package Observer20.Services;

import java.util.List;

import Observer20.Model.Obs_Allot;


public interface T_Allot_Group_Servcie {
	void migrateT_allot_group_Service();
	List<Obs_Allot> getObsAllotByObscode(String obsCode);
	//MElectionDetailsDataDTO getElectionData(String obsCode);
	

	
}

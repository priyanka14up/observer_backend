package Observer20.Services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import Observer20.Model.Obs_Allot;
import Observer20.payloads.MElectionDetailsDataDTO;
import Observer20.payloads.ObsAllotDTO;
import Observer20.payloads.ObsAllotDTO1;



public interface T_Allot_Group_Servcie {
	void migrateT_allot_group_Service();
	List<Obs_Allot> getObsAllotByObscode(String obsCode);
	MElectionDetailsDataDTO getElectionData(String obsCode);
	
	Map<String, String> getDistrictAndStateNames(String obsCode, String acNameEn);
	List<ObsAllotDTO> getObsAllotByObscode1(String obsCode);
	List<ObsAllotDTO1> getObsAllotByObscode2(String obsCode);
	
	

	
}

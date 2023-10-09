package Observer20.Services.ServiceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Model.AC_LIST2;
import Observer20.Model.MElectionSchedule2;
import Observer20.Model.M_ELECTION_DETAILS2;
import Observer20.Model1.AC_list;
import Observer20.Model1.M_ELECTION_DETAILS;
import Observer20.Model1.M_ELECTION_SCHEDULE;
import Observer20.Repo1.MElectionDetailsREPO;
import Observer20.Repo1.MElectionScheduleREPO;
import Observer20.Services.MElectionScheduleService;
import Observer20.repository.MElectionDetailsREPO2;
import Observer20.repository.MElectionScheduleREPO2;
@Service
public class MElectionScheduleServiceIMPL  implements MElectionScheduleService{
	@Autowired MElectionScheduleREPO mElectionScheduleREPO;
	@Autowired MElectionScheduleREPO2 mElectionScheduleREPO2;
	
	@Override
	public void migrateDataMElectionSchedule() {
				
		List<M_ELECTION_SCHEDULE> sourceData = mElectionScheduleREPO.findAll(); 
		List<MElectionSchedule2> newData =sourceData.stream().map(this::mapToNewEntity).collect(Collectors.toList());
		mElectionScheduleREPO2.saveAll(newData); } 
		  private MElectionSchedule2 mapToNewEntity(M_ELECTION_SCHEDULE source) 
		  { 
			  MElectionSchedule2 newEntity = new MElectionSchedule2();
		  newEntity.setScheduleID(source.getScheduleID());
		  newEntity.setDT_ISS_NOM(source.getDT_ISS_NOM());
		  newEntity.setLDT_IS_NOM(source.getLDT_IS_NOM());
		  newEntity.setDT_SCR_NOM(source.getDT_SCR_NOM());
		  newEntity.setLDT_WD_CAN(source.getLDT_WD_CAN());
		  newEntity.setDatePoll(source.getDATE_POLL());
		  newEntity.setDATE_COUNT(source.getDATE_COUNT());
		  newEntity.setDTB_EL_COM(source.getDTB_EL_COM());
		  newEntity.setDT_PRESS_ANNC(source.getDT_PRESS_ANNC());
		  newEntity.setPHASE_NO(source.getPHASE_NO());
		  newEntity.setCurrentElection(source.getCURRENTELECTION());
		  newEntity.setINSERTION_DATE(source.getINSERTION_DATE());
		  newEntity.setOBSREPORTDISP(source.getOBSREPORTDISP());
		  newEntity.setElectionID(source.getElectionID());
		 
		 
		  
		  return newEntity;
		  }
		
		
	}



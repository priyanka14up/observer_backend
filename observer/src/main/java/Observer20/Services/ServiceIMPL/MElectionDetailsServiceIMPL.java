package Observer20.Services.ServiceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Model.AC_LIST2;
import Observer20.Model.M_ELECTION_DETAILS2;
import Observer20.Model1.AC_list;
import Observer20.Model1.M_ELECTION_DETAILS;
import Observer20.Repo1.AC_LIST_REPO;
import Observer20.Repo1.MElectionDetailsREPO;
import Observer20.Services.MElectionDetailsService;
import Observer20.repository.AC_LIST2_REPO2;
import Observer20.repository.MElectionDetailsREPO2;

@Service
public class MElectionDetailsServiceIMPL implements  MElectionDetailsService {
	@Autowired MElectionDetailsREPO mElectionDetailsREPO;
	@Autowired MElectionDetailsREPO2 mElectionDetailsREPO2;
	@Override
	public void migrateDataMElectionDetails()
	{
		List<M_ELECTION_DETAILS> sourceData = mElectionDetailsREPO.findAll(); 
		List<M_ELECTION_DETAILS2> newData =sourceData.stream().map(this::mapToNewEntity).collect(Collectors.toList());
		mElectionDetailsREPO2.saveAll(newData); } 
		  private M_ELECTION_DETAILS2 mapToNewEntity(M_ELECTION_DETAILS source) 
		  { 
			  M_ELECTION_DETAILS2 newEntity = new M_ELECTION_DETAILS2();
		  newEntity.setCcode(source.getCCODE());
		  newEntity.setScheduleID(source.getScheduleID());
		  newEntity.setConstNo(source.getCONST_NO());
		  newEntity.setConstType(source.getCONST_TYPE());
		  newEntity.setDelimType(source.getDELIM_TYPE());
		  newEntity.setElectionType(source.getELECTION_TYPE());
		  newEntity.setStCode(source.getST_CODE());
		 // newEntity.setInsertionDate(source.getINSERTION_DATE());
		  newEntity.setVotesReg49O(source.getVotesReg_49O());
		  newEntity.setStatePhaseNo(source.getStatePHASE_NO());
		  newEntity.setPhaseNo(source.getPHASE_NO());
		  newEntity.setAdjournedPoll(source.getAdjournedPoll());
		 
		 
		  
		  return newEntity;
		  }
		
	}



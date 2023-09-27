package Observer20.Services.ServiceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Model.PC_AC_DIST2;
import Observer20.Model.STATE_LIST2;
import Observer20.Model1.PC_AC_DIST;
import Observer20.Model1.STATE_LIST;
import Observer20.Repo1.PC_AC_DIST_REPO;
import Observer20.Services.PC_AC_DIST_Service;
import Observer20.repository.PC_AC_DIST_REPO2;
@Service
public class PC_AC_DIST_ServiceIMPL implements PC_AC_DIST_Service{
	@Autowired PC_AC_DIST_REPO  pC_AC_DIST_REPO;
	@Autowired PC_AC_DIST_REPO2  pC_AC_DIST_REPO2;

	@Override
	public void migrateDataPC_AC_DIST_() {
		List<PC_AC_DIST> sourceData = pC_AC_DIST_REPO.findAll(); 
		List<PC_AC_DIST2> newData =sourceData.stream().map(this::mapToNewEntity).collect(Collectors.toList());
		pC_AC_DIST_REPO2.saveAll(newData); } 
		  private PC_AC_DIST2 mapToNewEntity(PC_AC_DIST source) 
		  { 
			  PC_AC_DIST2 newEntity = new PC_AC_DIST2();
		  newEntity.setStCode (source.getST_CODE());
		  newEntity.setST_NAME(source.getST_NAME());
		  newEntity.setPC_NO(source.getPC_NO());
		  newEntity.setPC_NAME(source.getPC_NAME());
		  newEntity.setPC_TYPE(source.getPC_TYPE());
		  newEntity.setAcNo(source.getAC_NO());
		  newEntity.setAC_NAME(source.getAC_NAME());
		  newEntity.setAC_TYPE(source.getAC_TYPE());
		  newEntity.setDIST_NO(source.getDIST_NO());
		  newEntity.setDIST_NAME(source.getDIST_NAME());
		  
		  return newEntity;
		  }
		
		
	}



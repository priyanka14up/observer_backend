package Observer20.Services.ServiceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Observer20.Model.DIST_LIST2;
import Observer20.Model1.DIST_LIST;
import Observer20.Repo1.DIST_LIST_REPO;
import Observer20.Services.DIST_LIST_Service;
import Observer20.repository.DIST_LIST_REPO2;
@Service
public class DIST_LIST_ServiceIMPL implements DIST_LIST_Service {
	@Autowired DIST_LIST_REPO  dIST_LIST_REPO ;
	@Autowired DIST_LIST_REPO2 dIST_LIST_REPO2;

	@Override
	public void migrateDataDIST_List() {
		List<DIST_LIST> sourceData = dIST_LIST_REPO.findAll(); 
		List<DIST_LIST2> newData =sourceData.stream().map(this::mapToNewEntity).collect(Collectors.toList());
		dIST_LIST_REPO2.saveAll(newData); } 
		  private DIST_LIST2 mapToNewEntity(DIST_LIST source) 
		  { 
			  DIST_LIST2 newEntity = new DIST_LIST2();
		  newEntity.setCCODE(source.getCCODE());
		  newEntity.setStCode(source.getST_CODE());
		  newEntity.setDistNo(source.getDIST_NO());
		  newEntity.setDistNameEn(source.getDIST_NAME_EN());
		  newEntity.setDIST_NAME_V1(source.getDIST_NAME_V1());
		  newEntity.setDIST_NAME_V2(source.getDIST_NAME_V2());
		  newEntity.setDIST_NAME_V3(source.getDIST_NAME_V3());
		  newEntity.setDIST_NAME_V4(source.getDIST_NAME_V4());
		  newEntity.setDIST_NAME_V5(source.getDIST_NAME_V5());
		  newEntity.setDIVISION_NO(source.getDIVISION_NO());
		  newEntity.setDIST_NO_REV(source.getDIST_NO_REV());
		  newEntity.setDIST_NAME_HI(source.getDIST_NAME_HI());
		  newEntity.setLast_Updated(source.getLast_Updated());
		 
		  
		  return newEntity;
		  }
		
	}



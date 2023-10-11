package Observer20.Services.ServiceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Model.AC_LIST2;
import Observer20.Model1.AC_list;
import Observer20.Repo1.AC_LIST_REPO;
import Observer20.Services.AC_LIST_Service;
import Observer20.repository.AC_LIST2_REPO2;
@Service
public class AC_List_ServiceIMPL implements AC_LIST_Service  {
	@Autowired AC_LIST_REPO  aC_LIST_REPO ;
	@Autowired AC_LIST2_REPO2 aC_LIST2_REPO2;

	@Override
	public void migrateDataAC_List() {
		List<AC_list> sourceData = aC_LIST_REPO.findAll(); 
		List<AC_LIST2> newData =sourceData.stream().map(this::mapToNewEntity).collect(Collectors.toList());
		aC_LIST2_REPO2.saveAll(newData); } 
		  private AC_LIST2 mapToNewEntity(AC_list source) 
		  { 
			  AC_LIST2 newEntity = new AC_LIST2();
		  newEntity.setCCODE(source.getCCODE());
		  newEntity.setStCode(source.getST_CODE());
		  newEntity.setAC_NO(source.getAC_NO());
		  newEntity.setAcNameEn(source.getAC_NAME_EN());
		  newEntity.setAC_NAME_V1(source.getAC_NAME_V1());
		  newEntity.setAC_NAME_V2(source.getAC_NAME_V2());
		  newEntity.setAC_NAME_V3(source.getAC_NAME_V3());
		  newEntity.setAC_NAME_V4(source.getAC_NAME_V4());
		  newEntity.setAC_NAME_V5(source.getAC_NAME_V5());
		  newEntity.setAC_TYPE(source.getAC_TYPE());
		  newEntity.setEPIC_PREFIX(source.getEPIC_PREFIX());
		  newEntity.setPC_NO(source.getPC_NO());
		  newEntity.setDistNoHdqtr(source.getDIST_NO_HDQTR());
		  newEntity.setUPDATED_DATE(source.getUPDATED_DATE());
		  newEntity.setAC_NAME_HI(source.getAC_NAME_HI());
		 
		  
		  return newEntity;
		  }
		
	}



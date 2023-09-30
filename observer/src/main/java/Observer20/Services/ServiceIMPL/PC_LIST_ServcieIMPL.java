package Observer20.Services.ServiceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Model.PC_LIST2;
import Observer20.Model1.PC_LIST;
import Observer20.Repo1.PC_LIST_REPO;
import Observer20.Services.PC_LIST_Service;
import Observer20.repository.PC_LIST_REPO2;
@Service
public class PC_LIST_ServcieIMPL implements PC_LIST_Service{
	@Autowired
	PC_LIST_REPO pC_LIST_REPO;
	@Autowired
	PC_LIST_REPO2 pC_LIST_REPO2;


	@Override
	public void migrateData_PC_LIST() {
		List<PC_LIST> sourceData = pC_LIST_REPO.findAll(); 
		List<PC_LIST2> newData =sourceData.stream().map(this::mapToNewEntity).collect(Collectors.toList());
		pC_LIST_REPO2.saveAll(newData); } 
		  private PC_LIST2 mapToNewEntity(PC_LIST source) 
		  { 
			  PC_LIST2 newEntity = new PC_LIST2();
		  newEntity.setStCode(source.getST_CODE());
		  newEntity.setPC_NO(source.getPC_NO());
		  newEntity.setPC_NAME_EN(source.getPC_NAME_EN());
		  newEntity.setPC_NAME_V1(source.getPC_NAME_V1());
		  newEntity.setPC_NAME_V2(source.getPC_NAME_V2());
		  newEntity.setPC_NAME_V3(source.getPC_NAME_V3());
		  newEntity.setPC_NAME_V4(source.getPC_NAME_V4());
		  newEntity.setPC_NAME_V5(source.getPC_NAME_V5());
		  newEntity.setPC_TYPE(source.getPC_TYPE());
		  newEntity.setDIST_NO_HDQTR(source.getDIST_NO_HDQTR());
		  newEntity.setPC_NAME_HI(source.getPC_NAME_HI());
		  newEntity.setUPDATED_DATE(source.getUPDATED_DATE());
		  
		  
		  return newEntity;
		  }
}

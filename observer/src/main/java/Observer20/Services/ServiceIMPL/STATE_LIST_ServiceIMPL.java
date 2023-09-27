package Observer20.Services.ServiceIMPL;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Model.STATE_LIST2;
import Observer20.Model1.STATE_LIST;
import Observer20.Repo1.STATE_LIST_REPO;
import Observer20.Services.STATE_LIST_Service;
import Observer20.repository.STATE_LIST2_Repo;
@Service
public class STATE_LIST_ServiceIMPL implements STATE_LIST_Service  {
	@Autowired STATE_LIST2_Repo sTATE_LIST2_Repo;
	  
	  @Autowired STATE_LIST_REPO sTATE_LIST_REPO;
	  

	@Override
	public Optional<STATE_LIST> getSTATELISTById(Long Id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void migrateData() {
		List<STATE_LIST> sourceData = sTATE_LIST_REPO.findAll(); 
		List<STATE_LIST2> newData =sourceData.stream().map(this::mapToNewEntity).collect(Collectors.toList());
		sTATE_LIST2_Repo.saveAll(newData); } 
		  private STATE_LIST2 mapToNewEntity(STATE_LIST source) 
		  { 
			  STATE_LIST2 newEntity = new STATE_LIST2();
		  newEntity.setStCode(source.getST_CODE());
		  newEntity.setStName(source.getST_NAME());
		  newEntity.setST_HNAME(source.getST_HNAME());
		  newEntity.setSHORTNAME(source.getSHORTNAME());
		  newEntity.setST_TYPE(source.getST_TYPE());
		  newEntity.setST_HFOCNAME(source.getST_HFOCNAME());
		  newEntity.setST_NAME_V1(source.getST_NAME_V1());
		  newEntity.setCCODE(source.getCCODE());
		  newEntity.setST_NAME_HI(source.getST_NAME_HI());
		  newEntity.setCURRENT_POLL(source.getCURRENT_POLL());
		  
		  return newEntity;
		  }
		 
	}



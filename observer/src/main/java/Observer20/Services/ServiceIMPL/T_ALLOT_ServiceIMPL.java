package Observer20.Services.ServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Exception.ApiException;
import Observer20.Model.AC_LIST2;
import Observer20.Model.Obs_Allot;
import Observer20.Model.ObserverUser;
import Observer20.Model.STATE_LIST2;
import Observer20.Model1.T_ALLOT_GROUP;
import Observer20.Repo1.T_ALLOT_GROUP_REPO;

import Observer20.Services.T_Allot_Group_Servcie;
import Observer20.repository.AC_LIST2_REPO2;
import Observer20.repository.Obs_AllotREPO;
import Observer20.repository.ObserverUserRepo;
import Observer20.repository.STATE_LIST2_Repo;
@Service
public class T_ALLOT_ServiceIMPL implements T_Allot_Group_Servcie {
	@Autowired
	T_ALLOT_GROUP_REPO t_ALLOT_GROUP_REPO;
	@Autowired
	Obs_AllotREPO obs_AllotREPO;
	@Autowired
	ObserverUserRepo observerUserRepo;
	@Autowired
	STATE_LIST2_Repo sTATE_LIST2_Repo;
	@Autowired
	AC_LIST2_REPO2 aC_LIST2_REPO2;
	
	  @Override 
	  public void migrateT_allot_group_Service() 
	  { List<T_ALLOT_GROUP> sourceData = t_ALLOT_GROUP_REPO.findAll(); 
	  List<Obs_Allot> newData=sourceData.stream().map(this::mapToNewEntity).collect(Collectors.toList());
	  obs_AllotREPO.saveAll(newData); } 
	  private Obs_Allot mapToNewEntity(T_ALLOT_GROUP source) {
	  
		  Obs_Allot newEntity = new Obs_Allot();
	  newEntity.setSt_Code(source.getST_CODE());
	 newEntity.setConst_Group_No(source.getCONST_GROUP_NO());
	  newEntity.setAc_No(source.getCONST_COVERED()); 
	  //newEntity.setObserverUser(source.getOBS_CODE());
	  newEntity.setObscode(source.getOBS_CODE());
	  
	  
	  return newEntity;
	  
	  }
	  @Override
	  public List<Obs_Allot> getObsAllotByObscode(String obsCode) {
	      List<Obs_Allot> obsAllotList = obs_AllotREPO.findAllByObscode(obsCode);
	      
	      if (obsAllotList != null && !obsAllotList.isEmpty()) {
	          List<Obs_Allot> obs_AllotList = new ArrayList<>();
	          
	          for (Obs_Allot obs_Allot : obsAllotList) {
	              Obs_Allot obs_Allot1 = obs_Allot;
	              String stCode = obs_Allot1.getSt_Code();
	              String acNo = obs_Allot1.getAc_No();

	              // Fetch the AC names using the AC_NO and St_Code
	              List<AC_LIST2> acList = aC_LIST2_REPO2.findAllByStCodeAndAcNo(stCode, acNo);
	              StringBuilder acNames = new StringBuilder();

	              if (acList != null && !acList.isEmpty()) {
	                  for (AC_LIST2 ac : acList) {
	                      acNames.append(ac.getAcNameEn()).append(", ");
	                  }
	                  // Remove the trailing comma and space
	                  if (acNames.length() > 0) {
	                      acNames.setLength(acNames.length() - 2);
	                      obs_Allot1.setAc_No(acNames.toString());
	                  } else {
	                      obs_Allot1.setAc_No("AC Name Not Found");
	                  }
	              } else {
	                  obs_Allot1.setAc_No("AC No. Not Found");
	              }

	              // Fetch the state name using the ST_CODE
	              STATE_LIST2 stateList2 = sTATE_LIST2_Repo.findByStCode(stCode);
	              if (stateList2 != null) {
	                  obs_Allot1.setSt_Code(stateList2.getStName());
	              } else {
	                  obs_Allot1.setSt_Code("State Not Found");
	              }
	              
	              // Fetch columns from eci_observers table
	              ObserverUser observerUser = observerUserRepo.findByObscode(obsCode);
	              if (observerUser != null) {
	                  obs_Allot1.setName(observerUser.getName());
	                  obs_Allot1.setService(observerUser.getService());
	              } else {
	                  obs_Allot1.setName("Observer Name Not Found");
	                  obs_Allot1.setService("Service Not Found");
	              }

	              obs_AllotList.add(obs_Allot1);
	          }
	          return obs_AllotList;
	      } else {
	          throw new ApiException("Observer with obscode " + obsCode + " not found.");
	      }
	  }

		
	
		
	}



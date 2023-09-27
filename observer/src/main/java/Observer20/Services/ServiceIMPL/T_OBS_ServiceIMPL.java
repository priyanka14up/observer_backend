package Observer20.Services.ServiceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Model.T_OBS2;
import Observer20.Model1.T_OBS;
import Observer20.Repo1.T_OBSREPO;
import Observer20.Services.T_OBS_Service;
import Observer20.repository.T_OBS2REPO2;
@Service
public class T_OBS_ServiceIMPL implements T_OBS_Service {
	@Autowired
	T_OBSREPO t_OBSREPO;
	@Autowired
	T_OBS2REPO2 t_OBS2REPO2;
	@Override
	public void migrateData_T_OBS() {
		List<T_OBS> sourceData = t_OBSREPO.findAll(); 
		List<T_OBS2> newData =sourceData.stream().map(this::mapToNewEntity).collect(Collectors.toList());
		t_OBS2REPO2.saveAll(newData); } 
		  private T_OBS2 mapToNewEntity(T_OBS source) 
		  { 
			  T_OBS2 newEntity = new T_OBS2();
		  newEntity.setECI_OBSID(source.getECI_OBSID());
		  newEntity.setID_NO(source.getID_NO());
		  newEntity.setOB_TITLE(source.getOB_TITLE());
		  newEntity.setOB_NAME(source.getOB_NAME());
		  newEntity.setOB_SERVICE(source.getOB_SERVICE());
		  newEntity.setOB_CADRE(source.getOB_CADRE());
		  newEntity.setOB_YEAR(source.getOB_YEAR());
		  newEntity.setOB_SEX(source.getOB_SEX());
		  newEntity.setOB_DOB(source.getOB_DOB());
		  newEntity.setOB_STATUS(source.getOB_STATUS());
		  newEntity.setOB_LANG(source.getOB_LANG());
		  newEntity.setOB_DESIG(source.getOB_DESIG());
		  newEntity.setO_ADR_L1(source.getO_ADR_L1());
		  newEntity.setO_CITY(source.getO_CITY());
		  newEntity.setO_STATE(source.getO_STATE());
		  newEntity.setO_PIN(source.getO_PIN());
		  newEntity.setO_STD(source.getO_STD());
		  newEntity.setO_TEL_DRCT(source.getO_TEL_DRCT());
		  newEntity.setO_TEL_PBX(source.getO_TEL_PBX());
		  newEntity.setO_TEL_EXT(source.getO_TEL_EXT());
		  newEntity.setO_FAX(source.getO_FAX());
		  newEntity.setO_EMAIL(source.getO_EMAIL());
		  newEntity.setO_MOBILE(source.getO_MOBILE());
		  newEntity.setR_PIN(source.getR_PIN());
		  newEntity.setR_STD(source.getR_STD());
		  newEntity.setR_TNO(source.getR_TNO());
		  newEntity.setR_FAX(source.getR_FAX());
		  newEntity.setEMG_NAME(source.getEMG_NAME());
		  newEntity.setOB_HM_STAT(source.getOB_HM_STAT());
		  newEntity.setSP_HM_STAT(source.getSP_HM_STAT());
		  newEntity.setSPONSOR(source.getSPONSOR());
		  newEntity.setSPON_OBSID(source.getSPON_OBSID());
		  newEntity.setDELHIBASED(source.getDELHIBASED());
		  newEntity.setSPLOBSERVER(source.getSPLOBSERVER());
		  newEntity.setSPLOBSPLACE(source.getSPLOBSPLACE());
		  newEntity.setOBS_CODE(source.getOBS_CODE());
		  newEntity.setNOMNSTATUS(source.getNOMNSTATUS());
		  newEntity.setDEPSTATUS(source.getDEPSTATUS());
		  newEntity.setBRIEFINGNO(source.getBRIEFINGNO());
		  newEntity.setBRIEFED(source.getBRIEFED());
		  newEntity.setDETAILEDFORMRECVD(source.getDETAILEDFORMRECVD());
		  newEntity.setMOD_DATE(source.getMOD_DATE());
		  newEntity.setAGE(source.getAGE());
		  newEntity.setOB_NODAL_ID(source.getOB_NODAL_ID());
		  newEntity.setOB_CDEP(source.getOB_CDEP());
		  newEntity.setEMG_TEL(source.getEMG_TEL());
		  newEntity.setOB_NA_DFROM(source.getOB_NA_DFROM());
		  newEntity.setOB_NA_DTO(source.getOB_NA_DTO());
		  newEntity.setOB_REMARK(source.getOB_REMARK());
		  newEntity.setOB_BRREMARK(source.getOB_BRREMARK());
		  newEntity.setOB_REQ_STATUS(source.getOB_REQ_STATUS());
		  newEntity.setMOD_BY(source.getMOD_BY());
		  newEntity.setDISPLAY(source.getDISPLAY());
		  newEntity.setCONST_NO(source.getCONST_NO());
		  newEntity.setOB_RATING(source.getOB_RATING());
		  newEntity.setOLDDEPSTATUS(source.getOLDDEPSTATUS());
		  newEntity.setO_MOBILE1(source.getO_MOBILE1());
		  newEntity.setROWID(source.getROWID());
		  newEntity.setCCODE(source.getCCODE());
		  newEntity.setO_AccountNo(source.getO_AccountNo());
		  newEntity.setO_IFCSCode(source.getO_IFCSCode());
		  newEntity.setO_BankName(source.getO_BankName());
		  newEntity.setO_BranchName(source.getO_BranchName());
		  newEntity.setO_AccountHolderName(source.getO_AccountHolderName());
		  newEntity.setO_Amount(source.getO_Amount());
		  newEntity.setSMS_SENT(source.getSMS_SENT());
		  newEntity.setDEPSTATUS_COUNTING(source.getDEPSTATUS_COUNTING());
		  newEntity.setCONST_NO_COUNTING(source.getCONST_NO_COUNTING());
		  newEntity.setAmount_Credited(source.getAmount_Credited());
		  newEntity.setSMS_Amount(source.getSMS_Amount());
		  newEntity.setObserverType(source.getObserverType());
		  newEntity.setOB_FromDate(source.getOB_FromDate());
		  newEntity.setOB_ToDate(source.getOB_ToDate());
		  newEntity.setOB_2ndFromDate(source.getOB_2ndFromDate());
		  newEntity.setOB_2ndToDate(source.getOB_2ndToDate());
		  newEntity.setMobile_ObsDuty(source.getMobile_ObsDuty());
		  newEntity.setSMS_Sent_AccountDetails(source.getSMS_Sent_AccountDetails());
		  newEntity.setOB_image(source.getOB_image());
		  newEntity.setExp_as_RO(source.getExp_as_RO());
		  newEntity.setExp_as_DEO(source.getExp_as_DEO());
		  newEntity.setExp_as_OtherElectionDuty(source.getExp_as_OtherElectionDuty());
		  newEntity.setOB_NewFromDate(source.getOB_NewFromDate());
		  newEntity.setOB_NewToDate(source.getOB_NewToDate());
		  newEntity.setDISPLAY_Counting(source.getDISPLAY_Counting());
		  newEntity.setOBSOTP(source.getOBSOTP());
		  
		  
		  
		  return newEntity;
		  }

}

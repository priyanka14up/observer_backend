package Observer20.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="M_ELECTION_Schedule2")
public class MElectionSchedule2 {
@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	  private Long id;

private String ScheduleID;
private String DT_ISS_NOM; 
private String LDT_IS_NOM; 
private String DT_SCR_NOM; 
private String LDT_WD_CAN; 
private String DATE_POLL;
private String DATE_COUNT; 
private String DTB_EL_COM; 
private String DT_PRESS_ANNC;
private String PHASE_NO;
private String CURRENTELECTION;
private String INSERTION_DATE;
private String OBSREPORTDISP;
private String ElectionID;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getScheduleID() {
	return ScheduleID;
}
public void setScheduleID(String scheduleID) {
	ScheduleID = scheduleID;
}
public String getDT_ISS_NOM() {
	return DT_ISS_NOM;
}
public void setDT_ISS_NOM(String dT_ISS_NOM) {
	DT_ISS_NOM = dT_ISS_NOM;
}
public String getLDT_IS_NOM() {
	return LDT_IS_NOM;
}
public void setLDT_IS_NOM(String lDT_IS_NOM) {
	LDT_IS_NOM = lDT_IS_NOM;
}
public String getDT_SCR_NOM() {
	return DT_SCR_NOM;
}
public void setDT_SCR_NOM(String dT_SCR_NOM) {
	DT_SCR_NOM = dT_SCR_NOM;
}
public String getLDT_WD_CAN() {
	return LDT_WD_CAN;
}
public void setLDT_WD_CAN(String lDT_WD_CAN) {
	LDT_WD_CAN = lDT_WD_CAN;
}
public String getDATE_POLL() {
	return DATE_POLL;
}
public void setDATE_POLL(String dATE_POLL) {
	DATE_POLL = dATE_POLL;
}
public String getDATE_COUNT() {
	return DATE_COUNT;
}
public void setDATE_COUNT(String dATE_COUNT) {
	DATE_COUNT = dATE_COUNT;
}
public String getDTB_EL_COM() {
	return DTB_EL_COM;
}
public void setDTB_EL_COM(String dTB_EL_COM) {
	DTB_EL_COM = dTB_EL_COM;
}
public String getDT_PRESS_ANNC() {
	return DT_PRESS_ANNC;
}
public void setDT_PRESS_ANNC(String dT_PRESS_ANNC) {
	DT_PRESS_ANNC = dT_PRESS_ANNC;
}
public String getPHASE_NO() {
	return PHASE_NO;
}
public void setPHASE_NO(String pHASE_NO) {
	PHASE_NO = pHASE_NO;
}
public String getCURRENTELECTION() {
	return CURRENTELECTION;
}
public void setCURRENTELECTION(String cURRENTELECTION) {
	CURRENTELECTION = cURRENTELECTION;
}
public String getINSERTION_DATE() {
	return INSERTION_DATE;
}
public void setINSERTION_DATE(String iNSERTION_DATE) {
	INSERTION_DATE = iNSERTION_DATE;
}
public String getOBSREPORTDISP() {
	return OBSREPORTDISP;
}
public void setOBSREPORTDISP(String oBSREPORTDISP) {
	OBSREPORTDISP = oBSREPORTDISP;
}
public String getElectionID() {
	return ElectionID;
}
public void setElectionID(String electionID) {
	ElectionID = electionID;
}

}

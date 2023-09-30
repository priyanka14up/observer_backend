package Observer20.Model;

import java.util.Date;

import javax.persistence.Column;
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

private Long scheduleID;
private Date DT_ISS_NOM; 
private Date LDT_IS_NOM; 
private Date DT_SCR_NOM; 
private Date LDT_WD_CAN; 
@Column(name = "DATE_POLL") // Specify the column name if it's different from the property name
private Date datePoll;
private Date DATE_COUNT; 
private Date DTB_EL_COM; 
private Date DT_PRESS_ANNC;
private int PHASE_NO;
private String CURRENTELECTION;
private Date INSERTION_DATE;
private String OBSREPORTDISP;
private String electionID;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getScheduleID() {
	return scheduleID;
}
public void setScheduleID(Long scheduleID) {
	this.scheduleID = scheduleID;
}
public Date getDT_ISS_NOM() {
	return DT_ISS_NOM;
}
public void setDT_ISS_NOM(Date dT_ISS_NOM) {
	DT_ISS_NOM = dT_ISS_NOM;
}
public Date getLDT_IS_NOM() {
	return LDT_IS_NOM;
}
public void setLDT_IS_NOM(Date lDT_IS_NOM) {
	LDT_IS_NOM = lDT_IS_NOM;
}
public Date getDT_SCR_NOM() {
	return DT_SCR_NOM;
}
public void setDT_SCR_NOM(Date dT_SCR_NOM) {
	DT_SCR_NOM = dT_SCR_NOM;
}
public Date getLDT_WD_CAN() {
	return LDT_WD_CAN;
}
public void setLDT_WD_CAN(Date lDT_WD_CAN) {
	LDT_WD_CAN = lDT_WD_CAN;
}
public Date getDatePoll() {
	return datePoll;
}
public void setDatePoll(Date datePoll) {
	this.datePoll = datePoll;
}
public Date getDATE_COUNT() {
	return DATE_COUNT;
}
public void setDATE_COUNT(Date dATE_COUNT) {
	DATE_COUNT = dATE_COUNT;
}
public Date getDTB_EL_COM() {
	return DTB_EL_COM;
}
public void setDTB_EL_COM(Date dTB_EL_COM) {
	DTB_EL_COM = dTB_EL_COM;
}
public Date getDT_PRESS_ANNC() {
	return DT_PRESS_ANNC;
}
public void setDT_PRESS_ANNC(Date dT_PRESS_ANNC) {
	DT_PRESS_ANNC = dT_PRESS_ANNC;
}
public int getPHASE_NO() {
	return PHASE_NO;
}
public void setPHASE_NO(int pHASE_NO) {
	PHASE_NO = pHASE_NO;
}
public String getCURRENTELECTION() {
	return CURRENTELECTION;
}
public void setCURRENTELECTION(String cURRENTELECTION) {
	CURRENTELECTION = cURRENTELECTION;
}
public Date getINSERTION_DATE() {
	return INSERTION_DATE;
}
public void setINSERTION_DATE(Date iNSERTION_DATE) {
	INSERTION_DATE = iNSERTION_DATE;
}
public String getOBSREPORTDISP() {
	return OBSREPORTDISP;
}
public void setOBSREPORTDISP(String oBSREPORTDISP) {
	OBSREPORTDISP = oBSREPORTDISP;
}
public String getElectionID() {
	return electionID;
}
public void setElectionID(String electionID) {
	this.electionID = electionID;
}


}
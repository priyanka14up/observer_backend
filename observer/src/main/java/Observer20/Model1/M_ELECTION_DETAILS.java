
  package Observer20.Model1;
  
  import javax.persistence.Column;
import javax.persistence.Entity; import javax.persistence.Id;
  
@Entity
  public class M_ELECTION_DETAILS {
  
  @Id 
  private String CCODE;
  private Long ScheduleID;
  private String CONST_NO; 
  private String CONST_TYPE; 
  private String DELIM_TYPE; 
  private String ELECTION_TYPE; 
  private String ST_CODE;
  private String INSERTION_DATE; 
  private String VotesReg_49O; 
  private int StatePHASE_NO;
  private int PHASE_NO;
 
  private String AdjournedPoll;
public String getCCODE() {
	return CCODE;
}
public void setCCODE(String cCODE) {
	CCODE = cCODE;
}

public Long getScheduleID() {
	return ScheduleID;
}
public void setScheduleID(Long scheduleID) {
	ScheduleID = scheduleID;
}
public String getCONST_NO() {
	return CONST_NO;
}
public void setCONST_NO(String cONST_NO) {
	CONST_NO = cONST_NO;
}
public String getCONST_TYPE() {
	return CONST_TYPE;
}
public void setCONST_TYPE(String cONST_TYPE) {
	CONST_TYPE = cONST_TYPE;
}
public String getDELIM_TYPE() {
	return DELIM_TYPE;
}
public void setDELIM_TYPE(String dELIM_TYPE) {
	DELIM_TYPE = dELIM_TYPE;
}
public String getELECTION_TYPE() {
	return ELECTION_TYPE;
}
public void setELECTION_TYPE(String eLECTION_TYPE) {
	ELECTION_TYPE = eLECTION_TYPE;
}
public String getST_CODE() {
	return ST_CODE;
}
public void setST_CODE(String sT_CODE) {
	ST_CODE = sT_CODE;
}
public String getINSERTION_DATE() {
	return INSERTION_DATE;
}
public void setINSERTION_DATE(String iNSERTION_DATE) {
	INSERTION_DATE = iNSERTION_DATE;
}
public String getVotesReg_49O() {
	return VotesReg_49O;
}
public void setVotesReg_49O(String votesReg_49O) {
	VotesReg_49O = votesReg_49O;
}
public int getStatePHASE_NO() {
	return StatePHASE_NO;
}
public void setStatePHASE_NO(int statePHASE_NO) {
	StatePHASE_NO = statePHASE_NO;
}
public int getPHASE_NO() {
	return PHASE_NO;
}
public void setPHASE_NO(int pHASE_NO) {
	PHASE_NO = pHASE_NO;
}
public String getAdjournedPoll() {
	return AdjournedPoll;
}
public void setAdjournedPoll(String adjournedPoll) {
	AdjournedPoll = adjournedPoll;
}



  
  }
 
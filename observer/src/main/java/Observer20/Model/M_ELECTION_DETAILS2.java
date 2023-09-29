package Observer20.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="M_ELECTION_DETAILS2")
public class M_ELECTION_DETAILS2 {
@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	  private Long id;
	  private String CCODE;
	  private String ScheduleID;
	  private String CONST_NO; 
	  private String CONST_TYPE; 
	  private String DELIM_TYPE; 
	  private String ELECTION_TYPE; 
	  private String ST_CODE;
	  private String INSERTION_DATE; 
	  private String VotesReg_49O; 
	  private String StatePHASE_NO;
	  private String PHASE_NO;
	  private String AdjournedPol;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCCODE() {
		return CCODE;
	}
	public void setCCODE(String cCODE) {
		CCODE = cCODE;
	}
	public String getScheduleID() {
		return ScheduleID;
	}
	public void setScheduleID(String scheduleID) {
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
	public String getStatePHASE_NO() {
		return StatePHASE_NO;
	}
	public void setStatePHASE_NO(String statePHASE_NO) {
		StatePHASE_NO = statePHASE_NO;
	}
	public String getPHASE_NO() {
		return PHASE_NO;
	}
	public void setPHASE_NO(String pHASE_NO) {
		PHASE_NO = pHASE_NO;
	}
	public String getAdjournedPol() {
		return AdjournedPol;
	}
	public void setAdjournedPol(String adjournedPol) {
		AdjournedPol = adjournedPol;
	}
	  

}

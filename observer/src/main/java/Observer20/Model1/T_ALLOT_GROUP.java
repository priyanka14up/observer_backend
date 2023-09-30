
  package Observer20.Model1;
  
 
import javax.persistence.Entity;
import javax.persistence.Id;

import Observer20.Model.ObserverUser;

  
  @Entity
  public class T_ALLOT_GROUP
  {
	  private String ST_CODE; 
	  private String CONST_GROUP_NO;
	  private String GROUP_TYPE;
	  private String CONST_COVERED;
      private String SCHEDULENO;
      
      private String OBS_CODE; 
  @Id
  private String CCODE;
  private int StatePhaseNo;
  private String CURRENTELECTION; 
  private Long SCHEDULEID;
  private String AdjournedPoll; 
  
  
public T_ALLOT_GROUP(String sT_CODE, String cONST_GROUP_NO, String gROUP_TYPE, String cONST_COVERED, String sCHEDULENO,
		String oBS_CODE, String cCODE, int statePhaseNo, String cURRENTELECTION, Long sCHEDULEID,
		String adjournedPoll) {
	super();
	ST_CODE = sT_CODE;
	CONST_GROUP_NO = cONST_GROUP_NO;
	GROUP_TYPE = gROUP_TYPE;
	CONST_COVERED = cONST_COVERED;
	SCHEDULENO = sCHEDULENO;
	OBS_CODE = oBS_CODE;
	CCODE = cCODE;
	StatePhaseNo = statePhaseNo;
	CURRENTELECTION = cURRENTELECTION;
	SCHEDULEID = sCHEDULEID;
	AdjournedPoll = adjournedPoll;
}


public String getST_CODE() {
	return ST_CODE;
}


public void setST_CODE(String sT_CODE) {
	ST_CODE = sT_CODE;
}


public String getCONST_GROUP_NO() {
	return CONST_GROUP_NO;
}


public void setCONST_GROUP_NO(String cONST_GROUP_NO) {
	CONST_GROUP_NO = cONST_GROUP_NO;
}


public String getGROUP_TYPE() {
	return GROUP_TYPE;
}


public void setGROUP_TYPE(String gROUP_TYPE) {
	GROUP_TYPE = gROUP_TYPE;
}


public String getCONST_COVERED() {
	return CONST_COVERED;
}


public void setCONST_COVERED(String cONST_COVERED) {
	CONST_COVERED = cONST_COVERED;
}


public String getSCHEDULENO() {
	return SCHEDULENO;
}


public void setSCHEDULENO(String sCHEDULENO) {
	SCHEDULENO = sCHEDULENO;
}





public String getOBS_CODE() {
	return OBS_CODE;
}


public void setOBS_CODE(String oBS_CODE) {
	OBS_CODE = oBS_CODE;
}


public String getCCODE() {
	return CCODE;
}


public void setCCODE(String cCODE) {
	CCODE = cCODE;
}


public int getStatePhaseNo() {
	return StatePhaseNo;
}


public void setStatePhaseNo(int statePhaseNo) {
	StatePhaseNo = statePhaseNo;
}


public String getCURRENTELECTION() {
	return CURRENTELECTION;
}


public void setCURRENTELECTION(String cURRENTELECTION) {
	CURRENTELECTION = cURRENTELECTION;
}


public Long getSCHEDULEID() {
	return SCHEDULEID;
}


public void setSCHEDULEID(Long sCHEDULEID) {
	SCHEDULEID = sCHEDULEID;
}


public String getAdjournedPoll() {
	return AdjournedPoll;
}


public void setAdjournedPoll(String adjournedPoll) {
	AdjournedPoll = adjournedPoll;
}



@Override
public String toString() {
	return "T_ALLOT_GROUP [ST_CODE=" + ST_CODE + ", CONST_GROUP_NO=" + CONST_GROUP_NO + ", GROUP_TYPE=" + GROUP_TYPE
			+ ", CONST_COVERED=" + CONST_COVERED + ", SCHEDULENO=" + SCHEDULENO + ", OBS_CODE=" + OBS_CODE + ", CCODE="
			+ CCODE + ", StatePhaseNo=" + StatePhaseNo + ", CURRENTELECTION=" + CURRENTELECTION + ", SCHEDULEID="
			+ SCHEDULEID + ", AdjournedPoll=" + AdjournedPoll + "]";
}


public T_ALLOT_GROUP() {
	
  
}
  }
 
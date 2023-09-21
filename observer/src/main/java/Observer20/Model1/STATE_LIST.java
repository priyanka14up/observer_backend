package Observer20.Model1;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class STATE_LIST {
	@Id
	private String ST_CODE;
	private String ST_NAME;
	private String ST_HNAME;
	private String SHORTNAME;
	private String ST_TYPE;
	private String ST_HFOCNAME;
	private String ST_NAME_V1;
	private String CCODE;
	private String ST_NAME_HI;
	private String CURRENT_POLL;
	public String getST_CODE() {
		return ST_CODE;
	}
	public void setST_CODE(String sT_CODE) {
		ST_CODE = sT_CODE;
	}
	public String getST_NAME() {
		return ST_NAME;
	}
	public void setST_NAME(String sT_NAME) {
		ST_NAME = sT_NAME;
	}
	public String getST_HNAME() {
		return ST_HNAME;
	}
	public void setST_HNAME(String sT_HNAME) {
		ST_HNAME = sT_HNAME;
	}
	public String getSHORTNAME() {
		return SHORTNAME;
	}
	public void setSHORTNAME(String sHORTNAME) {
		SHORTNAME = sHORTNAME;
	}
	public String getST_TYPE() {
		return ST_TYPE;
	}
	public void setST_TYPE(String sT_TYPE) {
		ST_TYPE = sT_TYPE;
	}
	public String getST_HFOCNAME() {
		return ST_HFOCNAME;
	}
	public void setST_HFOCNAME(String sT_HFOCNAME) {
		ST_HFOCNAME = sT_HFOCNAME;
	}
	public String getST_NAME_V1() {
		return ST_NAME_V1;
	}
	public void setST_NAME_V1(String sT_NAME_V1) {
		ST_NAME_V1 = sT_NAME_V1;
	}
	public String getCCODE() {
		return CCODE;
	}
	public void setCCODE(String cCODE) {
		CCODE = cCODE;
	}
	public String getST_NAME_HI() {
		return ST_NAME_HI;
	}
	public void setST_NAME_HI(String sT_NAME_HI) {
		ST_NAME_HI = sT_NAME_HI;
	}
	public String getCURRENT_POLL() {
		return CURRENT_POLL;
	}
	public void setCURRENT_POLL(String cURRENT_POLL) {
		CURRENT_POLL = cURRENT_POLL;
	}
	
	
	 
	 

}

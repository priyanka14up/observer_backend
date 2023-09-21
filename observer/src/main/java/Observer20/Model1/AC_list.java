package Observer20.Model1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AC_list {
	@Id
	private String CCODE;
	private String ST_CODE;
	private String AC_NO;
	private String AC_NAME_EN;
	private String AC_NAME_V1;
	private String AC_NAME_V2;
	private String AC_NAME_V3;
	private String AC_NAME_V4;
	private String AC_NAME_V5;
	private String AC_TYPE;
	private String EPIC_PREFIX;
	private String PC_NO;
	private String DIST_NO_HDQTR;
	private String UPDATED_DATE;
	private String AC_NAME_HI;
	public String getCCODE() {
		return CCODE;
	}
	public void setCCODE(String cCODE) {
		CCODE = cCODE;
	}
	public String getST_CODE() {
		return ST_CODE;
	}
	public void setST_CODE(String sT_CODE) {
		ST_CODE = sT_CODE;
	}
	public String getAC_NO() {
		return AC_NO;
	}
	public void setAC_NO(String aC_NO) {
		AC_NO = aC_NO;
	}
	public String getAC_NAME_EN() {
		return AC_NAME_EN;
	}
	public void setAC_NAME_EN(String aC_NAME_EN) {
		AC_NAME_EN = aC_NAME_EN;
	}
	public String getAC_NAME_V1() {
		return AC_NAME_V1;
	}
	public void setAC_NAME_V1(String aC_NAME_V1) {
		AC_NAME_V1 = aC_NAME_V1;
	}
	public String getAC_NAME_V2() {
		return AC_NAME_V2;
	}
	public void setAC_NAME_V2(String aC_NAME_V2) {
		AC_NAME_V2 = aC_NAME_V2;
	}
	public String getAC_NAME_V3() {
		return AC_NAME_V3;
	}
	public void setAC_NAME_V3(String aC_NAME_V3) {
		AC_NAME_V3 = aC_NAME_V3;
	}
	public String getAC_NAME_V4() {
		return AC_NAME_V4;
	}
	public void setAC_NAME_V4(String aC_NAME_V4) {
		AC_NAME_V4 = aC_NAME_V4;
	}
	public String getAC_NAME_V5() {
		return AC_NAME_V5;
	}
	public void setAC_NAME_V5(String aC_NAME_V5) {
		AC_NAME_V5 = aC_NAME_V5;
	}
	public String getAC_TYPE() {
		return AC_TYPE;
	}
	public void setAC_TYPE(String aC_TYPE) {
		AC_TYPE = aC_TYPE;
	}
	public String getEPIC_PREFIX() {
		return EPIC_PREFIX;
	}
	public void setEPIC_PREFIX(String ePIC_PREFIX) {
		EPIC_PREFIX = ePIC_PREFIX;
	}
	public String getPC_NO() {
		return PC_NO;
	}
	public void setPC_NO(String pC_NO) {
		PC_NO = pC_NO;
	}
	public String getDIST_NO_HDQTR() {
		return DIST_NO_HDQTR;
	}
	public void setDIST_NO_HDQTR(String dIST_NO_HDQTR) {
		DIST_NO_HDQTR = dIST_NO_HDQTR;
	}
	public String getUPDATED_DATE() {
		return UPDATED_DATE;
	}
	public void setUPDATED_DATE(String uPDATED_DATE) {
		UPDATED_DATE = uPDATED_DATE;
	}
	public String getAC_NAME_HI() {
		return AC_NAME_HI;
	}
	public void setAC_NAME_HI(String aC_NAME_HI) {
		AC_NAME_HI = aC_NAME_HI;
	}
	

}

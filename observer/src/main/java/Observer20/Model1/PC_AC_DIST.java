package Observer20.Model1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PC_AC_DIST {
	@Id
	private String ST_CODE;
	private String ST_NAME;
	private String PC_NO;
	private String PC_NAME;
	private String PC_TYPE;
	private String AC_NO;
	private String AC_NAME;
	private String AC_TYPE;
	private String DIST_NO;
	private String DIST_NAME;
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
	public String getPC_NO() {
		return PC_NO;
	}
	public void setPC_NO(String pC_NO) {
		PC_NO = pC_NO;
	}
	public String getPC_NAME() {
		return PC_NAME;
	}
	public void setPC_NAME(String pC_NAME) {
		PC_NAME = pC_NAME;
	}
	public String getPC_TYPE() {
		return PC_TYPE;
	}
	public void setPC_TYPE(String pC_TYPE) {
		PC_TYPE = pC_TYPE;
	}
	public String getAC_NO() {
		return AC_NO;
	}
	public void setAC_NO(String aC_NO) {
		AC_NO = aC_NO;
	}
	public String getAC_NAME() {
		return AC_NAME;
	}
	public void setAC_NAME(String aC_NAME) {
		AC_NAME = aC_NAME;
	}
	public String getAC_TYPE() {
		return AC_TYPE;
	}
	public void setAC_TYPE(String aC_TYPE) {
		AC_TYPE = aC_TYPE;
	}
	public String getDIST_NO() {
		return DIST_NO;
	}
	public void setDIST_NO(String dIST_NO) {
		DIST_NO = dIST_NO;
	}
	public String getDIST_NAME() {
		return DIST_NAME;
	}
	public void setDIST_NAME(String dIST_NAME) {
		DIST_NAME = dIST_NAME;
	}
	
	

}
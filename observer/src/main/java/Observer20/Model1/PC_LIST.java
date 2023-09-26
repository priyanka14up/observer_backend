package Observer20.Model1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PC_LIST {
	@Id
	private String ST_CODE;
	private String PC_NO;
	private String PC_NAME_EN;
	private String PC_NAME_V1;
	private String PC_NAME_V2;
	private String PC_NAME_V3;
	private String PC_NAME_V4;
	private String PC_NAME_V5;
	private String PC_TYPE;
	private String DIST_NO_HDQTR;
	private String PC_NAME_HI;
	private String UPDATED_DATE;
	public String getST_CODE() {
		return ST_CODE;
	}
	public void setST_CODE(String sT_CODE) {
		ST_CODE = sT_CODE;
	}
	public String getPC_NO() {
		return PC_NO;
	}
	public void setPC_NO(String pC_NO) {
		PC_NO = pC_NO;
	}
	public String getPC_NAME_EN() {
		return PC_NAME_EN;
	}
	public void setPC_NAME_EN(String pC_NAME_EN) {
		PC_NAME_EN = pC_NAME_EN;
	}
	public String getPC_NAME_V1() {
		return PC_NAME_V1;
	}
	public void setPC_NAME_V1(String pC_NAME_V1) {
		PC_NAME_V1 = pC_NAME_V1;
	}
	public String getPC_NAME_V2() {
		return PC_NAME_V2;
	}
	public void setPC_NAME_V2(String pC_NAME_V2) {
		PC_NAME_V2 = pC_NAME_V2;
	}
	public String getPC_NAME_V3() {
		return PC_NAME_V3;
	}
	public void setPC_NAME_V3(String pC_NAME_V3) {
		PC_NAME_V3 = pC_NAME_V3;
	}
	public String getPC_NAME_V4() {
		return PC_NAME_V4;
	}
	public void setPC_NAME_V4(String pC_NAME_V4) {
		PC_NAME_V4 = pC_NAME_V4;
	}
	public String getPC_NAME_V5() {
		return PC_NAME_V5;
	}
	public void setPC_NAME_V5(String pC_NAME_V5) {
		PC_NAME_V5 = pC_NAME_V5;
	}
	public String getPC_TYPE() {
		return PC_TYPE;
	}
	public void setPC_TYPE(String pC_TYPE) {
		PC_TYPE = pC_TYPE;
	}
	public String getDIST_NO_HDQTR() {
		return DIST_NO_HDQTR;
	}
	public void setDIST_NO_HDQTR(String dIST_NO_HDQTR) {
		DIST_NO_HDQTR = dIST_NO_HDQTR;
	}
	public String getPC_NAME_HI() {
		return PC_NAME_HI;
	}
	public void setPC_NAME_HI(String pC_NAME_HI) {
		PC_NAME_HI = pC_NAME_HI;
	}
	public String getUPDATED_DATE() {
		return UPDATED_DATE;
	}
	public void setUPDATED_DATE(String uPDATED_DATE) {
		UPDATED_DATE = uPDATED_DATE;
	}
	

}

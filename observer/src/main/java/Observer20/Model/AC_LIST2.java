package Observer20.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="M_AC_LIST")
@Component
public class AC_LIST2 {
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	private Long id;
	private String CCODE;
	//private String ST_CODE;
	@Column(name = "ST_CODE")
    private String stCode;
    
	//private String AC_NO;
	@Column(name = "AC_NO")
    private String acNo;
	@Column(name = "AC_NAME_EN")
	private String acNameEn;
	private String AC_NAME_V1;
	private String AC_NAME_V2;
	private String AC_NAME_V3;
	private String AC_NAME_V4;
	private String AC_NAME_V5;
	private String AC_TYPE;
	private String EPIC_PREFIX;
	private String PC_NO;
	
	@Column(name = "DIST_NO_HDQTR")
	private String distNoHdqtr;
	private String UPDATED_DATE;
	private String AC_NAME_HI;
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
	
	public String getStCode() {
		return stCode;
	}
	public void setStCode(String stCode) {
		this.stCode = stCode;
	}
	
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}

	
	  public String getAC_NO() { return getAC_NO(); } public void setAC_NO(String
	  aC_NO) { acNo = aC_NO; }
	  
	 
		public String getAcNameEn() {
		return acNameEn;
	}
	public void setAcNameEn(String acNameEn) {
		this.acNameEn = acNameEn;
	}
	/*
		 * public String getAC_NAME_EN() { return AC_NAME_EN; } public void
		 * setAC_NAME_EN(String aC_NAME_EN) { AC_NAME_EN = aC_NAME_EN; }
		 */
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
	
	
	
	
	public String getDistNoHdqtr() {
		return distNoHdqtr;
	}
	public void setDistNoHdqtr(String distNoHdqtr) {
		this.distNoHdqtr = distNoHdqtr;
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

package Observer20.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="M_DIST_LIST")
public class DIST_LIST2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	private Long id;
	private String CCODE;
	private String ST_CODE;
	private String DIST_NO;
	private String DIST_NAME_EN;
	private String DIST_NAME_V1;
	private String DIST_NAME_V2;
	private String DIST_NAME_V3;
	private String DIST_NAME_V4;
	private String DIST_NAME_V5;
	private String DIVISION_NO;
	private String DIST_NO_REV;
	private String DIST_NAME_HI;
	private String Last_Updated;
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
	public String getST_CODE() {
		return ST_CODE;
	}
	public void setST_CODE(String sT_CODE) {
		ST_CODE = sT_CODE;
	}
	public String getDIST_NO() {
		return DIST_NO;
	}
	public void setDIST_NO(String dIST_NO) {
		DIST_NO = dIST_NO;
	}
	public String getDIST_NAME_EN() {
		return DIST_NAME_EN;
	}
	public void setDIST_NAME_EN(String dIST_NAME_EN) {
		DIST_NAME_EN = dIST_NAME_EN;
	}
	public String getDIST_NAME_V1() {
		return DIST_NAME_V1;
	}
	public void setDIST_NAME_V1(String dIST_NAME_V1) {
		DIST_NAME_V1 = dIST_NAME_V1;
	}
	public String getDIST_NAME_V2() {
		return DIST_NAME_V2;
	}
	public void setDIST_NAME_V2(String dIST_NAME_V2) {
		DIST_NAME_V2 = dIST_NAME_V2;
	}
	public String getDIST_NAME_V3() {
		return DIST_NAME_V3;
	}
	public void setDIST_NAME_V3(String dIST_NAME_V3) {
		DIST_NAME_V3 = dIST_NAME_V3;
	}
	public String getDIST_NAME_V4() {
		return DIST_NAME_V4;
	}
	public void setDIST_NAME_V4(String dIST_NAME_V4) {
		DIST_NAME_V4 = dIST_NAME_V4;
	}
	public String getDIST_NAME_V5() {
		return DIST_NAME_V5;
	}
	public void setDIST_NAME_V5(String dIST_NAME_V5) {
		DIST_NAME_V5 = dIST_NAME_V5;
	}
	public String getDIVISION_NO() {
		return DIVISION_NO;
	}
	public void setDIVISION_NO(String dIVISION_NO) {
		DIVISION_NO = dIVISION_NO;
	}
	public String getDIST_NO_REV() {
		return DIST_NO_REV;
	}
	public void setDIST_NO_REV(String dIST_NO_REV) {
		DIST_NO_REV = dIST_NO_REV;
	}
	public String getDIST_NAME_HI() {
		return DIST_NAME_HI;
	}
	public void setDIST_NAME_HI(String dIST_NAME_HI) {
		DIST_NAME_HI = dIST_NAME_HI;
	}
	public String getLast_Updated() {
		return Last_Updated;
	}
	public void setLast_Updated(String last_Updated) {
		Last_Updated = last_Updated;
	}
	

}

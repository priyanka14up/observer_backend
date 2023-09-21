package Observer20.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "M_STATE_LIST")
public class STATE_LIST2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	private Long id;
	//private String ST_CODE;
	//private String ST_NAME;
	@Column(name = "ST_CODE")
    private String stCode;
    
    @Column(name = "ST_NAME")
    private String stName;
	private String ST_HNAME;
	private String SHORTNAME;
	private String ST_TYPE;
	private String ST_HFOCNAME;
	private String ST_NAME_V1;
	private String CCODE;
	private String ST_NAME_HI;
	private String CURRENT_POLL;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStCode() {
		return stCode;
	}
	public void setStCode(String stCode) {
		this.stCode = stCode;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
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
	public STATE_LIST2 orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

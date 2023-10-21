package Observer20.payloads;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

public class ObsAllotDTO {
	private String acNo;
	private String acName;
	private String distNo;
    private String distName;
    private String stCode;
    private String stName;
   // private Date datePoll;
   // private String constType;
    //private String electionType;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //private Date OBFromDate;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //private Date OBToDate;
    private Long scheduleID;
    private String obscode;
    private String name;
    private String email;
    private long mobnum;
    private String O_FAX;
    private String constMob;
    private String constTelNo;
    private String constFaxNo;
    private String LocalAdress;
    private String LocalMobile;
    private String whetherObName;
    private String localAdressMobile;
    
    
    
  
	public String getLocalAdressMobile() {
		return localAdressMobile;
	}
	public void setLocalAdressMobile(String localAdressMobile) {
		this.localAdressMobile = localAdressMobile;
	}
	
	public String getWhetherObName() {
		return whetherObName;
	}
	public void setWhetherObName(String whetherObName) {
		this.whetherObName = whetherObName;
	}
	public String getConstMob() {
		return constMob;
	}
	public void setConstMob(String constMob) {
		this.constMob = constMob;
	}
	public String getConstTelNo() {
		return constTelNo;
	}
	public void setConstTelNo(String constTelNo) {
		this.constTelNo = constTelNo;
	}
	
	
    
    
    
    
    
    
    
    
	public String getConstFaxNo() {
		return constFaxNo;
	}
	public void setConstFaxNo(String constFaxNo) {
		this.constFaxNo = constFaxNo;
	}
	public long getMobnum() {
		return mobnum;
	}
	public void setMobnum(long mobnum) {
		this.mobnum = mobnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getO_FAX() {
		return O_FAX;
	}
	public void setO_FAX(String o_FAX) {
		O_FAX = o_FAX;
	}
	public String getObscode() {
		return obscode;
	}
	public void setObscode(String obscode) {
		this.obscode = obscode;
	}
	public Long getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(Long scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}
	public String getAcName() {
		return acName;
	}
	public void setAcName(String acName) {
		this.acName = acName;
	}
	public String getDistNo() {
		return distNo;
	}
	public void setDistNo(String distNo) {
		this.distNo = distNo;
	}
	public String getDistName() {
		return distName;
	}
	public void setDistName(String distName) {
		this.distName = distName;
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
	
   

}

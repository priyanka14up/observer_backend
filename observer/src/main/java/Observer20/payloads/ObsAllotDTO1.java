package Observer20.payloads;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ObsAllotDTO1 {
	private String acNo;
	private String acName;
	private String distNo;
    private String distName;
    private String stCode;
    private String stName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date OBFromDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date OBToDate;
     //private Date datePoll;
     //private String constType;
     //private String electionType;
     private String OB_image;
     private String name;
	    private String service;
	    private String role;
	    private String obscode;
	    
	    
	    
		public String getObscode() {
			return obscode;
		}
		public void setObscode(String obscode) {
			this.obscode = obscode;
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
		public Date getOBFromDate() {
			return OBFromDate;
		}
		public void setOBFromDate(Date oBFromDate) {
			OBFromDate = oBFromDate;
		}
		public Date getOBToDate() {
			return OBToDate;
		}
		public void setOBToDate(Date oBToDate) {
			OBToDate = oBToDate;
		}
		
		public String getOB_image() {
			return OB_image;
		}
		public void setOB_image(String oB_image) {
			OB_image = oB_image;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getService() {
			return service;
		}
		public void setService(String service) {
			this.service = service;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	    
	    
	    
	    
	    
}

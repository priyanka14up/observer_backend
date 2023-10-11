package Observer20.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Obs_Allot {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 private String St_Code;
	    private String Const_Group_No;
	    private String Ac_No;
	    private String obscode;
	    private String role;
	    private Date OBFromDate;
	    private Date OBToDate;
	    private String name;
	    private String service;
	    private String PC_NAME;
	    private String DIST_NAME;
	   private int statePhaseNo;
	   //private int statePhaseNo = 0;
	    private String CURRENTELECTION;
	    private Long scheduleID;
	    private String GROUP_TYPE;
	    private String SCHEDULENO;
	    private String AdjournedPoll;
	    private String OB_image;
	    
	    
		public String getOB_image() {
			return OB_image;
		}
		public void setOB_image(String oB_image) {
			OB_image = oB_image;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getSt_Code() {
			return St_Code;
		}
		public void setSt_Code(String st_Code) {
			St_Code = st_Code;
		}
		public String getConst_Group_No() {
			return Const_Group_No;
		}
		public void setConst_Group_No(String const_Group_No) {
			Const_Group_No = const_Group_No;
		}
		public String getAc_No() {
			return Ac_No;
		}
		public void setAc_No(String ac_No) {
			Ac_No = ac_No;
		}
		
		public String getObscode() {
			return obscode;
		}
		public void setObscode(String obscode) {
			this.obscode = obscode;
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
		
		
		
		public String getPC_NAME() {
			return PC_NAME;
		}
		public void setPC_NAME(String pC_NAME) {
			PC_NAME = pC_NAME;
		}
		
		public String getDIST_NAME() {
			return DIST_NAME;
		}
		public void setDIST_NAME(String dIST_NAME) {
			DIST_NAME = dIST_NAME;
		}
		
		
		
		public int getStatePhaseNo() {
			return statePhaseNo;
		}
		public void setStatePhaseNo(int statePhaseNo) {
			this.statePhaseNo = statePhaseNo;
		}
		public String getCURRENTELECTION() {
			return CURRENTELECTION;
		}
		public void setCURRENTELECTION(String cURRENTELECTION) {
			CURRENTELECTION = cURRENTELECTION;
		}
	
		
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public Long getScheduleID() {
			return scheduleID;
		}
		public void setScheduleID(Long scheduleID) {
			this.scheduleID = scheduleID;
		}
		
		
		public String getGROUP_TYPE() {
			return GROUP_TYPE;
		}
		public void setGROUP_TYPE(String gROUP_TYPE) {
			GROUP_TYPE = gROUP_TYPE;
		}
		public String getSCHEDULENO() {
			return SCHEDULENO;
		}
		public void setSCHEDULENO(String sCHEDULENO) {
			SCHEDULENO = sCHEDULENO;
		}
		public String getAdjournedPoll() {
			return AdjournedPoll;
		}
		public void setAdjournedPoll(String adjournedPoll) {
			AdjournedPoll = adjournedPoll;
		}
		@Override
		public String toString() {
			return "Obs_Allot [id=" + id + ", St_Code=" + St_Code + ", Const_Group_No=" + Const_Group_No + ", Ac_No="
					+ Ac_No + ", obscode=" + obscode + ", role=" + role + ", OBFromDate=" + OBFromDate + ", OBToDate="
					+ OBToDate + ", name=" + name + ", service=" + service + ", PC_NAME=" + PC_NAME + ", DIST_NAME="
					+ DIST_NAME + ", statePhaseNo=" + statePhaseNo + ", CURRENTELECTION=" + CURRENTELECTION
					+ ", scheduleID=" + scheduleID + ", GROUP_TYPE=" + GROUP_TYPE + ", SCHEDULENO=" + SCHEDULENO
					+ ", AdjournedPoll=" + AdjournedPoll + "]";
		}
		
		
		
		public Obs_Allot(Long id, String st_Code, String const_Group_No, String ac_No, String obscode, String role,
				Date oBFromDate, Date oBToDate, String name, String service, String pC_NAME, String dIST_NAME,
				int statePhaseNo, String cURRENTELECTION, Long scheduleID, String gROUP_TYPE, String sCHEDULENO,
				String adjournedPoll) {
			super();
			this.id = id;
			St_Code = st_Code;
			Const_Group_No = const_Group_No;
			Ac_No = ac_No;
			this.obscode = obscode;
			this.role = role;
			OBFromDate = oBFromDate;
			OBToDate = oBToDate;
			this.name = name;
			this.service = service;
			PC_NAME = pC_NAME;
			DIST_NAME = dIST_NAME;
			this.statePhaseNo = statePhaseNo;
			CURRENTELECTION = cURRENTELECTION;
			this.scheduleID = scheduleID;
			GROUP_TYPE = gROUP_TYPE;
			SCHEDULENO = sCHEDULENO;
			AdjournedPoll = adjournedPoll;
		}
		public Obs_Allot() {
			super();
			// TODO Auto-generated constructor stub
		}
	    

}

package Observer20.Model;

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
	    private String Ob_From_Date;
	    private String Ob_To_Date;
	    private String name;
	    private String service;
	    private String PC_NAME;
	    private String DIST_NAME;
	    private int statePhaseNo;
	    private String CURRENTELECTION;
	    private Long scheduleID;
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
		public String getOb_From_Date() {
			return Ob_From_Date;
		}
		public void setOb_From_Date(String ob_From_Date) {
			Ob_From_Date = ob_From_Date;
		}
		public String getOb_To_Date() {
			return Ob_To_Date;
		}
		public void setOb_To_Date(String ob_To_Date) {
			Ob_To_Date = ob_To_Date;
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
			statePhaseNo = statePhaseNo;
		}
		public String getCURRENTELECTION() {
			return CURRENTELECTION;
		}
		public void setCURRENTELECTION(String cURRENTELECTION) {
			CURRENTELECTION = cURRENTELECTION;
		}
		public Long getSCHEDULEID() {
			return scheduleID;
		}
		public void setSCHEDULEID(Long sCHEDULEID) {
			scheduleID = sCHEDULEID;
		}
		@Override
		public String toString() {
			return "Obs_Allot [id=" + id + ", St_Code=" + St_Code + ", Const_Group_No=" + Const_Group_No + ", Ac_No="
					+ Ac_No + ", obs_code=" + obscode + ", Ob_From_Date=" + Ob_From_Date + ", Ob_To_Date=" + Ob_To_Date
					+ "]";
		}
		public Obs_Allot(Long id, String st_Code, String const_Group_No, String ac_No, String obs_code,
				String ob_From_Date, String ob_To_Date) {
			super();
			this.id = id;
			St_Code = st_Code;
			Const_Group_No = const_Group_No;
			Ac_No = ac_No;
			this.obscode = obs_code;
			Ob_From_Date = ob_From_Date;
			Ob_To_Date = ob_To_Date;
		}
		public Obs_Allot() {
			super();
			// TODO Auto-generated constructor stub
		}
	    

}

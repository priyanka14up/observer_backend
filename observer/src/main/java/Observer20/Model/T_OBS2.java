package Observer20.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Migrate_TOBS")
public class T_OBS2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	private Long id;
	private String ECI_OBSID;
    private String ID_NO;
    private String OB_TITLE;
    private String OB_NAME;
    private String OB_SERVICE;
    private String OB_CADRE;
    private String OB_YEAR;
    private String OB_SEX;
    private String OB_DOB;
    private String OB_STATUS;
    private String OB_LANG;
    private String OB_DESIG;
    private String O_ADR_L1;
    private String O_CITY;
    private String O_STATE;
    private String O_PIN;
    private String O_STD;
    private String O_TEL_DRCT;
    private String O_TEL_PBX;
    private String O_TEL_EXT;
    private String O_FAX;
    private String O_EMAIL;
    private String O_MOBILE;
    private String R_PIN;
    private String R_STD;
    private String R_TNO;
    private String R_FAX;
    private String EMG_NAME;
    private String OB_HM_STAT;
    private String SP_HM_STAT;
    private String SPONSOR;
    private String SPON_OBSID;
    private String OB_TYPE;
    private String DELHIBASED;
    private String SPLOBSERVER;
    private String SPLOBSPLACE;
    private String OBS_CODE;
    private String NOMNSTATUS;
    private String DEPSTATUS;
    private String BRIEFINGNO;
    private String BRIEFED;
    private String DETAILEDFORMRECVD;
    private String MOD_DATE;
    private String AGE;
    private String OB_NODAL_ID;
    private String OB_CDEP;
    private String EMG_TEL;
    private String OB_NA_DFROM;
    private String OB_NA_DTO;
    private String OB_REMARK;
    private String OB_BRREMARK;
    private String OB_REQ_STATUS;
    private String MOD_BY;
    private String DISPLAY;
    private String CONST_NO;
    private String OB_RATING;
    private String OLDDEPSTATUS;
    private String O_MOBILE1;
    private String ROWID;
    private String CCODE;
    private String O_AccountNo;
    private String O_IFCSCode;
    private String O_BankName;
    private String O_BranchName;
    private String O_AccountHolderName;
    private String O_Amount;
    private String SMS_SENT;
    private String DEPSTATUS_COUNTING;
    private String CONST_NO_COUNTING;
    private String Amount_Credited;
    private String SMS_Amount;
    private String ObserverType;
    private String OB_FromDate;
    private String OB_ToDate;

    private String OB_2ndFromDate;
    private String OB_2ndToDate;
    private String Mobile_ObsDuty;
    private String SMS_Sent_AccountDetails;
    private String OB_image;
    private String Exp_as_RO;
    private String Exp_as_DEO;
    private String Exp_as_OtherElectionDuty;
    private String OB_NewFromDate;
    private String OB_NewToDate;
    private String DISPLAY_Counting;
    private String OBSOTP;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getECI_OBSID() {
		return ECI_OBSID;
	}
	public void setECI_OBSID(String eCI_OBSID) {
		ECI_OBSID = eCI_OBSID;
	}
	public String getID_NO() {
		return ID_NO;
	}
	public void setID_NO(String iD_NO) {
		ID_NO = iD_NO;
	}
	public String getOB_TITLE() {
		return OB_TITLE;
	}
	public void setOB_TITLE(String oB_TITLE) {
		OB_TITLE = oB_TITLE;
	}
	public String getOB_NAME() {
		return OB_NAME;
	}
	public void setOB_NAME(String oB_NAME) {
		OB_NAME = oB_NAME;
	}
	public String getOB_SERVICE() {
		return OB_SERVICE;
	}
	public void setOB_SERVICE(String oB_SERVICE) {
		OB_SERVICE = oB_SERVICE;
	}
	public String getOB_CADRE() {
		return OB_CADRE;
	}
	public void setOB_CADRE(String oB_CADRE) {
		OB_CADRE = oB_CADRE;
	}
	public String getOB_YEAR() {
		return OB_YEAR;
	}
	public void setOB_YEAR(String oB_YEAR) {
		OB_YEAR = oB_YEAR;
	}
	public String getOB_SEX() {
		return OB_SEX;
	}
	public void setOB_SEX(String oB_SEX) {
		OB_SEX = oB_SEX;
	}
	public String getOB_DOB() {
		return OB_DOB;
	}
	public void setOB_DOB(String oB_DOB) {
		OB_DOB = oB_DOB;
	}
	public String getOB_STATUS() {
		return OB_STATUS;
	}
	public void setOB_STATUS(String oB_STATUS) {
		OB_STATUS = oB_STATUS;
	}
	public String getOB_LANG() {
		return OB_LANG;
	}
	public void setOB_LANG(String oB_LANG) {
		OB_LANG = oB_LANG;
	}
	public String getOB_DESIG() {
		return OB_DESIG;
	}
	public void setOB_DESIG(String oB_DESIG) {
		OB_DESIG = oB_DESIG;
	}
	public String getO_ADR_L1() {
		return O_ADR_L1;
	}
	public void setO_ADR_L1(String o_ADR_L1) {
		O_ADR_L1 = o_ADR_L1;
	}
	public String getO_CITY() {
		return O_CITY;
	}
	public void setO_CITY(String o_CITY) {
		O_CITY = o_CITY;
	}
	public String getO_STATE() {
		return O_STATE;
	}
	public void setO_STATE(String o_STATE) {
		O_STATE = o_STATE;
	}
	public String getO_PIN() {
		return O_PIN;
	}
	public void setO_PIN(String o_PIN) {
		O_PIN = o_PIN;
	}
	public String getO_STD() {
		return O_STD;
	}
	public void setO_STD(String o_STD) {
		O_STD = o_STD;
	}
	public String getO_TEL_DRCT() {
		return O_TEL_DRCT;
	}
	public void setO_TEL_DRCT(String o_TEL_DRCT) {
		O_TEL_DRCT = o_TEL_DRCT;
	}
	public String getO_TEL_PBX() {
		return O_TEL_PBX;
	}
	public void setO_TEL_PBX(String o_TEL_PBX) {
		O_TEL_PBX = o_TEL_PBX;
	}
	public String getO_TEL_EXT() {
		return O_TEL_EXT;
	}
	public void setO_TEL_EXT(String o_TEL_EXT) {
		O_TEL_EXT = o_TEL_EXT;
	}
	public String getO_FAX() {
		return O_FAX;
	}
	public void setO_FAX(String o_FAX) {
		O_FAX = o_FAX;
	}
	public String getO_EMAIL() {
		return O_EMAIL;
	}
	public void setO_EMAIL(String o_EMAIL) {
		O_EMAIL = o_EMAIL;
	}
	public String getO_MOBILE() {
		return O_MOBILE;
	}
	public void setO_MOBILE(String o_MOBILE) {
		O_MOBILE = o_MOBILE;
	}
	public String getR_PIN() {
		return R_PIN;
	}
	public void setR_PIN(String r_PIN) {
		R_PIN = r_PIN;
	}
	public String getR_STD() {
		return R_STD;
	}
	public void setR_STD(String r_STD) {
		R_STD = r_STD;
	}
	public String getR_TNO() {
		return R_TNO;
	}
	public void setR_TNO(String r_TNO) {
		R_TNO = r_TNO;
	}
	public String getR_FAX() {
		return R_FAX;
	}
	public void setR_FAX(String r_FAX) {
		R_FAX = r_FAX;
	}
	public String getEMG_NAME() {
		return EMG_NAME;
	}
	public void setEMG_NAME(String eMG_NAME) {
		EMG_NAME = eMG_NAME;
	}
	public String getOB_HM_STAT() {
		return OB_HM_STAT;
	}
	public void setOB_HM_STAT(String oB_HM_STAT) {
		OB_HM_STAT = oB_HM_STAT;
	}
	public String getSP_HM_STAT() {
		return SP_HM_STAT;
	}
	public void setSP_HM_STAT(String sP_HM_STAT) {
		SP_HM_STAT = sP_HM_STAT;
	}
	public String getSPONSOR() {
		return SPONSOR;
	}
	public void setSPONSOR(String sPONSOR) {
		SPONSOR = sPONSOR;
	}
	public String getSPON_OBSID() {
		return SPON_OBSID;
	}
	public void setSPON_OBSID(String sPON_OBSID) {
		SPON_OBSID = sPON_OBSID;
	}
	public String getOB_TYPE() {
		return OB_TYPE;
	}
	public void setOB_TYPE(String oB_TYPE) {
		OB_TYPE = oB_TYPE;
	}
	public String getDELHIBASED() {
		return DELHIBASED;
	}
	public void setDELHIBASED(String dELHIBASED) {
		DELHIBASED = dELHIBASED;
	}
	public String getSPLOBSERVER() {
		return SPLOBSERVER;
	}
	public void setSPLOBSERVER(String sPLOBSERVER) {
		SPLOBSERVER = sPLOBSERVER;
	}
	public String getSPLOBSPLACE() {
		return SPLOBSPLACE;
	}
	public void setSPLOBSPLACE(String sPLOBSPLACE) {
		SPLOBSPLACE = sPLOBSPLACE;
	}
	public String getOBS_CODE() {
		return OBS_CODE;
	}
	public void setOBS_CODE(String oBS_CODE) {
		OBS_CODE = oBS_CODE;
	}
	public String getNOMNSTATUS() {
		return NOMNSTATUS;
	}
	public void setNOMNSTATUS(String nOMNSTATUS) {
		NOMNSTATUS = nOMNSTATUS;
	}
	public String getDEPSTATUS() {
		return DEPSTATUS;
	}
	public void setDEPSTATUS(String dEPSTATUS) {
		DEPSTATUS = dEPSTATUS;
	}
	public String getBRIEFINGNO() {
		return BRIEFINGNO;
	}
	public void setBRIEFINGNO(String bRIEFINGNO) {
		BRIEFINGNO = bRIEFINGNO;
	}
	public String getBRIEFED() {
		return BRIEFED;
	}
	public void setBRIEFED(String bRIEFED) {
		BRIEFED = bRIEFED;
	}
	public String getDETAILEDFORMRECVD() {
		return DETAILEDFORMRECVD;
	}
	public void setDETAILEDFORMRECVD(String dETAILEDFORMRECVD) {
		DETAILEDFORMRECVD = dETAILEDFORMRECVD;
	}
	public String getMOD_DATE() {
		return MOD_DATE;
	}
	public void setMOD_DATE(String mOD_DATE) {
		MOD_DATE = mOD_DATE;
	}
	public String getAGE() {
		return AGE;
	}
	public void setAGE(String aGE) {
		AGE = aGE;
	}
	public String getOB_NODAL_ID() {
		return OB_NODAL_ID;
	}
	public void setOB_NODAL_ID(String oB_NODAL_ID) {
		OB_NODAL_ID = oB_NODAL_ID;
	}
	public String getOB_CDEP() {
		return OB_CDEP;
	}
	public void setOB_CDEP(String oB_CDEP) {
		OB_CDEP = oB_CDEP;
	}
	public String getEMG_TEL() {
		return EMG_TEL;
	}
	public void setEMG_TEL(String eMG_TEL) {
		EMG_TEL = eMG_TEL;
	}
	public String getOB_NA_DFROM() {
		return OB_NA_DFROM;
	}
	public void setOB_NA_DFROM(String oB_NA_DFROM) {
		OB_NA_DFROM = oB_NA_DFROM;
	}
	public String getOB_NA_DTO() {
		return OB_NA_DTO;
	}
	public void setOB_NA_DTO(String oB_NA_DTO) {
		OB_NA_DTO = oB_NA_DTO;
	}
	public String getOB_REMARK() {
		return OB_REMARK;
	}
	public void setOB_REMARK(String oB_REMARK) {
		OB_REMARK = oB_REMARK;
	}
	public String getOB_BRREMARK() {
		return OB_BRREMARK;
	}
	public void setOB_BRREMARK(String oB_BRREMARK) {
		OB_BRREMARK = oB_BRREMARK;
	}
	public String getOB_REQ_STATUS() {
		return OB_REQ_STATUS;
	}
	public void setOB_REQ_STATUS(String oB_REQ_STATUS) {
		OB_REQ_STATUS = oB_REQ_STATUS;
	}
	public String getMOD_BY() {
		return MOD_BY;
	}
	public void setMOD_BY(String mOD_BY) {
		MOD_BY = mOD_BY;
	}
	public String getDISPLAY() {
		return DISPLAY;
	}
	public void setDISPLAY(String dISPLAY) {
		DISPLAY = dISPLAY;
	}
	public String getCONST_NO() {
		return CONST_NO;
	}
	public void setCONST_NO(String cONST_NO) {
		CONST_NO = cONST_NO;
	}
	public String getOB_RATING() {
		return OB_RATING;
	}
	public void setOB_RATING(String oB_RATING) {
		OB_RATING = oB_RATING;
	}
	public String getOLDDEPSTATUS() {
		return OLDDEPSTATUS;
	}
	public void setOLDDEPSTATUS(String oLDDEPSTATUS) {
		OLDDEPSTATUS = oLDDEPSTATUS;
	}
	public String getO_MOBILE1() {
		return O_MOBILE1;
	}
	public void setO_MOBILE1(String o_MOBILE1) {
		O_MOBILE1 = o_MOBILE1;
	}
	public String getROWID() {
		return ROWID;
	}
	public void setROWID(String rOWID) {
		ROWID = rOWID;
	}
	public String getCCODE() {
		return CCODE;
	}
	public void setCCODE(String cCODE) {
		CCODE = cCODE;
	}
	public String getO_AccountNo() {
		return O_AccountNo;
	}
	public void setO_AccountNo(String o_AccountNo) {
		O_AccountNo = o_AccountNo;
	}
	public String getO_IFCSCode() {
		return O_IFCSCode;
	}
	public void setO_IFCSCode(String o_IFCSCode) {
		O_IFCSCode = o_IFCSCode;
	}
	public String getO_BankName() {
		return O_BankName;
	}
	public void setO_BankName(String o_BankName) {
		O_BankName = o_BankName;
	}
	public String getO_BranchName() {
		return O_BranchName;
	}
	public void setO_BranchName(String o_BranchName) {
		O_BranchName = o_BranchName;
	}
	public String getO_AccountHolderName() {
		return O_AccountHolderName;
	}
	public void setO_AccountHolderName(String o_AccountHolderName) {
		O_AccountHolderName = o_AccountHolderName;
	}
	public String getO_Amount() {
		return O_Amount;
	}
	public void setO_Amount(String o_Amount) {
		O_Amount = o_Amount;
	}
	public String getSMS_SENT() {
		return SMS_SENT;
	}
	public void setSMS_SENT(String sMS_SENT) {
		SMS_SENT = sMS_SENT;
	}
	public String getDEPSTATUS_COUNTING() {
		return DEPSTATUS_COUNTING;
	}
	public void setDEPSTATUS_COUNTING(String dEPSTATUS_COUNTING) {
		DEPSTATUS_COUNTING = dEPSTATUS_COUNTING;
	}
	public String getCONST_NO_COUNTING() {
		return CONST_NO_COUNTING;
	}
	public void setCONST_NO_COUNTING(String cONST_NO_COUNTING) {
		CONST_NO_COUNTING = cONST_NO_COUNTING;
	}
	public String getAmount_Credited() {
		return Amount_Credited;
	}
	public void setAmount_Credited(String amount_Credited) {
		Amount_Credited = amount_Credited;
	}
	public String getSMS_Amount() {
		return SMS_Amount;
	}
	public void setSMS_Amount(String sMS_Amount) {
		SMS_Amount = sMS_Amount;
	}
	public String getObserverType() {
		return ObserverType;
	}
	public void setObserverType(String observerType) {
		ObserverType = observerType;
	}
	public String getOB_FromDate() {
		return OB_FromDate;
	}
	public void setOB_FromDate(String oB_FromDate) {
		OB_FromDate = oB_FromDate;
	}
	public String getOB_ToDate() {
		return OB_ToDate;
	}
	public void setOB_ToDate(String oB_ToDate) {
		OB_ToDate = oB_ToDate;
	}
	public String getOB_2ndFromDate() {
		return OB_2ndFromDate;
	}
	public void setOB_2ndFromDate(String oB_2ndFromDate) {
		OB_2ndFromDate = oB_2ndFromDate;
	}
	public String getOB_2ndToDate() {
		return OB_2ndToDate;
	}
	public void setOB_2ndToDate(String oB_2ndToDate) {
		OB_2ndToDate = oB_2ndToDate;
	}
	public String getMobile_ObsDuty() {
		return Mobile_ObsDuty;
	}
	public void setMobile_ObsDuty(String mobile_ObsDuty) {
		Mobile_ObsDuty = mobile_ObsDuty;
	}
	public String getSMS_Sent_AccountDetails() {
		return SMS_Sent_AccountDetails;
	}
	public void setSMS_Sent_AccountDetails(String sMS_Sent_AccountDetails) {
		SMS_Sent_AccountDetails = sMS_Sent_AccountDetails;
	}
	public String getOB_image() {
		return OB_image;
	}
	public void setOB_image(String oB_image) {
		OB_image = oB_image;
	}
	public String getExp_as_RO() {
		return Exp_as_RO;
	}
	public void setExp_as_RO(String exp_as_RO) {
		Exp_as_RO = exp_as_RO;
	}
	public String getExp_as_DEO() {
		return Exp_as_DEO;
	}
	public void setExp_as_DEO(String exp_as_DEO) {
		Exp_as_DEO = exp_as_DEO;
	}
	public String getExp_as_OtherElectionDuty() {
		return Exp_as_OtherElectionDuty;
	}
	public void setExp_as_OtherElectionDuty(String exp_as_OtherElectionDuty) {
		Exp_as_OtherElectionDuty = exp_as_OtherElectionDuty;
	}
	public String getOB_NewFromDate() {
		return OB_NewFromDate;
	}
	public void setOB_NewFromDate(String oB_NewFromDate) {
		OB_NewFromDate = oB_NewFromDate;
	}
	public String getOB_NewToDate() {
		return OB_NewToDate;
	}
	public void setOB_NewToDate(String oB_NewToDate) {
		OB_NewToDate = oB_NewToDate;
	}
	public String getDISPLAY_Counting() {
		return DISPLAY_Counting;
	}
	public void setDISPLAY_Counting(String dISPLAY_Counting) {
		DISPLAY_Counting = dISPLAY_Counting;
	}
	public String getOBSOTP() {
		return OBSOTP;
	}
	public void setOBSOTP(String oBSOTP) {
		OBSOTP = oBSOTP;
	}
	public T_OBS2(Long id, String eCI_OBSID, String iD_NO, String oB_TITLE, String oB_NAME, String oB_SERVICE,
			String oB_CADRE, String oB_YEAR, String oB_SEX, String oB_DOB, String oB_STATUS, String oB_LANG,
			String oB_DESIG, String o_ADR_L1, String o_CITY, String o_STATE, String o_PIN, String o_STD,
			String o_TEL_DRCT, String o_TEL_PBX, String o_TEL_EXT, String o_FAX, String o_EMAIL, String o_MOBILE,
			String r_PIN, String r_STD, String r_TNO, String r_FAX, String eMG_NAME, String oB_HM_STAT,
			String sP_HM_STAT, String sPONSOR, String sPON_OBSID, String oB_TYPE, String dELHIBASED, String sPLOBSERVER,
			String sPLOBSPLACE, String oBS_CODE, String nOMNSTATUS, String dEPSTATUS, String bRIEFINGNO, String bRIEFED,
			String dETAILEDFORMRECVD, String mOD_DATE, String aGE, String oB_NODAL_ID, String oB_CDEP, String eMG_TEL,
			String oB_NA_DFROM, String oB_NA_DTO, String oB_REMARK, String oB_BRREMARK, String oB_REQ_STATUS,
			String mOD_BY, String dISPLAY, String cONST_NO, String oB_RATING, String oLDDEPSTATUS, String o_MOBILE1,
			String rOWID, String cCODE, String o_AccountNo, String o_IFCSCode, String o_BankName, String o_BranchName,
			String o_AccountHolderName, String o_Amount, String sMS_SENT, String dEPSTATUS_COUNTING,
			String cONST_NO_COUNTING, String amount_Credited, String sMS_Amount, String observerType,
			String oB_FromDate, String oB_ToDate, String oB_2ndFromDate, String oB_2ndToDate, String mobile_ObsDuty,
			String sMS_Sent_AccountDetails, String oB_image, String exp_as_RO, String exp_as_DEO,
			String exp_as_OtherElectionDuty, String oB_NewFromDate, String oB_NewToDate, String dISPLAY_Counting,
			String oBSOTP) {
		super();
		this.id = id;
		ECI_OBSID = eCI_OBSID;
		ID_NO = iD_NO;
		OB_TITLE = oB_TITLE;
		OB_NAME = oB_NAME;
		OB_SERVICE = oB_SERVICE;
		OB_CADRE = oB_CADRE;
		OB_YEAR = oB_YEAR;
		OB_SEX = oB_SEX;
		OB_DOB = oB_DOB;
		OB_STATUS = oB_STATUS;
		OB_LANG = oB_LANG;
		OB_DESIG = oB_DESIG;
		O_ADR_L1 = o_ADR_L1;
		O_CITY = o_CITY;
		O_STATE = o_STATE;
		O_PIN = o_PIN;
		O_STD = o_STD;
		O_TEL_DRCT = o_TEL_DRCT;
		O_TEL_PBX = o_TEL_PBX;
		O_TEL_EXT = o_TEL_EXT;
		O_FAX = o_FAX;
		O_EMAIL = o_EMAIL;
		O_MOBILE = o_MOBILE;
		R_PIN = r_PIN;
		R_STD = r_STD;
		R_TNO = r_TNO;
		R_FAX = r_FAX;
		EMG_NAME = eMG_NAME;
		OB_HM_STAT = oB_HM_STAT;
		SP_HM_STAT = sP_HM_STAT;
		SPONSOR = sPONSOR;
		SPON_OBSID = sPON_OBSID;
		OB_TYPE = oB_TYPE;
		DELHIBASED = dELHIBASED;
		SPLOBSERVER = sPLOBSERVER;
		SPLOBSPLACE = sPLOBSPLACE;
		OBS_CODE = oBS_CODE;
		NOMNSTATUS = nOMNSTATUS;
		DEPSTATUS = dEPSTATUS;
		BRIEFINGNO = bRIEFINGNO;
		BRIEFED = bRIEFED;
		DETAILEDFORMRECVD = dETAILEDFORMRECVD;
		MOD_DATE = mOD_DATE;
		AGE = aGE;
		OB_NODAL_ID = oB_NODAL_ID;
		OB_CDEP = oB_CDEP;
		EMG_TEL = eMG_TEL;
		OB_NA_DFROM = oB_NA_DFROM;
		OB_NA_DTO = oB_NA_DTO;
		OB_REMARK = oB_REMARK;
		OB_BRREMARK = oB_BRREMARK;
		OB_REQ_STATUS = oB_REQ_STATUS;
		MOD_BY = mOD_BY;
		DISPLAY = dISPLAY;
		CONST_NO = cONST_NO;
		OB_RATING = oB_RATING;
		OLDDEPSTATUS = oLDDEPSTATUS;
		O_MOBILE1 = o_MOBILE1;
		ROWID = rOWID;
		CCODE = cCODE;
		O_AccountNo = o_AccountNo;
		O_IFCSCode = o_IFCSCode;
		O_BankName = o_BankName;
		O_BranchName = o_BranchName;
		O_AccountHolderName = o_AccountHolderName;
		O_Amount = o_Amount;
		SMS_SENT = sMS_SENT;
		DEPSTATUS_COUNTING = dEPSTATUS_COUNTING;
		CONST_NO_COUNTING = cONST_NO_COUNTING;
		Amount_Credited = amount_Credited;
		SMS_Amount = sMS_Amount;
		ObserverType = observerType;
		OB_FromDate = oB_FromDate;
		OB_ToDate = oB_ToDate;
		OB_2ndFromDate = oB_2ndFromDate;
		OB_2ndToDate = oB_2ndToDate;
		Mobile_ObsDuty = mobile_ObsDuty;
		SMS_Sent_AccountDetails = sMS_Sent_AccountDetails;
		OB_image = oB_image;
		Exp_as_RO = exp_as_RO;
		Exp_as_DEO = exp_as_DEO;
		Exp_as_OtherElectionDuty = exp_as_OtherElectionDuty;
		OB_NewFromDate = oB_NewFromDate;
		OB_NewToDate = oB_NewToDate;
		DISPLAY_Counting = dISPLAY_Counting;
		OBSOTP = oBSOTP;
	}
	@Override
	public String toString() {
		return "T_OBS2 [id=" + id + ", ECI_OBSID=" + ECI_OBSID + ", ID_NO=" + ID_NO + ", OB_TITLE=" + OB_TITLE
				+ ", OB_NAME=" + OB_NAME + ", OB_SERVICE=" + OB_SERVICE + ", OB_CADRE=" + OB_CADRE + ", OB_YEAR="
				+ OB_YEAR + ", OB_SEX=" + OB_SEX + ", OB_DOB=" + OB_DOB + ", OB_STATUS=" + OB_STATUS + ", OB_LANG="
				+ OB_LANG + ", OB_DESIG=" + OB_DESIG + ", O_ADR_L1=" + O_ADR_L1 + ", O_CITY=" + O_CITY + ", O_STATE="
				+ O_STATE + ", O_PIN=" + O_PIN + ", O_STD=" + O_STD + ", O_TEL_DRCT=" + O_TEL_DRCT + ", O_TEL_PBX="
				+ O_TEL_PBX + ", O_TEL_EXT=" + O_TEL_EXT + ", O_FAX=" + O_FAX + ", O_EMAIL=" + O_EMAIL + ", O_MOBILE="
				+ O_MOBILE + ", R_PIN=" + R_PIN + ", R_STD=" + R_STD + ", R_TNO=" + R_TNO + ", R_FAX=" + R_FAX
				+ ", EMG_NAME=" + EMG_NAME + ", OB_HM_STAT=" + OB_HM_STAT + ", SP_HM_STAT=" + SP_HM_STAT + ", SPONSOR="
				+ SPONSOR + ", SPON_OBSID=" + SPON_OBSID + ", OB_TYPE=" + OB_TYPE + ", DELHIBASED=" + DELHIBASED
				+ ", SPLOBSERVER=" + SPLOBSERVER + ", SPLOBSPLACE=" + SPLOBSPLACE + ", OBS_CODE=" + OBS_CODE
				+ ", NOMNSTATUS=" + NOMNSTATUS + ", DEPSTATUS=" + DEPSTATUS + ", BRIEFINGNO=" + BRIEFINGNO
				+ ", BRIEFED=" + BRIEFED + ", DETAILEDFORMRECVD=" + DETAILEDFORMRECVD + ", MOD_DATE=" + MOD_DATE
				+ ", AGE=" + AGE + ", OB_NODAL_ID=" + OB_NODAL_ID + ", OB_CDEP=" + OB_CDEP + ", EMG_TEL=" + EMG_TEL
				+ ", OB_NA_DFROM=" + OB_NA_DFROM + ", OB_NA_DTO=" + OB_NA_DTO + ", OB_REMARK=" + OB_REMARK
				+ ", OB_BRREMARK=" + OB_BRREMARK + ", OB_REQ_STATUS=" + OB_REQ_STATUS + ", MOD_BY=" + MOD_BY
				+ ", DISPLAY=" + DISPLAY + ", CONST_NO=" + CONST_NO + ", OB_RATING=" + OB_RATING + ", OLDDEPSTATUS="
				+ OLDDEPSTATUS + ", O_MOBILE1=" + O_MOBILE1 + ", ROWID=" + ROWID + ", CCODE=" + CCODE + ", O_AccountNo="
				+ O_AccountNo + ", O_IFCSCode=" + O_IFCSCode + ", O_BankName=" + O_BankName + ", O_BranchName="
				+ O_BranchName + ", O_AccountHolderName=" + O_AccountHolderName + ", O_Amount=" + O_Amount
				+ ", SMS_SENT=" + SMS_SENT + ", DEPSTATUS_COUNTING=" + DEPSTATUS_COUNTING + ", CONST_NO_COUNTING="
				+ CONST_NO_COUNTING + ", Amount_Credited=" + Amount_Credited + ", SMS_Amount=" + SMS_Amount
				+ ", ObserverType=" + ObserverType + ", OB_FromDate=" + OB_FromDate + ", OB_ToDate=" + OB_ToDate
				+ ", OB_2ndFromDate=" + OB_2ndFromDate + ", OB_2ndToDate=" + OB_2ndToDate + ", Mobile_ObsDuty="
				+ Mobile_ObsDuty + ", SMS_Sent_AccountDetails=" + SMS_Sent_AccountDetails + ", OB_image=" + OB_image
				+ ", Exp_as_RO=" + Exp_as_RO + ", Exp_as_DEO=" + Exp_as_DEO + ", Exp_as_OtherElectionDuty="
				+ Exp_as_OtherElectionDuty + ", OB_NewFromDate=" + OB_NewFromDate + ", OB_NewToDate=" + OB_NewToDate
				+ ", DISPLAY_Counting=" + DISPLAY_Counting + ", OBSOTP=" + OBSOTP + "]";
	}
	public T_OBS2() {
		super();
		// TODO Auto-generated constructor stub
	}

}

package Observer20.Response;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

public class ObsAllotResponse {
	private String stateName;
    private String districtName;
    private String stateCode;
    private String districtCode;
    private String acName;
    private String acNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date OBFromDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date OBToDate;
    @Column(name = "DATE_POLL") // Specify the column name if it's different from the property name
    private Date datePoll;
    private String constType;
    private String electionType;
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getAcName() {
		return acName;
	}
	public void setAcName(String acName) {
		this.acName = acName;
	}
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
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
	public Date getDatePoll() {
		return datePoll;
	}
	public void setDatePoll(Date datePoll) {
		this.datePoll = datePoll;
	}
	public String getConstType() {
		return constType;
	}
	public void setConstType(String constType) {
		this.constType = constType;
	}
	public String getElectionType() {
		return electionType;
	}
	public void setElectionType(String electionType) {
		this.electionType = electionType;
	}
    
    
    

}

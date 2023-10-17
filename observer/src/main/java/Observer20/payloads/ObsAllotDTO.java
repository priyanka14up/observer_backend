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
    private Date datePoll;
    private String constType;
    private String electionType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date OBFromDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date OBToDate;
    private Long scheduleID;
    private String obscode;
    
    
    
    
    
    
    
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
   

}

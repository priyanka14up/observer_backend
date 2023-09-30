package Observer20.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="M_ELECTION_DETAILS2")
public class M_ELECTION_DETAILS2 {
@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

private Long id;
private String ccode;
private Long scheduleID;
private String constNo;
private String constType;
private String delimType;
private String electionType;
private String stCode;
private String insertionDate;
private String votesReg49O; // Updated variable name to camelCase
private int statePhaseNo;
private int phaseNo;
private String adjournedPol;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCcode() {
	return ccode;
}
public void setCcode(String ccode) {
	this.ccode = ccode;
}
public Long getScheduleId() {
	return scheduleID;
}
public void setScheduleId(Long scheduleId) {
	this.scheduleID = scheduleId;
}
public String getConstNo() {
	return constNo;
}
public void setConstNo(String constNo) {
	this.constNo = constNo;
}
public String getConstType() {
	return constType;
}
public void setConstType(String constType) {
	this.constType = constType;
}
public String getDelimType() {
	return delimType;
}
public void setDelimType(String delimType) {
	this.delimType = delimType;
}
public String getElectionType() {
	return electionType;
}
public void setElectionType(String electionType) {
	this.electionType = electionType;
}
public String getStCode() {
	return stCode;
}
public void setStCode(String stCode) {
	this.stCode = stCode;
}
public String getInsertionDate() {
	return insertionDate;
}
public void setInsertionDate(String insertionDate) {
	this.insertionDate = insertionDate;
}
public String getVotesReg49O() {
	return votesReg49O;
}
public void setVotesReg49O(String votesReg49O) {
	this.votesReg49O = votesReg49O;
}
public int getStatePhaseNo() {
	return statePhaseNo;
}
public void setStatePhaseNo(int statePhaseNo) {
	this.statePhaseNo = statePhaseNo;
}
public int getPhaseNo() {
	return phaseNo;
}
public void setPhaseNo(int phaseNo) {
	this.phaseNo = phaseNo;
}
public String getAdjournedPol() {
	return adjournedPol;
}
public void setAdjournedPol(String adjournedPol) {
	this.adjournedPol = adjournedPol;
}
public M_ELECTION_DETAILS2() {
	super();
	// TODO Auto-generated constructor stub
}

	
}

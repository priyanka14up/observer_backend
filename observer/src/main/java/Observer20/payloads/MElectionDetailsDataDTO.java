package Observer20.payloads;

import java.util.Date;

public class MElectionDetailsDataDTO {
	private String constType;
    private String electionType;
    private int phaseNo;
    private int statePhaseNO;;
    private Date datePoll;
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
	public int getPhaseNo() {
		return phaseNo;
	}
	public void setPhaseNo(int phaseNo) {
		this.phaseNo = phaseNo;
	}
	public int getStatePhaseNO() {
		return statePhaseNO;
	}
	public void setStatePhaseNO(int statePhaseNO) {
		this.statePhaseNO = statePhaseNO;
	}
	public Date getDatePoll() {
		return datePoll;
	}
	public void setDatePoll(Date datePoll) {
		this.datePoll = datePoll;
	}
	
    
}

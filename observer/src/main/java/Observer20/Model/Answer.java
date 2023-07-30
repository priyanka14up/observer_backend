package Observer20.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="answer")
@EntityListeners(AuditingEntityListener.class)
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "a_id", updatable = false, nullable = false)
    private Long aid;
	
	@Column(name = "f_id",nullable=false)
    private Long fid;
	
	@Column(name = "s_id",nullable=false)
    private Long sid;
	
	@Column(name = "q_id",nullable=false)
    private Long qid;
	
	@NotBlank(message = "Answer is mandatory")
	@Column(name = "answer",nullable=false)
    private String answer;
	
	@Column(name = "remarks")
    private String remarks;
	
	  /*observer code*/
		@Column(name = "submitted_by",nullable=false)
	    private String submittedBy;
	

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}
	
	
	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", fid=" + fid + ", sid=" + sid + ", qid=" + qid + ", answer=" + answer
				+ ", remarks=" + remarks + ", submittedBy=" + submittedBy + "]";
	}

	}





	


//package Observer20.Model;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//@Entity
//@Table(name="subform_draft")
//@EntityListeners(AuditingEntityListener.class)
//public class SubFormDraft {
//
//	/*represents draft id*/
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "d_id", updatable = false, nullable = false)
//    private Long did;
//	
//	@Column(name = "q_id",nullable=false)
//    private Long qid;
//	
//	@Column(name = "f_id",nullable=false)
//    private Long fid;
//	
//	@Column(name = "s_id",nullable=false)
//    private Long sid;
//	
//	@NotBlank(message = "Answer is mandatory")
//	@Column(name = "answer",nullable=false)
//    private String answer;
//	
//	@Column(name = "remarks")
//    private String remarks;
//	
//	@Column(name = "submitted_by",nullable=false)
//    private String submittedBy;
//
//	
//	public Long getDid() {
//		return did;
//	}
//
//	public void setDid(Long did) {
//		this.did = did;
//	}
//
//	public Long getQid() {
//		return qid;
//	}
//
//	public void setQid(Long qid) {
//		this.qid = qid;
//	}
//
//	public Long getFid() {
//		return fid;
//	}
//
//	public void setFid(Long fid) {
//		this.fid = fid;
//	}
//
//	public Long getSid() {
//		return sid;
//	}
//
//	public void setSid(Long sid) {
//		this.sid = sid;
//	}
//
//	public String getAnswer() {
//		return answer;
//	}
//
//	public void setAnswer(String answer) {
//		this.answer = answer;
//	}
//
//	public String getRemarks() {
//		return remarks;
//	}
//
//	public void setRemarks(String remarks) {
//		this.remarks = remarks;
//	}
//
//	public String getSubmittedBy() {
//		return submittedBy;
//	}
//
//	public void setSubmittedBy(String submittedBy) {
//		this.submittedBy = submittedBy;
//	}
//
//	@Override
//	public String toString() {
//		return "SubFormDraft [did=" + did + ", qid=" + qid + ", fid=" + fid + ", sid=" + sid + ", answer=" + answer
//				+ ", remarks=" + remarks + ", submittedBy=" + submittedBy + "]";
//	}
//	}
//
//
//
//
//
//	
//

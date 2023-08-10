package Observer20.Dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class FinalAnswerDto {
	@Column(name = "f_id",nullable=false)
    private Long fid;
	
	@Column(name = "s_id",nullable=false)
    private Long sid;
	
	@Column(name = "q_id",nullable=false)
    private Long qid;
	
	@Column(name = "qText",nullable=false)
    private String qText;
	
	
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

	

		public String getqText() {
			return qText;
		}

		public void setqText(String qText) {
			this.qText = qText;
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

		public String getSubmittedBy() {
			return submittedBy;
		}

		public void setSubmittedBy(String submittedBy) {
			this.submittedBy = submittedBy;
		}

		@Override
		public String toString() {
			return "FinalAnswerDto [fid=" + fid + ", sid=" + sid + ", qid=" + qid + ", qText=" + qText + ", answer="
					+ answer + ", remarks=" + remarks + ", submittedBy=" + submittedBy + "]";
		}

		
}

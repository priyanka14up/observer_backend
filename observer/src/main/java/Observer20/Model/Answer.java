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
@Table(name="questions_response")
@EntityListeners(AuditingEntityListener.class)
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ans_id", updatable = false, nullable = false)
    private Long aid;
	
	@Column(name = "q_id",nullable=false)
    private Long qid;
	
	@NotBlank(message = "Answer is mandatory")
	@Column(name = "answer",nullable=false)
    private String answer;
	
	@Column(name = "remarks")
    private String remarks;
	
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

	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", qid=" + qid + ", answer=" + answer + ", remarks=" + remarks + "]";
	}
	

	}





	


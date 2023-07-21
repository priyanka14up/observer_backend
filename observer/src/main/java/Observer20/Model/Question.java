
package Observer20.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="Master_Questions")
@EntityListeners(AuditingEntityListener.class)
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "q_id", updatable = false, nullable = false)
    private Long qid;
	
	@NotBlank(message = "Question Name is mandatory")
	@Column(name = "ques_name",nullable=false)
    private String qname;
	
	@NotBlank(message = "Input Type is mandatory")
	@Column(name = "input_type",nullable=false)
    private  String inputType;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "s_id")
    private SubForm subform;
	
	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public SubForm getSubform() {
		return subform;
	}

	public void setSubform(SubForm subform) {
		this.subform = subform;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", qname=" + qname + ", inputType=" + inputType + ", subform=" + subform + "]";
	}

	
	
	

//	public SubForm getSubform() {
//		return subform;
//	}
//
//	public void setSubform(SubForm subform) {
//		this.subform = subform;
//	}

	
	
}

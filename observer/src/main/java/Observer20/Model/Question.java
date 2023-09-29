
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
	@Column(columnDefinition = "TEXT",name = "ques_name",nullable=false)
    private String qname;
	
	//@NotBlank(message = "Question Name is mandatory")
	@Column(name = "ques_seq",nullable=false)
    private Long qseq;
	
	
	@NotBlank(message = "Input Type is mandatory")
	@Column(name = "input_type",nullable=false)
    private  String inputType;
	
	//@NotBlank(message = "Input Label is mandatory")
	@Column(name = "input_label",nullable=false)
    private  String inputLabel;
	
	//@NotBlank(message = "Remark Status is mandatory")
	@Column(name = "remark_status",nullable=false)
    private  boolean remarkStatus;
	
	//@NotBlank(message = "Remark Label is mandatory")
	@Column(name = "remark_label",nullable=false)
    private  String remarkLabel;
	
	
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
	
	public String getInputLabel() {
		return inputLabel;
	}

	public void setInputLabel(String inputLabel) {
		this.inputLabel = inputLabel;
	}

	

	public boolean isRemarkStatus() {
		return remarkStatus;
	}

	public void setRemarkStatus(boolean remarkStatus) {
		this.remarkStatus = remarkStatus;
	}

	public String getRemarkLabel() {
		return remarkLabel;
	}

	public void setRemarkLabel(String remarkLabel) {
		this.remarkLabel = remarkLabel;
	}
	
	public Long getQseq() {
		return qseq;
	}

	public void setQseq(Long qseq) {
		this.qseq = qseq;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", qname=" + qname + ", qseq=" + qseq + ", inputType=" + inputType
				+ ", inputLabel=" + inputLabel + ", remarkStatus=" + remarkStatus + ", remarkLabel=" + remarkLabel
				+ ", subform=" + subform + "]";
	}
//	public SubForm getSubform() {
//		return subform;
//	}
//
//	public void setSubform(SubForm subform) {
//		this.subform = subform;
//	}
}

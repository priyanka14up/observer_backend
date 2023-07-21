//
//package Observer20.Model;
//import java.util.List;
//
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EntityListeners;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
//@Entity
//@Table(name="Master_Questions1")
//@EntityListeners(AuditingEntityListener.class)
//public class Question1 {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "q_id", updatable = false, nullable = false)
//    private Long qid;
//	
//	@NotBlank(message = "Question Name is mandatory")
//	@Column(name = "ques_name",nullable=false)
//    private String qname;
//	
//	@NotBlank(message = "Input Type is mandatory")
//	@Column(name = "input_type",nullable=false)
//    private  String inputType;
//	
//	
//
//	public Long getQid() {
//		return qid;
//	}
//
//	public void setQid(Long qid) {
//		this.qid = qid;
//	}
//
//	public String getQname() {
//		return qname;
//	}
//
//	public void setQname(String qname) {
//		this.qname = qname;
//	}
//
//	public String getInputType() {
//		return inputType;
//	}
//
//	public void setInputType(String inputType) {
//		this.inputType = inputType;
//	}
//
//	@Override
//	public String toString() {
//		return "Question1 [qid=" + qid + ", qname=" + qname + ", inputType=" + inputType + "]";
//	}
//
//	
//	
//	
//	
//
//
//	
//	
//}

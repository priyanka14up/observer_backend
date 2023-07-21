//
//package Observer20.Model;
//import java.util.*;
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
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
//@Entity
//@Table(name="Sub_Form1")
//@EntityListeners(AuditingEntityListener.class)
//public class SubForm1 {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "s_id", updatable = false, nullable = false)
//    private Long sid;
//	
//	@NotBlank(message = "Heading is mandatory")
//	@Column(name = "Heading",nullable=false)
//    private String heading;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "q_id")
//    private List<Question1> questions;
//
//	public Long getSid() {
//		return sid;
//	}
//
//	public void setSid(Long sid) {
//		this.sid = sid;
//	}
//
//	public String getHeading() {
//		return heading;
//	}
//
//	public void setHeading(String heading) {
//		this.heading = heading;
//	}
//
//	public List<Question1> getQuestions() {
//		return questions;
//	}
//
//	public void setQuestions(List<Question1> questions) {
//		this.questions = questions;
//	}
//
//	@Override
//	public String toString() {
//		return "SubForm1 [sid=" + sid + ", heading=" + heading + ", questions=" + questions + "]";
//	}
//
//	
//
//	
//}

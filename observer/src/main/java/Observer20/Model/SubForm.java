
package Observer20.Model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Sub_Form")
@EntityListeners(AuditingEntityListener.class)
public class SubForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "s_id", updatable = false, nullable = false)
    private Long sid;
	
	@NotBlank(message = "Heading is mandatory")
	@Column(name = "Heading",nullable=false)
    private String heading;
		
	@ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "form_id")
    private Form form;
	
	 @OneToMany(mappedBy = "subform", cascade = CascadeType.ALL)
	    private List<Question> questions = new ArrayList<>();


	public Long getSid() {
		return sid;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getHeading() {
		return heading;
	}


	public void setHeading(String heading) {
		this.heading = heading;
	}
	
}

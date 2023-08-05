package Observer20.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SecurityQuestion {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long q_id;

	    @Column(nullable = false)
	    private String question;

		public Long getQ_id() {
			return q_id;
		}

		public void setQ_id(Long q_id) {
			this.q_id = q_id;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

	    
		
	    
}

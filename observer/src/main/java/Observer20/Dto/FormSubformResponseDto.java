package Observer20.Dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

import Observer20.Model.Answer;
import Observer20.repository.AnswerRepo;

public class FormSubformResponseDto {
	
	private Long id;
	 
	 //@NotBlank(message = "answers to be filled")
	 private List<Answer> answers;
		
	 //@NotBlank(message = "File Location is mandatory")
	 private  Long sid;
	 
	 private  boolean status;
	 
	 private String submittedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	@Override
	public String toString() {
		return "FormSubformResponseDto [id=" + id + ", answers=" + answers + ", sid=" + sid + ", status=" + status
				+ ", submittedBy=" + submittedBy + "]";
	}

	
	 
	
        
  
}
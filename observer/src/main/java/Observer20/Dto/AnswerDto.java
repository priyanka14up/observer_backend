package Observer20.Dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

import Observer20.Model.Answer;
import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;
import Observer20.repository.AnswerRepo;

public class AnswerDto {
	
	private Long id;
	 
	 //@NotBlank(message = "answers to be filled")
	 private List<DraftAnswer> draftAnswers;
		
	 private List<FinalSubmitAnswer> finalSubmitAnswer;
	 //@NotBlank(message = "File Location is mandatory")
	 
	 private  boolean status;
	 
	 private String submittedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public List<DraftAnswer> getDraftAnswers() {
		return draftAnswers;
	}

	public void setDraftAnswers(List<DraftAnswer> draftAnswers) {
		this.draftAnswers = draftAnswers;
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
	
	

	public List<FinalSubmitAnswer> getFinalSubmitAnswer() {
		return finalSubmitAnswer;
	}

	public void setFinalSubmitAnswer(List<FinalSubmitAnswer> finalSubmitAnswer) {
		this.finalSubmitAnswer = finalSubmitAnswer;
	}

	@Override
	public String toString() {
		return "AnswerDto [id=" + id + ", draftAnswers=" + draftAnswers + ", finalSubmitAnswer=" + finalSubmitAnswer
				+ ", status=" + status + ", submittedBy=" + submittedBy + "]";
	}

	
}
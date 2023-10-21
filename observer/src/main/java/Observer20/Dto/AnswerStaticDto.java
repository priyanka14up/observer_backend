
package Observer20.Dto;

import java.util.HashMap;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

//import Observer20.Model.Answer;
import Observer20.Model.DraftAnswer;
import Observer20.Model.DraftAnswerStatic;
import Observer20.Model.FinalSubmitAnswer;
//import Observer20.repository.AnswerRepo;
import Observer20.Model.FinalSubmitAnswerStatic;

public class AnswerStaticDto {
	
	private Long id;
	 
	 //@NotBlank(message = "answers to be filled")
	 private List<DraftAnswerStatic> draftAnswers;
	 
	//private List<HashMap<String,DraftAnswer>> draftAnswer;
		
	 private List<FinalSubmitAnswerStatic> finalSubmitAnswer;
	 //@NotBlank(message = "File Location is mandatory")
	 
	 private  boolean status;
	 
	private Long fid;
	 
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

	
	
	
	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public List<DraftAnswerStatic> getDraftAnswers() {
		return draftAnswers;
	}

	public void setDraftAnswers(List<DraftAnswerStatic> draftAnswers) {
		this.draftAnswers = draftAnswers;
	}

	public List<FinalSubmitAnswerStatic> getFinalSubmitAnswer() {
		return finalSubmitAnswer;
	}

	public void setFinalSubmitAnswer(List<FinalSubmitAnswerStatic> finalSubmitAnswer) {
		this.finalSubmitAnswer = finalSubmitAnswer;
	}

	@Override
	public String toString() {
		return "AnswerStaticDto [id=" + id + ", draftAnswers=" + draftAnswers + ", finalSubmitAnswer="
				+ finalSubmitAnswer + ", status=" + status + ", fid=" + fid + "]";
	}

	
	
	
	
	

	
	
	
}
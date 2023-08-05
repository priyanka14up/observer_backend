package Observer20.Dto;

import java.util.List;

import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;

public class GetAnswerDto {
	private Long id;
	
	private  Long sid;
	
	private String subform_heading;
	
	 private List<DraftAnswer> draftAnswers;
		
	 private List<FinalSubmitAnswer> finalSubmitAnswer;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	
	public List<DraftAnswer> getDraftAnswers() {
		return draftAnswers;
	}
	public void setDraftAnswers(List<DraftAnswer> draftAnswers) {
		this.draftAnswers = draftAnswers;
	}
	public List<FinalSubmitAnswer> getFinalSubmitAnswer() {
		return finalSubmitAnswer;
	}
	public void setFinalSubmitAnswer(List<FinalSubmitAnswer> finalSubmitAnswer) {
		this.finalSubmitAnswer = finalSubmitAnswer;
	}
	
	
	public String getSubform_heading() {
		return subform_heading;
	}
	public void setSubform_heading(String subform_heading) {
		this.subform_heading = subform_heading;
	}
	@Override
	public String toString() {
		return "GetAnswerDto [id=" + id + ", sid=" + sid + ", subform_heading=" + subform_heading + ", draftAnswers="
				+ draftAnswers + ", finalSubmitAnswer=" + finalSubmitAnswer + "]";
	}
	 
}

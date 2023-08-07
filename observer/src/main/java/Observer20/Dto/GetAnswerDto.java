package Observer20.Dto;

import java.util.List;

import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;

public class GetAnswerDto {
	private Long id;
	
	private String subform_heading;
	
	 private List<DraftAnswer> draftAnswers;
		
	 private List<FinalSubmitAnswer> finalSubmitAnswers;
	 
	 
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
	public List<FinalSubmitAnswer> getFinalSubmitAnswers() {
		return finalSubmitAnswers;
	}
	public void setFinalSubmitAnswers(List<FinalSubmitAnswer> finalSubmitAnswers) {
		this.finalSubmitAnswers = finalSubmitAnswers;
	}
	public String getSubform_heading() {
		return subform_heading;
	}
	public void setSubform_heading(String subform_heading) {
		this.subform_heading = subform_heading;
	}
	@Override
	public String toString() {
		return "GetAnswerDto [id=" + id + ", subform_heading=" + subform_heading + ", draftAnswers=" + draftAnswers
				+ ", finalSubmitAnswers=" + finalSubmitAnswers + "]";
	}
	 
}

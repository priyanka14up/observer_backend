package Observer20.Dto;

import java.util.List;

import Observer20.Model.DraftAnswer;

public class UpdateAnswerDto {

	    private Long questionId;
	    private String updatedAnswer;
	    private List<DraftAnswer> draftAnswers;
	    private String submittedBy;
	    
		public Long getQuestionId() {
			return questionId;
		}
		public void setQuestionId(Long questionId) {
			this.questionId = questionId;
		}
		public String getUpdatedAnswer() {
			return updatedAnswer;
		}
		public void setUpdatedAnswer(String updatedAnswer) {
			this.updatedAnswer = updatedAnswer;
		}
		
		public List<DraftAnswer> getDraftAnswers() {
			return draftAnswers;
		}
		public void setDraftAnswers(List<DraftAnswer> draftAnswers) {
			this.draftAnswers = draftAnswers;
		}
		
		
		public String getSubmittedBy() {
			return submittedBy;
		}
		public void setSubmittedBy(String submittedBy) {
			this.submittedBy = submittedBy;
		}
		@Override
		public String toString() {
			return "UpdateAnswerDto [questionId=" + questionId + ", updatedAnswer=" + updatedAnswer + ", draftAnswers="
					+ draftAnswers + ", submittedBy=" + submittedBy + "]";
		}
		
	  
}

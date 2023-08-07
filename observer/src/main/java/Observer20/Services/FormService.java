package Observer20.Services;


import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import Observer20.Dto.AnswerDto;
import Observer20.Dto.FormSubformResponseDto;
import Observer20.Dto.GetAnswerDto;
import Observer20.Exception.HandledException;
import Observer20.Model.Answer;
import Observer20.Model.DraftAnswer;
import Observer20.Model.Form;
import Observer20.Model.FormSubformResponse;
import Observer20.Model.Question;
import Observer20.Model.Response;
import Observer20.Model.SubForm;
//import Observer20.Model.SubFormDraft;


public interface FormService {
	public List allForms() throws HandledException;
	public List allFormsByObsType(String obsType) throws HandledException;
	public List<Question> allQuestionsBySid(Long sid) throws HandledException;
	public Form createForm(HttpServletRequest request, @Valid Form form)throws HandledException;
	public List<SubForm> allSubformsByfid(Long fid)throws HandledException;
	public Long getSubFormIdByQid(Long qid)throws HandledException;
	public Long getFormIdBySid(Long sid)throws HandledException;
	public List<Response> createResponses(HttpServletRequest request, @Valid List<Response> responses)throws HandledException;
	public List<Answer> submitAnswers(HttpServletRequest request, @Valid List<Answer> answers)throws HandledException;
	//public List<Answer> submitAnswers(HttpServletRequest request, @Valid List<Answer> answers,@Valid @RequestBody FormSubformResponse formSubformResponse)throws HandledException;
	public List<Response> getResponses(String submittedBy)throws HandledException;
	//public List<SubFormDraft> fillSubForm(HttpServletRequest request, @Valid List<SubFormDraft> subFormDrafts)throws HandledException;
	//List<Answer> submitAnswers(HttpServletRequest request, @Valid List<Answer> answers, boolean status)
			//throws HandledException;
	FormSubformResponseDto submitAnswers(HttpServletRequest request, FormSubformResponseDto formSubformResponseDto)
			throws HandledException;
	
	//public FormSubformResponse getAnswers(Long fid)throws HandledException;
	
	//public GetAnswerDto getAnswers(Long fid)throws HandledException;
	HashMap<String, Object> submitAnswers(HttpServletRequest request, AnswerDto nswerDto) throws HandledException;
	
	//public HashMap<String, Object> getAnswers(String userid, Long fid, Long sid) throws HandledException;
	public HashMap<String, Object> getDraftAnswers(String userid, Long fid, Long sid) throws HandledException;
}

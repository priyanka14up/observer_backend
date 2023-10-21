package Observer20.Services;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import Observer20.Dto.AnswerDto;
import Observer20.Dto.AnswerStaticDto;
import Observer20.Dto.QuestionProjection;
import Observer20.Dto.QuestionStaticArrivalDto;
import Observer20.Dto.UpdateAnswerDto;
//import Observer20.Dto.FormSubformResponseDto;
import Observer20.Exception.HandledException;
//import Observer20.Model.Answer;
import Observer20.Model.Form;
import Observer20.Model.FormDates;
import Observer20.Model.FormStatus;
import Observer20.Model.Messages;
//import Observer20.Model.FormSubformResponse;
import Observer20.Model.Question;
import Observer20.Model.QuestionStatic;
import Observer20.Model.Response;
import Observer20.Model.SubForm;
//import Observer20.Dto.AnswerDto;
import java.util.*;
//import Observer20.Model.SubFormDraft;


public interface FormService {
	public List allForms() throws HandledException;
	public List allFormsByObsType(String obsType) throws HandledException;
	public List allFormsByObsType1(String obsType,String userId) throws HandledException;
	public List<Question> allQuestionsBySid(Long sid) throws HandledException;
	public Form createForm(HttpServletRequest request, @Valid Form form)throws HandledException;
	public List<SubForm> allSubformsByfid(Long fid)throws HandledException;
	public Long getSubFormIdByQid(Long qid)throws HandledException;
	public Long getFormIdBySid(Long sid)throws HandledException;
	public List<Response> createResponses(HttpServletRequest request, @Valid List<Response> responses)throws HandledException;
	//public List<Answer> submitAnswers(HttpServletRequest request, @Valid List<Answer> answers)throws HandledException;
	//public List<Answer> submitAnswers(HttpServletRequest request, @Valid List<Answer> answers,@Valid @RequestBody FormSubformResponse formSubformResponse)throws HandledException;
	public List<Response> getResponses(String submittedBy)throws HandledException;
	//public List<SubFormDraft> fillSubForm(HttpServletRequest request, @Valid List<SubFormDraft> subFormDrafts)throws HandledException;
	//List<Answer> submitAnswers(HttpServletRequest request, @Valid List<Answer> answers, boolean status)
			//throws HandledException;
	//FormSubformResponseDto submitAnswers(HttpServletRequest request, FormSubformResponseDto formSubformResponseDto)
			//throws HandledException;

	
	//public FormSubformResponse getAnswers(Long fid)throws HandledException;
	
	//public GetAnswerDto getAnswers(Long fid)throws HandledException;
	HashMap<String, Object> submitAnswers(HttpServletRequest request, AnswerDto nswerDto,String consistuency) throws HandledException;
	HashMap<String, Object> submitAndUpdateAnswers(HttpServletRequest request, AnswerDto nswerDto,String consistuency) throws HandledException;

	//HashMap<String, Object> submitAnswersPut(HttpServletRequest request, AnswerDto nswerDto,String consistuency) throws HandledException;
	HashMap<String, Object> updateAnswer(HttpServletRequest request,AnswerDto answerDto,Long fid,Long sid) throws HandledException;
	//public HashMap<String, Object> getAnswers(String userid, Long fid, Long sid) throws HandledException;
	public HashMap<String, Object> getDraftAnswers(String userid, Long fid, Long sid) throws HandledException;
	public HashMap<String, Object> submitAllDraft(String obsType,Long fid)throws HandledException;
	public List<HashMap<String, Object>> getFinalAnswers(String userid, Long fid) throws HandledException;
	public List<HashMap<String, Object>> getAllDraftAnswers(String userid, Long fid) throws HandledException;
	public List<HashMap<String, Object>> allFormsByConsistuency(String obsType,String Consistuency,String userId)throws HandledException;
	HashMap<String, Object> submitDates(HttpServletRequest request,FormDates formDates) throws HandledException;
	HashMap<String, Object> updateDates(Long fid,FormDates formDates) throws HandledException;
	HashMap<String, Object> updateFormName(Long fid,Form form) throws HandledException;
	HashMap<String, Object> updateSubFormHeading(Long sid,SubForm subForm) throws HandledException;
	HashMap<String, Object> updateSubFormHeadingsByFid(Long sid,List<SubForm> subForms) throws HandledException;
	HashMap<String, Object> getFormById(Long fid)throws HandledException;
	Map<String, Boolean> deleteForm(Long fid)throws HandledException;
	public boolean FormByConsistuency(String userId,Long sid)throws HandledException;
	public List allDownload() throws HandledException;
	public HashMap<String, Object> getArrivalDepartureData(String userid,String constituency,Long fid) throws HandledException;
	//delete submitted forms
	Map<String, Boolean> deleteSubmittedForm(String obsCode)throws HandledException;
	//for submitting messages
	HashMap<String, Object> submitMessages(HttpServletRequest request,Messages messages) throws HandledException;
	
	//for submitting questions static
	//HashMap<String, Object> saveQuestionsStatic(HttpServletRequest request,QuestionStatic questionStatic) throws HandledException;
	
	//for fetching questions static
	//public List<QuestionStatic> getQuestionStatic(Long fid)throws HandledException;
	//List<Map<String, List<QuestionStatic>>>
	//public Map<String, List<QuestionStatic>> getQuestionStatic(Long fid)throws HandledException;
	//public List<Map<String, List<QuestionStatic>>> getQuestionStatic(Long fid)throws HandledException;
	//Map<String, List<QuestionProjection>> getQuestionStatic(Long fid)throws HandledException;
	Map<Object, List<Object>> getQuestionStatic(Long fid)throws HandledException;
	
	//Map<String, Map<String, List<QuestionStatic>>>
	public List<FormStatus> allFormsStatus() throws HandledException;
	public List<FormStatus> allFormsStatusByState(String statecode) throws HandledException; ;
	HashMap<String, Object> submitAndUpdateAnswersStatic(HttpServletRequest request, AnswerStaticDto answerStaticDto,String consistuency) throws HandledException;
}

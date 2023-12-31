package Observer20.Services;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import Observer20.Exception.HandledException;
import Observer20.Model.Form;
import Observer20.Model.Question;
import Observer20.Model.Response;
import Observer20.Model.SubForm;


public interface FormService {
	public List allForms() throws HandledException;
	public List allFormsByObsType(String obsType) throws HandledException;
	public List<Question> allQuestionsBySid(Long sid) throws HandledException;
	public Form createForm(HttpServletRequest request, @Valid Form form)throws HandledException;
	public List<SubForm> allSubformsByfid(Long fid)throws HandledException;
	public Long getSubFormIdByQid(Long qid)throws HandledException;
	public Long getFormIdBySid(Long sid)throws HandledException;
	public List<Response> createResponses(HttpServletRequest request, @Valid List<Response> responses)throws HandledException;
	public List<Response> getResponses(String submittedBy)throws HandledException;
}

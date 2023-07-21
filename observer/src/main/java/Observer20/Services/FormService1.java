//
//package Observer20.Services;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import Observer20.Dto.QuestionRequest;
//import Observer20.Exception.HandledException;
//import Observer20.Model.Form;
//import Observer20.Model.Form1;
//import Observer20.Model.Question;
//import Observer20.Model.Question1;
//import Observer20.Model.SubForm;
//import Observer20.Model.SubForm1;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;
//
//
//
//public interface FormService1 {
//	public List allForms() throws HandledException;
//	public List allFormsByObsType(String obsType) throws HandledException;
//	public List<Question1> allQuestionsBySid(Long sid) throws HandledException;
//	//public HashMap<String, Object> createForm(HttpServletRequest request, Form form,SubForm subForm,Question question)throws HandledException;
//	//public HashMap<String, Object> createSubForm(HttpServletRequest request, SubForm form)throws HandledException;
//	//public SubForm postFile(HttpServletRequest request, SubForm subForm) throws HandledException;
//	//public HashMap<String, Object> createQuestion(HttpServletRequest request, Question question) throws HandledException;
//	//public FormDetails getAllQuestionsByFormId(Long fId) throws HandledException;
//	public Form1 createForm(HttpServletRequest request, @Valid Question1 question)throws HandledException;
//	//public List<SubForm> allSubformsByfid(Long fid)throws HandledException;
//	public List<SubForm1> allSubformsByfid(Long fid)throws HandledException;
//	
//	public Long getSubFormIdByQid(Long qid)throws HandledException;
//}

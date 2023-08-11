
package Observer20.Controller;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Observer20.Dto.AnswerDto;
import Observer20.Dto.FormSubformResponseDto;
import Observer20.Dto.GetAnswerDto;
import Observer20.Exception.HandledException;
import Observer20.Model.Answer;
import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;
import Observer20.Model.Form;
import Observer20.Model.FormStatus;
import Observer20.Model.FormSubformResponse;
import Observer20.Model.Question;
import Observer20.Model.Response;
import Observer20.Model.SubForm;
//import Observer20.Model.SubFormDraft;
import Observer20.Services.FormService;
import Observer20.errors.ResponseHandler;
import Observer20.repository.FormServiceRepo;
import Observer20.repository.SubFormRepo;
@RestController
@RequestMapping("/api/v2")
public class FormController {

	@Autowired
	public FormService formService;
	
	@Autowired
	public FormServiceRepo formServiceRepo;
	
	@Autowired 
	public SubFormRepo subFormRepo;

	@GetMapping("/form")
	public ResponseEntity<Object> getAllForms() throws HandledException {

		try {

			List formData = (List) formService.allForms();
			return ResponseHandler.generateResponse("success", HttpStatus.OK, formData);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

		}

	}
	
	@GetMapping("/forms/{obsType}")
	public ResponseEntity<Object> getAllFormsByObsType(@PathVariable("obsType") String obsType) throws HandledException {

		try {

			List formData = (List) formService.allFormsByObsType(obsType);
			return ResponseHandler.generateResponse("success", HttpStatus.OK, formData);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

		}

	}
	
	
	@PostMapping("/createform")
	public ResponseEntity<Object> createForm(HttpServletRequest request, @Valid @RequestBody Form form) throws HandledException {
		try {

			Object obj = null;
			//formService.createForm(request,form,subForm,question);
			
			formService.createForm(request,form);
			return ResponseHandler.generateResponse("success", HttpStatus.OK, obj);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}
	/*getting questions by subform id*/
	@GetMapping("/questions/{sid}")
	public ResponseEntity<Object> getAllQuestionsBySid(@PathVariable("sid") Long sid) throws HandledException {

		try {
			System.out.println("starting controller");
			List<Question> formData =formService.allQuestionsBySid(sid);
			List<Object> data = new ArrayList<Object>();
			JSONArray array = new JSONArray();
			for(Question q: formData) {
				data.add(q.getQid());
				data.add(q.getQname());
				data.add(q.getInputType());
				array.put(data);
				data = new ArrayList<Object>();
			}
			
			// can be in used
//			ObjectMapper obj = new ObjectMapper();
//			String str = obj.writeValueAsString(array.toString());
			return ResponseHandler.generateResponse("success", HttpStatus.OK,array.toString());
			
		} catch (Exception e) {
			System.out.println(e);
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST,null);

		}

	}
	
	/*Getting subforms by form id*/
	
	@GetMapping("/subforms/{id}")
		public ResponseEntity<Object> getAllSubFormsByFid(@PathVariable("id") Long id) throws HandledException, JsonProcessingException {
		try {
			System.out.println("starting controller");
			List<SubForm> formData =formService.allSubformsByfid(id);
			List<Object> data = new ArrayList<Object>();
			JSONArray array = new JSONArray();
			for(SubForm s: formData) {
				data.add(s.getSid());
				data.add(s.getHeading());
				array.put(data);
				data = new ArrayList<Object>();
			}
			
			//can be used
			//ObjectMapper obj = new ObjectMapper();
			//String str = obj.writeValueAsString(array.toString());
			
			return ResponseHandler.generateResponse("success", HttpStatus.OK,array.toString());
		} 
		catch(HandledException e)
		{
			System.out.println(e);
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST,null);

		}

	}
	
	@GetMapping("/subformid/{qid}")
	public ResponseEntity<Object> getSubFormIdByQid(@PathVariable("qid") Long qid) throws HandledException {

		try {
			System.out.println("before");
			Long sid = formService.getSubFormIdByQid(qid);
			System.out.println("after");
			return ResponseHandler.generateResponse("success", HttpStatus.OK, sid);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

		}

	}
	
	@GetMapping("/formid/{sid}")
	public ResponseEntity<Object> getFormIdBySid(@PathVariable("sid") Long sid) throws HandledException {

		try {
			System.out.println("before");
			Long fid = formService.getFormIdBySid(sid);
			System.out.println("after");
			return ResponseHandler.generateResponse("success", HttpStatus.OK, fid);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

		}

	}
	
	@PostMapping("/createResponse")
	public ResponseEntity<Object> createResponse(HttpServletRequest request, @Valid @RequestBody List<Response> responses) throws HandledException {
		try {
			
			List<Response> result=formService.createResponses(request,responses);
	
			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}
	
	@GetMapping("/responses/{submittedBy}")
	public ResponseEntity<Object> getResponses(@PathVariable("submittedBy") String submittedBy) throws HandledException {
		try {

			
			
			List<Response> result=formService.getResponses(submittedBy);
	
			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		
	}
	
//	@PostMapping("/submitAnswers")
//	public ResponseEntity<Object> submitAnswers(HttpServletRequest request, @Valid @RequestBody List<Answer> answers) throws HandledException {
//		try {
//			
//			List<Answer> result=formService.submitAnswers(request,answers);
//	
//			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);
//
//		} catch (HandledException e) {
//
//			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
//		}
//	}
	
	//response and status
//	@PostMapping("/submitAnswers1")
//		public ResponseEntity<Object> submitAnswers(HttpServletRequest request,@Valid @RequestBody FormSubformResponseDto formSubformResponseDto) throws HandledException {
//			
//		try {
//			
//			//List<Answer> result=formService.submitAnswers(request,answers,status);
//			FormSubformResponseDto result=formService.submitAnswers(request,formSubformResponseDto);
//			//FormSubformResponseDto result=formService.submitAnswers(request,formSubformResponseDto);
//			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);
//
//		} catch (HandledException e) {
//
//			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
//		}
//	}
	
	@GetMapping("/draftanswers/{userid}/{fid}/{sid}")
	public ResponseEntity<Object> getAnswers(@PathVariable("userid")String userid,@PathVariable("fid") Long fid,@PathVariable("sid") Long sid) throws HandledException {
		try {

		HashMap<String, Object> result=formService.getDraftAnswers(userid,fid,sid);
	
			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		
	}
	
	@GetMapping("/finalanswers/{userid}/{fid}")
	public ResponseEntity<Object> getFinalAnswers(@PathVariable("userid")String userid,@PathVariable("fid") Long fid) throws HandledException {
		try {

			List<HashMap<String, Object>> result=formService.getFinalAnswers(userid,fid);
	
			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		
	}
	
	@PostMapping("/submitAnswers")
	public ResponseEntity<Object> submitAnswers(HttpServletRequest request,@Valid @RequestBody AnswerDto answerDto) throws HandledException {
		
	try {
		
		//List<Answer> result=formService.submitAnswers(request,answers,status);
		HashMap<String, Object> result=formService.submitAnswers(request,answerDto);
		//FormSubformResponseDto result=formService.submitAnswers(request,formSubformResponseDto);
		return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

	} catch (HandledException e) {

		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
	}
}
	
	
//	@GetMapping("/forms/{consistuency}")
//	public ResponseEntity<Object> getAllFormsStatusByConsistuency(@PathVariable("consistuency") String consistuency) throws HandledException {
//
//		try {
//
//			List formData = (List) formService.allFormsByConsistuency(consistuency);
//			return ResponseHandler.generateResponse("success", HttpStatus.OK, formData);
//
//		} catch (HandledException e) {
//
//			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
//
//		}
//
//	}
	
	
}

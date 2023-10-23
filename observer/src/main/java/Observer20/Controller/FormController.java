
package Observer20.Controller;
import java.io.IOException;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.rest.api.v2010.account.Message;

import Observer20.Dto.AnswerDto;
import Observer20.Dto.AnswerStaticDto;
import Observer20.Dto.EciObserverResponse;
//import Observer20.Dto.AnswerDto;
//import Observer20.Dto.FormSubformResponseDto;
import Observer20.Dto.GetAnswerDto;
import Observer20.Dto.QuestionProjection;
import Observer20.Dto.UpdateAnswerDto;
import Observer20.Dto.QuestionStaticArrivalDto;
import Observer20.Exception.HandledException;
//import Observer20.Model.Answer;
import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;
import Observer20.Model.Form;
import Observer20.Model.FormDates;
import Observer20.Model.FormStatus;
import Observer20.Model.Messages;
//import Observer20.Model.FormSubformResponse;
import Observer20.Model.Question;
import Observer20.Model.QuestionStatic;
import Observer20.Model.Response;
import Observer20.Model.SubForm;
import Observer20.Response.EciObserverArravalResponse;
import Observer20.Response.EciObserverArrivalRequest;
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

	// controller    @Autowired
			//private EciObserverService eciObserverService;
	
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
	
	
	@GetMapping("/forms/{obsType}/{userId}")
	public ResponseEntity<Object> getAllFormsByObsType1(@PathVariable("obsType") String obsType,@PathVariable("userId") String userId) throws HandledException {

		try {

			List formData = (List) formService.allFormsByObsType1(obsType,userId);
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
				data.add(q.getInputLabel());
				data.add(q.isRemarkStatus());
				data.add(q.getRemarkLabel());
				data.add(q.getQserial());
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
	
	
	
	@GetMapping("/questionsV2/{sid}")
	public ResponseEntity<Object> getAllQuestionsBySidJson(@PathVariable("sid") Long sid) throws HandledException {
	    try {
	        System.out.println("starting controller");
	        List<Question> formData = formService.allQuestionsBySid(sid);
	        List<Object> data = new ArrayList<>();

	        for (Question q : formData) {
	            Map<String, Object> questionData = new HashMap<>();
	            questionData.put("qid", q.getQid());
	            questionData.put("qname", q.getQname());
	            questionData.put("inputType", q.getInputType());
	            questionData.put("inputLabel", q.getInputLabel());
	            questionData.put("remarkStatus", q.isRemarkStatus());
	            questionData.put("remarkLabel", q.getRemarkLabel());
	            questionData.put("questionSerial", q.getQserial());
	            data.add(questionData);
	        }

	        return ResponseHandler.generateResponse("success", HttpStatus.OK,data);
	        //return data;
	    } catch (Exception e) {
	        System.out.println(e);
	        return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST,null);
	        //throw new HandledException(e.getMessage(), "CHECK_PARAMETERS");
	    }
	}
	
	/*Getting subforms by form id*/
	
	@GetMapping("/subforms/{id}")
	
	public ResponseEntity<Object> getAllSubFormsByFid(@PathVariable("id") Long id) throws HandledException, JsonProcessingException {
		try {
			
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
	
@GetMapping("/subformsV2/{id}")
	
	public ResponseEntity<Object> getAllSubFormsByFidJson(@PathVariable("id") Long id) throws HandledException, JsonProcessingException {
		
		 try {
		        System.out.println("starting controller");
		        List<SubForm> formData =formService.allSubformsByfid(id);
		        List<Object> data = new ArrayList<>();

		        for (SubForm s : formData) {
		            Map<String, Object> subformData = new HashMap<>();
		            subformData.put("sid",s.getSid());
		            subformData.put("heading",s.getHeading());
		           
		            data.add(subformData);
		        }

		        return ResponseHandler.generateResponse("success", HttpStatus.OK,data);
		        //return data;
		    } catch (Exception e) {
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
	
			if (result == null|| result.isEmpty()) {
	            return ResponseHandler.generateResponse("No final answers found", HttpStatus.NOT_FOUND, null);
	        }
			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		
	}
	
	
	@GetMapping("/draftanswers/{userid}/{fid}")
	public ResponseEntity<Object> getAllDraftAnswers(@PathVariable("userid")String userid,@PathVariable("fid") Long fid) throws HandledException {
		try {

			List<HashMap<String, Object>> result=formService.getAllDraftAnswers(userid,fid);
	
			if (result == null|| result.isEmpty()) {
	            return ResponseHandler.generateResponse("No draft answers found", HttpStatus.NOT_FOUND, null);
	        }
			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		
	}
	
	@PostMapping("/submitAnswers/{consistuency}")
	public ResponseEntity<Object> submitAnswers(HttpServletRequest request,@Valid @RequestBody AnswerDto answerDto,@PathVariable("consistuency")String consistuency) throws HandledException {
		
	try {
		HashMap<String, Object> result=formService.submitAnswers(request,answerDto,consistuency);
		return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

	} catch (HandledException e) {

		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
	}
}
	
	@PostMapping("/submitAllDraft/{userid}/{fid}")
	public ResponseEntity<Object> submitAllDraft(@PathVariable("userid")String userid,@PathVariable("fid")Long fid) throws HandledException {
		
	try {
		HashMap<String, Object> result=formService.submitAllDraft(userid,fid);
		return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

	} catch (HandledException e) {

		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
	}
}
	
	 @PutMapping("/update/{fid}/{sid}")
	    public ResponseEntity<Object> updateAnswer(HttpServletRequest request,@RequestBody AnswerDto updateAnswerDto,@PathVariable("fid")Long fid,@PathVariable("sid")Long sid) {
	        try {
	            // Call the service layer to update the answer
	            HashMap<String, Object> result = formService.updateAnswer(request,updateAnswerDto,fid,sid);
	            return ResponseHandler.generateResponse("success", HttpStatus.OK,result);
	           
	        } catch (HandledException e) {
	            // Handle exceptions and return an appropriate response
	        	return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
	           
	        }
	    }

	 @PutMapping("/submitAndUpdateAnswers/{consistuency}")
		public ResponseEntity<Object> submitAndUpdateAnswers(HttpServletRequest request,@Valid @RequestBody AnswerDto answerDto,@PathVariable("consistuency")String consistuency) throws HandledException {
			
		try {
			HashMap<String, Object> result=formService.submitAndUpdateAnswers(request,answerDto,consistuency);
			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}
	 

	 @PutMapping("/submitAndUpdateAnswersStatic/{consistuency}")
		public ResponseEntity<Object> submitAndUpdateAnswersStatic(HttpServletRequest request,@Valid @RequestBody AnswerStaticDto answerStaticDto,@PathVariable("consistuency")String consistuency) throws HandledException {
			
		try {
			HashMap<String, Object> result=formService.submitAndUpdateAnswersStatic(request,answerStaticDto,consistuency);
			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}
	 
	 
	
	/*dashboard*/
	@GetMapping("/forms/{obsType}/{constituency}/{userId}")
	public ResponseEntity<Object> getAllFormsStatusByConsistuency(@PathVariable("obsType") String obsType,@PathVariable("constituency") String consistuency,@PathVariable("userId")String userId) throws HandledException {

		try {

			List<HashMap<String, Object>>formData = formService.allFormsByConsistuency(obsType,consistuency,userId);
			 //List<HashMap<String, Object>> listOfMsgMaps = new ArrayList<>();
			 //listOfMsgMaps.add(formData);
			return ResponseHandler.generateResponse("success", HttpStatus.OK, formData);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

		}

	}
	
	
//	@GetMapping("/forms/{obsType}/{constituency}/{userId}")
//	public ResponseEntity<Object> getAllFormsStatusByConsistuency1(@PathVariable("obsType") String obsType,@PathVariable("constituency") String consistuency,@PathVariable("userId")String userId) throws HandledException {
//
//		try {
//
//			List<HashMap<String, Object>>formData = formService.allFormsByConsistuency(obsType,consistuency,userId);
//			 //List<HashMap<String, Object>> listOfMsgMaps = new ArrayList<>();
//			 //listOfMsgMaps.add(formData);
//			return ResponseHandler.generateResponse("success", HttpStatus.OK, formData);
//
//		} catch (HandledException e) {
//
//			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
//
//		}
//
//	}
//	
//	
//	
	
	@PostMapping("/saveDates")
	public ResponseEntity<Object> submitDates(HttpServletRequest request,@Valid @RequestBody FormDates formdates) throws HandledException {
		
	try {
		HashMap<String, Object> result=formService.submitDates(request,formdates);
		return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

	} catch (HandledException e) {

		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
	}
}
	
	@PutMapping("/updateDates/{fid}")
	public ResponseEntity<Object> updateDates(@PathVariable("fid")Long fid,@RequestBody FormDates formDates) throws HandledException {
		
	try {
		HashMap<String, Object> result=formService.updateDates(fid,formDates);
		return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

	} catch (HandledException e) {

		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
	}
}
	
	@PutMapping("/updateForm/{fid}")
	public ResponseEntity<Object> updateForm(@PathVariable("fid")Long fid,@RequestBody Form form) throws HandledException {
		
	try {
		HashMap<String, Object> result=formService.updateFormName(fid,form);
		return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

	} catch (HandledException e) {

		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
	}
}
	
	@PutMapping("/updateSubForm/{sid}")
	public ResponseEntity<Object> updateSubForm(@PathVariable("sid")Long fid,@RequestBody SubForm subForm) throws HandledException {
		
	try {
		HashMap<String, Object> result=formService.updateSubFormHeading(fid,subForm);
		return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

	} catch (HandledException e) {

		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
	}
}
	@PutMapping("/updateSubForms/{fid}")
	public ResponseEntity<Object> updateSubForms(@PathVariable("fid")Long fid,@RequestBody List<SubForm> subForms) throws HandledException {
		
	try {
		HashMap<String, Object> result=formService.updateSubFormHeadingsByFid(fid,subForms);
		return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

	} catch (HandledException e) {

		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
	}
}
//	@PutMapping("/updateOneAnwer/{qid}")
//	public ResponseEntity<Object> updateAnswerByQid(@PathVariable("qid")Long qid) throws HandledException {
//		
//	try {
//		HashMap<String, Object> result=formService.updateAnswerByQid(qid);
//		return ResponseHandler.generateResponse("success", HttpStatus.OK,result);
//
//	} catch (HandledException e) {
//
//		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
//	}
//}
	
	
	
	@GetMapping("/getform/{formId}")
	public ResponseEntity<Object> getFormById(@PathVariable Long formId) {
		
		try {
			HashMap<String, Object> result=formService.getFormById(formId);
			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	
	}

	@DeleteMapping("/deleteForm/{formId}")
    public ResponseEntity<Object> deleteForm(@PathVariable Long formId) {
       
        
        try {

			Map<String, Boolean> messageData = formService.deleteForm(formId);
			return ResponseHandler.generateResponse("deleted successfully", HttpStatus.OK, messageData);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
    }
	
	 @Transactional
	@DeleteMapping("/deleteSubmittedForm/{obsCode}")
    public ResponseEntity<Object> deleteSubmittedForm(@PathVariable String obsCode) {
       
        
        try {

			Map<String, Boolean> messageData = formService.deleteSubmittedForm(obsCode);
			return ResponseHandler.generateResponse("deleted successfully", HttpStatus.OK, messageData);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
    }
	
	@GetMapping("/form/{userId}/{sid}")
	public ResponseEntity<Object> getFormsStatusByConsistuency(@PathVariable("userId")String userId,@PathVariable("sid")Long sid) throws HandledException {

		try {

			boolean result = formService.FormByConsistuency(userId,sid);
			
			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

		}
	
	
}
	@GetMapping("/download")
	public ResponseEntity<Object> getAllFolder() throws HandledException {

		try {

			List downloadData = (List) formService.allDownload();
			return ResponseHandler.generateResponse("success", HttpStatus.OK, downloadData);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

		}

	}
	
	@GetMapping("/arrivalDeparture/{userid}/{constituency}/{fid}")
	public ResponseEntity<Object> getArrivalDepartureData(@PathVariable("userid")String userid,@PathVariable("constituency")String constituency,@PathVariable("fid")Long fid) throws HandledException {
		try {
			
		HashMap<String, Object> result=formService.getArrivalDepartureData(userid,constituency,fid);
	
		
			return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		
	}
	
	
	@GetMapping("/form/status")
	public ResponseEntity<Object> getAllFormsStatus() throws HandledException {

		try {

			List<FormStatus> formData = formService.allFormsStatus();
			return ResponseHandler.generateResponse("success", HttpStatus.OK, formData);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

		}

	}
	
	@GetMapping("/form/status/{statecode}")
	public ResponseEntity<Object> getAllFormsStatusByState(@PathVariable("statecode") String statecode) throws HandledException {

		try {

			List<FormStatus> formData = formService.allFormsStatusByState(statecode);
			return ResponseHandler.generateResponse("success", HttpStatus.OK, formData);

		} catch (HandledException e) {

			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

		}

	}

	@PostMapping("/saveMessages")
	public ResponseEntity<Object> saveMessages(HttpServletRequest request,@Valid @RequestBody Messages messages) throws HandledException {
		
	try {
		HashMap<String, Object> result=formService.submitMessages(request,messages);
		return ResponseHandler.generateResponse("success", HttpStatus.OK,result);

	} catch (HandledException e) {

		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
	}
}
	
	
//	@PostMapping("/saveQuestionsStatic")
//	public ResponseEntity<Object> saveQuestionsStatic(HttpServletRequest request,@Valid @RequestBody QuestionStatic questionStatic) throws HandledException {
//		
//	try {
//		HashMap<String, Object> result=formService.saveQuestionsStatic(request,questionStatic);
//		return ResponseHandler.generateResponse("success", HttpStatus.OK,result);
//
//	} catch (HandledException e) {
//
//		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
//	}
//}
	
	@GetMapping("/questionsStatic/{fid}")
	public ResponseEntity<Object> getQuestionStatic(@PathVariable("fid") Long fid) throws HandledException {

		try {

			//List formData = (List) formService.getQuestionStatic(fid);
			//Map<String, List<QuestionStatic>> formData=formService.getQuestionStatic(fid);
			//Map<String,List<QuestionStatic>> lists=formService.getQuestionStatic(fid);
			//List<Map<String, List<QuestionStatic>>> lists=formService.getQuestionStatic(fid);
			Map<Object, List<Object>> lists=formService.getQuestionStatic(fid);
			
			
			//Map<String, Map<String, List<QuestionStatic>>>
			
			//List<QuestionStatic> formData=formService.getQuestionStatic(fid);
			//return formData;
			//return ResponseHandler.generateResponse("success", HttpStatus.OK, formData);
			return ResponseEntity.ok(lists);
		} catch (HandledException e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			//return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

		}

	}
	
	

		 @GetMapping("/getListOfEciObserver")
		    public ResponseEntity<Map<Object, List<EciObserverResponse>>> getEciObserverObservations(@RequestParam("formId") Integer formId,@RequestParam("sId") Integer sId) throws IOException {
		        Map<Object, List<EciObserverResponse>> response = formService.getListOfEciObserver(formId,sId);
		        return new ResponseEntity<>(response, HttpStatus.OK);
		    }
		 @PostMapping("/saveArrrivalDetails")
			public ResponseEntity<Object> saveComplainaintRespondent(
					@RequestBody EciObserverArrivalRequest eciObserverArrivalRequest, HttpServletRequest request)
					throws IOException {
				if (Objects.isNull(eciObserverArrivalRequest.getFormId())) {

					return ResponseHandler.generateResponse("formId is Null", HttpStatus.BAD_REQUEST, null);
				}

				ResponseEntity<Object> response = formService.saveArrival(eciObserverArrivalRequest);
				return response;

			}
		 @GetMapping("/getListOfEciObserverArrival")
		    public ResponseEntity<Map<String, List<EciObserverArravalResponse>>>
		            getListOfEciObserverArrival(@RequestParam("formId") Integer formId) throws IOException {
		        Map<String, List<EciObserverArravalResponse>> response = formService.getListOfEciObserverArrival(formId);
		        return ResponseEntity.ok(response);
		    }
			}
		
			
	
	
	
	
	

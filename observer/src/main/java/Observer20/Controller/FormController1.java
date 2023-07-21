//
//package Observer20.Controller;
//import java.util.*;
//
//import org.json.JSONArray;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import Observer20.Dto.QuestionRequest;
//import Observer20.Exception.HandledException;
//import Observer20.Model.Form;
//import Observer20.Model.Question;
//import Observer20.Model.Question1;
//import Observer20.Model.SubForm;
//import Observer20.Model.SubForm1;
//import Observer20.Services.FormService;
//import Observer20.Services.FormService1;
//import Observer20.errors.ResponseHandler;
//import Observer20.repository.FormServiceRepo;
//import Observer20.repository.FormServiceRepo1;
//import Observer20.repository.SubFormRepo;
//import Observer20.repository.SubFormRepo1;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;
//@RestController
//@RequestMapping("/api/v2")
//public class FormController1 {
//
//	@Autowired
//	public FormService1 formService;
//	
//	@Autowired
//	public FormServiceRepo1 formServiceRepo;
//	
//	@Autowired 
//	public SubFormRepo1 subFormRepo;
//
//	@GetMapping("/form")
//	public ResponseEntity<Object> getAllForms() throws HandledException {
//
//		try {
//
//			List formData = (List) formService.allForms();
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
//	@GetMapping("/forms/{obsType}")
//	public ResponseEntity<Object> getAllFormsByObsType(@PathVariable("obsType") String obsType) throws HandledException {
//
//		try {
//
//			List formData = (List) formService.allFormsByObsType(obsType);
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
//	@PostMapping("/createform")
//	public ResponseEntity<Object> createForm(HttpServletRequest request, @Valid @RequestBody Question1 question) throws HandledException {
//		try {
//
//			Object obj = null;
//			//formService.createForm(request,form,subForm,question);
//			
//			formService.createForm(request,question);
//			return ResponseHandler.generateResponse("success", HttpStatus.OK, obj);
//
//		} catch (HandledException e) {
//
//			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
//		}
//	}
//	/*getting questions by subform id*/
//	@GetMapping("questions/{sid}")
//	public ResponseEntity<String> getAllQuestionsBySid(@PathVariable("sid") Long sid) throws HandledException {
//
//		try {
//			System.out.println("starting controller");
//			List<Question1> formData =formService.allQuestionsBySid(sid);
//			List<Object> data = new ArrayList<Object>();
//			JSONArray array = new JSONArray();
//			for(Question1 q: formData) {
//				data.add(q.getQid());
//				data.add(q.getQname());
//				data.add(q.getInputType());
//				array.put(data);
//				data = new ArrayList<Object>();
//			}
//			ObjectMapper obj = new ObjectMapper();
//			String str = obj.writeValueAsString(array.toString());
//			return new ResponseEntity<String>(str, HttpStatus.OK);
//		} catch (Exception e) {
//			System.out.println(e);
//			return new ResponseEntity<String>(e.toString(),HttpStatus.BAD_REQUEST);
//
//		}
//
//	}
//	
//	/*Getting subforms by form id*/
//	@GetMapping("subforms/{id}")
//		public ResponseEntity<Object> getAllSubFormsByFid(@PathVariable("id") Long id) throws HandledException, JsonProcessingException {
//		try {
//			System.out.println("starting controller");
//			List<SubForm1> formData =formService.allSubformsByfid(id);
//			List<Object> data = new ArrayList<Object>();
//			JSONArray array = new JSONArray();
//			for(SubForm1 s: formData) {
//				data.add(s.getSid());
//				data.add(s.getHeading());
//				array.put(data);
//				data = new ArrayList<Object>();
//			}
//			ObjectMapper obj = new ObjectMapper();
//			String str = obj.writeValueAsString(array.toString());
//			return ResponseHandler.generateResponse("success", HttpStatus.OK, str);
//		} 
//		catch(HandledException e)
//		{
//			System.out.println(e);
//			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST,null);
//
//		}
//
//	}
//	
//	@GetMapping("/subFormId/qid")
//	public ResponseEntity<Object> getSubFormIdByQid(@PathVariable("qid") Long qid) throws HandledException {
//
//		try {
//			System.out.println("before");
//			Long sid = formService.getSubFormIdByQid(qid);
//			System.out.println("after");
//			return ResponseHandler.generateResponse("success", HttpStatus.OK, sid);
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
////	@PostMapping("/createsubform")
////	public ResponseEntity<Object> createSubForm(HttpServletRequest request, @Valid @RequestBody SubForm subFormDetails) throws HandledException {
////
////		try {
////
////			Object obj = null;
////			formService.createSubForm(request,subFormDetails);
////			return ResponseHandler.generateResponse("success", HttpStatus.OK, obj);
////
////		} catch (HandledException e) {
////
////			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
////		}
////	}
//	
//	
//	
////	@PostMapping("/subform")
////	public ResponseEntity<Object> createSubForm(HttpServletRequest request, @Valid @RequestBody SubForm subForm) throws HandledException {
////
////		try {
////
////			SubForm subFormData = formService.postFile(request,subForm);
////			return ResponseHandler.generateResponse("success", HttpStatus.OK, subFormData);
////
////		} catch (HandledException e) {
////
////			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
////		}
////	}
//	
////	@GetMapping("/forms/{sid}")
////	public ResponseEntity<Object> createQuestionBySid(HttpServletRequest request,@Valid @RequestBody Question question) throws HandledException {
////
////		try {
////
////			HashMap<String, Object> postDetail = formService.createQuestion(request, question);
////			return ResponseHandler.generateResponse("success", HttpStatus.OK, postDetail);
////
////		} catch (HandledException e) {
////
////			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
////		}
////
////	}
//	
////	public FormController(FormServiceRepo formServiceRepo, SubFormRepo subFormRepo) {
////        this.formServiceRepo = formServiceRepo;
////        this.subFormRepo = subFormRepo;
////    }
//	
//	
////	@PostMapping("/create/forms")
////    public ResponseEntity<Form> createForm(@RequestBody Form form) {
////        Form savedForm = formServiceRepo.save(form);
////        return ResponseEntity.status(HttpStatus.CREATED).body(savedForm); 
////    }
//	
//	
////	 @PostMapping
////	    public ResponseEntity<Form> createForm(@RequestBody Form formRequest) {
////	        Form form = new Form();
////	        form.setName(formRequest.getName());
////	        
////	        Set<SubForm> subforms = new HashSet<>();
////	        for (Long subformId : formRequest.getSubforms().get(0).getSid()) {
////	            Subform subform = subformRepository.findById(subformId).orElse(null);
////	            if (subform != null) {
////	                subforms.add(subform);
////	            }
////	        }
////	        form.setSubforms(subforms);
////
////	        Form savedForm = formRepository.save(form);
////	        return ResponseEntity.status(HttpStatus.CREATED).body(savedForm);
////	    }
//	
//	
//	
//	
//	/*@GetMapping("/question/{form_Id}")
//	public ResponseEntity<Object> getAllQuestionsByFormId(@PathVariable(value = "form_Id") Long fid) throws HandledException {
//
//		try {
//
//			FormDetails forms = formService.getAllQuestionsByFormId(fid);
//			return ResponseHandler.generateResponse("success", HttpStatus.OK, forms);
//
//		} catch (HandledException e) {
//
//			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
//		}
//
//	}*/
//	
//	
//	
//	
//}

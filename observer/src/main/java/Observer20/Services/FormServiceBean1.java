//
//package Observer20.Services;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Optional;
//
//import org.hibernate.bytecode.spi.ReflectionOptimizer.AccessOptimizer;
//import org.springframework.beans.factory.annotation.Autowired;
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
////import Observer20.repository.FormDetailsRepo;
//import Observer20.repository.FormServiceRepo;
//import Observer20.repository.FormServiceRepo1;
//import Observer20.repository.QuestionRepo;
//import Observer20.repository.QuestionRepo1;
//import Observer20.repository.SubFormRepo;
//import Observer20.repository.SubFormRepo1;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;
//
//@Service
//public class FormServiceBean1 implements FormService1 {
//
//	@Autowired
//	public FormServiceRepo1 formServiceRepo;
//	
//	@Autowired
//	public QuestionRepo1 questionRepo;
//	
//	@Autowired
//	public SubFormRepo1 subFormRepo;
//	
//	
//	@Autowired
////	public FormDetailsRepo formDetailsRepo;
//	
//	
//	@Override
//	public List allForms() throws HandledException {
//		// TODO Auto-generated method stub
//	
//		List<Form1> formData=new ArrayList<Form1>();
//		try{
//			
//			formData = formServiceRepo.findAll();
//			
//		}catch(Exception e) {
//			
//			 System.out.println(e);
//		return null;
//	}	
//		List formList = new ArrayList<>() ;
//		
//		for (int i = 0; i < formData.size(); i++){  
//			
//			formList.add(customResponseForm(formData.get(i)));  
//		}  
//		
//		return formList;
//		
//		
//}
//
//	//custom response
//		private HashMap<String, Object> customResponseForm( Form1 formData) {
//			
//			HashMap<String, Object> formMap =  new HashMap<>();
//			
//			formMap.put("id", formData.getId());
//			formMap.put("FormName", formData.getName());
//			formMap.put("ObserverType", formData.getObsType());
//
//			return formMap;
//			
//		}
//		
//
//		
//		//custom response
//				private HashMap<String, Object> customResponseQuestion( Question questionData) {
//					
//					HashMap<String, Object> questionMap =  new HashMap<>();
//					
//					questionMap.put("id", questionData.getQid());
//					questionMap.put("questionName", questionData.getQname());
//					questionMap.put("inputType", questionData.getQname());
//					//questionMap.put("subForm", questionData.getSubform());
//
//					return questionMap;
//					
//				}
//		
//
//	/*private HashMap<String, Object> customResponseFormDetails( FormDetails formDetails) {
//			
//			HashMap<String, Object> formMap =  new HashMap<>();
//			
////			formMap.put("formId",formDetails.getId());
////			formMap.put("SubFormId", formDetails.getSubForm_Id());
////			formMap.put("Heading", formDetails.getHeading());
////			formMap.put("QuestionIds", formDetails.getQids());
//
//			return formMap;
//			
//		}*/
//
//		@Override
//		public List allFormsByObsType(String obsType) throws HandledException {
//			// TODO Auto-generated method stub
//			
//			List<Form1> FormForGeneral=new ArrayList<Form1>();
//			try{
//				
//				 FormForGeneral=formServiceRepo.findAllByObsType(obsType);
//				
//			}catch(Exception e) {
//				
//				 System.out.println(e);
//			return null;
//		}	
//			List formList = new ArrayList<>() ;
//			
//			for (int i = 0; i < FormForGeneral.size(); i++){  
//				
//				formList.add(customResponseForm(FormForGeneral.get(i)));  
//			}  
//			
//			return formList;
//		
//		}
//
//		
//
////		@Override
////		public Form1 createForm(HttpServletRequest request, @Valid Question1 question)throws HandledException
////		{
////			
//////			 Form form1=formServiceRepo.save(form);
//////			 System.out.println(form1);
//////			return form1;
////			
////		
////			List<SubForm1> subForm1=new ArrayList<SubForm1>();
////			
////			
////			
////			
////		        // Set the form reference in subforms
////		        form.getSubforms().forEach(subform -> subform.setForm(form));
////
////		        // Set the subform reference in questions
////		        form.getSubforms().forEach(subform -> {
////		            subform.getQuestions().forEach(question -> question.setSubform(subform));
////		        });
////
////		        // Save the form to the database
////		        return formServiceRepo.save(form);
////		    
////		}
//
//		@Override
//		public List<Question1> allQuestionsBySid(Long sid) throws HandledException {
//			List<Question1> questions=questionRepo.findQuestionsBySubformSid(sid);
//			if(questions.size()!=0)
//			{
//				return questions;
//			}
//			else
//			{
//			throw new HandledException("CHECK_PARAMETERS", "Questions does not exist for this form id.");
//			}
//	        
//			
//			
//	      
//			
//			
//		}
//		public List<SubForm1> allSubformsByfid(Long fid) throws HandledException {
//			
//			List<SubForm1> subforms=subFormRepo.findSubFormsByFormId(fid);
//			
//			if(subforms.size()!=0)
//			{
//				return subforms;
//			}
//			else
//			{
//			throw new HandledException("CHECK_PARAMETERS", "Subform does not exist for this form id.");
//			}
//	        
//			
//		}
//
//		@Override
//		public Long getSubFormIdByQid(Long qid) throws HandledException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public Form1 createForm(HttpServletRequest request, @Valid Question1 question) throws HandledException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
////		@Override
////		public Long getSubFormIdByQid(Long qid) throws HandledException {
////			//Long sid=questionRepo.findSubformSidByQid(qid);
////			Question1 question=questionRepo.getById(qid);
////			//SubForm1 subForm=question.getSubform();
////			//Long sid=subForm.getSid();
////			return sid;
//////			Long sid;
//////			 if (questionOptional.isPresent()) {
//////				 sid=questionOptional.get().getSubform().getSid();
//////				 
//////		            return sid;        
//////		        } else {
//////		            // Handle subform not found scenario
//////		            throw new HandledException("Subform not found with for this questionID: ",Long.toString(qid));
//////		        }
////		}
//
//		
//		
//
//		//@Override
//		//public SubForm postFile(HttpServletRequest request, SubForm subForm) throws HandledException {
//			
//			
//			//SubForm subFormData = subFormRepo.getById(subForm.getSid());
////			Form existedForm=formServiceRepo.getById(subForm.getFid());
////
////			if((existedForm!=null)&&(existedForm.getId()==subForm.getFid()))
////			{
////				if(subForm.getSid()==null)
////				{
////				subForm.setHeading(subForm.getHeading());
////				subForm.setFid(subForm.getFid());
////				subFormRepo.save(subForm);
////				return subForm;
////				}
////				else
////				{SubForm subFormData = subFormRepo.getById(subForm.getSid());
//////					subFormData.setFid(subForm.getFid());
//////					subFormData.setHeading(subForm.getHeading());
//////					
//////					subFormRepo.save(subFormData);
//////					return subFormData;
////					throw new HandledException("CHECK_PARAMETERS", "SubForm exists in Database for " +subForm.getSid());
////				}
////			}
////			else
////			{
////				throw new HandledException("CHECK_PARAMETERS", "Form does not exist in Database for " +subForm.getFid());
////			}
////			
////			
////			
////		}
//
////		@Override
////		public HashMap<String, Object> createQuestion(HttpServletRequest request, Question question)
////				throws HandledException {
////			Question QuestionInDb =  (Question) questionRepo.findByQid(question.getQid());
////			HashMap<String, Object> msgMap = new HashMap<>();
////			
////			if (QuestionInDb == null) {
////				
////				questionRepo.save(question);
////				msgMap = customResponseQuestion(question);
////				
////			}else {
////				
////				 Optional<Question> ques = questionRepo.findById(QuestionInDb.getQid());
////				 
////				 ques.get().setQname(question.getQname());
////				 ques.get().setSubform();
////				 msg.get().setDisplayBoard(message.getDisplayBoard());
////				 msg.get().setDisplayStatus(message.getDisplayStatus());
////				 msg.get().setMessageEnglish(message.getMessageEnglish());
////				 msg.get().setMessageHindi(message.getMessageHindi());
////				 msg.get().setMessageRegional(message.getMessageRegional());
////				 msg.get().setMessageEffect(message.getMessageEffect());
////				 msg.get().setSpeed(message.getSpeed());
////				 msg.get().setLetterSize(message.getLetterSize());
////				 msg.get().setCharacterGap(message.getCharacterGap());
////				 msg.get().setPageChangeTime(message.getPageChangeTime());	 
////				 msg.get().setDisplayStatus(message.getDisplayStatus());
////				 msg.get().setUpdatedBy(String.valueOf(customUtil.getIdFromToken()));
////				 commonUtil.updateActivities("Message updated ", String.valueOf(customUtil.getIdFromToken()));
////				 messageRepository.save(msg.get());
////				 msgMap = customResponseMsg(msg.get());
////				
////			}
////			
////			return msgMap;
////			return null;
////		}
////
////		
//		
//		
//
//		/*@Override
//		public FormDetails getAllQuestionsByFormId(Long fId) throws HandledException {
//			
//			
//			FormDetails formDetail = formDetailsRepo.findByid(fId);
//					
//					
//		         return formDetail;
//			
//		    //return customResponseFormDetails(formDetail);
//			
//			//List<Question> FormForGeneral=new ArrayList<Form>();
//			//List forms=formServiceRepo.findAllByFormId(fId);
//		
////			List<Question> forms=new ArrayList<Question>();
////			try{
////				
////				forms=formServiceRepo.findAllByFormId(fId);
////				
////			}catch(Exception e) {
////				
////				 System.out.println(e);
////			return null;
////		}	
////			List formList = new ArrayList<>() ;
////			
////			for (int i = 0; i < FormForGeneral.size(); i++){  
////				
////				formList.add(customResponseForm(FormForGeneral.get(i)));  
////			}  
////			
////			return formList;
//			
//		}*/
//
//}

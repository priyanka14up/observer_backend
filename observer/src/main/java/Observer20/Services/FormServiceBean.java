package Observer20.Services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Observer20.Dto.FormSubformResponseDto;
import Observer20.Exception.HandledException;
import Observer20.Model.Answer;
import Observer20.Model.Form;
import Observer20.Model.FormSubformResponse;
import Observer20.Model.Question;
import Observer20.Model.Response;
import Observer20.Model.SubForm;
import Observer20.repository.AnswerRepo;
//import Observer20.Model.SubFormDraft;
//import Observer20.repository.FormDetailsRepo;
import Observer20.repository.FormServiceRepo;
import Observer20.repository.FormSubformResponsesRepo;
import Observer20.repository.QuestionRepo;
import Observer20.repository.ResponseRepo;
import Observer20.repository.SubFormRepo;

@Service
public class FormServiceBean implements FormService {

	@Autowired
	public FormServiceRepo formServiceRepo;
	
	@Autowired
	public QuestionRepo questionRepo;
	
	@Autowired
	public SubFormRepo subFormRepo;
	
	@Autowired
	public ResponseRepo responseRepo;
	
	@Autowired
	public AnswerRepo answerRepo;
	
	@Autowired
	public FormSubformResponsesRepo formSubformResponsesRepo;
	
	
	@Override
	public List allForms() throws HandledException {
		// TODO Auto-generated method stub
	
		List<Form> formData=new ArrayList<Form>();
		try{
			
			formData = formServiceRepo.findAll();
			
		}catch(Exception e) {
			
			 System.out.println(e);
		return null;
	}	
		
		
		
		List formList = new ArrayList<>() ;
		
		for (int i = 0; i < formData.size(); i++){  
			
			formList.add(customResponseForm(formData.get(i)));  
		}  
		
		return formList;
		
		
}

	//custom response
		private HashMap<String, Object> customResponseForm( Form formData) {
			
			HashMap<String, Object> formMap =  new HashMap<>();
			
			formMap.put("id", formData.getId());
			formMap.put("FormName", formData.getName());
			formMap.put("ObserverType", formData.getObsType());

			return formMap;
			
		}
		

		
		//custom response
				private HashMap<String, Object> customResponseQuestion( Question questionData) {
					
					HashMap<String, Object> questionMap =  new HashMap<>();
					
					questionMap.put("id", questionData.getQid());
					questionMap.put("questionName", questionData.getQname());
					questionMap.put("inputType", questionData.getQname());
					//questionMap.put("subForm", questionData.getSubform());

					return questionMap;
					
				}
		

		@Override
		public List allFormsByObsType(String obsType) throws HandledException {
			// TODO Auto-generated method stub
			
			List<Form> FormForGeneral=new ArrayList<Form>();
			try{
				
				 FormForGeneral=formServiceRepo.findAllByObsType(obsType);
				
			}catch(Exception e) {
				
				 System.out.println(e);
			return null;
		}	
			
			if(FormForGeneral.size()>0)
			{
				List formList = new ArrayList<>() ;
				
				for (int i = 0; i < FormForGeneral.size(); i++){  
					
					formList.add(customResponseForm(FormForGeneral.get(i)));  
				}  
				
				return formList;
			}
			
			else
			{
				throw new HandledException("CHECK_PARAMETERS", "Form does not exist for this observer type ");
			}
		
		}

		

		@Override
		public Form createForm(HttpServletRequest request, @Valid Form form)throws HandledException
		{	
			
		        // Set the form reference in subforms
		        form.getSubforms().forEach(subform -> subform.setForm(form));

		        // Set the subform reference in questions
		        form.getSubforms().forEach(subform -> {
		            subform.getQuestions().forEach(question -> question.setSubform(subform));
		        });

		        // Save the form to the database
		        return formServiceRepo.save(form);
		    
		}

		@Override
		public List<Question> allQuestionsBySid(Long sid) throws HandledException {
			List<Question> questions=questionRepo.findQuestionsBySubformSid(sid);
			if(questions.size()!=0)
			{
				return questions;
			}
			else
			{
			throw new HandledException("CHECK_PARAMETERS", "Questions does not exist for this form id.");
			}
		}
	
		public List<SubForm> allSubformsByfid(Long fid) throws HandledException {
			
			List<SubForm> subforms=subFormRepo.findSubFormsByFormId(fid);
			
			if(subforms.size()!=0)
			{
				return subforms;
			}
			else
			{
			throw new HandledException("CHECK_PARAMETERS", "Subform does not exist for this form id.");
			}
	        
			
		}

		@Override
		public Long getSubFormIdByQid(Long qid) throws HandledException {
			Long sid=questionRepo.findSubformSidByQid(qid);
			
			if (sid != null) {
		        return sid;
		    } else {
		    	throw new HandledException("CHECK_PARAMETERS", "Subform does not exist for this question id.");
		    }
			
		}

		@Override
		public Long getFormIdBySid(Long sid) throws HandledException {
			Long fid=subFormRepo.findFormIdBySid(sid);
			
			if (fid != null) {
		        return fid;
		    } else {
		    	throw new HandledException("CHECK_PARAMETERS", "form does not exist for this subform id.");
		    }
		}

		@Override
		public List<Response> createResponses(HttpServletRequest request, @Valid List<Response> responses) throws HandledException {
		
			List<Response> resultResponses = new ArrayList<Response>();
			try {
				
			for(int i=0;i<responses.size();i++)
			{
				Response response=responseRepo.findBySubmittedBy(responses.get(i).getSubmittedBy());
				if(response==null)
				{
					responses.get(i).setQid(responses.get(i).getQid());
					responses.get(i).setAnswer(responses.get(i).getAnswer());
					if((responses.get(i).getAnswer().equals("no"))||(responses.get(i).getAnswer().equals("NO"))||(responses.get(i).getAnswer().equals("No")))
					{
						responses.get(i).setRemarks(responses.get(i).getRemarks());
						
					}
					else
					{
						responses.get(i).setRemarks(null);
						
					}
					responses.get(i).setSubmittedBy(responses.get(i).getSubmittedBy());
				
					Long sid=questionRepo.findSubformSidByQid(responses.get(i).getQid());
					responses.get(i).setSid(sid);
					Long fid=subFormRepo.findFormIdBySid(sid);
					responses.get(i).setFid(fid);
					responseRepo.save(responses.get(i));
					resultResponses.add(responses.get(i));
					
				}else
				{
					throw new HandledException("CHECK_PARAMETERS", "this Question is already submitted by User");
				}
			}
			return resultResponses;
				}catch(Exception e)
				{
					throw new HandledException("exception in adding response", e.getMessage());
				}
				
		
		}

		@Override
		public List<Response> getResponses(String submittedBy) throws HandledException {
		
			List<Response> responses=new ArrayList<Response>();
			List responsesList = new ArrayList<>() ;
			try{
				responses=responseRepo.findAllBySubmittedBy(submittedBy);
				if(responses.size()>0)
				{
					
					for (int i = 0; i < responses.size(); i++){  
						
						responsesList.add(customResponseSubmitResponse(responses.get(i)));  
					} 
				}
				else
				{
					throw new HandledException("CHECK_PARAMETERS", "Responses do not exist for this form");
					
				}
			}catch(Exception e) {
				
				 System.out.println(e);
		}
			return responsesList;
			
			
		}

		private Object customResponseSubmitResponse(Response response) {
HashMap<String, Object> ResponseMap =  new HashMap<>();
			
ResponseMap.put("qid",response.getQid());
ResponseMap.put("fid",response.getFid());
ResponseMap.put("sid", response.getSid());
ResponseMap.put("answer",response.getAnswer());
ResponseMap.put("remarks",response.getRemarks());


			return ResponseMap;
			
		}

		@Override
		public List<Answer> submitAnswers(HttpServletRequest request, @Valid List<Answer> answers)
				throws HandledException {
			List<Answer> resultAnswers = new ArrayList<Answer>();
			
			try {
				
			for(int i=0;i<answers.size();i++)
			{
				Answer answer=answerRepo.findByQid(answers.get(i).getQid());
				if(answer==null)
				{
					answers.get(i).setQid(answers.get(i).getQid());
					answers.get(i).setAnswer(answers.get(i).getAnswer());
					if((answers.get(i).getAnswer().equals("no"))||(answers.get(i).getAnswer().equals("NO"))||(answers.get(i).getAnswer().equals("No")))
					{
						answers.get(i).setRemarks(answers.get(i).getRemarks());
						
					}
					else
					{
						answers.get(i).setRemarks(null);
						
					}
					//answers.get(i).setSubmittedBy(answers.get(i).getSubmittedBy());
				
					Long sid=questionRepo.findSubformSidByQid(answers.get(i).getQid());
					answers.get(i).setSid(sid);
					Long fid=subFormRepo.findFormIdBySid(sid);
					answers.get(i).setFid(fid);
					answerRepo.save(answers.get(i));
					resultAnswers.add(answers.get(i));
					
				}else
				{
					throw new HandledException("CHECK_PARAMETERS", "this Answer is already submitted by User");
				}
			}
			return resultAnswers;
				}catch(Exception e)
				{
					throw new HandledException("exception in adding answer", e.getMessage());
				}
				
			
		}

		
		
		
		
//		public List<Long> getAnswerIdsForSubform(Long subformId) {
//			
//			FormSubformResponse formSubformResponse=formSubformResponsesRepo.findById(subformId).orElse(null);
//			//FormSubformResponse subformResponse = subformResponseRepository.findById(subformId).orElse(null);
//	        if (formSubformResponse != null) {
//	            Map<Long, List<Long>> subformResponses = formSubformResponse.getSubformResponses();
//	            return subformResponses.getOrDefault(subformId, new ArrayList<>());
//	        }
//	        return new ArrayList<>();
//	    }

		@Override
		public List<Answer> submitAnswers(HttpServletRequest request,FormSubformResponseDto formSubformResponseDto) throws HandledException {
			List<Answer> resultAnswers = new ArrayList<Answer>();
			//List<Long> answerIds=new ArrayList<>(List);
			FormSubformResponse formSubformResponse=new FormSubformResponse();
			List<Answer> answers=formSubformResponseDto.getAnswers();
			Long sid=formSubformResponseDto.getSid();
			boolean status=formSubformResponseDto.isStatus();
			String submittedBy=formSubformResponseDto.getSubmittedBy();
			try {
				
			for(int i=0;i<answers.size();i++)
			{
				Answer answer=answerRepo.findByQid(answers.get(i).getQid());
				if(answer==null)
				{
					Long qid=answers.get(i).getQid();
					answers.get(i).setQid(answers.get(i).getQid());
					String answerget=answers.get(i).getAnswer();
					answers.get(i).setAnswer(answers.get(i).getAnswer());
					if((answers.get(i).getAnswer().equals("no"))||(answers.get(i).getAnswer().equals("NO"))||(answers.get(i).getAnswer().equals("No")))
					{
						answers.get(i).setRemarks(answers.get(i).getRemarks());
						
					}
					else
					{
						answers.get(i).setRemarks(null);
						
					}
					//answers.get(i).setSubmittedBy(answers.get(i).getSubmittedBy());
				
					//Long sid=questionRepo.findSubformSidByQid(answers.get(i).getQid());
					answers.get(i).setSid(sid);
					Long fid=subFormRepo.findFormIdBySid(sid);
					answers.get(i).setFid(fid);
					answers.get(i).setSubmittedBy(submittedBy);
					answerRepo.save(answers.get(i));
					resultAnswers.add(answers.get(i));
			
					
				}else
				{
					throw new HandledException("CHECK_PARAMETERS", "this Answer is already submitted by User");
				}
			}
			FormSubformResponse existingFormSubformResponse=formSubformResponsesRepo.findByStatus(status);
			//formSubformResponse
			
			if(existingFormSubformResponse!=null)
			{
				if(existingFormSubformResponse.isStatus()==false)
				{
					
					List<Map> subFormresponses=existingFormSubformResponse.getSubformResponses();
					List<Long> answerIds=new ArrayList<Long>();
					List<Answer> savedAnswers=answerRepo.findAllBySid(sid);
					for(int i=0;i<savedAnswers.size();i++)
					{
						answerIds.add(savedAnswers.get(i).getAid());
					}
					Map<Long,List<Long>> subFormResponseMap=new HashMap<>();
					subFormResponseMap.put(sid, answerIds);
					subFormresponses.add(subFormResponseMap);
					//Long fid=subFormRepo.findFormIdBySid(sid);
					//existingFormSubformResponse.setFid(fid);
					existingFormSubformResponse.setSid(sid);
					existingFormSubformResponse.setSubformResponses(subFormresponses);
					existingFormSubformResponse.setSubmittedBy(submittedBy);
					existingFormSubformResponse.setStatus(status);
					
					formSubformResponsesRepo.save(existingFormSubformResponse);
				}
				else
				{
				//true 	
				}
			}
			else
			{
			Long fid=subFormRepo.findFormIdBySid(sid);
			formSubformResponse.setFid(fid);
			//Long ansSid=answers.get(0).getSid();
			formSubformResponse.setSid(sid);
			//List<Long> answerIds=answerRepo.findAllAidBySid(ansSid);
			
			//List<Long> answerIds=getAnswerIdsForSubform(answers.get(0).getSid());
			//Long sid=answers.get(0).getSid();
			List<Long> answerIds=new ArrayList<Long>();
			List<Answer> savedAnswers=answerRepo.findAllBySid(sid);
			for(int i=0;i<savedAnswers.size();i++)
			{
				answerIds.add(savedAnswers.get(i).getAid());
			}
			//List<Long> answersList=answerRepo.findAnswerIdsBySid(sid);
			List<Map> maps=new ArrayList<Map>();
			Map<Long,List<Long>> subFormResponseMap=new HashMap<>();
			subFormResponseMap.put(sid, answerIds);
			
				maps.add(subFormResponseMap);
				
			formSubformResponse.setSubformResponses(maps);
			formSubformResponse.setSubmittedBy(submittedBy);
			formSubformResponse.setStatus(status);
			
			formSubformResponsesRepo.save(formSubformResponse);
			}
			return resultAnswers;
				}catch(Exception e)
				{
					throw new HandledException("exception in adding answer", e.getMessage());
				}
				
			
		}
//		public FormSubformResponseDto entityToDto(FormSubformResponse formSubformResponse) {
//
//			FormSubformResponseDto Dto = new FormSubformResponseDto();
//			Dto.setAnswers(formSubformResponse.get);
//			Dto.setFileName();
//			Dto.setFileLocation(publicAnn.getFileLocation());
//			Dto.setMessageType(publicAnn.getMessageType());
//			Dto.setFileUrl(publicAnn.getFileUrl());
//
//			return Dto;
//
//		}
//		
		
//		@Override
//		public List<SubFormDraft> fillSubForm(HttpServletRequest request, @Valid List<SubFormDraft> subFormDrafts)
//				throws HandledException {
//			
//			return null;
//		}
}

package Observer20.Services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import Observer20.Dto.FormSubformResponseDto;
import Observer20.Exception.HandledException;
//import Observer20.Model.Answer;
import Observer20.Model.Form;
//import Observer20.Model.FormSubformResponse;
import Observer20.Model.Question;
import Observer20.Model.Response;
import Observer20.Model.SubForm;
//import Observer20.repository.AnswerRepo;
//import Observer20.Model.SubFormDraft;
//import Observer20.repository.FormDetailsRepo;
import Observer20.repository.FormServiceRepo;
//import Observer20.repository.FormSubformResponsesRepo;
import Observer20.repository.QuestionRepo;
import Observer20.repository.ResponseRepo;
import Observer20.repository.SubFormRepo;
//import Observer20.Dto.FormSubformResponseDto;
import Observer20.Dto.AnswerDto;
import Observer20.Dto.GetAnswerDto;
import Observer20.Dto.FinalAnswerDto;
import Observer20.Exception.HandledException;
//import Observer20.Model.Answer;
import Observer20.Model.Form;
//import Observer20.Model.FormSubformResponse;
import Observer20.Model.Question;
import Observer20.Model.Response;
import Observer20.Model.SubForm;
import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;
import Observer20.Model.FormStatus;
//import Observer20.repository.AnswerRepo;
//import Observer20.Model.SubFormDraft;
//import Observer20.repository.FormDetailsRepo;
import Observer20.repository.FormServiceRepo;
//import Observer20.repository.FormSubformResponsesRepo;
import Observer20.repository.QuestionRepo;
import Observer20.repository.ResponseRepo;
import Observer20.repository.SubFormRepo;
import Observer20.repository.DraftAnswerRepo;
import Observer20.repository.FinalSubmitAnswerRepo;
import Observer20.repository.FormStatusRepo;



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
	
//	@Autowired
//	public AnswerRepo answerRepo;
	
//	@Autowired
//	public FormSubformResponsesRepo formSubformResponsesRepo;
//	
	
	
@Autowired
	public DraftAnswerRepo draftAnswerRepo;
	
	@Autowired
	public FinalSubmitAnswerRepo finalSubmitAnswerRepo;
	
	@Autowired
	public FormStatusRepo formStatusRepo;
	
	

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
		public List allFormsByObsType1(String obsType,String userId) throws HandledException {
			// TODO Auto-generated method stub
			Long fid=null;
			boolean status=false;
			List<Form> FormForGeneral=new ArrayList<Form>();
			List<FormStatus> formStatuses=new ArrayList<FormStatus>();
			try{
				
				
				 FormForGeneral=formServiceRepo.findAllByObsType(obsType);
				 formStatusRepo.findAllBySubmittedBy(userId);
			}catch(Exception e) {
				
				 System.out.println(e);
			return null;
		}	
			
			if(FormForGeneral.size()>0)
			{
				List formList = new ArrayList<>() ;
				
				for (int i = 0; i < FormForGeneral.size(); i++){  
					
					fid=FormForGeneral.get(i).getId();
					FormStatus formStatus=formStatusRepo.findByFidAndSubmittedBy(fid, userId);
					
					if(formStatus!=null)
					{
						if(formStatus.isStatus()==true)
						{ status=true;
						formList.add(customResponseForm(FormForGeneral.get(i),status));
						}
						else if(formStatus.isStatus()==false)
						{ status=false;
							formList.add(customResponseForm(FormForGeneral.get(i),status)); 
						}
					}
					else
					{ status=false;
						formList.add(customResponseForm(FormForGeneral.get(i),status)); 
					}
					
					
					
					
				}  
				
				return formList;
			}
			
			else
			{
				throw new HandledException("CHECK_PARAMETERS", "Form does not exist for this observer type ");
			}
		
		}

		//custom response
		private HashMap<String, Object> customResponseForm( Form formData,boolean status) {
			
			HashMap<String, Object> formMap =  new HashMap<>();
			
			formMap.put("id", formData.getId());
			formMap.put("FormName", formData.getName());
			formMap.put("ObserverType", formData.getObsType());
			formMap.put("FormStatus",status);

			return formMap;
			
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
		public HashMap<String, Object> submitAnswers(HttpServletRequest request,AnswerDto answerDto) throws HandledException {
			
			
			FormStatus formStatus=new FormStatus();
			List<DraftAnswer> resultAnswers = new ArrayList<DraftAnswer>();
			
			List<DraftAnswer> answers=answerDto.getDraftAnswers();
			//HashMap<String, Object> answers=answerDto.getDraftAnswers();
			Long formId=null;
			Long sid=null;
			boolean status=answerDto.isStatus();
			String submittedBy=answerDto.getSubmittedBy();
			try {
				
			for(int i=0;i<answers.size();i++)
			{
				DraftAnswer answer=draftAnswerRepo.findByQid(answers.get(i).getQid());
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
					sid=questionRepo.findSubformSidByQid(qid);
					answers.get(i).setSid(questionRepo.findSubformSidByQid(qid));
					formId=subFormRepo.findFormIdBySid(sid);
					answers.get(i).setFid(formId);
					answers.get(i).setSubmittedBy(submittedBy);
					draftAnswerRepo.save(answers.get(i));
					resultAnswers.add(answers.get(i));
			
					
				}else
				{
					throw new HandledException("CHECK_PARAMETERS", "this Answer is already submitted by User");
				}
			}//end of for
			
			FormStatus existingFormStatus=formStatusRepo.findByFid(formId);
			List<FinalSubmitAnswer> finalSubmitAnswer=new ArrayList<FinalSubmitAnswer>();
			if(status==true)
			{
				List<DraftAnswer> draftAnswers=draftAnswerRepo.findAllByFid(formId);
				for(int i=0;i<draftAnswers.size();i++)
				{
					FinalSubmitAnswer finalAnswer = new FinalSubmitAnswer();
					finalAnswer.setAnswer(draftAnswers.get(i).getAnswer());
					finalAnswer.setFid(formId);
					finalAnswer.setQid(draftAnswers.get(i).getQid());
					finalAnswer.setRemarks(draftAnswers.get(i).getRemarks());
					finalAnswer.setSid(draftAnswers.get(i).getSid());
					finalAnswer.setSubmittedBy(submittedBy);
						finalSubmitAnswerRepo.save(finalAnswer);
						finalSubmitAnswer.add(finalAnswer);
					
				}
				draftAnswerRepo.deleteAll(draftAnswers);
				if(existingFormStatus!=null)
				{
					//List<DraftAnswer> savedAnswers=savedAnswers=draftAnswerRepo.findAllBySid(sid);
					List<FinalSubmitAnswer> savedFinalAnswers=finalSubmitAnswerRepo.findAllBySid(sid);
					
					 existingFormStatus.setFid(formId);
					 existingFormStatus.setStatus(status);
					 existingFormStatus.setSubmittedBy(submittedBy);
					 formStatusRepo.save(existingFormStatus);
					return entityToDtoForFinal(existingFormStatus,savedFinalAnswers);
				}
				else
				{
				Long fid=subFormRepo.findFormIdBySid(sid);
				formStatus.setFid(fid);
				formStatus.setStatus(status);
				formStatus.setSubmittedBy(submittedBy);
				List<FinalSubmitAnswer> savedFinalAnswers=finalSubmitAnswerRepo.findAllBySid(sid);
				formStatusRepo.save(formStatus);
				return entityToDtoForFinal(formStatus,savedFinalAnswers);
				}					
				
			}
			else
			{
				if(existingFormStatus!=null)
				{
					List<DraftAnswer> savedAnswers=draftAnswerRepo.findAllBySid(sid);;
					 savedAnswers=draftAnswerRepo.findAllBySid(sid);
					 existingFormStatus.setFid(formId);
					 existingFormStatus.setStatus(status);
					 existingFormStatus.setSubmittedBy(submittedBy);
					 formStatusRepo.save(existingFormStatus);
					return entityToDtoForDraft(existingFormStatus,savedAnswers);
				}
				else
				{
				Long fid=subFormRepo.findFormIdBySid(sid);
				formStatus.setFid(fid);
				formStatus.setStatus(status);
				formStatus.setSubmittedBy(submittedBy);
				List<DraftAnswer> savedAnswers=draftAnswerRepo.findAllBySid(sid);
				formStatusRepo.save(formStatus);
				
					return entityToDtoForDraft(formStatus,savedAnswers);
				
				
				}			
			
	}
			
		}
			catch(Exception e)
			{
				throw new HandledException("exception in adding answer", e.getMessage());
			}
		
		}
		
		public HashMap<String, Object> entityToDtoForFinal(FormStatus formStatus,List<FinalSubmitAnswer> finalSubmitAnswers) {

			AnswerDto Dto = new AnswerDto();
			Dto.setId(formStatus.getStid());
			Dto.setFinalSubmitAnswer(finalSubmitAnswers);
			
			Dto.setStatus(formStatus.isStatus());
			Dto.setSubmittedBy(formStatus.getSubmittedBy());

			
			return customResponseFinalAnswerDto(Dto);
			//return Dto;

		}
		
		public HashMap<String, Object> entityToDtoForDraft(FormStatus formStatus,List<DraftAnswer> draftAnswers) {

			AnswerDto Dto = new AnswerDto();
			Dto.setId(formStatus.getStid());
			
			Dto.setDraftAnswers(draftAnswers);
			Dto.setStatus(formStatus.isStatus());
			Dto.setSubmittedBy(formStatus.getSubmittedBy());

			//return Dto;
			return customResponseDraftAnswerDto(Dto);

		}

		@Override
		public HashMap<String, Object> getDraftAnswers(String userid,Long fid,Long sid) throws HandledException {
			
			GetAnswerDto getAnswerDto=new GetAnswerDto();
			List<DraftAnswer> draftAnswers=draftAnswerRepo.findByFidAndSidAndSubmittedBy(fid, sid, userid);
					 SubForm subform=subFormRepo.findById(sid)
						.orElseThrow(() ->new HandledException("NOT_FOUND", "subForm Id is not found"));
					 getAnswerDto.setSubform_heading(subform.getHeading());
					 getAnswerDto.setDraftAnswers(draftAnswers);
					 
				return customResponseGetAnswerDtoforDraftAnswer(getAnswerDto);
			
		}
		

		@Override
		public List<HashMap<String, Object>> getFinalAnswers(String userid, Long fid) throws HandledException {
		    List<HashMap<String, Object>> listOfMsgMaps = new ArrayList<>();
		    FinalAnswerDto finalAnswerDto=new FinalAnswerDto();
		    List<GetAnswerDto> listOfDtos = new ArrayList<GetAnswerDto>();
		 
		    	List<SubForm> subforms = subFormRepo.findSubFormsByFormId(fid);
			    
			    for (SubForm subform : subforms) {
			        Long sid = subform.getSid();
			        String heading = subform.getHeading();
			        GetAnswerDto getAnswerDto = new GetAnswerDto();
			        getAnswerDto.setSubform_heading(heading);

			        List<FinalSubmitAnswer> finalSubmitAnswers = finalSubmitAnswerRepo.findByFidAndSidAndSubmittedBy(fid, sid, userid);
			       
			        if (finalSubmitAnswers == null || finalSubmitAnswers.isEmpty()) {
			            // Skip this subform if no final submit answers are found
			        	
			            continue;
			        }
			        	getAnswerDto.setFinalSubmitAnswers(finalSubmitAnswers);
				        
				        HashMap<String, Object> msgMap = new HashMap<>();
				        msgMap.put("subformHeading", getAnswerDto.getSubform_heading());
				        
				        List<HashMap<String, Object>> customResponses = customResponseFinalAnswers1(getAnswerDto.getFinalSubmitAnswers());
				        if (customResponses != null && !customResponses.isEmpty()) {
				            msgMap.put("finalSubmitAnswer", customResponses);
				            listOfMsgMaps.add(msgMap);
				        
				        
				        }
//				        msgMap.put("finalSubmitAnswer", customResponseFinalAnswers1(getAnswerDto.getFinalSubmitAnswers()));
//				        
//				        listOfMsgMaps.add(msgMap);
			        	 
			    }
			    
			    return listOfMsgMaps;
		    	
		}

		private List<HashMap<String, Object>> customResponseFinalAnswers1(List<FinalSubmitAnswer> finalSubmitAnswer) {
		    List<HashMap<String, Object>> listOfMaps = new ArrayList<>();
		    
		    for (FinalSubmitAnswer answer : finalSubmitAnswer) {
		        HashMap<String, Object> msgMap = new HashMap<>();
		        //msgMap.put("id", answer.getId());
		        msgMap.put("formId", answer.getFid());
		        msgMap.put("questionId", answer.getQid());
		        Question question=questionRepo.findByQid(answer.getQid());
		         msgMap.put("questiionText",question.getQname());
		        msgMap.put("subFormId", answer.getSid());
		        msgMap.put("answer", answer.getAnswer());
		        msgMap.put("remarks", answer.getRemarks());
		        msgMap.put("submittedBy", answer.getSubmittedBy());
		        
		        listOfMaps.add(msgMap);
		    }

		    return listOfMaps;
		}
		
		
		private HashMap<String, Object> customResponseFinalAnswerDto( AnswerDto dto) {
			
			HashMap<String, Object> msgMap =  new HashMap<>();
			
			msgMap.put("id",dto.getId());
			
			//msgMap.put("finalAnswers",dto.getFinalSubmitAnswer());
			
			msgMap.put("finalAnswers",customResponseFinalAnswers(dto.getFinalSubmitAnswer()));
			
			msgMap.put("formStatus",dto.isStatus());
			
			msgMap.put("submittedBy",dto.getSubmittedBy());
			
			return msgMap;
			
		}
		
		
		private HashMap<String, Object> customResponseDraftAnswerDto( AnswerDto dto) {
			
			HashMap<String, Object> msgMap =  new HashMap<>();
			
			msgMap.put("id",dto.getId());
			
			msgMap.put("draftAnswers",customResponseDraftAnswers(dto.getDraftAnswers()));
			
			msgMap.put("FormStatus",dto.isStatus());
			
			msgMap.put("SubmittedBy",dto.getSubmittedBy());
			
			return msgMap;
			
		}
		
		private HashMap<String, Object> customResponseGetAnswerDtoforDraftAnswer(GetAnswerDto dto) {
			
			HashMap<String, Object> msgMap =  new HashMap<>();
			
			msgMap.put("subformHeading",dto.getSubform_heading());
			
			msgMap.put("draftAnswer",customResponseDraftAnswers(dto.getDraftAnswers()));
			
			return msgMap;
			
		}
		
		private List<HashMap<String, Object>> customResponsGetAnswerDtoforFinalAnswer( List<GetAnswerDto> dtos) {
	
			HashMap<String, Object> msgMap =  new HashMap<>();
			List<HashMap<String, Object>> listOfMsgMaps =  new ArrayList<>();
			
			for(int i=0;i<dtos.size();i++)
		{
				msgMap.put("subformHeading",dtos.get(i).getSubform_heading());
				
				msgMap.put("finalSubmitAnswer",customResponseFinalAnswers(dtos.get(i).getFinalSubmitAnswers()));
				
				listOfMsgMaps.add(msgMap);
				
			}
			return listOfMsgMaps;
			//return msgMap;
			
		}

		private List<HashMap<String, Object>> customResponseDraftAnswers( List<DraftAnswer> draftAnswers) {
			
			//HashMap<String, Object> msgMap =  new HashMap<>();
			List<HashMap<String, Object>> listOfMaps = new ArrayList<>();
			
			 for (DraftAnswer answer : draftAnswers) {
			        HashMap<String, Object> msgMap = new HashMap<>();
			        //msgMap.put("id", answer.getId());
			        msgMap.put("formId", answer.getFid());
			        msgMap.put("questionId", answer.getQid());
			        Question question=questionRepo.findByQid(answer.getQid());
			         msgMap.put("questiionText",question.getQname());
			        msgMap.put("subFormId", answer.getSid());
			        msgMap.put("answer", answer.getAnswer());
			        msgMap.put("remarks", answer.getRemarks());
			        msgMap.put("submittedBy", answer.getSubmittedBy());
			        
			        listOfMaps.add(msgMap);
			    }
			
			return listOfMaps;
			
		}
		
		private List<HashMap<String, Object>> customResponseFinalAnswers( List<FinalSubmitAnswer> finalSubmitAnswer) {
			
			HashMap<String, Object> msgMap =  new HashMap<>();
			List<HashMap<String, Object>> listOfMaps = new ArrayList<>();
			
			for(int i=0;i<finalSubmitAnswer.size();i++)
			{
				msgMap.put("id",finalSubmitAnswer.get(i).getFsid());
				
				msgMap.put("formId",finalSubmitAnswer.get(i).getFid());
				
				msgMap.put("questionId",finalSubmitAnswer.get(i).getQid());
				
				msgMap.put("subFormId",finalSubmitAnswer.get(i).getSid());
				
				msgMap.put("answer",finalSubmitAnswer.get(i).getAnswer());
				
				msgMap.put("remarks",finalSubmitAnswer.get(i).getRemarks());
				
				msgMap.put("submittedBy",finalSubmitAnswer.get(i).getSubmittedBy());
				
				listOfMaps.add(msgMap);
				
			}

			return listOfMaps;
		}


}

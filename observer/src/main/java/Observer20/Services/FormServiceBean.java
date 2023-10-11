package Observer20.Services;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
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
import Observer20.Model.STATE_LIST2;
import Observer20.Model.SubForm;
import Observer20.Repo1.STATE_LIST_REPO;
//import Observer20.repository.AnswerRepo;
//import Observer20.Model.SubFormDraft;
//import Observer20.repository.FormDetailsRepo;
import Observer20.repository.FormServiceRepo;
//import Observer20.repository.FormSubformResponsesRepo;
import Observer20.repository.QuestionRepo;
import Observer20.repository.ResponseRepo;
import Observer20.repository.STATE_LIST2_Repo;
import Observer20.repository.SubFormRepo;
//import Observer20.Dto.FormSubformResponseDto;
import Observer20.Dto.AnswerDto;
import Observer20.Dto.GetAnswerDto;
import Observer20.Dto.UpdateAnswerDto;
import Observer20.Enum.ObsStatus;
import Observer20.Dto.FinalAnswerDto;
import Observer20.Exception.HandledException;
//import Observer20.Model.Answer;
import Observer20.Model.Form;
import Observer20.Model.FormDates;
//import Observer20.Model.FormSubformResponse;
import Observer20.Model.Question;
import Observer20.Model.Response;
import Observer20.Model.SubForm;
import Observer20.Model.AC_LIST2;
import Observer20.Model.DownloadPdf;
import Observer20.Model.DraftAnswer;
import Observer20.Model.FinalSubmitAnswer;
import Observer20.Model.FormStatus;
import Observer20.Model.Obs_Allot;
import Observer20.Model.ObserverUser;
//import Observer20.repository.AnswerRepo;
//import Observer20.Model.SubFormDraft;
//import Observer20.repository.FormDetailsRepo;
import Observer20.repository.FormServiceRepo;
//import Observer20.repository.FormSubformResponsesRepo;
import Observer20.repository.QuestionRepo;
import Observer20.repository.ResponseRepo;
import Observer20.repository.SubFormRepo;
import Observer20.repository.AC_LIST2_REPO2;
import Observer20.repository.DownloadRepo;
import Observer20.repository.DraftAnswerRepo;
import Observer20.repository.FinalSubmitAnswerRepo;
import Observer20.repository.FormDatesRepo;
import Observer20.repository.FormStatusRepo;
import Observer20.repository.Obs_AllotREPO;
import Observer20.repository.ObserverUserRepo;



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
	public FormDatesRepo formDatesRepo;
	
	@Autowired
	public DraftAnswerRepo draftAnswerRepo;
	
	@Autowired
	public FinalSubmitAnswerRepo finalSubmitAnswerRepo;
	
	@Autowired
	public FormStatusRepo formStatusRepo;
	
	@Autowired
	public DownloadRepo downloadRepo;
	
	@Autowired
	public ObserverUserRepo observerUserRepo;

	@Autowired
	public Obs_AllotREPO obs_AllotREPO;
	
	@Autowired
	public AC_LIST2_REPO2 aC_LIST2_REPO2;

	@Autowired
	public STATE_LIST2_Repo sTATE_LIST2_Repo;
	
	
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
			formMap.put("subforms",formData.getSubforms());

			return formMap;
			
		}
		
		
	private HashMap<String, Object> customResponseSubForm( SubForm subFormData) {
			
			HashMap<String, Object> formMap =  new HashMap<>();
			
			formMap.put("SubFormId",subFormData.getSid());
			formMap.put("Heading", subFormData.getHeading());
			

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
				 //formStatusRepo.findAllBySubmittedBy(userId);
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
		public HashMap<String, Object> submitAnswers(HttpServletRequest request,AnswerDto answerDto,String consistuency) throws HandledException {
			
		
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
					//if((answers.get(i).getAnswer().equals("no"))||(answers.get(i).getAnswer().equals("NO"))||(answers.get(i).getAnswer().equals("No")))
					//{
						answers.get(i).setRemarks(answers.get(i).getRemarks());
						
					//}
//					else
//					{
//						answers.get(i).setRemarks(null);
//						
//					}	
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
				List<DraftAnswer> draftAnswers=draftAnswerRepo.findByFidAndSubmittedBy(formId, submittedBy);
				//List<DraftAnswer> draftAnswers=draftAnswerRepo.findAllByFid(formId);
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
					//List<FinalSubmitAnswer> savedFinalAnswers=finalSubmitAnswerRepo.findAllBySid(sid);
					List<FinalSubmitAnswer> savedFinalAnswers=finalSubmitAnswerRepo.findBySidAndSubmittedBy(sid, submittedBy);
					 existingFormStatus.setFid(formId);
					 existingFormStatus.setStatus(status);
					 existingFormStatus.setSubmittedBy(submittedBy);
					 existingFormStatus.setConstituency(consistuency);
					 formStatusRepo.save(existingFormStatus);
					return entityToDtoForFinal(existingFormStatus,savedFinalAnswers);
				}
				else
				{
				Long fid=subFormRepo.findFormIdBySid(sid);
				formStatus.setFid(fid);
				formStatus.setStatus(status);
				formStatus.setSubmittedBy(submittedBy);
				formStatus.setConstituency(consistuency);
				List<FinalSubmitAnswer> savedFinalAnswers=finalSubmitAnswerRepo.findBySidAndSubmittedBy(sid, submittedBy);
				//List<FinalSubmitAnswer> savedFinalAnswers=finalSubmitAnswerRepo.findAllBySid(sid);
				formStatusRepo.save(formStatus);
				return entityToDtoForFinal(formStatus,savedFinalAnswers);
				}					
				
			}
			else
			{
				if(existingFormStatus!=null)
				{
					//List<DraftAnswer> savedAnswers=draftAnswerRepo.findAllBySid(sid);
					List<DraftAnswer> savedAnswers=draftAnswerRepo.findBySidAndSubmittedBy(sid, submittedBy);
					 savedAnswers=draftAnswerRepo.findAllBySid(sid);
					 existingFormStatus.setFid(formId);
					 existingFormStatus.setStatus(status);
					 existingFormStatus.setSubmittedBy(submittedBy);
					 existingFormStatus.setConstituency(consistuency);
					 formStatusRepo.save(existingFormStatus);
					return entityToDtoForDraft(existingFormStatus,savedAnswers);
				}
				else
				{
				Long fid=subFormRepo.findFormIdBySid(sid);
				formStatus.setFid(fid);
				formStatus.setStatus(status);
				formStatus.setSubmittedBy(submittedBy);
				formStatus.setConstituency(consistuency);
				List<DraftAnswer> savedAnswers=draftAnswerRepo.findBySidAndSubmittedBy(sid, submittedBy);
				//List<DraftAnswer> savedAnswers=draftAnswerRepo.findAllBySid(sid);
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
		
		
		@Override
		public HashMap<String, Object> submitAllDraft(String obsType,Long fid) throws HandledException {
			List<FinalSubmitAnswer> finalSubmitAnswers=new ArrayList<FinalSubmitAnswer>();
			FormStatus formStatus=new FormStatus();
			
		List<DraftAnswer> draftAnswers=draftAnswerRepo.findByFidAndSubmittedBy(fid, obsType);
		try	
		{
		for(int i=0;i<draftAnswers.size();i++)
		{FinalSubmitAnswer finalSubmit=new FinalSubmitAnswer();
			finalSubmit.setAnswer(draftAnswers.get(i).getAnswer());
			finalSubmit.setRemarks(draftAnswers.get(i).getRemarks());
			finalSubmit.setFid(fid);
			finalSubmit.setQid(draftAnswers.get(i).getQid());
			finalSubmit.setSid(draftAnswers.get(i).getSid());
			finalSubmit.setSubmittedBy(draftAnswers.get(i).getSubmittedBy());
			finalSubmitAnswerRepo.save(finalSubmit);
			finalSubmitAnswers.add(finalSubmit);
		}
		draftAnswerRepo.deleteAll(draftAnswers);
		FormStatus existingStatus=formStatusRepo.findByFidAndSubmittedBy(fid, obsType);
		existingStatus.setStatus(true);
		formStatusRepo.save(existingStatus);
		return entityToDtoForFinal(existingStatus,finalSubmitAnswers);
		}
		catch(Exception e)
		{
			throw new HandledException("exception in adding answer", e.getMessage());
		}
		
			
		}

		
		@Override
		public HashMap<String, Object> submitAndUpdateAnswers(HttpServletRequest request,AnswerDto answerDto,String consistuency) throws HandledException {
			
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
			
					
				}else if (answer != null && (!answers.get(i).getAnswer().equals(answer.getAnswer())|| !answers.get(i).getRemarks().equals(answer.getRemarks()))) {
			             
					Long qid=answers.get(i).getQid();
					answers.get(i).setQid(answers.get(i).getQid());
					String answerget=answers.get(i).getAnswer();

					sid=questionRepo.findSubformSidByQid(qid);
					answers.get(i).setSid(questionRepo.findSubformSidByQid(qid));
					formId=subFormRepo.findFormIdBySid(sid);
					answers.get(i).setFid(formId);
					answers.get(i).setSubmittedBy(submittedBy);
					// Update the existing draft answer with new data
					
					answer.setAnswer(answers.get(i).getAnswer());
					
					if((answer.getAnswer().equals("no"))||(answer.getAnswer().equals("NO"))||(answer.getAnswer().equals("No")))
					{
						answer.setRemarks(answers.get(i).getRemarks());
						
					}
					else
					{
						answer.setRemarks(null);
						
					}	
					
					
					
					//answer.setRemarks(answers.get(i).getRemarks());
			                // You can update other fields if needed

			                draftAnswerRepo.save(answer);
			                
			                resultAnswers.add(answers.get(i));
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
					 existingFormStatus.setConstituency(consistuency);
					 formStatusRepo.save(existingFormStatus);
					return entityToDtoForFinal(existingFormStatus,savedFinalAnswers);
				}
				else
				{
				Long fid=subFormRepo.findFormIdBySid(sid);
				formStatus.setFid(fid);
				formStatus.setStatus(status);
				formStatus.setSubmittedBy(submittedBy);
				formStatus.setConstituency(consistuency);
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
					 existingFormStatus.setConstituency(consistuency);
					 formStatusRepo.save(existingFormStatus);
					return entityToDtoForDraft(existingFormStatus,savedAnswers);
				}
				else
				{
				Long fid=subFormRepo.findFormIdBySid(sid);
				formStatus.setFid(fid);
				formStatus.setStatus(status);
				formStatus.setSubmittedBy(submittedBy);
				formStatus.setConstituency(consistuency);
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
		
		
		@Override
		public HashMap<String, Object> updateAnswer(HttpServletRequest request,AnswerDto answerDto,Long fid1,Long sid11)throws HandledException {
			Long fid=null,sid=null,qid=null;
            FormStatus existingFormStatus=null;
            DraftAnswer existingAnswer = null;
			    try {
			        List<DraftAnswer> updatedAnswers = answerDto.getDraftAnswers();
			        String submittedBy=answerDto.getSubmittedBy();
			        for (DraftAnswer updatedAnswer : updatedAnswers) {
			        	
			             qid = updatedAnswer.getQid();
			            
			            //finding sid from qid
			            
			             sid=questionRepo.findSubformSidByQid(qid);
		           
	             fid=subFormRepo.findFormIdBySid(sid);
	            
			             existingFormStatus=formStatusRepo.findByFid(fid);
			            existingAnswer = draftAnswerRepo.findByQid(qid);

			            if (existingAnswer != null && (!updatedAnswer.getAnswer().equals(existingAnswer.getAnswer())|| !updatedAnswer.getRemarks().equals(existingAnswer.getRemarks()))) {
			                // Update the existing draft answer with new data
			                existingAnswer.setAnswer(updatedAnswer.getAnswer());
			                existingAnswer.setRemarks(updatedAnswer.getRemarks());
			                // You can update other fields if needed

			                draftAnswerRepo.save(existingAnswer);
			                
			            } 
			        }
			        return null;
			       
			    } catch (Exception e) {
			        throw new HandledException("Exception in updating draft answers", e.getMessage());
			    }
			    //return null;   
}
			
		
		public HashMap<String, Object> entityToDtoForFinal(FormStatus formStatus,List<FinalSubmitAnswer> finalSubmitAnswers) {

			AnswerDto Dto = new AnswerDto();
			Dto.setId(formStatus.getStid());
			Dto.setFinalSubmitAnswer(finalSubmitAnswers);
			
			Dto.setStatus(formStatus.isStatus());
			Dto.setSubmittedBy(formStatus.getSubmittedBy());
			
			
			return customResponseFinalAnswerDto(Dto);

		}
		
		public HashMap<String, Object> entityToDtoForDraft(FormStatus formStatus,List<DraftAnswer> draftAnswers) {

			AnswerDto Dto = new AnswerDto();
			Dto.setId(formStatus.getStid());
			
			Dto.setDraftAnswers(draftAnswers);
			Dto.setStatus(formStatus.isStatus());
			Dto.setSubmittedBy(formStatus.getSubmittedBy());
			return customResponseDraftAnswerDto(Dto);

		}
		
		public HashMap<String, Object> entityToDtoForDraft(List<DraftAnswer> draftAnswers) {

			UpdateAnswerDto Dto = new UpdateAnswerDto();
			
			Dto.setDraftAnswers(draftAnswers);
			
			return customResponseDraftAnswerDtoUpdate(Dto);

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

			    }
			    
			    return listOfMsgMaps;
		    	
		}
		
		@Override
		public List<HashMap<String, Object>> getAllDraftAnswers(String userid, Long fid) throws HandledException {
		    List<HashMap<String, Object>> listOfMsgMaps = new ArrayList<>();
		   
		   // FinalAnswerDto finalAnswerDto=new FinalAnswerDto();
		    List<GetAnswerDto> listOfDtos = new ArrayList<GetAnswerDto>();
		 
		    	List<SubForm> subforms = subFormRepo.findSubFormsByFormId(fid);
			    
			    for (SubForm subform : subforms) {
			        Long sid = subform.getSid();
			        String heading = subform.getHeading();
			        GetAnswerDto getAnswerDto = new GetAnswerDto();
			        getAnswerDto.setSubform_heading(heading);

			        //List<FinalSubmitAnswer> finalSubmitAnswers = finalSubmitAnswerRepo.findByFidAndSidAndSubmittedBy(fid, sid, userid);
			       
			        List<DraftAnswer> draftAnswers=draftAnswerRepo.findByFidAndSidAndSubmittedBy(fid, sid, userid);
			        if (draftAnswers == null || draftAnswers.isEmpty()) {        
			        	
			            continue;
			        }
			        	getAnswerDto.setDraftAnswers(draftAnswers);
				        
				        HashMap<String, Object> msgMap = new HashMap<>();
				        msgMap.put("subformHeading", getAnswerDto.getSubform_heading());
				        
				        List<HashMap<String, Object>> customResponses = customResponseDraftAnswers(getAnswerDto.getDraftAnswers());
				        if (customResponses != null && !customResponses.isEmpty()) {
				            msgMap.put("draftAnswer", customResponses);
				            listOfMsgMaps.add(msgMap);
				        
				        
				        }

			    }
			    
			    return listOfMsgMaps;
		    	
		}
		
		
		

		private List<HashMap<String, Object>> customResponseFinalAnswers1(List<FinalSubmitAnswer> finalSubmitAnswer) {
		    List<HashMap<String, Object>> listOfMaps = new ArrayList<>();
		    
		    for (FinalSubmitAnswer answer : finalSubmitAnswer) {
		        HashMap<String, Object> msgMap = new HashMap<>();
		        msgMap.put("formId", answer.getFid());
		        msgMap.put("questionId", answer.getQid());
		        Question question=questionRepo.findByQid(answer.getQid());
		         msgMap.put("questionText",question.getQname());
		         
		       //msgMap.put("questionSeq",question.getQseq());
		         
		         msgMap.put("inputType",question.getInputType());
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
		
		private HashMap<String, Object> customResponseDraftAnswerDtoUpdate( UpdateAnswerDto dto) {
			
			HashMap<String, Object> msgMap =  new HashMap<>();
			
			msgMap.put("draftAnswers",customResponseDraftAnswers(dto.getDraftAnswers()));
			
			msgMap.put("SubmittedBy", msgMap);
			
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
			         msgMap.put("questionText",question.getQname());
			         
			       //msgMap.put("questionSeq",question.getQseq()); 
			         
			         msgMap.put("inputType",question.getInputType());
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

		@Override
		public List<HashMap<String, Object>> allFormsByConsistuency(String obsType,String constituency,String userId) throws HandledException 
		{
			Long fid=null,phaseNo=null;
			boolean isSubmitted=false;
			LocalDate sdate,ldate;
			String state=null;
			LocalDate currentLocalDate;
			HashMap<String, Object> formDatesMap = new HashMap<>();
			List<HashMap<String, Object>> listOfMsgMaps = new ArrayList<>();
			
			//FormStatus constituencyCheck=formStatusRepo.findByFidAndSubmittedByAndConstituency(fid, userId, constituency);
			
//			if(constituencyCheck!=null)
//			{
//				
				List<Form> forms=formServiceRepo.findAllByObsType(obsType);
				for(Form form : forms)
				{
					fid=form.getId();
					FormDates formDatesDetails=formDatesRepo.findByFid(fid);
					
					
					
					//FormStatus formStatus=formStatusRepo.findByFidAndSubmittedBy(fid, userId);
					
					FormStatus formStatus=formStatusRepo.findByFidAndSubmittedByAndConstituency(fid, userId, constituency);
					if(formStatus!=null)
					{
						if(formStatus.isStatus()==true)
						{
							isSubmitted=true;
							formDatesMap=customResponseFormStatusSubmit(form,ObsStatus.submitted,formStatus.getDate(),isSubmitted);
						}
						else if(formStatus.isStatus()==false)
						{ 
							
							//status=false;
							isSubmitted=false;
							formDatesMap=customResponseFormStatusDraft(form,ObsStatus.draft,formStatus.getDate(),isSubmitted); 
						}
					}
					else
					{ 
						
						 ldate=formDatesDetails.getLdate();
						 currentLocalDate = LocalDate.now();
//						//savedLocalDate.isAfter(currentLocalDate)
						if(formDatesDetails.getLdate().isAfter(currentLocalDate))
						{
						System.out.println("pending");	
						isSubmitted=false;
						formDatesMap=customResponseFormStatusPending(form,ObsStatus.pending,formDatesDetails.getSdate(),formDatesDetails.getLdate(),isSubmitted); 
						}
						else if(formDatesDetails.getLdate().isBefore(currentLocalDate))
					{
						System.out.println("due");	
						isSubmitted=false;
						formDatesMap=customResponseFormStatusDue(form,ObsStatus.due,formDatesDetails.getLdate(),isSubmitted); 
//							 state=formDatesDetails.getState();
//								 phaseNo=formDatesDetails.getPhaseNo();				
						}
						else
						{isSubmitted=false;
							formDatesMap=customResponseFormStatusPending(form,ObsStatus.pending,formDatesDetails.getSdate(),formDatesDetails.getLdate(),isSubmitted); 
						}
						//customResponseForm(form); 
					
					}
					listOfMsgMaps.add(formDatesMap);
				}
				return listOfMsgMaps;
//			}
//			else
//			{
//				throw new HandledException("CHECK_PARAMETERS","please select contituency first");
//				
//			}
		
		//return null;
		
		
		}


private HashMap<String, Object> customResponseFormStatusSubmit(Form form,ObsStatus status,Date submitDate,boolean isSubmitted) {
	
	HashMap<String, Object> formMap =  new HashMap<>();
	
	formMap.put("FormId",form.getId());
	formMap.put("FormName",form.getName());
	formMap.put("FormStatus",status);
	formMap.put("Submitted_On",submitDate);
	formMap.put("isSubmitted",isSubmitted);

	return formMap;
	
}

private HashMap<String, Object> customResponseFormStatusDraft(Form form,ObsStatus status,Date draftDate,boolean isSubmitted) {
	
	HashMap<String, Object> formMap =  new HashMap<>();
	
	formMap.put("FormId",form.getId());
	formMap.put("FormName",form.getName());
	formMap.put("FormStatus",status);
	formMap.put("Last_Submitted_On",draftDate);
	formMap.put("isSubmitted",isSubmitted);


	return formMap;
	
}
private HashMap<String, Object> customResponseFormStatusPending(Form form,ObsStatus status,LocalDate startDate,LocalDate lastdate,boolean isSubmitted) {
	
	HashMap<String, Object> formMap =  new HashMap<>();
	
	formMap.put("FormId",form.getId());
	formMap.put("FormName",form.getName());
	formMap.put("FormStatus",status);
	formMap.put("Pending_Since",startDate);
	formMap.put("Last_date",lastdate);
	formMap.put("isSubmitted",isSubmitted);


	return formMap;
	
}
private HashMap<String, Object> customResponseFormStatusDue(Form form,ObsStatus status,LocalDate lastDate,boolean isSubmitted) {
	
	HashMap<String, Object> formMap =  new HashMap<>();
	
	formMap.put("FormId",form.getId());
	formMap.put("FormName",form.getName());
	formMap.put("FormStatus",status);
	formMap.put("Due_On",lastDate);
	formMap.put("isSubmitted",isSubmitted);


	return formMap;
	
}


		@Override
		public HashMap<String, Object> submitDates(HttpServletRequest request, FormDates formDates)
				throws HandledException {

			
			
		FormDates formDatesInDB=formDatesRepo.findByFidAndObsType(formDates.getFid(),formDates.getObsType());
			HashMap<String, Object> formDatesMap = new HashMap<>();
			
			if (formDatesInDB == null) {
				
				formDatesRepo.save(formDates);
				
				formDatesMap = customResponseFormDates(formDates);
				
			}else {
				
				throw new HandledException("CHECK_PARAMETERS", "Already existed");
			}
			
			return formDatesMap;
			
			
		}
		private HashMap<String, Object> customResponseFormDates( FormDates formDates) {
			
			HashMap<String, Object> msgMap =  new HashMap<>();
			
			msgMap.put("FormId",formDates.getFid());
			msgMap.put("ObsType",formDates.getObsType());
			msgMap.put("StartDate",formDates.getSdate());
			msgMap.put("LastDate",formDates.getLdate());
			msgMap.put("ActiveStatus", formDates.getActiveStatus());
			
			return msgMap;
			
		}

		@Override
		public HashMap<String, Object> updateDates(Long fid,FormDates formDates)throws HandledException {
			FormDates formDate=formDatesRepo.findByFid(fid);
			HashMap<String, Object> formDatesMap = new HashMap<>();
			if(formDate!=null)
			{
				formDate.setLdate(formDates.getLdate());
				formDate.setSdate(formDates.getSdate());
				formDate.setPhaseNo(formDates.getPhaseNo());
				formDate.setState(formDates.getState());
				formDate.setActiveStatus(formDates.getActiveStatus());
				formDatesRepo.save(formDate);
				formDatesMap = customResponseFormDates(formDate);
				return formDatesMap;
				
			}
			else
			{
				throw new HandledException("CHECK_PARAMETERS", "not existed");
			}
			
		
		}
		
		
		
		@Override
		public HashMap<String, Object> updateFormName(Long fid,Form form)throws HandledException {
			
			Optional<Form> existedForm=formServiceRepo.findById(fid);
			HashMap<String, Object> formDatesMap = new HashMap<>();
			if(existedForm.get()!=null)
			{
				existedForm.get().setName(form.getName());
				
				formServiceRepo.save(existedForm.get());
				formDatesMap = customResponseForm(existedForm.get());
				return formDatesMap;
				
			}
			else
			{
				throw new HandledException("CHECK_PARAMETERS", "not existed");
			}
			
		
		}

		@Override
		public HashMap<String, Object> updateSubFormHeading(Long sid, SubForm subForm) throws HandledException {
			Optional<SubForm> existedSubForm=subFormRepo.findById(sid);
			
			HashMap<String, Object> formDatesMap = new HashMap<>();
			if(existedSubForm.get()!=null)
			{
				existedSubForm.get().setHeading(subForm.getHeading());
				
				subFormRepo.save(existedSubForm.get());
				formDatesMap = customResponseSubForm(existedSubForm.get());
				return formDatesMap;
				
			}
			else
			{
				throw new HandledException("CHECK_PARAMETERS", "not existed");
			}
		}

		@Override
		public HashMap<String, Object> updateSubFormHeadingsByFid(Long fid, List<SubForm> subForms) throws HandledException {
			
			return null;
		}

		@Override
		public HashMap<String, Object> getFormById(Long fid) throws HandledException {
			Optional<Form> optionalForm = formServiceRepo.findById(fid);
			if (optionalForm.isPresent()) {
		        Form form = optionalForm.get();
		        return customResponseForm(form);
		    } else {
		        throw new HandledException("CHECK_PARAMETERS", "not existed");
		    }
			
		}

		@Override
		public Map<String, Boolean> deleteForm(Long fid) throws HandledException 
		{
			      Optional<Form> optionalForm = formServiceRepo.findById(fid);
			      FormDates formDates=formDatesRepo.findByFid(fid);
			      FormStatus formStatus=formStatusRepo.findByFid(fid);
			      List<DraftAnswer> draftAnswers=draftAnswerRepo.findAllByFid(fid);
			      List<FinalSubmitAnswer> finalSubmitAnswers=finalSubmitAnswerRepo.findAllByFid(fid);
			        if (optionalForm.isPresent()) {
			            Form form = optionalForm.get();
			            if(formStatus!=null)
			            {
			            	if(formStatus.isStatus()==false)
			            {
			            	 draftAnswerRepo.deleteAll(draftAnswers);
			            }
			            else
			            {
			            	finalSubmitAnswerRepo.deleteAll(finalSubmitAnswers);
			            }
			            
			            	formStatusRepo.delete(formStatus);
			            }
			            
			            formServiceRepo.delete(form);
			            
			            if(formDates!=null)
			            {
			            	formDatesRepo.delete(formDates);
			            	
			            }
			            
			            HashMap<String, Boolean> response = new HashMap<>();
						 response.put("deleted", Boolean.TRUE);
						 return response;
			        } else {
			        	throw new HandledException("CHECK_PARAMETERS", "not existed");
			        }
			   
		}
		
		@Override
		public boolean FormByConsistuency(String userId,Long sid) throws HandledException 
		{
			List<DraftAnswer> result=draftAnswerRepo.findBySidAndSubmittedBy(sid, userId);
			
			if(result == null|| result.isEmpty())
			
				return false;
			else
			return true;
		
		
		}
		

		@Override
		public List allDownload() throws HandledException {
			// TODO Auto-generated method stub
			List<DownloadPdf> downloadData=new ArrayList<DownloadPdf>();
			try{
				//downloadData=downloadRepo.findAll();
				downloadData=downloadRepo.findAllByOrderByIdAsc();
				//formData = formServiceRepo.findAll();
				
			}catch(Exception e) {
				
				 System.out.println(e);
			return null;
			
		}
			List downloadList = new ArrayList<>() ;
			
			for (int i = 0; i < downloadData.size(); i++){  
				
				downloadList.add(customResponseDownload(downloadData.get(i)));  
			}  
			
			return downloadList;
		}

private HashMap<String, Object> customResponseDownload( DownloadPdf downloadData) {
			
			HashMap<String, Object> formMap =  new HashMap<>();
			
			formMap.put("id", downloadData.getId());
			formMap.put("foldName", downloadData.getFoldName());
			formMap.put("fileName", downloadData.getFileName());
			formMap.put("fileText",downloadData.getFileText());

			return formMap;
			
		}

@Override
public HashMap<String, Object> getArrivalDepartureData(String userid,String constituency,String district,String state) throws HandledException {
	
	ObserverUser observer=observerUserRepo.getObserverUserByobscode(userid);
	String name=observer.getName();
	
	String email=observer.getEmail();
	
	Long mobile=observer.getMobnum();
	
	String fax=observer.getO_FAX();
	
	
	List<Obs_Allot> obs_AllotList=obs_AllotREPO.findAllByObscode(userid);
	
	
	
	//String acNo=Obs_Allot.getAc_No();
	//AC_LIST2 aC_LIST2=aC_LIST2_REPO2.findByAcNo(acNo);
	
	//String constituencyName=aC_LIST2.getAC_NAME_HI();
	
	//String district=Obs_Allot.getDIST_NAME();
	
	//String stCode=Obs_Allot.getSt_Code();
	
	//STATE_LIST2 sTATE_LIST2=sTATE_LIST2_Repo.findByStCode(stCode);
	
	//String state=sTATE_LIST2.getST_NAME_HI();
	
		return customResponseArrivalDeparture(userid,name,email,mobile,fax,constituency,district,state);
	
}
//custom response
		private HashMap<String, Object> customResponseArrivalDeparture(String userid,String name,String email,Long mob,String fax,String constituency,String district,String state) {
			
			HashMap<String, Object> formMap =  new HashMap<>();
			
			formMap.put("ObserverNameAndCode",name+" "+userid);
			formMap.put("Email",email);
			formMap.put("Constituency",constituency);
			formMap.put("DistrictAndState",district+" "+state);
			formMap.put("MobileNo",mob);
			formMap.put("FaxNo",fax);
			return formMap;
			
		}
		
}

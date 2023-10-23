package Observer20.Response;


public class EciObserverArrivalRequest {

	private Integer userId;

	private Integer formId;

	private String observerId;

	private String constituencyId;

	private Integer quesId;

	private String answer;

	private String remark;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public String getObserverId() {
		return observerId;
	}

	public void setObserverId(String observerId) {
		this.observerId = observerId;
	}

	public String getConstituencyId() {
		return constituencyId;
	}

	public void setConstituencyId(String constituencyId) {
		this.constituencyId = constituencyId;
	}

	public Integer getQuesId() {
		return quesId;
	}

	public void setQuesId(Integer quesId) {
		this.quesId = quesId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public EciObserverArrivalRequest(Integer userId, Integer formId, String observerId, String constituencyId,
			Integer quesId, String answer, String remark) {
		super();
		this.userId = userId;
		this.formId = formId;
		this.observerId = observerId;
		this.constituencyId = constituencyId;
		this.quesId = quesId;
		this.answer = answer;
		this.remark = remark;
	}

	public EciObserverArrivalRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}


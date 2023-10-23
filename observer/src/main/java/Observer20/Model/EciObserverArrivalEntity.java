package Observer20.Model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Eci_Observer_Arrival")
public class EciObserverArrivalEntity {
	
	@EmbeddedId
	private EciObserverArrivalPKId eciObserverArrivalPKId;
	
	@Column(name = "ques_Id")
	private Integer quesId;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "remark")
	private String remark;

	public EciObserverArrivalPKId getEciObserverArrivalPKId() {
		return eciObserverArrivalPKId;
	}

	public void setEciObserverArrivalPKId(EciObserverArrivalPKId eciObserverArrivalPKId) {
		this.eciObserverArrivalPKId = eciObserverArrivalPKId;
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

	public EciObserverArrivalEntity(EciObserverArrivalPKId eciObserverArrivalPKId, Integer quesId, String answer,
			String remark) {
		super();
		this.eciObserverArrivalPKId = eciObserverArrivalPKId;
		this.quesId = quesId;
		this.answer = answer;
		this.remark = remark;
	}

	public EciObserverArrivalEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EciObserverArrivalEntity [eciObserverArrivalPKId=" + eciObserverArrivalPKId + ", quesId=" + quesId
				+ ", answer=" + answer + ", remark=" + remark + "]";
	}
	
	
}
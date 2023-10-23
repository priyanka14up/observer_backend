package Observer20.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;


public class EciObserverArrivalPKId implements Serializable{

	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "form_id")
	private Integer formId;

	@Column(name = "observer_id")
	private String observerId;

	@Column(name = "constituency_id")
	private String constituencyId;

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

	public EciObserverArrivalPKId(Integer userId, Integer formId, String observerId, String constituencyId) {
		super();
		this.userId = userId;
		this.formId = formId;
		this.observerId = observerId;
		this.constituencyId = constituencyId;
	}

	public EciObserverArrivalPKId() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

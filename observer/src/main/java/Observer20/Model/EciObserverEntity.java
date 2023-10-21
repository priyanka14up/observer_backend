package Observer20.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//entity   package com.eci.observer.eci.observer.model;




@Entity
@Table(name = "eci_question_master")
public class EciObserverEntity {
	@Id
	@Column(name = "sno")
	private Long Id;
	@Column(name = "form_id")
	private Integer formId;
	@Column(name = "sid")
	private Integer sId;
	@Column(name = "subform_name")
	private String subFormName;
	@Column(name = "ques")
	private String quesText;
	@Column(name = "type")
	private String type;
	@Column(name = "qid")
	private Integer qId;
	@Column(name = "table_name")
	private String tableName;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Integer getFormId() {
		return formId;
	}
	public void setFormId(Integer formId) {
		this.formId = formId;
	}
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getSubFormName() {
		return subFormName;
	}
	public void setSubFormName(String subFormName) {
		this.subFormName = subFormName;
	}
	public String getQuesText() {
		return quesText;
	}
	public void setQuesText(String quesText) {
		this.quesText = quesText;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getqId() {
		return qId;
	}
	public void setqId(Integer qId) {
		this.qId = qId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	@Override
	public String toString() {
		return "EciObserverEntity [Id=" + Id + ", formId=" + formId + ", sId=" + sId + ", subFormName=" + subFormName
				+ ", quesText=" + quesText + ", type=" + type + ", qId=" + qId + ", tableName=" + tableName + "]";
	}
	public EciObserverEntity(Long id, Integer formId, Integer sId, String subFormName, String quesText, String type,
			Integer qId, String tableName) {
		super();
		Id = id;
		this.formId = formId;
		this.sId = sId;
		this.subFormName = subFormName;
		this.quesText = quesText;
		this.type = type;
		this.qId = qId;
		this.tableName = tableName;
	}
	public EciObserverEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
package Observer20.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class EciObserverResponse {

	

	private Integer formId;

	//private Integer sId;

	//private String subFormName;

	private String quesText;

	private String type;

	private Integer qId;
@JsonIgnore
	private String tableName;
public Integer getFormId() {
	return formId;
}
public void setFormId(Integer formId) {
	this.formId = formId;
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



}
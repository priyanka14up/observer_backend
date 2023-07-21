package Observer20.Dto;

import java.util.List;

public class FormRequest {
    private String formName;
    private String obsType;
    private List<SubFormRequest> subforms;
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public List<SubFormRequest> getSubforms() {
		return subforms;
	}
	public void setSubforms(List<SubFormRequest> subforms) {
		this.subforms = subforms;
	}
	public String getObsType() {
		return obsType;
	}
	public void setObsType(String obsType) {
		this.obsType = obsType;
	}
	

    // Constructors, getters, and setters
    // ...
}

package Observer20.Model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Observer_forms")
@EntityListeners(AuditingEntityListener.class)
public class Form {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "form_id", updatable = false, nullable = false)
    private Long id;
	
	@NotBlank(message = "Form Name is mandatory")
	@Column(columnDefinition = "TEXT",name = "form_name",nullable=false)
    private String name;
	
	@NotBlank(message = "Observer Type is mandatory")
	@Column(name = "obs_type",nullable=false)
    private  String obsType;
	
	 @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
	    private List<SubForm> subforms = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getObsType() {
		return obsType;
	}

	public void setObsType(String obsType) {
		this.obsType = obsType;
	}

	public List<SubForm> getSubforms() {
		return subforms;
	}

	public void setSubforms(List<SubForm> subforms) {
		this.subforms = subforms;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", name=" + name + ", obsType=" + obsType + ", subforms=" + subforms + "]";
	}

	

	
	
//	public List<SubForm> getSubforms() {
//		return subforms;
//	}
//
//	public void setSubforms(List<SubForm> subforms) {
//		this.subforms = subforms;
//	}

	

	
	
	

//	public List<SubForm> getSubforms() {
//		return subforms;
//	}
//
//	public void setSubforms(List<SubForm> subforms) {
//		this.subforms = subforms;
//	}

//	public List<SubForm> getSubforms() {
//		return subforms;
//	}
//
//	public void setSubforms(List<SubForm> subforms) {
//		this.subforms = subforms;
//	}

	
	
	
	
	
	}





	


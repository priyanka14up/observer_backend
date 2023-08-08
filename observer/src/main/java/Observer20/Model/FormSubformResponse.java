package Observer20.Model;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "form_subform_responses")
public class FormSubformResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "f_id",nullable=false)
    private Long fid;
    
    @Column(name = "s_id",nullable=false)
    private Long sid;
    
    /*subform responses*/
    @Convert(converter = Serialization.class)
    @Column(columnDefinition = "TEXT")
    List<Map> subformResponses;
    //private Map<Long, List<Long>> subformResponses;
    
    //@Convert(converter = JsonBConverter.class)
   // @Column(name = "subform_responses", columnDefinition = "jsonb")
    //private Map<String, SubformResponse> subformResponses = new HashMap<>();
    
    /*observer code*/
	@Column(name = "submitted_by",nullable=false)
    private String submittedBy;
	
    @Column(name = "status")
    private boolean status;
    
    public FormSubformResponse(Long fid,Long sid,boolean status,List<Map> subformResponses) {
        this.fid = fid;
        this.sid=sid;
        this.status = status;
        this.subformResponses = subformResponses;
    }
      
    
	public FormSubformResponse() {
		
	}

	public Long getFid() {
		return fid;
	}


	public void setFid(Long fid) {
		this.fid = fid;
	}
	


	public Long getSid() {
		return sid;
	}


	public void setSid(Long sid) {
		this.sid = sid;
	}


	public List<Map> getSubformResponses() {
		return subformResponses;
	}


	public void setSubformResponses(List<Map> subformResponses) {
		this.subformResponses = subformResponses;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getSubformResponses() {
//		return subformResponses;
//	}
//
//	public void setSubformResponses(String subformResponses) {
//		this.subformResponses = subformResponses;
//	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "FormSubformResponse [id=" + id + ", fid=" + fid + ", sid=" + sid + ", subformResponses="
				+ subformResponses + ", submittedBy=" + submittedBy + ", status=" + status + "]";
	}

}
package Observer20.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="Master_Questions_static")
@EntityListeners(AuditingEntityListener.class)
public class QuestionStatic {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;
	
	@Column(name = "q_id",nullable=false)
    private Long qid;

	@Column(columnDefinition = "TEXT",name = "ques_Text",nullable=false)
    private String qtext;
	
	@Column(name = "type",nullable=false)
    private  String type;
	
	@Column(name = "f_id",nullable=false)
    private Long fid;
	
	@Column(name = "s_id")
    private Long sid;
	
	



	@Column(name = "subform_heading")
    private String sHeading;
	
	@Column(name = "table_name")
    private String tName;
	
	
	

	public QuestionStatic(Long id, Long qid, String qtext, String type, Long fid, Long sid, String sHeading,
			String tName) {
		super();
		this.id = id;
		this.qid = qid;
		this.qtext = qtext;
		this.type = type;
		this.fid = fid;
		this.sid = sid;
		this.sHeading = sHeading;
		this.tName = tName;
	}

	public QuestionStatic() {
	    // Default constructor
	}
	
	public Long getQid() {
		return qid;
	}
	
	

	public void setQid(Long qid) {
		this.qid = qid;
	}

	


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public String getQtext() {
		return qtext;
	}

	public void setQtext(String qtext) {
		this.qtext = qtext;
	}
	
	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}
	
	

	public String getsHeading() {
		return sHeading;
	}



	public void setsHeading(String sHeading) {
		this.sHeading = sHeading;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "QuestionStatic [id=" + id + ", qid=" + qid + ", qtext=" + qtext + ", type=" + type + ", fid=" + fid
				+ ", sid=" + sid + ", sHeading=" + sHeading + ", tName=" + tName + "]";
	}

	
	


}

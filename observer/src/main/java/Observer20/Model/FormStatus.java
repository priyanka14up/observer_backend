package Observer20.Model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="status")
@EntityListeners(AuditingEntityListener.class)
public class FormStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stat_id", updatable = false, nullable = false)
    private Long stid;
	
	@Column(name = "f_id",nullable=false)
    private Long fid;
	
	@Column(name = "status",nullable=false)
    private boolean status;
	
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modified",nullable=false)
    private Date date;
	
	  /*observer code*/
			@Column(name = "submitted_by",nullable=false)
		    private String submittedBy;
			
	@Column(name = "consistuency")
	private String Consistuency;
			
	public Long getStid() {
		return stid;
	}

	public void setStid(Long stid) {
		this.stid = stid;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}
	
	
	

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	
	
	
	public String getConsistuency() {
		return Consistuency;
	}

	public void setConsistuency(String consistuency) {
		Consistuency = consistuency;
	}

	@Override
	public String toString() {
		return "FormStatus [stid=" + stid + ", fid=" + fid + ", status=" + status + ", date=" + date + ", submittedBy="
				+ submittedBy + ", Consistuency=" + Consistuency + "]";
	}

	
	
	
	}





	


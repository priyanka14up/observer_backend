
package Observer20.Model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="forms_dates")
@EntityListeners(AuditingEntityListener.class)
public class FormDates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

	
	@Column(name = "fid",nullable=false)
    private  Long fid;
	
	
	@NotBlank(message = "Observer Type is mandatory")
	@Column(name = "obs_type",nullable=false)
    private  String obsType;
	
	
	@Column(name = "start_date",nullable=false)
    private LocalDate sdate;
	
	
	@Column(name = "last_date",nullable=false)
    private LocalDate ldate;
	
	
	@Column(name = "State",nullable=false)
    private String state;
	
	@Column(name = "PhaseNo",nullable=false)
    private Long phaseNo;
	
	
	
	@Column(name = "activeStatus",nullable=false)
    private  String activeStatus;
	



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public String getObsType() {
		return obsType;
	}

	public void setObsType(String obsType) {
		this.obsType = obsType;
	}

	

	public LocalDate getSdate() {
		return sdate;
	}

	public void setSdate(LocalDate sdate) {
		this.sdate = sdate;
	}

	public LocalDate getLdate() {
		return ldate;
	}

	public void setLdate(LocalDate ldate) {
		this.ldate = ldate;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	public Long getPhaseNo() {
		return phaseNo;
	}

	public void setPhaseNo(Long phaseNo) {
		this.phaseNo = phaseNo;
	}

	@Override
	public String toString() {
		return "FormDates [id=" + id + ", fid=" + fid + ", obsType=" + obsType + ", sdate=" + sdate + ", ldate=" + ldate
				+ ", state=" + state + ", phaseNo=" + phaseNo + ", activeStatus=" + activeStatus + "]";
	}


	
	
	
	}


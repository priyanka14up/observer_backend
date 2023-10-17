
package Observer20.Model;
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
@Table(name="messages")
@EntityListeners(AuditingEntityListener.class)
public class Messages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
	
	//@NotBlank(message = "Folder Name is mandatory")
	@Column(columnDefinition = "TEXT",name = "msg_text",nullable=false)
    private String msgText;
	
	//@NotBlank(message = "File Name is mandatory")
	@Column(name = "obscode",nullable=false)
    private String obsCode;

	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modified",nullable=false)
    private Date date;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsgText() {
		return msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	public String getObsCode() {
		return obsCode;
	}

	public void setObsCode(String obsCode) {
		this.obsCode = obsCode;
	}
	
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", msgText=" + msgText + ", obsCode=" + obsCode + ", date=" + date + "]";
	}

	

	}
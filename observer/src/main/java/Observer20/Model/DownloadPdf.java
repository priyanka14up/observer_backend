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
@Table(name="Download")
@EntityListeners(AuditingEntityListener.class)
public class DownloadPdf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
	
	//@NotBlank(message = "Folder Name is mandatory")
	@Column(name = "folder_name",nullable=false)
    private String foldName;
	
	//@NotBlank(message = "File Name is mandatory")
	@Column(name = "file_name",nullable=false)
    private String fileName;
	
	//@NotBlank(message = "File Text is mandatory")
	@Column(columnDefinition = "TEXT",name = "file_Text",nullable=false)
    private String fileText;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoldName() {
		return foldName;
	}

	public void setFoldName(String foldName) {
		this.foldName = foldName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileText() {
		return fileText;
	}

	public void setFileText(String fileText) {
		this.fileText = fileText;
	}

	@Override
	public String toString() {
		return "DownloadPdf [id=" + id + ", foldName=" + foldName + ", fileName=" + fileName + ", fileText=" + fileText
				+ "]";
	}
	
	}
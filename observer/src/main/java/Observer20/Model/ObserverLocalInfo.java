package Observer20.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotEmpty;


@SuppressWarnings("deprecation")
@Entity
@Table(name = "observer_local_info")
public class ObserverLocalInfo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	  @OneToOne
	  @JoinColumn(name = "obscode") 
	  private ObserverUser observerUser;
	 
	/*
	 * @Column(name = "obscode") private String obscode;
	 */
	  
    @Column(name = "local_address")
    @NotEmpty(message = "Local address cannot be empty")
    private String localAddress;

    @Column(name = "local_mobile")
    @NotNull(message = "Mobnum cannot be null")
    @Min(value = 1000000000, message = "Mobnum must be at least 10 digits")
    @Max(value = 9999999999L, message = "Mobnum can be at most 10 digits")
    private String localMobile;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ObserverUser getObserverUser() {
		return observerUser;
	}

	public void setObserverUser(ObserverUser observerUser) {
		this.observerUser = observerUser;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public String getLocalMobile() {
		return localMobile;
	}

	public void setLocalMobile(String localMobile) {
		this.localMobile = localMobile;
	}

	public ObserverLocalInfo(Long id, ObserverUser observerUser,
			@NotEmpty(message = "Local address cannot be empty") String localAddress,
			@NotNull(message = "Mobnum cannot be null") @Min(value = 1000000000, message = "Mobnum must be at least 10 digits") @Max(value = 999999999, message = "Mobnum can be at most 10 digits") String localMobile) {
		super();
		this.id = id;
		this.observerUser = observerUser;
		this.localAddress = localAddress;
		this.localMobile = localMobile;
	}

	public ObserverLocalInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ObserverLocalInfo [id=" + id + ", observerUser=" + observerUser + ", localAddress=" + localAddress
				+ ", localMobile=" + localMobile + "]";
	}

	

	
}

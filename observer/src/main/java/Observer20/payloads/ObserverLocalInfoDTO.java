package Observer20.payloads;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ObserverLocalInfoDTO {
	private Long id;
	@NotBlank(message = "Local address cannot be null.")
	private String localAddress;

	
	  
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

	public ObserverLocalInfoDTO(Long id, String localAddress, String localMobile) {
		super();
		this.id = id;
		this.localAddress = localAddress;
		this.localMobile = localMobile;
	}

	@Override
	public String toString() {
		return "ObserverLocalInfoDTO [id=" + id + ", localAddress=" + localAddress + ", localMobile=" + localMobile
				+ "]";
	}

	public ObserverLocalInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
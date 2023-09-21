package Observer20.Model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ObserverLocalInfoRequest {

	private String obscode;
	@NotEmpty(message = "Local address cannot be empty")
    private String localAddress;
	
	  @NotNull(message = "Mobnum cannot be null")
	  
	  @Min(value = 1000000000, message = "Mobnum must be at least 10 digits")
	  
	  @Max(value = 9999999999L, message = "Mobnum can be at most 10 digits")
	 
    private String localMobile;

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
	public String getObscode() {
		return obscode;
	}
	public void setObscode(String obscode) {
		this.obscode = obscode;
	}
    
	
}

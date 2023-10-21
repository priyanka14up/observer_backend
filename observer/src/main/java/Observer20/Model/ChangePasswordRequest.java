package Observer20.Model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePasswordRequest {
    private String obscode;
    
    @NotEmpty
    @Size(min=8, max=20, message="Password must be between 8 and 20 characters")
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
    message="Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character (@#$%^&+=)"
    )
    private String oldpassword;
    
    @NotEmpty
    @Size(min=8, max=20, message="Password must be between 8 and 20 characters")
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
    message="Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character (@#$%^&+=)"
    )
    private String newpassword;

	/*
	 * public ChangePasswordRequest() { // Initialize oldPassword to an empty string
	 * or any default value you prefer this.oldPassword = ""; }
	 */

    
    // Getters and setters for the fields

   

    public String getObscode() {
        return obscode;
    }

    public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public void setObscode(String obscode) {
        this.obscode = obscode;
    }
}

package Observer20.payloads;

public class LoginProfileStatusResponse {

	private Boolean profileStatus=false;
   
    private String email;
    private long mobnum;
	public Boolean getProfileStatus() {
		return profileStatus;
	}
	public void setProfileStatus(Boolean profileStatus) {
		this.profileStatus = profileStatus;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public long getMobnum() {
		return mobnum;
	}
	public void setMobnum(long mobnum) {
		this.mobnum = mobnum;
	}
	public LoginProfileStatusResponse(Boolean profileStatus, String email, long mobnum) {
		super();
		this.profileStatus = profileStatus;
		this.email = email;
		this.mobnum = mobnum;
	}
	@Override
	public String toString() {
		return "LoginProfileStatusResponse [profileStatus=" + profileStatus + ", email=" + email + ", mobnum=" + mobnum
				+ "]";
	}
	public LoginProfileStatusResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
}

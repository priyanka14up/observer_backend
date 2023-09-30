package Observer20.payloads;

public class LoginProfileStatusResponse {

	private Boolean profileStatus=false;
    private String name;
    private String email;
    private long mobnum;
	public Boolean getProfileStatus() {
		return profileStatus;
	}
	public void setProfileStatus(Boolean profileStatus) {
		this.profileStatus = profileStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public LoginProfileStatusResponse(Boolean profileStatus, String name, String email, long mobileNumber) {
		super();
		this.profileStatus = profileStatus;
		this.name = name;
		this.email = email;
		this.mobnum = mobileNumber;
	}
	@Override
	public String toString() {
		return "LoginProfileStatusResponse [profileStatus=" + profileStatus + ", name=" + name + ", email=" + email
				+ ", mobileNumber=" + mobnum + "]";
	}
	public LoginProfileStatusResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

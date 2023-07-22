package Observer20.payloads;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class ObserverUserDto {
	private int id;
	
	@NotEmpty
	private String obscode;
    @NotEmpty
	 @Size(min=4,message="user name must be greter than 4 charcter!!")
	private String name;
    @Email(message="your email adress is not valid!!")
	private String email;

	@NotEmpty
	@Size(min=3, max=10,message="password must be minimum of 3 cahr and maximum of 10 char")
	private String password;
	@NotEmpty
	 private String role;
	@NotEmpty
	private String service;
	@NotEmpty
	private String  homeState;
	@NotNull
	private int mobnum;
	@NotNull
	private int workexperience;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObscode() {
		return obscode;
	}
	public void setObscode(String obscode) {
		this.obscode = obscode;
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

	/*
	 * public String getPassword() { return password; }
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getHomeState() {
		return homeState;
	}
	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}
	public int getMobnum() {
		return mobnum;
	}
	public void setMobnum(int mobnum) {
		this.mobnum = mobnum;
	}
	public int getWorkexperience() {
		return workexperience;
	}
	public void setWorkexperience(int workexperience) {
		this.workexperience = workexperience;
	}
	@Override
	public String toString() {
		return "ObserverUserDto [id=" + id + ", obscode=" + obscode + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", service=" + service + ", homeState=" + homeState
				+ ", mobnum=" + mobnum + ", workexperience=" + workexperience + "]";
	}
	public ObserverUserDto(int id, String obscode, String name, String email, String password, String role,
			String service, String homeState, int mobnum, int workexperience) {
		super();
		this.id = id;
		this.obscode = obscode;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.service = service;
		this.homeState = homeState;
		this.mobnum = mobnum;
		this.workexperience = workexperience;
	}
	public ObserverUserDto() {
		
	}
	
	
	 
	
}

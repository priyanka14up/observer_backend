package Observer20.payloads;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ObserverUserDtoUpdation {
	
	
private int id;
	
	@NotEmpty
	private String obscode;
    @NotEmpty
    @Size(min=4,message="user name must be greter than 4 charcter!!")
	private String name;
    @Email(message="your email adress is not valid!!")
	private String email;
    
	@NotEmpty
	 private String role;
	@NotEmpty
	private String service;
	@NotEmpty
	private String  homeState;
	@NotNull
	@NotNull(message = "Mobnum cannot be null")
    @Min(value = 1000000000, message = "Mobnum must be at least 10 digits")
    @Max(value = 9999999999L, message = "Mobnum can be at most 10 digits")
	private long mobnum;
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
	public long getMobnum() {
		return mobnum;
	}
	public void setMobnum(long mobnum) {
		this.mobnum = mobnum;
	}
	public int getWorkexperience() {
		return workexperience;
	}
	public void setWorkexperience(int workexperience) {
		this.workexperience = workexperience;
	}
	public ObserverUserDtoUpdation(int id, @NotEmpty String obscode, @NotEmpty String name, String email,
			@NotEmpty String role, @NotEmpty String service, @NotEmpty String homeState, @NotNull long mobnum,
			@NotNull int workexperience) {
		super();
		this.id = id;
		this.obscode = obscode;
		this.name = name;
		this.email = email;
		this.role = role;
		this.service = service;
		this.homeState = homeState;
		this.mobnum = mobnum;
		this.workexperience = workexperience;
	}
	@Override
	public String toString() {
		return "ObserverUserDtoUpdation [id=" + id + ", obscode=" + obscode + ", name=" + name + ", email=" + email
				+ ", role=" + role + ", service=" + service + ", homeState=" + homeState + ", mobnum=" + mobnum
				+ ", workexperience=" + workexperience + "]";
	}
	public ObserverUserDtoUpdation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}

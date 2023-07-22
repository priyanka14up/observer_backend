package Observer20.Model;


import org.springframework.stereotype.Component;


@Component
public class LoginBean {
	

	String obs_id;
	String password;
	public String getObs_id() {
		return obs_id;
	}
	public void setObs_id(String obs_id) {
		this.obs_id = obs_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

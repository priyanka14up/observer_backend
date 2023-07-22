package Observer20.payloads;

public class LoginDto {
	private String obscode;
	private String password;
	public String getObscode() {
		return obscode;
	}
	public void setObscode(String obscode) {
		this.obscode = obscode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDto(String obscode, String password) {
		super();
		this.obscode = obscode;
		this.password = password;
	}
	public LoginDto() {
		
	}
	@Override
	public String toString() {
		return "LoginDto [obscode=" + obscode + ", password=" + password + "]";
	}
	
	
	
}

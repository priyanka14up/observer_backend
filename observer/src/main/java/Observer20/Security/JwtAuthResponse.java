package Observer20.Security;

public class JwtAuthResponse {
	private String token;
	private String obscode;
    private String name;
	
    private String email;
    
    private String role;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public JwtAuthResponse(String token, String obscode, String name, String email, String role) {
		super();
		this.token = token;
		this.obscode = obscode;
		this.name = name;
		this.email = email;
		this.role = role;
	}
   
    
	

	

	

}

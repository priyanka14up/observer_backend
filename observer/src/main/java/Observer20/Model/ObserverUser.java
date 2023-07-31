package Observer20.Model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="eci_observers")
public class ObserverUser implements UserDetails{
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String obscode;
	

	@Column(name="observer_name",nullable=false,length=100)
	private String name;
	
    private String email;
    private String password;
    private String role;
    private String service;
    private String homeState;
    private int mobnum;
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

	

	public ObserverUser(int id, String obscode, String name, String email, String password, String role, String service,
			String homeState, int mobnum, int workexperience, Set<Role> roles) {
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

	public ObserverUser() {
		
		
	}
   
	@Override
	public String toString() {
		return "ObserverUser [id=" + id + ", obscode=" + obscode + ", name=" + name + ", email=" + email + ", password="
				+ password + ", role=" + role + ", service=" + service + ", homeState=" + homeState + ", mobnum="
				+ mobnum + ", workexperience=" + workexperience + ", roles="  + "]";
	}

	
	  @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	  
	  @JoinTable(name="user_role", 
	  joinColumns =@JoinColumn (name="eci_observers",referencedColumnName="id"),
	  inverseJoinColumns = @JoinColumn(name="role",referencedColumnName="id") )

	  private Set<Role> roles= new HashSet<>();


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities=roles.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return obscode;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	 
	 
	
}

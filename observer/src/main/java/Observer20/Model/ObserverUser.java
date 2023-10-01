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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="eci_observers")
public class ObserverUser implements UserDetails{
	
	

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String obscode;
	

	@Column(name="observer_name",nullable=false,length=100)
	private String name;
	
    private String email;
    @JsonIgnore
    private String password;
    private String role;
    private String service;
    private String homeState;
    private long mobnum;
    private int workexperience;
    private String ECI_OBSID;
    private String ID_NO;
    private String OB_TITLE;
    private String OB_CADRE;
    private String OB_YEAR;
    private String OB_SEX;
    private String OB_DOB;
    private String OB_STATUS;
    private String OB_LANG;
    private String OB_DESIG;
    private String O_ADR_L1;
    private String O_CITY;
    private String O_STATE;
    private String O_PIN;
    private String O_STD;
    private String O_FAX;
    private String R_PIN;
    private String R_STD;
    private String R_TNO;
    private String R_FAX;
    private String EMG_NAME;
    private String SPONSOR;
    private String AGE;
    private String O_AccountNo;
    private String O_IFCSCode;
    private String O_BankName;
    private String O_BranchName;
    private String O_AccountHolderName;
    private String OB_FromDate;
    private String OB_ToDate;
    private String OB_CDEP;
    private String Exp_as_RO;
    private String Exp_as_DEO;
    private String Exp_as_OtherElectionDuty;
    @Column(name = "Profile_Status") 
	  private Boolean ProfileStatus = false;
	
	  public String getOB_CDEP() {
		return OB_CDEP;
	}

	public void setOB_CDEP(String oB_CDEP) {
		OB_CDEP = oB_CDEP;
	}

	public String getExp_as_RO() {
		return Exp_as_RO;
	}

	public void setExp_as_RO(String exp_as_RO) {
		Exp_as_RO = exp_as_RO;
	}

	public String getExp_as_DEO() {
		return Exp_as_DEO;
	}

	public void setExp_as_DEO(String exp_as_DEO) {
		Exp_as_DEO = exp_as_DEO;
	}

	public String getExp_as_OtherElectionDuty() {
		return Exp_as_OtherElectionDuty;
	}

	public void setExp_as_OtherElectionDuty(String exp_as_OtherElectionDuty) {
		Exp_as_OtherElectionDuty = exp_as_OtherElectionDuty;
	}


	
    
	
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
	
	

	

	public String getECI_OBSID() {
		return ECI_OBSID;
	}

	public void setECI_OBSID(String eCI_OBSID) {
		ECI_OBSID = eCI_OBSID;
	}

	public String getID_NO() {
		return ID_NO;
	}

	public void setID_NO(String iD_NO) {
		ID_NO = iD_NO;
	}

	public String getOB_TITLE() {
		return OB_TITLE;
	}

	public void setOB_TITLE(String oB_TITLE) {
		OB_TITLE = oB_TITLE;
	}

	public String getOB_CADRE() {
		return OB_CADRE;
	}

	public void setOB_CADRE(String oB_CADRE) {
		OB_CADRE = oB_CADRE;
	}

	public String getOB_YEAR() {
		return OB_YEAR;
	}

	public void setOB_YEAR(String oB_YEAR) {
		OB_YEAR = oB_YEAR;
	}

	public String getOB_SEX() {
		return OB_SEX;
	}

	public void setOB_SEX(String oB_SEX) {
		OB_SEX = oB_SEX;
	}

	public String getOB_DOB() {
		return OB_DOB;
	}

	public void setOB_DOB(String oB_DOB) {
		OB_DOB = oB_DOB;
	}

	public String getOB_STATUS() {
		return OB_STATUS;
	}

	public void setOB_STATUS(String oB_STATUS) {
		OB_STATUS = oB_STATUS;
	}

	public String getOB_LANG() {
		return OB_LANG;
	}

	public void setOB_LANG(String oB_LANG) {
		OB_LANG = oB_LANG;
	}

	public String getOB_DESIG() {
		return OB_DESIG;
	}

	public void setOB_DESIG(String oB_DESIG) {
		OB_DESIG = oB_DESIG;
	}

	public String getO_ADR_L1() {
		return O_ADR_L1;
	}

	public void setO_ADR_L1(String o_ADR_L1) {
		O_ADR_L1 = o_ADR_L1;
	}

	public String getO_CITY() {
		return O_CITY;
	}

	public void setO_CITY(String o_CITY) {
		O_CITY = o_CITY;
	}

	public String getO_STATE() {
		return O_STATE;
	}

	public void setO_STATE(String o_STATE) {
		O_STATE = o_STATE;
	}

	public String getO_PIN() {
		return O_PIN;
	}

	public void setO_PIN(String o_PIN) {
		O_PIN = o_PIN;
	}

	public String getO_STD() {
		return O_STD;
	}

	public void setO_STD(String o_STD) {
		O_STD = o_STD;
	}

	public String getO_FAX() {
		return O_FAX;
	}

	public void setO_FAX(String o_FAX) {
		O_FAX = o_FAX;
	}

	public String getR_PIN() {
		return R_PIN;
	}

	public void setR_PIN(String r_PIN) {
		R_PIN = r_PIN;
	}

	public String getR_STD() {
		return R_STD;
	}

	public void setR_STD(String r_STD) {
		R_STD = r_STD;
	}

	public String getR_TNO() {
		return R_TNO;
	}

	public void setR_TNO(String r_TNO) {
		R_TNO = r_TNO;
	}

	public String getR_FAX() {
		return R_FAX;
	}

	public void setR_FAX(String r_FAX) {
		R_FAX = r_FAX;
	}

	public String getEMG_NAME() {
		return EMG_NAME;
	}

	public void setEMG_NAME(String eMG_NAME) {
		EMG_NAME = eMG_NAME;
	}

	public String getSPONSOR() {
		return SPONSOR;
	}

	public void setSPONSOR(String sPONSOR) {
		SPONSOR = sPONSOR;
	}

	public String getAGE() {
		return AGE;
	}

	public void setAGE(String aGE) {
		AGE = aGE;
	}

	public String getO_AccountNo() {
		return O_AccountNo;
	}

	public void setO_AccountNo(String o_AccountNo) {
		O_AccountNo = o_AccountNo;
	}

	public String getO_IFCSCode() {
		return O_IFCSCode;
	}

	public void setO_IFCSCode(String o_IFCSCode) {
		O_IFCSCode = o_IFCSCode;
	}

	public String getO_BankName() {
		return O_BankName;
	}

	public void setO_BankName(String o_BankName) {
		O_BankName = o_BankName;
	}

	public String getO_BranchName() {
		return O_BranchName;
	}

	public void setO_BranchName(String o_BranchName) {
		O_BranchName = o_BranchName;
	}

	public String getO_AccountHolderName() {
		return O_AccountHolderName;
	}

	public void setO_AccountHolderName(String o_AccountHolderName) {
		O_AccountHolderName = o_AccountHolderName;
	}

	public String getOB_FromDate() {
		return OB_FromDate;
	}

	public void setOB_FromDate(String oB_FromDate) {
		OB_FromDate = oB_FromDate;
	}

	public String getOB_ToDate() {
		return OB_ToDate;
	}

	public void setOB_ToDate(String oB_ToDate) {
		OB_ToDate = oB_ToDate;
	}

	


	

	

	

	

	
	public Boolean getProfileStatus() {
		return ProfileStatus;
	}

	public void setProfileStatus(Boolean profileStatus) {
		ProfileStatus = profileStatus;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<UserSecurityQuestion> getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(Set<UserSecurityQuestion> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	public ObserverLocalInfo getLocalInfo() {
		return localInfo;
	}

	public void setLocalInfo(ObserverLocalInfo localInfo) {
		this.localInfo = localInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	


	public ObserverUser(int id, String obscode, String name, String email, String password, String role, String service,
			String homeState, long mobnum, int workexperience, String eCI_OBSID, String iD_NO, String oB_TITLE,
			String oB_CADRE, String oB_YEAR, String oB_SEX, String oB_DOB, String oB_STATUS, String oB_LANG,
			String oB_DESIG, String o_ADR_L1, String o_CITY, String o_STATE, String o_PIN, String o_STD, String o_FAX,
			String r_PIN, String r_STD, String r_TNO, String r_FAX, String eMG_NAME, String sPONSOR, String aGE,
			String o_AccountNo, String o_IFCSCode, String o_BankName, String o_BranchName, String o_AccountHolderName,
			String oB_FromDate, String oB_ToDate, String oB_CDEP, String exp_as_RO, String exp_as_DEO,
			String exp_as_OtherElectionDuty, Boolean profileStatus, Set<Role> roles,
			Set<UserSecurityQuestion> securityQuestions, ObserverLocalInfo localInfo) {
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
		ECI_OBSID = eCI_OBSID;
		ID_NO = iD_NO;
		OB_TITLE = oB_TITLE;
		OB_CADRE = oB_CADRE;
		OB_YEAR = oB_YEAR;
		OB_SEX = oB_SEX;
		OB_DOB = oB_DOB;
		OB_STATUS = oB_STATUS;
		OB_LANG = oB_LANG;
		OB_DESIG = oB_DESIG;
		O_ADR_L1 = o_ADR_L1;
		O_CITY = o_CITY;
		O_STATE = o_STATE;
		O_PIN = o_PIN;
		O_STD = o_STD;
		O_FAX = o_FAX;
		R_PIN = r_PIN;
		R_STD = r_STD;
		R_TNO = r_TNO;
		R_FAX = r_FAX;
		EMG_NAME = eMG_NAME;
		SPONSOR = sPONSOR;
		AGE = aGE;
		O_AccountNo = o_AccountNo;
		O_IFCSCode = o_IFCSCode;
		O_BankName = o_BankName;
		O_BranchName = o_BranchName;
		O_AccountHolderName = o_AccountHolderName;
		OB_FromDate = oB_FromDate;
		OB_ToDate = oB_ToDate;
		OB_CDEP = oB_CDEP;
		Exp_as_RO = exp_as_RO;
		Exp_as_DEO = exp_as_DEO;
		Exp_as_OtherElectionDuty = exp_as_OtherElectionDuty;
		ProfileStatus = profileStatus;
		this.roles = roles;
		this.securityQuestions = securityQuestions;
		this.localInfo = localInfo;
	}

	public ObserverUser() {
		
		
	}
   
	@Override
	public String toString() {
		return "ObserverUser [id=" + id + ", obscode=" + obscode + ", name=" + name + ", email=" + email + ", password="
				+ password + ", role=" + role + ", service=" + service + ", homeState=" + homeState + ", mobnum="
				+ mobnum + ", workexperience=" + workexperience + ", ECI_OBSID=" + ECI_OBSID + ", ID_NO=" + ID_NO
				+ ", OB_TITLE=" + OB_TITLE + ", OB_CADRE=" + OB_CADRE + ", OB_YEAR=" + OB_YEAR + ", OB_SEX=" + OB_SEX
				+ ", OB_DOB=" + OB_DOB + ", OB_STATUS=" + OB_STATUS + ", OB_LANG=" + OB_LANG + ", OB_DESIG=" + OB_DESIG
				+ ", O_ADR_L1=" + O_ADR_L1 + ", O_CITY=" + O_CITY + ", O_STATE=" + O_STATE + ", O_PIN=" + O_PIN
				+ ", O_STD=" + O_STD + ", O_FAX=" + O_FAX + ", R_PIN=" + R_PIN + ", R_STD=" + R_STD + ", R_TNO=" + R_TNO
				+ ", R_FAX=" + R_FAX + ", EMG_NAME=" + EMG_NAME + ", SPONSOR=" + SPONSOR + ", AGE=" + AGE
				+ ", O_AccountNo=" + O_AccountNo + ", O_IFCSCode=" + O_IFCSCode + ", O_BankName=" + O_BankName
				+ ", O_BranchName=" + O_BranchName + ", O_AccountHolderName=" + O_AccountHolderName + ", OB_FromDate="
				+ OB_FromDate + ", OB_ToDate=" + OB_ToDate + ", OB_CDEP=" + OB_CDEP + ", Exp_as_RO=" + Exp_as_RO
				+ ", Exp_as_DEO=" + Exp_as_DEO + ", Exp_as_OtherElectionDuty=" + Exp_as_OtherElectionDuty
				+ ", ProfileStatus=" + ProfileStatus + ", roles=" + roles + ", securityQuestions=" + securityQuestions
				+ ", localInfo=" + localInfo + "]";
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
	
	 @OneToMany(mappedBy = "observeruser", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<UserSecurityQuestion> securityQuestions = new HashSet<>();


	public void addSecurityQuestion(UserSecurityQuestion userSecurityQuestion) {
		// TODO Auto-generated method stub
		
	}
	@OneToOne(mappedBy = "observerUser", cascade = CascadeType.ALL, orphanRemoval = true)
	    private ObserverLocalInfo localInfo;

	    // Method to add local info
	    public void addLocalInfo(ObserverLocalInfo localInfo) {
	        this.localInfo = localInfo;
	    }

		public void setObserverLocalInfo(ObserverLocalInfo localInfo2) {
			// TODO Auto-generated method stub
			
		}

	 
	 
	
}

/*
 * package Observer20.Security;
 * 
 * import java.util.ArrayList; import java.util.Collection; import
 * java.util.List; import java.util.Set;
 * 
 * import org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails;
 * 
 * import Observer20.Model.ObserverUser;
 * 
 * 
 * public class MyUserDetails implements UserDetails{ private ObserverUser
 * observerUser; private MyUserDetails myUserDetails; public
 * MyUserDetails(MyUserDetails myUserDetails) {
 * this.myUserDetails=myUserDetails; }
 * 
 * 
 * public MyUserDetails(ObserverUser observerUser2) { // TODO Auto-generated
 * constructor stub }
 * 
 * 
 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
 * //Set<Role> roles=observerUser.getRole(); List<SimpleGrantedAuthority>
 * authorities= new ArrayList<>(); //for(Role role:roles) {
 * //authorities.add(new SimpleGrantedAuthority(role.getObscode()));
 * 
 * } return authorities; }
 * 
 * @Override public String getPassword() {
 * 
 * return observerUser.getPassword(); }
 * 
 * @Override public String getUsername() {
 * 
 * return observerUser.getName(); }
 * 
 * @Override public boolean isAccountNonExpired() { // TODO Auto-generated
 * method stub return true; }
 * 
 * @Override public boolean isAccountNonLocked() { // TODO Auto-generated method
 * stub return true; }
 * 
 * @Override public boolean isCredentialsNonExpired() { // TODO Auto-generated
 * method stub return true; }
 * 
 * @Override public boolean isEnabled() { // TODO Auto-generated method stub
 * return true; }
 * 
 * }
 */

  package Observer20.Security;
  
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; 
  import org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
  import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;



  
  @Configuration
  
  @EnableWebSecurity public class webSecurityConfig extends
  WebSecurityConfigurerAdapter{
  
  @Autowired CustomUserDetailsService customUserDetailsService;
  @Autowired
  MD5PasswordEncoder  mD5PasswordEncoder;
  
  //@Autowired PasswordEncoder PasswordEncoder;
  @Bean
  public CustomUserDetailsService customUserDetailsService() {
      return new CustomUserDetailsService();
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
  
  http. csrf(). disable() .authorizeRequests() .anyRequest() .authenticated()
  .and() .httpBasic(); }
  
  @Override 
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  
  auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder()); }

@Bean
public PasswordEncoder passwordEncoder() {
    return new MD5PasswordEncoder();
}


  }
  
/*
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * MD5PasswordEncoder() // return new BCryptPasswordEncoder(); }
 
 * 
 * 
 * 
 * }
 */
 
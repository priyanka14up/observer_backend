package Observer20.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Exception.ApiException;
import Observer20.Security.JwtAuthRequest;
import Observer20.Security.JwtAuthResponse;
import Observer20.Security.JwtTokenHelper;


@RestController

@RequestMapping("/api/auth")
  public class JwtAuthController {
  
  @Autowired private JwtTokenHelper jwtTokenHelper;
  
  @Autowired private UserDetailsService userDetailsService;
  
  @Autowired AuthenticationManager authenticationManager;
  
  @PostMapping("/login") 
  public ResponseEntity<JwtAuthResponse>
  createToken(@RequestBody JwtAuthRequest request) throws Exception {
  
  authenticate(request.getObscode(),request.getPassword()); 
  UserDetails userDetails=userDetailsService.loadUserByUsername(request.getObscode());
  String token=jwtTokenHelper.generateToken(userDetails); 
  JwtAuthResponse response= new JwtAuthResponse();
  response.setToken(token);
  
  return new  ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
  
  }
  private void authenticate(String obscode, String password) throws Exception
  {
  
  UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(obscode, password); 
  try {
  authenticationManager.authenticate(authenticationToken); }
  
  catch(BadCredentialsException e) { 
	  throw new ApiException("Invalid username or password") ; }
  
  }
  
  
  }


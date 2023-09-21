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
import Observer20.Model.ObserverUser;
import Observer20.Security.JwtAuthRequest;
import Observer20.Security.JwtAuthResponse;
import Observer20.Security.JwtTokenHelper;
import Observer20.repository.ObserverUserRepo;

@RestController

@RequestMapping("/api/auth")
public class JwtAuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	ObserverUserRepo ObserverUserRepo;

	
	
	
	 @PostMapping("/login")
	    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
	        authenticate(request.getObscode(), request.getPassword());
	        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getObscode());
	        String token = jwtTokenHelper.generateToken(userDetails);

	        // Get the user from the database
	        ObserverUser user = getUserByUsername(request.getObscode());
	        
	        String obscode = user.getObscode();
	        String name = user.getUsername();
	        String email = user.getEmail();
	        String role = user.getRole();
	        
	        JwtAuthResponse response = new JwtAuthResponse(token, obscode, name, email, role);
	        response.setToken(token);

	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    

	    // Helper method to retrieve the user by obscode from the database
	    private ObserverUser getUserByUsername(String obscode) {
	        
	        return ObserverUserRepo.findByObscode(obscode); 
	    }
	

	 private void authenticate(String obscode, String password) throws Exception {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(obscode,
				password);
		try {
			authenticationManager.authenticate(authenticationToken);
		}

		catch (BadCredentialsException e) {
			throw new ApiException("Invalid username or password");
		}

	}

}

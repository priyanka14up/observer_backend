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
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private ObserverUserRepo observerUserRepo;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
        authenticate(request.getObscode(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getObscode());
        String token = jwtTokenHelper.generateToken(userDetails);

        ObserverUser user = getUserByUsername(request.getObscode());

        String obscode = user.getObscode();
        String name = user.getName();
        String email = user.getEmail();
        String role = user.getRole();

        JwtAuthResponse response = new JwtAuthResponse(token, obscode, name, email, role);
        response.setToken(token);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ObserverUser getUserByUsername(String obscode) {
        return observerUserRepo.findByObscode(obscode);
    }

    private void authenticate(String obscode, String password) throws Exception {
        ObserverUser user = getUserByUsername(obscode);

        if (user == null) {
            throw new ApiException("User not found");
        }

        if (!user.getDISPLAY().equalsIgnoreCase("yes")) {
            throw new ApiException("User is not allowed to log in");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(obscode, password);

        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            throw new ApiException("Invalid username or password");
        }
    }
}

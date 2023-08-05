package Observer20.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Observer20.Model.ObserverUser;
import Observer20.repository.ObserverUserRepo;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	ObserverUserRepo observerUserRepo;

	@Override
	public UserDetails loadUserByUsername(String obscode) throws UsernameNotFoundException {
		
		ObserverUser observerUser=observerUserRepo.findByObscode(obscode);
		if(observerUser==null) 
		{ 
			throw new UsernameNotFoundException("could not find user"); }
		return observerUser;
		
		
		
	}

}

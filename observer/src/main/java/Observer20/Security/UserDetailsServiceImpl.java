package Observer20.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Observer20.Model.ObserverUser;
import Observer20.repository.ObserverUserRepo;



public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	ObserverUserRepo observerUserRepo;

	@Override
	public UserDetails loadUserByUsername(String obscode) throws UsernameNotFoundException {
		ObserverUser observerUser=observerUserRepo.getObserverUserByobscode(obscode) ;
		if(observerUser==null)
		{
			throw new UsernameNotFoundException("could not find user");
		}
		return new MyUserDetails(observerUser);
	}

}

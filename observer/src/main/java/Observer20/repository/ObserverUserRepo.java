package Observer20.repository;

import java.util.Optional;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Observer20.Model.ObserverUser;





@EnableJpaRepositories
@Repository
public interface ObserverUserRepo extends JpaRepository<ObserverUser, Integer>{
	Optional<ObserverUser> findOneByObscodeAndPassword(String obscode,String password);
	//ObserverUser getUserByUsername(String obscode);
	
	//Optional<ObserverUser> findByObscode(String obscode);
	ObserverUser findByObscode(String obscode);
	
	@Query("Select u from ObserverUser u where u.email=:email")
	 ObserverUser getObserverUserByEmail(@Param("email") String email);
	
	@Query("Select u from ObserverUser u where u.obsecoee=:obsecode")
	 ObserverUser getObserverUserByobscode(@Param("obscode") String obscode);
}

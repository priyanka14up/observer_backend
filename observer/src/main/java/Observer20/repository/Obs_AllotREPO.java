package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.Obs_Allot;


public interface Obs_AllotREPO extends JpaRepository<Obs_Allot,Long> {

	//List<Obs_Allot> findAllByObsAllot_Obscode(String obsCode);
	 List<Obs_Allot> findAllByObscode(String obsCode);
	 
	

}

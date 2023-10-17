package Observer20.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import Observer20.Model.Obs_Allot;
import Observer20.payloads.ObsAllotDTO;


public interface Obs_AllotREPO extends JpaRepository<Obs_Allot, Long> {
   
	List<Obs_Allot> findAllByObscode(String obsCode);

	List<Obs_Allot> findAllDepByObscode(String obsCode);
	

}

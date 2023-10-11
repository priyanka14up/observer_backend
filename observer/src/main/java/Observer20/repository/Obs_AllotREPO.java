package Observer20.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.Obs_Allot;


public interface Obs_AllotREPO extends JpaRepository<Obs_Allot,Long> {

	//List<Obs_Allot> findAllByObsAllot_Obscode(String obsCode);
	 List<Obs_Allot> findAllByObscode(String obsCode);
		/*
		 * // Add a method to fetch the currentelection column by obsCode String
		 * findCurrentElectionByObscode(String obsCode);
		 */
	 
		/*
		 * @Query("SELECT oa.currentElection FROM Obs_Allot oa WHERE oa.obscode = :obsCode"
		 * ) List<String> findCurrentElectionByObscode(String obsCode);
		 */
	 //Obs_Allot findByObscode(String obsCode);
}

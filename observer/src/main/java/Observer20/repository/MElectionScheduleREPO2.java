package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Observer20.Model.MElectionSchedule2;

public interface MElectionScheduleREPO2 extends JpaRepository<MElectionSchedule2, Long> {
	/*
	 * @Query("SELECT s.datePoll FROM MElectionSchedule2 s JOIN Obs_Allot o ON s.scheduleID = o.scheduleID WHERE o.obscode = :obsCode"
	 * ) String findDatePollByObsCode(String obsCode);
	 */
	/*
	 * 
	 * @Query("SELECT s.datePoll FROM MElectionSchedule2 s JOIN Obs_Allot o ON s.scheduleID = o.scheduleID WHERE o.obscode = :obsCode"
	 * ) List<String> findDatePollByObsCode(String obsCode);
	 */
	 
	
	
	  @Query("SELECT s.datePoll, s.currentElection FROM MElectionSchedule2 s JOIN Obs_Allot o ON s.scheduleID = o.scheduleID WHERE o.obscode = :obsCode"
	  ) List<Object[]> findDatePollAndCurrentElectionByObsCode(String obsCode);
	 
}


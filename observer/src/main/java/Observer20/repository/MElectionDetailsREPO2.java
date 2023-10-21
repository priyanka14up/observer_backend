package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Observer20.Model.M_ELECTION_DETAILS2;

public interface MElectionDetailsREPO2 extends JpaRepository<M_ELECTION_DETAILS2, Long> {
	/*
	 * @Query("SELECT e.constType, e.electionType, e.statePhaseNo, e.phaseNo FROM M_ELECTION_DETAILS2 e JOIN Obs_Allot o ON e.scheduleID = o.scheduleID WHERE o.obscode = :obsCode"
	 * ) Object[] findDetailsByObsCode(String obsCode);
	 */
	@Query("SELECT e.constType, e.electionType, e.statePhaseNo, e.phaseNo FROM M_ELECTION_DETAILS2 e JOIN Obs_Allot o ON e.scheduleID = o.scheduleID WHERE o.obscode = :obsCode")
    List<Object[]> findDetailsByObsCode(String obsCode);

	M_ELECTION_DETAILS2 findByScheduleID(Long scheduleId);
}


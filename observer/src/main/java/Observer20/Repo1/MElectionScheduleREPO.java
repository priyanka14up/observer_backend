package Observer20.Repo1;

import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model1.M_ELECTION_DETAILS;
import Observer20.Model1.M_ELECTION_SCHEDULE;

public interface MElectionScheduleREPO extends JpaRepository<M_ELECTION_SCHEDULE,Long> {

}

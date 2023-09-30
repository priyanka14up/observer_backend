package Observer20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Observer20.Model.STATE_LIST2;
@Repository
public interface STATE_LIST2_Repo extends JpaRepository<STATE_LIST2, Long> {
	STATE_LIST2 findByStCode(String stCode);
}

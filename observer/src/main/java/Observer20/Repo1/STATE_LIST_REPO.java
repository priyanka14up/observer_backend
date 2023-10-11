package Observer20.Repo1;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Observer20.Model1.STATE_LIST;
@Repository
public interface STATE_LIST_REPO  extends JpaRepository<STATE_LIST,Long>
	{
	
}

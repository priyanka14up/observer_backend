
  package Observer20.repository;
  
  import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Observer20.Model.ObserverLocalInfo;
  
  public interface ObserverLocalInfoRepository extends JpaRepository<ObserverLocalInfo, Long> {
	   
	  ObserverLocalInfo findByObserverUser_Obscode(String obscode);
	    
	    List<ObserverLocalInfo> findAllByObserverUser_Obscode(String obscode);
	    
	    Optional<ObserverLocalInfo> findOneByObserverUser_Obscode(String obscode);

		//Optional<ObserverLocalInfo> findOneByObs_code(String obsCode);
	    
	
	}
	
	  
  
 
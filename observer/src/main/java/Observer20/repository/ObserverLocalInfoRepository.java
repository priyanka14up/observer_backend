
  package Observer20.repository;
  
  import java.util.Optional;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import Observer20.Model.ObserverLocalInfo;
  
  public interface ObserverLocalInfoRepository extends JpaRepository<ObserverLocalInfo, Long> {
	   
	  ObserverLocalInfo findByObserverUser_Obscode(String obscode);
	  Optional<ObserverLocalInfo> findByObserverUserObscode(String obscode);

	
	  }
  
 
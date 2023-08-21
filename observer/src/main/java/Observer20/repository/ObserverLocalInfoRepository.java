
  package Observer20.repository;
  
  import java.util.Optional;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import Observer20.Model.ObserverLocalInfo;
  
  public interface ObserverLocalInfoRepository extends JpaRepository<ObserverLocalInfo, Long> {
	  //Optional<ObserverLocalInfo> findByObscode(String obscode); 
	  Optional<ObserverLocalInfo> findByObserverUser_Obscode(String obscode);
	  }
  
 
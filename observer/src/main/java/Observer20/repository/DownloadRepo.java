
package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Observer20.Model.DownloadPdf;
import Observer20.Model.Form;
import Observer20.Model.FormDates;
import Observer20.Model.Question;

@Repository
public interface DownloadRepo extends JpaRepository<DownloadPdf, Long>{
	
	//public List<DownloadPdf> findAllByOrderById();
	public List<DownloadPdf> findAllByOrderByOrdering();
	
	
}

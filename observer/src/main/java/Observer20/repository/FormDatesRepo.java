
package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Observer20.Model.Form;
import Observer20.Model.FormDates;
import Observer20.Model.Question;

@Repository
public interface FormDatesRepo extends JpaRepository<FormDates, Long>{
	
	
	FormDates findByFidAndObsType(Long fid,String obsType);
	FormDates findByFid(Long fid);
	
}

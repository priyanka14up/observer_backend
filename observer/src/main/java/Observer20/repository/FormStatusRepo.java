package Observer20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.FormStatus;


public interface FormStatusRepo extends JpaRepository<FormStatus, Long>{
	FormStatus findByFid(Long fid);
	List<FormStatus> findAllBySubmittedBy(String submittedBy);
	
	FormStatus findByFidAndSubmittedBy(Long fid,String submittedBy);
}

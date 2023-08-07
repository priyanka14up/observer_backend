package Observer20.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.FormStatus;
import Observer20.Model.FormSubformResponse;

public interface FormStatusRepo extends JpaRepository<FormStatus, Long>{
	FormStatus findByFid(Long fid);
}

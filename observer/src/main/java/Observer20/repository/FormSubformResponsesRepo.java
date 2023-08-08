package Observer20.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Observer20.Model.FormSubformResponse;

@Repository
public interface FormSubformResponsesRepo extends JpaRepository<FormSubformResponse, Long> {
    // Add custom queries or methods if required
	FormSubformResponse findByStatus(boolean status);
	FormSubformResponse findByFid(Long fid);
} 
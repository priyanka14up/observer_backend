package Observer20.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Observer20.Model.PC_LIST2;


public interface PC_LIST_REPO2 extends JpaRepository<PC_LIST2, Long> {
	PC_LIST2 findByStCode(String stCode);
}

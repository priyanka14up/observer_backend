package Observer20.Repo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Observer20.Model1.PC_LIST;

@Repository
public interface PC_LIST_REPO extends JpaRepository<PC_LIST,Long>{

}

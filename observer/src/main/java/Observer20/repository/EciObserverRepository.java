package Observer20.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Observer20.Model.EciObserverEntity;

@Repository
public interface EciObserverRepository extends JpaRepository<EciObserverEntity, Long> {

	@Query(value = "Select * from public.eci_question_master where form_id = :formId and sid = :sId", nativeQuery = true)
	Optional<List<EciObserverEntity>> getListOfEciObserver(@Param("formId") Integer formId, @Param("sId") Integer sId);

	@Query(value = "Select * from public.eci_question_master where form_id = :formId and sid is null ", nativeQuery = true)
    Optional<List<EciObserverEntity>> getListOfEciObserverByFormId(@Param("formId") Integer formId);

	// Optional<EciObserverEntity> findById(Long serNo);
}
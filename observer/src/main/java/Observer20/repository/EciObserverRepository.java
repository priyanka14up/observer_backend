package Observer20.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Observer20.Model.EciObserverArrivalEntity;
import Observer20.Model.EciObserverEntity;

@Repository
public interface EciObserverRepository extends JpaRepository<EciObserverEntity, Long> {

	@Query(value = "Select * from public.eci_question_master where form_id = :formId and sid = :sId", nativeQuery = true)
	Optional<List<EciObserverEntity>> getListOfEciObserver(@Param("formId") Integer formId, @Param("sId") Integer sId);

	@Query(value = "Select * from public.eci_question_master where form_id = :formId and sid is null ", nativeQuery = true)
    Optional<List<EciObserverEntity>> getListOfEciObserverByFormId(@Param("formId") Integer formId);

	// Optional<EciObserverEntity> findById(Long serNo);
	
	/*
	 * @Query(value =
	 * "SELECT * FROM public.eci_observer_arrival where form_id = :fromId",
	 * nativeQuery = true) Optional<List<EciObserverArrivalEntity>>
	 * getByFromId(@Param("fromId") Integer fromId);
	 */

	
	
	/*
	 * @Query(value =
	 * "SELECT constituency_id,form_id,observer_id,user_id,answer,ques_id,remark FROM public.eci_observer_arrival where form_id = :fromId\r\n"
	 * + "", nativeQuery = true) Optional<List<EciObserverArrivalEntity>>
	 * getByFromId(@Param("fromId") Integer fromId);
	 */
	 
	
	
	 
}
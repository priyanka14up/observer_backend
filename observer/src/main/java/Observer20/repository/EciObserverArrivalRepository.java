package Observer20.repository;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Observer20.Model.EciObserverArrivalEntity;
import Observer20.Model.EciObserverArrivalPKId;


@Repository
public interface EciObserverArrivalRepository extends JpaRepository<EciObserverArrivalEntity, EciObserverArrivalPKId> {

	@Query(value = "SELECT constituency_id,form_id,observer_id,user_id,answer,ques_id,remark FROM public.eci_observer_arrival where form_id = :fromId\r\n"
			+ "", nativeQuery = true)
	List<Object[]> getByFromId(@Param("fromId") Integer fromId);

}
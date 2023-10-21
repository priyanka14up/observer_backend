
package Observer20.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Observer20.Model.Form;
import Observer20.Model.FormDates;
import Observer20.Model.Messages;
import Observer20.Model.Question;

@Repository
public interface MessagesRepo extends JpaRepository<Messages, Long>{
	
	
	Messages findByObsCodeAndMsgTextAndDate(String obsCode,String msgText,java.util.Date date);
	
}
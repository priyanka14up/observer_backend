  package Observer20.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String obscode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObscode() {
		return obscode;
	}
	public void setObscode(String obscode) {
		this.obscode = obscode;
	}
	
	
	
}

package Observer20.Services;

import java.util.Optional;

import Observer20.Model1.STATE_LIST;

public interface STATE_LIST_Service{
	Optional<STATE_LIST> getSTATELISTById(Long Id);
void migrateData();

}

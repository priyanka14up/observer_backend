package Observer20.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Services.T_OBS_Service;

@RestController
public class MigCronSchdulerController {


	    @Autowired
	    private T_OBS_Service t_OBS_Service;

	    // Store the timestamp of the last migration
	    private LocalDateTime lastMigrationTimestamp = LocalDateTime.MIN;

	    @Scheduled(cron = "0 */ * * * *") // Run every 15 minutes
	    public void scheduledDataMigration() {
	        try {
	            LocalDateTime latestUpdateTimestamp = getLastUpdateTimestamp(); // Get the latest timestamp from the source table

	            if (latestUpdateTimestamp.isAfter(lastMigrationTimestamp)) {
	                // There are updates since the last migration
	               // t_OBS_Service.migrateData_T_OBS(lastMigrationTimestamp, latestUpdateTimestamp);
	                lastMigrationTimestamp = latestUpdateTimestamp; // Update the last migration timestamp
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle the exception if needed
	        }
	    }

	    private LocalDateTime getLastUpdateTimestamp() {
	        // Implement this method to retrieve the latest timestamp (mod_date) from the source table
	        // You can use a database query to get the maximum value of the mod_date column
	        // Return the latest timestamp as a LocalDateTime
	        return LocalDateTime.now(); // For demonstration purposes, return the current timestamp
	    }
	}



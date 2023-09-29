package Observer20.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Services.AC_LIST_Service;
import Observer20.Services.DIST_LIST_Service;
import Observer20.Services.MElectionDetailsService;
import Observer20.Services.MElectionScheduleService;
import Observer20.Services.PC_LIST_Service;
import Observer20.Services.STATE_LIST_Service;
import Observer20.Services.T_Allot_Group_Servcie;
import Observer20.Services.T_OBS_Service;


	@RestController
	@RequestMapping("/fetchSQL")
	public class MigrationController {

		
		 //@Autowired private MigrationService migrationService;
		  
		  @Autowired STATE_LIST_Service sTATE_LIST_Service;
		  @Autowired AC_LIST_Service aC_LIST_Service;
		  @Autowired  DIST_LIST_Service  dIST_LIST_Service;
		  @Autowired Observer20.Services.PC_AC_DIST_Service pC_AC_DIST_Service;
		  @Autowired T_Allot_Group_Servcie t_Allot_Group_Servcie;
		  @Autowired PC_LIST_Service pC_LIST_Service;
		  @Autowired T_OBS_Service t_OBS_Service;
		  @Autowired MElectionDetailsService mElectionDetailsService;
		  @Autowired MElectionScheduleService mElectionScheduleService;
		  
		  @GetMapping("/migrate/state_list")
		    public ResponseEntity<String> migrateData() {
		        try {
		        	sTATE_LIST_Service.migrateData(); // Call your data migration method here
		            return ResponseEntity.ok("Data migration completed successfully.");
		        } catch (Exception e) {
		            e.printStackTrace();
		            return ResponseEntity.badRequest().body("Data migration failed.");
		        }
		    }
		  
		  

		  
		  @GetMapping("/migrate/ac_list")
		    public ResponseEntity<String> migrateDataAC_List() {
		        try {
		        	aC_LIST_Service.migrateDataAC_List(); // Call your data migration method here
		            return ResponseEntity.ok("Data migration completed successfully.");
		        } catch (Exception e) {
		            e.printStackTrace();
		            return ResponseEntity.badRequest().body("Data migration failed.");
		        }
		    }
		  @GetMapping("/migrate/dist_list")
		    public ResponseEntity<String> migrateDataDIST_List() {
		        try {
		        	dIST_LIST_Service.migrateDataDIST_List(); // Call your data migration method here
		            return ResponseEntity.ok("Data migration completed successfully.");
		        } catch (Exception e) {
		            e.printStackTrace();
		            return ResponseEntity.badRequest().body("Data migration failed.");
		        }
		    }
		  @GetMapping("/migrate/pc_ac_dist")
		    public ResponseEntity<String> migrateDataPC_AC_DIST() {
		        try {
		        	pC_AC_DIST_Service.migrateDataPC_AC_DIST_(); // Call your data migration method here
		            return ResponseEntity.ok("Data migration completed successfully.");
		        } catch (Exception e) {
		            e.printStackTrace();
		            return ResponseEntity.badRequest().body("Data migration failed.");
		        }}
		        @GetMapping("/migrate/T_Allot_Group")
			    public ResponseEntity<String> migrateT_Allot_Group() {
			        try {
			        	t_Allot_Group_Servcie.migrateT_allot_group_Service(); // Call your data migration method here
			            return ResponseEntity.ok("Data migration completed successfully.");
			        } catch (Exception e) {
			            e.printStackTrace();
			            return ResponseEntity.badRequest().body("Data migration failed.");
			        }
			        
		  }
		        @GetMapping("/migrate/pc_list")
			    public ResponseEntity<String> migrateT_PC_LIST() {
			        try {
			        	pC_LIST_Service.migrateData_PC_LIST(); // Call your data migration method here
			            return ResponseEntity.ok("Data migration completed successfully.");
			        } catch (Exception e) {
			            e.printStackTrace();
			            return ResponseEntity.badRequest().body("Data migration failed.");
			        }
			        
		  }
		        
			
			  @GetMapping("/migrate/t_obs") 
			  public ResponseEntity<String> migrateT_T_OBS()
			  { 
				  try { t_OBS_Service.migrateData_T_OBS(); 
			  // Call your data migration method here
			  return ResponseEntity.ok("Data migration completed successfully."); }
			  catch (Exception e) { e.printStackTrace(); 
			  return ResponseEntity.badRequest().body("Data migration failed."); }
			  
			  }
			  @GetMapping("/migrate/melection") 
			  public ResponseEntity<String> migrateTMElctionDetails()
			  { 
				  try { mElectionDetailsService.migrateDataMElectionDetails(); 
			  // Call your data migration method here
			  return ResponseEntity.ok("Data migration completed successfully."); }
			  catch (Exception e) { e.printStackTrace(); 
			  return ResponseEntity.badRequest().body("Data migration failed."); }
			  
			  }
			  @GetMapping("/migrate/mElectionSchedule") 
			  public ResponseEntity<String> migrateTMElctionSchedule()
			  { 
				  try { mElectionScheduleService.migrateDataMElectionSchedule(); 
			  // Call your data migration method here
			  return ResponseEntity.ok("Data migration completed successfully."); }
			  catch (Exception e) { e.printStackTrace(); 
			  return ResponseEntity.badRequest().body("Data migration failed."); }
			  
			  }
	}
			 
			/*
			 * @GetMapping("/migrate/t_obs") public ResponseEntity<String> migrateT_T_OBS()
			 * { try { LocalDateTime lastMigrationTimestamp = getLastMigrationTimestamp();
			 * // Get the timestamp of the last migration LocalDateTime
			 * latestUpdateTimestamp = getLatestUpdateTimestamp(); // Get the latest
			 * timestamp from the source table
			 * 
			 * if (latestUpdateTimestamp.isAfter(lastMigrationTimestamp)) { // There are
			 * updates since the last migration
			 * t_OBS_Service.migrateData_T_OBS(lastMigrationTimestamp,
			 * latestUpdateTimestamp); updateLastMigrationTimestamp(latestUpdateTimestamp);
			 * // Update the last migration timestamp }
			 * 
			 * return ResponseEntity.ok("Data migration completed successfully."); } catch
			 * (Exception e) { e.printStackTrace(); return
			 * ResponseEntity.badRequest().body("Data migration failed."); } } private
			 * LocalDateTime getLastMigrationTimestamp() { // Implement this method to
			 * retrieve the timestamp of the last migration // You can store it in a
			 * configuration file or a database table // Return the timestamp as a
			 * LocalDateTime // If it's the first migration, return LocalDateTime.MIN or a
			 * default timestamp return LocalDateTime.MIN; // For demonstration purposes,
			 * return LocalDateTime.MIN }
			 * 
			 * private LocalDateTime getLatestUpdateTimestamp() { // Implement this method
			 * to retrieve the latest timestamp (mod_date) from the source table // You can
			 * use a database query to get the maximum value of the mod_date column //
			 * Return the latest timestamp as a LocalDateTime return LocalDateTime.now(); //
			 * For demonstration purposes, return the current timestamp }
			 * 
			 * private void updateLastMigrationTimestamp(LocalDateTime timestamp) { //
			 * Implement this method to update the timestamp of the last migration // Store
			 * the current timestamp in a configuration file or a database table } }
			 */
		  
		  


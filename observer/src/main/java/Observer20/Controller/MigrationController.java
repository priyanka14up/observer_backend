package Observer20.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Services.AC_LIST_Service;
import Observer20.Services.DIST_LIST_Service;
import Observer20.Services.STATE_LIST_Service;
import Observer20.Services.T_Allot_Group_Servcie;


	@RestController
	@RequestMapping("/fetchSQL")
	public class MigrationController {

		
		 //@Autowired private MigrationService migrationService;
		  
		  @Autowired STATE_LIST_Service sTATE_LIST_Service;
		  @Autowired AC_LIST_Service aC_LIST_Service;
		  @Autowired  DIST_LIST_Service  dIST_LIST_Service;
		  @Autowired Observer20.Services.PC_AC_DIST_Service pC_AC_DIST_Service;
		  @Autowired T_Allot_Group_Servcie t_Allot_Group_Servcie;
		  
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
	}
		  
		  
		  


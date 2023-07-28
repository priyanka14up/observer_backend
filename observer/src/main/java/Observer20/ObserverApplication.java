package Observer20;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
//@ComponentScan(basePackages = "Observer20.Observer20.Model.MapToJsonConverter")
public class ObserverApplication   {
	/*implements CommandLineRunner */
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ObserverApplication.class, args);
		
		
	}
}

package Observer20.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Exception.LocalAddressValidationException;
import Observer20.Exception.MobileNumberValidationException;
import Observer20.Model.ObserverLocalInfo;
import Observer20.Model.ObserverLocalInfoRequest;
import Observer20.Model.ObserverUser;
import Observer20.Services.ObserverLocalInfoService;
import Observer20.Services.ObserverService;
import Observer20.payloads.ObserverUserDto;

@RestController
@RequestMapping("/api/observers")
public class ObserverLocalInfoController {



	private final ObserverService observerService;

    public ObserverLocalInfoController(ObserverService observerService) {
        this.observerService = observerService;
    }

    @PostMapping("/add-local-info")
    public ResponseEntity<String> addLocalInfo(@RequestBody ObserverLocalInfoRequest localInfoRequest) {
        try {
    	String obsCode = localInfoRequest.getObscode();
        String localAddress = localInfoRequest.getLocalAddress();
        String localMobileNumber = localInfoRequest.getLocalMobile();

        ObserverUserDto observerUserDto = observerService.addLocalInfo(obsCode, localAddress, localMobileNumber);

        return ResponseEntity.ok("Local information added successfully for obscode: " + obsCode);
    }
    catch (MobileNumberValidationException | LocalAddressValidationException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    }
}



package Observer20.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Services.GupshupService;
import Observer20.payloads.SmsRequest;

@RestController
@RequestMapping("/api/observers")
public class SMSControllerNew {

    private final GupshupService gupshupService;

    @Autowired
    public SMSControllerNew(GupshupService gupshupService) {
        this.gupshupService = gupshupService;
    }

    @PostMapping("/send-sms")
    public void sendSMS(@RequestBody SmsRequest smsRequest) {
        gupshupService.sendSMS(smsRequest.getPhoneNumber(), smsRequest.getMessage());
    }
}


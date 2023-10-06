package Observer20.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GupshupService {

    @Value("${gupshup.api.url}")
    private String apiUrl;

    @Value("${gupshup.api.id}")
    private String apiId;

    @Value("${gupshup.api.pass}")
    private String apiPass;

    public void sendSMS(String phoneNumber, String message) {
        String fullUrl = apiUrl +
                "?method=sendMessage" +
                "&send_to=" + phoneNumber +
                "&msg=" + message +
                "&msg_type=TEXT" +
                "&userid=" + apiId +
                "&auth_scheme=plain" +
                "&password=" + apiPass +
                "&format=text";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(fullUrl, String.class);
        System.out.println("Gupshup API Response: " + response);
    }
}


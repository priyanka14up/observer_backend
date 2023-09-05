package Observer20.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	System.out.println("Web Socket Configure");
       
        config.enableSimpleBroker("/topic");
        // Set the prefix for destinations that the application can receive messages from clients
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	
    	System.out.println("stop end point with configure");
       
        registry.addEndpoint("/gs-guide-websocket") .withSockJS();
                //.setAllowedOrigins("*") // Add allowed origins as needed
               
    }
}






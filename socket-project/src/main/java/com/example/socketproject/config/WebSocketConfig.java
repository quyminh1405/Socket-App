package com.example.socketproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

/*Websocket configuration, enable message broker.
 * message-broker: middle-man, receives messages and broadcast to addresses (clients),
 * it shows an endpoint for client to connect to websocket server (in this case /ws)*/

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").withSockJS();		// /ws is the endpoint that client will use to connect to websocket server
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");	//message whose destination starts with "/app" will be routed to message-handling methods
		registry.enableSimpleBroker("/topic");	//whoever subscribed to a particular topic will get broadcasted messages
	}
}

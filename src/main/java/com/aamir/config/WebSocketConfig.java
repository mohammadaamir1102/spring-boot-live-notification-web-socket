package com.aamir.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * This class is responsible for configuring WebSocket in a Spring Boot application
 * using STOMP protocol. It enables a message broker that will handle routing messages
 * from one client to another.
 */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    /**
     * This method is used to register the WebSocket endpoint that the clients will use
     * to connect to our WebSocket server.
     */

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /**
         * This adds an endpoint at the URL "/ws" where clients can connect.
         * SockJS is enabled as a fallback option for browsers that don’t support WebSocket.
         * Example: http://localhost:8080/ws
         */

        registry.addEndpoint("/ws").withSockJS();
    }


    /**
     * This method is used to configure the message broker.
     * A message broker helps in routing messages between the sender and receivers.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        /**
         * All messages that are sent from the client with a destination starting with "/app"
         * will be routed to message-handling methods in your @Controller classes.
         * For example, "/app/chat" will be mapped to a @MessageMapping("/chat").
         */
        registry.setApplicationDestinationPrefixes("/app");
        /**
         * This enables a simple in-memory message broker that will be used to broadcast messages
         * to all connected clients. The destination prefix "/topic" is used for broadcasting messages.
         * For example, if a message is sent to "/topic/greetings", all clients subscribed to that
         * topic will receive the message.
         */
        registry.enableSimpleBroker("/topic");
    }
}
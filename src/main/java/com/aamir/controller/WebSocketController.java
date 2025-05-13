package com.aamir.controller;

import com.aamir.helper.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    /**
     * This method handles incoming messages sent to the "/chat" endpoint.
     * It uses the @MessageMapping annotation to map the method to the specified endpoint.
     * The @SendTo annotation indicates that the return value of this method should be sent to all subscribers of the "/topic/messages" topic.
     *
     * @param message The incoming message object.
     * @return The same message object, which will be sent to all subscribers of the "/topic/messages" topic.
     */
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) {
        return message;
    }
}

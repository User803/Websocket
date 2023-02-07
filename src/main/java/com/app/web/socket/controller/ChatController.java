package com.app.web.socket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import com.app.web.socket.model.ChatMessage;

@Controller
public class ChatController {

	@MessageMapping("/chat.user")
	@SendTo("/topic/user")		
	public ChatMessage chat(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());

		return chatMessage;		
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/user")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

}

package org.zerock.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.zerock.club.dto.Message;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // FrontEnd에서 가져온 메세지를 전달
    @MessageMapping("/app/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/app/private-message")
    public Message recMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        System.out.println(message.toString());
        return message;
    }
}

package me.siyoon.simplechat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class ChatController {
    @MessageMapping("/enter-user")
    @SendTo("/topic/greeting")
    public EnteringUserResponse addUser(@Payload EnteringUserRequest request) {
        log.info("User Add Request {}", request.getName());

        //todo 세션에 등록하기

        return EnteringUserResponse.builder()
                .name(request.getName())
                .build();
    }
}

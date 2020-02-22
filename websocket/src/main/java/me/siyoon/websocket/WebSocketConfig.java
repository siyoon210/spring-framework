package me.siyoon.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket").withSockJS(); //최초 소켓 연결시에 사용하는 엔드포인트 (SockJS를 사용하겠다는 뜻)
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app"); //클라이언트가 서버로 메시지를 보낼때 사용하는 주소 prefix
        registry.enableSimpleBroker("/topic"); //서버가 클라이언트로 메시지를 보낼때 사용하는 주소 prefix
    }
}

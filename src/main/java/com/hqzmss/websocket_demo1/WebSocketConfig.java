package com.hqzmss.websocket_demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements  WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(webSocketHandler(), "/webSocketServer.action").addInterceptors(new MyWebSocketInterceptor()).setAllowedOrigins("*");
        webSocketHandlerRegistry.addHandler(webSocketHandler(), "/sockjs/webSocketServer.action")
                .addInterceptors(new MyWebSocketInterceptor()).withSockJS();
    }

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new MyHandler();
    }
}

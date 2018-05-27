package com.hqzmss.websocket_demo1;

import org.springframework.web.socket.*;

/**
 * 创建处理器
 */
public class MyHandler implements WebSocketHandler  {
    /**
     * 在WebSocket协商成功后调用，并且打开WebSocket连接准备使用
     * @param webSocketSession webSocketSession
     * @throws Exception 异常
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.out.println("sessionId=" + webSocketSession.getId());
    }

    /**
     * 当一个新的WebSocket消息到达时调用
     * @param webSocketSession webSocketSession
     * @param webSocketMessage webSocketMessage
     * @throws Exception 异常
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        System.out.println(webSocketMessage.getPayload());
        System.out.println("有消息到达服务器！");
    }

    /**
     * 处理来自底层WebSocket消息传输的错误
     * @param webSocketSession webSocketSession
     * @param throwable 错误
     * @throws Exception 异常
     */
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    /**
     * 在网络套接字连接关闭后或在传输错误发生后调用。
     * 尽管从技术上讲，会话可能仍然是开放的，但取决于底层实现，在这一点上发送消息是不鼓励的，而且很可能不会成功。
     * @param webSocketSession webSocketSession
     * @param closeStatus closeStatus
     * @throws Exception 异常
     */
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        if(webSocketSession.isOpen()) {
            webSocketSession.close();
        }
        System.out.println("安全退出了系统");
    }

    /**
     * WebSocketHandler是否处理部分消息
     * @return 标志
     */
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}

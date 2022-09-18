package com.sysbot32.robotmc.core.server.socket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;

public interface WebSocketHandler {
    @OnWebSocketConnect
    void onConnect(final Session session);

    @OnWebSocketClose
    void onClose(final Session session, final int statusCode, final String reason);

    @OnWebSocketMessage
    void onMessage(final Session session, final String message);
}

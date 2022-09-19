package com.sysbot32.robotmc.core.server.socket;

import com.sysbot32.robotmc.core.driver.MinecraftServer;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class WebSocketHandlerImpl implements WebSocketHandler {
    public static final String PATH = "/socket";

    private final MinecraftServer minecraftServer;

    public WebSocketHandlerImpl() {
        this.minecraftServer = MinecraftServer.getInstance();
    }

    @Override
    @OnWebSocketConnect
    public void onConnect(final Session session) {

    }

    @Override
    @OnWebSocketClose
    public void onClose(final Session session, final int statusCode, final String reason) {

    }

    @Override
    @OnWebSocketMessage
    public void onMessage(final Session session, final String message) {
        minecraftServer.write(message);
    }
}

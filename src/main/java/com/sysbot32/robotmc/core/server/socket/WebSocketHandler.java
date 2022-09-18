package com.sysbot32.robotmc.core.server.socket;

import org.eclipse.jetty.websocket.api.Session;

public interface WebSocketHandler {
    void onConnect(final Session session);

    void onClose(final Session session, final int statusCode, final String reason);

    void onMessage(final Session session, final String message);
}

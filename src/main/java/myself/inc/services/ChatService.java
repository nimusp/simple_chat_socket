package myself.inc.services;

import myself.inc.socketServlets.ChatWebSocket;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatService {

    private Set<ChatWebSocket> webSockets;

    public ChatService() {
        this.webSockets = Collections.newSetFromMap(new ConcurrentHashMap<>());
    }

    public void add(ChatWebSocket chatWebSocket) {
        webSockets.add(chatWebSocket);
    }

    public void sendMessage(String data) {
        webSockets.forEach(socket -> socket.sendString(data));
    }

    public void remove(ChatWebSocket chatWebSocket) {
        webSockets.remove(chatWebSocket);
    }
}

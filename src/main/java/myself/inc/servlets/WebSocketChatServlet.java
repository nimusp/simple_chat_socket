package myself.inc.servlets;

import myself.inc.services.ChatService;
import myself.inc.socketServlets.ChatWebSocket;
import org.eclipse.jetty.websocket.servlet.*;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "WebSocketChatServlet", urlPatterns = "/chat")
public class WebSocketChatServlet extends WebSocketServlet {

    private final ChatService chatService;

    public WebSocketChatServlet() {
        this.chatService = new ChatService();
    }

    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.getPolicy().setIdleTimeout(2 * 60 * 1000);
        webSocketServletFactory.setCreator((request, response) -> new ChatWebSocket(chatService));
    }
}

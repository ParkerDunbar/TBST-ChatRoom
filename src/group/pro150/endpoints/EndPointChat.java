package group.pro150.endpoints;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/endpoint")
public class EndPointChat {
	private static List<EndPointChat> users = new CopyOnWriteArrayList<>();
	private static List<String> messages = new CopyOnWriteArrayList<>();
	Session sesssion;

	@OnOpen
	public void onOpen(Session session) {
		this.sesssion = session;
		users.add(this);
	}

	@OnClose
	public void onClose(Session session) {
		users.remove(this);
		if (users.size() == 0) {
			messages.removeAll(messages);
		}
	}

	@OnMessage
	public void onMessage(String message) {
		messages.add(message);
		broadcast(messages);
	}

	private void broadcast(List<String> message) {
		for (EndPointChat user : users) {
			try {
				String msg = "";
				for (int i = 0; i < message.size(); i++) {
					msg += message.get(i);
					msg += "\n";
				}
				user.sesssion.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				users.remove(this);
				try {
					user.sesssion.close();
				} catch (IOException e1) {
					e.printStackTrace();
				}
			}
		}
	}

}

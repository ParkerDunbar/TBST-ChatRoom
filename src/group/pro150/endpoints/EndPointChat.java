package group.pro150.endpoints;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import group.pro150.Datastore.DatabaseConnection;
import group.pro150.model.client.messages.Chat_Message;
import group.pro150.model.client.messages.Friends_Request_Message;
import group.pro150.model.client.messages.Join_Message;
import group.pro150.model.client.messages.Message_List_Request_Message;
import group.pro150.model.messages.Message;
import group.pro150.model.server.messages.Chat_Message_List;
import group.pro150.model.server.messages.Friends_List_Message;
import group.pro150.model.server.messages.Message_List_Message;
import group.pro150.model.server.messages.Online_Users_Message;


@ServerEndpoint(value = "/endpoint/{RoomName}", encoders = Encoder.class, decoders = Decoder.class)
public class EndPointChat {
	private static Map<String, List<EndPointChat>> users = new HashMap<>();
	private static Map<String, List<String>> messages = new HashMap<>();
	private static Map<String, List<String>> userList = new HashMap<>();
	Session sesssion;

	@OnOpen
	public void onOpen(Session session, @PathParam("RoomName") String roomName) {
		this.sesssion = session;
		this.sesssion.setMaxIdleTimeout(120000);
		List<EndPointChat> clients = null;
		if (users.get(roomName) == null) {
			clients = new CopyOnWriteArrayList<>();
			clients.add(this);
			users.put(roomName, clients);
		} else {
			clients = users.get(roomName);
			clients.add(this);
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason r, @PathParam("RoomName") String roomName) {
		System.out.println(r);
		List<EndPointChat> clients = users.get(roomName);
		clients.remove(this);
	}

	@OnMessage
	public void onMessage(Message message, @PathParam("RoomName") String RoomName) {
		if (message instanceof Chat_Message) {
			handleMessage((Chat_Message) message, RoomName);
		} else if (message instanceof Join_Message) {
			handleMessage((Join_Message) message, RoomName);
		} else if (message instanceof Message_List_Request_Message) {
			handleMessage((Message_List_Request_Message) message, RoomName);
		} else if (message instanceof Friends_Request_Message) {
			handleMessage((Friends_Request_Message) message, RoomName);
		} else {
			System.out.println("Bad Message");
		}
	}

	private void handleMessage(Friends_Request_Message message, String roomName) {
		Friends_List_Message frinedList = new Friends_List_Message(getFriendsList(message.getUserName()));
		textUser(frinedList, roomName);
	}

	private String getFriendsList(String userName) {
		String friends = DatabaseConnection.SelectFriendsList("UserCredentials", "UserName", userName, "FriendList");
		if (friends == null || friends.isEmpty()) {
			return friends;
		} else {
			friends = friends.substring(15);
			friends = friends.substring(0, friends.length() - 1);
			return friends;
		}
	}

	private void handleMessage(Message_List_Request_Message message, String roomName) {
		List<String> msg = messages.get(roomName);
		broadcast(new Message_List_Message(msg), roomName);
	}

	private void handleMessage(Join_Message message, String roomName) {
		if (userList.get(roomName) == null) {
			List<String> msg = new CopyOnWriteArrayList<String>();
			msg.add(message.getName());
			userList.put(roomName, msg);
			broadcast(new Online_Users_Message(msg), roomName);
		} else {
			List<String> msg = userList.get(roomName);
			if (msg.contains(message.getName())) {
				broadcast(new Online_Users_Message(msg), roomName);
			} else {
				msg.add(message.getName());
				broadcast(new Online_Users_Message(msg), roomName);
			}
		}
	}

	private void handleMessage(Chat_Message message, String roomName) {
		if (messages.get(roomName) == null) {
			List<String> msg = new CopyOnWriteArrayList<>();
			msg.add(message.toString());
			messages.put(roomName, msg);
			broadcast(new Chat_Message_List(msg), roomName);
		} else {
			List<String> msg = messages.get(roomName);
			msg.add(message.toString());
			broadcast(new Chat_Message_List(msg), roomName);
		}
	}

	private void broadcast(Message message, String roomName) {
		List<EndPointChat> clients = users.get(roomName);
		for (EndPointChat user : clients) {
			try {
				user.sesssion.getBasicRemote().sendObject(message);
			} catch (IOException | EncodeException e) {
				clients.remove(this);
				try {
					user.sesssion.close();
				} catch (IOException e1) {
					e.printStackTrace();
				}
			}
		}
	}

	private void textUser(Message frinedList, String roomName) {
		try {
			this.sesssion.getBasicRemote().sendObject(frinedList);
		} catch (IOException | EncodeException e) {
			try {
				this.sesssion.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
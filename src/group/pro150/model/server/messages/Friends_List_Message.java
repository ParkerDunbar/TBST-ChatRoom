package group.pro150.model.server.messages;

import java.util.List;

import group.pro150.model.messages.Message;

public class Friends_List_Message extends Message {

	private String friendsList;

	public Friends_List_Message(String friendsList2) {
		this.setFriendsList(friendsList2);
		this.setTage(7);
	}

	public String getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(String friendsList) {
		this.friendsList = friendsList;
	}

}

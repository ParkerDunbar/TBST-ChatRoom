package group.pro150.model.server.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import group.pro150.model.messages.Message;

public class Online_Users_Message extends Message {
	@JsonProperty
	private List<String> users;

	public Online_Users_Message(List<String> users) {
		this.users = users;
		this.setTage(5);
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

}

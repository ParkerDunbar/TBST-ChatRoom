package group.pro150.model.server.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import group.pro150.model.messages.Message;


public class Chat_Message_List extends Message {
	@JsonProperty
	private List<String> message;

	public Chat_Message_List(List<String> message) {
		this.setMessage(message);
		this.setTage(8);
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}
}

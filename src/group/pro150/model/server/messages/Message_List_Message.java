package group.pro150.model.server.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import group.pro150.model.messages.Message;

public class Message_List_Message extends Message{
	@JsonProperty
	private List<String> message;

	public Message_List_Message(List<String> message) {
		this.setMessage(message);
		this.setTage(6);
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

}
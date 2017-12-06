package group.pro150.model.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

import group.pro150.model.messages.Message;

public class Chat_Message extends Message {

	@JsonProperty("message")
	private String message;
	@JsonProperty("userName")
	private String userName;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return this.getUserName() + ": " + this.getMessage();
	}

}

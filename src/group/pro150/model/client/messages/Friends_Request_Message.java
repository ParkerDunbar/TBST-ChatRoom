package group.pro150.model.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

import group.pro150.model.messages.Message;

public class Friends_Request_Message extends Message {
	@JsonProperty("userName")
	private String UserName;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}
}

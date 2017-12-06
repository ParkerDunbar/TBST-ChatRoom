package group.pro150.model.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

import group.pro150.model.messages.Message;


public class Join_Message extends Message {
	@JsonProperty("userName")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

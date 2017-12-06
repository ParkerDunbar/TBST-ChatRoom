package group.pro150.model.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

	@JsonProperty("tage")
	private int tage;

	public int getTage() {
		return tage;
	}

	public void setTage(int tage) {
		this.tage = tage;
	}

}

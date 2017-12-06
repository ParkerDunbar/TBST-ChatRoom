package group.pro150.endpoints;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import group.pro150.model.messages.Message;

public class Encoder implements javax.websocket.Encoder.Text<Message> {

	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig arg0) {
	}

	@Override
	public String encode(Message message) throws EncodeException {
		Gson gson = new Gson();
		String msg = gson.toJson(message);
		return msg;
	}

}


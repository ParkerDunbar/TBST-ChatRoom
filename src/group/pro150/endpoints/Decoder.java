package group.pro150.endpoints;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.websocket.DecodeException;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import group.pro150.model.client.messages.Chat_Message;
import group.pro150.model.client.messages.Friends_Request_Message;
import group.pro150.model.client.messages.Join_Message;
import group.pro150.model.client.messages.Message_List_Request_Message;
import group.pro150.model.messages.Message;

public class Decoder implements javax.websocket.Decoder.Text<Message> {

	@Override
	public void destroy() {

	}

	@Override
	public void init(EndpointConfig arg0) {
	}

	@Override
	public Message decode(String msg) throws DecodeException {
		List<String> key = new ArrayList<String>();
		List<JsonElement> value = new ArrayList<JsonElement>();
		Message message = null;
		ObjectMapper mapper = new ObjectMapper();
		JsonElement ele = new JsonParser().parse(msg);
		for (Map.Entry<String, JsonElement> entr : ele.getAsJsonObject().entrySet()) {
			key.add(entr.getKey());
			value.add(entr.getValue());
		}
		if (value.get(0).getAsInt() == 1) {
			try {
				message = mapper.readValue(msg, Join_Message.class);
			} catch (IOException e) {
				System.out.println("Info:1");
				e.printStackTrace();
			}
		} else if (value.get(0).getAsInt() == 2) {
			try {
				message = mapper.readValue(msg, Message_List_Request_Message.class);
			} catch (IOException e) {
				System.out.println("Info:2");
				e.printStackTrace();
			}
		} else if (value.get(0).getAsInt() == 3) {
			try {
				message = mapper.readValue(msg, Friends_Request_Message.class);
			} catch (IOException e) {
				System.out.println("Info:3");
				e.printStackTrace();
			}
		} else if (value.get(0).getAsInt() == 4) {
			try {
				message = mapper.readValue(msg, Chat_Message.class);
			} catch (IOException e) {
				System.out.println("Info:4");
				e.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public boolean willDecode(String message) {
		try {
			Json.createReader((new StringReader(message)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

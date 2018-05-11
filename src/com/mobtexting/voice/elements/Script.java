package com.mobtexting.voice.elements;

import java.util.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mobtexting.voice.CallFlow;
import com.mobtexting.voice.VoiceElement;

public class Script implements VoiceElement {
	private String method = "get";
	private String url = "";
	private int reqTimeout = 60;
	private CallFlow timeOut;
	private CallFlow error;
	private List<Map<String, CallFlow>> responses=new ArrayList<>();

	public void setMethod(String method) {
		this.method = method;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setReqTimeout(int reqTimeout) {
		this.reqTimeout = reqTimeout;
	}

	public void setTimeOut(CallFlow timeOut) {
		this.timeOut = timeOut;
	}

	public void setError(CallFlow error) {
		this.error = error;
	}

	public void AddResponse(String response,CallFlow responseFlow) {
		Map<String, CallFlow> responsesElement = new HashMap<>();
		responsesElement.put(String.valueOf(response), responseFlow);
		responses.add(responsesElement);
	}

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = new JsonObject();
		JsonObject jsonAnswer = new JsonObject();
		jsonAnswer.addProperty("method", method);
		jsonAnswer.addProperty("url", url.toString());
		jsonAnswer.addProperty("reqtime", reqTimeout);
		
		if(error==null) {
			jsonAnswer.add("error", new JsonArray());
		}else {
			jsonAnswer.add("error", error.toJson());
		}
		
		if(timeOut==null) {
			jsonAnswer.add("timeout", new JsonArray());
		}else {
			jsonAnswer.add("timeout", timeOut.toJson());
		}
		JsonObject jsonResponse = new JsonObject();

		for (int i = 0; i < responses.size(); i++) {
			Map<String, CallFlow> temp = responses.get(i);
			for (Map.Entry<String, CallFlow> map : temp.entrySet()) {
				jsonResponse.add(map.getKey().toString(), map.getValue().toJson());
			}
		}

		jsonAnswer.add("response", jsonResponse);
		jsonObject.add("Url", jsonAnswer);
		

		return jsonObject;
	}

}

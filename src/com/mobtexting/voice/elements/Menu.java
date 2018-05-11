package com.mobtexting.voice.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mobtexting.voice.CallFlow;
import com.mobtexting.voice.VoiceElement;

public class Menu implements VoiceElement {
	private String type = "";
	private String prompt = "";
	private int maxRepeat = 0;
	private int waitTime = 10;
	private int dtmfTimeout = 3;
	private int maxDigits = 1;
	private CallFlow timeOut;
	private CallFlow wrongKey;
	private CallFlow onFail;
	private List<Map<String, CallFlow>> responses=new ArrayList<>();

	public void setType(String type) {
		this.type = type;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public void setMaxRepeat(int maxRepeat) {
		this.maxRepeat = maxRepeat;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public void setDtmfTimeout(int dtmfTimeout) {
		this.dtmfTimeout = dtmfTimeout;
	}

	public void setMaxDigits(int maxDigits) {
		this.maxDigits = maxDigits;
	}

	public void setTimeOut(CallFlow timeOut) {
		this.timeOut = timeOut;
	}

	public void setWrongKey(CallFlow wrongKey) {
		this.wrongKey = wrongKey;
	}

	public void setOnFail(CallFlow onFail) {
		this.onFail = onFail;
	}

	/**
	 * add dynamic user response
	 * 
	 * @param dtmfKey
	 * @param voiceElement
	 */
	public void addResponse(int dtmfKey, CallFlow voiceElement) {
		Map<String, CallFlow> responsesElement = new HashMap<>();
		responsesElement.put(String.valueOf(dtmfKey), voiceElement);
		responses.add(responsesElement);
	}

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = new JsonObject();
		JsonObject jsonAnswer = new JsonObject();
		jsonAnswer.addProperty("type", type);
		jsonAnswer.addProperty("prompt", prompt);
		jsonAnswer.addProperty("maxrepeat", maxRepeat);
		jsonAnswer.addProperty("waittime", waitTime);
		jsonAnswer.addProperty("dtmftimeout", dtmfTimeout);
		jsonAnswer.addProperty("maxdigits", maxDigits);
		if (timeOut == null) {
			jsonAnswer.add("timeout", new JsonArray());
		} else {
			jsonAnswer.add("timeout", timeOut.toJson());
		}
		if (wrongKey == null) {
			jsonAnswer.add("wrongkey", new JsonArray());
		} else {
			jsonAnswer.add("wrongkey", wrongKey.toJson());
		}
		if (onFail == null) {
			jsonAnswer.add("onfail", new JsonArray());
		} else {
			jsonAnswer.add("onfail", onFail.toJson());
		}

		for (int i = 0; i < responses.size(); i++) {
			Map<String, CallFlow> temp = responses.get(i);
			for (Map.Entry<String, CallFlow> map : temp.entrySet()) {
				jsonAnswer.addProperty(map.getKey().toString(), map.getValue().toString());
			}
		}

		jsonObject.add("Menu", jsonAnswer);

		return jsonObject;
	}

}

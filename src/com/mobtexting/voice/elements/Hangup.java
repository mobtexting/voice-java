package com.mobtexting.voice.elements;

import com.google.gson.JsonObject;
import com.mobtexting.voice.VoiceElement;

public class Hangup implements VoiceElement{
	private int reason=16;

	public void setReason(int reason) {
		this.reason = reason;
	}

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject=new JsonObject();
		JsonObject jsonAnswer=new JsonObject();
		jsonAnswer.addProperty("reason", reason);
		jsonObject.add("Hangup", jsonAnswer);
		return jsonObject;
	}

}

package com.mobtexting.voice.elements;

import com.google.gson.JsonObject;
import com.mobtexting.voice.VoiceElement;

public class Delay implements VoiceElement{
	private int seconds=0;

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject=new JsonObject();
		JsonObject jsonAnswer=new JsonObject();
		jsonAnswer.addProperty("seconds", seconds);
		jsonObject.add("Delay", jsonAnswer);
		return jsonObject;
	}
	
}

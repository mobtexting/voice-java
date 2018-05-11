package com.mobtexting.voice.elements;

import com.google.gson.JsonObject;
import com.mobtexting.voice.VoiceElement;

public class Answer implements VoiceElement{
	private int delay;

	public void setDelay(int delay) {
		this.delay = delay;
	}

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject=new JsonObject();
		JsonObject jsonAnswer=new JsonObject();
		jsonAnswer.addProperty("delay", delay);
		jsonObject.add("Answer", jsonAnswer);
		return jsonObject;
	}

		
	
}

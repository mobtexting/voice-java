package com.mobtexting.voice.elements;

import com.google.gson.JsonObject;
import com.mobtexting.voice.VoiceElement;

public class Repeat implements VoiceElement{
	private boolean isReset=false;

	public void setReset(boolean isReset) {
		this.isReset = isReset;
	}

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject=new JsonObject();
		JsonObject jsonAnswer=new JsonObject();
		jsonAnswer.addProperty("reset", isReset);
		jsonObject.add("Repeat", jsonAnswer);
		return jsonObject;
	}
	
}

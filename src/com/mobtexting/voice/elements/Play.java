package com.mobtexting.voice.elements;

import com.google.gson.JsonObject;
import com.mobtexting.voice.VoiceElement;

public class Play implements VoiceElement{
	private String path="";
	private String type="gsm";
	private int duration=0;
	public void setPath(String path) {
		this.path = path;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	@Override
	public JsonObject toJson() {
		JsonObject jsonObject=new JsonObject();
		JsonObject jsonAnswer=new JsonObject();
		jsonAnswer.addProperty("path", path);
		jsonAnswer.addProperty("type", type);
		jsonAnswer.addProperty("duration", duration);
		jsonObject.add("Play", jsonAnswer);
		return jsonObject;
	}
	

	
}

package com.mobtexting.voice;

import java.util.*;

import com.google.gson.JsonArray;

public class CallFlow {
	List<VoiceElement> voiceElementList = new ArrayList<>();

	public void addCallElement(VoiceElement voiceElement) {
		voiceElementList.add(voiceElement);
	}

	public void addCallElement(int index,VoiceElement voiceElement) {
		voiceElementList.add(index,voiceElement);
	}
	
	public JsonArray toJson() {
		JsonArray jsonArray=new JsonArray();
		for(int i=0;i<voiceElementList.size();i++) {
			jsonArray.add(voiceElementList.get(i).toJson());
		}
		return jsonArray;
	}
	
	@Override
	public String toString() {
		return toJson().toString();
	}
}

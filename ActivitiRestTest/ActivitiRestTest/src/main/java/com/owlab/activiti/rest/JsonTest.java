package com.owlab.activiti.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.owlab.util.JsonNodeUtil;

public class JsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		
		ObjectNode node = mapper.createObjectNode();
		
		node.put("id", "1000");
		
		System.out.println(node.path("id").asInt());
		
		ArrayNode array = mapper.createArrayNode();
		for(int i = 0; i < 10; i++){
			ObjectNode on = mapper.createObjectNode();
			on.put("key" + i, "value" + i);
			array.add(on);
		}
		
		for(JsonNode on: array) {
			JsonNodeUtil.beautifulPrint(on);
		}
	}

}

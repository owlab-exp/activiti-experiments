package com.owlab.activiti.rest;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.owlab.util.JsonNodeUtil;
import com.owlab.util.WeakRestClient;

public class Messages {

	public static void main(String[] args) throws ClientProtocolException, URISyntaxException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode result = mapper.createObjectNode();
		

		ObjectNode messageNode = mapper.createObjectNode();
		messageNode.put("saveProcessInstanceId", true);
		messageNode.put("message", "한글 메시지");
		
		WeakRestClient.RestResponse response = WeakRestClient.post("http://alpha:28081/activiti-rest/service/runtime/tasks/27589/comments")
				.header("content-type", "application/json; charset=utf-8")
				.basicAuth("kermit", "kermit")
				.bodyAsJsonNode(messageNode)
				.execute();
		
		if(response.statusCode == 200) {
			JsonNode aNode = response.asJsonNode();
			JsonNodeUtil.beautifulPrint(aNode);
		} else {
			System.out.println(response.responseBody);
		}
		
		
		
//		response = WeakRestClient.get("http://alpha:28081/activiti-rest/service/history/historic-process-instances/27568/comments")
//				.basicAuth("kermit", "kermit")
//				//.queryString("nameLike", "여신")
//				//.queryString("nameLike","여신%")
////				.queryString("nameLike","%임%")
////				.queryString("size", "1000")
//				.execute();
//		
//		if(response.statusCode == 200) {
//			JsonNode aNode = response.asJsonNode();
//			JsonNodeUtil.beautifulPrint(aNode);
//		} else {
//			System.out.println(response.responseBody);
//		}
		
	}

}

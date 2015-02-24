package com.owlab.activiti.rest;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.databind.JsonNode;
import com.owlab.util.JsonNodeUtil;
import com.owlab.util.WeakRestClient;

public class ProcessDefnitions {

	public static void main(String[] args) throws ClientProtocolException, URISyntaxException, IOException {
		// TODO Auto-generated method stub
		WeakRestClient.RestResponse response = WeakRestClient.get("http://alpha:28081/activiti-rest/service/repository/process-definitions")
				.basicAuth("kermit", "kermit")
				//.queryString("nameLike", "여신")
				//.queryString("nameLike","여신%")
				.queryString("nameLike","%임%")
				.queryString("size", "1000")
				.execute();
		
		if(response.statusCode == 200) {
			JsonNode aNode = response.asJsonNode();
			JsonNodeUtil.beautifulPrint(aNode);
		} else {
			System.out.println(response.responseBody);
		}
		
	}

}

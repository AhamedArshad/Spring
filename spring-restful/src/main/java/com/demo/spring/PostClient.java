package com.demo.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		RestTemplate rt = new RestTemplate();
		String empJsonData ="{\n" +
				"	\"empId\": 406, \n" +
				"	\"name\": \"Sehwag\", \n"+
				"	\"city\": \"Mumbai\", \n"+
				"	\"salary\": 93000\n"+
				"}";
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		
		
		HttpEntity entity = new HttpEntity<>(empJsonData,headers);
		
		ResponseEntity resp = rt.exchange("http://localhost:8087/app/save", HttpMethod.POST,
				entity, String.class);
		
		System.out.println(resp.getBody());

	}

}

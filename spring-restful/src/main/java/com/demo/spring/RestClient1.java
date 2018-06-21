package com.demo.spring;



import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userDetails ="scott:welcome1";
		String encrypted = new String(Base64.encodeBase64(userDetails.getBytes()));		
		System.out.println("Credentials : " + encrypted);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", "Basic "+ encrypted);
		
		HttpEntity httpEntity = new HttpEntity<>(headers);
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity response = 
				rt.exchange("http://localhost:8080/spring-rest-service/emp?id=1000", HttpMethod.GET,
				httpEntity, String.class);
		
		
		
		System.out.println(response.getBody());
	}

}

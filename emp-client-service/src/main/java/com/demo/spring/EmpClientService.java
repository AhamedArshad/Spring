package com.demo.spring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path="/emp")
public class EmpClientService {
	
/*	@Autowired
	RestTemplate rt;*/
	
	@Autowired
	ClientService clientService;
	
	@RequestMapping(path="/get/{id}")
	public ResponseEntity fetch(@PathVariable("id")int empId){
		
	ResponseEntity<String> resp = clientService.getEmployee(empId);
		
	/*ResponseEntity<String> resp=
		rt.getForEntity("http://springboot-app/app/emp?id=" +empId,
			String.class);
		*/
		
		/*HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_XML_VALUE);
		
		HttpEntity entity = new HttpEntity<>(headers);
		
		ResponseEntity resp = rt.exchange("http://localhost:8087/app/emp?id="+empId, HttpMethod.GET,
				entity, String.class);*/
		
		
		return resp;
	}
	
	
	/*
	 * Load Balancer
	 * 1. Spring Eureka
	 * 2. Load Balancer: Spring Ribbon
	 * 3. CircuitBreaker  : Hystrix
	 * 4. API Gateway : Zuul
	 */

}

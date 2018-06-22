package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ClientService {
	
	@Autowired	
	RestTemplate rt;
	
	@HystrixCommand(fallbackMethod="handleFailure")
    public ResponseEntity getEmployee(int empId){
    	return rt.getForEntity("http://springboot-app/app/emp?id=" +empId, String.class);
    }
	
	
	public ResponseEntity handleFailure(int empId){
		return ResponseEntity.ok("Service now unavailable");
	}
}

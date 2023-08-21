package com.demo.soap.ws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumeSoapWebService {
	
	@Autowired
	ConsumeSoapService consumeSoapService;
	
	public String getData(int a, int b) {
		
		return consumeSoapService.getResponseFromService(a, b);
	} 
}

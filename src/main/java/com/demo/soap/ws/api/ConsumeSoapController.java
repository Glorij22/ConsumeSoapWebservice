package com.demo.soap.ws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws")
public class ConsumeSoapController {
	
	@Autowired
	ConsumeSoapWebService consumeSoapWebService;
	
	@GetMapping(value = "/consumeSoap")
	public String getValue(@RequestParam(value = "firstValue", defaultValue = "") int firstValue,
			@RequestParam(value = "secondValue", defaultValue = "") int secondValue) {
		
		System.out.println("First Value - " + firstValue + " : Second Value - " + secondValue);
		return consumeSoapWebService.getData(firstValue, secondValue);
	}

}

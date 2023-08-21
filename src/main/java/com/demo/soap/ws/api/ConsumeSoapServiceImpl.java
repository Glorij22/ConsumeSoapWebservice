package com.demo.soap.ws.api;

import org.demo.soap.ws.api.client.Calculator;
import org.demo.soap.ws.api.client.CalculatorSoap;
import org.springframework.stereotype.Service;


@Service
public class ConsumeSoapServiceImpl implements ConsumeSoapService {

	@Override
	public String getResponseFromService(int a, int b) {
		// TODO Auto-generated method stub
		int response = 0;
		
		Calculator calc = new Calculator();
		// get the object of the port for SOAP message exchange
		CalculatorSoap port = calc.getCalculatorSoap();
		try {
			response = port.add(a, b);
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "The sum is " + response;
		
	}

}

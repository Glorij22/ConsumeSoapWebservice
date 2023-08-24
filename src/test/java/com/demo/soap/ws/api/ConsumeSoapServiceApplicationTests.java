package com.demo.soap.ws.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)
class ConsumeSoapServiceApplicationTests {
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Mock
    private ConsumeSoapService consumeSoapService;

	@Test
	void controllerTest() throws Exception {
		
		ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/ws/consumeSoap?firstValue=4&secondValue=4").toString(), String.class);
	        assertEquals("The sum is 8", response.getBody());
	}
	
	@Test
	void consumeSoapWebServiceTest() throws Exception {
		when(consumeSoapService.getResponseFromService(4, 4)).thenReturn("The sum is 8");
        String actual = consumeSoapService.getResponseFromService(4, 4);
        assertEquals(actual, "The sum is 8");
	}
	
	@Test
	void consumeSoapWebServiceImplTest() throws Exception {
		when(consumeSoapService.getResponseFromService(4, 4)).thenReturn("The sum is 8");
        String actual = consumeSoapService.getResponseFromService(4, 4);
        assertEquals(actual, "The sum is 8");
		
	}
}

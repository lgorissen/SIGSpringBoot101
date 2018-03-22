package com.dronebuzzers.rest.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.dronebuzzers.rest.part.Part;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PartIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testGet() {
		ResponseEntity<Part> responseEntity =
	            restTemplate.getForEntity("/dronebuzzers/part/DB-FK-A250-V4", Part.class);
	        Part resultPart = responseEntity.getBody();
	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals("DB-FK-A250-V4", resultPart.getId());
	        assertEquals("Frame", resultPart.getType());
	        assertEquals("Drone", resultPart.getCategory());
	        assertEquals("DroneBuzzer Frame Kit regular V4 (2016 edition)", resultPart.getName());
	}
}

package com.dronebuzzers.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.dronebuzzers.rest.part.Part;
import com.dronebuzzers.rest.part.PartsDAO;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PartsDAO partsDAO;
	
	@Test
	public void testUpdate() throws Exception {
		Part part = new Part("DB-FK-A250-V4", "Drone", "Beta", "TestPart", 100, "Euro");
		Part part2 = new Part("DB-38406-2350KV", "Bike", "Gamma", "TestPart2", 150, "Euro");
		when(partsDAO.getPart("DB-FK-A250-V4")).thenReturn(part);
		when(partsDAO.getPart("DB-38406-2350KV")).thenReturn(part2);
		when(partsDAO.getAmount(Mockito.any(String.class), Mockito.any(Integer.class))).thenReturn(5.0);
		
		String payload = "{\"clientId\": \"TDF\", \"clientReference\": \"TDF-0067\", \"orderLines\": [{\"id\": \"DB-FK-A250-V4\", \"count\": 22 }, {\"id\": \"DB-38406-2350KV\", \"count\": 4 }] }";
		
		this.mockMvc.perform(post("/dronebuzzers/order").contentType(MediaType.APPLICATION_JSON).content(payload)).andDo(print())
			.andExpect(status().isOk());
	}
}

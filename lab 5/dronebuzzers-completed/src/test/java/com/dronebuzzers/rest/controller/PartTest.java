package com.dronebuzzers.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

import com.dronebuzzers.rest.part.Part;
import com.dronebuzzers.rest.part.PartsDAO;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(PartController.class)
public class PartTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PartsDAO partsDAO;
	
	@Test
	public void testGet() throws Exception {
		Part part = new Part("DB-FK-A250-V5", "Drone", "Beta", "TestPart", 100, "Euro");
		when(partsDAO.getPart("DB-FK-A250-V5")).thenReturn(part);
		
		this.mockMvc.perform(get("/dronebuzzers/part/DB-FK-A250-V5").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is("DB-FK-A250-V5")))
			.andExpect(jsonPath("$.category", is("Drone")));
		
		this.mockMvc.perform(get("/dronebuzzers/part/unknown").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
	}
	
	@Test
	public void testGetAll() throws Exception {
		List<Part> partList = new ArrayList<>();
		partList.add(new Part("Part_1", "Drone", "Beta", "TestPart", 100, "Euro"));
		partList.add(new Part("Part_2", "Drone", "Gamma", "TestPart2", 150, "Euro"));
		when(partsDAO.getAllParts()).thenReturn(partList);
		this.mockMvc.perform(get("/dronebuzzers/part").contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.parts[0].id", is("Part_1")))
			.andExpect(jsonPath("$.parts[1].id", is("Part_2")));
	}
	
	@Test
	public void testGetPartsByCategory() throws Exception {
		List<Part> partList = new ArrayList<>();
		partList.add(new Part("Part_1", "Drone", "Beta", "TestPart", 100, "Euro"));
		partList.add(new Part("Part_2", "Drone", "Gamma", "TestPart2", 150, "Euro"));
		when(partsDAO.getPartsByCategory("test")).thenReturn(partList);
		this.mockMvc.perform(get("/dronebuzzers/part/category/test").contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.parts[0].id", is("Part_1")))
			.andExpect(jsonPath("$.parts[1].id", is("Part_2")));
	}
	
	@Test
	public void testGetPartsByType() throws Exception {
		List<Part> partList = new ArrayList<>();
		partList.add(new Part("Part_1", "Drone", "Beta", "TestPart", 100, "Euro"));
		partList.add(new Part("Part_2", "Drone", "Gamma", "TestPart2", 150, "Euro"));
		when(partsDAO.getPartsByType("test")).thenReturn(partList);
		this.mockMvc.perform(get("/dronebuzzers/part/type/test").contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.parts[0].id", is("Part_1")))
			.andExpect(jsonPath("$.parts[1].id", is("Part_2")));
	}
}

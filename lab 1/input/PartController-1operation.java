package com.dronebuzzers.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dronebuzzers.rest.part.MockedPartsDAO;
import com.dronebuzzers.rest.part.Part;
import com.dronebuzzers.rest.part.PartsDAO;

@CrossOrigin
@RestController
@RequestMapping("/dronebuzzers/part")
public class PartsController {

	PartsDAO partsDAO = new MockedPartsDAO();

	// Get a part by Id
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<Part> get(@PathVariable String id) {

		Part match = null;
		match = partsDAO.getPart(id);

		if (match != null) {
			return new ResponseEntity<>(match, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
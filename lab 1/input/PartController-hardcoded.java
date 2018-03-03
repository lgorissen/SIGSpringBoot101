package com.dronebuzzers.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dronebuzzers.rest.part.Part;

@CrossOrigin
@RestController
@RequestMapping("/dronebuzzers/part")
public class PartController {


	// Get a part by Id
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<Part> get(@PathVariable String id) {

		Part resultPart = new Part("partId", "partCategory", "partType", "partName", 0.0, "EUR");

		return new ResponseEntity<>(resultPart, HttpStatus.OK);
	}

}

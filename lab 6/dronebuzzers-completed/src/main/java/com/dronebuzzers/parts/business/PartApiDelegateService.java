package com.dronebuzzers.parts.business;

import com.dronebuzzers.parts.service.api.PartApiDelegate;
import com.dronebuzzers.parts.service.model.Part;
import com.dronebuzzers.parts.service.model.Parts;
import com.dronebuzzers.parts.repositories.part.repository.PartRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-17T17:35:48.103Z")

@Controller
public class PartApiDelegateService implements PartApiDelegate {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	PartRepository partRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public PartApiDelegateService(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return Optional.ofNullable(objectMapper);
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public ResponseEntity<Part> getPart(@ApiParam(value = "part id", required = true) @PathVariable("id") String id) {
		log.info("DroneBuzzers: getPart with id : " + id);

		com.dronebuzzers.parts.repositories.part.Part match = partRepository.findByPartId(id);
		com.dronebuzzers.parts.service.model.Part result = Converter.convertInternalPart2ModelPart(match);

		return new ResponseEntity<com.dronebuzzers.parts.service.model.Part>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Parts> getParts() {

		log.info("DroneBuzzers: getParts()");

		com.dronebuzzers.parts.service.model.Parts result = Converter
				.convertInternalParts2ModelParts(partRepository.findAll());
		return new ResponseEntity<Parts>(result, HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Parts> getPartsByCategory(
			@ApiParam(value = "category id", required = true) @PathVariable("category") String category) {

		log.info("DroneBuzzers: getParts() by category : " + category);

		com.dronebuzzers.parts.service.model.Parts result = Converter
				.convertInternalParts2ModelParts(partRepository.findByCategory(category));
		return new ResponseEntity<Parts>(result, HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Parts> getPartsByType(
			@ApiParam(value = "type id", required = true) @PathVariable("type") String type) {

		log.info("DroneBuzzers: getParts() by type : " + type);

		com.dronebuzzers.parts.service.model.Parts result = Converter
				.convertInternalParts2ModelParts(partRepository.findByType(type));
		return new ResponseEntity<Parts>(result, HttpStatus.ACCEPTED);
	}

}

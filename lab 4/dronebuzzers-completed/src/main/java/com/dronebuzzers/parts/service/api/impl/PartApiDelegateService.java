package com.dronebuzzers.parts.service.api.impl;

import com.dronebuzzers.parts.service.api.PartApiDelegate;
import com.dronebuzzers.parts.service.model.Parts;
import com.dronebuzzers.parts.service.model.Part;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * A delegate to be called by the {@link PartApiController}}. Implement this
 * interface with a {@link org.springframework.stereotype.Service} annotated
 * class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-02T11:12:28.462Z")

@Service
public class PartApiDelegateService implements PartApiDelegate {

	private static final Logger log = LoggerFactory.getLogger(PartApiDelegateService.class);

	PartsDAO partsDAO = new MockedPartsDAO();

	@org.springframework.beans.factory.annotation.Autowired
	public PartApiDelegateService() {

	}

	@Override
	public ResponseEntity<com.dronebuzzers.parts.service.model.Part> getPart(String id) {

		log.info("DroneBuzzers: getPart with id : " + id);

		com.dronebuzzers.parts.service.api.impl.Part match = partsDAO.getPart(id);

		com.dronebuzzers.parts.service.model.Part result = convertInternalPart2ModelPart(match);

		if (result != null) {
			return new ResponseEntity<com.dronebuzzers.parts.service.model.Part>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Parts> getParts() {

		log.info("DroneBuzzers: getParts()");

		com.dronebuzzers.parts.service.model.Parts result = convertInternalParts2ModelParts(partsDAO.getAllParts());
		return new ResponseEntity<Parts>(result, HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Parts> getPartsByCategory(String category) {

		log.info("DroneBuzzers: getParts() by category");

		com.dronebuzzers.parts.service.model.Parts result = convertInternalParts2ModelParts(
				partsDAO.getPartsByCategory(category));
		return new ResponseEntity<Parts>(result, HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Parts> getPartsByType(String type) {

		log.info("DroneBuzzers: getParts() by type");

		com.dronebuzzers.parts.service.model.Parts result = convertInternalParts2ModelParts(
				partsDAO.getPartsByType(type));
		return new ResponseEntity<Parts>(result, HttpStatus.ACCEPTED);
	}

	static com.dronebuzzers.parts.service.model.Part convertInternalPart2ModelPart(
			com.dronebuzzers.parts.service.api.impl.Part in) {

		com.dronebuzzers.parts.service.model.Part result = new com.dronebuzzers.parts.service.model.Part();
		result.setCategory(in.getCategory());
		result.setCurrency(in.getCurrency());
		result.setId(in.getId());
		result.setName(in.getName());
		result.setType(in.getType());
		result.setUnitPrice(in.getUnitPrice());

		return result;
	}

	private com.dronebuzzers.parts.service.model.Parts convertInternalParts2ModelParts(
			List<com.dronebuzzers.parts.service.api.impl.Part> inParts) {

		com.dronebuzzers.parts.service.model.Parts result = new com.dronebuzzers.parts.service.model.Parts();

		java.util.List<com.dronebuzzers.parts.service.api.impl.Part> listParts = inParts;

		for (int i = 0; i < listParts.size(); i++) {

			com.dronebuzzers.parts.service.api.impl.Part inPart = listParts.get(i);
			com.dronebuzzers.parts.service.model.Part toConvert = new com.dronebuzzers.parts.service.model.Part();

			toConvert.setCategory(inPart.getCategory());
			toConvert.setCurrency(inPart.getCurrency());
			toConvert.setId(inPart.getId());
			toConvert.setName(inPart.getName());
			toConvert.setType(inPart.getType());
			toConvert.setUnitPrice(inPart.getUnitPrice());
			result.addPartsItem(toConvert);

		}

		return result;
	}

}

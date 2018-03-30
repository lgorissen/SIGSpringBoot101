package com.dronebuzzers.soap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.dronebuzzers.parts.repository.PartRepository;
import com.dronebuzzers.parts.soap.GetPartRequest;
import com.dronebuzzers.parts.soap.GetPartResponse;
import com.dronebuzzers.parts.soap.GetPartsByTypeRequest;
import com.dronebuzzers.parts.soap.GetPartsByTypeResponse;
import com.dronebuzzers.parts.soap.GetPartsRequest;
import com.dronebuzzers.parts.soap.GetPartsResponse;

@Endpoint
public class PartEndpoint {

	private static final String NAMESPACE_URI = "http://dronebuzzers.com/parts/soap";

	private PartRepository partRepository;

	@Autowired
	public PartEndpoint(PartRepository partRepository) {
		this.partRepository = partRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPartRequest")
	@ResponsePayload
	public GetPartResponse getPart(@RequestPayload GetPartRequest request) {
		GetPartResponse response = new GetPartResponse();
		response.setPart(partRepository.findPart(request.getId()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPartsRequest")
	@ResponsePayload
	public GetPartsResponse getParts(@RequestPayload GetPartsRequest request) {
		GetPartsResponse response = new GetPartsResponse();
		response.setPartList(partRepository.getParts());

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPartsByTypeRequest")
	@ResponsePayload
	public GetPartsByTypeResponse getPartByType(@RequestPayload GetPartsByTypeRequest request) {
		GetPartsByTypeResponse response = new GetPartsByTypeResponse();
		response.setPartList(partRepository.findPartsByType(request.getType()));

		return response;
	}

	
}

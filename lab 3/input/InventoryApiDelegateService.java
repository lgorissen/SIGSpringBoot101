
package com.dronebuzzers.helloworld.service.api.impl;

import com.dronebuzzers.helloworld.service.api.InventoryApiDelegate;

import com.dronebuzzers.helloworld.service.model.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**
 * A delegate to be called by the {@link CaseactivityApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-02T11:12:28.462Z")

@Service 
public class InventoryApiDelegateService implements InventoryApiDelegate {

    private static final Logger log = LoggerFactory.getLogger(InventoryApiDelegateService.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;


    @org.springframework.beans.factory.annotation.Autowired
    public InventoryApiDelegateService(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


	@Override
	public ResponseEntity<Void> addInventory(InventoryItem inventoryItem) {

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}


	@Override
	public ResponseEntity<List<InventoryItem>> searchInventory(String searchString, Integer skip, Integer limit) {
		
		List<InventoryItem> inventoryItemList = new ArrayList<InventoryItem>();
		
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setHomePage("https://www.amis.nl");
		manufacturer.setName("AMIS");
		manufacturer.setPhone("+31 (0)30 601 6000");

		InventoryItem inventoryItem1 = new InventoryItem();
		inventoryItem1.setId(UUID.randomUUID());
		inventoryItem1.setManufacturer(manufacturer);
		inventoryItem1.setName("SIG Spring Boot 101");
		inventoryItem1.setReleaseDate("5-apr-2018");
		
		inventoryItemList.add(inventoryItem1);

		return new ResponseEntity<List<InventoryItem>>(inventoryItemList, HttpStatus.ACCEPTED);
	}

}

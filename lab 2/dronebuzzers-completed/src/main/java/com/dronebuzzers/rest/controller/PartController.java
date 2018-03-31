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
import com.dronebuzzers.rest.part.Parts;
import com.dronebuzzers.rest.part.PartsDAO;

@CrossOrigin
@RestController
@RequestMapping("/dronebuzzers/part")
public class PartController {

	PartsDAO partsDAO = new MockedPartsDAO();

    // Get all parts
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Parts> getAll() {

        Part[] partsArray = partsDAO.getAllParts().toArray(new Part[0]);

        Parts parts = new Parts();

        parts.setParts(partsArray);
        
        return new ResponseEntity<>(parts, HttpStatus.OK);
    }

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

    // Get parts by category
    @RequestMapping(method = RequestMethod.GET, value = "/category/{category}")
    public ResponseEntity<Parts> getPartsByCategory(@PathVariable String category) {

        Part[] partsArray = partsDAO.getPartsByCategory(category).toArray(new Part[0]);

        Parts parts = new Parts();
        parts.setParts(partsArray);
        
        return new ResponseEntity<>(parts, HttpStatus.OK);

    }

    // Get parts by type
    @RequestMapping(method = RequestMethod.GET, value = "/type/{type}")
    public ResponseEntity<Parts> getPartsByType(@PathVariable String type) {

        Part[] partsArray = partsDAO.getPartsByType(type).toArray(new Part[0]);

        Parts parts = new Parts();
        parts.setParts(partsArray);
        
        return new ResponseEntity<>(parts, HttpStatus.OK);

    }


}
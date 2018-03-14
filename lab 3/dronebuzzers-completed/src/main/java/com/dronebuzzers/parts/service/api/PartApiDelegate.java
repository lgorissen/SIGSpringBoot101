package com.dronebuzzers.parts.service.api;

import com.dronebuzzers.parts.service.model.Part;
import com.dronebuzzers.parts.service.model.Parts;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link PartApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-14T21:15:28.475Z")

public interface PartApiDelegate {

    Logger log = LoggerFactory.getLogger(PartApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    /**
     * @see PartApi#getPart
     */
    default ResponseEntity<Part> getPart(String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"unitPrice\" : 6.027456183070403,  \"name\" : \"name\",  \"currency\" : \"currency\",  \"id\" : \"id\",  \"category\" : \"category\",  \"type\" : \"type\"}", Part.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default PartApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see PartApi#getParts
     */
    default ResponseEntity<Parts> getParts() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"parts\" : [ {    \"unitPrice\" : 6.027456183070403,    \"name\" : \"name\",    \"currency\" : \"currency\",    \"id\" : \"id\",    \"category\" : \"category\",    \"type\" : \"type\"  }, {    \"unitPrice\" : 6.027456183070403,    \"name\" : \"name\",    \"currency\" : \"currency\",    \"id\" : \"id\",    \"category\" : \"category\",    \"type\" : \"type\"  } ]}", Parts.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default PartApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see PartApi#getPartsByCategory
     */
    default ResponseEntity<Parts> getPartsByCategory(String category) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"parts\" : [ {    \"unitPrice\" : 6.027456183070403,    \"name\" : \"name\",    \"currency\" : \"currency\",    \"id\" : \"id\",    \"category\" : \"category\",    \"type\" : \"type\"  }, {    \"unitPrice\" : 6.027456183070403,    \"name\" : \"name\",    \"currency\" : \"currency\",    \"id\" : \"id\",    \"category\" : \"category\",    \"type\" : \"type\"  } ]}", Parts.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default PartApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see PartApi#getPartsByType
     */
    default ResponseEntity<Parts> getPartsByType(String type) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"parts\" : [ {    \"unitPrice\" : 6.027456183070403,    \"name\" : \"name\",    \"currency\" : \"currency\",    \"id\" : \"id\",    \"category\" : \"category\",    \"type\" : \"type\"  }, {    \"unitPrice\" : 6.027456183070403,    \"name\" : \"name\",    \"currency\" : \"currency\",    \"id\" : \"id\",    \"category\" : \"category\",    \"type\" : \"type\"  } ]}", Parts.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default PartApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

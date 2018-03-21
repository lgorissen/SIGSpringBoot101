package com.dronebuzzers.parts.service.api;

import com.dronebuzzers.parts.service.model.Order;
import com.dronebuzzers.parts.service.model.OrderSummary;
import com.dronebuzzers.parts.service.model.Orders;
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
 * A delegate to be called by the {@link OrderApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-19T20:22:45.205Z")

public interface OrderApiDelegate {

    Logger log = LoggerFactory.getLogger(OrderApi.class);

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
     * @see OrderApi#getOrder
     */
    default ResponseEntity<Order> getOrder(String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"clientId\" : \"clientId\",  \"dbOrderNumber\" : \"dbOrderNumber\",  \"orderLines\" : [ {    \"count\" : 0,    \"id\" : \"id\"  }, {    \"count\" : 0,    \"id\" : \"id\"  } ],  \"clientReference\" : \"clientReference\"}", Order.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default OrderApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see OrderApi#getOrders
     */
    default ResponseEntity<Orders> getOrders() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"orders\" : [ {    \"clientId\" : \"clientId\",    \"dbOrderNumber\" : \"dbOrderNumber\",    \"orderLines\" : [ {      \"count\" : 0,      \"id\" : \"id\"    }, {      \"count\" : 0,      \"id\" : \"id\"    } ],    \"clientReference\" : \"clientReference\"  }, {    \"clientId\" : \"clientId\",    \"dbOrderNumber\" : \"dbOrderNumber\",    \"orderLines\" : [ {      \"count\" : 0,      \"id\" : \"id\"    }, {      \"count\" : 0,      \"id\" : \"id\"    } ],    \"clientReference\" : \"clientReference\"  } ]}", Orders.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default OrderApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see OrderApi#orderParts
     */
    default ResponseEntity<OrderSummary> orderParts(Order order) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"totalAmount\" : 1.4658129805029452,  \"clientId\" : \"clientId\",  \"orderSummaryLines\" : [ {    \"part\" : {      \"unitPrice\" : 6.027456183070403,      \"name\" : \"name\",      \"currency\" : \"currency\",      \"id\" : \"id\",      \"category\" : \"category\",      \"type\" : \"type\"    },    \"count\" : 0  }, {    \"part\" : {      \"unitPrice\" : 6.027456183070403,      \"name\" : \"name\",      \"currency\" : \"currency\",      \"id\" : \"id\",      \"category\" : \"category\",      \"type\" : \"type\"    },    \"count\" : 0  } ],  \"dbOrderNumber\" : \"dbOrderNumber\",  \"clientReference\" : \"clientReference\"}", OrderSummary.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default OrderApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

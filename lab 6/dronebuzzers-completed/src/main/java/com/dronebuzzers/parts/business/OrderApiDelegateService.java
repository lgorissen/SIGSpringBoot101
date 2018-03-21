package com.dronebuzzers.parts.business;

import com.dronebuzzers.parts.service.api.OrderApi;
import com.dronebuzzers.parts.service.api.OrderApiDelegate;
import com.dronebuzzers.parts.service.model.Order;
import com.dronebuzzers.parts.service.model.OrderLine;
import com.dronebuzzers.parts.service.model.OrderSummary;
import com.dronebuzzers.parts.service.model.OrderSummaryLine;
import com.dronebuzzers.parts.service.model.Orders;
import com.dronebuzzers.parts.repositories.order.repository.OrderLineRepository;
import com.dronebuzzers.parts.repositories.order.repository.OrderRepository;
import com.dronebuzzers.parts.repositories.part.Part;
import com.dronebuzzers.parts.repositories.part.repository.PartRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-17T17:35:48.103Z")

@Controller
public class OrderApiDelegateService implements OrderApiDelegate {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	PartRepository partRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderLineRepository orderLineRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public OrderApiDelegateService(ObjectMapper objectMapper, HttpServletRequest request) {
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

	/**
	 * @see OrderApi#getOrder
	 */
	@Override
	public ResponseEntity<Order> getOrder(String id) {

		com.dronebuzzers.parts.repositories.order.Order orderByDbOrderNumber = orderRepository.findByDbOrderNumber(id);

		Order result = Converter.convertInternalOrder2ModelOrder(orderByDbOrderNumber);

		if (result != null) {
			return new ResponseEntity<Order>(result, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<Order>(result, HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * @see OrderApi#getOrders
	 */
	@Override
	public ResponseEntity<Orders> getOrders() {

		Orders result = new Orders();

		List<com.dronebuzzers.parts.repositories.order.Order> orderList = orderRepository.findAll();
		for (int i = 0; i < orderList.size(); i++) {
			Order order = Converter.convertInternalOrder2ModelOrder(orderList.get(i));
			result.addOrdersItem(order);
		}

		return new ResponseEntity<Orders>(result, HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<OrderSummary> orderParts(
			@ApiParam(value = "order for drone parts", required = true) @Valid @RequestBody Order order) {

		log.info("DroneBuzzers: orderParts with order : " + order);

		Random rand = new Random();
		String randomNumber = "00" + rand.nextInt(1000000);
		String dbOrderNumber = "DB-" + randomNumber.toString();

		com.dronebuzzers.parts.repositories.order.Order internalOrder = Converter
				.convertModelOrder2InternalOrder(order);
		internalOrder.setDbOrderNumber(dbOrderNumber);
		com.dronebuzzers.parts.repositories.order.Order saveOrder = orderRepository.save(internalOrder);

		Iterator<com.dronebuzzers.parts.repositories.order.OrderLine> internalOrderLinesIterator = internalOrder
				.getOrderLines().iterator();
		HashSet<com.dronebuzzers.parts.repositories.order.OrderLine> internalOrderLines = new HashSet<com.dronebuzzers.parts.repositories.order.OrderLine>();
		while (internalOrderLinesIterator.hasNext()) {
			com.dronebuzzers.parts.repositories.order.OrderLine orderLine = (com.dronebuzzers.parts.repositories.order.OrderLine) internalOrderLinesIterator
					.next();
			orderLine.setOrder(saveOrder);
			orderLine.setDbOrderNumber(dbOrderNumber);
			internalOrderLines.add(orderLine);
		}
		orderLineRepository.save(internalOrderLines);

		com.dronebuzzers.parts.business.OrderSummary internalOrderSummary = new com.dronebuzzers.parts.business.OrderSummary(
				internalOrder, partRepository);

		OrderSummary orderSummary = Converter.convertInternalOrderSummary2ModelOrderSummary(internalOrderSummary);

		return new ResponseEntity<OrderSummary>(orderSummary, HttpStatus.ACCEPTED);
	}

}

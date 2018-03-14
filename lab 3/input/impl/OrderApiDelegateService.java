package com.dronebuzzers.parts.service.api.impl;

import com.dronebuzzers.parts.service.api.OrderApiDelegate;
import com.dronebuzzers.parts.service.model.Order;
import com.dronebuzzers.parts.service.model.OrderSummary;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * A delegate to be called by the {@link PartApiController}}. Implement
 * this interface with a {@link org.springframework.stereotype.Service}
 * annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-02T11:12:28.462Z")

@Service
public class OrderApiDelegateService implements OrderApiDelegate {

	private static final Logger log = LoggerFactory.getLogger(OrderApiDelegateService.class);

	PartsDAO partsDAO = new MockedPartsDAO();

	@org.springframework.beans.factory.annotation.Autowired
	public OrderApiDelegateService(ObjectMapper objectMapper, HttpServletRequest request) {
	}

	@Override
	public ResponseEntity<OrderSummary> orderParts(Order order) {

		log.info("DroneBuzzers: orderParts with order : " + order);

		com.dronebuzzers.parts.service.api.impl.Order internalOrder = convertModelOrder2InternalOrder(order);
		com.dronebuzzers.parts.service.api.impl.OrderSummary internalOrderSummary = new com.dronebuzzers.parts.service.api.impl.OrderSummary(
				internalOrder, partsDAO);

		com.dronebuzzers.parts.service.model.OrderSummary orderSummary = convertInternalOrderSummary2ModelOrderSummary(
				internalOrderSummary);

		return new ResponseEntity<OrderSummary>(orderSummary, HttpStatus.ACCEPTED);
	}

	static com.dronebuzzers.parts.service.model.OrderSummary convertInternalOrderSummary2ModelOrderSummary(
			com.dronebuzzers.parts.service.api.impl.OrderSummary in) {

		com.dronebuzzers.parts.service.model.OrderSummary result = new com.dronebuzzers.parts.service.model.OrderSummary();

		result.setClientId(in.getClientId());
		result.setClientReference(in.getClientReference());

		List<OrderSummaryLine> internalOrderSummaryLines = in.getOrderSummaryLines();
		List<com.dronebuzzers.parts.service.model.OrderSummaryLine> modelOrderSummaryLines = new ArrayList<com.dronebuzzers.parts.service.model.OrderSummaryLine>();

		for (int i = 0; i < internalOrderSummaryLines.size(); i++) {

			com.dronebuzzers.parts.service.model.OrderSummaryLine modelOrderSummaryLine = convertInternalOrderSummaryLine2ModelOrderSummaryLine(
					internalOrderSummaryLines.get(i));
			modelOrderSummaryLines.add(modelOrderSummaryLine);
		}
		result.setOrderSummaryLines(modelOrderSummaryLines);
		result.setTotalAmount(in.getTotalAmount());

		return result;
	}

	static com.dronebuzzers.parts.service.model.OrderSummaryLine convertInternalOrderSummaryLine2ModelOrderSummaryLine(
			com.dronebuzzers.parts.service.api.impl.OrderSummaryLine in) {

		com.dronebuzzers.parts.service.model.OrderSummaryLine result = new com.dronebuzzers.parts.service.model.OrderSummaryLine();
		result.setCount(in.getCount());
		result.setPart(PartApiDelegateService.convertInternalPart2ModelPart(in.getPart()));

		return result;
	}

	static com.dronebuzzers.parts.service.api.impl.Order convertModelOrder2InternalOrder(
			com.dronebuzzers.parts.service.model.Order in) {

		com.dronebuzzers.parts.service.api.impl.Order result = new com.dronebuzzers.parts.service.api.impl.Order();

		result.setClientId(in.getClientId());
		result.setClientReference(in.getClientReference());

		OrderLine[] internalOrderLines = new OrderLine[in.getOrderLines().size()];

		for (int i = 0; i < in.getOrderLines().size(); i++) {

			OrderLine internalOrderLine = convertModelOrderLine2InternalOrderLine(in.getOrderLines().get(i));
			internalOrderLines[i] = internalOrderLine;
		}
		result.setOrderLines(internalOrderLines);

		return result;
	}

	static com.dronebuzzers.parts.service.api.impl.OrderLine convertModelOrderLine2InternalOrderLine(
			com.dronebuzzers.parts.service.model.OrderLine in) {

		com.dronebuzzers.parts.service.api.impl.OrderLine result = new com.dronebuzzers.parts.service.api.impl.OrderLine();

		result.setCount(in.getCount());
		result.setId(in.getId());

		return result;
	}

}

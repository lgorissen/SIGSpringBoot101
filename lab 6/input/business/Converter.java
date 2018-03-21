package com.dronebuzzers.parts.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.dronebuzzers.parts.service.model.Order;
import com.dronebuzzers.parts.service.model.OrderLine;
import com.dronebuzzers.parts.service.model.OrderSummary;
import com.dronebuzzers.parts.service.model.OrderSummaryLine;
import com.dronebuzzers.parts.service.model.Part;

public class Converter {

	static Order convertInternalOrder2ModelOrder(
			com.dronebuzzers.parts.repositories.order.Order in) {

		Order result = new Order();
		result.setClientId(in.getClientId());
		result.setClientReference(in.getClientReference());
		result.setDbOrderNumber(in.getDbOrderNumber());
		result.setOrderLines(convertInternalOrderLines2ModelOrderLines(in.getOrderLines()));
		return result;
	}
	
	static List<OrderLine> convertInternalOrderLines2ModelOrderLines(
			Set<com.dronebuzzers.parts.repositories.order.OrderLine> in) {

		List<OrderLine> result = new ArrayList<OrderLine>();

		
		Iterator<com.dronebuzzers.parts.repositories.order.OrderLine> internalOrderLinesIterator = in.iterator();
		while (internalOrderLinesIterator.hasNext()) {
			com.dronebuzzers.parts.repositories.order.OrderLine orderLineIn = (com.dronebuzzers.parts.repositories.order.OrderLine) internalOrderLinesIterator.next();
			
			OrderLine orderLineResult = new OrderLine();
			
			orderLineResult.setCount(orderLineIn.getCount());
			orderLineResult.setId(orderLineIn.getPartId());
			
			result.add(orderLineResult);

		}

		return result;
	}


	static OrderSummary convertInternalOrderSummary2ModelOrderSummary(
			com.dronebuzzers.parts.business.OrderSummary in) {

		OrderSummary result = new OrderSummary();

		result.setClientId(in.getClientId());
		result.setClientReference(in.getClientReference());
		result.setDbOrderNumber(in.getDbOrderNumber());

		List<com.dronebuzzers.parts.business.OrderSummaryLine> internalOrderSummaryLines = in
				.getOrderSummaryLines();
		List<OrderSummaryLine> modelOrderSummaryLines = new ArrayList<OrderSummaryLine>();

		for (int i = 0; i < internalOrderSummaryLines.size(); i++) {

			OrderSummaryLine modelOrderSummaryLine = convertInternalOrderSummaryLine2ModelOrderSummaryLine(
					internalOrderSummaryLines.get(i));
			modelOrderSummaryLines.add(modelOrderSummaryLine);
		}
		result.setOrderSummaryLines(modelOrderSummaryLines);
		result.setTotalAmount(in.getTotalAmount());

		return result;
	}

	static OrderSummaryLine convertInternalOrderSummaryLine2ModelOrderSummaryLine(
			com.dronebuzzers.parts.business.OrderSummaryLine in) {

		OrderSummaryLine result = new OrderSummaryLine();
		result.setCount(in.getCount());
		result.setPart(convertInternalPart2ModelPart(in.getPart()));

		return result;
	}

	static com.dronebuzzers.parts.repositories.order.Order convertModelOrder2InternalOrder(Order in) {

		com.dronebuzzers.parts.repositories.order.Order result = new com.dronebuzzers.parts.repositories.order.Order();

		result.setClientId(in.getClientId());
		result.setClientReference(in.getClientReference());

		Set<com.dronebuzzers.parts.repositories.order.OrderLine> internalOrderLines = new HashSet<com.dronebuzzers.parts.repositories.order.OrderLine>();

		for (int i = 0; i < in.getOrderLines().size(); i++) {

			com.dronebuzzers.parts.repositories.order.OrderLine internalOrderLine = convertModelOrderLine2InternalOrderLine(
					in.getOrderLines().get(i));
			internalOrderLines.add(internalOrderLine);
		}
		result.setOrderLines(internalOrderLines);

		return result;
	}

	static com.dronebuzzers.parts.repositories.order.OrderLine convertModelOrderLine2InternalOrderLine(OrderLine in) {

		com.dronebuzzers.parts.repositories.order.OrderLine result = new com.dronebuzzers.parts.repositories.order.OrderLine();

		result.setPartId(in.getId());
		result.setCount(in.getCount());

		return result;
	}
	
	static com.dronebuzzers.parts.service.model.Part convertInternalPart2ModelPart(
			com.dronebuzzers.parts.repositories.part.Part in) {

		com.dronebuzzers.parts.service.model.Part result = new com.dronebuzzers.parts.service.model.Part();
		result.setCategory(in.getCategory());
		result.setCurrency(in.getCurrency());
		result.setId(String.valueOf(in.getPartId()));
		result.setName(in.getName());
		result.setType(in.getType());
		result.setUnitPrice(in.getUnitPrice());

		return result;
	}

	static com.dronebuzzers.parts.service.model.Parts convertInternalParts2ModelParts(
			List<com.dronebuzzers.parts.repositories.part.Part> inParts) {

		com.dronebuzzers.parts.service.model.Parts result = new com.dronebuzzers.parts.service.model.Parts();

		java.util.List<com.dronebuzzers.parts.repositories.part.Part> listParts = inParts;

		for (int i = 0; i < listParts.size(); i++) {

			com.dronebuzzers.parts.repositories.part.Part inPart = listParts.get(i);
			Part toConvert = new Part();

			toConvert.setCategory(inPart.getCategory());
			toConvert.setCurrency(inPart.getCurrency());
			toConvert.setId(String.valueOf(inPart.getPartId()));
			toConvert.setName(inPart.getName());
			toConvert.setType(inPart.getType());
			toConvert.setUnitPrice(inPart.getUnitPrice());
			result.addPartsItem(toConvert);

		}

		return result;
	}

	
}

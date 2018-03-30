package com.dronebuzzers.parts.repository;


import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.dronebuzzers.parts.soap.Currency;
import com.dronebuzzers.parts.soap.Part;
import com.dronebuzzers.parts.soap.PartList;


@Component
public class PartRepository {

	private static final Map<String, Part> parts = new HashMap<String, Part>();

	@PostConstruct
	public void initData() {

		Part part1 = new Part();
		part1.setId("DB-FK-A250-V4");
		part1.setCategory("Drone");
		part1.setType("Frame");
		part1.setDescription("DroneBuzzer Frame Kit regular V4 (2016 edition)");
		part1.setPrice(14.65);
		part1.setCurrency(Currency.EUR);
		
		parts.put(part1.getId(), part1);

		Part part2 = new Part();
		part2.setId("DB-FK-A250-V5");
		part2.setCategory("Drone");
		part2.setType("Frame");
		part2.setDescription("DroneBuzzer Frame Kit regular V5 (2017 edition)");
		part2.setPrice(19.55);
		part2.setCurrency(Currency.EUR);
		
		parts.put(part2.getId(), part2);

		Part part3 = new Part();
		part3.setId("DB-FK-R250-SuperR");
		part3.setCategory("Drone");
		part3.setType("Frame");
		part3.setDescription("DroneBuzzer Race Frame Kit version SuperR");
		part3.setPrice(23.15);
		part3.setCurrency(Currency.EUR);
		
		parts.put(part3.getId(), part3);
		
		Part part4 = new Part();
		part4.setId("DB-38404-2300KV");
		part4.setCategory("Drone");
		part4.setType("Motor");
		part4.setDescription("DroneBuzzer regular 2016");
		part4.setPrice(18.95);
		part4.setCurrency(Currency.EUR);
		
		parts.put(part4.getId(), part4);
		
		Part part5 = new Part();
		part5.setId("DB-38406-2350KV");
		part5.setCategory("Drone");
		part5.setType("Motor");
		part5.setDescription("DroneBuzzer regular 2017");
		part5.setPrice(21.95);
		part5.setCurrency(Currency.EUR);
		
		parts.put(part5.getId(), part5);
		
		Part part6 = new Part();
		part6.setId("DB-38608-250500KV");
		part6.setCategory("Drone");
		part6.setType("Motor");
		part6.setDescription("DroneBuzzer racer");
		part6.setPrice(25.95);
		part6.setCurrency(Currency.EUR);
		
		parts.put(part6.getId(), part6);
		
		Part part7 = new Part();
		part7.setId("DB-ESC-622-25A");
		part7.setCategory("Drone");
		part7.setType("Speedcontroller");
		part7.setDescription("DroneBuzzer speedcontoller quadcopter - ESC 2-4S 4x25A");
		part7.setPrice(32.90);
		part7.setCurrency(Currency.EUR);
		
		parts.put(part7.getId(), part7);
		
		Part part8 = new Part();
		part8.setId("DB-ESC-629-40A");
		part8.setCategory("Drone");
		part8.setType("Speedcontroller");
		part8.setDescription("DroneBuzzer speedcontoller racer - 40A (require 4)");
		part8.setPrice(9.95);
		part8.setCurrency(Currency.EUR);
		
		parts.put(part8.getId(), part8);
		
		Part part9 = new Part();
		part9.setId("DB-FC-9773-R");
		part9.setCategory("Drone");
		part9.setType("Flightcontroller");
		part9.setDescription("DroneBuzzer flightcontoller racer - 4ch");
		part9.setPrice(43.95);
		part9.setCurrency(Currency.EUR);
		
		parts.put(part9.getId(), part9);
		
		Part part10= new Part();
		part10.setId("DB-FC-9773-A");
		part10.setCategory("Drone");
		part10.setType("Flightcontroller");
		part10.setDescription("DroneBuzzer flightcontoller regular - 4ch");
		part10.setPrice(24.15);
		part10.setCurrency(Currency.EUR);
		
		parts.put(part10.getId(), part10);
		
		Part part11 = new Part();
		part11.setId("DB-CAM-16:9-fisheye-C960");
		part11.setCategory("Drone");
		part11.setType("Camera");
		part11.setDescription("DroneBuzzer camera - 16:9 CMOS ");
		part11.setPrice(34.99);
		part11.setCurrency(Currency.EUR);
		
		parts.put(part11.getId(), part11);
		
		Part part12 = new Part();
		part12.setId("DB-PROP-6x4.5-CW/CCW-FIB-001");
		part12.setCategory("Drone");
		part12.setType("Props");
		part12.setDescription("DroneBuzzer regular prop 6 inch - 2 pairs/pack, CW & CCW");
		part12.setPrice(1.05);
		part12.setCurrency(Currency.EUR);
		
		parts.put(part12.getId(), part12);
		
		Part part13 = new Part();
		part13.setId("DB-PROP-6x4-CW/CCW-FIB-002");
		part13.setCategory("Drone");
		part13.setType("Props");
		part13.setDescription("DroneBuzzer regular prop 6 inch - 2 pairs/pack, CW & CCW");
		part13.setPrice(1.15);
		part13.setCurrency(Currency.EUR);
		
		parts.put(part13.getId(), part13);
		
		Part part14 = new Part();
		part14.setId("DB-PROP-6x5-CW/CCW-FIB-RE");
		part14.setCategory("Drone");
		part14.setType("Props");
		part14.setDescription("DroneBuzzer racing prop 6 inch - 2 pairs/pack, CW & CCW");
		part14.setPrice(1.95);
		part14.setCurrency(Currency.EUR);
		
		parts.put(part14.getId(), part14);
	

	}

	public Part findPart(String id) {
		Assert.notNull(id, "The part's id must not be null");
		return parts.get(id);
	}
 
	public PartList getParts() {

                PartList result = new PartList();

                for (String key : parts.keySet()) {
                        result.getPart().add(parts.get(key));
                }

		return result;
	}

	public PartList findPartsByType(String type) {
		Assert.notNull(type, "The part's type must not be null");

                PartList result = new PartList();

                for (String key : parts.keySet()) {
                        if ( parts.get(key).getType().equals(type) ) {

                                result.getPart().add(parts.get(key));
                        }
                }


		return result;
	}

}



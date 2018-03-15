package com.dronebuzzers.parts.service.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class MockedPartsStore {
	
	  private static final CopyOnWriteArrayList<Part> pList = new CopyOnWriteArrayList<>();
	  
	  static {

	        String jsonString = "[ { \"id\": \"DB-FK-A250-V4\", \"category\": \"Drone\", \"type\": \"Frame\", \"name\": \"DroneBuzzer Frame Kit regular V4 (2016 edition)\", \"unitPrice\": 14.65, \"currency\": \"EUR\" }, { \"id\": \"DB-FK-A250-V5\",  \"category\": \"Drone\", \"type\": \"Frame\", \"name\": \"DroneBuzzer Frame Kit regular V5 (2017 edition)\", \"unitPrice\": 19.55, \"currency\": \"EUR\" }, { \"id\": \"DB-FK-R250-SuperR\",  \"category\": \"Drone\", \"type\": \"Frame\", \"name\": \"DroneBuzzer Race Frame Kit version SuperR\", \"unitPrice\": 23.15, \"currency\": \"EUR\" }, { \"id\": \"DB-38404-2300KV\",  \"category\": \"Drone\", \"type\": \"Motor\", \"name\": \"DroneBuzzer regular 2016\", \"unitPrice\": 18.95, \"currency\": \"EUR\" }, { \"id\": \"DB-38406-2350KV\",  \"category\": \"Drone\", \"type\": \"Motor\", \"name\": \"DroneBuzzer regular 2017\", \"unitPrice\": 21.95, \"currency\": \"EUR\" }, { \"id\": \"DB-38608-250500KV\",  \"category\": \"Drone\", \"type\": \"Motor\", \"name\": \"DroneBuzzer racer\", \"unitPrice\": 25.95, \"currency\": \"EUR\" }, { \"id\": \"DB-ESC-622-25A\",  \"category\": \"Drone\", \"type\": \"Speedcontroller\", \"name\": \"DroneBuzzer speedcontoller quadcopter - ESC 2-4S 4x25A\", \"unitPrice\": 32.90, \"currency\": \"EUR\" }, { \"id\": \"DB-ESC-629-40A\",  \"category\": \"Drone\", \"type\": \"Speedcontroller\", \"name\": \"DroneBuzzer speedcontoller racer - 40A (require 4)\", \"unitPrice\": 9.95, \"currency\": \"EUR\" }, { \"id\": \"DB-FC-9773-R\",  \"category\": \"Drone\", \"type\": \"Flightcontroller\", \"name\": \"DroneBuzzer flightcontoller racer - 4ch\", \"unitPrice\": 43.95, \"currency\": \"EUR\" }, { \"id\": \"DB-FC-9773-A\",  \"category\": \"Drone\", \"type\": \"Flightcontroller\", \"name\": \"DroneBuzzer flightcontoller regular - 4ch\", \"unitPrice\": 24.15, \"currency\": \"EUR\" }, { \"id\": \"DB-CAM-16:9-fisheye-C960\",  \"category\": \"Drone\", \"type\": \"Camera\", \"name\": \"DroneBuzzer camera - 16:9 CMOS \", \"unitPrice\": 34.99, \"currency\": \"EUR\" }, { \"id\": \"DB-PROP-6x4.5-CW/CCW-FIB-001\",  \"category\": \"Drone\", \"type\": \"Props\", \"name\": \"DroneBuzzer regular prop 6 inch - 2 pairs/pack, CW & CCW\", \"unitPrice\": 1.05, \"currency\": \"EUR\" }, { \"id\": \"DB-PROP-6x4-CW/CCW-FIB-002\",  \"category\": \"Drone\", \"type\": \"Props\", \"name\": \"DroneBuzzer regular prop 6 inch - 2 pairs/pack, CW & CCW\", \"unitPrice\": 1.15, \"currency\": \"EUR\" }, { \"id\": \"DB-PROP-6x5-CW/CCW-FIB-RE\",  \"category\": \"Drone\", \"type\": \"Props\", \"name\": \"DroneBuzzer racing prop 6 inch - 2 pairs/pack, CW & CCW\", \"unitPrice\": 1.95, \"currency\": \"EUR\" }]";

	        try {

	            ObjectMapper mapper = new ObjectMapper();

	            Part[] myParts = mapper.readValue(jsonString, Part[].class);
	            
	            pList.addAll(Arrays.asList(myParts));
	            
	        } catch (IOException exception) {
	            System.out.println("Error: " + exception.getMessage());
	        }
	      
	  }
	  
	  private MockedPartsStore(){}
	  
	  public static CopyOnWriteArrayList<Part> getInstance(){
	    return pList;
	  }


}
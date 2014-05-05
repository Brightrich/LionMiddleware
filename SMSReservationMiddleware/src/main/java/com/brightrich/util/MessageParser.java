package com.brightrich.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class MessageParser {
	
	
	
	
    
	public static HashMap<String,String> messageParser(String msg, String type){
				 
		 Matcher m = null;
		 HashMap<String, String> parsedMap = new HashMap<String, String>();
		 
		 //convert msg to Upper-case and Trim message to remove unnecessary white-space 
		 msg = msg.toUpperCase().trim();
		 
		 if(type.equalsIgnoreCase(Constant.MessageParser.STARTS_WITH_AIRLINES)){
			 
			 System.out.println(Constant.MessageParser.STARTS_WITH_AIRLINES);
			 
			 parsedMap.put(Constant.MessageParser.STEP, Constant.MessageParser.STARTS_WITH_AIRLINES);				
			 
			 if(Constant.MessageParser.FlightInquiry.rFlightPattern.matcher(msg).matches()){
				//RETURN FLIGHT
				m = Constant.MessageParser.FlightInquiry.rFlightPattern.matcher(msg); 				
				parsedMap = populateCommonMap(parsedMap, m, Constant.MessageParser.FlightInquiry.RETURN_FLIGHT_ORDER);						
				parsedMap.remove(Constant.MessageParser.AVOIDED_DASH);								 
			 } else if(Constant.MessageParser.FlightInquiry.sFlightPattern.matcher(msg).matches()){				 
				 m = Constant.MessageParser.FlightInquiry.sFlightPattern.matcher(msg);				 
				 parsedMap = populateCommonMap(parsedMap, m, Constant.MessageParser.FlightInquiry.SINGLE_FLIGHT_ORDER);				 
			 } else {
				 parsedMap.put(Constant.MessageParser.PATTERN_NOT_FOUND, Constant.MessageParser.PATTERN_NOT_FOUND);
			 }
			 
		 } else if(type.equalsIgnoreCase(Constant.MessageParser.STARTS_WITH_BOOKING)){
			 
			 System.out.println(Constant.MessageParser.STARTS_WITH_BOOKING);
			 parsedMap.put(Constant.MessageParser.STEP, Constant.MessageParser.STARTS_WITH_BOOKING);
			 
			 if(Constant.MessageParser.FlightBooking.rBookingPattern.matcher(msg).matches()){
					//RETURN FLIGHT BOOKING				 	
				m = Constant.MessageParser.FlightBooking.rBookingPattern.matcher(msg); 					
			    parsedMap = populateCommonMap(parsedMap, m, Constant.MessageParser.FlightBooking.RETURN_BOOKING_ORDER);
			    parsedMap.put(Constant.MessageParser.FLIGHT_TYPE, Constant.MessageParser.R_FLAG);
			} else if(Constant.MessageParser.FlightBooking.sBookingPattern.matcher(msg).matches()){
				
				System.out.println("SINGLE BOOKING ORDER");
				
				m = Constant.MessageParser.FlightBooking.sBookingPattern.matcher(msg);				 
				parsedMap = populateCommonMap(parsedMap, m, Constant.MessageParser.FlightBooking.SINGLE_BOOKING_ORDER);
				parsedMap.put(Constant.MessageParser.FLIGHT_TYPE, Constant.MessageParser.S_FLAG);	 
			} else {
				parsedMap.put(Constant.MessageParser.PATTERN_NOT_FOUND, Constant.MessageParser.PATTERN_NOT_FOUND);
			}
			 
		 } else if(type.equalsIgnoreCase(Constant.MessageParser.STARTS_WITH_PAX)){
			 
			 parsedMap.put(Constant.MessageParser.STEP, Constant.MessageParser.STARTS_WITH_PAX);
			 
			 msg = msg.replace(Constant.MessageParser.PaxDetails.PAX_COMMAND + " ","");
			 		
			 String[] parsedMsg = msg.split(Constant.MessageParser.PaxDetails.WILDCARD);			 			 
			 
			 int numOfPax=0;
			 for (int i = 0; i < parsedMsg.length; i++) {
				 numOfPax = numOfPax + 1;
				 System.out.println("PARSED MSG = " + parsedMsg[i]);
				 
				 if(Constant.MessageParser.PaxDetails.adultPaxPattern.matcher(parsedMsg[i]).matches()){
					m = Constant.MessageParser.PaxDetails.adultPaxPattern.matcher(parsedMsg[i]); 					
					parsedMap = populatePaxMap(parsedMap, m, Constant.MessageParser.PaxDetails.ADULT_PAX_ORDER);																				 
				 } else if(Constant.MessageParser.PaxDetails.childPaxPattern.matcher(parsedMsg[i]).matches()){					 
					 m = Constant.MessageParser.PaxDetails.childPaxPattern.matcher(parsedMsg[i]);				 
					 parsedMap = populatePaxMap(parsedMap, m, Constant.MessageParser.PaxDetails.CHILD_PAX_ORDER);
					 
				 } else if(Constant.MessageParser.PaxDetails.adultPaxWithMidNamePattern.matcher(parsedMsg[i]).matches()){
						m = Constant.MessageParser.PaxDetails.adultPaxWithMidNamePattern.matcher(parsedMsg[i]); 					
						parsedMap = populatePaxMap(parsedMap, m, Constant.MessageParser.PaxDetails.ADULT_PAX_WITH_MID_NAME_ORDER);
				 } else if(Constant.MessageParser.PaxDetails.childPaxWithMidNamePattern.matcher(parsedMsg[i]).matches()){					 
					 m = Constant.MessageParser.PaxDetails.childPaxWithMidNamePattern.matcher(parsedMsg[i]);				 
					 parsedMap = populatePaxMap(parsedMap, m, Constant.MessageParser.PaxDetails.CHILD_PAX_WITH_MID_NAME_ORDER);
						
			     }else {
					 parsedMap.put(Constant.MessageParser.PATTERN_NOT_FOUND, Constant.MessageParser.PATTERN_NOT_FOUND);
					 break;
				 }
			 }
			 
			 parsedMap.put(Constant.MessageParser.PaxDetails.NUM_OF_PAX, String.valueOf(numOfPax));
		 }
		 
		    
		    //System.out.println("MATCH PATTERN ? " + m.matches());		   		    
		    return parsedMap;
	}
	
	public static HashMap<String, String> populateCommonMap(HashMap<String, String> parsedMap, Matcher m, String[] attribute){
		m.find();
		//System.out.println("LENGTH = " + m.groupCount());
		for(int i=0; i < m.groupCount(); i++){
			 
			 //System.out.println("GROUP #" + i + " VALUE = " + m.group(i));
			 if(!m.group(i+1).equalsIgnoreCase(Constant.MessageParser.AVOIDED_WHITE_SPACE)){
				 
				 parsedMap.put(attribute[i/2], m.group(i+1));
				 //System.out.println(Constant.MessageParser.FlightInquiry.RETURN_FLIGHT_ORDER[i/2] +" = "  + m.group(i+1) + " REAL VALUE = " + m.group(i+1));
			 }					 
		 }
		
		return parsedMap;
	}
	
	public static HashMap<String, String> populatePaxMap(HashMap<String, String> parsedMap, Matcher m, String[] attribute){
		m.find();
		String paxNumKey = "";
		for(int i=0; i < m.groupCount(); i++){									
			// System.out.println("GROUP #" + i + " VALUE = " + m.group(i));
			 if(!m.group(i+1).equalsIgnoreCase(Constant.MessageParser.AVOIDED_WHITE_SPACE)){
				 
				 if(i==0){
					 paxNumKey = m.group(i+1);
				 }
				 
				 parsedMap.put(paxNumKey+"_"+attribute[i/2], m.group(i+1));
				 //System.out.println(Constant.MessageParser.FlightInquiry.RETURN_FLIGHT_ORDER[i/2] +" = "  + m.group(i+1) + " REAL VALUE = " + m.group(i+1));
			 }					 
		 }
		
		return parsedMap;
	}
	
	public static void main(String args[]){
		//String txt = "LION CGK DPS S 10 JUN MORNING ECONOMY 2";
		//String txt ="LION CGK DPS R 10 JUN MORNING - 12 JUN NIGHT ECONOMY 2";
		//String txt = "BOOKING O#1 R#2";
		//String txt = "BOOKING O#1";
		String txt = "PAX P1 MR ARGA HASRIL 3275081107850014#P2 MRS RINJANI PUTRI HASRIL 01234567890#P3 MR GUNTUR PUTRA";
		HashMap<String,String> parsedMsg = messageParser(txt,Constant.MessageParser.STARTS_WITH_PAX);
		for (Map.Entry<String, String>  map : parsedMsg.entrySet()) {
        	System.out.println(map.getKey() + " : " + map.getValue());
        }				
	}
	
}

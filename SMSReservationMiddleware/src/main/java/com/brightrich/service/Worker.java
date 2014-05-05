package com.brightrich.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brightrich.dao.BookingResultDao;
import com.brightrich.dao.InquiryResultDao;
import com.brightrich.model.BookingResult;
import com.brightrich.model.InquiryResult;
import com.brightrich.util.Constant;
import com.brightrich.util.MessageParser;
import com.brightrich.util.QueueSender;
import com.lion.model.xsd.ObjectFactory;
import com.lion.model.xsd.Pax;
import com.lion.model.xsd.PaxDetailResponse;
import com.lion.model.xsd.PaymentNotificationResponse;

public class Worker implements Runnable{
		
	private String message;
	private String msisdn;
	private String trxId;
	private static InquiryResultDao inquiryResultDao;
	private static BookingResultDao bookingResultDao;
	static Logger log = LoggerFactory.getLogger(Worker.class);
	
	public Worker(String message, String msisdn, String trxId, InquiryResultDao inquiryResultDao, BookingResultDao bookingResultDao){
		this.message = message;
		this.msisdn = msisdn;
		this.trxId = trxId;
		Worker.inquiryResultDao = inquiryResultDao;
		Worker.bookingResultDao = bookingResultDao;
	}        
	
	public static String flightBookingProcess(String msg, String msisdn){
    	String response="",messageHeader="", messageBody="", 
    		   messageFooter="Untuk melanjutkan, masukkan data penumpang dengan format PAX P1 <TITLE> <FIRST_NAME> <LAST_NAME> <ID_CARD_NUMBER>#P2 <TITLE> <FIRST_NAME> <LAST_NAME> <ID_CARD_NUMBER>, sebanyak jumlah penumpang.";
    	
    	System.out.println("STEPS = BEGIN MESSAGE PARSER BOOKING");
    	
    	HashMap<String, String> parsedMap = null;
    	parsedMap = MessageParser.messageParser(msg, Constant.MessageParser.STARTS_WITH_BOOKING);    	    	    	
    	System.out.println("MESSAGE PARSER DONE with FLIGHT_TYPE = " + parsedMap.get(Constant.MessageParser.FLIGHT_TYPE));
    	
    	if(parsedMap.get(Constant.MessageParser.PATTERN_NOT_FOUND)==null){
    	
		    	//bookingResultDao.ge
		    	
		    	InquiryResult out = inquiryResultDao.getInquiryResultWithTypeAndKey(msisdn, parsedMap.get(Constant.MessageParser.FlightBooking.OUTBOUND_FLIGHT));
		    	
		    	if(out == null){		    		
		    		return response = Constant.Validation.BOOKING_SCHEDULE_NF_ERROR_MSG;
		    	}
		    	
		    	InquiryResult ret = null;
				
				//System.out.println("OUT FLIGHT = " + out.getFlightNumber());
				
		    	if(parsedMap.get(Constant.MessageParser.FLIGHT_TYPE).equals(Constant.MessageParser.R_FLAG)){
		    		ret = inquiryResultDao.getInquiryResultWithTypeAndKey(msisdn, parsedMap.get(Constant.MessageParser.FlightBooking.RETURN_FLIGHT));
		    		if(ret == null){
		    			return response = Constant.Validation.BOOKING_SCHEDULE_NF_ERROR_MSG;
		    		}
		    	}
		    	
		    	
		    	//System.out.println("STEPS = INVOKE LION WS STUB BOOKING");
		    	log.info("Invoking LionAirWs for Reservation Process with msisdn : " + msisdn);
		    	BookingResult res = null;
				try {
					res = LionAirService.invokeFlightReservationService(parsedMap, msisdn, out, ret);
					
					inquiryResultDao.updateInquiryResultFlag(Constant.MessageParser.FlightInquiry.CHOSEN_FLAG, out.getId());
					if(ret!=null){
						inquiryResultDao.updateInquiryResultFlag(Constant.MessageParser.FlightInquiry.CHOSEN_FLAG, ret.getId());
					}
					
					inquiryResultDao.deleteTemporaryInquiryResult(msisdn, Constant.MessageParser.FlightInquiry.CHOSEN_FLAG);
					bookingResultDao.saveBookingResult(res);
					
				} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();				
					log.error(e.getMessage());
					return response = Constant.Validation.BOOKING_FLIGHT_ERROR;
				}
		    	
		    	messageHeader = "Outbound flight " + res.getDepartureDate() + " "+ res.getOutboundFlightNumber() +"/" + res.getFlightClass() + " " + res.getOrigin() + " " + res.getOutboundDepartureTime()
		    					+ " - " + res.getDestination() + " " + res.getOutboundArrivalTime()+"\n"+
		    					"Return flight " + res.getReturnDate() + " "+ res.getReturnFlightNumber() +"/" + res.getFlightClass() + " " + res.getDestination() + " " + res.getReturnDepartureTime()
		    					+ " - " + res.getOrigin() + " " + res.getReturnArrivalTime();
		    	
		    	messageBody = "Total taxes & fees:\n Base fare " + res.getBaseFare() + "\n Total Fuel Surcharge, Taxes & Fees " + res.getAdditionalFees() + "\n Total " + Constant.Common.numberFormatIDR.format(new BigDecimal(res.getTotalFare())).replace(Constant.Common.RP, Constant.Common.RP+" ").replace(Constant.Common.DEC_DIGIT, "");		    			    	
		    	
		    	//System.out.println("STEPS = BUILDING MESSAGE RESPONSE");
		    	
		    	response = messageHeader + "\n" + messageBody +"\n" + messageFooter;
		    	
    	} else {
    		response = Constant.Validation.BOOKING_PATTERN_ERROR_MSG;
    	}
    	
    	
    	//System.out.println("RESPONSE MSG = " + response);
    	return response;
    }
    
    public static String flightInquiryProcess(String msg, String msisdn){
    	String messageOutbound="", messageReturn="", messageFooter="balas sms ini dengan mengetik BOOKING O#<angka> R#<angka> untuk memilih waktu penerbangan",response ="";
    	
    	//System.out.println("STEPS = BEGIN MESSAGE PARSER");
    	
    	
    	HashMap<String, String> parsedMap = null;
    	parsedMap = MessageParser.messageParser(msg, Constant.MessageParser.STARTS_WITH_AIRLINES);
    	
    	if(parsedMap.get(Constant.MessageParser.PATTERN_NOT_FOUND)==null){
    			
    			Calendar dateNow = Calendar.getInstance();
    			try {
					Date depDate = Constant.Validation.flightTimeFormat.parse(parsedMap.get(Constant.MessageParser.FlightInquiry.OUTBOUND_DATE)+"-"+Constant.Validation.monthMapIDtoEN.get(parsedMap.get(Constant.MessageParser.FlightInquiry.OUTBOUND_MONTH))+"-"+dateNow.get(Calendar.YEAR));
					Date retDate = Constant.Validation.flightTimeFormat.parse(parsedMap.get(Constant.MessageParser.FlightInquiry.RETURN_DATE)+"-"+Constant.Validation.monthMapIDtoEN.get(parsedMap.get(Constant.MessageParser.FlightInquiry.RETURN_MONTH))+"-"+dateNow.get(Calendar.YEAR));
					
					if(depDate.getMonth() > retDate.getMonth()){
						retDate.setYear(dateNow.get(Calendar.YEAR)+1);
					}
					
					if(depDate.after(retDate)){
						return response = Constant.Validation.INQUIRY_FLIGHT_DATE_ERROR;
					}
				} catch (ParseException e1) {
					e1.printStackTrace();
					log.error(e1.getMessage());
				}
    		
				
		    	//System.out.println("STEPS = INVOKE LION WS STUB");
    			log.info("Invoking LionAirWs for Inquiry Process with msisdn : " + msisdn);
		    	List<InquiryResult> listResult = LionAirService.invokeFlightInquiryService(parsedMap, msisdn);
		    	
		    	if(listResult.size() > 0){
		    				    	
			    	try{
			    		inquiryResultDao.deleteTemporaryInquiryResult(msisdn, "N");
			    		inquiryResultDao.saveInquiryResult(listResult);
			    		messageOutbound = "OUTBOUND " + parsedMap.get(Constant.MessageParser.FlightInquiry.OUTBOUND_DATE) + " " + Constant.Validation.monthMapIDtoEN.get(parsedMap.get(Constant.MessageParser.FlightInquiry.OUTBOUND_MONTH)) + "\n";
				    	messageReturn = "RETURN " + parsedMap.get(Constant.MessageParser.FlightInquiry.RETURN_DATE) + " " + Constant.Validation.monthMapIDtoEN.get(parsedMap.get(Constant.MessageParser.FlightInquiry.RETURN_MONTH)) + "\n";
			    	} catch (Exception e){
			    		e.printStackTrace();
			    		log.error(e.getMessage());
			    		return response = Constant.Validation.INQUIRY_FLIGHT_ERROR;
			    	}
			    	
			    	//System.out.println("STEPS = BUILDING MESSAGE RESPONSE");
			    	
			    	for (InquiryResult i : listResult) {
			    		
						if(i.getFlightType().equalsIgnoreCase(Constant.InquiryProcess.OUTBOUND_TYPE)){
							messageOutbound = messageOutbound + i.generateSMSResponse();
						} else if(i.getFlightType().equalsIgnoreCase(Constant.InquiryProcess.RETURN_TYPE)){
							messageReturn = messageReturn + i.generateSMSResponse();
						}
						
					}
			    	
			    	response = messageOutbound + "\n" + messageReturn +"\n" + messageFooter;
			    	
		    	} else {
		    		response = Constant.Validation.INQUIRY_FLIGHT_NA_MSG;
		    	}
		    	
    	} else {
    			response = Constant.Validation.INQUIRY_PATTERN_ERROR_MSG;
    	}
    	
    	return response;
    }
    
    public static String paxInfoReservationDetails(String msg, String msisdn){
    	
    	String response="";
    	
    	System.out.println("STEPS = BEGIN MESSAGE PARSER");
    	
    	HashMap<String, String> parsedMap = null;
    	parsedMap = MessageParser.messageParser(msg, Constant.MessageParser.STARTS_WITH_PAX);
    	
    	if(parsedMap.get(Constant.MessageParser.PATTERN_NOT_FOUND)==null){
    	
		    	//System.out.println("STEPS = INVOKE LION WS STUB");
		    	
		    	BookingResult book = bookingResultDao.getLatestBookingResult(msisdn);
		    	
		    	if(book == null){
		    		return response = Constant.Validation.PAX_BOOK_NF_ERROR_MSG;
		    	}
		    	
		     			     			     	
		     	
		     	if(Integer.parseInt(parsedMap.get(Constant.MessageParser.PaxDetails.NUM_OF_PAX)) < Integer.parseInt(book.getNumOfPax()) || 
		     	   Integer.parseInt(parsedMap.get(Constant.MessageParser.PaxDetails.NUM_OF_PAX)) > Integer.parseInt(book.getNumOfPax())) {
		     		return response = Constant.Validation.PAX_INCOMPLETE_ERROR_MSG;
		     	}
		     	
		     	List<Pax> paxList = new ArrayList<Pax>();
		     	
		     	ObjectFactory fact = new ObjectFactory();
		     	String identifier = "P";
		     	String name="";
		     	
		     	for(int i=1; i<=Integer.parseInt(book.getNumOfPax()); i++){
		     		Pax p = new Pax();
		     		identifier += i + "_";
		     		name = parsedMap.get(identifier+Constant.MessageParser.PaxDetails.PAX_FIRST_NAME) + " " + 
		     			   (parsedMap.get(identifier+Constant.MessageParser.PaxDetails.PAX_MIDDLE_NAME)!=null?parsedMap.get(identifier+Constant.MessageParser.PaxDetails.PAX_MIDDLE_NAME)+" ":" ") +
		     			   (parsedMap.get(identifier+Constant.MessageParser.PaxDetails.PAX_LAST_NAME)!=null?parsedMap.get(identifier+Constant.MessageParser.PaxDetails.PAX_LAST_NAME):"");
		     		
		     		p.setPaxName(fact.createPaxPaxName(name));
		     		p.setTransactionId(fact.createPaxTransactionId(book.getTransactionId()));
		     		p.setTitle(fact.createPaxTitle(parsedMap.get(identifier+Constant.MessageParser.PaxDetails.PAX_TITLE)));
		     		p.setPaxSSN(fact.createPaxPaxSSN(parsedMap.get(identifier+Constant.MessageParser.PaxDetails.PAX_SSN)!=null?parsedMap.get(identifier+Constant.MessageParser.PaxDetails.PAX_SSN):""));
		     		paxList.add(p);		     		
		     	}
		    			     			    			    			    	    
		    	try{
		    		
		    		log.info("Invoking LionAirWs for PaxInfo Process with TrxId : " + book.getTransactionId());
		    		PaxDetailResponse res = LionAirService.invokePaxDetails(paxList);
		    		bookingResultDao.updateBookingResultPaymentCode(res.getPaymentCode().getValue(), res.getTransactionId().getValue());
		    		System.out.println("STEPS = BUILDING MESSAGE RESPONSE");		    	    
			    	response = res.getMessage().getValue();
		    	} catch (Exception e){
		    		e.printStackTrace();
		    		log.error(e.getMessage());
		    		response = Constant.Validation.PAX_SERVICE_ERROR;
		    	}
		    			    	
    	
    	} else {
    		response = Constant.Validation.PAX_PATTERN_ERROR_MSG;
    	}
    	
    	//System.out.println("RESPONSE MSG = " + response);
    	return response;
    	
    }
    
    public static String paymentNotification(String transactionId, String msisdn){
    	
    	String response="";    	    	
    	
    	//System.out.println("STEPS = INVOKE LION WS STUB");
    	log.info("Invoking LionAirWs for Payment Notification Process for TrxId : " + transactionId);
    	PaymentNotificationResponse res = LionAirService.invokePaymentNotification(transactionId);
    	    	
    	try{
    		bookingResultDao.updateBookingResultBookingCode(res.getBookingCode().getValue(), res.getTransactionId().getValue());
    		bookingResultDao.updateBookingResultFlag(Constant.BookingProcess.FLAG_PAID, res.getTransactionId().getValue());
    		inquiryResultDao.deleteTemporaryInquiryResult(msisdn, "P");
    	} catch (Exception e){
    		e.printStackTrace();
    		log.error(e.getMessage());
    	}
    	
    	//System.out.println("STEPS = BUILDING MESSAGE RESPONSE");
    	    	
    	response = res.getMessage().getValue();
    	//System.out.println("RESPONSE MSG = " + response);
    	return response;
    	
    }

	public void run() {
		// TODO Auto-generated method stub
		String response="";
		HashMap<String, String> responseMap = null;
		
		log.info("Execute worker...");
		
		if(message.startsWith(Constant.MessageParser.STARTS_WITH_LION) || message.startsWith(Constant.MessageParser.STARTS_WITH_BATIK)){
			log.info("Proceeding with inquiry process with msisdn : " + msisdn + " and message :" + message);
        	response = Worker.flightInquiryProcess(message, msisdn);
        	log.info("Inquiry result for msisdn : " + msisdn + " and message :" + response);
        } else if(message.startsWith(Constant.MessageParser.STARTS_WITH_BOOKING)){
        	log.info("Proceeding with reservation process with msisdn : " + msisdn + " and message :" + message);
        	response = Worker.flightBookingProcess(message, msisdn);
        	log.info("Reservation result for msisdn : " + msisdn + " and message :" + response);
        } else if(message.startsWith(Constant.MessageParser.STARTS_WITH_PAX)){
        	log.info("Proceeding with PaxInfo process with msisdn : " + msisdn + " and message :" + message);
        	response = Worker.paxInfoReservationDetails(message, msisdn);
        	log.info("PaxInfo result for msisdn : " + msisdn + " and message :" + response);
        } else if(message.equals(Constant.MessageParser.STARTS_WITH_PAY)){
        	log.info("Proceeding with Payment Notification process with TrxId : " + trxId);
        	response = Worker.paymentNotification(trxId,msisdn);
        	log.info("Payment Notification result for TrxId : " + trxId + " and message :" + response);
        } else {
        	log.info("Receiving unknown command from : " + msisdn +" says :" + message);
        	response = Constant.Validation.INQUIRY_PATTERN_ERROR_MSG;
        	log.info("Response for unknown command from : " + msisdn +" says :" + response);
        }
		
		//System.out.println("STEPS = BEGIN REPLY MESSAGE");
        
        responseMap = new HashMap<String, String>();
        responseMap.put("msisdn", msisdn);
        responseMap.put("message", response);
        
        log.info("Sending response to SMS Gateway...");
        try {
			QueueSender.sendMessageToInboundQueue(responseMap);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return;
		}
              
        log.info("Response has been sent");
        
        return;
        	//Thread.currentThread().interrupt();        
	}
	
}

package com.brightrich.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.brightrich.model.BookingResult;
import com.brightrich.model.InquiryResult;
import com.brightrich.util.Constant;
import com.lion.model.xsd.BookingResponse;
import com.lion.model.xsd.Inquiry;
import com.lion.model.xsd.InquiryResponse;
import com.lion.model.xsd.ObjectFactory;
import com.lion.model.xsd.Pax;
import com.lion.model.xsd.PaxDetailResponse;
import com.lion.model.xsd.PaymentNotificationResponse;
import com.lion.model.xsd.Schedule;
import com.lion.model.xsd.Transaction;
import com.lion.stub.LionStubWS;
import com.lion.stub.LionStubWSPortType;

public class LionAirService {
	
	private static LionStubWS ws = new LionStubWS();
	private static LionStubWSPortType service = ws.getLionStubWSHttpSoap11Endpoint();

	public static List<InquiryResult> invokeFlightInquiryService(HashMap<String, String> parsedMap, String msisdn){
    	//LionStubWS ws = new LionStubWS();
		//LionStubWSPortType service = ws.getLionStubWSHttpSoap11Endpoint();		
		
		ObjectFactory fact = new ObjectFactory();
		Inquiry inq = fact.createInquiry();
		
		inq.setAirlines(fact.createInquiryAirlines(parsedMap.get(Constant.MessageParser.FlightInquiry.AIRLINES)));
		inq.setDepartureDate(fact.createInquiryDepartureDate(parsedMap.get(Constant.MessageParser.FlightInquiry.OUTBOUND_DATE)+" "+Constant.Validation.monthMapIDtoEN.get(parsedMap.get(Constant.MessageParser.FlightInquiry.OUTBOUND_MONTH))));
		inq.setDestination(fact.createInquiryDestination(parsedMap.get(Constant.MessageParser.FlightInquiry.DESTINATION)));
		inq.setFlightClass(fact.createInquiryFlightClass(parsedMap.get(Constant.MessageParser.FlightInquiry.FLIGHT_CLASS)));
		inq.setFlightType(fact.createInquiryFlightType(parsedMap.get(Constant.MessageParser.FLIGHT_TYPE)));
		inq.setNumOfPax(fact.createInquiryNumOfPax(parsedMap.get(Constant.MessageParser.FlightInquiry.NUM_OF_PAX)));
		inq.setOrigin(fact.createInquiryOrigin(parsedMap.get(Constant.MessageParser.FlightInquiry.ORIGIN)));
		inq.setOutboundTimeRange(fact.createInquiryOutboundTimeRange(parsedMap.get(Constant.MessageParser.FlightInquiry.OUTBOUND_TIME_RANGE)));
		inq.setReturnDate(fact.createInquiryReturnDate(parsedMap.get(Constant.MessageParser.FlightInquiry.RETURN_DATE) + " " + Constant.Validation.monthMapIDtoEN.get(parsedMap.get(Constant.MessageParser.FlightInquiry.RETURN_MONTH))));
		inq.setReturnTimeRange(fact.createInquiryReturnTimeRange(parsedMap.get(Constant.MessageParser.FlightInquiry.RETURN_TIME_RANGE)));
		inq.setMsisdn(fact.createInquiryMsisdn(msisdn));
		
		InquiryResponse res = service.flightInquiry(inq);					
		List<InquiryResult> listResult = new ArrayList<InquiryResult>();
				
		for (Schedule o : res.getOutboundSchedules()) {
			InquiryResult r = new InquiryResult();
			r.setAirlines(res.getAirlines().getValue());			
	        r.setArrivalTime(o.getArrivalTime().getValue());
	        r.setDepartureDate(res.getDepartureDate().getValue());
	        r.setDepartureTime(o.getDepartureTime().getValue());
	        r.setDestination(res.getDestination().getValue());	        
	        r.setFlightClass(res.getFlightClass().getValue());
	        r.setFlightKey(o.getFlightKey().getValue());
	        r.setFlightNumber(o.getFlightNumber().getValue());
	        r.setFlightType(Constant.InquiryProcess.OUTBOUND_TYPE);	        
	        r.setMsisdn(msisdn);
	        r.setNumOfPax(res.getNumOfPax().getValue());
	        r.setOrigin(res.getOrigin().getValue());
	        r.setOutboundTimeRange(res.getOutboundTimeRange().getValue());
	        r.setPrice(o.getPrice().getValue());
	        r.setReturnDate(res.getReturnDate().getValue());
	        r.setReturnTimeRange(res.getReturnTimeRange().getValue());			
	        listResult.add(r);
		}
		
		for (Schedule r : res.getReturnSchedules()) {
			InquiryResult i = new InquiryResult();
			i.setAirlines(res.getAirlines().getValue());			
	        i.setArrivalTime(r.getArrivalTime().getValue());
	        i.setDepartureDate(res.getDepartureDate().getValue());
	        i.setDepartureTime(r.getDepartureTime().getValue());
	        i.setDestination(res.getDestination().getValue());	        
	        i.setFlightClass(res.getFlightClass().getValue());
	        i.setFlightKey(r.getFlightKey().getValue());
	        i.setFlightNumber(r.getFlightNumber().getValue());
	        i.setFlightType(Constant.InquiryProcess.RETURN_TYPE);	        
	        i.setMsisdn(msisdn);
	        i.setNumOfPax(res.getNumOfPax().getValue());
	        i.setOrigin(res.getOrigin().getValue());
	        i.setOutboundTimeRange(res.getOutboundTimeRange().getValue());
	        i.setPrice(r.getPrice().getValue());
	        i.setReturnDate(res.getReturnDate().getValue());
	        i.setReturnTimeRange(res.getReturnTimeRange().getValue());			
	        listResult.add(i);
		}
		
			return listResult;
    }
	
	public static BookingResult invokeFlightReservationService(HashMap<String, String> parsedMap, String msisdn, InquiryResult out, InquiryResult ret) throws DatatypeConfigurationException{
    	
    	
    	//LionStubWS ws = new LionStubWS();
		//LionStubWSPortType service = ws.getLionStubWSHttpSoap11Endpoint();
		ObjectFactory fact = new ObjectFactory();
		Transaction trx = fact.createTransaction();
    			    	    		    	
    	trx.setAirlines(fact.createTransactionAirlines(out.getAirlines()));
    	trx.setBookingCode(fact.createTransactionBookingCode(""));

		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		trx.setBookingDate(fact.createTransactionBookingDate(date));
		
    	trx.setDepartureDate(fact.createTransactionDepartureDate(out.getDepartureDate()));
    	trx.setOutboundDepartureTime(fact.createTransactionOutboundDepartureTime(out.getDepartureTime()));
    	trx.setDestination(fact.createTransactionDestination(out.getDestination()));
    	trx.setFlag(fact.createTransactionFlag(""));
    	trx.setFlightClass(fact.createTransactionFlightClass(out.getFlightClass()));
    	trx.setFlightType(fact.createTransactionFlightType(parsedMap.get(Constant.MessageParser.FLIGHT_TYPE)));
    	trx.setMsisdn(fact.createTransactionMsisdn(msisdn));
    	
    	trx.setNumOfPax(fact.createTransactionNumOfPax(out.getNumOfPax()));
    	trx.setOrigin(fact.createTransactionOrigin(out.getOrigin()));
    	trx.setOutboundFlightNumber(fact.createTransactionOutboundFlightNumber(out.getFlightNumber()));
    	trx.setPaymentCode(fact.createTransactionPaymentCode(""));    	    	
    	
    	trx.setTotalFare(fact.createTransactionTotalFare(""));
    	trx.setTransactionId(fact.createTransactionTransactionId(""));
    		
    	trx.setReturnDate(fact.createTransactionReturnDate(ret!=null?ret.getReturnDate():""));
    	trx.setReturnFlightNumber(fact.createTransactionReturnFlightNumber(ret!=null?ret.getFlightNumber():""));
    	trx.setReturnDepartureTime(fact.createTransactionReturnDepartureTime(ret!=null?ret.getDepartureTime():""));
    	trx.setReturnArrivalTime(fact.createTransactionReturnArrivalTime(ret!=null?ret.getArrivalTime():""));
    	trx.setOutboundArrivalTime(fact.createTransactionOutboundArrivalTime(out.getArrivalTime()));
    				
    	
    	BookingResponse br = service.flightReservation(trx);
		BookingResult res = new BookingResult();
		res.setAirlines(br.getAirlines().getValue());
		res.setBookingCode(br.getBookingCode().getValue());
		res.setBookingDate(br.getBookingDate().getValue().toGregorianCalendar().getTime());
		res.setDepartureDate(br.getDepartureDate().getValue());
		res.setOutboundDepartureTime(br.getOutboundDepartureTime().getValue());
		res.setDestination(br.getDestination().getValue());
		res.setFlag(br.getFlag().getValue());
		res.setFlightClass(br.getFlightClass().getValue());
		res.setFlightType(br.getFlightType().getValue());
		res.setMsisdn(br.getMsisdn().getValue());
		res.setNumOfPax(br.getNumOfPax().getValue());
		res.setOrigin(br.getOrigin().getValue());
		res.setOutboundFlightNumber(br.getOutboundFlightNumber().getValue());
		res.setPaymentCode(br.getPaymentCode().getValue());
		res.setReturnDate(br.getReturnDate().getValue());
		res.setReturnFlightNumber(br.getReturnFlightNumber().getValue());
		res.setReturnDepartureTime(br.getReturnDepartureTime().getValue());
		res.setTotalFare(br.getTotalFare().getValue());
		res.setTransactionId(br.getTransactionId().getValue());
    	res.setOutboundArrivalTime(br.getOutboundArrivalTime().getValue());
    	res.setReturnArrivalTime(br.getReturnArrivalTime().getValue());
    	
    	//set transient fields
    	res.setBaseFare(Constant.Common.numberFormatIDR.format(new BigDecimal(br.getBaseFare().getValue())).replace(Constant.Common.RP, Constant.Common.RP+" ").replace(Constant.Common.DEC_DIGIT,""));
    	res.setAdditionalFees(Constant.Common.numberFormatIDR.format(new BigDecimal(br.getAdditionalFees().getValue())).replace(Constant.Common.RP, Constant.Common.RP+" ").replace(Constant.Common.DEC_DIGIT, ""));
		
		return res;
    }		
	
	public static PaxDetailResponse invokePaxDetails(List<Pax> paxList){
		
		PaxDetailResponse response = service.paxInfoReservationDetails(paxList);
		return response;
	}
	
	public static PaymentNotificationResponse invokePaymentNotification(String transactionId){		
		
		PaymentNotificationResponse response = service.paymentReceivedNotification(transactionId);
		return response;
	}
	
}

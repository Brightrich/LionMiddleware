package com.brightrich.model;

import java.util.Date;

public class BookingResult {

	private String transactionId;
	private String bookingCode;
	private String outboundFlightNumber;
	private String returnFlightNumber;
	private String departureDate;
	private String outboundDepartureTime;
	private String returnDepartureTime;
	private String returnDate;		
	private String flightType;
	private String numOfPax;
	private String totalFare;	
	private String origin;
	private String destination;
	private String msisdn;
	private String airlines;
	private Date bookingDate;
	private String flag;	
	
	private String paymentCode;
	private String flightClass;
	private String outboundArrivalTime;
	private String returnArrivalTime;
	
	//TRANSIENT FIELDS
	private String baseFare;
	private String additionalFees;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getBookingCode() {
		return bookingCode;
	}
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	public String getOutboundFlightNumber() {
		return outboundFlightNumber;
	}
	public void setOutboundFlightNumber(String outboundFlightNumber) {
		this.outboundFlightNumber = outboundFlightNumber;
	}
	public String getReturnFlightNumber() {
		return returnFlightNumber;
	}
	public void setReturnFlightNumber(String returnFlightNumber) {
		this.returnFlightNumber = returnFlightNumber;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}	
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	public String getNumOfPax() {
		return numOfPax;
	}
	public void setNumOfPax(String numOfPax) {
		this.numOfPax = numOfPax;
	}
	public String getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(String totalFare) {
		this.totalFare = totalFare;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public String getOutboundDepartureTime() {
		return outboundDepartureTime;
	}
	public void setOutboundDepartureTime(String outboundDepartureTime) {
		this.outboundDepartureTime = outboundDepartureTime;
	}
	public String getReturnDepartureTime() {
		return returnDepartureTime;
	}
	public void setReturnDepartureTime(String returnDepartureTime) {
		this.returnDepartureTime = returnDepartureTime;
	}
	public String getOutboundArrivalTime() {
		return outboundArrivalTime;
	}
	public void setOutboundArrivalTime(String outboundArrivalTime) {
		this.outboundArrivalTime = outboundArrivalTime;
	}
	public String getReturnArrivalTime() {
		return returnArrivalTime;
	}
	public void setReturnArrivalTime(String returnArrivalTime) {
		this.returnArrivalTime = returnArrivalTime;
	}
	public String getBaseFare() {
		return baseFare;
	}
	public void setBaseFare(String baseFare) {
		this.baseFare = baseFare;
	}
	public String getAdditionalFees() {
		return additionalFees;
	}
	public void setAdditionalFees(String additionalFees) {
		this.additionalFees = additionalFees;
	}
	
	
	
}

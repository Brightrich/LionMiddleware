package com.brightrich.model;

import java.math.BigDecimal;

import com.brightrich.util.Constant;

public class InquiryResult {

	private String id;
	private String msisdn;
	private String origin;
	private String destination;
	private String flightType;
	private String departureDate;
	private String returnDate;
	private String airlines;
	private String flightClass;
	private String numOfPax;
	private String outboundTimeRange;
	private String returnTimeRange;
	private String flightKey;
	private String flightNumber;
	private String departureTime;
	private String arrivalTime;
	private String price;
	private String flag;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
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
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
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
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public String getNumOfPax() {
		return numOfPax;
	}
	public void setNumOfPax(String numOfPax) {
		this.numOfPax = numOfPax;
	}
	public String getOutboundTimeRange() {
		return outboundTimeRange;
	}
	public void setOutboundTimeRange(String outboundTimeRange) {
		this.outboundTimeRange = outboundTimeRange;
	}
	public String getReturnTimeRange() {
		return returnTimeRange;
	}
	public void setReturnTimeRange(String returnTimeRange) {
		this.returnTimeRange = returnTimeRange;
	}
	public String getFlightKey() {
		return flightKey;
	}
	public void setFlightKey(String flightKey) {
		this.flightKey = flightKey;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String generateSMSResponse() {
		StringBuilder builder = new StringBuilder();
		builder.append(flightKey);
		builder.append(" ");		
		builder.append(flightNumber);
		builder.append(" ");
		builder.append(departureTime);
		builder.append(" - ");
		builder.append(arrivalTime);
		builder.append(" ");
		builder.append((Constant.Common.numberFormatIDR.format(new BigDecimal(price))).replace(Constant.Common.RP, Constant.Common.RP+" ").replace(Constant.Common.DEC_DIGIT, ""));
		builder.append("\n");
		return builder.toString();
	}
	
	
	
}

package com.brightrich.smsgateway.pojo;

import java.io.Serializable;

public class MessageObject implements Serializable{

	private String msisdn;
	private String message;
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

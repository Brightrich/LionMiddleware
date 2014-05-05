package com.brightrich.smsgateway.pojo;

public class Status {

	private String manufacture;
	private String model;
	private String serialNo;
	private String simImsi;
	private int signal;
	private int battery;
	
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getSimImsi() {
		return simImsi;
	}
	public void setSimImsi(String simImsi) {
		this.simImsi = simImsi;
	}
	public int getSignal() {
		return signal;
	}
	public void setSignal(int signal) {
		this.signal = signal;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	
}

package com.brightrich.controller;

import java.util.List;

import com.brightrich.model.BookingResult;

public class Form {

	private String selectedTrx;
	private List<BookingResult> unpaidTransactionList;
	public String getSelectedTrx() {
		return selectedTrx;
	}
	public void setSelectedTrx(String selectedTrx) {
		this.selectedTrx = selectedTrx;
	}
	public List<BookingResult> getUnpaidTransactionList() {
		return unpaidTransactionList;
	}
	public void setUnpaidTransactionList(List<BookingResult> unpaidTransactionList) {
		this.unpaidTransactionList = unpaidTransactionList;
	}
	
}

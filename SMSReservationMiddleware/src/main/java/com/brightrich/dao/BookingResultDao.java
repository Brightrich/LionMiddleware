package com.brightrich.dao;

import java.util.List;

import com.brightrich.model.BookingResult;

public interface BookingResultDao {
	public void saveBookingResult(BookingResult r);
    public BookingResult getLatestBookingResult(String msisdn);
    public BookingResult getBookingResult(String trxId);
    public void updateBookingResultFlag(String status, String transactionId);
    public void updateBookingResultPaymentCode(String paymentCode, String transactionId);
    public void updateBookingResultBookingCode(String bookingCode,String transactionId);
    public List<BookingResult> getUnpaidBooking();
}

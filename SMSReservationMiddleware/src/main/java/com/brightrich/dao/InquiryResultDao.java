package com.brightrich.dao;

import java.util.List;

import com.brightrich.model.InquiryResult;


public interface InquiryResultDao {
	public void saveInquiryResult(List<InquiryResult> irList);
    public InquiryResult getInquiryResult(String msisdn, String flightKey, String flightType);
    public void updateInquiryResultFlag(String status, String inqId);
    public void deleteTemporaryInquiryResult(String msisdn, String flag);
    public InquiryResult getInquiryResultWithTypeAndKey(String msisdn, String flightTypeAndKey);
}

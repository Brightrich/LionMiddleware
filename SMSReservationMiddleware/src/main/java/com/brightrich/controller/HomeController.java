package com.brightrich.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.brightrich.dao.BookingResultDao;
import com.brightrich.dao.InquiryResultDao;
import com.brightrich.model.BookingResult;
import com.brightrich.service.Worker;
import com.brightrich.util.Constant;

@Controller
public class HomeController {

	@Autowired
	private BookingResultDao bookingResultDao;
	@Autowired
	private InquiryResultDao inquiryResultDao;
	
	private Form form;
	
	@RequestMapping("/home")
	public ModelAndView homePage(ModelAndView mav){
		mav.setViewName("home");
		form = new Form();
		form.setUnpaidTransactionList(bookingResultDao.getUnpaidBooking());		
		System.out.println("LIST SIZE = " + form.getUnpaidTransactionList().size());
		mav.addObject("form", form);						
		return mav;
	}
	
	
	@RequestMapping("/submitPaymentConfirmation.do")
	public ModelAndView submitPaymentConfirmation(HttpServletRequest request, ModelAndView mav) throws InterruptedException{
		mav.setViewName("/home");		
		String selectedTrx = request.getParameter("selectedTrx");
		String selectedMsisdn = request.getParameter("selectedMsisdn");
		
		BookingResult br = bookingResultDao.getBookingResult(selectedTrx);
		
		new Thread(new Worker(Constant.MessageParser.STARTS_WITH_PAY,br.getMsisdn(),selectedTrx, inquiryResultDao, bookingResultDao)).start();
		Thread.sleep(5000L);
		return mav;
	}
}

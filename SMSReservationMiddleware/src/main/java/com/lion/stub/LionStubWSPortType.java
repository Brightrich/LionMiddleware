
package com.lion.stub;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.lion.model.xsd.BookingResponse;
import com.lion.model.xsd.Inquiry;
import com.lion.model.xsd.InquiryResponse;
import com.lion.model.xsd.Pax;
import com.lion.model.xsd.PaxDetailResponse;
import com.lion.model.xsd.PaymentNotificationResponse;
import com.lion.model.xsd.Transaction;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LionStubWSPortType", targetNamespace = "http://stub.lion.com")
@XmlSeeAlso({
    com.lion.model.xsd.ObjectFactory.class,
    com.lion.stub.ObjectFactory.class
})
public interface LionStubWSPortType {


    /**
     * 
     * @param param0
     * @return
     *     returns com.lion.model.xsd.BookingResponse
     */
    @WebMethod(action = "urn:flightReservation")
    @WebResult(targetNamespace = "http://stub.lion.com")
    @RequestWrapper(localName = "flightReservation", targetNamespace = "http://stub.lion.com", className = "com.lion.stub.FlightReservation")
    @ResponseWrapper(localName = "flightReservationResponse", targetNamespace = "http://stub.lion.com", className = "com.lion.stub.FlightReservationResponse")
    public BookingResponse flightReservation(
        @WebParam(name = "param0", targetNamespace = "http://stub.lion.com")
        Transaction param0);

    /**
     * 
     * @param param0
     * @return
     *     returns com.lion.model.xsd.PaxDetailResponse
     */
    @WebMethod(action = "urn:paxInfoReservationDetails")
    @WebResult(targetNamespace = "http://stub.lion.com")
    @RequestWrapper(localName = "paxInfoReservationDetails", targetNamespace = "http://stub.lion.com", className = "com.lion.stub.PaxInfoReservationDetails")
    @ResponseWrapper(localName = "paxInfoReservationDetailsResponse", targetNamespace = "http://stub.lion.com", className = "com.lion.stub.PaxInfoReservationDetailsResponse")
    public PaxDetailResponse paxInfoReservationDetails(
        @WebParam(name = "param0", targetNamespace = "http://stub.lion.com")
        List<Pax> param0);

    /**
     * 
     * @param param0
     * @return
     *     returns com.lion.model.xsd.InquiryResponse
     */
    @WebMethod(action = "urn:flightInquiry")
    @WebResult(targetNamespace = "http://stub.lion.com")
    @RequestWrapper(localName = "flightInquiry", targetNamespace = "http://stub.lion.com", className = "com.lion.stub.FlightInquiry")
    @ResponseWrapper(localName = "flightInquiryResponse", targetNamespace = "http://stub.lion.com", className = "com.lion.stub.FlightInquiryResponse")
    public InquiryResponse flightInquiry(
        @WebParam(name = "param0", targetNamespace = "http://stub.lion.com")
        Inquiry param0);

    /**
     * 
     * @param param0
     * @return
     *     returns com.lion.model.xsd.PaymentNotificationResponse
     */
    @WebMethod(action = "urn:paymentReceivedNotification")
    @WebResult(targetNamespace = "http://stub.lion.com")
    @RequestWrapper(localName = "paymentReceivedNotification", targetNamespace = "http://stub.lion.com", className = "com.lion.stub.PaymentReceivedNotification")
    @ResponseWrapper(localName = "paymentReceivedNotificationResponse", targetNamespace = "http://stub.lion.com", className = "com.lion.stub.PaymentReceivedNotificationResponse")
    public PaymentNotificationResponse paymentReceivedNotification(
        @WebParam(name = "param0", targetNamespace = "http://stub.lion.com")
        String param0);

}

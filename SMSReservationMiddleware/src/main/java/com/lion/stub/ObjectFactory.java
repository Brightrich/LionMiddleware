
package com.lion.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.lion.model.xsd.BookingResponse;
import com.lion.model.xsd.Inquiry;
import com.lion.model.xsd.InquiryResponse;
import com.lion.model.xsd.PaxDetailResponse;
import com.lion.model.xsd.PaymentNotificationResponse;
import com.lion.model.xsd.Transaction;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lion.stub package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FlightInquiryResponseReturn_QNAME = new QName("http://stub.lion.com", "return");
    private final static QName _PaymentReceivedNotificationParam0_QNAME = new QName("http://stub.lion.com", "param0");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lion.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PaymentReceivedNotificationResponse }
     * 
     */
    public PaymentReceivedNotificationResponse createPaymentReceivedNotificationResponse() {
        return new PaymentReceivedNotificationResponse();
    }

    /**
     * Create an instance of {@link FlightInquiryResponse }
     * 
     */
    public FlightInquiryResponse createFlightInquiryResponse() {
        return new FlightInquiryResponse();
    }

    /**
     * Create an instance of {@link FlightInquiry }
     * 
     */
    public FlightInquiry createFlightInquiry() {
        return new FlightInquiry();
    }

    /**
     * Create an instance of {@link FlightReservation }
     * 
     */
    public FlightReservation createFlightReservation() {
        return new FlightReservation();
    }

    /**
     * Create an instance of {@link PaxInfoReservationDetailsResponse }
     * 
     */
    public PaxInfoReservationDetailsResponse createPaxInfoReservationDetailsResponse() {
        return new PaxInfoReservationDetailsResponse();
    }

    /**
     * Create an instance of {@link PaymentReceivedNotification }
     * 
     */
    public PaymentReceivedNotification createPaymentReceivedNotification() {
        return new PaymentReceivedNotification();
    }

    /**
     * Create an instance of {@link PaxInfoReservationDetails }
     * 
     */
    public PaxInfoReservationDetails createPaxInfoReservationDetails() {
        return new PaxInfoReservationDetails();
    }

    /**
     * Create an instance of {@link FlightReservationResponse }
     * 
     */
    public FlightReservationResponse createFlightReservationResponse() {
        return new FlightReservationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InquiryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stub.lion.com", name = "return", scope = FlightInquiryResponse.class)
    public JAXBElement<InquiryResponse> createFlightInquiryResponseReturn(InquiryResponse value) {
        return new JAXBElement<InquiryResponse>(_FlightInquiryResponseReturn_QNAME, InquiryResponse.class, FlightInquiryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaxDetailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stub.lion.com", name = "return", scope = PaxInfoReservationDetailsResponse.class)
    public JAXBElement<PaxDetailResponse> createPaxInfoReservationDetailsResponseReturn(PaxDetailResponse value) {
        return new JAXBElement<PaxDetailResponse>(_FlightInquiryResponseReturn_QNAME, PaxDetailResponse.class, PaxInfoReservationDetailsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stub.lion.com", name = "param0", scope = PaymentReceivedNotification.class)
    public JAXBElement<String> createPaymentReceivedNotificationParam0(String value) {
        return new JAXBElement<String>(_PaymentReceivedNotificationParam0_QNAME, String.class, PaymentReceivedNotification.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stub.lion.com", name = "return", scope = FlightReservationResponse.class)
    public JAXBElement<BookingResponse> createFlightReservationResponseReturn(BookingResponse value) {
        return new JAXBElement<BookingResponse>(_FlightInquiryResponseReturn_QNAME, BookingResponse.class, FlightReservationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Inquiry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stub.lion.com", name = "param0", scope = FlightInquiry.class)
    public JAXBElement<Inquiry> createFlightInquiryParam0(Inquiry value) {
        return new JAXBElement<Inquiry>(_PaymentReceivedNotificationParam0_QNAME, Inquiry.class, FlightInquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stub.lion.com", name = "param0", scope = FlightReservation.class)
    public JAXBElement<Transaction> createFlightReservationParam0(Transaction value) {
        return new JAXBElement<Transaction>(_PaymentReceivedNotificationParam0_QNAME, Transaction.class, FlightReservation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentNotificationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stub.lion.com", name = "return", scope = PaymentReceivedNotificationResponse.class)
    public JAXBElement<PaymentNotificationResponse> createPaymentReceivedNotificationResponseReturn(PaymentNotificationResponse value) {
        return new JAXBElement<PaymentNotificationResponse>(_FlightInquiryResponseReturn_QNAME, PaymentNotificationResponse.class, PaymentReceivedNotificationResponse.class, value);
    }

}

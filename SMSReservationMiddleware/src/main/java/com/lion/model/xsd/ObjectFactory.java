
package com.lion.model.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lion.model.xsd package. 
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

    private final static QName _ScheduleFlightNumber_QNAME = new QName("http://model.lion.com/xsd", "flightNumber");
    private final static QName _ScheduleDepartureTime_QNAME = new QName("http://model.lion.com/xsd", "departureTime");
    private final static QName _ScheduleFlightKey_QNAME = new QName("http://model.lion.com/xsd", "flightKey");
    private final static QName _SchedulePrice_QNAME = new QName("http://model.lion.com/xsd", "price");
    private final static QName _ScheduleArrivalTime_QNAME = new QName("http://model.lion.com/xsd", "arrivalTime");
    private final static QName _InquiryOrigin_QNAME = new QName("http://model.lion.com/xsd", "origin");
    private final static QName _InquiryReturnTimeRange_QNAME = new QName("http://model.lion.com/xsd", "returnTimeRange");
    private final static QName _InquiryDestination_QNAME = new QName("http://model.lion.com/xsd", "destination");
    private final static QName _InquiryOutboundTimeRange_QNAME = new QName("http://model.lion.com/xsd", "outboundTimeRange");
    private final static QName _InquiryReturnDate_QNAME = new QName("http://model.lion.com/xsd", "returnDate");
    private final static QName _InquiryFlightClass_QNAME = new QName("http://model.lion.com/xsd", "flightClass");
    private final static QName _InquiryFlightType_QNAME = new QName("http://model.lion.com/xsd", "flightType");
    private final static QName _InquiryNumOfPax_QNAME = new QName("http://model.lion.com/xsd", "numOfPax");
    private final static QName _InquiryMsisdn_QNAME = new QName("http://model.lion.com/xsd", "msisdn");
    private final static QName _InquiryAirlines_QNAME = new QName("http://model.lion.com/xsd", "airlines");
    private final static QName _InquiryDepartureDate_QNAME = new QName("http://model.lion.com/xsd", "departureDate");
    private final static QName _PaxDetailResponsePaymentCode_QNAME = new QName("http://model.lion.com/xsd", "paymentCode");
    private final static QName _PaxDetailResponseTransactionId_QNAME = new QName("http://model.lion.com/xsd", "transactionId");
    private final static QName _PaxDetailResponseMessage_QNAME = new QName("http://model.lion.com/xsd", "message");
    private final static QName _TransactionOutboundFlightNumber_QNAME = new QName("http://model.lion.com/xsd", "outboundFlightNumber");
    private final static QName _TransactionTotalFare_QNAME = new QName("http://model.lion.com/xsd", "totalFare");
    private final static QName _TransactionFlag_QNAME = new QName("http://model.lion.com/xsd", "flag");
    private final static QName _TransactionOutboundArrivalTime_QNAME = new QName("http://model.lion.com/xsd", "outboundArrivalTime");
    private final static QName _TransactionBookingCode_QNAME = new QName("http://model.lion.com/xsd", "bookingCode");
    private final static QName _TransactionBookingDate_QNAME = new QName("http://model.lion.com/xsd", "bookingDate");
    private final static QName _TransactionReturnDepartureTime_QNAME = new QName("http://model.lion.com/xsd", "returnDepartureTime");
    private final static QName _TransactionOutboundDepartureTime_QNAME = new QName("http://model.lion.com/xsd", "outboundDepartureTime");
    private final static QName _TransactionReturnFlightNumber_QNAME = new QName("http://model.lion.com/xsd", "returnFlightNumber");
    private final static QName _TransactionReturnArrivalTime_QNAME = new QName("http://model.lion.com/xsd", "returnArrivalTime");
    private final static QName _BookingResponseBaseFare_QNAME = new QName("http://model.lion.com/xsd", "baseFare");
    private final static QName _BookingResponseAdditionalFees_QNAME = new QName("http://model.lion.com/xsd", "additionalFees");
    private final static QName _PaxTitle_QNAME = new QName("http://model.lion.com/xsd", "title");
    private final static QName _PaxPaxName_QNAME = new QName("http://model.lion.com/xsd", "paxName");
    private final static QName _PaxPaxSSN_QNAME = new QName("http://model.lion.com/xsd", "paxSSN");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lion.model.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PaymentNotificationResponse }
     * 
     */
    public PaymentNotificationResponse createPaymentNotificationResponse() {
        return new PaymentNotificationResponse();
    }

    /**
     * Create an instance of {@link InquiryResponse }
     * 
     */
    public InquiryResponse createInquiryResponse() {
        return new InquiryResponse();
    }

    /**
     * Create an instance of {@link Inquiry }
     * 
     */
    public Inquiry createInquiry() {
        return new Inquiry();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link PaxDetailResponse }
     * 
     */
    public PaxDetailResponse createPaxDetailResponse() {
        return new PaxDetailResponse();
    }

    /**
     * Create an instance of {@link Pax }
     * 
     */
    public Pax createPax() {
        return new Pax();
    }

    /**
     * Create an instance of {@link BookingResponse }
     * 
     */
    public BookingResponse createBookingResponse() {
        return new BookingResponse();
    }

    /**
     * Create an instance of {@link Schedule }
     * 
     */
    public Schedule createSchedule() {
        return new Schedule();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "flightNumber", scope = Schedule.class)
    public JAXBElement<String> createScheduleFlightNumber(String value) {
        return new JAXBElement<String>(_ScheduleFlightNumber_QNAME, String.class, Schedule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "departureTime", scope = Schedule.class)
    public JAXBElement<String> createScheduleDepartureTime(String value) {
        return new JAXBElement<String>(_ScheduleDepartureTime_QNAME, String.class, Schedule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "flightKey", scope = Schedule.class)
    public JAXBElement<String> createScheduleFlightKey(String value) {
        return new JAXBElement<String>(_ScheduleFlightKey_QNAME, String.class, Schedule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "price", scope = Schedule.class)
    public JAXBElement<String> createSchedulePrice(String value) {
        return new JAXBElement<String>(_SchedulePrice_QNAME, String.class, Schedule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "arrivalTime", scope = Schedule.class)
    public JAXBElement<String> createScheduleArrivalTime(String value) {
        return new JAXBElement<String>(_ScheduleArrivalTime_QNAME, String.class, Schedule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "origin", scope = Inquiry.class)
    public JAXBElement<String> createInquiryOrigin(String value) {
        return new JAXBElement<String>(_InquiryOrigin_QNAME, String.class, Inquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "returnTimeRange", scope = Inquiry.class)
    public JAXBElement<String> createInquiryReturnTimeRange(String value) {
        return new JAXBElement<String>(_InquiryReturnTimeRange_QNAME, String.class, Inquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "destination", scope = Inquiry.class)
    public JAXBElement<String> createInquiryDestination(String value) {
        return new JAXBElement<String>(_InquiryDestination_QNAME, String.class, Inquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "outboundTimeRange", scope = Inquiry.class)
    public JAXBElement<String> createInquiryOutboundTimeRange(String value) {
        return new JAXBElement<String>(_InquiryOutboundTimeRange_QNAME, String.class, Inquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "returnDate", scope = Inquiry.class)
    public JAXBElement<String> createInquiryReturnDate(String value) {
        return new JAXBElement<String>(_InquiryReturnDate_QNAME, String.class, Inquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "flightClass", scope = Inquiry.class)
    public JAXBElement<String> createInquiryFlightClass(String value) {
        return new JAXBElement<String>(_InquiryFlightClass_QNAME, String.class, Inquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "flightType", scope = Inquiry.class)
    public JAXBElement<String> createInquiryFlightType(String value) {
        return new JAXBElement<String>(_InquiryFlightType_QNAME, String.class, Inquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "numOfPax", scope = Inquiry.class)
    public JAXBElement<String> createInquiryNumOfPax(String value) {
        return new JAXBElement<String>(_InquiryNumOfPax_QNAME, String.class, Inquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "msisdn", scope = Inquiry.class)
    public JAXBElement<String> createInquiryMsisdn(String value) {
        return new JAXBElement<String>(_InquiryMsisdn_QNAME, String.class, Inquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "airlines", scope = Inquiry.class)
    public JAXBElement<String> createInquiryAirlines(String value) {
        return new JAXBElement<String>(_InquiryAirlines_QNAME, String.class, Inquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "departureDate", scope = Inquiry.class)
    public JAXBElement<String> createInquiryDepartureDate(String value) {
        return new JAXBElement<String>(_InquiryDepartureDate_QNAME, String.class, Inquiry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "paymentCode", scope = PaxDetailResponse.class)
    public JAXBElement<String> createPaxDetailResponsePaymentCode(String value) {
        return new JAXBElement<String>(_PaxDetailResponsePaymentCode_QNAME, String.class, PaxDetailResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "transactionId", scope = PaxDetailResponse.class)
    public JAXBElement<String> createPaxDetailResponseTransactionId(String value) {
        return new JAXBElement<String>(_PaxDetailResponseTransactionId_QNAME, String.class, PaxDetailResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "message", scope = PaxDetailResponse.class)
    public JAXBElement<String> createPaxDetailResponseMessage(String value) {
        return new JAXBElement<String>(_PaxDetailResponseMessage_QNAME, String.class, PaxDetailResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "outboundFlightNumber", scope = Transaction.class)
    public JAXBElement<String> createTransactionOutboundFlightNumber(String value) {
        return new JAXBElement<String>(_TransactionOutboundFlightNumber_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "totalFare", scope = Transaction.class)
    public JAXBElement<String> createTransactionTotalFare(String value) {
        return new JAXBElement<String>(_TransactionTotalFare_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "flag", scope = Transaction.class)
    public JAXBElement<String> createTransactionFlag(String value) {
        return new JAXBElement<String>(_TransactionFlag_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "numOfPax", scope = Transaction.class)
    public JAXBElement<String> createTransactionNumOfPax(String value) {
        return new JAXBElement<String>(_InquiryNumOfPax_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "outboundArrivalTime", scope = Transaction.class)
    public JAXBElement<String> createTransactionOutboundArrivalTime(String value) {
        return new JAXBElement<String>(_TransactionOutboundArrivalTime_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "airlines", scope = Transaction.class)
    public JAXBElement<String> createTransactionAirlines(String value) {
        return new JAXBElement<String>(_InquiryAirlines_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "origin", scope = Transaction.class)
    public JAXBElement<String> createTransactionOrigin(String value) {
        return new JAXBElement<String>(_InquiryOrigin_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "paymentCode", scope = Transaction.class)
    public JAXBElement<String> createTransactionPaymentCode(String value) {
        return new JAXBElement<String>(_PaxDetailResponsePaymentCode_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "bookingCode", scope = Transaction.class)
    public JAXBElement<String> createTransactionBookingCode(String value) {
        return new JAXBElement<String>(_TransactionBookingCode_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "destination", scope = Transaction.class)
    public JAXBElement<String> createTransactionDestination(String value) {
        return new JAXBElement<String>(_InquiryDestination_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "returnDate", scope = Transaction.class)
    public JAXBElement<String> createTransactionReturnDate(String value) {
        return new JAXBElement<String>(_InquiryReturnDate_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "flightClass", scope = Transaction.class)
    public JAXBElement<String> createTransactionFlightClass(String value) {
        return new JAXBElement<String>(_InquiryFlightClass_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "bookingDate", scope = Transaction.class)
    public JAXBElement<XMLGregorianCalendar> createTransactionBookingDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TransactionBookingDate_QNAME, XMLGregorianCalendar.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "transactionId", scope = Transaction.class)
    public JAXBElement<String> createTransactionTransactionId(String value) {
        return new JAXBElement<String>(_PaxDetailResponseTransactionId_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "flightType", scope = Transaction.class)
    public JAXBElement<String> createTransactionFlightType(String value) {
        return new JAXBElement<String>(_InquiryFlightType_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "returnDepartureTime", scope = Transaction.class)
    public JAXBElement<String> createTransactionReturnDepartureTime(String value) {
        return new JAXBElement<String>(_TransactionReturnDepartureTime_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "msisdn", scope = Transaction.class)
    public JAXBElement<String> createTransactionMsisdn(String value) {
        return new JAXBElement<String>(_InquiryMsisdn_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "outboundDepartureTime", scope = Transaction.class)
    public JAXBElement<String> createTransactionOutboundDepartureTime(String value) {
        return new JAXBElement<String>(_TransactionOutboundDepartureTime_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "returnFlightNumber", scope = Transaction.class)
    public JAXBElement<String> createTransactionReturnFlightNumber(String value) {
        return new JAXBElement<String>(_TransactionReturnFlightNumber_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "returnArrivalTime", scope = Transaction.class)
    public JAXBElement<String> createTransactionReturnArrivalTime(String value) {
        return new JAXBElement<String>(_TransactionReturnArrivalTime_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "departureDate", scope = Transaction.class)
    public JAXBElement<String> createTransactionDepartureDate(String value) {
        return new JAXBElement<String>(_InquiryDepartureDate_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "baseFare", scope = BookingResponse.class)
    public JAXBElement<String> createBookingResponseBaseFare(String value) {
        return new JAXBElement<String>(_BookingResponseBaseFare_QNAME, String.class, BookingResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "additionalFees", scope = BookingResponse.class)
    public JAXBElement<String> createBookingResponseAdditionalFees(String value) {
        return new JAXBElement<String>(_BookingResponseAdditionalFees_QNAME, String.class, BookingResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "bookingCode", scope = PaymentNotificationResponse.class)
    public JAXBElement<String> createPaymentNotificationResponseBookingCode(String value) {
        return new JAXBElement<String>(_TransactionBookingCode_QNAME, String.class, PaymentNotificationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "transactionId", scope = PaymentNotificationResponse.class)
    public JAXBElement<String> createPaymentNotificationResponseTransactionId(String value) {
        return new JAXBElement<String>(_PaxDetailResponseTransactionId_QNAME, String.class, PaymentNotificationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "message", scope = PaymentNotificationResponse.class)
    public JAXBElement<String> createPaymentNotificationResponseMessage(String value) {
        return new JAXBElement<String>(_PaxDetailResponseMessage_QNAME, String.class, PaymentNotificationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "title", scope = Pax.class)
    public JAXBElement<String> createPaxTitle(String value) {
        return new JAXBElement<String>(_PaxTitle_QNAME, String.class, Pax.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "paxName", scope = Pax.class)
    public JAXBElement<String> createPaxPaxName(String value) {
        return new JAXBElement<String>(_PaxPaxName_QNAME, String.class, Pax.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "transactionId", scope = Pax.class)
    public JAXBElement<String> createPaxTransactionId(String value) {
        return new JAXBElement<String>(_PaxDetailResponseTransactionId_QNAME, String.class, Pax.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.lion.com/xsd", name = "paxSSN", scope = Pax.class)
    public JAXBElement<String> createPaxPaxSSN(String value) {
        return new JAXBElement<String>(_PaxPaxSSN_QNAME, String.class, Pax.class, value);
    }

}

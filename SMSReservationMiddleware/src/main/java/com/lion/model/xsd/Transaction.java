
package com.lion.model.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Transaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Transaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="airlines" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bookingCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bookingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="departureDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flightClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flightType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msisdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numOfPax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outboundArrivalTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outboundDepartureTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outboundFlightNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnArrivalTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnDepartureTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnFlightNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalFare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transaction", propOrder = {
    "airlines",
    "bookingCode",
    "bookingDate",
    "departureDate",
    "destination",
    "flag",
    "flightClass",
    "flightType",
    "msisdn",
    "numOfPax",
    "origin",
    "outboundArrivalTime",
    "outboundDepartureTime",
    "outboundFlightNumber",
    "paymentCode",
    "returnArrivalTime",
    "returnDate",
    "returnDepartureTime",
    "returnFlightNumber",
    "totalFare",
    "transactionId"
})
@XmlSeeAlso({
    BookingResponse.class
})
public class Transaction {

    @XmlElementRef(name = "airlines", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> airlines;
    @XmlElementRef(name = "bookingCode", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bookingCode;
    @XmlElementRef(name = "bookingDate", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> bookingDate;
    @XmlElementRef(name = "departureDate", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> departureDate;
    @XmlElementRef(name = "destination", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> destination;
    @XmlElementRef(name = "flag", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flag;
    @XmlElementRef(name = "flightClass", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flightClass;
    @XmlElementRef(name = "flightType", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flightType;
    @XmlElementRef(name = "msisdn", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> msisdn;
    @XmlElementRef(name = "numOfPax", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> numOfPax;
    @XmlElementRef(name = "origin", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origin;
    @XmlElementRef(name = "outboundArrivalTime", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> outboundArrivalTime;
    @XmlElementRef(name = "outboundDepartureTime", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> outboundDepartureTime;
    @XmlElementRef(name = "outboundFlightNumber", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> outboundFlightNumber;
    @XmlElementRef(name = "paymentCode", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentCode;
    @XmlElementRef(name = "returnArrivalTime", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> returnArrivalTime;
    @XmlElementRef(name = "returnDate", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> returnDate;
    @XmlElementRef(name = "returnDepartureTime", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> returnDepartureTime;
    @XmlElementRef(name = "returnFlightNumber", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> returnFlightNumber;
    @XmlElementRef(name = "totalFare", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> totalFare;
    @XmlElementRef(name = "transactionId", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionId;

    /**
     * Gets the value of the airlines property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAirlines() {
        return airlines;
    }

    /**
     * Sets the value of the airlines property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAirlines(JAXBElement<String> value) {
        this.airlines = value;
    }

    /**
     * Gets the value of the bookingCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBookingCode() {
        return bookingCode;
    }

    /**
     * Sets the value of the bookingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBookingCode(JAXBElement<String> value) {
        this.bookingCode = value;
    }

    /**
     * Gets the value of the bookingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the value of the bookingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setBookingDate(JAXBElement<XMLGregorianCalendar> value) {
        this.bookingDate = value;
    }

    /**
     * Gets the value of the departureDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the value of the departureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDepartureDate(JAXBElement<String> value) {
        this.departureDate = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDestination(JAXBElement<String> value) {
        this.destination = value;
    }

    /**
     * Gets the value of the flag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlag() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlag(JAXBElement<String> value) {
        this.flag = value;
    }

    /**
     * Gets the value of the flightClass property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlightClass() {
        return flightClass;
    }

    /**
     * Sets the value of the flightClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlightClass(JAXBElement<String> value) {
        this.flightClass = value;
    }

    /**
     * Gets the value of the flightType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlightType() {
        return flightType;
    }

    /**
     * Sets the value of the flightType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlightType(JAXBElement<String> value) {
        this.flightType = value;
    }

    /**
     * Gets the value of the msisdn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMsisdn() {
        return msisdn;
    }

    /**
     * Sets the value of the msisdn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMsisdn(JAXBElement<String> value) {
        this.msisdn = value;
    }

    /**
     * Gets the value of the numOfPax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNumOfPax() {
        return numOfPax;
    }

    /**
     * Sets the value of the numOfPax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNumOfPax(JAXBElement<String> value) {
        this.numOfPax = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigin(JAXBElement<String> value) {
        this.origin = value;
    }

    /**
     * Gets the value of the outboundArrivalTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOutboundArrivalTime() {
        return outboundArrivalTime;
    }

    /**
     * Sets the value of the outboundArrivalTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOutboundArrivalTime(JAXBElement<String> value) {
        this.outboundArrivalTime = value;
    }

    /**
     * Gets the value of the outboundDepartureTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOutboundDepartureTime() {
        return outboundDepartureTime;
    }

    /**
     * Sets the value of the outboundDepartureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOutboundDepartureTime(JAXBElement<String> value) {
        this.outboundDepartureTime = value;
    }

    /**
     * Gets the value of the outboundFlightNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOutboundFlightNumber() {
        return outboundFlightNumber;
    }

    /**
     * Sets the value of the outboundFlightNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOutboundFlightNumber(JAXBElement<String> value) {
        this.outboundFlightNumber = value;
    }

    /**
     * Gets the value of the paymentCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentCode() {
        return paymentCode;
    }

    /**
     * Sets the value of the paymentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentCode(JAXBElement<String> value) {
        this.paymentCode = value;
    }

    /**
     * Gets the value of the returnArrivalTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReturnArrivalTime() {
        return returnArrivalTime;
    }

    /**
     * Sets the value of the returnArrivalTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReturnArrivalTime(JAXBElement<String> value) {
        this.returnArrivalTime = value;
    }

    /**
     * Gets the value of the returnDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the value of the returnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReturnDate(JAXBElement<String> value) {
        this.returnDate = value;
    }

    /**
     * Gets the value of the returnDepartureTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReturnDepartureTime() {
        return returnDepartureTime;
    }

    /**
     * Sets the value of the returnDepartureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReturnDepartureTime(JAXBElement<String> value) {
        this.returnDepartureTime = value;
    }

    /**
     * Gets the value of the returnFlightNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReturnFlightNumber() {
        return returnFlightNumber;
    }

    /**
     * Sets the value of the returnFlightNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReturnFlightNumber(JAXBElement<String> value) {
        this.returnFlightNumber = value;
    }

    /**
     * Gets the value of the totalFare property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTotalFare() {
        return totalFare;
    }

    /**
     * Sets the value of the totalFare property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTotalFare(JAXBElement<String> value) {
        this.totalFare = value;
    }

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionId(JAXBElement<String> value) {
        this.transactionId = value;
    }

}

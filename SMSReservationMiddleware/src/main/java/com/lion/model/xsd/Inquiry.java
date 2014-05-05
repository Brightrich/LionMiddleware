
package com.lion.model.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Inquiry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Inquiry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="airlines" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departureDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flightClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flightType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msisdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numOfPax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outboundTimeRange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnTimeRange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Inquiry", propOrder = {
    "airlines",
    "departureDate",
    "destination",
    "flightClass",
    "flightType",
    "msisdn",
    "numOfPax",
    "origin",
    "outboundTimeRange",
    "returnDate",
    "returnTimeRange"
})
@XmlSeeAlso({
    InquiryResponse.class
})
public class Inquiry {

    @XmlElementRef(name = "airlines", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> airlines;
    @XmlElementRef(name = "departureDate", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> departureDate;
    @XmlElementRef(name = "destination", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> destination;
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
    @XmlElementRef(name = "outboundTimeRange", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> outboundTimeRange;
    @XmlElementRef(name = "returnDate", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> returnDate;
    @XmlElementRef(name = "returnTimeRange", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> returnTimeRange;

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
     * Gets the value of the outboundTimeRange property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOutboundTimeRange() {
        return outboundTimeRange;
    }

    /**
     * Sets the value of the outboundTimeRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOutboundTimeRange(JAXBElement<String> value) {
        this.outboundTimeRange = value;
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
     * Gets the value of the returnTimeRange property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReturnTimeRange() {
        return returnTimeRange;
    }

    /**
     * Sets the value of the returnTimeRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReturnTimeRange(JAXBElement<String> value) {
        this.returnTimeRange = value;
    }

}

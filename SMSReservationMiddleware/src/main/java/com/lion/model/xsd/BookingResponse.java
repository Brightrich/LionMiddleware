
package com.lion.model.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BookingResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BookingResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.lion.com/xsd}Transaction">
 *       &lt;sequence>
 *         &lt;element name="additionalFees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baseFare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BookingResponse", propOrder = {
    "additionalFees",
    "baseFare"
})
public class BookingResponse
    extends Transaction
{

    @XmlElementRef(name = "additionalFees", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> additionalFees;
    @XmlElementRef(name = "baseFare", namespace = "http://model.lion.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> baseFare;

    /**
     * Gets the value of the additionalFees property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdditionalFees() {
        return additionalFees;
    }

    /**
     * Sets the value of the additionalFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdditionalFees(JAXBElement<String> value) {
        this.additionalFees = value;
    }

    /**
     * Gets the value of the baseFare property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBaseFare() {
        return baseFare;
    }

    /**
     * Sets the value of the baseFare property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBaseFare(JAXBElement<String> value) {
        this.baseFare = value;
    }

}

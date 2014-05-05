
package com.lion.model.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InquiryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InquiryResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.lion.com/xsd}Inquiry">
 *       &lt;sequence>
 *         &lt;element name="outboundSchedules" type="{http://model.lion.com/xsd}Schedule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="returnSchedules" type="{http://model.lion.com/xsd}Schedule" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InquiryResponse", propOrder = {
    "outboundSchedules",
    "returnSchedules"
})
public class InquiryResponse
    extends Inquiry
{

    @XmlElement(nillable = true)
    protected List<Schedule> outboundSchedules;
    @XmlElement(nillable = true)
    protected List<Schedule> returnSchedules;

    /**
     * Gets the value of the outboundSchedules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outboundSchedules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutboundSchedules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Schedule }
     * 
     * 
     */
    public List<Schedule> getOutboundSchedules() {
        if (outboundSchedules == null) {
            outboundSchedules = new ArrayList<Schedule>();
        }
        return this.outboundSchedules;
    }

    /**
     * Gets the value of the returnSchedules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the returnSchedules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturnSchedules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Schedule }
     * 
     * 
     */
    public List<Schedule> getReturnSchedules() {
        if (returnSchedules == null) {
            returnSchedules = new ArrayList<Schedule>();
        }
        return this.returnSchedules;
    }

}

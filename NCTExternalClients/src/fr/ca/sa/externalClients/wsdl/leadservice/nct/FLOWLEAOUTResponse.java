
package fr.ca.sa.externalClients.wsdl.leadservice.nct;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FLOW_LEA_OUT" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PROSPECT_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="ERROR_MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "flowleaout"
})
@XmlRootElement(name = "FLOW_LEA_OUT_Response")
public class FLOWLEAOUTResponse {

    @XmlElement(name = "FLOW_LEA_OUT")
    protected List<FLOWLEAOUTResponse.FLOWLEAOUT> flowleaout;

    /**
     * Gets the value of the flowleaout property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flowleaout property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFLOWLEAOUT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FLOWLEAOUTResponse.FLOWLEAOUT }
     * 
     * 
     */
    public List<FLOWLEAOUTResponse.FLOWLEAOUT> getFLOWLEAOUT() {
        if (flowleaout == null) {
            flowleaout = new ArrayList<FLOWLEAOUTResponse.FLOWLEAOUT>();
        }
        return this.flowleaout;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="PROSPECT_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="ERROR_MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "prospectidext",
        "errormessage"
    })
    public static class FLOWLEAOUT {

        @XmlElement(name = "PROSPECT_ID_EXT", required = true, type = Long.class, nillable = true)
        protected Long prospectidext;
        @XmlElement(name = "ERROR_MESSAGE", required = true, nillable = true)
        protected String errormessage;

        /**
         * Gets the value of the prospectidext property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getPROSPECTIDEXT() {
            return prospectidext;
        }

        /**
         * Sets the value of the prospectidext property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setPROSPECTIDEXT(Long value) {
            this.prospectidext = value;
        }

        /**
         * Gets the value of the errormessage property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getERRORMESSAGE() {
            return errormessage;
        }

        /**
         * Sets the value of the errormessage property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setERRORMESSAGE(String value) {
            this.errormessage = value;
        }

    }

}

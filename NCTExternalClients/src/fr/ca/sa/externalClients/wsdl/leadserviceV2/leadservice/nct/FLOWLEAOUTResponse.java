
package fr.ca.sa.externalClients.wsdl.leadserviceV2.leadservice.nct;



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
 *         &lt;element name="FLOW_LEA_OUT" minOccurs="0">
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
    protected FLOWLEAOUTResponse.FLOWLEAOUT flowleaout;

    /**
     * Gets the value of the flowleaout property.
     * 
     * @return
     *     possible object is
     *     {@link FLOWLEAOUTResponse.FLOWLEAOUT }
     *     
     */
    public FLOWLEAOUTResponse.FLOWLEAOUT getFLOWLEAOUT() {
        return flowleaout;
    }

    /**
     * Sets the value of the flowleaout property.
     * 
     * @param value
     *     allowed object is
     *     {@link FLOWLEAOUTResponse.FLOWLEAOUT }
     *     
     */
    public void setFLOWLEAOUT(FLOWLEAOUTResponse.FLOWLEAOUT value) {
        this.flowleaout = value;
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

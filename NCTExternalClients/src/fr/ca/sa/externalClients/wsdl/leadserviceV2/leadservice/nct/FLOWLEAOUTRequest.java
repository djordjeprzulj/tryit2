
package fr.ca.sa.externalClients.wsdl.leadserviceV2.leadservice.nct;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *                   &lt;element name="PROSPECT_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="PROSPECT_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="PROSPECT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="CLIENT_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="PORTFOLIO_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="ENTITY_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="SEGMENT_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="PROSPECT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="COMPANY_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="COMPANY_OFFICER_FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="COMPANY_OFFICER_LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="CIVILITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="MARITAL_STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="CHILDREN_NUMBER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="CSP" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="ACTIVITY_SECTOR" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="ORIGIN" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="FAVORITE_CANAL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="BIRTH_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="BIRTH_PLACE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ADDRESS_COMPL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="POSTCODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="COUNTRY_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="PROFESIONAL_PHONE_COUNTRY_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="PROFESIONAL_PHONE_CALL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="PROFESIONAL_PHONE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="PERSONAL_PHONE_COUNTRY_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="PERSONAL_PHONE_CALL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="PERSONAL_PHONE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="MOBILE_PHONE_COUNTRY_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="MOBILE_PHONE_CALL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="MOBILE_PHONE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="EMAIL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="CLIENT_STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="CHANGE_STATUS_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="COMMENTS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DATE_OF_FIRST_CONTACT" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="FIRST_CONTACT_COLLABORATOR_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="DATE_OF_LAST_CONTACT" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="LAST_CONTACT_COLLABORATOR_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="CONTACT_PRIORITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="CLIENT_CODE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlRootElement(name = "FLOW_LEA_OUT_Request")
public class FLOWLEAOUTRequest {

    @XmlElement(name = "FLOW_LEA_OUT")
    protected FLOWLEAOUTRequest.FLOWLEAOUT flowleaout;

    /**
     * Gets the value of the flowleaout property.
     * 
     * @return
     *     possible object is
     *     {@link FLOWLEAOUTRequest.FLOWLEAOUT }
     *     
     */
    public FLOWLEAOUTRequest.FLOWLEAOUT getFLOWLEAOUT() {
        return flowleaout;
    }

    /**
     * Sets the value of the flowleaout property.
     * 
     * @param value
     *     allowed object is
     *     {@link FLOWLEAOUTRequest.FLOWLEAOUT }
     *     
     */
    public void setFLOWLEAOUT(FLOWLEAOUTRequest.FLOWLEAOUT value) {
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
     *         &lt;element name="PROSPECT_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="PROSPECT_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="PROSPECT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="CLIENT_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="PORTFOLIO_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="ENTITY_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="SEGMENT_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="PROSPECT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="COMPANY_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="COMPANY_OFFICER_FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="COMPANY_OFFICER_LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="CIVILITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="MARITAL_STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="CHILDREN_NUMBER" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="CSP" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="ACTIVITY_SECTOR" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="ORIGIN" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="FAVORITE_CANAL" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="BIRTH_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="BIRTH_PLACE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ADDRESS_COMPL" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="POSTCODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="COUNTRY_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="PROFESIONAL_PHONE_COUNTRY_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="PROFESIONAL_PHONE_CALL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="PROFESIONAL_PHONE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="PERSONAL_PHONE_COUNTRY_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="PERSONAL_PHONE_CALL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="PERSONAL_PHONE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="MOBILE_PHONE_COUNTRY_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="MOBILE_PHONE_CALL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="MOBILE_PHONE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="EMAIL" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="CLIENT_STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="CHANGE_STATUS_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="COMMENTS" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DATE_OF_FIRST_CONTACT" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="FIRST_CONTACT_COLLABORATOR_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="DATE_OF_LAST_CONTACT" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="LAST_CONTACT_COLLABORATOR_ID_EXT" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="CONTACT_PRIORITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="CLIENT_CODE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "prospectid",
        "prospectidext",
        "prospectcode",
        "clientidext",
        "portfolioidext",
        "entityidext",
        "segmentidext",
        "prospecttype",
        "companyname",
        "companyofficerfirstname",
        "companyofficerlastname",
        "lastname",
        "firstname",
        "civility",
        "maritalstatus",
        "childrennumber",
        "csp",
        "activitysector",
        "origin",
        "favoritecanal",
        "birthdate",
        "birthplace",
        "nationality",
        "address",
        "addresscompl",
        "postcode",
        "city",
        "countrycode",
        "profesionalphonecountrycode",
        "profesionalphonecallnumber",
        "profesionalphonenumber",
        "personalphonecountrycode",
        "personalphonecallnumber",
        "personalphonenumber",
        "mobilephonecountrycode",
        "mobilephonecallnumber",
        "mobilephonenumber",
        "email",
        "clientstatus",
        "changestatusdate",
        "comments",
        "dateoffirstcontact",
        "firstcontactcollaboratoridext",
        "dateoflastcontact",
        "lastcontactcollaboratoridext",
        "contactpriority",
        "clientcodetype"
    })
    public static class FLOWLEAOUT {

        @XmlElement(name = "PROSPECT_ID", required = true, type = Integer.class, nillable = true)
        protected Integer prospectid;
        @XmlElement(name = "PROSPECT_ID_EXT", required = true, type = Long.class, nillable = true)
        protected Long prospectidext;
        @XmlElement(name = "PROSPECT_CODE", required = true, nillable = true)
        protected String prospectcode;
        @XmlElement(name = "CLIENT_ID_EXT", required = true, type = Long.class, nillable = true)
        protected Long clientidext;
        @XmlElement(name = "PORTFOLIO_ID_EXT", required = true, type = Integer.class, nillable = true)
        protected Integer portfolioidext;
        @XmlElement(name = "ENTITY_ID_EXT", required = true, type = Integer.class, nillable = true)
        protected Integer entityidext;
        @XmlElement(name = "SEGMENT_ID_EXT", required = true, type = Integer.class, nillable = true)
        protected Integer segmentidext;
        @XmlElement(name = "PROSPECT_TYPE", required = true, type = Integer.class, nillable = true)
        protected Integer prospecttype;
        @XmlElement(name = "COMPANY_NAME", required = true, nillable = true)
        protected String companyname;
        @XmlElement(name = "COMPANY_OFFICER_FIRST_NAME", required = true, nillable = true)
        protected String companyofficerfirstname;
        @XmlElement(name = "COMPANY_OFFICER_LAST_NAME", required = true, nillable = true)
        protected String companyofficerlastname;
        @XmlElement(name = "LAST_NAME", required = true, nillable = true)
        protected String lastname;
        @XmlElement(name = "FIRST_NAME", required = true, nillable = true)
        protected String firstname;
        @XmlElement(name = "CIVILITY", required = true, type = Integer.class, nillable = true)
        protected Integer civility;
        @XmlElement(name = "MARITAL_STATUS", required = true, type = Integer.class, nillable = true)
        protected Integer maritalstatus;
        @XmlElement(name = "CHILDREN_NUMBER", required = true, type = Integer.class, nillable = true)
        protected Integer childrennumber;
        @XmlElement(name = "CSP", required = true, type = Integer.class, nillable = true)
        protected Integer csp;
        @XmlElement(name = "ACTIVITY_SECTOR", required = true, type = Integer.class, nillable = true)
        protected Integer activitysector;
        @XmlElement(name = "ORIGIN", required = true, type = Integer.class, nillable = true)
        protected Integer origin;
        @XmlElement(name = "FAVORITE_CANAL", required = true, type = Integer.class, nillable = true)
        protected Integer favoritecanal;
        @XmlElement(name = "BIRTH_DATE", required = true, nillable = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar birthdate;
        @XmlElement(name = "BIRTH_PLACE", required = true, nillable = true)
        protected String birthplace;
        @XmlElement(name = "NATIONALITY", required = true, nillable = true)
        protected String nationality;
        @XmlElement(name = "ADDRESS", required = true, nillable = true)
        protected String address;
        @XmlElement(name = "ADDRESS_COMPL", required = true, nillable = true)
        protected String addresscompl;
        @XmlElement(name = "POSTCODE", required = true, nillable = true)
        protected String postcode;
        @XmlElement(name = "CITY", required = true, nillable = true)
        protected String city;
        @XmlElement(name = "COUNTRY_CODE", required = true, nillable = true)
        protected String countrycode;
        @XmlElement(name = "PROFESIONAL_PHONE_COUNTRY_CODE", required = true, nillable = true)
        protected String profesionalphonecountrycode;
        @XmlElement(name = "PROFESIONAL_PHONE_CALL_NUMBER", required = true, nillable = true)
        protected String profesionalphonecallnumber;
        @XmlElement(name = "PROFESIONAL_PHONE_NUMBER", required = true, nillable = true)
        protected String profesionalphonenumber;
        @XmlElement(name = "PERSONAL_PHONE_COUNTRY_CODE", required = true, nillable = true)
        protected String personalphonecountrycode;
        @XmlElement(name = "PERSONAL_PHONE_CALL_NUMBER", required = true, nillable = true)
        protected String personalphonecallnumber;
        @XmlElement(name = "PERSONAL_PHONE_NUMBER", required = true, nillable = true)
        protected String personalphonenumber;
        @XmlElement(name = "MOBILE_PHONE_COUNTRY_CODE", required = true, nillable = true)
        protected String mobilephonecountrycode;
        @XmlElement(name = "MOBILE_PHONE_CALL_NUMBER", required = true, nillable = true)
        protected String mobilephonecallnumber;
        @XmlElement(name = "MOBILE_PHONE_NUMBER", required = true, nillable = true)
        protected String mobilephonenumber;
        @XmlElement(name = "EMAIL", required = true, nillable = true)
        protected String email;
        @XmlElement(name = "CLIENT_STATUS")
        protected int clientstatus;
        @XmlElement(name = "CHANGE_STATUS_DATE", required = true, nillable = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar changestatusdate;
        @XmlElement(name = "COMMENTS", required = true, nillable = true)
        protected String comments;
        @XmlElement(name = "DATE_OF_FIRST_CONTACT", required = true, nillable = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dateoffirstcontact;
        @XmlElement(name = "FIRST_CONTACT_COLLABORATOR_ID_EXT", required = true, type = Integer.class, nillable = true)
        protected Integer firstcontactcollaboratoridext;
        @XmlElement(name = "DATE_OF_LAST_CONTACT", required = true, nillable = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dateoflastcontact;
        @XmlElement(name = "LAST_CONTACT_COLLABORATOR_ID_EXT", required = true, type = Integer.class, nillable = true)
        protected Integer lastcontactcollaboratoridext;
        @XmlElement(name = "CONTACT_PRIORITY", required = true, type = Integer.class, nillable = true)
        protected Integer contactpriority;
        @XmlElement(name = "CLIENT_CODE_TYPE", required = true, nillable = true)
        protected String clientcodetype;

        /**
         * Gets the value of the prospectid property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getPROSPECTID() {
            return prospectid;
        }

        /**
         * Sets the value of the prospectid property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setPROSPECTID(Integer value) {
            this.prospectid = value;
        }

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
         * Gets the value of the prospectcode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPROSPECTCODE() {
            return prospectcode;
        }

        /**
         * Sets the value of the prospectcode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPROSPECTCODE(String value) {
            this.prospectcode = value;
        }

        /**
         * Gets the value of the clientidext property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getCLIENTIDEXT() {
            return clientidext;
        }

        /**
         * Sets the value of the clientidext property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setCLIENTIDEXT(Long value) {
            this.clientidext = value;
        }

        /**
         * Gets the value of the portfolioidext property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getPORTFOLIOIDEXT() {
            return portfolioidext;
        }

        /**
         * Sets the value of the portfolioidext property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setPORTFOLIOIDEXT(Integer value) {
            this.portfolioidext = value;
        }

        /**
         * Gets the value of the entityidext property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getENTITYIDEXT() {
            return entityidext;
        }

        /**
         * Sets the value of the entityidext property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setENTITYIDEXT(Integer value) {
            this.entityidext = value;
        }

        /**
         * Gets the value of the segmentidext property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getSEGMENTIDEXT() {
            return segmentidext;
        }

        /**
         * Sets the value of the segmentidext property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setSEGMENTIDEXT(Integer value) {
            this.segmentidext = value;
        }

        /**
         * Gets the value of the prospecttype property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getPROSPECTTYPE() {
            return prospecttype;
        }

        /**
         * Sets the value of the prospecttype property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setPROSPECTTYPE(Integer value) {
            this.prospecttype = value;
        }

        /**
         * Gets the value of the companyname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOMPANYNAME() {
            return companyname;
        }

        /**
         * Sets the value of the companyname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOMPANYNAME(String value) {
            this.companyname = value;
        }

        /**
         * Gets the value of the companyofficerfirstname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOMPANYOFFICERFIRSTNAME() {
            return companyofficerfirstname;
        }

        /**
         * Sets the value of the companyofficerfirstname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOMPANYOFFICERFIRSTNAME(String value) {
            this.companyofficerfirstname = value;
        }

        /**
         * Gets the value of the companyofficerlastname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOMPANYOFFICERLASTNAME() {
            return companyofficerlastname;
        }

        /**
         * Sets the value of the companyofficerlastname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOMPANYOFFICERLASTNAME(String value) {
            this.companyofficerlastname = value;
        }

        /**
         * Gets the value of the lastname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLASTNAME() {
            return lastname;
        }

        /**
         * Sets the value of the lastname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLASTNAME(String value) {
            this.lastname = value;
        }

        /**
         * Gets the value of the firstname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIRSTNAME() {
            return firstname;
        }

        /**
         * Sets the value of the firstname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIRSTNAME(String value) {
            this.firstname = value;
        }

        /**
         * Gets the value of the civility property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getCIVILITY() {
            return civility;
        }

        /**
         * Sets the value of the civility property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setCIVILITY(Integer value) {
            this.civility = value;
        }

        /**
         * Gets the value of the maritalstatus property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getMARITALSTATUS() {
            return maritalstatus;
        }

        /**
         * Sets the value of the maritalstatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setMARITALSTATUS(Integer value) {
            this.maritalstatus = value;
        }

        /**
         * Gets the value of the childrennumber property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getCHILDRENNUMBER() {
            return childrennumber;
        }

        /**
         * Sets the value of the childrennumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setCHILDRENNUMBER(Integer value) {
            this.childrennumber = value;
        }

        /**
         * Gets the value of the csp property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getCSP() {
            return csp;
        }

        /**
         * Sets the value of the csp property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setCSP(Integer value) {
            this.csp = value;
        }

        /**
         * Gets the value of the activitysector property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getACTIVITYSECTOR() {
            return activitysector;
        }

        /**
         * Sets the value of the activitysector property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setACTIVITYSECTOR(Integer value) {
            this.activitysector = value;
        }

        /**
         * Gets the value of the origin property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getORIGIN() {
            return origin;
        }

        /**
         * Sets the value of the origin property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setORIGIN(Integer value) {
            this.origin = value;
        }

        /**
         * Gets the value of the favoritecanal property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getFAVORITECANAL() {
            return favoritecanal;
        }

        /**
         * Sets the value of the favoritecanal property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setFAVORITECANAL(Integer value) {
            this.favoritecanal = value;
        }

        /**
         * Gets the value of the birthdate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getBIRTHDATE() {
            return birthdate;
        }

        /**
         * Sets the value of the birthdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setBIRTHDATE(XMLGregorianCalendar value) {
            this.birthdate = value;
        }

        /**
         * Gets the value of the birthplace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBIRTHPLACE() {
            return birthplace;
        }

        /**
         * Sets the value of the birthplace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBIRTHPLACE(String value) {
            this.birthplace = value;
        }

        /**
         * Gets the value of the nationality property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNATIONALITY() {
            return nationality;
        }

        /**
         * Sets the value of the nationality property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNATIONALITY(String value) {
            this.nationality = value;
        }

        /**
         * Gets the value of the address property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getADDRESS() {
            return address;
        }

        /**
         * Sets the value of the address property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setADDRESS(String value) {
            this.address = value;
        }

        /**
         * Gets the value of the addresscompl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getADDRESSCOMPL() {
            return addresscompl;
        }

        /**
         * Sets the value of the addresscompl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setADDRESSCOMPL(String value) {
            this.addresscompl = value;
        }

        /**
         * Gets the value of the postcode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPOSTCODE() {
            return postcode;
        }

        /**
         * Sets the value of the postcode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPOSTCODE(String value) {
            this.postcode = value;
        }

        /**
         * Gets the value of the city property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCITY() {
            return city;
        }

        /**
         * Sets the value of the city property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCITY(String value) {
            this.city = value;
        }

        /**
         * Gets the value of the countrycode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOUNTRYCODE() {
            return countrycode;
        }

        /**
         * Sets the value of the countrycode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOUNTRYCODE(String value) {
            this.countrycode = value;
        }

        /**
         * Gets the value of the profesionalphonecountrycode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPROFESIONALPHONECOUNTRYCODE() {
            return profesionalphonecountrycode;
        }

        /**
         * Sets the value of the profesionalphonecountrycode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPROFESIONALPHONECOUNTRYCODE(String value) {
            this.profesionalphonecountrycode = value;
        }

        /**
         * Gets the value of the profesionalphonecallnumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPROFESIONALPHONECALLNUMBER() {
            return profesionalphonecallnumber;
        }

        /**
         * Sets the value of the profesionalphonecallnumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPROFESIONALPHONECALLNUMBER(String value) {
            this.profesionalphonecallnumber = value;
        }

        /**
         * Gets the value of the profesionalphonenumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPROFESIONALPHONENUMBER() {
            return profesionalphonenumber;
        }

        /**
         * Sets the value of the profesionalphonenumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPROFESIONALPHONENUMBER(String value) {
            this.profesionalphonenumber = value;
        }

        /**
         * Gets the value of the personalphonecountrycode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPERSONALPHONECOUNTRYCODE() {
            return personalphonecountrycode;
        }

        /**
         * Sets the value of the personalphonecountrycode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPERSONALPHONECOUNTRYCODE(String value) {
            this.personalphonecountrycode = value;
        }

        /**
         * Gets the value of the personalphonecallnumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPERSONALPHONECALLNUMBER() {
            return personalphonecallnumber;
        }

        /**
         * Sets the value of the personalphonecallnumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPERSONALPHONECALLNUMBER(String value) {
            this.personalphonecallnumber = value;
        }

        /**
         * Gets the value of the personalphonenumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPERSONALPHONENUMBER() {
            return personalphonenumber;
        }

        /**
         * Sets the value of the personalphonenumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPERSONALPHONENUMBER(String value) {
            this.personalphonenumber = value;
        }

        /**
         * Gets the value of the mobilephonecountrycode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMOBILEPHONECOUNTRYCODE() {
            return mobilephonecountrycode;
        }

        /**
         * Sets the value of the mobilephonecountrycode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMOBILEPHONECOUNTRYCODE(String value) {
            this.mobilephonecountrycode = value;
        }

        /**
         * Gets the value of the mobilephonecallnumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMOBILEPHONECALLNUMBER() {
            return mobilephonecallnumber;
        }

        /**
         * Sets the value of the mobilephonecallnumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMOBILEPHONECALLNUMBER(String value) {
            this.mobilephonecallnumber = value;
        }

        /**
         * Gets the value of the mobilephonenumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMOBILEPHONENUMBER() {
            return mobilephonenumber;
        }

        /**
         * Sets the value of the mobilephonenumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMOBILEPHONENUMBER(String value) {
            this.mobilephonenumber = value;
        }

        /**
         * Gets the value of the email property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEMAIL() {
            return email;
        }

        /**
         * Sets the value of the email property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEMAIL(String value) {
            this.email = value;
        }

        /**
         * Gets the value of the clientstatus property.
         * 
         */
        public int getCLIENTSTATUS() {
            return clientstatus;
        }

        /**
         * Sets the value of the clientstatus property.
         * 
         */
        public void setCLIENTSTATUS(int value) {
            this.clientstatus = value;
        }

        /**
         * Gets the value of the changestatusdate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCHANGESTATUSDATE() {
            return changestatusdate;
        }

        /**
         * Sets the value of the changestatusdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCHANGESTATUSDATE(XMLGregorianCalendar value) {
            this.changestatusdate = value;
        }

        /**
         * Gets the value of the comments property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOMMENTS() {
            return comments;
        }

        /**
         * Sets the value of the comments property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOMMENTS(String value) {
            this.comments = value;
        }

        /**
         * Gets the value of the dateoffirstcontact property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDATEOFFIRSTCONTACT() {
            return dateoffirstcontact;
        }

        /**
         * Sets the value of the dateoffirstcontact property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDATEOFFIRSTCONTACT(XMLGregorianCalendar value) {
            this.dateoffirstcontact = value;
        }

        /**
         * Gets the value of the firstcontactcollaboratoridext property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getFIRSTCONTACTCOLLABORATORIDEXT() {
            return firstcontactcollaboratoridext;
        }

        /**
         * Sets the value of the firstcontactcollaboratoridext property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setFIRSTCONTACTCOLLABORATORIDEXT(Integer value) {
            this.firstcontactcollaboratoridext = value;
        }

        /**
         * Gets the value of the dateoflastcontact property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDATEOFLASTCONTACT() {
            return dateoflastcontact;
        }

        /**
         * Sets the value of the dateoflastcontact property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDATEOFLASTCONTACT(XMLGregorianCalendar value) {
            this.dateoflastcontact = value;
        }

        /**
         * Gets the value of the lastcontactcollaboratoridext property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getLASTCONTACTCOLLABORATORIDEXT() {
            return lastcontactcollaboratoridext;
        }

        /**
         * Sets the value of the lastcontactcollaboratoridext property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setLASTCONTACTCOLLABORATORIDEXT(Integer value) {
            this.lastcontactcollaboratoridext = value;
        }

        /**
         * Gets the value of the contactpriority property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getCONTACTPRIORITY() {
            return contactpriority;
        }

        /**
         * Sets the value of the contactpriority property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setCONTACTPRIORITY(Integer value) {
            this.contactpriority = value;
        }

        /**
         * Gets the value of the clientcodetype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCLIENTCODETYPE() {
            return clientcodetype;
        }

        /**
         * Sets the value of the clientcodetype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCLIENTCODETYPE(String value) {
            this.clientcodetype = value;
        }

    }

}

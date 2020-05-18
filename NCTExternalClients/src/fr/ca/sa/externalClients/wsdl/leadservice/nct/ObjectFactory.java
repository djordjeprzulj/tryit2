
package fr.ca.sa.externalClients.wsdl.leadservice.nct;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the leadservice.nct package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: leadservice.nct
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FLOWLEAOUTRequest }
     * 
     */
    public FLOWLEAOUTRequest createFLOWLEAOUTRequest() {
        return new FLOWLEAOUTRequest();
    }

    /**
     * Create an instance of {@link FLOWLEAOUTResponse }
     * 
     */
    public FLOWLEAOUTResponse createFLOWLEAOUTResponse() {
        return new FLOWLEAOUTResponse();
    }

    /**
     * Create an instance of {@link FLOWLEAOUTRequest.FLOWLEAOUT }
     * 
     */
    public FLOWLEAOUTRequest.FLOWLEAOUT createFLOWLEAOUTRequestFLOWLEAOUT() {
        return new FLOWLEAOUTRequest.FLOWLEAOUT();
    }

    /**
     * Create an instance of {@link FLOWLEAOUTResponse.FLOWLEAOUT }
     * 
     */
    public FLOWLEAOUTResponse.FLOWLEAOUT createFLOWLEAOUTResponseFLOWLEAOUT() {
        return new FLOWLEAOUTResponse.FLOWLEAOUT();
    }

}

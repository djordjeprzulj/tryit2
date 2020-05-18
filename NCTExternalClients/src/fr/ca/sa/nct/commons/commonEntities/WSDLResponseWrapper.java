package fr.ca.sa.nct.commons.commonEntities;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Container class for WSDL responses - for Web Sockets(JSON) and DB(XML)
 * 
 * @author Nemanja Ignjatov
 *
 */
public class WSDLResponseWrapper implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String jsonString;
	private String xmlString;
	private String errorString;

	/**
	 * default constructor for WSDL Response Wrapper
	 */
	public WSDLResponseWrapper() {
		super();
	}

	/**
	 * WSDL Response Wrapper
	 * 
	 * @param jsonString
	 * 				JSON string
	 * 
	 * @param xmlString
	 * 				XML string
	 * 
	 * @param errorString
	 * 				Error string
	 */
	public WSDLResponseWrapper(String jsonString, String xmlString, String errorString) {
		super();
		this.jsonString = jsonString;
		this.xmlString = xmlString;
		this.errorString = errorString;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public String getXmlString() {
		return xmlString;
	}

	public void setXmlString(String xmlString) {
		this.xmlString = xmlString;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	@Override
	public String toString() {
		return "WSDLResponseWrapper [jsonString=" + jsonString + ", xmlString=" + xmlString + ", errorString="
				+ errorString + "]";
	}

}

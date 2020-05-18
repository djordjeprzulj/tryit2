package fr.ca.sa.nct.commons.commonEntities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder for cached WSDL response for the client
 * 
 * @author Nemanja Ignjatov
 *
 */
public class WSDLCachedResponseContainer implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, String> messages;
	private Date lastCached;

	/**
	 * default constructor for WSDL Cached Response Container
	 */
	public WSDLCachedResponseContainer() {
		super();
		this.messages = new HashMap<String, String>();
	}

	/**
	 * WSDL Cached Response Container
	 * 
	 * @param lastCached
	 * 				Last cached
	 */
	public WSDLCachedResponseContainer(Date lastCached) {
		super();
		this.lastCached = lastCached;
		this.messages = new HashMap<String, String>();
	}

	public Date getLastCached() {
		return lastCached;
	}

	public void setLastCached(Date lastCached) {
		this.lastCached = lastCached;
	}

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "WSDLCachedResponseContainer [messages=" + messages + ", lastCached=" + lastCached + "]";
	}

}

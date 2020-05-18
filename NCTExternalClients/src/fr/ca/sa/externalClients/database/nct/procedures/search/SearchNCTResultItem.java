package fr.ca.sa.externalClients.database.nct.procedures.search;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.Client;

/**
 * 
 * Item containing user data fetched from DB
 * 
 * @author nignjatov
 *
 */
public class SearchNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Client client;	
	//private String birthDate;

	/**
	 * default constructor for Search NCT Result Item
	 */
	public SearchNCTResultItem() {
		super();
	}

	/**
	 * Search NCT Result Item
	 * 
	 * @param client
	 * 				Client 
	 */
	public SearchNCTResultItem(Client client) {
		super();
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "SearchNCTResultItem [client=" + client + "]";
	}

}

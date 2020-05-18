package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class TranslatableClientOppProductList implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<TranslatableClientOppProduct> clientOppProductList;

	/**
	 * default constructor for Translatable Client Opportunity Product List
	 */
	public TranslatableClientOppProductList() {
		super();
		this.clientOppProductList = new ArrayList<>();
	}

	/**
	 * Translatable Client Opportunity Product List
	 * 
	 * @param clientOppProductList
	 * 				Client opportunity product list
	 */
	public TranslatableClientOppProductList(List<TranslatableClientOppProduct> clientOppProductList) {
		super();
		this.clientOppProductList = clientOppProductList;
	}

	public List<TranslatableClientOppProduct> getClientOppProductList() {
		return clientOppProductList;
	}

	public void setClientOppProductList(List<TranslatableClientOppProduct> clientOppProductList) {
		this.clientOppProductList = clientOppProductList;
	}

}

package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getAgreedOfferTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class SAAgreedProductTypeResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<SAAgreedProductTypeItem> agreedProductTypesList;

	/**
	 * default constructor for Sales Assistant Agreed Product Type Result List
	 */
	public SAAgreedProductTypeResultList() {
		super();
		this.agreedProductTypesList = new ArrayList<>();
	}

	/**
	 * Sales Assistant Agreed Product Type Result List
	 * 
	 * @param agreedProductTypesList
	 * 				Agreed product types list
	 */
	public SAAgreedProductTypeResultList(List<SAAgreedProductTypeItem> agreedProductTypesList) {
		super();
		this.agreedProductTypesList = agreedProductTypesList;
	}

	public List<SAAgreedProductTypeItem> getAgreedProductTypesList() {
		return agreedProductTypesList;
	}

	public void setAgreedProductTypesList(List<SAAgreedProductTypeItem> agreedProductTypesList) {
		this.agreedProductTypesList = agreedProductTypesList;
	}

	@Override
	public String toString() {
		return "SAAgreedProductTypeResultList [agreedProductTypesList=" + agreedProductTypesList + "]";
	}

}

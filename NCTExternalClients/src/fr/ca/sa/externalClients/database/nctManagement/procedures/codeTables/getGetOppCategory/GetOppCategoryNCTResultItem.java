package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getGetOppCategory;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetOppCategoryNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int oppCategoryId;
	private String oppCategoryName;

	/**
	 * default constructor for Get Opportunity Category NCT Result Item
	 */
	public GetOppCategoryNCTResultItem() {
		super();
	}

	/**
	 * Get Opportunity Category NCT Result Item
	 * 
	 * @param oppCategoryId
	 * 				Opportunity category ID
	 * 
	 * @param oppCategoryName
	 * 				Opportunity category name
	 */
	public GetOppCategoryNCTResultItem(int oppCategoryId, String oppCategoryName) {
		super();
		this.oppCategoryId = oppCategoryId;
		this.oppCategoryName = oppCategoryName;
	}

	public int getOppCategoryId() {
		return oppCategoryId;
	}

	public void setOppCategoryId(int oppCategoryId) {
		this.oppCategoryId = oppCategoryId;
	}

	public String getOppCategoryName() {
		return oppCategoryName;
	}

	public void setOppCategoryName(String oppCategoryName) {
		this.oppCategoryName = oppCategoryName;
	}

	@Override
	public String toString() {
		return "GetOppCategoryNCTResultItem [oppCategoryId=" + oppCategoryId + ", oppCategoryName=" + oppCategoryName
				+ "]";
	}

}

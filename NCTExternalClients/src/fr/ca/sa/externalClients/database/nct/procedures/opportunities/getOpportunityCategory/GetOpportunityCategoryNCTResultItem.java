package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityCategory;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityCategoryNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int oppCategoryId;
	private String oppCategoryName;
	private String oppCategoryPicture;

	/**
	 * default constructor for Get Opportunity Category NCT Result Item
	 */
	public GetOpportunityCategoryNCTResultItem() {
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
	public GetOpportunityCategoryNCTResultItem(int oppCategoryId, String oppCategoryName) {
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

	public String getOppCategoryPicture() {
		return oppCategoryPicture;
	}

	public void setOppCategoryPicture(String oppCategoryPicture) {
		this.oppCategoryPicture = oppCategoryPicture;
	}

	@Override
	public String toString() {
		return "GetOpportunityCategoryNCTResultItem [oppCategoryId=" + oppCategoryId + ", oppCategoryName="
				+ oppCategoryName + ", oppCategoryPicture=" + oppCategoryPicture + "]";
	}

}

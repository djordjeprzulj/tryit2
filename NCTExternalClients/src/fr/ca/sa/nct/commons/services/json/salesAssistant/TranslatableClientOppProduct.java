package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.BaseTranslatableProduct;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class TranslatableClientOppProduct extends BaseTranslatableClientProduct implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int opportunityId;
	
	/**
	 * default constructor for Translatable Client Opp Product
	 */
	public TranslatableClientOppProduct() {
		super();
	}

	/**
	 * Translatable Client Opportunity Product
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 */
	public TranslatableClientOppProduct(BaseTranslatableProduct baseTranslatableProduct, int opportunityId) {
		super(baseTranslatableProduct);
		this.opportunityId = opportunityId;
	}

	public int getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(int opportunityId) {
		this.opportunityId = opportunityId;
	}	
}

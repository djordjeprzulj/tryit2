package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder for CS and QCR opportunity list
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TranslatableClientOpportunityLightList implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<TranslatableClientOpportunityLight> opportunities;

	/**
	 * default constructor for Translatable Client Opportunity Light List
	 */
	public TranslatableClientOpportunityLightList() {
		super();
		this.opportunities = new ArrayList<>();
	}

	/**
	 * Translatable Client Opportunity Light List
	 * 
	 * @param opportunities
	 * 				Opportunities
	 */
	public TranslatableClientOpportunityLightList(List<TranslatableClientOpportunityLight> opportunities) {
		super();
		this.opportunities = opportunities;
	}

	public List<TranslatableClientOpportunityLight> getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(List<TranslatableClientOpportunityLight> opportunities) {
		this.opportunities = opportunities;
	}

}

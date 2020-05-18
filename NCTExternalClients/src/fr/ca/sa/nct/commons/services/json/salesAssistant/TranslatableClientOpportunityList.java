package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.TranslatableClientOpportunity;

/**
 * 
 * Holder for SA opportunity list
 * 
 * @author Sasa Radovanovic
 *
 */
public class TranslatableClientOpportunityList implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<TranslatableClientOpportunity> opportunities;

	/**
	 * default constructor for Translatable Client Opportunity List
	 */
	public TranslatableClientOpportunityList() {
		super();
		this.opportunities = new ArrayList<>();
	}

	/**
	 * Translatable Client Opportunity List
	 * 
	 * @param opportunities
	 * 				Opportunities list
	 */
	public TranslatableClientOpportunityList(List<TranslatableClientOpportunity> opportunities) {
		super();
		this.opportunities = opportunities;
	}

	public List<TranslatableClientOpportunity> getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(List<TranslatableClientOpportunity> opportunities) {
		this.opportunities = opportunities;
	}

}

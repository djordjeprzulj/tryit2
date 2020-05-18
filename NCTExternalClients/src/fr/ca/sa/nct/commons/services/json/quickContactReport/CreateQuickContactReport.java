package fr.ca.sa.nct.commons.services.json.quickContactReport;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.QuickContactReport;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class CreateQuickContactReport implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private QuickContactReport quickContactReport;
	
	private List<QCROpportunityStatesRequest> opportunities;

	/**
	 * default constructor for Create Quick Contact Report
	 */
	public CreateQuickContactReport() {
		super();
	}

	/**
	 * Create Quick Contact Report
	 * 
	 * @param quickContactReport
	 * 				Quick Contact Report
	 *  
	 * @param opportunities
	 * 				Opportunities
	 */
	public CreateQuickContactReport(QuickContactReport quickContactReport, List<QCROpportunityStatesRequest> opportunities) {
		super();
		this.quickContactReport = quickContactReport;
		this.opportunities = opportunities;
	}

	public QuickContactReport getQuickContactReport() {
		return quickContactReport;
	}

	public void setQuickContactReport(QuickContactReport quickContactReport) {
		this.quickContactReport = quickContactReport;
	}

	public List<QCROpportunityStatesRequest> getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(List<QCROpportunityStatesRequest> opportunities) {
		this.opportunities = opportunities;
	}

}

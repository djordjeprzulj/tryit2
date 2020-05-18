package fr.ca.sa.externalClients.database.nct.procedures.quickContact.getQCRDetails;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.model.QuickContactReport;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetQCRDetailsNCTResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private QuickContactReport quickContactReport; 

	/**
	 * Get QCR Details NCT Result Item
	 *   
	 * @param quickContactReport
	 * 				Quick Contact Report
	 */
	public GetQCRDetailsNCTResultItem(QuickContactReport quickContactReport) {
		super();
		this.quickContactReport = quickContactReport;
		// SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
		// this.reportDate = formatter.format(reportDate);
	}

	public QuickContactReport getQuickContactReport() {
		return quickContactReport;
	}

	public void setQuickContactReport(QuickContactReport quickContactReport) {
		this.quickContactReport = quickContactReport;
	}

	@Override
	public String toString() {
		return "GetQCRDetailsNCTResultItem [quickContactReport=" + quickContactReport + "]";
	}
}

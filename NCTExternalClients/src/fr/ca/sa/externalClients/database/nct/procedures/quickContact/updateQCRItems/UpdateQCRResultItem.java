package fr.ca.sa.externalClients.database.nct.procedures.quickContact.updateQCRItems;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class UpdateQCRResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer qcrId;

	/**
	 * default constructor for Update QCR Result Item
	 */
	public UpdateQCRResultItem() {
		super();
	}

	/**
	 * Update QCR Result Item
	 * 
	 * @param qcrId
	 * 				QCR ID
	 */
	public UpdateQCRResultItem(Integer qcrId) {
		super();
		this.qcrId = qcrId;
	}

	public Integer getQcrId() {
		return qcrId;
	}

	public void setQcrId(Integer qcrId) {
		this.qcrId = qcrId;
	}

	@Override
	public String toString() {
		return "SetQCR [qcrId=" + qcrId + "]";
	}
}

package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.setIncomingFlowData;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

public class SetIncomingFlowDataNCTResult implements StoreProcedureResult, Serializable {
	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	private boolean errorOccured;
	/**
	 * default constructor for Set Flow Process Type NCT Result Item
	 */
	public SetIncomingFlowDataNCTResult() {
		super();
	}
	public SetIncomingFlowDataNCTResult(boolean errorOccured) {
		super();
		this.errorOccured = errorOccured;
	}
	public boolean isErrorOccured() {
		return errorOccured;
	}
	public void setErrorOccured(boolean errorOccured) {
		this.errorOccured = errorOccured;
	}
	@Override
	public String toString() {
		return "SetIncomingFlowDataNCTResult [errorOccured=" + errorOccured + "]";
	}
}
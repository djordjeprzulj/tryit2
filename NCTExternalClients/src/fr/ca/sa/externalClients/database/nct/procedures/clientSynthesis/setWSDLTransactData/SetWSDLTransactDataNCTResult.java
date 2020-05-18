package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.setWSDLTransactData;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning inserted/updated transact id
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetWSDLTransactDataNCTResult implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int transactId;

	/**
	 * default constructor for Set WSDL Transaction Data NCT Result
	 */
	public SetWSDLTransactDataNCTResult() {
		super();
	}

	/**
	 * Set WSDL Transact Data NCT Result
	 * 
	 * @param transactId
	 * 				Transaction ID
	 */
	public SetWSDLTransactDataNCTResult(int transactId) {
		super();
		this.transactId = transactId;
	}

	public int getTransactId() {
		return transactId;
	}

	public void setTransactId(int transactId) {
		this.transactId = transactId;
	}

	@Override
	public String toString() {
		return "SetWSDLTransactDataNCTResult [transactId=" + transactId + "]";
	}

}

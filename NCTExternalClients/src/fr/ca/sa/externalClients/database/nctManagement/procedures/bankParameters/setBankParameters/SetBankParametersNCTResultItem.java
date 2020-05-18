package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.setBankParameters;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spSetBankParameters store procedure
 */
public class SetBankParametersNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String logoPicture;

	/**
	 * default constructor for Set Bank Parameters NCT Result Item
	 */
	public SetBankParametersNCTResultItem() {
		super();
	}

	/**
	 * Set Bank Parameters NCT Result Item
	 * 
	 * @param logoPicture
	 * 				Logo picture
	 */
	public SetBankParametersNCTResultItem(String logoPicture) {
		super();
		this.logoPicture = logoPicture;
	}

	public String getLogoPicture() {
		return logoPicture;
	}

	public void setLogoPicture(String logoPicture) {
		this.logoPicture = logoPicture;
	}

	@Override
	public String toString() {
		return "SetBankParametersNCTResultItem [logoPicture=" + logoPicture + "]";
	}

}

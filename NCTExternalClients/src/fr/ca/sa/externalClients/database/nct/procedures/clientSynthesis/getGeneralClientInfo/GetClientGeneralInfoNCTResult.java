package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getGeneralClientInfo;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.model.Client;

/**
 * 
 * Wrapper for returning general client info JSON response
 * 
 * @author Nemanja Ignjatov
 * 
 * @author Djordje Przulj 
 *
 */
public class GetClientGeneralInfoNCTResult implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Client client;
	
	private boolean printAllowed;
	private boolean basketPrintAllowed;

	/**
	 * default constructor for Get Client General Info NCT Result
	 */
	public GetClientGeneralInfoNCTResult() {
		super();
	}

	/**
	 * Get Client General Info NCT Result
	 * 
	 * @param client
	 *            Client 
	 */
	public GetClientGeneralInfoNCTResult(Client client) {
		super();
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public boolean isPrintAllowed() {
		return printAllowed;
	}

	public void setPrintAllowed(boolean printAllowed) {
		this.printAllowed = printAllowed;
	}

	public boolean isBasketPrintAllowed() {
		return basketPrintAllowed;
	}

	public void setBasketPrintAllowed(boolean basketPrintAllowed) {
		this.basketPrintAllowed = basketPrintAllowed;
	}

	@Override
	public String toString() {
		return "GetClientGeneralInfoNCTResult [client=" + client + ", printAllowed="
				+ printAllowed + ", basketPrintAllowed=" + basketPrintAllowed + "]";
	}

}

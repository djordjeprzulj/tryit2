package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.prospectRelates.getProspectRelates;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetProspectRelatesNCTResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer clientId;

	private String clientName;

	private String clientSurname;

	private Integer relateId;

	/**
	 * default constructor for Get Prospect Relates NCT Result Item
	 */
	public GetProspectRelatesNCTResultItem() {
		super();
	}

	/**
	 * Get Prospect Relates NCT Result Item
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param clientName	
	 * 				Client name
	 * 
	 * @param clientSurname
	 * 				Client surname
	 * 
	 * @param relateId
	 * 				Relate ID
	 */
	public GetProspectRelatesNCTResultItem(Integer clientId, String clientName, String clientSurname,
			Integer relateId) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientSurname = clientSurname;
		this.relateId = relateId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientSurname() {
		return clientSurname;
	}

	public void setClientSurname(String clientSurname) {
		this.clientSurname = clientSurname;
	}

	public Integer getRelateId() {
		return relateId;
	}

	public void setRelateId(Integer relateId) {
		this.relateId = relateId;
	}

	@Override
	public String toString() {
		return "GetProspectRelatesItem [clientId=" + clientId + ", clientName=" + clientName + ", clientSurname="
				+ clientSurname + ", relateId=" + relateId + "]";
	}

}

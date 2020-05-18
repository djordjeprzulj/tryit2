package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getAgreedProductStatuses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SAAgreedProductStatusResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<SAAgreedProductStatusItem> agreedProductStatusesList;

	/**
	 * default constructor for Sales Assistant Agreed Product Status Result List
	 */
	public SAAgreedProductStatusResultList() {
		super();
		this.agreedProductStatusesList = new ArrayList<>();
	}

	/**
	 * Sales Assistant Agreed Product Status Result List
	 * 
	 * @param agreedProductStatusesList
	 * 				Agreed product statuses list
	 */
	public SAAgreedProductStatusResultList(List<SAAgreedProductStatusItem> agreedProductStatusesList) {
		super();
		this.agreedProductStatusesList = agreedProductStatusesList;
	}

	public List<SAAgreedProductStatusItem> getAgreedProductStatusesList() {
		return agreedProductStatusesList;
	}

	public void setAgreedProductStatusesList(List<SAAgreedProductStatusItem> agreedProductStatusesList) {
		this.agreedProductStatusesList = agreedProductStatusesList;
	}

	@Override
	public String toString() {
		return "SAAgreedProductStatusResultList [agreedProductStatusesList=" + agreedProductStatusesList + "]";
	}

}

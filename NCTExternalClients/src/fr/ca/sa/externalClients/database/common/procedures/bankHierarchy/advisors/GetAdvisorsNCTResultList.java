package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.advisors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for all results from spGetBankAdvisors store procedure
 * 
 * * @author Nemanja Ignjatov
 */

public class GetAdvisorsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetAdvisorsNCTResultItem> advisors;

	/**
	 * default constructor for Get Advisors NCT Result List
	 */
	public GetAdvisorsNCTResultList() {
		super();
		advisors = new ArrayList<GetAdvisorsNCTResultItem>();
	}

	/**
	 * Get Advisors NCT Result List
	 * 
	 * @param advisors
	 * 				Advisors
	 */
	public GetAdvisorsNCTResultList(List<GetAdvisorsNCTResultItem> advisors) {
		super();
		this.advisors = advisors;
	}

	public List<GetAdvisorsNCTResultItem> getAdvisors() {
		return advisors;
	}

	public void setAdvisors(List<GetAdvisorsNCTResultItem> advisors) {
		this.advisors = advisors;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetAdvisorsNCTResultList [ ");
		if(advisors != null){
			for (GetAdvisorsNCTResultItem advisorsItem : advisors) {
				sbRetValue.append(advisorsItem.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}
		
		return "GetAdvisorsNCTResultList is empty!!!";
	}

}

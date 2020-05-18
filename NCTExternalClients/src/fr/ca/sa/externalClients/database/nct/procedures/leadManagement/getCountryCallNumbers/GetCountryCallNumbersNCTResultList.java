package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.getCountryCallNumbers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for list of call numbers for country
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetCountryCallNumbersNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetCountryCallNumbersNCTResultItem> callNumbers;

	/**
	 * default constructor for Get Country Call Numbers NCT Result List
	 */
	public GetCountryCallNumbersNCTResultList() {
		this.callNumbers = new ArrayList<GetCountryCallNumbersNCTResultItem>();
	}

	/**
	 * Get Country Call Numbers NCT Result List
	 * 
	 * @param callNumbers
	 * 				Call numbers
	 */
	public GetCountryCallNumbersNCTResultList(List<GetCountryCallNumbersNCTResultItem> callNumbers) {
		super();
		this.callNumbers = callNumbers;
	}

	public List<GetCountryCallNumbersNCTResultItem> getCallNumbers() {
		return callNumbers;
	}

	public void setCallNumbers(List<GetCountryCallNumbersNCTResultItem> callNumbers) {
		this.callNumbers = callNumbers;
	}

	@Override
	public String toString() {
		return "GetCountryCallNumbersNCTResultList [callNumbers=" + callNumbers + "]";
	}

}

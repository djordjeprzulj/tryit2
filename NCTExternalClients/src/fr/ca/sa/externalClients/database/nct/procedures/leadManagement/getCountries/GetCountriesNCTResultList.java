package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.getCountries;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for list of countries
 * 
 * @author Nemanja Ignjatov
 *
 */

public class GetCountriesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetCountriesNCTResultItem> countries;

	/**
	 * default constructor for Get Countries NCT Result List
	 */
	public GetCountriesNCTResultList() {
		this.countries = new ArrayList<GetCountriesNCTResultItem>();
	}

	/**
	 * Get Countries NCT Result List
	 * 
	 * @param countries
	 * 				Countries
	 */
	public GetCountriesNCTResultList(List<GetCountriesNCTResultItem> countries) {
		super();
		this.countries = countries;
	}

	public List<GetCountriesNCTResultItem> getCountries() {
		return countries;
	}

	public void setCountries(List<GetCountriesNCTResultItem> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "GetCountriesNCTResultList [countries=" + countries + "]";
	}

}

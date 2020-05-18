package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response SON wrapper for get opportunity views configuration
 * 
 * @author Nemanja Ignjatov
 *
 */
public class OpportunityViewConfiguration implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int expirationDays;
	private Map<String, String> types;

	/**
	 * default constructor for Opportunity View Configuration
	 */
	public OpportunityViewConfiguration() {
		super();
		this.types = new HashMap<String, String>();
	}

	/**
	 * Opportunity View Configuration
	 * 
	 * @param expirationDays
	 * 				Expiration days
	 * 
	 * @param types
	 * 				Types
	 */
	public OpportunityViewConfiguration(int expirationDays, Map<String, String> types) {
		super();
		this.expirationDays = expirationDays;
		this.types = types;
	}

	public int getExpirationDays() {
		return expirationDays;
	}

	public void setExpirationDays(int expirationDays) {
		this.expirationDays = expirationDays;
	}

	public Map<String, String> getTypes() {
		return types;
	}

	public void setTypes(Map<String, String> types) {
		this.types = types;
	}

}

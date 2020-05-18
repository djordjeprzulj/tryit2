package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response SON wrapper for get views configuration
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ViewsConfigurationResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, LinkedHashMap<String, String>> views;
	private OpportunityViewConfiguration opportunities;

	/**
	 * default constructor for Views Configuration Response
	 */
	public ViewsConfigurationResponse() {
		super();
		this.views = new HashMap<String, LinkedHashMap<String, String>>();
	}

	/**
	 * Views Configuration Response
	 * 
	 * @param views
	 * 				Views
	 * 
	 * @param opportunities
	 * 				Opportunities
	 */
	public ViewsConfigurationResponse(Map<String, LinkedHashMap<String, String>> views,
			OpportunityViewConfiguration opportunities) {
		super();
		this.views = views;
		this.opportunities = opportunities;
	}

	public Map<String, LinkedHashMap<String, String>> getViews() {
		return views;
	}

	public void setViews(Map<String, LinkedHashMap<String, String>> views) {
		this.views = views;
	}

	public OpportunityViewConfiguration getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(OpportunityViewConfiguration opportunities) {
		this.opportunities = opportunities;
	}

}

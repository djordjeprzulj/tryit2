package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response JSON wrapper for getting sales assistant configuration
 * 
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SalesAssistantConfigurationContainer implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<TranslatableNeedCategory> needsConfiguration;

	/**
	 * default constructor for Sales Assistant Configuration Container
	 */
	public SalesAssistantConfigurationContainer() {
		super();
		this.needsConfiguration = new ArrayList<TranslatableNeedCategory>();
	}

	public List<TranslatableNeedCategory> getNeedsConfiguration() {
		return needsConfiguration;
	}

	public void setNeedsConfiguration(List<TranslatableNeedCategory> needsConfiguration) {
		this.needsConfiguration = needsConfiguration;
	}

	@Override
	public String toString() {
		return "SalesAssistantConfigurationContainer [needsConfiguration=" + needsConfiguration + "]";
	}

}

package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.commonEntities.TranslatableElementConf;

/**
 * 
 * Sales assistant configuration holder
 * 
 * @author Sasa Radovanovic
 *
 */
public class SalesAssistantConfiguration implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<TranslatableNeedCategory> needs;
	private List<TranslatableElementConf> origins;
	private List<TranslatableElementConf> notIntReasons;
	private List<TranslatableElementConf> agreedProductStatuses;
	private List<TranslatableElementConf> agreedProductTypes;
	private List<TranslatableElementConf> channels;

	/**
	 * Sales Assistant Configuration
	 * 
	 * @param needs
	 * 				Needs
	 * 
	 * @param origins
	 * 				Origins
	 * 
	 * @param notIntReasons
	 * 				Not interested reasons
	 * 
	 * @param agreedProductStatuses
	 * 				Agreed product statuses
	 * 
	 * @param agreedProductTypes
	 * 				Agreed product types
	 * 
	 * @param channels
	 * 				Channels
	 */
	public SalesAssistantConfiguration(List<TranslatableNeedCategory> needs,
			List<TranslatableElementConf> origins, List<TranslatableElementConf> notIntReasons,
			List<TranslatableElementConf> agreedProductStatuses,
			List<TranslatableElementConf> agreedProductTypes, List<TranslatableElementConf> channels) {
		super();
		this.needs = needs;
		this.origins = origins;
		this.notIntReasons = notIntReasons;
		this.agreedProductStatuses = agreedProductStatuses;
		this.agreedProductTypes = agreedProductTypes;
		this.channels = channels;
	}

	public List<TranslatableNeedCategory> getNeeds() {
		return needs;
	}

	public void setNeeds(List<TranslatableNeedCategory> needs) {
		this.needs = needs;
	}

	public List<TranslatableElementConf> getOrigins() {
		return origins;
	}

	public void setOrigins(List<TranslatableElementConf> origins) {
		this.origins = origins;
	}

	public List<TranslatableElementConf> getNotIntReasons() {
		return notIntReasons;
	}

	public void setNotIntReasons(List<TranslatableElementConf> notIntReasons) {
		this.notIntReasons = notIntReasons;
	}

	public List<TranslatableElementConf> getAgreedProductStatuses() {
		return agreedProductStatuses;
	}

	public void setAgreedProductStatuses(List<TranslatableElementConf> agreedProductStatuses) {
		this.agreedProductStatuses = agreedProductStatuses;
	}

	public List<TranslatableElementConf> getAgreedProductTypes() {
		return agreedProductTypes;
	}

	public void setAgreedProductTypes(List<TranslatableElementConf> agreedProductTypes) {
		this.agreedProductTypes = agreedProductTypes;
	}

	public List<TranslatableElementConf> getChannels() {
		return channels;
	}

	public void setChannels(List<TranslatableElementConf> channels) {
		this.channels = channels;
	}

}

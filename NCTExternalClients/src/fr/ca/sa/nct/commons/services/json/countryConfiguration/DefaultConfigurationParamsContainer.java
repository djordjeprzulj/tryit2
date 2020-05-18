package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

public class DefaultConfigurationParamsContainer implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer country;
	private Integer requestedBy;
	private Integer channel;
	private Integer countryId;
	private Integer requestedById;
	private Integer channelId;
	
	public DefaultConfigurationParamsContainer() {
		super();
	}

	public DefaultConfigurationParamsContainer(Integer country, Integer requestedBy, Integer channel, Integer countryId,
			Integer requestedById, Integer channelId) {
		super();
		this.country = country;
		this.requestedBy = requestedBy;
		this.channel = channel;
		this.countryId = countryId;
		this.requestedById = requestedById;
		this.channelId = channelId;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(Integer requestedBy) {
		this.requestedBy = requestedBy;
	}

	public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getRequestedById() {
		return requestedById;
	}

	public void setRequestedById(Integer requestedById) {
		this.requestedById = requestedById;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	@Override
	public String toString() {
		return "DefaultConfigurationParamsContainer [country=" + country + ", requestedBy=" + requestedBy + ", channel="
				+ channel + ", countryId=" + countryId + ", requestedById=" + requestedById + ", channelId=" + channelId
				+ "]";
	}

	

}

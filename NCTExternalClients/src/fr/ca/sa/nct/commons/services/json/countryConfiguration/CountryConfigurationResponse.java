package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.procedures.campaigns.getHomepageCampaigns.GetHomepageCampaignsNCTResultItem;
import fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioTypes.GetPortfolioTypesNCTResultItem;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getCurrencies.GetCurrenciesNCTResultItem;
import fr.ca.sa.nct.commons.commonEntities.TranslatableElementConf;

/**
 * 
 * Response JSON wrapper for merged bank hierarchy, opportunities and views
 * configuration
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CountryConfigurationResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private CountryHierarchyResponse hierarchy;
	private OpportunitiesConfigurationResponse opportunitiesConfig;
	private ViewsConfigurationResponse viewsConfiguration;
	private List<GetCurrenciesNCTResultItem> currencies;
	private Integer basketExpiration;
	private List<TranslatableElementConf> clientOrigins;
	private List<GetPortfolioTypesNCTResultItem> portfolioTypes;
	private List<HomepageLinksTranslatableItem> homepageLinks;
	private DateTimeFormatConfiguration dateTime;
	private Integer contactReportDaysInPast;
	private String claimToolLink;
	private String progressLink;
	private List<GetHomepageCampaignsNCTResultItem> homepageCampaigns;
	private List<TranslatableElementConf> statisticsList;
	private String ctGeolocationLink;
	private String ctSuperScreenLink;
	private String ctSalesLink;
	private DefaultConfigurationParamsContainer defaultParameters;
	private boolean opportunitySummaryAccess;
	private String currancyNumberFormat;

	public String getCurrancyNumberFormat() {
		return currancyNumberFormat;
	}

	public void setCurrancyNumberFormat(String currancyNumberFormat) {
		this.currancyNumberFormat = currancyNumberFormat;
	}

	/**
	 * default constructor for Country Configuration Response
	 */
	public CountryConfigurationResponse() {
		super();
	}

	/**
	 * Country Configuration Response
	 * 
	 * @param hierarchy           Hierarchy
	 * 
	 * @param opportunitiesConfig Opportunities configuration
	 * 
	 * @param viewsConfiguration  Views configuration
	 * 
	 * @param currencies          Currencies
	 */
	public CountryConfigurationResponse(CountryHierarchyResponse hierarchy,
			OpportunitiesConfigurationResponse opportunitiesConfig, ViewsConfigurationResponse viewsConfiguration,
			List<GetCurrenciesNCTResultItem> currencies) {
		super();
		this.hierarchy = hierarchy;
		this.opportunitiesConfig = opportunitiesConfig;
		this.viewsConfiguration = viewsConfiguration;
		this.currencies = currencies;
	}

	public CountryHierarchyResponse getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(CountryHierarchyResponse hierarchy) {
		this.hierarchy = hierarchy;
	}

	public OpportunitiesConfigurationResponse getOpportunitiesConfig() {
		return opportunitiesConfig;
	}

	public void setOpportunitiesConfig(OpportunitiesConfigurationResponse opportunitiesConfig) {
		this.opportunitiesConfig = opportunitiesConfig;
	}

	public ViewsConfigurationResponse getViewsConfiguration() {
		return viewsConfiguration;
	}

	public void setViewsConfiguration(ViewsConfigurationResponse viewsConfiguration) {
		this.viewsConfiguration = viewsConfiguration;
	}

	public List<GetCurrenciesNCTResultItem> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<GetCurrenciesNCTResultItem> currencies) {
		this.currencies = currencies;
	}

	public Integer getBasketExpiration() {
		return basketExpiration;
	}

	public void setBasketExpiration(Integer basketExpiration) {
		this.basketExpiration = basketExpiration;
	}

	public List<TranslatableElementConf> getClientOrigins() {
		return clientOrigins;
	}

	public void setClientOrigins(List<TranslatableElementConf> clientOrigins) {
		this.clientOrigins = clientOrigins;
	}

	public List<GetPortfolioTypesNCTResultItem> getPortfolioTypes() {
		return portfolioTypes;
	}

	public void setPortfolioTypes(List<GetPortfolioTypesNCTResultItem> portfolioTypes) {
		this.portfolioTypes = portfolioTypes;
	}

	public List<HomepageLinksTranslatableItem> getHomepageLinks() {
		return homepageLinks;
	}

	public void setHomepageLinks(List<HomepageLinksTranslatableItem> homepageLinks) {
		this.homepageLinks = homepageLinks;
	}

	public DateTimeFormatConfiguration getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTimeFormatConfiguration dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getContactReportDaysInPast() {
		return contactReportDaysInPast;
	}

	public void setContactReportDaysInPast(Integer contactReportDaysInPast) {
		this.contactReportDaysInPast = contactReportDaysInPast;
	}

	public String getClaimToolLink() {
		return claimToolLink;
	}

	public void setClaimToolLink(String claimToolLink) {
		this.claimToolLink = claimToolLink;
	}

	public String getProgressLink() {
		return progressLink;
	}

	public void setProgressLink(String progressLink) {
		this.progressLink = progressLink;
	}

	public List<GetHomepageCampaignsNCTResultItem> getHomepageCampaigns() {
		return homepageCampaigns;
	}

	public void setHomepageCampaigns(List<GetHomepageCampaignsNCTResultItem> homepageCampaigns) {
		this.homepageCampaigns = homepageCampaigns;
	}

	public List<TranslatableElementConf> getStatisticsList() {
		return statisticsList;
	}

	public void setStatisticsList(List<TranslatableElementConf> statisticsList) {
		this.statisticsList = statisticsList;
	}

	public String getCtGeolocationLink() {
		return ctGeolocationLink;
	}

	public void setCtGeolocationLink(String ctGeolocationUrl) {
		this.ctGeolocationLink = ctGeolocationUrl;
	}

	public String getCtSuperScreenLink() {
		return ctSuperScreenLink;
	}

	public void setCtSuperScreenLink(String ctSuperScreenUrl) {
		this.ctSuperScreenLink = ctSuperScreenUrl;
	}

	public String getCtSalesLink() {
		return ctSalesLink;
	}

	public void setCtSalesLink(String ctSalesUrl) {
		this.ctSalesLink = ctSalesUrl;
	}

	public DefaultConfigurationParamsContainer getDefaultParameters() {
		return defaultParameters;
	}

	public void setDefaultParameters(DefaultConfigurationParamsContainer defaultParameters) {
		this.defaultParameters = defaultParameters;
	}

	public boolean isOpportunitySummaryAccess() {
		return opportunitySummaryAccess;
	}

	public void setOpportunitySummaryAccess(boolean opportunitySummaryAccess) {
		this.opportunitySummaryAccess = opportunitySummaryAccess;
	}

	@Override
	public String toString() {
		return "CountryConfigurationResponse [hierarchy=" + hierarchy + ", opportunitiesConfig=" + opportunitiesConfig
				+ ", viewsConfiguration=" + viewsConfiguration + ", currencies=" + currencies + ", basketExpiration="
				+ basketExpiration + ", clientOrigins=" + clientOrigins + ", portfolioTypes=" + portfolioTypes
				+ ", homepageLinks=" + homepageLinks + ", dateTime=" + dateTime + ", contactReportDaysInPast="
				+ contactReportDaysInPast + ", claimToolLink=" + claimToolLink + ", progressLink=" + progressLink
				+ ", homepageCampaigns=" + homepageCampaigns + ", statisticsList=" + statisticsList
				+ ", ctGeolocationLink=" + ctGeolocationLink + ", ctSuperScreenLink=" + ctSuperScreenLink
				+ ", ctSalesLink=" + ctSalesLink + ", defaultParameters=" + defaultParameters
				+ ", opportunitySummaryAccess=" + opportunitySummaryAccess + "]";
	}
}

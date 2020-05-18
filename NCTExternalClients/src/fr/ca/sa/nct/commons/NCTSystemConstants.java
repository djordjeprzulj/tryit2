package fr.ca.sa.nct.commons;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.configs.FileSystemConfig;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.advisors.GetAdvisorsNCTResultList;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankEntities.GetBankEntitiesNCTResultList;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankParameters.GetBankParametersNCTResultItem;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankSegments.GetBankSegmentsNCTResultList;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.clientTypes.GetClientTypesNCTResultList;
import fr.ca.sa.externalClients.database.common.procedures.campaigns.getHomepageCampaigns.GetHomepageCampaignsNCTResultItem;
import fr.ca.sa.externalClients.database.common.procedures.worktime.getWorktime.GetBankEntityWorkTimeNCTResultList;
import fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioTypes.GetPortfolioTypesNCTResultList;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getCurrencies.GetCurrenciesNCTResultList;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNeedsCategories.GetNeedsCategoriesNCTResultItem;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductCatalog.GetProductCatalogNCTResultItem;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductGroup.GetProductGroupNCTResultItem;
import fr.ca.sa.externalClients.ldap.LDAPClientSystemConstants;
import fr.ca.sa.externalClients.sso.KeyCloakConfiguration;
import fr.ca.sa.nct.commons.commonEntities.AgendaItemConf;
import fr.ca.sa.nct.commons.commonEntities.QuickContactTemplate;
import fr.ca.sa.nct.commons.commonEntities.TranslatableElementConf;
import fr.ca.sa.nct.commons.services.json.audit.AuditConfigurationResponse;
import fr.ca.sa.nct.commons.services.json.countryConfiguration.BankBankMergedItem;
import fr.ca.sa.nct.commons.services.json.countryConfiguration.BankBranchMergedItem;
import fr.ca.sa.nct.commons.services.json.countryConfiguration.BankMainBranchMergedItem;
import fr.ca.sa.nct.commons.services.json.countryConfiguration.BankRegionMergedItem;
import fr.ca.sa.nct.commons.services.json.countryConfiguration.DateTimeFormatConfiguration;
import fr.ca.sa.nct.commons.services.json.countryConfiguration.DefaultConfigurationParamsContainer;
import fr.ca.sa.nct.commons.services.json.countryConfiguration.HomepageLinksTranslatableItem;
import fr.ca.sa.nct.commons.services.json.countryConfiguration.OpportunityViewConfiguration;
import fr.ca.sa.nct.commons.services.json.countryConfiguration.ViewsConfigurationResponse;
import fr.ca.sa.nct.commons.services.json.leadManagement.LeadManagementConfigurationContainer;
import fr.ca.sa.nct.commons.services.json.salesAssistant.SalesAssistantConfigurationContainer;

/**
 * 
 * System constants for runtime operations
 * 
 * @author Sasa Radovanovic
 *
 */
public final class NCTSystemConstants {

	private NCTSystemConstants() {
		throw new IllegalAccessError("Utility class");
	}

	private static final Integer REINIT_TIMER_TMR_MINUTES_DEFAULT = 10;
	private static final Integer REINIT_TIMER_TMR_HOURS_DEFAULT = 21;
	private static final int WS_MESSAGES_CACHE_EXPIRATION_DEFAULT = 5;
	private static final long PICTURES_KEEP_ALIVE_PERIOD_DAYS_DEFAULT = 5;
	private static final Integer USER_SEARCH_LIMIT_DEFAULT = 1000;
	private static final Integer BASKET_EXPIRATION_HOURS_DEFAULT = 24;
	private static final Integer CONTACT_REPORT_DAYS_IN_PAST_DEFAULT = 3;
	private static final Integer AUDIT_LOG_ROWS_LIMIT_DEFAULT = 1000;

	public static final Integer TMR_MINUTES_DEFAULT = 5;
	public static final Integer TMR_HOURS_DEFAULT = 0;
	public static final Integer TMR_MINUTES_DIVISION = 5;

	private static FileSystemConfig fileSystemConfig;
	private static LDAPClientSystemConstants ldapConfiguration;
	private static KeyCloakConfiguration ssoConfiguration;

	// Re-Init timer constants
	private static Integer REINIT_TIMER_TMR_MINUTES = REINIT_TIMER_TMR_MINUTES_DEFAULT;
	private static Integer REINIT_TIMER_TMR_HOURS = REINIT_TIMER_TMR_HOURS_DEFAULT;

	// Session length for keeping cached WS messages in queue (in minutes)
	public static final int WS_MESSAGES_CACHE_EXPIRATION = WS_MESSAGES_CACHE_EXPIRATION_DEFAULT;

	private static String VIEWS_CONFIG;

	// Selected environment on system boot
	private static String RUNTIME_ENV;

	// WSDL
	private static Boolean WSDL_WITH_DEPOSITS_OPCV;
	private static String WSDL_ADDRESS = "";
	private static String WSDL_ADDRESS_LEAD = "";

	private static String ENDPOINT_ADDRESS = "";
	private static String ENDPOINT_ADDRESS_LEAD = "";

	private static Boolean LEAD_WS;

	// Picture expiration period in seconds
	private static long PICTURES_KEEP_ALIVE_PERIOD_DAYS = PICTURES_KEEP_ALIVE_PERIOD_DAYS_DEFAULT;

	// Limit for user search results
	// Default value 1000
	private static Integer USER_SEARCH_LIMIT = USER_SEARCH_LIMIT_DEFAULT;

	// Limit for editing and creating agenda items in past
	private static Integer AGENDA_PAST_DAYS = 0;

	// How many hours should basket be persisted in local storage
	private static Integer BASKET_EXPIRATION_HOURS = BASKET_EXPIRATION_HOURS_DEFAULT;

	private static String CURRANCY_NUMBER_FORMAT = "";

	// How many days in past from today advisor can created contact report
	private static Integer CONTACT_REPORT_DAYS_IN_PAST = CONTACT_REPORT_DAYS_IN_PAST_DEFAULT;

	// Link to the claim tool application
	private static String CLAIM_TOOL_LINK = null;

	// Link to the progress bar application
	private static String PROGRESS_LINK = null;

	// Max number of rows in audit log
	private static Integer AUDIT_LOG_ROWS_LIMIT = AUDIT_LOG_ROWS_LIMIT_DEFAULT;

	// Bank work time holder
	private static GetBankEntityWorkTimeNCTResultList bankWorktime = new GetBankEntityWorkTimeNCTResultList();

	private static DefaultConfigurationParamsContainer defaultConfigParams = null;

	// Supported languages in app
	private static Map<String, GetBankParametersNCTResultItem> languageMap = new HashMap<String, GetBankParametersNCTResultItem>();
	private static GetBankParametersNCTResultItem defaultLang = null;

	private static int languageOrder1Id;
	private static int languageOrder2Id;
	private static String languageOrder1Code;
	private static String languageOrder2Code;

	// Configuration attributes and parameters - opportunities,views,limits....
	private static OpportunityViewConfiguration opportunityViewConfiguration = null;

	private static ViewsConfigurationResponse viewsConfigurations = null;

	// Agenda items configuration
	private static Map<Integer, AgendaItemConf> agendaItemConfigurationMap = new HashMap<Integer, AgendaItemConf>();

	private static Map<String, ArrayList<TranslatableElementConf>> agendaConfiguration = new HashMap<String, ArrayList<TranslatableElementConf>>();

	private static List<TranslatableElementConf> salesAssistantOrigins = new ArrayList<>();

	private static List<TranslatableElementConf> salesAssistantNotIntReasons = new ArrayList<>();

	private static List<TranslatableElementConf> salesAssistantAgreedProductStatuses = new ArrayList<>();

	private static List<TranslatableElementConf> salesAssistantAgreedProductTypes = new ArrayList<>();

	private static List<TranslatableElementConf> salesAssistantOpportunityStatuses = new ArrayList<>();

	private static Map<String, String> agendaItemTypeFieldMapping = new HashMap<String, String>();

	private static Map<Integer, Integer> agendaAdvisorMapping = new HashMap<Integer, Integer>();

	private static Map<String, ArrayList<TranslatableElementConf>> quickContactReportConf = new HashMap<String, ArrayList<TranslatableElementConf>>();

	private static List<QuickContactTemplate> quickContactReportTemplates = new ArrayList<QuickContactTemplate>();

	private static List<QuickContactTemplate> msgTemplates = new ArrayList<QuickContactTemplate>();

	private static LeadManagementConfigurationContainer leadManagementConf = null;

	private static SalesAssistantConfigurationContainer salesAssistantConf = null;

	private static GetCurrenciesNCTResultList currenciesConfig = null;

	private static AuditConfigurationResponse auditConfig = null;

	private static List<TranslatableElementConf> clientOriginsConfig = null;

	private static GetPortfolioTypesNCTResultList portfolioTypes = null;

	private static List<HomepageLinksTranslatableItem> homepageLinks = null;

	private static DateTimeFormatConfiguration dateTimeFormats = null;

	private static List<GetHomepageCampaignsNCTResultItem> homepageCampaigns = null;

	private static List<TranslatableElementConf> statisticsList = null;

	private static Map<Integer, String> opportunityCategoriesPictures = new HashMap<Integer, String>();

	private static String productDefaultImg = null;

	private static String opportunityDefaultImg = null;

	private static PublicKey keycloakPublicKey = null;

	private static String keycloakClientId = null;

	private static String keycloakRealm = null;

	private static String keycloakURL = null;

	private static int dbBankId;

	private static Map<Integer, String> productGroupPicturesMap = new HashMap<Integer, String>();
	private static Map<Integer, String> productPicturesMap = new HashMap<Integer, String>();

	private static Map<Integer, GetProductCatalogNCTResultItem> productCatalogMap = new HashMap<Integer, GetProductCatalogNCTResultItem>();
	private static Map<Integer, GetProductGroupNCTResultItem> productGroupsMap = new HashMap<Integer, GetProductGroupNCTResultItem>();
	private static Map<Integer, GetNeedsCategoriesNCTResultItem> needCategoriesMap = new HashMap<Integer, GetNeedsCategoriesNCTResultItem>();

	private static GetAdvisorsNCTResultList advisorsList = null;
	private static GetBankEntitiesNCTResultList allBankEntities = null;
	private static List<BankBranchMergedItem> mergeBranches = new ArrayList<BankBranchMergedItem>();
	private static List<BankMainBranchMergedItem> mergeMainBranches = new ArrayList<BankMainBranchMergedItem>();
	private static List<BankRegionMergedItem> mergeRegions = new ArrayList<BankRegionMergedItem>();
	private static List<BankBankMergedItem> mergeBanks = new ArrayList<BankBankMergedItem>();

	private static GetClientTypesNCTResultList clientTypes;
	private static GetBankSegmentsNCTResultList bankSegments;

	private static String cbkAdapterAddress;

	private static String bizCtxConfigurationUnvrs;
	private static String bizCtxConfigurationAppName;

	private static String ctxTransferSessionAppId;
	private static String ctxTransferSessionSslbtp;
	private static String ctxTransferSessionHdrMd;

	private static String ctxTransferGeolocationLink;
	private static String ctxTransferSuperScreenLink;
	private static String ctxTransferSalesLink;

	private static Boolean functionRoleMapping;

	private static String accessControlAllowOrigin;
	private static String managementAccessControlAllowOrigin;

	private static String leadSageLink;
	private static String basketSageLink;

	public static synchronized FileSystemConfig getFileSystemConfig() {
		if (fileSystemConfig == null) {
			fileSystemConfig = new FileSystemConfig();
		}
		return fileSystemConfig;
	}

	public static Integer getTmrMinutes() {
		return REINIT_TIMER_TMR_MINUTES;
	}

	public static void setTmrMinutes(Integer tmrMinutes) {
		REINIT_TIMER_TMR_MINUTES = tmrMinutes;
	}

	public static Integer getTmrHours() {
		return REINIT_TIMER_TMR_HOURS;
	}

	public static void setTmrHours(Integer tmrHours) {
		REINIT_TIMER_TMR_HOURS = tmrHours;
	}

	public static String getRuntimeEnv() {
		return RUNTIME_ENV;
	}

	public static void setRuntimeEnv(String runtimeEnv) {
		RUNTIME_ENV = runtimeEnv;
	}

	public static Boolean getWsdlWithDepositsOPCV() {
		return WSDL_WITH_DEPOSITS_OPCV;
	}

	public static void setWsdlWithDepositsOPCV(Boolean wsdlWithDepositsOPCV) {
		WSDL_WITH_DEPOSITS_OPCV = wsdlWithDepositsOPCV;
	}

	public static String getWsdlAddress() {
		return WSDL_ADDRESS;
	}

	public static void setWsdlAddress(String wsdlAddress) {
		WSDL_ADDRESS = wsdlAddress;
	}

	/**
	 * @return the wSDL_ADDRESS_LEAD
	 */
	public static String getWsdlAddressLead() {
		return WSDL_ADDRESS_LEAD;
	}

	/**
	 * @param wSDL_ADDRESS_LEAD the wSDL_ADDRESS_LEAD to set
	 */
	public static void setWsdlAddressLead(String wsdlAddressLead) {
		WSDL_ADDRESS_LEAD = wsdlAddressLead;
	}

	/**
	 * @return the lEAD_WS
	 */
	public static Boolean getLeadWS() {
		return LEAD_WS;
	}

	/**
	 * @param lEAD_WS the lEAD_WS to set
	 */
	public static void setLeadWS(Boolean leadWS) {
		LEAD_WS = leadWS;
	}

	public static long getPicturesKeepAlivePeriodDays() {
		return PICTURES_KEEP_ALIVE_PERIOD_DAYS;
	}

	public static void setPicturesKeepAlivePeriodDays(long picturesKeepAlivePeriodDays) {
		PICTURES_KEEP_ALIVE_PERIOD_DAYS = picturesKeepAlivePeriodDays;
	}

	public static Integer getUserSearchLimit() {
		return USER_SEARCH_LIMIT;
	}

	public static void setUserSearchLimit(Integer userSearchLimit) {
		USER_SEARCH_LIMIT = userSearchLimit;
	}

	public static Integer getAgendaPastDays() {
		return AGENDA_PAST_DAYS;
	}

	public static void setAgendaPastDays(Integer agendaPastDays) {
		AGENDA_PAST_DAYS = agendaPastDays;
	}

	public static Integer getBasketExpirationHours() {
		return BASKET_EXPIRATION_HOURS;
	}

	public static void setBasketExpirationHours(Integer basketExpirationHours) {
		BASKET_EXPIRATION_HOURS = basketExpirationHours;
	}

	public static Integer getContactReportDaysInPast() {
		return CONTACT_REPORT_DAYS_IN_PAST;
	}

	public static void setContactReportDaysInPast(Integer contactReportDaysInPast) {
		CONTACT_REPORT_DAYS_IN_PAST = contactReportDaysInPast;
	}

	public static String getClaimToolLink() {
		return CLAIM_TOOL_LINK;
	}

	public static void setClaimToolLink(String claimToolLink) {
		CLAIM_TOOL_LINK = claimToolLink;
	}

	public static String getProgressLink() {
		return PROGRESS_LINK;
	}

	public static void setProgressLink(String progressLink) {
		PROGRESS_LINK = progressLink;
	}

	public static Integer getAuditLogRowsLimit() {
		return AUDIT_LOG_ROWS_LIMIT;
	}

	public static void setAuditLogRowsLimit(Integer auditLogRowsLimit) {
		AUDIT_LOG_ROWS_LIMIT = auditLogRowsLimit;
	}

	public static GetBankEntityWorkTimeNCTResultList getBankWorktime() {
		return bankWorktime;
	}

	public static void setBankWorktime(GetBankEntityWorkTimeNCTResultList bankWorktime) {
		NCTSystemConstants.bankWorktime = bankWorktime;
	}

	public static Map<String, GetBankParametersNCTResultItem> getLanguageMap() {
		return languageMap;
	}

	public static void setLanguageMap(Map<String, GetBankParametersNCTResultItem> languageMap) {
		NCTSystemConstants.languageMap = languageMap;
	}

	public static GetBankParametersNCTResultItem getDefaultLang() {
		return defaultLang;
	}

	public static void setDefaultLang(GetBankParametersNCTResultItem defaultLang) {
		NCTSystemConstants.defaultLang = defaultLang;
	}

	public static OpportunityViewConfiguration getOpportunityViewConfiguration() {
		return opportunityViewConfiguration;
	}

	public static void setOpportunityViewConfiguration(OpportunityViewConfiguration opportunityViewConfiguration) {
		NCTSystemConstants.opportunityViewConfiguration = opportunityViewConfiguration;
	}

	public static ViewsConfigurationResponse getViewsConfigurations() {
		return viewsConfigurations;
	}

	public static void setViewsConfigurations(ViewsConfigurationResponse viewsConfigurations) {
		NCTSystemConstants.viewsConfigurations = viewsConfigurations;
	}

	public static Map<Integer, AgendaItemConf> getAgendaItemConfigurationMap() {
		return agendaItemConfigurationMap;
	}

	public static void setAgendaItemConfigurationMap(Map<Integer, AgendaItemConf> agendaItemConfigurationMap) {
		NCTSystemConstants.agendaItemConfigurationMap = agendaItemConfigurationMap;
	}

	public static Map<String, ArrayList<TranslatableElementConf>> getAgendaConfiguration() {
		return agendaConfiguration;
	}

	public static void setAgendaConfiguration(Map<String, ArrayList<TranslatableElementConf>> agendaConfiguration) {
		NCTSystemConstants.agendaConfiguration = agendaConfiguration;
	}

	public static List<TranslatableElementConf> getSalesAssistantOrigins() {
		return salesAssistantOrigins;
	}

	public static void setSalesAssistantOrigins(List<TranslatableElementConf> salesAssistantOrigins) {
		NCTSystemConstants.salesAssistantOrigins = salesAssistantOrigins;
	}

	public static List<TranslatableElementConf> getSalesAssistantNotIntReasons() {
		return salesAssistantNotIntReasons;
	}

	public static void setSalesAssistantNotIntReasons(List<TranslatableElementConf> salesAssistantNotIntReasons) {
		NCTSystemConstants.salesAssistantNotIntReasons = salesAssistantNotIntReasons;
	}

	public static List<TranslatableElementConf> getSalesAssistantAgreedProductStatuses() {
		return salesAssistantAgreedProductStatuses;
	}

	public static void setSalesAssistantAgreedProductStatuses(
			List<TranslatableElementConf> salesAssistantAgreedProductStatuses) {
		NCTSystemConstants.salesAssistantAgreedProductStatuses = salesAssistantAgreedProductStatuses;
	}

	public static List<TranslatableElementConf> getSalesAssistantAgreedProductTypes() {
		return salesAssistantAgreedProductTypes;
	}

	public static void setSalesAssistantAgreedProductTypes(
			List<TranslatableElementConf> salesAssistantAgreedProductTypes) {
		NCTSystemConstants.salesAssistantAgreedProductTypes = salesAssistantAgreedProductTypes;
	}

	public static List<TranslatableElementConf> getSalesAssistantOpportunityStatuses() {
		return salesAssistantOpportunityStatuses;
	}

	public static void setSalesAssistantOpportunityStatuses(
			List<TranslatableElementConf> salesAssistantOpportunityStatuses) {
		NCTSystemConstants.salesAssistantOpportunityStatuses = salesAssistantOpportunityStatuses;
	}

	public static Map<String, String> getAgendaItemTypeFieldMapping() {
		return agendaItemTypeFieldMapping;
	}

	public static void setAgendaItemTypeFieldMapping(Map<String, String> agendaItemTypeFieldMapping) {
		NCTSystemConstants.agendaItemTypeFieldMapping = agendaItemTypeFieldMapping;
	}

	public static Map<Integer, Integer> getAgendaAdvisorMapping() {
		return agendaAdvisorMapping;
	}

	public static void setAgendaAdvisorMapping(Map<Integer, Integer> agendaAdvisorMapping) {
		NCTSystemConstants.agendaAdvisorMapping = agendaAdvisorMapping;
	}

	public static Map<String, ArrayList<TranslatableElementConf>> getQuickContactReportConf() {
		return quickContactReportConf;
	}

	public static void setQuickContactReportConf(
			Map<String, ArrayList<TranslatableElementConf>> quickContactReportConf) {
		NCTSystemConstants.quickContactReportConf = quickContactReportConf;
	}

	public static List<QuickContactTemplate> getQuickContactReportTemplates() {
		return quickContactReportTemplates;
	}

	public static void setQuickContactReportTemplates(List<QuickContactTemplate> quickContactReportTemplates) {
		NCTSystemConstants.quickContactReportTemplates = quickContactReportTemplates;
	}

	public static List<QuickContactTemplate> getMsgTemplates() {
		return msgTemplates;
	}

	public static void setMsgTemplates(List<QuickContactTemplate> msgTemplates) {
		NCTSystemConstants.msgTemplates = msgTemplates;
	}

	public static LeadManagementConfigurationContainer getLeadManagementConf() {
		return leadManagementConf;
	}

	public static void setLeadManagementConf(LeadManagementConfigurationContainer leadManagementConf) {
		NCTSystemConstants.leadManagementConf = leadManagementConf;
	}

	public static SalesAssistantConfigurationContainer getSalesAssistantConf() {
		return salesAssistantConf;
	}

	public static void setSalesAssistantConf(SalesAssistantConfigurationContainer salesAssistantConf) {
		NCTSystemConstants.salesAssistantConf = salesAssistantConf;
	}

	public static GetCurrenciesNCTResultList getCurrenciesConfig() {
		return currenciesConfig;
	}

	public static void setCurrenciesConfig(GetCurrenciesNCTResultList currenciesConfig) {
		NCTSystemConstants.currenciesConfig = currenciesConfig;
	}

	public static AuditConfigurationResponse getAuditConfig() {
		return auditConfig;
	}

	public static void setAuditConfig(AuditConfigurationResponse auditConfig) {
		NCTSystemConstants.auditConfig = auditConfig;
	}

	public static List<TranslatableElementConf> getClientOriginsConfig() {
		return clientOriginsConfig;
	}

	public static void setClientOriginsConfig(List<TranslatableElementConf> clientOriginsConfig) {
		NCTSystemConstants.clientOriginsConfig = clientOriginsConfig;
	}

	public static GetPortfolioTypesNCTResultList getPortfolioTypes() {
		return portfolioTypes;
	}

	public static void setPortfolioTypes(GetPortfolioTypesNCTResultList portfolioTypes) {
		NCTSystemConstants.portfolioTypes = portfolioTypes;
	}

	public static List<HomepageLinksTranslatableItem> getHomepageLinks() {
		return homepageLinks;
	}

	public static void setHomepageLinks(List<HomepageLinksTranslatableItem> homepageLinks) {
		NCTSystemConstants.homepageLinks = homepageLinks;
	}

	public static DateTimeFormatConfiguration getDateTimeFormats() {
		return dateTimeFormats;
	}

	public static void setDateTimeFormats(DateTimeFormatConfiguration dateTimeFormats) {
		NCTSystemConstants.dateTimeFormats = dateTimeFormats;
	}

	public static List<GetHomepageCampaignsNCTResultItem> getHomepageCampaigns() {
		return homepageCampaigns;
	}

	public static void setHomepageCampaigns(List<GetHomepageCampaignsNCTResultItem> homepageCampaigns) {
		NCTSystemConstants.homepageCampaigns = homepageCampaigns;
	}

	public static List<TranslatableElementConf> getStatisticsList() {
		return statisticsList;
	}

	public static void setStatisticsList(List<TranslatableElementConf> statisticsList) {
		NCTSystemConstants.statisticsList = statisticsList;
	}

	public static Map<Integer, String> getOpportunityCategoriesPictures() {
		return opportunityCategoriesPictures;
	}

	public static void setOpportunityCategoriesPictures(Map<Integer, String> opportunityCategoriesPictures) {
		NCTSystemConstants.opportunityCategoriesPictures = opportunityCategoriesPictures;
	}

	public static String getProductDefaultImg() {
		return productDefaultImg;
	}

	public static void setProductDefaultImg(String productDefaultImg) {
		NCTSystemConstants.productDefaultImg = productDefaultImg;
	}

	public static String getOpportunityDefaultImg() {
		return opportunityDefaultImg;
	}

	public static void setOpportunityDefaultImg(String opportunityDefaultImg) {
		NCTSystemConstants.opportunityDefaultImg = opportunityDefaultImg;
	}

	public static LDAPClientSystemConstants getLdapConfiguration() {
		return ldapConfiguration;
	}

	public static void setLdapConfiguration(LDAPClientSystemConstants ldapConfiguration) {
		NCTSystemConstants.ldapConfiguration = ldapConfiguration;
	}

	public static KeyCloakConfiguration getSsoConfiguration() {
		return ssoConfiguration;
	}

	public static void setSsoConfiguration(KeyCloakConfiguration ssoConfiguration) {
		NCTSystemConstants.ssoConfiguration = ssoConfiguration;
		NCTSystemConstants.keycloakPublicKey = ssoConfiguration.getSsoConfig().getPubKey();
		NCTSystemConstants.keycloakClientId = ssoConfiguration.getSsoConfig().getClientId();
		NCTSystemConstants.keycloakRealm = ssoConfiguration.getSsoConfig().getRealm();
		NCTSystemConstants.keycloakURL = ssoConfiguration.getSsoConfig().getUrl();
	}

	public static boolean isLdapEnabled() {
		return NCTSystemConstants.ldapConfiguration != null;
	}

	public static boolean isSSOEnabled() {
		return NCTSystemConstants.ssoConfiguration != null;
	}

	public static PublicKey getKeycloakPublicKey() {
		return keycloakPublicKey;
	}

	public static void setKeycloakPublicKey(PublicKey keycloakPublicKey) {
		NCTSystemConstants.keycloakPublicKey = keycloakPublicKey;
	}

	public static String getKeycloakResource() {
		return keycloakClientId;
	}

	public static void setKeycloakResource(String keycloakResource) {
		NCTSystemConstants.keycloakClientId = keycloakResource;
	}

	public static String getKeycloakRealm() {
		return keycloakRealm;
	}

	public static void setKeycloakRealm(String keycloakRealm) {
		NCTSystemConstants.keycloakRealm = keycloakRealm;
	}

	public static String getKeycloakURL() {
		return keycloakURL;
	}

	public static void setKeycloakURL(String keycloakURL) {
		NCTSystemConstants.keycloakURL = keycloakURL;
	}

	public static String getViewsConfig() {
		return VIEWS_CONFIG;
	}

	public static void setViewsConfig(String config) {
		VIEWS_CONFIG = config;
	}

	public static int getDBBankId() {
		return dbBankId;
	}

	public static void setDBBankId(int dBBankId) {
		dbBankId = dBBankId;
	}

	public static Map<Integer, String> getProductGroupPicturesMap() {
		return productGroupPicturesMap;
	}

	public static Map<Integer, String> getProductPicturesMap() {
		return productPicturesMap;
	}

	public static Map<Integer, GetProductCatalogNCTResultItem> getProductCatalogMap() {
		return productCatalogMap;
	}

	public static void setProductCatalogMap(Map<Integer, GetProductCatalogNCTResultItem> productCatalogMap) {
		NCTSystemConstants.productCatalogMap = productCatalogMap;
	}

	public static int getLanguageOrder1Id() {
		return languageOrder1Id;
	}

	public static void setLanguageOrder1Id(int languageOrder1Id) {
		NCTSystemConstants.languageOrder1Id = languageOrder1Id;
	}

	public static int getLanguageOrder2Id() {
		return languageOrder2Id;
	}

	public static void setLanguageOrder2Id(int languageOrder2Id) {
		NCTSystemConstants.languageOrder2Id = languageOrder2Id;
	}

	public static String getLanguageOrder1Code() {
		return languageOrder1Code;
	}

	public static void setLanguageOrder1Code(String languageOrder1Code) {
		NCTSystemConstants.languageOrder1Code = languageOrder1Code;
	}

	public static String getLanguageOrder2Code() {
		return languageOrder2Code;
	}

	public static void setLanguageOrder2Code(String languageOrder2Code) {
		NCTSystemConstants.languageOrder2Code = languageOrder2Code;
	}

	public static Map<Integer, GetProductGroupNCTResultItem> getProductGroupsMap() {
		return productGroupsMap;
	}

	public static void setProductGroupsMap(Map<Integer, GetProductGroupNCTResultItem> productGroupsMap) {
		NCTSystemConstants.productGroupsMap = productGroupsMap;
	}

	public static Map<Integer, GetNeedsCategoriesNCTResultItem> getNeedCategoriesMap() {
		return needCategoriesMap;
	}

	public static void setNeedCategoriesMap(Map<Integer, GetNeedsCategoriesNCTResultItem> needCategoriesMap) {
		NCTSystemConstants.needCategoriesMap = needCategoriesMap;
	}

	public static GetAdvisorsNCTResultList getAdvisorsList() {
		return advisorsList;
	}

	public static void setAdvisorsList(GetAdvisorsNCTResultList advisorsList) {
		NCTSystemConstants.advisorsList = advisorsList;
	}

	public static GetBankEntitiesNCTResultList getAllBankEntities() {
		return allBankEntities;
	}

	public static void setAllBankEntities(GetBankEntitiesNCTResultList allBankEntities) {
		NCTSystemConstants.allBankEntities = allBankEntities;
	}

	public static List<BankBranchMergedItem> getMergeBranches() {
		return mergeBranches;
	}

	public static void setMergeBranches(List<BankBranchMergedItem> mergeBranches) {
		NCTSystemConstants.mergeBranches = mergeBranches;
	}

	public static List<BankMainBranchMergedItem> getMergeMainBranches() {
		return mergeMainBranches;
	}

	public static void setMergeMainBranches(List<BankMainBranchMergedItem> mergeMainBranches) {
		NCTSystemConstants.mergeMainBranches = mergeMainBranches;
	}

	public static List<BankRegionMergedItem> getMergeRegions() {
		return mergeRegions;
	}

	public static void setMergeRegions(List<BankRegionMergedItem> mergeRegions) {
		NCTSystemConstants.mergeRegions = mergeRegions;
	}

	public static List<BankBankMergedItem> getMergeBanks() {
		return mergeBanks;
	}

	public static void setMergeBanks(List<BankBankMergedItem> mergeBanks) {
		NCTSystemConstants.mergeBanks = mergeBanks;
	}

	public static GetClientTypesNCTResultList getClientTypes() {
		return clientTypes;
	}

	public static void setClientTypes(GetClientTypesNCTResultList clientTypes) {
		NCTSystemConstants.clientTypes = clientTypes;
	}

	public static GetBankSegmentsNCTResultList getBankSegments() {
		return bankSegments;
	}

	public static void setBankSegments(GetBankSegmentsNCTResultList bankSegments) {
		NCTSystemConstants.bankSegments = bankSegments;
	}

	public static String getCbkAdapterAddress() {
		return cbkAdapterAddress;
	}

	public static void setCbkAdapterAddress(String cbkAdapterAddress) {
		NCTSystemConstants.cbkAdapterAddress = cbkAdapterAddress;
	}

	public static String getBizCtxConfigurationUnvrs() {
		return bizCtxConfigurationUnvrs;
	}

	public static void setBizCtxConfigurationUnvrs(String bizCtxConfigurationUnvrs) {
		NCTSystemConstants.bizCtxConfigurationUnvrs = bizCtxConfigurationUnvrs;
	}

	public static String getBizCtxConfigurationAppName() {
		return bizCtxConfigurationAppName;
	}

	public static void setBizCtxConfigurationAppName(String bizCtxConfigurationAppName) {
		NCTSystemConstants.bizCtxConfigurationAppName = bizCtxConfigurationAppName;
	}

	public static String getCtxTransferSessionAppId() {
		return ctxTransferSessionAppId;
	}

	public static void setCtxTransferSessionAppId(String ctxTransferSessionAppId) {
		NCTSystemConstants.ctxTransferSessionAppId = ctxTransferSessionAppId;
	}

	public static String getCtxTransferSessionSslbtp() {
		return ctxTransferSessionSslbtp;
	}

	public static void setCtxTransferSessionSslbtp(String ctxTransferSessionSslbtp) {
		NCTSystemConstants.ctxTransferSessionSslbtp = ctxTransferSessionSslbtp;
	}

	public static String getCtxTransferSessionHdrMd() {
		return ctxTransferSessionHdrMd;
	}

	public static void setCtxTransferSessionHdrMd(String ctxTransferSessionHdrMd) {
		NCTSystemConstants.ctxTransferSessionHdrMd = ctxTransferSessionHdrMd;
	}

	public static String getCtxTransferGeolocationLink() {
		return ctxTransferGeolocationLink;
	}

	public static void setCtxTransferGeolocationLink(String ctxTransferGeolocationLink) {
		NCTSystemConstants.ctxTransferGeolocationLink = ctxTransferGeolocationLink;
	}

	public static String getCtxTransferSuperScreenLink() {
		return ctxTransferSuperScreenLink;
	}

	public static void setCtxTransferSuperScreenLink(String ctxTransferSuperScreenLink) {
		NCTSystemConstants.ctxTransferSuperScreenLink = ctxTransferSuperScreenLink;
	}

	public static String getCtxTransferSalesLink() {
		return ctxTransferSalesLink;
	}

	public static void setCtxTransferSalesLink(String ctxTransferSalesLink) {
		NCTSystemConstants.ctxTransferSalesLink = ctxTransferSalesLink;
	}

	public static void setFunctionRoleMapping(Boolean functionRoleMapping) {
		NCTSystemConstants.functionRoleMapping = functionRoleMapping;
	}

	public static Boolean isFunctionRoleMapping() {
		return NCTSystemConstants.functionRoleMapping;
	}

	public static String getAccessControlAllowOrigin() {
		return NCTSystemConstants.accessControlAllowOrigin;
	}

	public static void setAccessControlAllowOrigin(String accessControlAllowOrigin) {
		NCTSystemConstants.accessControlAllowOrigin = accessControlAllowOrigin;
	}

	public static String getManagementAccessControlAllowOrigin() {
		return managementAccessControlAllowOrigin;
	}

	public static void setManagementAccessControlAllowOrigin(String managementAccessControlAllowOrigin) {
		NCTSystemConstants.managementAccessControlAllowOrigin = managementAccessControlAllowOrigin;
	}

	public static String getLeadSageLink() {
		return leadSageLink;
	}

	public static void setLeadSageLink(String leadSageLink) {
		NCTSystemConstants.leadSageLink = leadSageLink;
	}

	public static String getBasketSageLink() {
		return basketSageLink;
	}

	public static void setBasketSageLink(String basketSageLink) {
		NCTSystemConstants.basketSageLink = basketSageLink;
	}

	public static DefaultConfigurationParamsContainer getDefaultConfigParams() {
		return defaultConfigParams;
	}

	public static void setDefaultConfigParams(DefaultConfigurationParamsContainer defaultConfigParams) {
		NCTSystemConstants.defaultConfigParams = defaultConfigParams;
	}

	public static String getCurrancyNumberFormat() {
		return CURRANCY_NUMBER_FORMAT;
	}

	public static void setCurrancyNumberFormat(String s) {
		NCTSystemConstants.CURRANCY_NUMBER_FORMAT = s;
	}

	public static String getSoapEndpointAddress() {
		return ENDPOINT_ADDRESS;
	}

	public static void setSoapEndpointAddress(String wsdlAddress) {
		ENDPOINT_ADDRESS = wsdlAddress;
	}

	public static String getEndpointAddressLead() {
		return ENDPOINT_ADDRESS_LEAD;
	}

	/**
	 * @param wSDL_ADDRESS_LEAD the wSDL_ADDRESS_LEAD to set
	 */
	public static void setEndpointAddressLead(String wsdlAddressLead) {
		ENDPOINT_ADDRESS_LEAD = wsdlAddressLead;
	}
}

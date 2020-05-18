package fr.ca.sa.commons.configs;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public final class ConfigurationJSONConstants {

	private ConfigurationJSONConstants() {
		throw new IllegalAccessError("Utility class");
	}

	// Config file names
	public static final String NCT_CONFIG_FILE = "config.json";
	public static final String NCT_ERROR_FILE = "errorCodes.json";
	public static final String NCT_TEST_CONFIG_FILE = "testConfig.json";

	// NCT runtime environments
	public static final String RUNTIME_ENVIRONMENT_DEV = "dev";
	public static final String RUNTIME_ENVIRONMENT_PROD = "prod";
	public static final String RUNTIME_ENVIRONMENT_TESTING = "test";

	public static final String NCT_APPLICATION_CONFIG_OBJ = "NCT_Application";
	public static final String NCT_APPLICATION_CONFIG_ENVIRONMENT = "environment";

	public static final String NCT_APPLICATION_DEPLOYMENT_ADDRESS = "deploymentAddress";
	public static final String NCT_APPLICATION_DEPLOYMENT_PORT = "deploymentPort";
	public static final String NCT_APPLICATION_DEPLOYMENT_PROTOCOL = "deploymentProtocol";
	public static final String NCT_APPLICATION_DEPLOYMENT_VERSION = "apiVersion";

	public static final String NCT_IMAGES_KEEP_ALIVE_DAYS = "imagesKeepAliveDays";
	public static final String NCT_APPLICATION_ENDPOINTS_OBJ = "endpoints";
	public static final String NCT_APPLICATION_ENDPOINTS_MNGMT = "management";
	public static final String NCT_APPLICATION_ENDPOINTS_USER = "nctUser";
	public static final String NCT_WSDL_WITH_DEPOSITS_OPCV = "wsdlWithDepositsOPCV";
	public static final String NCT_WSDL_ADDRESS = "wsdlAddress";
	public static final String NCT_WSDL_ADDRESS_LEAD = "wsdlAddressLeadOut";
	public static final String NCT_LEAD_OUT_VIA_WS = "leadOutViaWS";
	public static final String NCT_MNGMT_LANG_1 = "managementLanguage1";
	public static final String NCT_MNGMT_LANG_2 = "managementLanguage2";
	public static final String NCT_ENDPOINT_ADDRESS = "endpointAddress";
	public static final String NCT_ENDPOINT_ADDRESS_LEAD = "endpointAddressLeadOut";


	// Field names in authentication object
	public static final String NCT_AUTHNETICATION_CONFIGURATION = "authenticationConfiguration";

	public static final String NCT_LDAP_ENABLED = "ldapEnabled";
	public static final String NCT_SSO_ENABLED = "ssoEnabled";

	public static final String NCT_LDAP_CONFIGURATION = "ldapConfiguration";
	public static final String NCT_ACTIVE_DIRECTORY_ADDRESS = "activeDirectoryAddress";
	public static final String NCT_DOMAIN = "domain";
	public static final String NCT_APPLICATION_CONFIG_SESSION_LENGTH = "sessionLengthMinutes";
	public static final String NCT_APPLICATION_CONFIG_MAX_JWT_DURATION = "maxJWTDurationMinutes";
	public static final String NCT_SECURITY_PRINCIPALS_UID = "securityPrincipalContainsUid";

	public static final String NCT_SSO_CONFIGURATION = "ssoConfiguration";
	public static final String NCT_KEYCLOAK_CONFIGURATION_FILE = "keyCloakConfigurationFileName";

	public static final String NCT_CONTEXT_TRANSFER_CONFIGURATION = "contextTransferConfiguration";
	public static final String NCT_CBK_ADAPTER_ADDRESS = "cbkAdapterAddress";

	public static final String NCT_BIZ_CTX_CONFIGURATION = "bizCtxConfiguration";
	public static final String NCT_BIZ_CTX_CONFIGURATION_UNVRS = "unvrs";
	public static final String NCT_BIZ_CTX_CONFIGURATION_APPNAME = "appName";

	public static final String NCT_CTX_TRANSFER_SESSION_CONFIGURATION = "sessionConfiguration";
	public static final String NCT_CTX_TRANSFER_SESSION_CONFIGURATION_APP_ID = "appId";
	public static final String NCT_CTX_TRANSFER_SESSION_CONFIGURATION_SSLBTP = "sslbtp";

	public static final String NCT_CTX_TRANSFER_FE_LINKS = "FELinks";
	public static final String NCT_CTX_TRANSFER_GEOLOCATION_LINK = "geolocation";
	public static final String NCT_CTX_TRANSFER_SALES_LINK = "sales";
	public static final String NCT_CTX_TRANSFER_SUPER_SCREEN_LINK = "superScreen";

	public static final String NCT_CTX_TRANSFER_HDR_CONFIGURATION = "hdrConfiguration";
	public static final String NCT_CTX_TRANSFER_HDR_CONFIGURATION_MD = "md";

	// Object names in viewsConfig.json
	public static final String NCT_VIEWS_CUSTOMIZATION_OBJ = "viewsCustomization";
	public static final String NCT_OPPORTUNITIES_TYPES_CONFIG_OBJ = "opportunitiesTypes";
	public static final String NCT_ADVANCED_SEARCH_VIEW_OBJ = "advancedSearchView";
	public static final String NCT_TOOLBAR_VIEW_OBJ = "toolbarView";

	public static final String NCT_APPLICATION_TEST_OBJ = "tests";
	public static final String NCT_APPLICATION_TEST_RUN = "runTests";
	public static final String NCT_APPLICATION_TEST_EXIT = "exitOnFinish";
	public static final String NCT_APPLICATION_TEST_EXPORT = "exportResults";
	public static final String NCT_APPLICATION_TEST_EXPORT_LOCATION = "exportLocation";

	public static final String NCT_JMS_FLOW_PROCESSING_SERIALIZATION = "jmsFlowProcessingSerialization";
	public static final String NCT_JMS_QUEUED_FLOW_PROCESSING = "jmsQueuedFlowProcessingEnabled";
	public static final String NCT_BATCH_INPUT_LOCATION = "batchInputLocation";
	public static final String NCT_BATCH_FS_ROOT = "batchFileSystemRoot";
	public static final String NCT_BATCH_EXTERNAL_FILES_DIR = "batchExternalFilesFolderName";
	public static final String NCT_JMS_FLOW_ITEMS_LIMIT = "jmsOutboundFlowsItemsLimit";
	public static final String NCT_JMS_FLOW_PROCESSING_TIMER_SECONDS = "jmsTimerSeconds";
	public static final String NCT_JMS_FLOW_PROCESSING_DURATION_SECONDS = "jmsEstimatedProcessingDurationSeconds";
	// Object names in keycloak.json
	public static final String NCT_APPLICATION_KEYCLOAK_REALM = "realm";
	public static final String NCT_APPLICATION_KEYCLOAK_REALM_PUBLIC_KEY = "realm-public-key";
	public static final String NCT_APPLICATION_KEYCLOAK_AUTH_SERVER_URL = "auth-server-url";
	public static final String NCT_APPLICATION_KEYCLOAK_RESOURCE = "resource";

	public static final String NCT_FUNCTION_ROLE_MAPPING = "functionRoleMapping";

	public static final String NCT_ACCESS_CONTROL_ALLOW_ORIGIN = "accessControlAllowOrigin";
	public static final String NCT_MANAGEMENT_ACCESS_CONTROL_ALLOW_ORIGIN = "managementAccessControlAllowOrigin";

	public static final String NCT_LEAD_SAGE_LINK = "leadSageLink";
	public static final String NCT_BASKET_SAGE_LINK = "basketSageLink";
}

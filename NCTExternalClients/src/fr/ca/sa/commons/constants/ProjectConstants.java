package fr.ca.sa.commons.constants;

import org.jboss.logging.Logger;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ProjectConstants {

	private static final Logger LOGGER = Logger.getLogger(ProjectConstants.class);

	public static final long SERIALIZABLE_CLASS_UID = 3849643947794773052L;

	public static final String SERVICE_INIT_METHOD = "initializeService";
	public static final String LOAD_ROLES_PERMISSIONS_METHOD = "loadPermissionMatrix";

	// NCT runtime environments
	public static final String RUNTIME_ENVIRONMENT_DEV = "dev";
	public static final String RUNTIME_ENVIRONMENT_PROD = "prod";

	public static final String DATETIME_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.mmm";
	public static final String DATE_TIME_FORMAT_NO_MILLIS = "yyyy-MM-dd HH:mm:ss";

	public static final String TRUE_VALUE_LOWER_CASE = "true";

	public static final String FLOW_TYPE_FILE_NAME = "File";
	public static final String FLOW_TYPE_JMS_NAME = "JMS";

	public static final String INCOMING_BATCH_DIRECTION = "Incoming";
	public static final String OUTGOING_BATCH_DIRECTION = "Outgoing";

	// Common authorization permissions
	public static final String PERMISSION_OBJECT_PORTFOLIO_EXPORT = "Export on the Porfolio";
	public static final String PERMISSION_OBJECT_CLIENT_SYNTHESIS_PRINT = "Print on the Client Synthesis";
	public static final String PERMISSION_OBJECT_CONTACT_REPORT_PRINT = "Print on the Contact Report";
	public static final String PERMISSION_OBJECT_OPPORTUNITY_SUMMARY_PAGE = "Opportunity Summary Page";

	/**
	 * File flow type
	 */
	private static final int FILE_FLOW_TYPE_DEFAULT_VALUE = 1;
	private static int fileFlowType = FILE_FLOW_TYPE_DEFAULT_VALUE;

	/**
	 * JMS flow type
	 */
	private static final int JMS_FLOW_TYPE_DEFAULT_VALUE = 2;
	private static int jmsFlowType = JMS_FLOW_TYPE_DEFAULT_VALUE;

	// Data types for fields in batch and jms processing
	public static final String FIELD_TYPE_INTEGER = "integer";
	public static final String FIELD_TYPE_TEXT = "nvarchar";
	public static final String FIELD_TYPE_DECIMAL = "decimal";
	public static final String FIELD_TYPE_DATE = "datetime";
	public static final String FIELD_TYPE_BINARY = "file_name";
	public static final String FIELD_TYPE_LONG = "bigint";

	// Image formats and mime types
	public static final String IMAGE_MIME_TYPE_PNG = "png";
	public static final String IMAGE_MIME_TYPE_JPG = "jpg";
	public static final String DEFAULT_IMAGE_MIME_TYPE = IMAGE_MIME_TYPE_JPG;

	// Time utils
	public static final int MINUTE_IN_MILLIS = 60000;
	public static final int MILLIS_IN_SECOND = 1000;
	public static final int DEFAULT_YEAR = 70;
	public static final int MAX_HOUR_VALUE = 23;
	public static final int MAX_MINUTE_VALUE = 59;
	// Permission constants
	public static final int L_LEVELS_NUMBER = 6;

	// RSA constants
	public static final int RSA_KEY_LENGTH = 1024;
	public static final int RSA_ENCRYPT_BLOCK_LENGTH = 100;
	public static final int RSA_DECRYPT_BLOCK_LENGTH = 128;

	// Integer to boolean mapping
	public static final int INTEGER_TRUE_VALUE = 1;
	public static final int INTEGER_FALSE_VALUE = 0;

	// Image streams processing constants
	public static final String HEX_PREFIX = "0x";
	public static final String BASE64_IMAGE_DATA_SEPARATOR = ",";

	// Random strings constants
	public static final int RANDOM_STRING_BASE_130 = 130;
	public static final int RANDOM_STRING_LENGTH_32 = 32;
	public static final int RANDOM_STRING_LENGTH_64 = 64;
	public static final int RANDOM_STRING_LENGTH_256 = 256;

	public static final Integer HTTP_STATUS_OK = 200;

	// Keycloak constants
	public static final String BEARER_PREFIX = "Bearer";
	public static final String PREFERED_USERNAME = "preferred_username";
	public static final String GROUPS = "groups";
	public static final String PLACE_ID = "placeId";
	public static final String OPERATOR_ID = "operator_id";
	public static final String AUTH_TIME = "auth_time";
	public static final String EXPIRATION = "exp";
	public static final String CHANNEL = "channel";
	public static final String KEYCLOAK_GET_SAML_PATH = "/realms/UFE/retriveSAMLToken";

	public static final Long INDEFINITE_CACHE_EXPIRATION = -1L;
	// Name of the Authorization headers
	public static final String SET_AUTHORIZATION_HEADER = "Set-Authorization";
	public static final String AUTHORIZATION_HEADER = "Authorization";

	public static final int LANGUAGE_ORDER_1 = 1;
	public static final int LANGUAGE_ORDER_2 = 2;

	public static final int BYTES_IN_MB = 1048576;

	public static final int TIMER_MINUTES_5 = 5;

	public static final int COLUMN_INDEX_0 = 0;
	public static final int COLUMN_INDEX_1 = 1;
	public static final int COLUMN_INDEX_2 = 2;
	public static final int COLUMN_INDEX_3 = 3;
	public static final int COLUMN_INDEX_4 = 4;
	public static final int COLUMN_INDEX_5 = 5;
	public static final int COLUMN_INDEX_6 = 6;
	public static final int COLUMN_INDEX_7 = 7;
	public static final int COLUMN_INDEX_8 = 8;
	public static final int COLUMN_INDEX_9 = 9;
	public static final int COLUMN_INDEX_10 = 10;
	public static final int COLUMN_INDEX_11 = 11;
	public static final int COLUMN_INDEX_12 = 12;
	public static final int COLUMN_INDEX_13 = 13;
	public static final int COLUMN_INDEX_14 = 14;

	public static final int ENTITY_LEVEL_1 = 1;
	public static final int ENTITY_LEVEL_2 = 2;
	public static final int ENTITY_LEVEL_3 = 3;
	public static final int ENTITY_LEVEL_4 = 4;
	public static final int ENTITY_LEVEL_5 = 5;

	public static final String EXTERNAL_CLIENT_DB = "DB";
	public static final String EXTERNAL_CLIENT_SOAP = "SOAP";
	public static final String EXTERNAL_CLIENT_LEAD_OUT = "LEAD_OUT";

	public static final String CONFIG_PARAM_EXECUTION_WARN_TIME_DB = "DATABASE_EXECUTION_WARNING_MILLIS";
	public static final String CONFIG_PARAM_EXECUTION_WARN_TIME_SOAP = "SOAP_EXECUION_WARNING_MILLIS";
	public static final String CONFIG_PARAM_EXECUTION_WARN_TIME_LEAD_OUT = "LEAD_OUT_EXECUTION_WARNING_MILLIS";

	private static long warnExecutionTimeDB = 100;
	private static long warnExecutionTimeSOAP = 100;
	private static long warnExecutionTimeLeadOut = 100;

	private ProjectConstants() {
		throw new IllegalStateException("Utility class");
	}
	
	public static int getFileFlowType() {
		return fileFlowType;
	}

	public static void setFileFlowType(int fileFlowType) {
		ProjectConstants.fileFlowType = fileFlowType;
	}

	public static int getJmsFlowType() {
		return jmsFlowType;
	}

	public static void setJmsFlowType(int jmsFlowType) {
		ProjectConstants.jmsFlowType = jmsFlowType;
	}

	public static long getWarnExecutionTimeDB() {
		return warnExecutionTimeDB;
	}

	public static void setWarnExecutionTimeDB(long warnExecutionTimeDB) {
		if (ProjectConstants.warnExecutionTimeDB != warnExecutionTimeDB) {
			LOGGER.warn("Setting DB warning time to " + warnExecutionTimeDB + " ms.");
			ProjectConstants.warnExecutionTimeDB = warnExecutionTimeDB;
		}
	}

	public static long getWarnExecutionTimeSOAP() {
		return warnExecutionTimeSOAP;
	}

	public static void setWarnExecutionTimeSOAP(long warnExecutionTimeSOAP) {
		if (ProjectConstants.warnExecutionTimeSOAP != warnExecutionTimeSOAP) {
			LOGGER.warn("Setting SOAP warning time to " + warnExecutionTimeSOAP + " ms.");
			ProjectConstants.warnExecutionTimeSOAP = warnExecutionTimeSOAP;
		}
	}

	public static long getWarnExecutionTimeLeadOut() {
		return warnExecutionTimeLeadOut;
	}

	public static void setWarnExecutionTimeLeadOut(long warnExecutionTimeLeadOut) {
		if (ProjectConstants.warnExecutionTimeLeadOut != warnExecutionTimeLeadOut) {
			LOGGER.warn("Setting LEAD_OUT warning time to " + warnExecutionTimeLeadOut + " ms.");
			ProjectConstants.warnExecutionTimeLeadOut = warnExecutionTimeLeadOut;
		}
	}

}

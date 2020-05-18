package fr.ca.sa.commons.constants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseConstants {

	// Datasource path from standalone.xml
	public static final String DATASOURCE_PATH = "java:jboss/datasources/NCT";

	public static final int SP_ARG_NR_1 = 1;
	public static final int SP_ARG_NR_2 = 2;
	public static final int SP_ARG_NR_3 = 3;
	public static final int SP_ARG_NR_4 = 4;
	public static final int SP_ARG_NR_5 = 5;
	public static final int SP_ARG_NR_6 = 6;
	public static final int SP_ARG_NR_7 = 7;
	public static final int SP_ARG_NR_8 = 8;
	public static final int SP_ARG_NR_9 = 9;
	public static final int SP_ARG_NR_10 = 10;
	public static final int SP_ARG_NR_11 = 11;
	public static final int SP_ARG_NR_12 = 12;
	public static final int SP_ARG_NR_13 = 13;
	public static final int SP_ARG_NR_14 = 14;
	public static final int SP_ARG_NR_15 = 15;
	public static final int SP_ARG_NR_16 = 16;
	public static final int SP_ARG_NR_17 = 17;
	public static final int SP_ARG_NR_18 = 18;
	public static final int SP_ARG_NR_19 = 19;
	public static final int SP_ARG_NR_20 = 20;
	public static final int SP_ARG_NR_21 = 21;
	public static final int SP_ARG_NR_22 = 22;
	public static final int SP_ARG_NR_23 = 23;
	public static final int SP_ARG_NR_24 = 24;
	public static final int SP_ARG_NR_25 = 25;
	public static final int SP_ARG_NR_26 = 26;
	public static final int SP_ARG_NR_27 = 27;
	public static final int SP_ARG_NR_28 = 28;
	public static final int SP_ARG_NR_29 = 29;
	public static final int SP_ARG_NR_30 = 30;
	public static final int SP_ARG_NR_31 = 31;
	public static final int SP_ARG_NR_32 = 32;
	public static final int SP_ARG_NR_33 = 33;
	public static final int SP_ARG_NR_34 = 34;
	public static final int SP_ARG_NR_35 = 35;
	public static final int SP_ARG_NR_36 = 36;
	public static final int SP_ARG_NR_37 = 37;
	public static final int SP_ARG_NR_38 = 38;
	public static final int SP_ARG_NR_39 = 39;
	public static final int SP_ARG_NR_40 = 40;
	public static final int SP_ARG_NR_41 = 41;
	public static final int SP_ARG_NR_42 = 42;
	public static final int SP_ARG_NR_43 = 43;

	/**
	 * Language IDs
	 */
	private static final int UNDEFINED_LANG_ID = -1;
	private static final int LANGUAGE_ID_1 = 1;
	private static final int LANGUAGE_ID_2 = 2;
	
	private static final int LANGUAGE_ID_6 = 6;

	/**
	 * Limit for user roles results Default value 1000
	 */
	private static final int USER_ROLES_LIMIT = 1000;

	/**
	 * Login return codes
	 */
	private static final int LOGIN_USER_UNKNOWN = -1;
	private static final int LOGIN_USER_NOT_ACTIVE = -2;
	private static final int LOGIN_USER_UNKNOWN_POSITION = -3;

	/**
	 * 
	 * Flow processing constants
	 */
	// 2 = 1 for ID column, 1 for Java indexing from 0
	private static final int BULK_INSERT_QUERY_CELL_INDEX_OFFSET = 2;

	public static final int ACTIVE_INTEGER_VALUE = 1;
	public static final int INACTIVE_INTEGER_VALUE = 0;

	private static final int BACKBONE_VARCHAR_LENGTH_50 = 50;
	private static final int BACKBONE_VARCHAR_LENGTH_512 = 512;
	private static final int BACKBONE_VARCHAR_LENGTH_2048 = 512;
	private static final int UNDEFINED_SEQ_INDEX_DB = 0;

	private static final int SEARCH_TYPE_QUICK = 1;
	private static final int SEARCH_TYPE_ADVANCED = 2;
	private static final int SEARCH_LEADS_ENABLED = 0;

	// Not closed agenda appointments total count values
	private static final int NOT_CLOSED_AGENDA_ITEM_LIST_ID = 0;
	private static final int NOT_CLOSED_AGENDA_ITEM_TOTAL_COUNT_ID = 1;
	
	// DB date time constants
	public static final String BACKBONE_ONLY_DATE_DATETIME_FORMAT = "yyyy-MM-dd";

	public static final String BACKBONE_FULL_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	
	public static final String BACKBONE_WORKTIME_DATETIME_FORMAT = "HH:mm";

	public static final String PRODUCT_GROUP_PICTURES_MAP_NAME = "productGroupPicture";
	public static final String PRODUCT_PICTURES_MAP_NAME = "productPicture";

	private NCTDatabaseConstants() {
	}

	public static int getUndefinedLangId() {
		return UNDEFINED_LANG_ID;
	}

	public static int getUserRolesLimit() {
		return USER_ROLES_LIMIT;
	}

	public static int getLanguageId1() {
		return LANGUAGE_ID_1;
	}

	public static int getLanguageId2() {
		return LANGUAGE_ID_2;
	}

	public static int getLanguageId6() {
		return LANGUAGE_ID_6;
	}

	public static int getLoginUserUnknown() {
		return LOGIN_USER_UNKNOWN;
	}

	public static int getLoginUserNotActive() {
		return LOGIN_USER_NOT_ACTIVE;
	}

	public static int getLoginUserUnknownPosition() {
		return LOGIN_USER_UNKNOWN_POSITION;
	}

	public static int getBulkInsertQueryCellIndexOffset() {
		return BULK_INSERT_QUERY_CELL_INDEX_OFFSET;
	}

	public static int getBackboneVarcharLength50() {
		return BACKBONE_VARCHAR_LENGTH_50;
	}

	public static int getBackboneVarcharLength512() {
		return BACKBONE_VARCHAR_LENGTH_512;
	}

	public static int getBackboneVarcharLength2048() {
		return BACKBONE_VARCHAR_LENGTH_2048;
	}

	public static int getUndefinedSeqIndexDb() {
		return UNDEFINED_SEQ_INDEX_DB;
	}

	public static int getSearchTypeQuick() {
		return SEARCH_TYPE_QUICK;
	}

	public static int getSearchTypeAdvanced() {
		return SEARCH_TYPE_ADVANCED;
	}

	public static int getSearchLeadsEnabled() {
		return SEARCH_LEADS_ENABLED;
	}

	public static String getBackboneOnlyDateDatetimeFormat() {
		return BACKBONE_ONLY_DATE_DATETIME_FORMAT;
	}

	public static String getBackboneFullDatetimeFormat() {
		return BACKBONE_FULL_DATETIME_FORMAT;
	}

	public static String getBackboneWorktimeDatetimeFormat() {
		return BACKBONE_WORKTIME_DATETIME_FORMAT;
	}

	public static int getNotClosedAgendaItemListId() {
		return NOT_CLOSED_AGENDA_ITEM_LIST_ID;
	}
	

	public static int getNotClosedAgendaItemTotalCountId() {
		return NOT_CLOSED_AGENDA_ITEM_TOTAL_COUNT_ID;
	}
}

package fr.ca.sa.commons.constants;

/**
 * 
 * TestConstants class contains all the variables and methods which are used for
 * testing
 * 
 * @author Stevan Mihajlov
 *
 */
public final class TestConstants {

	private TestConstants() {
		throw new IllegalAccessError("Utility class");
	}

	private static final String CLIENT_ID = "clientId";
	private static final String CLIENT_TYPE = "clientType";	
	private static final String ENTITY_ID = "entityId";
	private static final String CLIENT_ENTITY_ID = "clientEntityId";
	private static final String ADVISOR_ID = "advisorId";


	// Dummy value for userCoreId, find the right one and refactor tests
	public static final Integer USER_CORE_ID = 1;

	public static final String TEST_CONST_STRING_NUMBER = "number";
	public static final String TEST_CONST_STRING_WORD = "word";

	// Constants for reading from testConfig.json
	public static final String TEST_DATA_OBJ = "testData";
	public static final String PROFILE_DATA_OBJ = "profileData";
	public static final String TODO_DATA_OBJ = "toDoData";
	public static final String TODO_UPDATE_DATA_OBJ = "toDoDataUpdate";
	public static final String SEARCH_DATA_OBJ = "searchData";
	public static final String COUNTRY_CONFIGURATION_DATA_OBJ = "countryConfigurationData";

	// JSON objects for profile testing
	public static final String ENTITY_CODE_OBJ = "entityCode";
	public static final String ENTITY_NAME_OBJ = "entityName";
	public static final String FIRST_NAME_OBJ = "firstName";
	public static final String LAST_NAME_OBJ = "lastName";
	public static final String ID_OBJ = "id";
	public static final String FUNCTION_NAME_OBJ = "functionName";
	public static final String PASS_OBJ = "password";
	public static final String BRANCH_ID_OBJ = "branchId";

	// Variables for testing profile service
	private static int ID = 0;
	private static String ENTITY_CODE = "";
	private static String ENTITY_NAME = "";
	private static String FIRST_NAME = "";
	private static String LAST_NAME = "";
	private static String FUNCTION_NAME = "";
	private static String PASS = "";
	private static int BRANCH_ID = 0;

	// JSON objects for event service testing
	public static final String CLIENT_OBJ = CLIENT_ID;	
	public static final String COLLABORATOR_ID_OBJ = "collaboratorId";
	public static final String COMMENT_OBJ = "comment";	
	public static final String DATE_TIME_OBJ = "dateTime";
	public static final String SUBJECT_OBJ = "subject";

	// Variables for testing profile service
	private static int COLLABORATOR_ID = 0;
	private static String SUBJECT = "";
	private static String DATE_TIME = "";
	private static int CLIENT = 0;
	private static String COMMENT = "";
	private static String NAME_TO_DO = "";
	private static String SURNAME_TO_DO = "";

	private static int COLLABORATOR_UPDATE_ID = 0;
	private static String NAME_UPDATE_TO_DO = "";
	private static String SURNAME_UPDATE_TO_DO = "";
	private static String SUBJECT_UPDATE = "";
	private static String DATE_TIME_UPDATE = "";
	private static int CLIENT_UPDATE = 0;
	private static String COMMENT_UPDATE = "";
	private static int STATUS = 0;

	// JSON objects for search service testing
	public static final String EXPECTED_SEARCH_RESULT_OBJ = "expectedSearchResult";
	public static final String QUICK_SEARCH_ITEM_OBJ = "quickSearchItem";
	public static final String ADVANCED_SEARCH_ITEM_OBJ = "advancedSearchItem";
	public static final String BANK_ID_SEARCH_OBJ = "bankId";
	public static final String NEEDLE_SEARCH_OBJ = "needle";

	public static final String CL_SEARCH_OBJ = "clientOrLead";
	public static final String CLIENT_TYPE_OBJ = CLIENT_TYPE;
	public static final String CLIENT_CODE_OBJ = "clientCode";
	public static final String CITY_OBJ = "city";
	public static final String MOBILE_PHONE_OBJ = "mobilePhone";
	public static final String LAST_CONTACT_DATE_OBJ = "lastContactDate";
	public static final String LAST_CONTACT_ADVISOR_OBJ = "lastContactAdvisor";
	public static final String SEGMENT_OBJ = "segment";
	public static final String BRANCH_OBJ = "branch";
	public static final String ADVISORS_OBJ = "advisors";

	// Variables for testing search service
	private static int QUICK_SEARCH_ITEM = 0;
	private static int ADVANCED_SEARCH_ITEM = 0;
	private static int BANK_ID_SEARCH = 0;
	private static String NEEDLE_SEARCH = "";

	private static String CL_SEARCH = "";
	private static String CLIENT_TYPE_SEARCH = "";
	private static int CLIENT_SEARCH = 0;
	private static String CLIENT_CODE_SEARCH = "";
	private static String FIRST_NAME_SEARCH = "";
	private static String LAST_NAME_SEARCH = "";
	private static String CITY_SEARCH = "";
	private static String MOBILE_PHONE_SEARCH = "";
	private static String LAST_CONTACT_DATE_SEARCH = "";
	private static String LAST_CONTACT_ADVISOR_SEARCH = "";
	private static String SEGMENT_SEARCH = "";
	private static String BRANCH_SEARCH = "";
	private static String ADVISORS_SEARCH = "";

	// JSON objects for country configuration service testing
	public static final String ADVISOR_OBJ = "advisor";	
	public static final String ARRAY_ELEMENT_COUNTRY_CONFIGURATION_OBJ = "arrayElementCountry";
	public static final String ARRAY_ELEMENT_ADVISOR_OBJ = "arrayElementAdvisor";
	public static final String BANK_OBJ = "bank";	
	public static final String BANK_SEGMENTS_OBJ = "bankSegments";
	public static final String CLIENT_TYPE_ID_OBJ = "clientTypeId";
	public static final String CLIENT_TYPE_NAME_OBJ = "clientTypeName";
	public static final String CLIENT_TYPES_OBJ = "clientTypes";	
	public static final String ENTITY_OBJ = "entity";
	public static final String ENTITY_ID_OBJ = ENTITY_ID;
	public static final String ENTITY_LEVEL_OBJ = "level";
	public static final String PARENT_ENTITY_OBJ = "parentEntity";
	public static final String SEGMENT_ID_OBJ = "segmentId";
	public static final String SEGMENT_NAME_OBJ = "segmentName";
	public static final String USER_ID_OBJ = "userId";

	// JSON objects for quick contact report
	public static final String QUICK_CONTACT_REPORT_OBJ = "quickContactReport";
	public static final String QCR_CLIENT_ID_OBJ = CLIENT_ID;
	public static final String QCR_CLIENT_ENTITY_ID_OBJ = CLIENT_ENTITY_ID;
	public static final String QCR_CLIENT_PORTFOLIO_ID_OBJ = "clientPortfolioId";
	public static final String QCR_CLIENT_TYPE_OBJ = "clientType";
	public static final String QCR_REPORT_DATE_OBJ = "reportDate";
	public static final String QCR_REQUEST_ID_OBJ = "requestId";
	public static final String QCR_CHANNEL_ID_OBJ = "channelId";
	public static final String QCR_REASON_ID_OBJ = "reasonId";
	public static final String QCR_RESULT_ID_OBJ = "resultId";
	public static final String QCR_COMMENT_OBJ = "comment";
	public static final String QCR_DETAIL_OBJ = "qcrDetailsNCTResult";
	public static final String QCR_DETAIL_ENTITY_ID_OBJ = ENTITY_ID;
	public static final String QCR_DETAIL_ADVISOR_ID_OBJ = ADVISOR_ID;
	public static final String QCR_DETAIL_CLIENT_ADVISOR_ID_OBJ = "clientAdvisorId";
	public static final String QCR_DETAIL_CLIENT_ENTITY_ID_OBJ = CLIENT_ENTITY_ID;
	public static final String QCR_DETAIL_CLIENT_PORTFOLIO_ID_OBJ = "clientPortfolioId";
	public static final String QCR_DETAIL_CLIENT_ID_OBJ = CLIENT_ID;
	public static final String QCR_DETAIL_CLIENT_TYPE_OBJ = CLIENT_TYPE;
	public static final String QCR_DETAIL_REQUEST_ID_OBJ = "requestId";
	public static final String QCR_DETAIL_CHANNEL_ID_OBJ = "channelId";
	public static final String QCR_DETAIL_REASON_ID_OBJ = "reasonId";
	public static final String QCR_DETAIL_CLAIM_REASON_ID_OBJ = "claimReasonId";
	public static final String QCR_DETAIL_UNREACHABLE_REASON_ID_OBJ = "unreachableReasonId";
	public static final String QCR_DETAIL_NOT_INT_REASON_ID_OBJ = "notIntReasonId";
	public static final String QCR_DETAIL_RESULT_ID_OBJ = "resultId";
	public static final String QCR_DETAIL_REPORT_DATE_OBJ = "reportDate";

	// Variables for testing country configuration service
	private static int ARRAY_ELEMENT_COUNTRY_CONFIGURATION = 0;

	// Audit
	private static String AUDIT_OBJ = "audit";
	private static String AUDIT_APPLICATION_ID_OBJ = "applicationId";
	private static String AUDIT_TRANSACTION_ID_OBJ = "transactionId";
	private static String AUDIT_LANG_CODE_OBJ = "langCode";
	private static String AUDIT_START_TIME_OBJ = "startTime";
	private static String AUDIT_END_TIME_OBJ = "endTime";
	private static String AUDIT_START_TIME_DISTANT_OBJ = "startTimeDistant";
	private static String AUDIT_END_TIME_DISTANT_OBJ = "endTimeDistant";
	private static String AUDIT_TARGET_ENTITY_ID_OBJ = "targetEntityId";
	private static String AUDIT_TARGET_ID_OBJ = "targetId";
	private static String AUDIT_ADVISOR_ID_OBJ = ADVISOR_ID;
	private static int AUDIT_APPLICATION_ID = 0;
	private static int AUDIT_TRANSACTION_ID = 0;
	private static int AUDIT_LANG_CODE = 0;
	private static String AUDIT_START_TIME = "";
	private static String AUDIT_END_TIME = "";
	private static String AUDIT_START_TIME_DISTANT = "";
	private static String AUDIT_END_TIME_DISTANT = "";
	private static int AUDIT_TARGET_ENTITY_ID = 0;
	private static int AUDIT_TARGET_ID = 0;
	private static int AUDIT_ADVISOR_ID = 0;

	// Advisor
	private static int ARRAY_ELEMENT_ADVISOR = 0;
	private static int USER_ID_ADVISOR = 0;
	private static String FIRST_NAME_ADVISOR = "";
	private static String LAST_NAME_ADVISOR = "";
	private static String ENTITY_CODE_ADVISOR = "";

	// Entity
	private static int ENTITY_ID_COUNTRY_CONFIG = 0;
	private static String ENTITY_CODE_COUNTRY_CONFIG = "";
	private static String ENTITY_NAME_COUNTRY_CONFIG = "";
	private static String PARENT_ENTITY_COUNTRY_CONFIG = "";
	private static int LEVEL_COUNTRY_CONFIG = 0;

	// BankSegments
	private static int SEGMENT_ID_COUNTRY_CONFIG = 0;
	private static String SEGMENT_NAME_COUNTRY_CONFIG = "";

	// ClientType
	private static int CLIENT_TYPE_ID_COUNTRY_CONFIG = 0;
	private static String CLIENT_TYPE_NAME_COUNTRY_CONFIG = "";

	// bank
	private static String BANK_COUNTRY_CONFIG = "";
	// JSON object for agenda testing
	public static final String AGENDA_BRANCH_ID_OBJ = "branchId";
	public static final String AGENDA_CONFIG_OBJ = "agendaConfiguration";
	public static final String AGENDA_ITEM_OBJ = "agendaItem";	
	public static final String AGENDA_ITEM_REQUEST = "setAgendaItemRequest";
	public static final String AGENDA_REQUEST_OBJ = "agendaRequest";
	public static final String AGENDA_USER_ID_OBJ = "userId";
	public static final String FROM_TIME_OBJ = "fromTime";
	public static final String LANGUAGE_OBJ = "language";	
	public static final String TO_TIME_OBJ = "toTime";

	// JSON object for agenda detail
	public static final String AGENDA_ITEM_DETAILED_OBJ = "agendaItemDetailed";
	public static final String AGENDA_AGENDA_ID_OBJ = "agendaId";
	public static final String AGENDA_ADVISOR_ID_OBJ = ADVISOR_ID;
	public static final String AGENDA_ADVISOR_ENTITY_ID_OBJ = "advisorEntityId";
	public static final String AGENDA_ITEM_TYPE_ID_OBJ = "agendaItemTypeId";
	public static final String AGENDA_STATUS_ID_OBJ = "statusId";
	public static final String AGENDA_CONTACT_ID_OBJ = "contactId";
	public static final String AGENDA_CLIENT_TYPE_ID_OBJ = CLIENT_TYPE;
	public static final String AGENDA_CLIENT_ID_OBJ = CLIENT_ID;
	public static final String AGENDA_CLIENT_ENTITY_ID_OBJ = CLIENT_ENTITY_ID;
	public static final String AGENDA_CLIENT_PORTFOLIO_ID_OBJ = "clientPortfolioId";
	public static final String AGENDA_MESSAGE_TYPE_ID_OBJ = "messageTypeId";
	public static final String AGENDA_START_TIME_OBJ = "startTime";
	public static final String AGENDA_END_TIME_OBJ = "endTime";
	public static final String AGENDA_WEEKLY_FREQUENCY_OBJ = "weeklyFrequency";
	public static final String AGENDA_REMINDER_TIME_OBJ = "reminderTime";
	public static final String AGENDA_CLOSE_REASON_ID_OBJ = "closeReasonId";
	public static final String AGENDA_AVAILABLE_OBJ = "available";
	public static final String AGENDA_VISIBLE_OBJ = "visible";
	public static final String AGENDA_LOCATION_ID_OBJ = "locationId";
	public static final String AGENDA_ORIGIN_ID_OBJ = "originId";
	public static final String AGENDA_DURATION_ID_OBJ = "durationId";
	public static final String AGENDA_CANCEL_REASON_ID_OBJ = "cancelReasonId";
	public static final String AGENDA_FIRST_NAME_OBJ = "firstName";
	public static final String AGENDA_ELEMENT_ID_REQ_OBJ = "agendaElementId";
	public static final String AGENDA_POSITIVE_ID_REQ_OBJ = "agendaElementTypeId";
	public static final String AGENDA_START_TIME_REQ_OBJ = "startTime";
	public static final String AGENDA_END_TIME_REQ_OBJ = "endTime";
	public static final String AGENDA_UPDATED_START_TIME_REQ_OBJ = "updatedStartTime";
	public static final String AGENDA_UPDATED_END_TIME_REQ_OBJ = "updatedEndTime";
	public static final String AGENDA_STATUS_ID_REQ_OBJ = "statusId";
	public static final String AGENDA_AVAILABLE_REQ_OBJ = "available";
	public static final String AGENDA_VISIBLE_REQ_OBJ = "visible";
	public static final String AGENDA_EMPTY_STRING_REQ_OBJ = "messageText";
	public static final String AGENDA_NEGATIVE_ID_REQ_OBJ = "purposeId";
	public static final String AGENDA_UPDATED_ADVISOR_ID_OBJ = "updatedAdvisorId";
	public static final String AGENDA_UPDATED_ADVISOR_ENTITY_ID_OBJ = "updatedAdvisorEntityId";

	// JSON objects for portfolio testing
	public static final String PORTFOLIO_PORTFOLIOS_OBJ = "portfolios";
	public static final String PORTFOLIO_PORTFOLIO_RESULT_OBJ = "portfolioResult";
	public static final String PORTFOLIO_ROW_ID_OBJ = "rowId";
	public static final String PORTFOLIO_PORTFOLIO_ID_OBJ = "portfolioId";
	public static final String PORTFOLIO_NAME_OBJ = "name";
	public static final String PORTFOLIO_CODE_OBJ = "code";
	public static final String PORTFOLIO_TYPE_ID_OBJ = "typeId";
	public static final String PORTFOLIO_TYPE_NAME_OBJ = "typeName";
	public static final String PORTFOLIO_TYPE_CODE_OBJ = "typeCode";
	public static final String PORTFOLIO_SIZE_OBJ = "size";
	public static final String PORTFOLIO_FTE_SIZE_OBJ = "fteSize";
	public static final String PORTFOLIO_ENTITY_ID_OBJ = ENTITY_ID;
	public static final String PORTFOLIO_ENTITY_NAME_OBJ = "entityName";
	public static final String PORTFOLIO_OWNER_ID_OBJ = "ownerId";
	public static final String PORTFOLIO_OWNER_FIRSTNAME_OBJ = "ownerFirstName";
	public static final String PORTFOLIO_OWNER_LASTNAME_OBJ = "ownerLastName";
	public static final String PORTFOLIO_TOTAL_COUNT_OBJ = "totalCount";
	public static final String PORTFOLIO_DETAILS_CLIENTS_OBJ = "portfolioClients";
	public static final String PORTFOLIO_DETAILS_ROW_ID_OBJ = "rowId";
	public static final String PORTFOLIO_DETAILS_PORTFOLIO_ID_OBJ = "portfolioId";
	public static final String PORTFOLIO_DETAILS_CLIENT_ID_OBJ = CLIENT_ID;
	public static final String PORTFOLIO_DETAILS_CLIENT_ENTITY_ID_OBJ = CLIENT_ENTITY_ID;
	public static final String PORTFOLIO_DETAILS_CLIENT_ADVISOR_ID_OBJ = "clientAdvisorId";
	public static final String PORTFOLIO_DETAILS_CLIENT_TYPE_OBJ = CLIENT_TYPE;
	public static final String PORTFOLIO_DETAILS_CLIENT_GROUP_TYPE_OBJ = "clientGroupType";
	public static final String PORTFOLIO_DETAILS_CLIENT_NAME_OBJ = "clientName";
	public static final String PORTFOLIO_DETAILS_CLIENT_CODE_OBJ = "clientCode";
	public static final String PORTFOLIO_DETAILS_CLIENT_SEGMENT_OBJ = "clientSegment";
	public static final String PORTFOLIO_DETAILS_TOTAL_COUNT_OBJ = "totalCount";

	// JSON objects for opportunities testing
	public static final String OPPORTUNITIES_CONFIG_OBJ = "opportunitiesConfiguration";
	public static final String PRIORITIES_OBJ = "priorities";
	public static final String SUBCATEGORIES_OBJ = "subcategories";
	public static final String CATEGORIES_OBJ = "categories";
	public static final int LANGUAGE_CODE = 1;
	public static final String LANGUAGE_STRING = "en_EN";

	public static final String OPPORTUNITIES_ELEMENT_OBJ = "opportunitiesElement";

	// Priority JSON objects
	public static final String PRIORITY_ID_OBJ = "priorityId";
	public static final String PRIORITY_NAME_OBJ = "priorityName";

	// Subcategory JSON objects
	public static final String SUBCATEGORY_ID_OBJ = "subcategoryId";
	public static final String SUBCATEGORY_NAME_OBJ = "subcategoryName";

	// Category JSON objects
	public static final String CATEGORY_ID_OBJ = "categoryId";
	public static final String CATEGORY_NAME_OBJ = "categoryName";
	public static final String CATEGORY_COUNT_OBJ = "categoryCount";

	// Cancel request JSON objects
	public static final String CANCEL_REASON_OBJ = "cancelReason";
	public static final String REASON_ID_OBJ = "reasonId";
	public static final String REASON_NAME_OBJ = "reasonName";

	// Opportunity data request JSON objects
	public static final String OPPORTUNITY_DATA_REQUEST_OBJ = "opportunityDataRequest";
	public static final String ADVISOR_ID_OBJ = ADVISOR_ID;
	public static final String PAGE_INDEX_OBJ = "pageIndex";
	public static final String PAGE_SIZE_OBJ = "pageSize";
	public static final String REQUEST_COUNT_OBJ = "recordCount";

	// Opportunity data response JSON objects
	public static final String CLIENT_ID_OBJ = CLIENT_ID;
	public static final String CIVILITY_OBJ = "civility";	
	public static final String OPPORTUNITY_DATA_RESPONSE_OBJ = "opportunityDataResponse";
	public static final String OPPORTUNITY_ID_OBJ = "opportunityId";
	public static final String OPPORTUNITY_TYPE_ID_OBJ = "opportunityTypeId";
	public static final String OPPORTUNITY_SUBCAT_ID_OBJ = "opportunitySubCatId";
	public static final String OPPORTUNITY_START_DATE_OBJ = "opportunityStartDate";
	public static final String OPPORTUNITY_EXPIRATION_DATE_OBJ = "opportunityExpirationDate";
	public static final String OPPORTUNITY_PRIORITY_ID_OBJ = "opportunityPriorityId";
	public static final String OPPORTUNITY_STATUS_ID_OBJ = "opportunityStatusId";
	public static final String OPPORTUNITY_STATUS_NAME_OBJ = "opportunityStatusName";
	public static final String OPPORTUNITY_CONFIG_ID_OBJ = "opportunityConfigId";
	public static final String ROW_ID_OBJ = "rowId";
	public static final String TREATMENT_PERIOD_OBJ = "treatmentPeriod";
	
	// Active user opportunities Json objects
	public static final String USER_ACTIVE_OPPORTUNITY_OBJ = "userActiveOpportunity";
	public static final String OPPORTUNITY_NAME_OBJ = "opportunityName";
	public static final String OPPORTUNITY_ID_ID_OBJ = "opportunityId";
	public static final String OPPORTUNITY_TYPE_ID_ID_OBJ = "opportunityTypeId";
	public static final String OPPORTUNITY_START_DATE_ACTIVE_OPPORTUNITY_OBJ = "opportunityStartDate";
	public static final String OPPORTUNITY_EXPIRATION_DATE_ACTIVE_OPPORTUNITY_OBJ = "opportunityExpirationDate";
	public static final String OPPORTUNITY_TREATMENT_PERIOD_ID_OBJ = "treatmentPeriod";
	public static final String OPPORTUNITY_OPPORTUNITY_STATE_ID_OBJ = "opportunityStateId";

	// Sales Assistant
	public static final String SA_OBJ = "salesAssistant";
	public static final String SA_FIRST_LANGUAGE_OBJ = "firstLanguage";
	public static final String SA_SECOND_LANGUAGE_OBJ = "secondLanguage";
	public static final String SA_CLIENT_ID_OBJ = CLIENT_ID;
	public static final String SA_CLIENT_PRODUCTS_OBJ = "clientProducts";
	public static final String SA_CLIENT_PRODUCTS_GROUP_ID_OBJ = "productGroupId";
	public static final String SA_CLIENT_PRODUCTS_GROUP_NAME_LAN1_OBJ = "productGroupNameLAN1";
	public static final String SA_CLIENT_PRODUCTS_GROUP_NAME_LAN2_OBJ = "productGroupNameLAN2";
	public static final String SA_CLIENT_PRODUCTS_GROUP_DESCRIPTION_LAN1_OBJ = "productGroupDescriptionLAN1";
	public static final String SA_CLIENT_PRODUCTS_GROUP_DESCRIPTION_LAN2_OBJ = "productGroupDescriptionLAN2";
	public static final String SA_CLIENT_PRODUCTS_NAME_LAN1_OBJ = "productNameLAN1";
	public static final String SA_CLIENT_PRODUCTS_NAME_LAN2_OBJ = "productNameLAN2";
	public static final String SA_CLIENT_PRODUCTS_COLOR_OBJ = "productColor";
	public static final String SA_PRODUCT_GROUPS_OBJ = "productGroups";
	public static final String SA_PRODUCT_GROUPS_ID_OBJ = "productGroupId";
	public static final String SA_PRODUCT_GROUPS_CODE_OBJ = "productGroupCode";
	public static final String SA_PRODUCT_GROUPS_NAME_LAN1_OBJ = "productGroupNameLAN1";
	public static final String SA_PRODUCT_GROUPS_NAME_LAN2_OBJ = "productGroupNameLAN2";
	public static final String SA_PRODUCT_GROUPS_DESCRIPTION_LAN1_OBJ = "productGroupDescriptionLAN1";
	public static final String SA_PRODUCT_GROUPS_DESCRIPTION_LAN2_OBJ = "productGroupDescriptionLAN2";
	public static final String SA_OPPORTUNITY_PRODUCTS_OPPORTUNITY_OBJ = "clientOpportunityProducts";
	public static final String SA_OPPORTUNITY_PRODUCTS_OPPORTUNITY_ID_OBJ = "opportunityId";
	public static final String SA_OPPORTUNITY_PRODUCTS_PRODUCT_ID_OBJ = "productId";
	public static final String SA_OPPORTUNITY_PRODUCTS_NAME_LAN1_OBJ = "productNameLAN1";
	public static final String SA_OPPORTUNITY_PRODUCTS_NAME_LAN2_OBJ = "productNameLAN2";
	public static final String SA_OPPORTUNITY_PRODUCTS_LONG_DESCRIPTION_LINK_OBJ = "productLongDescriptionLink";
	public static final String SA_OPPORTUNITY_PRODUCTS_TIPS_LINK_OBJ = "productTipsLink";
	public static final String SA_OPPORTUNITY_PRODUCTS_SIM_LINK_OBJ = "productSimulatorLink";
	public static final String SA_OPPORTUNITY_PRODUCTS_COLOR_OBJ = "productColor";
	public static final String SA_OPPORTUNITY_PRODUCTS_OWNED_OBJ = "productOwnedByClient";
	public static final String SA_OPPORTUNITY_PRODUCTS_HAS_AMOUNT_OBJ = "productHasAmount";
	public static final String SA_OPPORTUNITY_PRODUCTS_HAS_PIECES_OBJ = "productHasPieces";
	public static final String SA_CLIENT_NEEDS_OBJ = "clientNeeds";
	public static final String SA_CLIENT_NEEDS_CATEGORY_OBJ = "needCategory";
	public static final String SA_CLIENT_NEEDS_CATEGORY_ID_OBJ = "needCategoryId";
	public static final String SA_CLIENT_NEEDS_CATEGORY_NAME_LAN1_OBJ = "namesLAN1";
	public static final String SA_CLIENT_NEEDS_CATEGORY_NAME_LAN2_OBJ = "namesLAN2";
	public static final String SA_CLIENT_NEEDS_CATEGORY_PROJECT_ID_OBJ = "projectCategoryId";
	public static final String SA_CLIENT_NEEDS_CATEGORY_PRODUCT_NAME_LAN1_OBJ = "productNamesLAN1";
	public static final String SA_CLIENT_NEEDS_CATEGORY_PRODUCT_NAME_LAN2_OBJ = "productNamesLAN2";
	public static final String SA_CLIENT_NEEDS_CATEGORY_ELIGIBLE_OBJ = "eligible";
	public static final String SA_CLIENT_NEEDS_CATEGORY_RUNNING_PROJECTS_OBJ = "runningProjects";
	public static final String SA_CLIENT_NEEDS_CATEGORY_TOTAL_COUNT_OBJ = "totalCount";
	public static final String SA_CLIENT_NEEDS_SUBCATEGORY_OBJ = "needSubcategory";
	public static final String SA_CLIENT_NEEDS_SUBCATEGORY_ID_OBJ = "needsSubcategoryId";
	public static final String SA_CLIENT_NEEDS_SUBCATEGORY_NAME_LAN1_OBJ = "subcategoryNamesLAN1";
	public static final String SA_CLIENT_NEEDS_SUBCATEGORY_NAME_LAN2_OBJ = "subcategoryNamesLAN2";
	public static final String SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_COUNT_OBJ = "productCount";
	public static final String SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_ID_OBJ = "productId";
	public static final String SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_NAME_LAN1_OBJ = "productNamesLAN1";
	public static final String SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_NAME_LAN2_OBJ = "productNamesLAN2";
	public static final String SA_CLIENT_NEEDS_SUBCATEGORY_COUNT_OBJ = "subcategoryCount";
	public static final String SA_GET_BASKET_OBJ = "getBasket";
	public static final String SA_GET_BASKET_ID_OBJ = "basketId";
	public static final String SA_GET_BASKET_COMMENT_OBJ = "comment";
	public static final String SA_GET_BASKET_ORIGIN_ID_OBJ = "originId";
	public static final String SA_GET_BASKET_BASKET_DATE_OBJ = "basketDate";
	public static final String SA_GET_BASKET_AGREED_LIST_COUNT_OBJ = "agreedListCount";
	public static final String SA_GET_BASKET_AGREED_LIST_PRODUCT_ID_OBJ = "agreedProductId";
	public static final String SA_GET_BASKET_AGREED_LIST_PRODUCT_NAME_L1_OBJ = "agreedProductNameL1";
	public static final String SA_GET_BASKET_AGREED_LIST_PRODUCT_NAME_L2_OBJ = "agreedProductNameL2";
	public static final String SA_GET_BASKET_NUMBER_OF_PIECES_OBJ = "numberOfPieces";
	public static final String SA_GET_BASKET_POSTPONED_LIST_COUNT_OBJ = "postponedListCount";
	public static final String SA_GET_BASKET_POSTPONED_PRODUCT_ID_OBJ = "postponedProductId";
	public static final String SA_GET_BASKET_POSTPONED_PRODUCT_NAME_L1_OBJ = "postponedProductNameL1";
	public static final String SA_GET_BASKET_POSTPONED_PRODUCT_NAME_L2_OBJ = "postponedProductNameL2";
	public static final String SA_GET_BASKET_POSTPONED_TARGET_DATE_OBJ = "targetDate";
	public static final String SA_GET_BASKET_NOT_INTETERESTED_LIST_COUNT_OBJ = "notInterestedListCount";
	public static final String SA_GET_BASKET_NOT_INTERESTED_PRODUCT_ID_OBJ = "notInterestedProductId";
	public static final String SA_GET_BASKET_NOT_INTERESTED_PRODUCT_NAME_L1_OBJ = "notInterestedProductNameL1";
	public static final String SA_GET_BASKET_NOT_INTERESTED_PRODUCT_NAME_L2_OBJ = "notInterestedProductNameL2";
	public static final String SA_GET_BASKET_CREATED_DATE_OBJ = "createdDate";

	// Sales Assistant variables
	private static String SA_FIRST_LANGUAGE = "";
	private static String SA_SECOND_LANGUAGE = "";
	private static int SA_CLIENT_ID = 0;
	private static int SA_CLIENT_PRODUCTS_GROUP_ID = 0;
	private static String SA_CLIENT_PRODUCTS_GROUP_NAME_LAN1 = "";
	private static String SA_CLIENT_PRODUCTS_GROUP_NAME_LAN2 = "";
	private static String SA_CLIENT_PRODUCTS_GROUP_DESCRIPTION_LAN1 = "";
	private static String SA_CLIENT_PRODUCTS_GROUP_DESCRIPTION_LAN2 = "";
	private static String SA_CLIENT_PRODUCTS_NAME_LAN1 = "";
	private static String SA_CLIENT_PRODUCTS_NAME_LAN2 = "";
	private static String SA_CLIENT_PRODUCTS_COLOR = "";
	private static int SA_PRODUCT_GROUPS_ID = 0;
	private static String SA_PRODUCT_GROUPS_CODE = "";
	private static String SA_PRODUCT_GROUPS_NAME_LAN1 = "";
	private static String SA_PRODUCT_GROUPS_NAME_LAN2 = "";
	private static String SA_PRODUCT_GROUPS_DESCRIPTION_LAN1 = "";
	private static String SA_PRODUCT_GROUPS_DESCRIPTION_LAN2 = "";
	private static int SA_OPPORTUNITY_PRODUCTS_OPPORTUNITY_ID = 0;
	private static int SA_OPPORTUNITY_PRODUCTS_PRODUCT_ID = 0;
	private static String SA_OPPORTUNITY_PRODUCTS_NAME_LAN1 = "";
	private static String SA_OPPORTUNITY_PRODUCTS_NAME_LAN2 = "";
	private static String SA_OPPORTUNITY_PRODUCTS_LONG_DESCRIPTION_LINK = "";
	private static String SA_OPPORTUNITY_PRODUCTS_TIPS_LINK = "";
	private static String SA_OPPORTUNITY_PRODUCTS_SIM_LINK = "";
	private static String SA_OPPORTUNITY_PRODUCTS_COLOR = "";
	private static String SA_OPPORTUNITY_PRODUCTS_OWNED = "";
	private static String SA_OPPORTUNITY_PRODUCTS_HAS_AMOUNT = "";
	private static String SA_OPPORTUNITY_PRODUCTS_HAS_PIECES = "";
	private static int SA_CLIENT_NEEDS_CATEGORY_ID = 0;
	private static String SA_CLIENT_NEEDS_CATEGORY_NAME_LAN1 = "";
	private static String SA_CLIENT_NEEDS_CATEGORY_NAME_LAN2 = "";
	private static int SA_CLIENT_NEEDS_CATEGORY_PROJECT_ID = 0;
	private static String SA_CLIENT_NEEDS_CATEGORY_PRODUCT_NAME_LAN1 = "";
	private static String SA_CLIENT_NEEDS_CATEGORY_PRODUCT_NAME_LAN2 = "";
	private static String SA_CLIENT_NEEDS_CATEGORY_ELIGIBLE = "";
	private static String SA_CLIENT_NEEDS_CATEGORY_RUNNING_PROJECTS = "";
	private static int SA_CLIENT_NEEDS_CATEGORY_TOTAL_COUNT = 0;
	private static int SA_CLIENT_NEEDS_SUBCATEGORY_ID = 0;
	private static String SA_CLIENT_NEEDS_SUBCATEGORY_NAME_LAN1 = "";
	private static String SA_CLIENT_NEEDS_SUBCATEGORY_NAME_LAN2 = "";
	private static int SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_COUNT = 0;
	private static int SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_ID = 0;
	private static String SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_NAME_LAN1 = "";
	private static String SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_NAME_LAN2 = "";
	private static int SA_CLIENT_NEEDS_SUBCATEGORY_COUNT = 0;
	private static int SA_GET_BASKET_ID = 0;
	private static String SA_GET_BASKET_COMMENT = "";
	private static int SA_GET_BASKET_ORIGIN_ID = 0;
	private static String SA_GET_BASKET_BASKET_DATE = "";
	private static int SA_GET_BASKET_AGREED_LIST_COUNT = 0;
	private static int SA_GET_BASKET_AGREED_LIST_PRODUCT_ID = 0;
	private static String SA_GET_BASKET_AGREED_LIST_PRODUCT_NAME_L1 = "";
	private static String SA_GET_BASKET_AGREED_LIST_PRODUCT_NAME_L2 = "";
	private static int SA_GET_BASKET_NUMBER_OF_PIECES = 0;
	private static int SA_GET_BASKET_POSTPONED_LIST_COUNT = 0;
	private static int SA_GET_BASKET_POSTPONED_PRODUCT_ID = 0;
	private static String SA_GET_BASKET_POSTPONED_PRODUCT_NAME_L1 = "";
	private static String SA_GET_BASKET_POSTPONED_PRODUCT_NAME_L2 = "";
	private static String SA_GET_BASKET_POSTPONED_TARGET_DATE = "";
	private static int SA_GET_BASKET_NOT_INTERESTED_LIST_COUNT = 0;
	private static int SA_GET_BASKET_NOT_INTERESTED_PRODUCT_ID = 0;
	private static String SA_GET_BASKET_NOT_INTERESTED_PRODUCT_NAME_L1 = "";
	private static String SA_GET_BASKET_NOT_INTERESTED_PRODUCT_NAME_L2 = "";
	private static String SA_GET_BASKET_CREATED_DATE = "";

	// Prospect data object
	public static final String PROSPECTS_DATA_OBJ = "prospectsData";
	public static final String FIRSTNAME_DATA_OBJ = "firstName";
	public static final String LASTNAME_DATA_OBJ = "lastName";
	public static final String EMAIL_DATA_OBJ = "email";
	public static final String PROSPECT_TYPE_ID_DATA_OBJ = "prospectTypeId";
	public static final String CITY_DATA_OBJ = "city";
	public static final String ENTITY_ID_DATA_OBJ = ENTITY_ID;
	public static final String SEGMENT_ID_DATA_OBJ = "segmentId";
	public static final String CHANGE_DATE_DATA_OBJ = "changeDate";

	// Variables for prospect
	private static String FIRSTNAME_DATA = "";
	private static String LASTNAME_DATA = "";
	private static String EMAIL_DATA = "";
	private static int PROSPECT_TYPE_ID_DATA = 0;
	private static String CITY_DATA = "";
	private static int ENTITY_ID_DATA = 0;
	private static int SEGMENT_ID_DATA = 0;
	private static String CHANGE_DATE_DATA = "";
	private static int STATUS_ID = 0;
	// Variables for opportunities testing
	private static int OPPORTUNITIES_ELEMENT = 0;

	// Priority
	private static int PRIORITY_ID_OPPORTUNITY = 0;
	private static String PRIORITY_NAME_OPPORTUNITY = "";

	// Subcategory
	private static int SUBCATEGORY_ID_OPPORTUNITY = 0;
	private static String SUBCATEGORY_NAME_OPPORTUNITY = "";

	// Category
	private static int CATEGORY_ID_OPPORTUNITY = 0;
	private static String CATEGORY_NAME_OPPORTUNITY = "";
	private static int CATEGORY_COUNT_OPPORTUNITY = 0;

	// Cancel Reason
	private static int REASON_ID_OPPORTUNITY = 0;
	private static String REASON_NAME_OPPORTUNITY = "";

	// Opportunity data request
	private static int ADVISOR_ID_OPPORTUNITY_REQ = 0;
	private static int BRANCH_ID_OPPORTUNITY_REQ = 0;
	private static int PAGE_INDEX_OPPORTUNITY_REQ = 0;
	private static int PAGE_SIZE_OPPOPRTUNITY_REQ = 0;
	private static int REQUEST_COUNT_OPPORTUNITY_REQ = 0;
	private static int CATEGORY_ID_OPPORTUNITY_REQ = 0;
	private static int PRIORITY_ID_OPPORTUNITY_REQ = 0;

	// Opportunity data response
	private static int ROW_ID_OPPORTUNITY_RESP = 0;
	private static int OPPORTUNITY_ID_RESP = 0;
	private static int CLIENT_ID_OPPORTUNITY_RESP = 0;
	private static String CLIENT_CODE_OPPORTUNITY_RESP = "";
	private static String CLIENT_TYPE_OPPORTUNITY_RESP = "";
	private static String CIVILITY_OPPORTUNITY_RESP = "";
	private static String FIRST_NAME_OPPORTUNITY_RESP = "";
	private static String LAST_NAME_OPPORTUNITY_RESP = "";
	private static int OPPORTUNITY_TYPE_ID_RESP = 0;
	private static int OPPORTUNITY_SUBCAT_ID_RESP = 0;
	private static String OPPORTUNITY_START_DATE_RESP = "";
	private static String OPPORTUNITY_EXPIRATION_DATE_RESP = "";
	private static String TREATMENT_PERIOD_OPPORTUNITY_RESP = "";
	private static int OPPORTUNITY_PRIORITY_ID_RESP = 0;
	private static int OPPORTUNITY_STATUS_ID_RESP = 0;
	private static String OPPORTUNITY_STATUS_NAME_RESP = "";
	private static int OPPORTUNITY_CONFIG_ID = 0;

	// Active user opportunities variables
	private static String OPPORTUNITY_NAME_RESP = "";
	private static int OPPORTUNITY_ID_ID_RESP = 0;
	private static int OPPORTUNITY_TYPE_ID_ID_RESP = 0;
	private static String OPPORTUNITY_START_DATE_ACTIVE_OPPORTUNITY_RESP = "";
	private static String OPPORTUNITY_EXPIRATION_DATE_ACTIVE_OPPORTUNITY_RESP = "";
	private static String OPPORTUNITY_TREATMENT_PERIOD_ID_RESP = "";
	private static int OPPORTUNITY_OPPORTUNITY_STATE_ID_RESP = 0;

	// Reassign JSON objects
	public static final String REASSIGN_OBJ = "reassign";

	// Reassign variables
	private static int REASSIGN_BRANCH_ID = 0;
	private static int REASSIGN_COLLABORATOR_ID = 0;
	private static int REASSIGN_CALLER_BRANCH_ID = 1;
	private static int REASSIGN_CALLER_COLLABORATOR_ID = 1;
	private static int REASSIGN_OPPORTUNITY_ID = 0;

	// Portfolio variables
	private static int PORTFOLIO_ROW_ID = 0;
	private static int PORTFOLIO_PORTFOLIO_ID = 0;
	private static String PORTFOLIO_NAME = "";
	private static String PORTFOLIO_CODE = "";
	private static int PORTFOLIO_TYPE_ID = 0;
	private static String PORTFOLIO_TYPE_NAME = "";
	private static String PORTFOLIO_TYPE_CODE = "";
	private static int PORTFOLIO_SIZE = 0;
	private static int PORTFOLIO_FTE_SIZE = 0;
	private static int PORTFOLIO_ENTITY_ID = 0;
	private static String PORTFOLIO_ENTITY_NAME = "";
	private static int PORTFOLIO_OWNER_ID = 0;
	private static String PORTFOLIO_OWNER_FIRSTNAME = "";
	private static String PORTFOLIO_OWNER_LASTNAME = "";
	private static int PORTFOLIO_TOTAL_COUNT = 0;
	private static int PORTFOLIO_DETAILS_ROW_ID = 0;
	private static int PORTFOLIO_DETAILS_PORTFOLIO_ID = 0;
	private static int PORTFOLIO_DETAILS_CLIENT_ID = 0;
	private static int PORTFOLIO_DETAILS_CLIENT_ENTITY_ID = 0;
	private static int PORTFOLIO_DETAILS_CLIENT_ADVISOR_ID = 0;
	private static String PORTFOLIO_DETAILS_CLIENT_TYPE = "";
	private static String PORTFOLIO_DETAILS_CLIENT_GROUP_TYPE = "";
	private static String PORTFOLIO_DETAILS_CLIENT_NAME = "";
	private static String PORTFOLIO_DETAILS_CLIENT_CODE = "";
	private static String PORTFOLIO_DETAILS_CLIENT_SEGMENT = "";
	private static int PORTFOLIO_DETAILS_TOTAL_COUNT = 0;

	// Agenda variables
	private static String FROM_TIME = "";
	private static String TO_TIME = "";
	private static int AGENDA_BRANCH_ID = 0;
	private static String LANGUAGE = "";
	private static int AGENDA_AGENDA_ID = 0;
	private static int AGENDA_USER_ID = 0;
	private static int AGENDA_ITEM = 0;
	private static int AGENDA_ITEM_DETAILED = 0;
	private static int AGENDA_ADVISOR_ID = 0;
	private static int AGENDA_ADVISOR_ENTITY_ID = 0;
	private static int AGENDA_ITEM_TYPE_ID = 0;
	private static int AGENDA_STATUS_ID = 0;
	private static int AGENDA_CONTACT_ID = 0;
	private static String AGENDA_CLIENT_TYPE_ID = "";
	private static int AGENDA_CLIENT_ID = 0;
	private static int AGENDA_CLIENT_ENTITY_ID = 0;
	private static int AGENDA_CLIENT_PORTFOLIO_ID = 0;
	private static int AGENDA_MESSAGE_TYPE_ID = 0;
	private static String AGENDA_START_TIME = "";
	private static String AGENDA_END_TIME = "";
	private static int AGENDA_WEEKLY_FREQUENCY = 0;
	private static int AGENDA_REMINDER_TIME = 0;
	private static int AGENDA_CLOSE_REASON_ID = 0;
	private static int AGENDA_AVAILABLE = 0;
	private static int AGENDA_VISIBLE = 0;
	private static int AGENDA_LOCATION_ID = 0;
	private static int AGENDA_ORIGIN_ID = 0;
	private static int AGENDA_DURATION_ID = 0;
	private static int AGENDA_CANCEL_REASON_ID = 0;
	private static String AGENDA_FIRST_NAME = "";
	private static int AGENDA_ELEMENT_ID_REQ = 0;
	private static int AGENDA_POSITIVE_ID_REQ = 0;
	private static String AGENDA_START_TIME_REQ = "";
	private static String AGENDA_END_TIME_REQ = "";
	private static String AGENDA_UPDATED_START_TIME_REQ = "";
	private static String AGENDA_UPDATED_END_TIME_REQ = "";
	private static int AGENDA_STATUS_ID_REQ = 0;
	private static int AGENDA_AVAILABLE_REQ = 0;
	private static int AGENDA_VISIBLE_REQ = 0;
	private static String AGENDA_EMPTY_STRING_REQ = "";
	private static int AGENDA_NEGATIVE_ID_REQ = 0;
	private static int AGENDA_LANG_ID=0;
	private static int AGENDA_UPDATED_ADVISOR_ID = 0;
	private static int AGENDA_UPDATED_ADVISOR_ENTITY_ID = 0;

	// Quick contact report
	private static int QCR_CLIENT_ID = 0;
	private static int QCR_CLIENT_ENTITY_ID = 0;
	private static int QCR_CLIENT_PORTFOLIO_ID = 0;
	private static String QCR_CLIENT_TYPE = "";
	private static String QCR_REPORT_DATE = "";
	private static int QCR_REQUEST_ID = 0;
	private static int QCR_CHANNEL_ID = 0;
	private static int QCR_REASON_ID = 0;
	private static int QCR_RESULT_ID = 0;
	private static String QCR_COMMENT = "";
	private static int QCR_DETAIL_ENTITY_ID = 0;
	private static int QCR_DETAIL_ADVISOR_ID = 0;
	private static int QCR_DETAIL_CLIENT_ADVISOR_ID = 0;
	private static int QCR_DETAIL_CLIENT_ENTITY_ID = 0;
	private static int QCR_DETAIL_CLIENT_PORTFOLIO_ID = 0;
	private static int QCR_DETAIL_CLIENT_ID = 0;
	private static String QCR_DETAIL_CLIENT_TYPE = "";
	private static int QCR_DETAIL_REQUEST_ID = 0;
	private static int QCR_DETAIL_CHANNEL_ID = 0;
	private static int QCR_DETAIL_REASON_ID = 0;
	private static int QCR_DETAIL_CLAIM_REASON_ID = 0;
	private static int QCR_DETAIL_UNREACHABLE_REASON_ID = 0;
	private static int QCR_DETAIL_NOT_INT_REASON_ID = 0;
	private static int QCR_DETAIL_RESULT_ID = 0;
	private static String QCR_DETAIL_REPORT_DATE = "";

	// Client info JSON objects
	public static final String CLIENT_DATA_OBJ = "clientData";
	public static final String NAME_OBJ = "name";
	public static final String SURNAME_OBJ = "surname";
	public static final String BIRTH_DATE_OBJ = "birthDate";
	public static final String NUMBER_OF_YEARS_OBJ = "numberOfYears";

	// Client info variables
	private static int CLIENT_ID_INFO = 0;
	private static String CLIENT_CODE_INFO = "";
	private static String CLIENT_NAME_INFO = "";
	private static String CLIENT_SURNAME_INFO = "";
	private static String CLIENT_BIRTH_DATE_INFO = "";
	private static int CLIENT_NUMBER_OF_YEARS_INFO = 0;

	// Hierarchy data JSON objects
	public static final String HIERARCHY_DATA_OBJ = "hierarchyData";
	// public static final String HIERARCHY_SIZE_OBJ = "hierarchySize";
	public static final String CALLER_ID_OBJ = "portfolioId";
	public static final String PORTFOLIO_ID_OBJ = "callerId";

	public static final String P1_OBJ = "p1";
	public static final String P2_OBJ = "p2";
	public static final String P3_OBJ = "p3";
	public static final String P4_OBJ = "p4";
	public static final String P5_OBJ = "p5";
	public static final String P6_OBJ = "p6";

	// Hierarchy data variables
	private static String HIERARCHY_CALLER_ID = "";
	private static String HIERARCHY_PORTFOLIO_ID = "";

	private static int REGION_LEVEL_1_BRANCH_1_ID = 0;
	private static int REGION_LEVEL_2_BRANCH_1_ID = 0;
	private static int REGION_LEVEL_3_BRANCH_1_ID = 0;
	private static int REGION_LEVEL_4_BRANCH_1_ID = 0;

	private static int REGION_LEVEL_2_BRANCH_2_ID = 0;
	private static int REGION_LEVEL_3_BRANCH_2_ID = 0;
	private static int REGION_LEVEL_4_BRANCH_2_ID = 0;

	private static int P1 = 0;
	private static int P2 = 0;
	private static int P3 = 0;
	private static int P4 = 0;
	private static int P5 = 0;
	private static int P6 = 0;

	// Agenda item statusId
	public static final int AGENDA_ITEM_STATUS_INITIATED = 1;
	
	public static final int ROLE_BUSINESS_ADMINISTRATOR = 100;
	
	public static final int BIG_INTEGER_BIT_LENGTH_130 = 130;
	
	public static final int INTEGER_VALUE_16 = 16;

	public static final int STRING_LENGTH_3 = 3;
	public static final int STRING_LENGTH_4 = 4;	
	public static final int STRING_LENGTH_5 = 5;	
	public static final int STRING_LENGTH_6 = 6;
	public static final int STRING_LENGTH_7 = 7;
	public static final int STRING_LENGTH_8 = 8;
	public static final int STRING_LENGTH_9 = 9;	
	public static final int STRING_LENGTH_10 = 10;
	public static final int STRING_LENGTH_15 = 15;
	public static final int STRING_LENGTH_20 = 20;
	public static final int STRING_LENGTH_25 = 25;	
	public static final int STRING_LENGTH_30 = 30;	

	public static final int USER_ID_4 = 4;
	
	public static final int TOKEN_LENGTH_32 = 32;

	public static final int ENTITY_ID_4 = 4;
	public static final int ENTITY_ID_5 = 5;
	public static final int ENTITY_ID_6 = 6;	
	public static final int ENTITY_ID_12 = 12;
	
	public static final int PORTFOLIO_ID_5 = 5;
	public static final int PORTFOLIO_ID_10 = 10;
	public static final int PORTFOLIO_ID_20 = 20;
	
	public static final int PAGE_SIZE_10 = 10;
	
	public static final int NEED_CATEGORY_ID_1 = 1;
	
	public static final int CLIENT_ID_3 = 3;
	public static final int CLIENT_ID_31 = 31;
	
	public static final int PRODUCT_ID_6 = 6;
	public static final int NOT_INTERESTED_REASON_ID_1 = 1;
	public static final int OPPORTUNITY_ID_1 = 1;
		
	public static final int ADVISOR_ID_4 = 4;
	
	public static final int HASHMAP_INITIAL_SIZE_2 = 2;
	
	public static final int SUBSTRING_END_INDEX_30 = 30;

	public static int getId() {
		return ID;
	}

	public static void setId(int id) {
		ID = id;
	}

	public static String getEntityCode() {
		return ENTITY_CODE;
	}

	public static void setEntityCode(String entityCode) {
		ENTITY_CODE = entityCode;
	}

	public static String getEntityName() {
		return ENTITY_NAME;
	}

	public static void setEntityName(String entityName) {
		ENTITY_NAME = entityName;
	}

	public static String getFirstName() {
		return FIRST_NAME;
	}

	public static void setFirstName(String firstName) {
		FIRST_NAME = firstName;
	}

	public static String getLastName() {
		return LAST_NAME;
	}

	public static void setLastName(String lastName) {
		LAST_NAME = lastName;
	}

	public static String getFunctionName() {
		return FUNCTION_NAME;
	}

	public static void setFunctionName(String functionName) {
		FUNCTION_NAME = functionName;
	}

	public static String getPassword() {
		return PASS;
	}

	public static void setPassword(String password) {
		PASS = password;
	}

	public static int getBranchId() {
		return BRANCH_ID;
	}

	public static void setBranchId(int branchId) {
		BRANCH_ID = branchId;
	}

	public static int getCollaboratorId() {
		return COLLABORATOR_ID;
	}

	public static void setCollaboratorId(int collaboratorId) {
		COLLABORATOR_ID = collaboratorId;
	}

	public static String getSubject() {
		return SUBJECT;
	}

	public static void setSubject(String subject) {
		SUBJECT = subject;
	}

	public static String getDateTime() {
		return DATE_TIME;
	}

	public static void setDateTime(String dateTime) {
		DATE_TIME = dateTime;
	}

	public static int getClient() {
		return CLIENT;
	}

	public static void setClient(int client) {
		CLIENT = client;
	}

	public static String getComment() {
		return COMMENT;
	}

	public static void setComment(String comment) {
		COMMENT = comment;
	}

	public static String getNameToDo() {
		return NAME_TO_DO;
	}

	public static void setNameToDo(String nameToDo) {
		NAME_TO_DO = nameToDo;
	}

	public static String getSurnameToDo() {
		return SURNAME_TO_DO;
	}

	public static void setSurnameToDo(String surnameToDo) {
		SURNAME_TO_DO = surnameToDo;
	}

	public static int getCollaboratorUpdateId() {
		return COLLABORATOR_UPDATE_ID;
	}

	public static void setCollaboratorUpdateId(int collaboratorUpdateId) {
		COLLABORATOR_UPDATE_ID = collaboratorUpdateId;
	}

	public static String getNameUpdateToDo() {
		return NAME_UPDATE_TO_DO;
	}

	public static void setNameUpdateToDo(String nameUpdateToDo) {
		NAME_UPDATE_TO_DO = nameUpdateToDo;
	}

	public static String getSurnameUpdateToDo() {
		return SURNAME_UPDATE_TO_DO;
	}

	public static void setSurnameUpdateToDo(String surnameUpdateToDo) {
		SURNAME_UPDATE_TO_DO = surnameUpdateToDo;
	}

	public static String getSubjectUpdate() {
		return SUBJECT_UPDATE;
	}

	public static void setSubjectUpdate(String subjectUpdate) {
		SUBJECT_UPDATE = subjectUpdate;
	}

	public static String getDateTimeUpdate() {
		return DATE_TIME_UPDATE;
	}

	public static void setDateTimeUpdate(String dateTimeUpdate) {
		DATE_TIME_UPDATE = dateTimeUpdate;
	}

	public static int getClientUpdate() {
		return CLIENT_UPDATE;
	}

	public static void setClientUpdate(int clientUpdate) {
		CLIENT_UPDATE = clientUpdate;
	}

	public static String getCommentUpdate() {
		return COMMENT_UPDATE;
	}

	public static void setCommentUpdate(String commentUpdate) {
		COMMENT_UPDATE = commentUpdate;
	}

	public static int getStatus() {
		return STATUS;
	}

	public static void setStatus(int status) {
		STATUS = status;
	}

	public static int getQuickSearchItem() {
		return QUICK_SEARCH_ITEM;
	}

	public static void setQuickSearchItem(int quickSearchItem) {
		QUICK_SEARCH_ITEM = quickSearchItem;
	}

	public static int getAdvancedSearchItem() {
		return ADVANCED_SEARCH_ITEM;
	}

	public static void setAdvancedSearchItem(int advancedSearchItem) {
		ADVANCED_SEARCH_ITEM = advancedSearchItem;
	}

	public static int getBankIdSearch() {
		return BANK_ID_SEARCH;
	}

	public static void setBankIdSearch(int bankIdSearch) {
		BANK_ID_SEARCH = bankIdSearch;
	}

	public static String getNeedleSearch() {
		return NEEDLE_SEARCH;
	}

	public static void setNeedleSearch(String needleSearch) {
		NEEDLE_SEARCH = needleSearch;
	}

	public static String getClSearch() {
		return CL_SEARCH;
	}

	public static void setClSearch(String clSearch) {
		CL_SEARCH = clSearch;
	}

	public static String getClientTypeSearch() {
		return CLIENT_TYPE_SEARCH;
	}

	public static void setClientTypeSearch(String clientTypeSearch) {
		CLIENT_TYPE_SEARCH = clientTypeSearch;
	}

	public static int getClientSearch() {
		return CLIENT_SEARCH;
	}

	public static void setClientSearch(int clientSearch) {
		CLIENT_SEARCH = clientSearch;
	}

	public static String getClientCodeSearch() {
		return CLIENT_CODE_SEARCH;
	}

	public static void setClientCodeSearch(String clientCodeSearch) {
		CLIENT_CODE_SEARCH = clientCodeSearch;
	}

	public static String getFirstNameSearch() {
		return FIRST_NAME_SEARCH;
	}

	public static void setFirstNameSearch(String firstNameSearch) {
		FIRST_NAME_SEARCH = firstNameSearch;
	}

	public static String getLastNameSearch() {
		return LAST_NAME_SEARCH;
	}

	public static void setLastNameSearch(String lastNameSearch) {
		LAST_NAME_SEARCH = lastNameSearch;
	}

	public static String getCitySearch() {
		return CITY_SEARCH;
	}

	public static void setCitySearch(String citySearch) {
		CITY_SEARCH = citySearch;
	}

	public static String getMobilePhoneSearch() {
		return MOBILE_PHONE_SEARCH;
	}

	public static void setMobilePhoneSearch(String mobilePhoneSearch) {
		MOBILE_PHONE_SEARCH = mobilePhoneSearch;
	}

	public static String getLastContactDate() {
		return LAST_CONTACT_DATE_SEARCH;
	}

	public static void setLastContactDateSearch(String lastContactDateSearch) {
		LAST_CONTACT_DATE_SEARCH = lastContactDateSearch;
	}

	public static String getLastContactAdvisorSearch() {
		return LAST_CONTACT_ADVISOR_SEARCH;
	}

	public static void setLastContactAdvisorSearch(String lastContactAdvisorSearch) {
		LAST_CONTACT_ADVISOR_SEARCH = lastContactAdvisorSearch;
	}

	public static String getSegmentSearch() {
		return SEGMENT_SEARCH;
	}

	public static void setSegmentSearch(String segmentSearch) {
		SEGMENT_SEARCH = segmentSearch;
	}

	public static String getBranchSearch() {
		return BRANCH_SEARCH;
	}

	public static void setBranchSearch(String branchSearch) {
		BRANCH_SEARCH = branchSearch;
	}

	public static String getAdvisorsSearch() {
		return ADVISORS_SEARCH;
	}

	public static void setAdvisorsSearch(String advisorsSearch) {
		ADVISORS_SEARCH = advisorsSearch;
	}

	public static int getArrayElementCountryConfiguration() {
		return ARRAY_ELEMENT_COUNTRY_CONFIGURATION;
	}

	public static void setArrayElementCountryConfiguration(int arrayElementCountryConfiguration) {
		ARRAY_ELEMENT_COUNTRY_CONFIGURATION = arrayElementCountryConfiguration;
	}

	public static String getAuditObj() {
		return AUDIT_OBJ;
	}

	public static void setAuditObj(String auditObj) {
		AUDIT_OBJ = auditObj;
	}

	public static String getAuditApplicationIdObj() {
		return AUDIT_APPLICATION_ID_OBJ;
	}

	public static void setAuditApplicationIdObj(String auditApplicationIdObj) {
		AUDIT_APPLICATION_ID_OBJ = auditApplicationIdObj;
	}

	public static String getAuditTransactionIdObj() {
		return AUDIT_TRANSACTION_ID_OBJ;
	}

	public static void setAuditTransactionIdObj(String auditTransactionIdObj) {
		AUDIT_TRANSACTION_ID_OBJ = auditTransactionIdObj;
	}

	public static String getAuditLangCodeObj() {
		return AUDIT_LANG_CODE_OBJ;
	}

	public static void setAuditLangCodeObj(String auditLangCodeObj) {
		AUDIT_LANG_CODE_OBJ = auditLangCodeObj;
	}

	public static String getAuditStartTimeObj() {
		return AUDIT_START_TIME_OBJ;
	}

	public static void setAuditStartTimeObj(String auditStartTimeObj) {
		AUDIT_START_TIME_OBJ = auditStartTimeObj;
	}

	public static String getAudtiEndTime() {
		return AUDIT_END_TIME_OBJ;
	}

	public static void setAudtiEndTime(String audtiEndTime) {
		AUDIT_END_TIME_OBJ = audtiEndTime;
	}

	public static String getAuditStartTimeDistantObj() {
		return AUDIT_START_TIME_DISTANT_OBJ;
	}

	public static void setAuditStartTimeDistantObj(String auditStartTimeDistantObj) {
		AUDIT_START_TIME_DISTANT_OBJ = auditStartTimeDistantObj;
	}

	public static String getAuditEndTimeDistantObj() {
		return AUDIT_END_TIME_DISTANT_OBJ;
	}

	public static void setAuditEndTimeDistantObj(String auditEndTimeDistantObj) {
		AUDIT_END_TIME_DISTANT_OBJ = auditEndTimeDistantObj;
	}

	public static String getAuditTargetEntityIdObj() {
		return AUDIT_TARGET_ENTITY_ID_OBJ;
	}

	public static void setAuditTargetEntityIdObj(String auditTargetEntityIdObj) {
		AUDIT_TARGET_ENTITY_ID_OBJ = auditTargetEntityIdObj;
	}

	public static String getAuditTargetIdObj() {
		return AUDIT_TARGET_ID_OBJ;
	}

	public static void setAuditTargetIdObj(String auditTargetIdObj) {
		AUDIT_TARGET_ID_OBJ = auditTargetIdObj;
	}

	public static String getAuditAdvisorIdObj() {
		return AUDIT_ADVISOR_ID_OBJ;
	}

	public static void setAuditAdvisorIdObj(String auditAdvisorIdObj) {
		AUDIT_ADVISOR_ID_OBJ = auditAdvisorIdObj;
	}

	public static int getAuditApplicationId() {
		return AUDIT_APPLICATION_ID;
	}

	public static void setAuditApplicationId(int auditApplicationId) {
		AUDIT_APPLICATION_ID = auditApplicationId;
	}

	public static int getAuditTransactionId() {
		return AUDIT_TRANSACTION_ID;
	}

	public static void setAuditTransactionId(int auditTransactionId) {
		AUDIT_TRANSACTION_ID = auditTransactionId;
	}

	public static int getAuditLangCode() {
		return AUDIT_LANG_CODE;
	}

	public static void setAuditLangCode(int auditLangCode) {
		AUDIT_LANG_CODE = auditLangCode;
	}

	public static String getAuditStartTime() {
		return AUDIT_START_TIME;
	}

	public static void setAuditStartTime(String auditStartTime) {
		AUDIT_START_TIME = auditStartTime;
	}

	public static String getAuditEndTime() {
		return AUDIT_END_TIME;
	}

	public static void setAuditEndTime(String auditEndTime) {
		AUDIT_END_TIME = auditEndTime;
	}

	public static String getAuditStartTimeDistant() {
		return AUDIT_START_TIME_DISTANT;
	}

	public static void setAuditStartTimeDistant(String auditStartTimeDistant) {
		AUDIT_START_TIME_DISTANT = auditStartTimeDistant;
	}

	public static String getAuditEndTimeDistant() {
		return AUDIT_END_TIME_DISTANT;
	}

	public static void setAuditEndTimeDistant(String auditEndTimeDistant) {
		AUDIT_END_TIME_DISTANT = auditEndTimeDistant;
	}

	public static int getAuditTargetEntityId() {
		return AUDIT_TARGET_ENTITY_ID;
	}

	public static void setAuditTargetEntityId(int auditTargetEntityId) {
		AUDIT_TARGET_ENTITY_ID = auditTargetEntityId;
	}

	public static int getAuditTargetId() {
		return AUDIT_TARGET_ID;
	}

	public static void setAuditTargetId(int auditTargetId) {
		AUDIT_TARGET_ID = auditTargetId;
	}

	public static int getAuditAdvisorId() {
		return AUDIT_ADVISOR_ID;
	}

	public static void setAuditAdvisorId(int auditAdvisorId) {
		AUDIT_ADVISOR_ID = auditAdvisorId;
	}

	public static int getArrayElementAdvisor() {
		return ARRAY_ELEMENT_ADVISOR;
	}

	public static void setArrayElementAdvisor(int arrayElementAdvisor) {
		ARRAY_ELEMENT_ADVISOR = arrayElementAdvisor;
	}

	public static int getUserIdAdvisor() {
		return USER_ID_ADVISOR;
	}

	public static void setUserIdAdvisor(int userIdAdvisor) {
		USER_ID_ADVISOR = userIdAdvisor;
	}

	public static String getFirstNameAdvisor() {
		return FIRST_NAME_ADVISOR;
	}

	public static void setFirstNameAdvisor(String firstNameAdvisor) {
		FIRST_NAME_ADVISOR = firstNameAdvisor;
	}

	public static String getLastNameAdvisor() {
		return LAST_NAME_ADVISOR;
	}

	public static void setLastNameAdvisor(String lastNameAdvisor) {
		LAST_NAME_ADVISOR = lastNameAdvisor;
	}

	public static String getEntityCodeAdvisor() {
		return ENTITY_CODE_ADVISOR;
	}

	public static void setEntityCodeAdvisor(String entityCodeAdvisor) {
		ENTITY_CODE_ADVISOR = entityCodeAdvisor;
	}

	public static int getEntityIdCountryConfig() {
		return ENTITY_ID_COUNTRY_CONFIG;
	}

	public static void setEntityIdCountryConfig(int entityIdCountryConfig) {
		ENTITY_ID_COUNTRY_CONFIG = entityIdCountryConfig;
	}

	public static String getEntityCodeCountryConfig() {
		return ENTITY_CODE_COUNTRY_CONFIG;
	}

	public static void setEntityCodeCountryConfig(String entityCodeCountryConfig) {
		ENTITY_CODE_COUNTRY_CONFIG = entityCodeCountryConfig;
	}

	public static String getEntityNameCountryConfig() {
		return ENTITY_NAME_COUNTRY_CONFIG;
	}

	public static void setEntityNameCountryConfig(String entityNameCountryConfig) {
		ENTITY_NAME_COUNTRY_CONFIG = entityNameCountryConfig;
	}

	public static String getParentEntityCountryConfig() {
		return PARENT_ENTITY_COUNTRY_CONFIG;
	}

	public static void setParentEntityCountryConfig(String parentEntityCountryConfig) {
		PARENT_ENTITY_COUNTRY_CONFIG = parentEntityCountryConfig;
	}

	public static int getLevelCountryConfig() {
		return LEVEL_COUNTRY_CONFIG;
	}

	public static void setLevelCountryConfig(int levelCountryConfig) {
		LEVEL_COUNTRY_CONFIG = levelCountryConfig;
	}

	public static int getSegmentIdCountryConfig() {
		return SEGMENT_ID_COUNTRY_CONFIG;
	}

	public static void setSegmentIdCountryConfig(int segmentIdCountryConfig) {
		SEGMENT_ID_COUNTRY_CONFIG = segmentIdCountryConfig;
	}

	public static String getSegmentNameCountryConfig() {
		return SEGMENT_NAME_COUNTRY_CONFIG;
	}

	public static void setSegmentNameCountryConfig(String segmentNameCountryConfig) {
		SEGMENT_NAME_COUNTRY_CONFIG = segmentNameCountryConfig;
	}

	public static int getClientTypeIdCountryConfig() {
		return CLIENT_TYPE_ID_COUNTRY_CONFIG;
	}

	public static void setClientTypeIdCountryConfig(int clientTypeIdCountryConfig) {
		CLIENT_TYPE_ID_COUNTRY_CONFIG = clientTypeIdCountryConfig;
	}

	public static String getClientTypeNameCountryConfig() {
		return CLIENT_TYPE_NAME_COUNTRY_CONFIG;
	}

	public static void setClientTypeNameCountryConfig(String clientTypeNameCountryConfig) {
		CLIENT_TYPE_NAME_COUNTRY_CONFIG = clientTypeNameCountryConfig;
	}

	public static String getBankCountryConfig() {
		return BANK_COUNTRY_CONFIG;
	}

	public static void setBankCountryConfig(String bankCountryConfig) {
		BANK_COUNTRY_CONFIG = bankCountryConfig;
	}

	public static String getSAFirstLanguage() {
		return SA_FIRST_LANGUAGE;
	}

	public static void setSAFirstLanguage(String saFirstLanguage) {
		SA_FIRST_LANGUAGE = saFirstLanguage;
	}

	public static String getSASecondLanguage() {
		return SA_SECOND_LANGUAGE;
	}

	public static void setSASecondLanguage(String saSecondLanguage) {
		SA_SECOND_LANGUAGE = saSecondLanguage;
	}

	public static int getSAClientId() {
		return SA_CLIENT_ID;
	}

	public static void setSAClientId(int saClientId) {
		SA_CLIENT_ID = saClientId;
	}

	public static int getSAClientProductsGroupId() {
		return SA_CLIENT_PRODUCTS_GROUP_ID;
	}

	public static void setSAClientProductsGroupId(int saClientProductsGroupId) {
		SA_CLIENT_PRODUCTS_GROUP_ID = saClientProductsGroupId;
	}

	public static String getSAClientProductsGroupNameLan1() {
		return SA_CLIENT_PRODUCTS_GROUP_NAME_LAN1;
	}

	public static void setSAClientProductsGroupNameLan1(String saClientProductsGroupNameLan1) {
		SA_CLIENT_PRODUCTS_GROUP_NAME_LAN1 = saClientProductsGroupNameLan1;
	}

	public static String getSAClientProductsGroupNameLan2() {
		return SA_CLIENT_PRODUCTS_GROUP_NAME_LAN2;
	}

	public static void setSAClientProductsGroupNameLan2(String saClientProductsGroupNameLan2) {
		SA_CLIENT_PRODUCTS_GROUP_NAME_LAN2 = saClientProductsGroupNameLan2;
	}

	public static String getSAClientProductsGroupDescriptionLan1() {
		return SA_CLIENT_PRODUCTS_GROUP_DESCRIPTION_LAN1;
	}

	public static void setSAClientProductsGroupDescriptionLan1(String saClientProductsGroupDescriptionLan1) {
		SA_CLIENT_PRODUCTS_GROUP_DESCRIPTION_LAN1 = saClientProductsGroupDescriptionLan1;
	}

	public static String getSAClientProductsGroupDescriptionLan2() {
		return SA_CLIENT_PRODUCTS_GROUP_DESCRIPTION_LAN2;
	}

	public static void setSAClientProductsGroupDescriptionLan2(String saClientProductsGroupDescriptionLan2) {
		SA_CLIENT_PRODUCTS_GROUP_DESCRIPTION_LAN2 = saClientProductsGroupDescriptionLan2;
	}

	public static String getSAClientProductsNameLan1() {
		return SA_CLIENT_PRODUCTS_NAME_LAN1;
	}

	public static void setSAClientProductsNameLan1(String saClientProductsNameLan1) {
		SA_CLIENT_PRODUCTS_NAME_LAN1 = saClientProductsNameLan1;
	}

	public static String getSAClientProductsNameLan2() {
		return SA_CLIENT_PRODUCTS_NAME_LAN2;
	}

	public static void setSAClientProductsNameLan2(String saClientProductsNameLan2) {
		SA_CLIENT_PRODUCTS_NAME_LAN2 = saClientProductsNameLan2;
	}

	public static String getSAClientProductsColor() {
		return SA_CLIENT_PRODUCTS_COLOR;
	}

	public static void setSAClientProductsColor(String saClientProductsColor) {
		SA_CLIENT_PRODUCTS_COLOR = saClientProductsColor;
	}

	public static int getSAProductGroupsId() {
		return SA_PRODUCT_GROUPS_ID;
	}

	public static void setSAProductGroupsId(int saProductGroupsId) {
		SA_PRODUCT_GROUPS_ID = saProductGroupsId;
	}

	public static String getSAProductGroupsCode() {
		return SA_PRODUCT_GROUPS_CODE;
	}

	public static void setSAProductGroupsCode(String saProductGroupsCode) {
		SA_PRODUCT_GROUPS_CODE = saProductGroupsCode;
	}

	public static String getSAProductGroupsNameLan1() {
		return SA_PRODUCT_GROUPS_NAME_LAN1;
	}

	public static void setSAProductGroupsNameLan1(String saProductGroupsNameLan1) {
		SA_PRODUCT_GROUPS_NAME_LAN1 = saProductGroupsNameLan1;
	}

	public static String getSAProductGroupsNameLan2() {
		return SA_PRODUCT_GROUPS_NAME_LAN2;
	}

	public static void setSAProductGroupsNameLan2(String saProductGroupsNameLan2) {
		SA_PRODUCT_GROUPS_NAME_LAN2 = saProductGroupsNameLan2;
	}

	public static String getSAProductGroupsDescriptionLan1() {
		return SA_PRODUCT_GROUPS_DESCRIPTION_LAN1;
	}

	public static void setSAProductGroupsDescriptionLan1(String saSAProductGroupsDescriptionLan1) {
		SA_PRODUCT_GROUPS_DESCRIPTION_LAN1 = saSAProductGroupsDescriptionLan1;
	}

	public static String getSAProductGroupsDescriptionLan2() {
		return SA_PRODUCT_GROUPS_DESCRIPTION_LAN2;
	}

	public static void setSASAProductGroupsDescriptionLan2(String saProductGroupsDescriptionLan1) {
		SA_PRODUCT_GROUPS_DESCRIPTION_LAN2 = saProductGroupsDescriptionLan1;
	}

	public static int getSAOpportunityProductsOpportunityId() {
		return SA_OPPORTUNITY_PRODUCTS_OPPORTUNITY_ID;
	}

	public static void setSAOpportunityProductsOpportunityId(int saOpportunityProductsOpportunityId) {
		SA_OPPORTUNITY_PRODUCTS_OPPORTUNITY_ID = saOpportunityProductsOpportunityId;
	}

	public static int getSAOpportunityProductsProductId() {
		return SA_OPPORTUNITY_PRODUCTS_PRODUCT_ID;
	}

	public static void setSAOpportunityProductsProductId(int saOpportunityProductsProductId) {
		SA_OPPORTUNITY_PRODUCTS_PRODUCT_ID = saOpportunityProductsProductId;
	}

	public static String getSAOpportunityProductsNameL1() {
		return SA_OPPORTUNITY_PRODUCTS_NAME_LAN1;
	}

	public static void setSAOpportunityProductsNameL1(String saSAOpportunityProductsNameL1) {
		SA_OPPORTUNITY_PRODUCTS_NAME_LAN1 = saSAOpportunityProductsNameL1;
	}

	public static String getSAOpportunityProductsNameL2() {
		return SA_OPPORTUNITY_PRODUCTS_NAME_LAN2;
	}

	public static void setSAOpportunityProductsNameL2(String saOpportunityProductsNameL2) {
		SA_OPPORTUNITY_PRODUCTS_NAME_LAN2 = saOpportunityProductsNameL2;
	}

	public static String getSAOpportunityProductsLongDescriptionLink() {
		return SA_OPPORTUNITY_PRODUCTS_LONG_DESCRIPTION_LINK;
	}

	public static void setSAOpportunityProductsLongDescriptionLink(String saOpportunityProductsLongDescriptionLink) {
		SA_OPPORTUNITY_PRODUCTS_LONG_DESCRIPTION_LINK = saOpportunityProductsLongDescriptionLink;
	}

	public static String getSAOpportunityProductsTipsLink() {
		return SA_OPPORTUNITY_PRODUCTS_TIPS_LINK;
	}

	public static void setSAOpportunityProductsTipsLink(String saOpportunityProductsTipsLink) {
		SA_OPPORTUNITY_PRODUCTS_TIPS_LINK = saOpportunityProductsTipsLink;
	}

	public static String getSAOpportunityProductsSimLink() {
		return SA_OPPORTUNITY_PRODUCTS_SIM_LINK;
	}

	public static void setSAOpportunityProductsSimLink(String saOpportunityProductsSimLink) {
		SA_OPPORTUNITY_PRODUCTS_SIM_LINK = saOpportunityProductsSimLink;
	}

	public static String getSAOpportunityProductsColor() {
		return SA_OPPORTUNITY_PRODUCTS_COLOR;
	}

	public static void setSAOpportunityProductsColor(String saOpportunityProductsColor) {
		SA_OPPORTUNITY_PRODUCTS_COLOR = saOpportunityProductsColor;
	}

	public static String getSAOpportunityProductsOwned() {
		return SA_OPPORTUNITY_PRODUCTS_OWNED;
	}

	public static void setSAOpportunityProductsOwned(String saOpportunityProductsOwned) {
		SA_OPPORTUNITY_PRODUCTS_OWNED = saOpportunityProductsOwned;
	}

	public static String getSAOpportunityProductsHasAmount() {
		return SA_OPPORTUNITY_PRODUCTS_HAS_AMOUNT;
	}

	public static void setSAOpportunityProductsHasAmount(String saOpportunityProductsHasAmount) {
		SA_OPPORTUNITY_PRODUCTS_HAS_AMOUNT = saOpportunityProductsHasAmount;
	}

	public static String getSAOpportunityProductsHasPieces() {
		return SA_OPPORTUNITY_PRODUCTS_HAS_PIECES;
	}

	public static void setSAOpportunityProductsHasPieces(String saOpportunityProductsHasPieces) {
		SA_OPPORTUNITY_PRODUCTS_HAS_PIECES = saOpportunityProductsHasPieces;
	}

	public static int getSAClientNeedsCategoryId() {
		return SA_CLIENT_NEEDS_CATEGORY_ID;
	}

	public static void setSAClientNeedsCategoryId(int saClientNeedsCategoryId) {
		SA_CLIENT_NEEDS_CATEGORY_ID = saClientNeedsCategoryId;
	}

	public static String getSAClientNeedsCategoryNameLan1() {
		return SA_CLIENT_NEEDS_CATEGORY_NAME_LAN1;
	}

	public static void setSAClientNeedsCategoryNameLan1(String saClientNeedsCategoryNameLan1) {
		SA_CLIENT_NEEDS_CATEGORY_NAME_LAN1 = saClientNeedsCategoryNameLan1;
	}

	public static String getSAClientNeedsCategoryNameLan2() {
		return SA_CLIENT_NEEDS_CATEGORY_NAME_LAN2;
	}

	public static void setSAClientNeedsCategoryNameLan2(String saClientNeedsCategoryNameLan2) {
		SA_CLIENT_NEEDS_CATEGORY_NAME_LAN2 = saClientNeedsCategoryNameLan2;
	}

	public static int getSAClientNeedsCategoryProjectId() {
		return SA_CLIENT_NEEDS_CATEGORY_PROJECT_ID;
	}

	public static void setSAClientNeedsCategoryProjectId(int saClientNeedsCategoryProjectId) {
		SA_CLIENT_NEEDS_CATEGORY_PROJECT_ID = saClientNeedsCategoryProjectId;
	}

	public static String getSAClientNeedsCategoryProductNameLan1() {
		return SA_CLIENT_NEEDS_CATEGORY_PRODUCT_NAME_LAN1;
	}

	public static void setSAClientNeedsCategoryProductNameLan1(String saClientNeedsCategoryProductNameLan1) {
		SA_CLIENT_NEEDS_CATEGORY_PRODUCT_NAME_LAN1 = saClientNeedsCategoryProductNameLan1;
	}

	public static String getSAClientNeedsCategoryProductNameLan2() {
		return SA_CLIENT_NEEDS_CATEGORY_PRODUCT_NAME_LAN2;
	}

	public static void setSAClientNeedsCategoryProductNameLan2(String saClientNeedsCategoryProductNameLan2) {
		SA_CLIENT_NEEDS_CATEGORY_PRODUCT_NAME_LAN2 = saClientNeedsCategoryProductNameLan2;
	}

	public static String getSAClientNeedsCategoryEligible() {
		return SA_CLIENT_NEEDS_CATEGORY_ELIGIBLE;
	}

	public static void setSAClientNeedsCategoryEligible(String saClientNeedsCategoryEligible) {
		SA_CLIENT_NEEDS_CATEGORY_ELIGIBLE = saClientNeedsCategoryEligible;
	}

	public static String getSAClientNeedsCategoryRunningProjects() {
		return SA_CLIENT_NEEDS_CATEGORY_RUNNING_PROJECTS;
	}

	public static void setSAClientNeedsCategoryRunningProjects(String saClientNeedsCategoryRunningProjects) {
		SA_CLIENT_NEEDS_CATEGORY_RUNNING_PROJECTS = saClientNeedsCategoryRunningProjects;
	}

	public static int getSAClientNeedsCategoryTotalCount() {
		return SA_CLIENT_NEEDS_CATEGORY_TOTAL_COUNT;
	}

	public static void setSAClientNeedsCategoryTotalCount(int saClientNeedsCategoryTotalCount) {
		SA_CLIENT_NEEDS_CATEGORY_TOTAL_COUNT = saClientNeedsCategoryTotalCount;
	}

	public static int getSAClientNeedsSubcategoryId() {
		return SA_CLIENT_NEEDS_SUBCATEGORY_ID;
	}

	public static void setSAClientNeedsSubcategoryId(int saClientNeedsSubcategoryId) {
		SA_CLIENT_NEEDS_SUBCATEGORY_ID = saClientNeedsSubcategoryId;
	}

	public static String getSAClientNeedsSubcategoryNameLan1() {
		return SA_CLIENT_NEEDS_SUBCATEGORY_NAME_LAN1;
	}

	public static void setSAClientNeedsSubcategoryNameLan1(String saClientNeedsSubcategoryNameLan1) {
		SA_CLIENT_NEEDS_SUBCATEGORY_NAME_LAN1 = saClientNeedsSubcategoryNameLan1;
	}

	public static String getSAClientNeedsSubcategoryNameLan2() {
		return SA_CLIENT_NEEDS_SUBCATEGORY_NAME_LAN2;
	}

	public static void setSAClientNeedsSubcategoryNameLan2(String saClientNeedsSubcategoryNameLan2) {
		SA_CLIENT_NEEDS_SUBCATEGORY_NAME_LAN2 = saClientNeedsSubcategoryNameLan2;
	}

	public static int getSAClientNeedsSubcategoryProductCount() {
		return SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_COUNT;
	}

	public static void setSAClientNeedsSubcategoryProductCount(int saClientNeedsSubcategoryProductCount) {
		SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_COUNT = saClientNeedsSubcategoryProductCount;
	}

	public static int getSAClientNeedsSubcategoryProductId() {
		return SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_ID;
	}

	public static void setSAClientNeedsSubcategoryProductId(int saClientNeedsSubcategoryProductId) {
		SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_ID = saClientNeedsSubcategoryProductId;
	}

	public static String getSAClientNeedsSubcategoryProductNameLan1() {
		return SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_NAME_LAN1;
	}

	public static void setSAClientNeedsSubcategoryProductNameLan1(String saClientNeedsSubcategoryProductNameLan1) {
		SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_NAME_LAN1 = saClientNeedsSubcategoryProductNameLan1;
	}

	public static String getSAClientNeedsSubcategoryProductNameLan2() {
		return SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_NAME_LAN2;
	}

	public static void setSAClientNeedsSubcategoryProductNameLan2(String saClientNeedsSubcategoryProductNameLan2) {
		SA_CLIENT_NEEDS_SUBCATEGORY_PRODUCT_NAME_LAN2 = saClientNeedsSubcategoryProductNameLan2;
	}

	public static int getSAClientNeedsSubcategoryCount() {
		return SA_CLIENT_NEEDS_SUBCATEGORY_COUNT;
	}

	public static void setSAClientNeedsSubcategoryCount(int saClientNeedsSubcategoryCount) {
		SA_CLIENT_NEEDS_SUBCATEGORY_COUNT = saClientNeedsSubcategoryCount;
	}

	public static int getSAGetBasketId() {
		return SA_GET_BASKET_ID;
	}

	public static void setSAGetBasketId(int saGetBasketId) {
		SA_GET_BASKET_ID = saGetBasketId;
	}

	public static String getSAGetBasketComment() {
		return SA_GET_BASKET_COMMENT;
	}

	public static void setSAGetBasketComment(String saGetBasketComment) {
		SA_GET_BASKET_COMMENT = saGetBasketComment;
	}

	public static int getSAGetBasketOriginId() {
		return SA_GET_BASKET_ORIGIN_ID;
	}

	public static void setSAGetBasketOriginId(int saGetBasketOriginId) {
		SA_GET_BASKET_ORIGIN_ID = saGetBasketOriginId;
	}

	public static String getSAGetBasketBasketDate() {
		return SA_GET_BASKET_BASKET_DATE;
	}

	public static void setSAGetBasketBasketDate(String saGetBasketBasketDate) {
		SA_GET_BASKET_BASKET_DATE = saGetBasketBasketDate;
	}

	public static int getSAGetBasketAgreedListCount() {
		return SA_GET_BASKET_AGREED_LIST_COUNT;
	}

	public static void setSAGetBasketAgreedListCount(int saGetBasketAgreedListCount) {
		SA_GET_BASKET_AGREED_LIST_COUNT = saGetBasketAgreedListCount;
	}

	public static int getSAGetBasketAgreedListProductId() {
		return SA_GET_BASKET_AGREED_LIST_PRODUCT_ID;
	}

	public static void setSAGetBasketAgreedListProductId(int saGetBasketAgreedListProductId) {
		SA_GET_BASKET_AGREED_LIST_PRODUCT_ID = saGetBasketAgreedListProductId;
	}

	public static String getSAGetBasketAgreedListProductNameL1() {
		return SA_GET_BASKET_AGREED_LIST_PRODUCT_NAME_L1;
	}

	public static void setSAGetBasketAgreedListProductNameL1(String saGetBasketAgreedListProductNameL1) {
		SA_GET_BASKET_AGREED_LIST_PRODUCT_NAME_L1 = saGetBasketAgreedListProductNameL1;
	}

	public static String getSAGetBasketAgreedListProductNameL2() {
		return SA_GET_BASKET_AGREED_LIST_PRODUCT_NAME_L2;
	}

	public static void setSAGetBasketAgreedListProductNameL2(String saGetBasketAgreedListProductNameL2) {
		SA_GET_BASKET_AGREED_LIST_PRODUCT_NAME_L2 = saGetBasketAgreedListProductNameL2;
	}

	public static int getSAGetBasketNumberOfPieces() {
		return SA_GET_BASKET_NUMBER_OF_PIECES;
	}

	public static void setSAGetBasketNumberOfPieces(int saGetBasketNumberOfPieces) {
		SA_GET_BASKET_NUMBER_OF_PIECES = saGetBasketNumberOfPieces;
	}

	public static int getSAGetBasketPostponedListCount() {
		return SA_GET_BASKET_POSTPONED_LIST_COUNT;
	}

	public static void setSAGetBasketPostponedListCount(int saGetBasketPostponedListCount) {
		SA_GET_BASKET_POSTPONED_LIST_COUNT = saGetBasketPostponedListCount;
	}

	public static int getSAGetBasketPostponedProductId() {
		return SA_GET_BASKET_POSTPONED_PRODUCT_ID;
	}

	public static void setSAGetBasketPostponedProductId(int saGetBasketPostponedProductId) {
		SA_GET_BASKET_POSTPONED_PRODUCT_ID = saGetBasketPostponedProductId;
	}

	public static String getSAGetBasketPostponedProductNameL1() {
		return SA_GET_BASKET_POSTPONED_PRODUCT_NAME_L1;
	}

	public static void setSAGetBasketPostponedProductNameL1(String saGetBasketPostponedProductNameL1) {
		SA_GET_BASKET_POSTPONED_PRODUCT_NAME_L1 = saGetBasketPostponedProductNameL1;
	}

	public static String getSAGetBasketPostponedProductNameL2() {
		return SA_GET_BASKET_POSTPONED_PRODUCT_NAME_L2;
	}

	public static void setSAGetBasketPostponedProductNameL2(String saGetBasketPostponedProductNameL2) {
		SA_GET_BASKET_POSTPONED_PRODUCT_NAME_L2 = saGetBasketPostponedProductNameL2;
	}

	public static String getSAGetBasketPostponedTargetDate() {
		return SA_GET_BASKET_POSTPONED_TARGET_DATE;
	}

	public static void setSAGetBasketPostponedTargetDate(String saGetBasketPostponedTargetDate) {
		SA_GET_BASKET_POSTPONED_TARGET_DATE = saGetBasketPostponedTargetDate;
	}

	public static int getSAGetBasketNotInterestedListCount() {
		return SA_GET_BASKET_NOT_INTERESTED_LIST_COUNT;
	}

	public static void setSAGetBasketNotInterestedListCount(int saGetBasketNotInterestedListCount) {
		SA_GET_BASKET_NOT_INTERESTED_LIST_COUNT = saGetBasketNotInterestedListCount;
	}

	public static int getSAGetBasketNotInterestedProductId() {
		return SA_GET_BASKET_NOT_INTERESTED_PRODUCT_ID;
	}

	public static void setSAGetBasketNotInterestedProductId(int saGetBasketNotInterestedProductId) {
		SA_GET_BASKET_NOT_INTERESTED_PRODUCT_ID = saGetBasketNotInterestedProductId;
	}

	public static String getSAGetBasketNotInterestedProductNameL1() {
		return SA_GET_BASKET_NOT_INTERESTED_PRODUCT_NAME_L1;
	}

	public static void setSAGetBasketNotInterestedProductNameL1(String saGetBasketNotInterestedProductNameL1) {
		SA_GET_BASKET_NOT_INTERESTED_PRODUCT_NAME_L1 = saGetBasketNotInterestedProductNameL1;
	}

	public static String getSAGetBasketNotInterestedProductNameL2() {
		return SA_GET_BASKET_NOT_INTERESTED_PRODUCT_NAME_L2;
	}

	public static void setSAGetBasketNotInterestedProductNameL2(String saGetBasketNotInterestedProductNameL2) {
		SA_GET_BASKET_NOT_INTERESTED_PRODUCT_NAME_L2 = saGetBasketNotInterestedProductNameL2;
	}

	public static String getSAGetBasketCreatedDate() {
		return SA_GET_BASKET_CREATED_DATE;
	}

	public static void setSAGetBasketCreatedDate(String saGetBasketCreatedDate) {
		SA_GET_BASKET_CREATED_DATE = saGetBasketCreatedDate;
	}

	public static String getFirstnameData() {
		return FIRSTNAME_DATA;
	}

	public static void setFirstnameData(String firstnameData) {
		FIRSTNAME_DATA = firstnameData;
	}

	public static String getLastnameData() {
		return LASTNAME_DATA;
	}

	public static void setLastnameData(String lastnameData) {
		LASTNAME_DATA = lastnameData;
	}

	public static String getEmailData() {
		return EMAIL_DATA;
	}

	public static void setEmailData(String emailData) {
		EMAIL_DATA = emailData;
	}

	public static int getProspectTypeIdData() {
		return PROSPECT_TYPE_ID_DATA;
	}

	public static void setProspectTypeIdData(int prospectTypeIdData) {
		PROSPECT_TYPE_ID_DATA = prospectTypeIdData;
	}

	public static String getCityData() {
		return CITY_DATA;
	}

	public static void setCityData(String cityData) {
		CITY_DATA = cityData;
	}

	public static int getEntityIdData() {
		return ENTITY_ID_DATA;
	}

	public static void setEntityIdData(int entityIdData) {
		ENTITY_ID_DATA = entityIdData;
	}

	public static int getSegmentIdData() {
		return SEGMENT_ID_DATA;
	}
	public static int getStatusId() {
		return STATUS_ID;
	}

	public static void setSegmentIdData(int segmentIdData) {
		SEGMENT_ID_DATA = segmentIdData;
	}

	public static String getChangeDateData() {
		return CHANGE_DATE_DATA;
	}

	public static void setChangeDateData(String changeDateData) {
		CHANGE_DATE_DATA = changeDateData;
	}

	public static int getOpportunitiesElement() {
		return OPPORTUNITIES_ELEMENT;
	}

	public static void setOpportunitiesElement(int opportunitiesElement) {
		OPPORTUNITIES_ELEMENT = opportunitiesElement;
	}

	public static int getPriorityIdOpportunity() {
		return PRIORITY_ID_OPPORTUNITY;
	}

	public static void setPriorityIdOpportunity(int priorityIdOpportunity) {
		PRIORITY_ID_OPPORTUNITY = priorityIdOpportunity;
	}

	public static String getPriorityNameOpportunity() {
		return PRIORITY_NAME_OPPORTUNITY;
	}

	public static void setPriorityNameOpportunity(String priorityNameOpportunity) {
		PRIORITY_NAME_OPPORTUNITY = priorityNameOpportunity;
	}

	public static int getSubcategoryIdOpportunity() {
		return SUBCATEGORY_ID_OPPORTUNITY;
	}

	public static void setSubcategoryIdOpportunity(int subcategoryIdOpportunity) {
		SUBCATEGORY_ID_OPPORTUNITY = subcategoryIdOpportunity;
	}

	public static String getSubcategoryNameOpportunity() {
		return SUBCATEGORY_NAME_OPPORTUNITY;
	}

	public static void setSubcategoryNameOpportunity(String subcategoryNameOpportunity) {
		SUBCATEGORY_NAME_OPPORTUNITY = subcategoryNameOpportunity;
	}

	public static int getCategoryIdOpportunity() {
		return CATEGORY_ID_OPPORTUNITY;
	}

	public static void setCategoryIdOpportunity(int categoryIdOpportunity) {
		CATEGORY_ID_OPPORTUNITY = categoryIdOpportunity;
	}

	public static String getCategoryNameOpportunity() {
		return CATEGORY_NAME_OPPORTUNITY;
	}

	public static void setCategoryNameOpportunity(String categoryNameOpportunity) {
		CATEGORY_NAME_OPPORTUNITY = categoryNameOpportunity;
	}

	public static int getCategoryCountOpportunity() {
		return CATEGORY_COUNT_OPPORTUNITY;
	}

	public static void setCategoryCountOpportunity(int categoryCountOpportunity) {
		CATEGORY_COUNT_OPPORTUNITY = categoryCountOpportunity;
	}

	public static int getReasonIdOpportunity() {
		return REASON_ID_OPPORTUNITY;
	}

	public static void setReasonIdOpportunity(int reasonIdOpportunity) {
		REASON_ID_OPPORTUNITY = reasonIdOpportunity;
	}

	public static String getReasonNameOpportunity() {
		return REASON_NAME_OPPORTUNITY;
	}

	public static void setReasonNameOpportunity(String reasonNameOpportunity) {
		REASON_NAME_OPPORTUNITY = reasonNameOpportunity;
	}

	public static int getAdvisorIdOpportunityReq() {
		return ADVISOR_ID_OPPORTUNITY_REQ;
	}

	public static void setAdvisorIdOpportunityReq(int advisorIdOpportunityReq) {
		ADVISOR_ID_OPPORTUNITY_REQ = advisorIdOpportunityReq;
	}

	public static int getBranchIdOpportunityReq() {
		return BRANCH_ID_OPPORTUNITY_REQ;
	}

	public static void setBranchIdOpportunityReq(int branchIdOpportunityReq) {
		BRANCH_ID_OPPORTUNITY_REQ = branchIdOpportunityReq;
	}

	public static int getPageIndexOpportunityReq() {
		return PAGE_INDEX_OPPORTUNITY_REQ;
	}

	public static void setPageIndexOpportunityReq(int pageIndexOpportunityReq) {
		PAGE_INDEX_OPPORTUNITY_REQ = pageIndexOpportunityReq;
	}

	public static int getPageSizeOpportunityReq() {
		return PAGE_SIZE_OPPOPRTUNITY_REQ;
	}

	public static void setPageSizeOpportunityReq(int pageSizeOpportunityReq) {
		PAGE_SIZE_OPPOPRTUNITY_REQ = pageSizeOpportunityReq;
	}

	public static int getRequestCountOpportunityReq() {
		return REQUEST_COUNT_OPPORTUNITY_REQ;
	}

	public static void setRequestCountOpportunityReq(int requestCountOpportunityReq) {
		REQUEST_COUNT_OPPORTUNITY_REQ = requestCountOpportunityReq;
	}

	public static int getCategoryIdOpportunityReq() {
		return CATEGORY_ID_OPPORTUNITY_REQ;
	}

	public static void setCategoryIdOpportunityReq(int categoryIdOpportunityReq) {
		CATEGORY_ID_OPPORTUNITY_REQ = categoryIdOpportunityReq;
	}

	public static int getPriorityIdOpportunityReq() {
		return PRIORITY_ID_OPPORTUNITY_REQ;
	}

	public static void setPriorityIdOpportunityReq(int priorityIdOpportunityReq) {
		PRIORITY_ID_OPPORTUNITY_REQ = priorityIdOpportunityReq;
	}

	public static int getRowIdOpportunityResp() {
		return ROW_ID_OPPORTUNITY_RESP;
	}

	public static void setRowIdOpportunityResp(int rowIdOpportunityResp) {
		ROW_ID_OPPORTUNITY_RESP = rowIdOpportunityResp;
	}

	public static int getOpportunityIdResp() {
		return OPPORTUNITY_ID_RESP;
	}

	public static void setOpportunityIdResp(int opportunityIdResp) {
		OPPORTUNITY_ID_RESP = opportunityIdResp;
	}

	public static int getClientIdOpportunityResp() {
		return CLIENT_ID_OPPORTUNITY_RESP;
	}

	public static void setClientIdOpportunityResp(int clientIdOpportunityResp) {
		CLIENT_ID_OPPORTUNITY_RESP = clientIdOpportunityResp;
	}

	public static String getClientCodeOpportunityResp() {
		return CLIENT_CODE_OPPORTUNITY_RESP;
	}

	public static void setClientCodeOpportunityResp(String cclientCodeOpportunityResp) {
		CLIENT_CODE_OPPORTUNITY_RESP = cclientCodeOpportunityResp;
	}

	public static String getClientTypeOpportunityResp() {
		return CLIENT_TYPE_OPPORTUNITY_RESP;
	}

	public static void setClientTypeOpportunityResp(String clientTypeOpportunityResp) {
		CLIENT_TYPE_OPPORTUNITY_RESP = clientTypeOpportunityResp;
	}

	public static String getCivilityOpportunityResp() {
		return CIVILITY_OPPORTUNITY_RESP;
	}

	public static void setCivilityOpportunityResp(String civilityOpportunityResp) {
		CIVILITY_OPPORTUNITY_RESP = civilityOpportunityResp;
	}

	public static String getFirstNameOpportunityResp() {
		return FIRST_NAME_OPPORTUNITY_RESP;
	}

	public static void setFirstNameOpportunityResp(String firstNameOpportunityResp) {
		FIRST_NAME_OPPORTUNITY_RESP = firstNameOpportunityResp;
	}

	public static String getLastNameOpportunityResp() {
		return LAST_NAME_OPPORTUNITY_RESP;
	}

	public static void setLastNameOpportunityResp(String lastNameOpportunityResp) {
		LAST_NAME_OPPORTUNITY_RESP = lastNameOpportunityResp;
	}

	public static int getOpportunityTypeIdResp() {
		return OPPORTUNITY_TYPE_ID_RESP;
	}

	public static void setOpportunityTypeIdResp(int opportunityTypeIdResp) {
		OPPORTUNITY_TYPE_ID_RESP = opportunityTypeIdResp;
	}

	public static int getOpportunitySubcatIdResp() {
		return OPPORTUNITY_SUBCAT_ID_RESP;
	}

	public static void setOpportunitySubcatIdResp(int opportunitySubcatIdResp) {
		OPPORTUNITY_SUBCAT_ID_RESP = opportunitySubcatIdResp;
	}

	public static String getOpportunityStartDateResp() {
		return OPPORTUNITY_START_DATE_RESP;
	}

	public static void setOpportunityStartDateResp(String opportunityStartDateResp) {
		OPPORTUNITY_START_DATE_RESP = opportunityStartDateResp;
	}

	public static String getOpportunityExpirationDateResp() {
		return OPPORTUNITY_EXPIRATION_DATE_RESP;
	}

	public static void setOpportunityExpirationDateResp(String opportunityExpirationDateResp) {
		OPPORTUNITY_EXPIRATION_DATE_RESP = opportunityExpirationDateResp;
	}

	public static String getTreatmentPeriodOpportunityResp() {
		return TREATMENT_PERIOD_OPPORTUNITY_RESP;
	}

	public static void setTreatmentPeriodOpportunityResp(String treatmentPeriodOpportunityResp) {
		TREATMENT_PERIOD_OPPORTUNITY_RESP = treatmentPeriodOpportunityResp;
	}

	public static int getOpportunityPriorityIdResp() {
		return OPPORTUNITY_PRIORITY_ID_RESP;
	}

	public static void setOpportunityPriorityIdResp(int opportunityPriorityIdResp) {
		OPPORTUNITY_PRIORITY_ID_RESP = opportunityPriorityIdResp;
	}

	public static int getOpportunityStatusIdResp() {
		return OPPORTUNITY_STATUS_ID_RESP;
	}

	public static void setOpportunityStatusIdResp(int opportunityStatusIdResp) {
		OPPORTUNITY_STATUS_ID_RESP = opportunityStatusIdResp;
	}

	public static String getOpportunityStatusNameResp() {
		return OPPORTUNITY_STATUS_NAME_RESP;
	}

	public static void setOpportunityStatusNameResp(String opportunityStatusNameResp) {
		OPPORTUNITY_STATUS_NAME_RESP = opportunityStatusNameResp;
	}

	public static int getOpportunityConfigId() {
		return OPPORTUNITY_CONFIG_ID;
	}

	public static void setOpportunityConfigId(int opportunityConfigId) {
		OPPORTUNITY_CONFIG_ID = opportunityConfigId;
	}

	public static String getOpportunityNameResp() {
		return OPPORTUNITY_NAME_RESP;
	}

	public static void setOpportunityNameResp(String opportunityNameResp) {
		OPPORTUNITY_NAME_RESP = opportunityNameResp;
	}

	public static int getOpportunityIdIdResp() {
		return OPPORTUNITY_ID_ID_RESP;
	}

	public static void setOpportunityIdIdResp(int opportunityIdIdResp) {
		OPPORTUNITY_ID_ID_RESP = opportunityIdIdResp;
	}

	public static int getOpportunityTypeIdIdResp() {
		return OPPORTUNITY_TYPE_ID_ID_RESP;
	}

	public static void setOpportunityTypeIdIdResp(int opportunityTypeIdIdResp) {
		OPPORTUNITY_TYPE_ID_ID_RESP = opportunityTypeIdIdResp;
	}

	public static String getOpportunityStartDateActiveOpportunityResp() {
		return OPPORTUNITY_START_DATE_ACTIVE_OPPORTUNITY_RESP;
	}

	public static void setOpportunityStartDateActiveOpportunityResp(String oppStartDateActiveOppResp) {
		OPPORTUNITY_START_DATE_ACTIVE_OPPORTUNITY_RESP = oppStartDateActiveOppResp;
	}

	public static String getOpportunityExpirationDateActiveOpportunityResp() {
		return OPPORTUNITY_EXPIRATION_DATE_ACTIVE_OPPORTUNITY_RESP;
	}

	public static void setOpportunityExpirationDateActiveOpportunityResp(
			String oppExpDateActiveOppResp) {
		OPPORTUNITY_EXPIRATION_DATE_ACTIVE_OPPORTUNITY_RESP = oppExpDateActiveOppResp;
	}

	public static String getOpportunityTreatmentPeriodIdResp() {
		return OPPORTUNITY_TREATMENT_PERIOD_ID_RESP;
	}

	public static void setOpportunityTreatmentPeriodIdResp(String opportunityTreatmentPeriodIdResp) {
		OPPORTUNITY_TREATMENT_PERIOD_ID_RESP = opportunityTreatmentPeriodIdResp;
	}

	public static int getOpportunityOpportunityStateIdResp() {
		return OPPORTUNITY_OPPORTUNITY_STATE_ID_RESP;
	}

	public static void setOpportunityOpportunityStateIdResp(int opportunityOpportunityStateIdResp) {
		OPPORTUNITY_OPPORTUNITY_STATE_ID_RESP = opportunityOpportunityStateIdResp;
	}

	public static int getReassignBranchId() {
		return REASSIGN_BRANCH_ID;
	}

	public static void setReassignBranchId(int reassignBranchId) {
		REASSIGN_BRANCH_ID = reassignBranchId;
	}

	public static int getReassignCollaboratorId() {
		return REASSIGN_COLLABORATOR_ID;
	}

	public static void setReassignCollaboratorId(int reassignCollaboratorId) {
		REASSIGN_COLLABORATOR_ID = reassignCollaboratorId;
	}

	public static int getReassignCallerBranchId() {
		return REASSIGN_CALLER_BRANCH_ID;
	}

	public static void setReassignCallerBranchId(int reassignCallerBranchId) {
		REASSIGN_CALLER_BRANCH_ID = reassignCallerBranchId;
	}

	public static int getReassignCallerCollaboratorId() {
		return REASSIGN_CALLER_COLLABORATOR_ID;
	}

	public static void setReassignCallerCollaboratorId(int reassignCallerCollaboratorId) {
		REASSIGN_CALLER_COLLABORATOR_ID = reassignCallerCollaboratorId;
	}

	public static int getReassignOpportunityId() {
		return REASSIGN_OPPORTUNITY_ID;
	}

	public static void setReassignOpportunityId(int reassignOpportunityId) {
		REASSIGN_OPPORTUNITY_ID = reassignOpportunityId;
	}

	public static int getPortfolioRowId() {
		return PORTFOLIO_ROW_ID;
	}

	public static void setPortfolioRowId(int portfolioRowId) {
		PORTFOLIO_ROW_ID = portfolioRowId;
	}

	public static int getPortfolioPortfolioId() {
		return PORTFOLIO_PORTFOLIO_ID;
	}

	public static void setPortfolioPortfolioId(int portfolioPortfolioId) {
		PORTFOLIO_PORTFOLIO_ID = portfolioPortfolioId;
	}

	public static String getPortfolioName() {
		return PORTFOLIO_NAME;
	}

	public static void setPortfolioName(String portfolioName) {
		PORTFOLIO_NAME = portfolioName;
	}

	public static String getPortfolioCode() {
		return PORTFOLIO_CODE;
	}

	public static void setPortfolioCode(String portfolioCode) {
		PORTFOLIO_CODE = portfolioCode;
	}

	public static int getPortfolioTypeId() {
		return PORTFOLIO_TYPE_ID;
	}

	public static void setPortfolioTypeId(int portfolioTypeId) {
		PORTFOLIO_TYPE_ID = portfolioTypeId;
	}

	public static String getPortfolioTypeName() {
		return PORTFOLIO_TYPE_NAME;
	}

	public static void setPortfolioTypeName(String portfolioTypeName) {
		PORTFOLIO_TYPE_NAME = portfolioTypeName;
	}

	public static String getPortfolioTypeCode() {
		return PORTFOLIO_TYPE_CODE;
	}

	public static void setPortfolioTypeCode(String portfolioTypeCode) {
		PORTFOLIO_TYPE_CODE = portfolioTypeCode;
	}

	public static int getPortfolioSize() {
		return PORTFOLIO_SIZE;
	}

	public static void setPortfolioSize(int portfolioSize) {
		PORTFOLIO_SIZE = portfolioSize;
	}

	public static int getPortfolioFteSize() {
		return PORTFOLIO_FTE_SIZE;
	}

	public static void setPortfolioFteSize(int portfolioFteSize) {
		PORTFOLIO_FTE_SIZE = portfolioFteSize;
	}

	public static int getPortfolioEntityId() {
		return PORTFOLIO_ENTITY_ID;
	}

	public static void setPortfolioEntityId(int portfolioEntityId) {
		PORTFOLIO_ENTITY_ID = portfolioEntityId;
	}

	public static String getPortfolioEntityName() {
		return PORTFOLIO_ENTITY_NAME;
	}

	public static void setPortfolioEntityName(String portfolioEntityName) {
		PORTFOLIO_ENTITY_NAME = portfolioEntityName;
	}

	public static int getPortfolioOwnerId() {
		return PORTFOLIO_OWNER_ID;
	}

	public static void setPortfolioOwnerId(int portfolioOwnerId) {
		PORTFOLIO_OWNER_ID = portfolioOwnerId;
	}

	public static String getPortfolioOwnerFirstname() {
		return PORTFOLIO_OWNER_FIRSTNAME;
	}

	public static void setPortfolioOwnerFirstname(String portfolioOwnerFirstname) {
		PORTFOLIO_OWNER_FIRSTNAME = portfolioOwnerFirstname;
	}

	public static String getPortfolioOwnerLastname() {
		return PORTFOLIO_OWNER_LASTNAME;
	}

	public static void setPortfolioOwnerLastname(String portfolioOwnerLastname) {
		PORTFOLIO_OWNER_LASTNAME = portfolioOwnerLastname;
	}

	public static int getPortfolioTotalCount() {
		return PORTFOLIO_TOTAL_COUNT;
	}

	public static void setPortfolioTotalCount(int portfolioTotalCount) {
		PORTFOLIO_TOTAL_COUNT = portfolioTotalCount;
	}

	public static int getPortfolioDetailsRowId() {
		return PORTFOLIO_DETAILS_ROW_ID;
	}

	public static void setPortfolioDetailsRowId(int portfolioDetailsRowId) {
		PORTFOLIO_DETAILS_ROW_ID = portfolioDetailsRowId;
	}

	public static int getPortfolioDetailsPortfolioId() {
		return PORTFOLIO_DETAILS_PORTFOLIO_ID;
	}

	public static void setPortfolioDetailsPortfolioId(int portfolioDetailsPortfolioId) {
		PORTFOLIO_DETAILS_PORTFOLIO_ID = portfolioDetailsPortfolioId;
	}

	public static int getPortfolioDetailsClientId() {
		return PORTFOLIO_DETAILS_CLIENT_ID;
	}

	public static void setPortfolioDetailsClientId(int portfolioDetailsClientId) {
		PORTFOLIO_DETAILS_CLIENT_ID = portfolioDetailsClientId;
	}

	public static int getPortfolioDetailsClientEntityId() {
		return PORTFOLIO_DETAILS_CLIENT_ENTITY_ID;
	}

	public static void setPortfolioDetailsClientEntityId(int portfolioDetailsClientEntityId) {
		PORTFOLIO_DETAILS_CLIENT_ENTITY_ID = portfolioDetailsClientEntityId;
	}

	public static int getPortfolioDetailsClientAdvisorId() {
		return PORTFOLIO_DETAILS_CLIENT_ADVISOR_ID;
	}

	public static void setPortfolioDetailsClientAdvisorId(int portfolioDetailsClientAdvisorId) {
		PORTFOLIO_DETAILS_CLIENT_ADVISOR_ID = portfolioDetailsClientAdvisorId;
	}

	public static String getPortfolioDetailsClientType() {
		return PORTFOLIO_DETAILS_CLIENT_TYPE;
	}

	public static void setPortfolioDetailsClientType(String portfolioDetailsClientType) {
		PORTFOLIO_DETAILS_CLIENT_TYPE = portfolioDetailsClientType;
	}

	public static String getPortfolioDetailsClientGroupType() {
		return PORTFOLIO_DETAILS_CLIENT_GROUP_TYPE;
	}

	public static void setPortfolioDetailsClientGroupType(String portfolioDetailsClientGroupType) {
		PORTFOLIO_DETAILS_CLIENT_GROUP_TYPE = portfolioDetailsClientGroupType;
	}

	public static String getPortfolioDetailsClientName() {
		return PORTFOLIO_DETAILS_CLIENT_NAME;
	}

	public static void setPortfolioDetailsClientName(String portfolioDetailsClientName) {
		PORTFOLIO_DETAILS_CLIENT_NAME = portfolioDetailsClientName;
	}

	public static String getPortfolioDetailsClientCode() {
		return PORTFOLIO_DETAILS_CLIENT_CODE;
	}

	public static void setPortfolioDetailsClientCode(String portfolioDetailsClientCode) {
		PORTFOLIO_DETAILS_CLIENT_CODE = portfolioDetailsClientCode;
	}

	public static String getPortfolioDetailsClientSegment() {
		return PORTFOLIO_DETAILS_CLIENT_SEGMENT;
	}

	public static void setPortfolioDetailsClientSegment(String portfolioDetailsClientSegment) {
		PORTFOLIO_DETAILS_CLIENT_SEGMENT = portfolioDetailsClientSegment;
	}

	public static int getPortfolioDetailsTotalCount() {
		return PORTFOLIO_DETAILS_TOTAL_COUNT;
	}

	public static void setPortfolioDetailsTotalCount(int portfolioDetailsTotalCount) {
		PORTFOLIO_DETAILS_TOTAL_COUNT = portfolioDetailsTotalCount;
	}

	public static String getFromTime() {
		return FROM_TIME;
	}

	public static void setFromTime(String fromTime) {
		FROM_TIME = fromTime;
	}

	public static String getToTime() {
		return TO_TIME;
	}

	public static void setToTime(String toTime) {
		TO_TIME = toTime;
	}

	public static int getAgendaBranchId() {
		return AGENDA_BRANCH_ID;
	}

	public static void setAgendaBranchId(int agendaBranchId) {
		AGENDA_BRANCH_ID = agendaBranchId;
	}

	public static String getLanguage() {
		return LANGUAGE;
	}

	public static void setLanguage(String language) {
		LANGUAGE = language;
	}

	public static int getAgendaAgendaId() {
		return AGENDA_AGENDA_ID;
	}

	public static void setAgendaAgendaId(int agendaAgendaId) {
		AGENDA_AGENDA_ID = agendaAgendaId;
	}

	public static int getAgendaUserId() {
		return AGENDA_USER_ID;
	}

	public static void setAgendaUserId(int agendaUserId) {
		AGENDA_USER_ID = agendaUserId;
	}

	public static int getAgendaItem() {
		return AGENDA_ITEM;
	}

	public static void setAgendaItem(int agendaItem) {
		AGENDA_ITEM = agendaItem;
	}

	public static int getAgendaItemDetailed() {
		return AGENDA_ITEM_DETAILED;
	}

	public static void setAgendaItemDetailed(int agendaItemDetailed) {
		AGENDA_ITEM_DETAILED = agendaItemDetailed;
	}

	public static int getAgendaAdvisorId() {
		return AGENDA_ADVISOR_ID;
	}

	public static void setAgendaAdvisorId(int agendaAdvisorId) {
		AGENDA_ADVISOR_ID = agendaAdvisorId;
	}

	public static int getAgendaAdvisorEntityId() {
		return AGENDA_ADVISOR_ENTITY_ID;
	}

	public static void setAgendaAdvisorEntityId(int agendaAdvisorEntityId) {
		AGENDA_ADVISOR_ENTITY_ID = agendaAdvisorEntityId;
	}

	public static int getAgendaItemTypeId() {
		return AGENDA_ITEM_TYPE_ID;
	}

	public static void setAgendaItemTypeId(int agendaItemTypeId) {
		AGENDA_ITEM_TYPE_ID = agendaItemTypeId;
	}

	public static int getAgendaStatusId() {
		return AGENDA_STATUS_ID;
	}

	public static void setAgendaStatusId(int agendaStatusId) {
		AGENDA_STATUS_ID = agendaStatusId;
	}

	public static int getAgendaContactId() {
		return AGENDA_CONTACT_ID;
	}

	public static void setAgendaContactId(int agendaContactId) {
		AGENDA_CONTACT_ID = agendaContactId;
	}

	public static String getAgendaClientTypeId() {
		return AGENDA_CLIENT_TYPE_ID;
	}

	public static void setAgendaClientTypeId(String agendaClientTypeId) {
		AGENDA_CLIENT_TYPE_ID = agendaClientTypeId;
	}

	public static int getAgendaClientid() {
		return AGENDA_CLIENT_ID;
	}

	public static void setAgendaClientid(int agendaClientid) {
		AGENDA_CLIENT_ID = agendaClientid;
	}

	public static int getAgendaClientEntityId() {
		return AGENDA_CLIENT_ENTITY_ID;
	}

	public static void setAgendaClientEntityId(int agendaClientEntityId) {
		AGENDA_CLIENT_ENTITY_ID = agendaClientEntityId;
	}

	public static int getAgendaClientPortfolioId() {
		return AGENDA_CLIENT_PORTFOLIO_ID;
	}

	public static void setAgendaClientPortfolioId(int agendaClientPortfolioId) {
		AGENDA_CLIENT_PORTFOLIO_ID = agendaClientPortfolioId;
	}

	public static int getAgendaMessageTypeId() {
		return AGENDA_MESSAGE_TYPE_ID;
	}

	public static void setAgendaMessageTypeId(int agendaMessageTypeId) {
		AGENDA_MESSAGE_TYPE_ID = agendaMessageTypeId;
	}

	public static String getAgendaStartTime() {
		return AGENDA_START_TIME;
	}

	public static void setAgendaStartTime(String agendaStartTime) {
		AGENDA_START_TIME = agendaStartTime;
	}

	public static String getAgendaEndTime() {
		return AGENDA_END_TIME;
	}

	public static void setAgendaEndTime(String agendaEndTime) {
		AGENDA_END_TIME = agendaEndTime;
	}

	public static int getAgendaWeeklyFrequency() {
		return AGENDA_WEEKLY_FREQUENCY;
	}

	public static void setAgendaWeeklyFrequency(int agendaWeeklyFrequency) {
		AGENDA_WEEKLY_FREQUENCY = agendaWeeklyFrequency;
	}

	public static int getAgendaReminderTime() {
		return AGENDA_REMINDER_TIME;
	}

	public static void setAgendaReminderTime(int agendaReminderTime) {
		AGENDA_REMINDER_TIME = agendaReminderTime;
	}

	public static int getAgendaCloseReasonId() {
		return AGENDA_CLOSE_REASON_ID;
	}

	public static void setAgendaCloseReasonId(int agendaCloseReasonId) {
		AGENDA_CLOSE_REASON_ID = agendaCloseReasonId;
	}

	public static int getAgendaAvailable() {
		return AGENDA_AVAILABLE;
	}

	public static void setAgendaAvailable(int agendaAvailable) {
		AGENDA_AVAILABLE = agendaAvailable;
	}

	public static int getAgendaVisible() {
		return AGENDA_VISIBLE;
	}

	public static void setAgendaVisible(int agendaVisible) {
		AGENDA_VISIBLE = agendaVisible;
	}

	public static int getAgendaLocationId() {
		return AGENDA_LOCATION_ID;
	}

	public static void setAgendaLocationId(int agendaLocationId) {
		AGENDA_LOCATION_ID = agendaLocationId;
	}

	public static int getAgendaOriginId() {
		return AGENDA_ORIGIN_ID;
	}

	public static void setAgendaOriginId(int agendaOriginId) {
		AGENDA_ORIGIN_ID = agendaOriginId;
	}

	public static int getAgendaDurationId() {
		return AGENDA_DURATION_ID;
	}

	public static void setAgendaDurationId(int agendaDurationId) {
		AGENDA_DURATION_ID = agendaDurationId;
	}

	public static int getAgendaCancelReasonId() {
		return AGENDA_CANCEL_REASON_ID;
	}

	public static void setAgendaCancelReasonId(int agendaCancelReasonId) {
		AGENDA_CANCEL_REASON_ID = agendaCancelReasonId;
	}

	public static String getAgendaFirstName() {
		return AGENDA_FIRST_NAME;
	}

	public static void setAgendaFirstName(String agendaFirstName) {
		AGENDA_FIRST_NAME = agendaFirstName;
	}

	public static int getAgendaElementIdReq() {
		return AGENDA_ELEMENT_ID_REQ;
	}

	public static void setAgendaElementIdReq(int agendaElementIdReq) {
		AGENDA_ELEMENT_ID_REQ = agendaElementIdReq;
	}

	public static int getAgendaPositiveIdReq() {
		return AGENDA_POSITIVE_ID_REQ;
	}

	public static void setAgendaPositiveIdReq(int agendaPositiveIdReq) {
		AGENDA_POSITIVE_ID_REQ = agendaPositiveIdReq;
	}

	public static String getAgendaStartTimeReq() {
		return AGENDA_START_TIME_REQ;
	}

	public static void setAgendaStartTimeReq(String agendaStartTimeReq) {
		AGENDA_START_TIME_REQ = agendaStartTimeReq;
	}

	public static String getAgendaEndTimeReq() {
		return AGENDA_END_TIME_REQ;
	}

	public static void setAgendaEndTimeReq(String agendaEndTimeReq) {
		AGENDA_END_TIME_REQ = agendaEndTimeReq;
	}

	public static String getAgendaUpdatedStartTimeReq() {
		return AGENDA_UPDATED_START_TIME_REQ;
	}

	public static void setAgendaUpdatedStartTimeReq(String agendaUpdatedStartTimeReq) {
		AGENDA_UPDATED_START_TIME_REQ = agendaUpdatedStartTimeReq;
	}

	public static String getAgendaUpdatedEndTimeReq() {
		return AGENDA_UPDATED_END_TIME_REQ;
	}

	public static void setAgendaUpdatedEndTimeReq(String agendaUpdatedEndTimeReq) {
		AGENDA_UPDATED_END_TIME_REQ = agendaUpdatedEndTimeReq;
	}

	public static int getAgendaStatusIdReq() {
		return AGENDA_STATUS_ID_REQ;
	}

	public static void setAgendaStatusIdReq(int agendaStatusIdReq) {
		AGENDA_STATUS_ID_REQ = agendaStatusIdReq;
	}

	public static int getAgendaAvailableReq() {
		return AGENDA_AVAILABLE_REQ;
	}

	public static void setAgendaAvailableReq(int agendaAvailableReq) {
		AGENDA_AVAILABLE_REQ = agendaAvailableReq;
	}

	public static int getAgendaVisibleReq() {
		return AGENDA_VISIBLE_REQ;
	}

	public static void setAgendaVisibleReq(int agendaVisibleReq) {
		AGENDA_VISIBLE_REQ = agendaVisibleReq;
	}

	public static String getAgendaEmptyStringReq() {
		return AGENDA_EMPTY_STRING_REQ;
	}

	public static void setAgendaEmptyStringReq(String agendaEmptyStringReq) {
		AGENDA_EMPTY_STRING_REQ = agendaEmptyStringReq;
	}

	public static int getAgendaNegativeIdReq() {
		return AGENDA_NEGATIVE_ID_REQ;
	}
	public static Integer getAgendaLangId() {
		return AGENDA_LANG_ID;
	}
	public static void setAgendaNegativeIdReq(int agendaNegativeIdReq) {
		AGENDA_NEGATIVE_ID_REQ = agendaNegativeIdReq;
	}

	public static int getAgendaUpdatedAdvisorId() {
		return AGENDA_UPDATED_ADVISOR_ID;
	}

	public static void setAgendaUpdatedAdvisorId(int agendaUpdatedAdvisorId) {
		AGENDA_UPDATED_ADVISOR_ID = agendaUpdatedAdvisorId;
	}

	public static int getAgendaUpdatedAdvisorEntityId() {
		return AGENDA_UPDATED_ADVISOR_ENTITY_ID;
	}

	public static void setAgendaUpdatedAdvisorEntityId(int agendaUpdatedAdvisorEntityId) {
		AGENDA_UPDATED_ADVISOR_ENTITY_ID = agendaUpdatedAdvisorEntityId;
	}

	public static int getQCRClientId() {
		return QCR_CLIENT_ID;
	}

	public static void setQCRClientId(int qcrClientId) {
		QCR_CLIENT_ID = qcrClientId;
	}

	public static int getQCRClientEntityId() {
		return QCR_CLIENT_ENTITY_ID;
	}

	public static void setQCRClientEntityId(int qcrClientEntityId) {
		QCR_CLIENT_ENTITY_ID = qcrClientEntityId;
	}

	public static int getQCRClientPortfolioId() {
		return QCR_CLIENT_PORTFOLIO_ID;
	}

	public static void setQCRClientPortfolioId(int qcrClientPortfolioId) {
		QCR_CLIENT_PORTFOLIO_ID = qcrClientPortfolioId;
	}

	public static String getQCRClientType() {
		return QCR_CLIENT_TYPE;
	}

	public static void setQCRClientType(String qcrClientType) {
		QCR_CLIENT_TYPE = qcrClientType;
	}

	public static String getQCRReportDate() {
		return QCR_REPORT_DATE;
	}

	public static void setQCRReportDate(String qcrReportDate) {
		QCR_REPORT_DATE = qcrReportDate;
	}

	public static int getQCRRequestId() {
		return QCR_REQUEST_ID;
	}

	public static void setQCRRequestId(int qcrRequestId) {
		QCR_REQUEST_ID = qcrRequestId;
	}

	public static int getQCRChannelId() {
		return QCR_CHANNEL_ID;
	}

	public static void setQCRChannelId(int qcrChannelId) {
		QCR_CHANNEL_ID = qcrChannelId;
	}

	public static int getQCRReasonId() {
		return QCR_REASON_ID;
	}

	public static void setQCRReasonId(int qcrReasonId) {
		QCR_REASON_ID = qcrReasonId;
	}

	public static int getQCRResultId() {
		return QCR_RESULT_ID;
	}

	public static void setQCRResultId(int qcrResultId) {
		QCR_RESULT_ID = qcrResultId;
	}

	public static String getQCRComment() {
		return QCR_COMMENT;
	}

	public static void setQCRComment(String qcrComment) {
		QCR_COMMENT = qcrComment;
	}

	public static int getQCRDetailEntityId() {
		return QCR_DETAIL_ENTITY_ID;
	}

	public static void setQCRDetailEntityId(int qcrDetailEntityId) {
		QCR_DETAIL_ENTITY_ID = qcrDetailEntityId;
	}

	public static int getQCRDetailAdvisorId() {
		return QCR_DETAIL_ADVISOR_ID;
	}

	public static void setQCRDetailAdvisorId(int qcrDetailAdvisorId) {
		QCR_DETAIL_ADVISOR_ID = qcrDetailAdvisorId;
	}

	public static int getQCRDetailClientAdvisorId() {
		return QCR_DETAIL_CLIENT_ADVISOR_ID;
	}

	public static void setQCRDetailClientAdvisorId(int qcrDetailClientAdvisorId) {
		QCR_DETAIL_CLIENT_ADVISOR_ID = qcrDetailClientAdvisorId;
	}

	public static int getQCRDetailClientEntityId() {
		return QCR_DETAIL_CLIENT_ENTITY_ID;
	}

	public static void setQCRDetailClientEntityId(int qcrDetailClientEntityId) {
		QCR_DETAIL_CLIENT_ENTITY_ID = qcrDetailClientEntityId;
	}

	public static int getQCRDetailClientPortfolioId() {
		return QCR_DETAIL_CLIENT_PORTFOLIO_ID;
	}

	public static void setQCRDetailClientPortfolioId(int qcrDetailClientPortfolioId) {
		QCR_DETAIL_CLIENT_PORTFOLIO_ID = qcrDetailClientPortfolioId;
	}

	public static int getQCRDetailClientId() {
		return QCR_DETAIL_CLIENT_ID;
	}

	public static void setQCRDetailClientId(int qcrDetailClientId) {
		QCR_DETAIL_CLIENT_ID = qcrDetailClientId;
	}

	public static String getQCRDetailClientType() {
		return QCR_DETAIL_CLIENT_TYPE;
	}

	public static void setQCRDetailClientType(String qcrDetailClientType) {
		QCR_DETAIL_CLIENT_TYPE = qcrDetailClientType;
	}

	public static int getQCRDetailRequestId() {
		return QCR_DETAIL_REQUEST_ID;
	}

	public static void setQCRDetailRequestId(int qcrDetailRequestId) {
		QCR_DETAIL_REQUEST_ID = qcrDetailRequestId;
	}

	public static int getQCRDetailChannelId() {
		return QCR_DETAIL_CHANNEL_ID;
	}

	public static void setQCRDetailChannelId(int qcrDetailChannelId) {
		QCR_DETAIL_CHANNEL_ID = qcrDetailChannelId;
	}

	public static int getQCRDetailReasonId() {
		return QCR_DETAIL_REASON_ID;
	}

	public static void setQCRDetailReasonId(int qcrDetailReasonId) {
		QCR_DETAIL_REASON_ID = qcrDetailReasonId;
	}

	public static int getQCRDetailClaimReasonId() {
		return QCR_DETAIL_CLAIM_REASON_ID;
	}

	public static void setQCRDetailClaimReasonId(int qcrDetailClaimReasonId) {
		QCR_DETAIL_CLAIM_REASON_ID = qcrDetailClaimReasonId;
	}

	public static int getQCRDetailUnreachableReasonId() {
		return QCR_DETAIL_UNREACHABLE_REASON_ID;
	}

	public static void setQCRDetailUnreachableReasonId(int qcrDetailUnreachableReasonId) {
		QCR_DETAIL_UNREACHABLE_REASON_ID = qcrDetailUnreachableReasonId;
	}

	public static int getQCRDetailNotIntReasonId() {
		return QCR_DETAIL_NOT_INT_REASON_ID;
	}

	public static void setQCRDetailNotIntReasonId(int qcrDetailNotIntReasonId) {
		QCR_DETAIL_NOT_INT_REASON_ID = qcrDetailNotIntReasonId;
	}

	public static int getQCRDetailResultId() {
		return QCR_DETAIL_RESULT_ID;
	}

	public static void setQCRDetailResultId(int qcrDetailResultId) {
		QCR_DETAIL_RESULT_ID = qcrDetailResultId;
	}

	public static String getQCRDetailReportDate() {
		return QCR_DETAIL_REPORT_DATE;
	}

	public static void setQCRDetailReportDate(String qcrDetailReportDate) {
		QCR_DETAIL_REPORT_DATE = qcrDetailReportDate;
	}

	public static int getClientIdInfo() {
		return CLIENT_ID_INFO;
	}

	public static void setClientIdInfo(int clientIdInfo) {
		CLIENT_ID_INFO = clientIdInfo;
	}

	public static String getClientCodeInfo() {
		return CLIENT_CODE_INFO;
	}

	public static void setClientCodeInfo(String clientCodeInfo) {
		CLIENT_CODE_INFO = clientCodeInfo;
	}

	public static String getClientNameInfo() {
		return CLIENT_NAME_INFO;
	}

	public static void setClientNameInfo(String clientNameInfo) {
		CLIENT_NAME_INFO = clientNameInfo;
	}

	public static String getClientSurnameInfo() {
		return CLIENT_SURNAME_INFO;
	}

	public static void setClientSurnameInfo(String clientSurnameInfo) {
		CLIENT_SURNAME_INFO = clientSurnameInfo;
	}

	public static String getClientBirthDateInfo() {
		return CLIENT_BIRTH_DATE_INFO;
	}

	public static void setClientBirthDateInfo(String clientBirthDateInfo) {
		CLIENT_BIRTH_DATE_INFO = clientBirthDateInfo;
	}

	public static int getClientNumberOfYearsInfo() {
		return CLIENT_NUMBER_OF_YEARS_INFO;
	}

	public static void setClientNumberOfYearsInfo(int clientNumberOfYearsInfo) {
		CLIENT_NUMBER_OF_YEARS_INFO = clientNumberOfYearsInfo;
	}

	public static String getHierarchyCallerId() {
		return HIERARCHY_CALLER_ID;
	}

	public static void setHierarchyCallerId(String hierarchyCallerId) {
		HIERARCHY_CALLER_ID = hierarchyCallerId;
	}

	public static String getHierarchyPortfolioId() {
		return HIERARCHY_PORTFOLIO_ID;
	}

	public static void setHierarchyPortfolioId(String hierarchyPortfolioId) {
		HIERARCHY_PORTFOLIO_ID = hierarchyPortfolioId;
	}

	public static int getRegionLevel1Branch1Id() {
		return REGION_LEVEL_1_BRANCH_1_ID;
	}

	public static void setRegionLevel1Branch1Id(int regionLevel1Branch1Id) {
		REGION_LEVEL_1_BRANCH_1_ID = regionLevel1Branch1Id;
	}

	public static int getRegionLevel2Branch1Id() {
		return REGION_LEVEL_2_BRANCH_1_ID;
	}

	public static void setRegionLevel2Branch1Id(int regionLevel2Branch1Id) {
		REGION_LEVEL_2_BRANCH_1_ID = regionLevel2Branch1Id;
	}

	public static int getRegionLevel3Branch1Id() {
		return REGION_LEVEL_3_BRANCH_1_ID;
	}

	public static void setRegionLevel3Branch1Id(int regionLevel3Branch1Id) {
		REGION_LEVEL_3_BRANCH_1_ID = regionLevel3Branch1Id;
	}

	public static int getRegionLevel4Branch1Id() {
		return REGION_LEVEL_4_BRANCH_1_ID;
	}

	public static void setRegionLevel4Branch1Id(int regionLevel4Branch1Id) {
		REGION_LEVEL_4_BRANCH_1_ID = regionLevel4Branch1Id;
	}

	public static int getRegionLevel2Branch2Id() {
		return REGION_LEVEL_2_BRANCH_2_ID;
	}

	public static void setRegionLevel2Branch2Id(int regionLevel2Branch2Id) {
		REGION_LEVEL_2_BRANCH_2_ID = regionLevel2Branch2Id;
	}

	public static int getRegionLevel3Branch2Id() {
		return REGION_LEVEL_3_BRANCH_2_ID;
	}

	public static void setRegionLevel3Branch2Id(int regionLevel3Branch2Id) {
		REGION_LEVEL_3_BRANCH_2_ID = regionLevel3Branch2Id;
	}

	public static int getRegionLevel4Branch2Id() {
		return REGION_LEVEL_4_BRANCH_2_ID;
	}

	public static void setRegionLevel4Branch2Id(int regionLevel4Branch2Id) {
		REGION_LEVEL_4_BRANCH_2_ID = regionLevel4Branch2Id;
	}

	public static int getP1() {
		return P1;
	}

	public static void setP1(int p1) {
		P1 = p1;
	}

	public static int getP2() {
		return P2;
	}

	public static void setP2(int p2) {
		P2 = p2;
	}

	public static int getP3() {
		return P3;
	}

	public static void setP3(int p3) {
		P3 = p3;
	}

	public static int getP4() {
		return P4;
	}

	public static void setP4(int p4) {
		P4 = p4;
	}

	public static int getP5() {
		return P5;
	}

	public static void setP5(int p5) {
		P5 = p5;
	}

	public static int getP6() {
		return P6;
	}

	public static void setP6(int p6) {
		P6 = p6;
	}
}

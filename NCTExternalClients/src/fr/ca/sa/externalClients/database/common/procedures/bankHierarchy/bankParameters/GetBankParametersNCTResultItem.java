package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankParameters;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spGetBankParameters store procedure
 */
public class GetBankParametersNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private int bankId;
	private String bankName;
	private int langId;
	private int langOrder;
	private String langName;
	private String langCode;
	private boolean defaultLang;

	private String logoPicture;
	private String flagPicture;

	private String translations;
	private String translationsManagement;

	/**
	 * default constructor for Get Bank Parameters NCT Result Item
	 */
	public GetBankParametersNCTResultItem() {
		super();
	}

	/**
	 * Get Bank Parameters NCT Result Item
	 * 
	 * @param bankId
	 * 				Bank ID
	 * 
	 * @param bankName
	 * 				Bank name
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @param langOrder
	 * 				Language order
	 * 
	 * @param langName
	 * 				Language name
	 * 
	 * @param langCode
	 * 				Language code
	 * 
	 * @param defaultLang
	 * 				Default language
	 * 
	 * @param translations
	 * 				Translations 
	 * 
	 * @param translationsManagement
	 * 				Translations management
	 */
	public GetBankParametersNCTResultItem(int bankId, String bankName, int langId, int langOrder, String langName,
			String langCode, boolean defaultLang, String translations, String translationsManagement) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.langId = langId;
		this.langOrder = langOrder;
		this.langName = langName;
		this.langCode = langCode;
		this.defaultLang = defaultLang;
		this.translations = translations;
		this.translationsManagement = translationsManagement;
	}

	/**
	 * Get Bank Parameters NCT Result Item
	 * 
	 * @param bankId
	 * 				Bank ID
	 * 
	 * @param bankName
	 * 				Bank name
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @param langOrder
	 * 				Language order
	 * 
	 * @param langName
	 * 				Language name
	 * 
	 * @param langCode
	 * 				Language code
	 * 
	 * @param defaultLang
	 * 				Default language
	 * 
	 * @param logoPicture
	 * 				Logo picture
	 * 
	 * @param translations
	 * 				Translations
	 * 
	 * @param translationsManagement
	 * 				Translations management
	 */
	public GetBankParametersNCTResultItem(int bankId, String bankName, int langId, int langOrder, String langName,
			String langCode, boolean defaultLang, String logoPicture, String translations,
			String translationsManagement) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.langId = langId;
		this.langOrder = langOrder;
		this.langName = langName;
		this.langCode = langCode;
		this.defaultLang = defaultLang;
		this.logoPicture = logoPicture;
		this.translations = translations;
		this.translationsManagement = translationsManagement;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public int getLangOrder() {
		return langOrder;
	}

	public void setLangOrder(int langOrder) {
		this.langOrder = langOrder;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public boolean isDefaultLang() {
		return defaultLang;
	}

	public void setDefaultLang(boolean defaultLang) {
		this.defaultLang = defaultLang;
	}

	public String getLogoPicture() {
		return logoPicture;
	}

	public void setLogoPicture(String logoPicture) {
		this.logoPicture = logoPicture;
	}

	public String getFlagPicture() {
		return flagPicture;
	}

	public void setFlagPicture(String flagPicture) {
		this.flagPicture = flagPicture;
	}

	public String getTranslations() {
		return translations;
	}

	public void setTranslations(String translations) {
		this.translations = translations;
	}

	public String getTranslationsManagement() {
		return translationsManagement;
	}

	public void setTranslationsManagement(String translationsManagement) {
		this.translationsManagement = translationsManagement;
	}

	@Override
	public String toString() {
		return "GetBankParametersNCTResultItem [bankId=" + bankId + ", bankName=" + bankName + ", langId=" + langId
				+ ", langOrder=" + langOrder + ", langName=" + langName + ", langCode=" + langCode + ", defaultLang="
				+ defaultLang + ", logoPicture=" + logoPicture + ", flagPicture=" + flagPicture + ", translations="
				+ translations + ", translationsManagement=" + translationsManagement + "]";
	}

}

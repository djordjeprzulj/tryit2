package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.languages.getLanguages;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from spGetLanguages
 *         store procedure
 */
public class GetLanguagesNCTResultItem implements StoreProcedureResult, Serializable {
	
	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int langId;
	private String langCode;
	private String langName;

	private String flagPicture;

	private String translations;
	private String translationsManagement;

	/**
	 * default constructor for Get Languages NCT Result Item
	 */
	public GetLanguagesNCTResultItem() {
		super();
	}

	/**
	 * Get Languages NCT Result Item
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @param langCode
	 * 				Language code
	 * 
	 * @param langName
	 * 				Language name
	 * 
	 * @param translations
	 * 				Translations
	 * 
	 * @param translationsManagement
	 * 				Translations for management
	 */
	public GetLanguagesNCTResultItem(int langId, String langCode, String langName, String translations,
			String translationsManagement) {
		super();
		this.langId = langId;
		this.langCode = langCode;
		this.langName = langName;
		this.translations = translations;
		this.translationsManagement = translationsManagement;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
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
		return "GetLanguagesNCTResultItem [langId=" + langId + ", langCode=" + langCode + ", langName=" + langName
				+ ", flagPicture=" + flagPicture + ", translations=" + translations + ", translationsManagement="
				+ translationsManagement + "]";
	}

}

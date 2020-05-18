package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.languages.getLanguages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.nct.commons.commonEntities.TranslationPair;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetLanguages store procedure
 */

public class GetLanguagesNCTResultList implements StoreProcedureResult, Serializable {
	
	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetLanguagesNCTResultItem> languages;
	private List<TranslationPair> defaultLanguageTranslations;

	/**
	 * default constructor for Get Languages NCT Result List
	 */
	public GetLanguagesNCTResultList() {
		super();
		languages = new ArrayList<GetLanguagesNCTResultItem>();
	}

	/**
	 * Get Languages NCT Result List
	 * 
	 * @param languages
	 * 				Languages
	 */
	public GetLanguagesNCTResultList(List<GetLanguagesNCTResultItem> languages) {
		super();
		this.languages = languages;
	}

	public List<GetLanguagesNCTResultItem> getLanguages() {
		return languages;
	}

	public void setLanguages(List<GetLanguagesNCTResultItem> languages) {
		this.languages = languages;
	}

	public List<TranslationPair> getDefaultLanguageTranslations() {
		return defaultLanguageTranslations;
	}

	public void setDefaultLanguageTranslations(List<TranslationPair> defaultLanguageTranslations) {
		this.defaultLanguageTranslations = defaultLanguageTranslations;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetLanguagesNCTResultList [ ");
		if (this.languages != null) {
			for (GetLanguagesNCTResultItem langItem : this.languages) {
				sbRetValue.append(langItem.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetLanguagesNCTResultList is empty!!!";
	}

}

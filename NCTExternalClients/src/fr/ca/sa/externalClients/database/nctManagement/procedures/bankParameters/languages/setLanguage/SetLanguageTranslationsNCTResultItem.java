package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.languages.setLanguage;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from spSetLanguage
 *         store procedure
 */
public class SetLanguageTranslationsNCTResultItem implements StoreProcedureResult {

	private int translationID;

	/**
	 * Set Language Translations NCT Result Item
	 * 
	 * @param translationID
	 * 				Translation ID
	 */
	public SetLanguageTranslationsNCTResultItem(int translationID) {
		super();
		this.translationID = translationID;
	}

	public int getTranslationID() {
		return translationID;
	}

	public void setTranslationID(int translationID) {
		this.translationID = translationID;
	}

	@Override
	public String toString() {
		return "SetLanguageTranslationsNCTResultItem [translationID=" + translationID + "]";
	}

}

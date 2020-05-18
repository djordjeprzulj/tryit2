package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.languages.setLanguage;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spSetLanguage store procedure
 */
public class SetLanguageNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String flagPicture;
	private int langId;

	/**
	 * Set Language NCT Result Item
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public SetLanguageNCTResultItem(int langId) {
		super();
		this.langId = langId;
	}

	/**
	 * Set Language NCT Result Item
	 * 
	 * @param flagPicture
	 * 				Flag picture
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public SetLanguageNCTResultItem(String flagPicture, int langId) {
		super();
		this.flagPicture = flagPicture;
		this.langId = langId;
	}

	public String getFlagPicture() {
		return flagPicture;
	}

	public void setFlagPicture(String flagPicture) {
		this.flagPicture = flagPicture;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	@Override
	public String toString() {
		return "SetLanguageNCTResultItem [flagPicture=" + flagPicture + ", langId=" + langId + "]";
	}

}

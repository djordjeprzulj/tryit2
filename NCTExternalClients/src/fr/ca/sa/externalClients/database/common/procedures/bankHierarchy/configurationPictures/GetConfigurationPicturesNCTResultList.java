package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationPictures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetCONFIGURATION_PICTURES store
 *         procedure
 */

public class GetConfigurationPicturesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private List<GetConfigurationPicturesNCTResultItem> pictures;

	/**
	 * default constructor for Get Configuration Pictures NCT Result List
	 */
	public GetConfigurationPicturesNCTResultList() {
		super();
		this.pictures = new ArrayList<GetConfigurationPicturesNCTResultItem>();
	}

	/**
	 * Get Configuration Pictures NCT Result List
	 * 
	 * @param pictures
	 * 				Pictures
	 */
	public GetConfigurationPicturesNCTResultList(List<GetConfigurationPicturesNCTResultItem> pictures) {
		super();
		this.pictures = pictures;
	}

	public List<GetConfigurationPicturesNCTResultItem> getPictures() {
		return pictures;
	}

	public void setPictures(List<GetConfigurationPicturesNCTResultItem> pictures) {
		this.pictures = pictures;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetConfigurationPicturesNCTResultList [ ");
		if (this.pictures != null) {
			for (GetConfigurationPicturesNCTResultItem pic : this.pictures) {
				sbRetValue.append(pic.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetConfigurationPicturesNCTResultList is empty!!!";
	}

}

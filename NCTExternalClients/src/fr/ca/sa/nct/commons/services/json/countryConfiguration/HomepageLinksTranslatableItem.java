package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response JSON wrapper for translatable homepage links item
 * 
 * @author Nemanja Ignjatov
 *
 */
public class HomepageLinksTranslatableItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int linkId;
	private Map<String, String> names;
	private String linkUrl;
	private String linkPictureName;
	private int linkOrder;
	private Boolean isActive;

	/**
	 * default constructor for Homepage Links Translatable Item
	 */
	public HomepageLinksTranslatableItem() {
		super();
		this.names = new HashMap<String, String>();
	}

	/**
	 * Homepage Links Translatable Item
	 * 
	 * @param linkId
	 * 				Link ID
	 * 
	 * @param linkUrl
	 * 				Link URL
	 * 
	 * @param linkPictureName
	 * 				Link picture name
	 * 
	 * @param linkOrder
	 * 				Link order
	 * 
	 * @param lang
	 * 				Language
	 * 
	 * @param name
	 * 				Name
	 * 
	 * @param isActive
	 * 				Active link
	 */
	public HomepageLinksTranslatableItem(int linkId, String linkUrl, String linkPictureName, int linkOrder,
			String lang, String name, Integer isActive) {
		super();
		this.linkId = linkId;
		this.linkUrl = linkUrl;
		this.linkPictureName = linkPictureName;
		this.linkOrder = linkOrder;
		this.isActive = isActive == 1;

		this.names = new HashMap<String, String>();
		this.names.put(lang, name);
	}

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public Map<String, String> getNames() {
		return names;
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkPictureName() {
		return linkPictureName;
	}

	public void setLinkPictureName(String linkPictureName) {
		this.linkPictureName = linkPictureName;
	}

	public int getLinkOrder() {
		return linkOrder;
	}

	public void setLinkOrder(int linkOrder) {
		this.linkOrder = linkOrder;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "HomepageLinksTranslatableItem [linkId=" + linkId + ", names=" + names + ", linkUrl=" + linkUrl
				+ ", linkPictureName=" + linkPictureName + ", linkOrder=" + linkOrder + ", isActive=" + isActive + "]";
	}

}

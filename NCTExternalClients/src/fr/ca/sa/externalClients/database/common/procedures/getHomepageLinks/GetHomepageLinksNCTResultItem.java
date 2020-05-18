package fr.ca.sa.externalClients.database.common.procedures.getHomepageLinks;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spGetAppHomePageMenuLinks store procedure
 */
public class GetHomepageLinksNCTResultItem implements StoreProcedureResult {

	private int linkId;
	private String linkName;
	private String linkUrl;
	private String linkPictureName;
	private int linkOrder;
	private Integer isActive;

	/**
	 * default constructor for Get Homepage Links NCT Result Item
	 */
	public GetHomepageLinksNCTResultItem() {
		super();
	}

	/**
	 * Get Homepage Links NCT Result Item
	 * 
	 * @param linkId
	 * 				Link ID
	 * 
	 * @param linkName
	 * 				Link name
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
	 * @param isActive
	 * 				If it's active
	 */
	public GetHomepageLinksNCTResultItem(int linkId, String linkName, String linkUrl, String linkPictureName,
			int linkOrder, Integer isActive) {
		super();
		this.linkId = linkId;
		this.linkName = linkName;
		this.linkUrl = linkUrl;
		this.linkPictureName = linkPictureName;
		this.linkOrder = linkOrder;
		this.isActive = isActive;
	}

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "GetHomepageLinksNCTResultItem [linkId=" + linkId + ", linkName=" + linkName + ", linkUrl=" + linkUrl
				+ ", linkPictureName=" + linkPictureName + ", linkOrder=" + linkOrder + ", isActive=" + isActive + "]";
	}

}

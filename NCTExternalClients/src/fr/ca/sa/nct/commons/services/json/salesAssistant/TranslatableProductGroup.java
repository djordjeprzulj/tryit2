package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Translatable Product Group
 * 
 * @author Sasa Radovanovic
 *
 */
public class TranslatableProductGroup implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int productGroupId;
	private String productGroupCode;
	private Map<String, String> productGroupName;
	private String productGroupPicture;
	private Map<String, String> productGroupDescription;
	private Boolean isBestOffer;

	/**
	 * Translatable Product Group
	 * 
	 * @param productGroupId
	 * 				Product group ID
	 * 
	 * @param productGroupCode
	 * 				Product group code
	 * 
	 * @param productGroupName
	 * 				Product group name 
	 * 
	 * @param productGroupPicture
	 * 				Product group picture
	 * 
	 * @param productGroupDescription
	 * 				Product group description
	 * 
	 * @param isBestOffer
	 * 				Is best offer
	 */
	public TranslatableProductGroup(int productGroupId, String productGroupCode,
			Map<String, String> productGroupName, String productGroupPicture,
			Map<String, String> productGroupDescription, Boolean isBestOffer) {
		super();
		this.productGroupId = productGroupId;
		this.productGroupCode = productGroupCode;
		this.productGroupName = productGroupName;
		this.productGroupPicture = productGroupPicture;
		this.productGroupDescription = productGroupDescription;
		this.isBestOffer = isBestOffer;
	}

	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getProductGroupCode() {
		return productGroupCode;
	}

	public void setProductGroupCode(String productGroupCode) {
		this.productGroupCode = productGroupCode;
	}

	public Map<String, String> getProductGroupName() {
		return productGroupName;
	}

	public void setProductGroupName(Map<String, String> productGroupName) {
		this.productGroupName = productGroupName;
	}

	public String getProductGroupPicture() {
		return productGroupPicture;
	}

	public void setProductGroupPicture(String productGroupPicture) {
		this.productGroupPicture = productGroupPicture;
	}

	public Map<String, String> getProductGroupDescription() {
		return productGroupDescription;
	}

	public void setProductGroupDescription(Map<String, String> productGroupDescription) {
		this.productGroupDescription = productGroupDescription;
	}

	public Boolean getIsBestOffer() {
		return isBestOffer;
	}

	public void setIsBestOffer(Boolean isBestOffer) {
		this.isBestOffer = isBestOffer;
	}

}

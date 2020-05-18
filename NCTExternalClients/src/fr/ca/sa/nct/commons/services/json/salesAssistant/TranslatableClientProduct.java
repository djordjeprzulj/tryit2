package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.BaseTranslatableProduct;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class TranslatableClientProduct extends BaseTranslatableClientProduct implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int groupId;
	private Map<String, String> groupName;
	private Map<String, String> groupDescription;
	
	private Boolean isBestOfferProductGroup;
	private String bestOfferDescription;

	/**
	 * Translatable Client Product
	 * 
	 * @param groupId
	 * 				Product group ID
	 * 
	 * @param groupName
	 * 				Product group name
	 * 
	 * @param groupDescription
	 * 				Product group description
	 * 
	 * @param isBestOfferProductGroup
	 * 				Is best offer product group
	 * 
	 * @param bestOfferDescription
	 * 				Best offer description
	 *  
	 */
	public TranslatableClientProduct(BaseTranslatableProduct baseTranslatableProduct,
			int groupId, 
			Map<String, String> groupName,
			Map<String, String> groupDescription, 
			Boolean isBestOfferProductGroup,
			String bestOfferDescription) {
		super(baseTranslatableProduct);
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.isBestOfferProductGroup = isBestOfferProductGroup;
		this.bestOfferDescription=bestOfferDescription;
	}

	public int getProductGroupId() {
		return groupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.groupId = productGroupId;
	}

	public Map<String, String> getProductGroupName() {
		return groupName;
	}

	public void setProductGroupName(Map<String, String> productGroupName) {
		this.groupName = productGroupName;
	}

	public Map<String, String> getProductGroupDescription() {
		return groupDescription;
	}

	public void setProductGroupDescription(Map<String, String> productGroupDescription) {
		this.groupDescription = productGroupDescription;
	}

	public Boolean getIsBestOfferProductGroup() {
		return isBestOfferProductGroup;
	}

	public void setIsBestOfferProductGroup(Boolean isBestOfferProductGroup) {
		this.isBestOfferProductGroup = isBestOfferProductGroup;
	}

	public String getBestOfferDescription() {
		return this.bestOfferDescription;
	}

	public void setBestOfferDescription(String bestOfferDescription) {
		this.bestOfferDescription = bestOfferDescription;
	}

}

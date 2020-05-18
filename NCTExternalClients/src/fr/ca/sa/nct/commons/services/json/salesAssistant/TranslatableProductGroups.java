package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder for translated Product Groups
 * 
 * @author Sasa Radovanovic
 *
 */
public class TranslatableProductGroups implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<TranslatableProductGroup> productGroups;

	/**
	 * default constructor for Translatable Product Groups
	 */
	public TranslatableProductGroups() {
		super();
		this.productGroups = new ArrayList<>();
	}

	/**
	 * Translatable Product Groups
	 * 
	 * @param productGroups
	 * 				Product groups
	 */
	public TranslatableProductGroups(List<TranslatableProductGroup> productGroups) {
		super();
		this.productGroups = productGroups;
	}

	public List<TranslatableProductGroup> getProductGroups() {
		return productGroups;
	}

	public void setProductGroups(List<TranslatableProductGroup> productGroups) {
		this.productGroups = productGroups;
	}

}

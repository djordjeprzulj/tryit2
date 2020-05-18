package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for products list retrieved from database. Used in pair
 * with @GetProductsGroupsNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetProductGroupNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetProductGroupNCTResultItem> productsGroups;

	/**
	 * default constructor for Get Products Groups NCT Result List
	 */
	public GetProductGroupNCTResultList() {
		super();
		productsGroups = new ArrayList<>();
	}

	/**
	 * Get Products Groups NCT Result List
	 * 
	 * @param productsGroups
	 * 				Products groups
	 */
	public GetProductGroupNCTResultList(List<GetProductGroupNCTResultItem> productsGroups) {
		super();
		this.productsGroups = productsGroups;
	}

	public List<GetProductGroupNCTResultItem> getProductsGroups() {
		return productsGroups;
	}

	public void setProductsGroups(List<GetProductGroupNCTResultItem> productsGroups) {
		this.productsGroups = productsGroups;
	}

	@Override
	public String toString() {
		return "GetProductsGroupsNCTResultList [productsGroups=" + productsGroups + "]";
	}

}

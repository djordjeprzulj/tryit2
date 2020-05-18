package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductsGroups;

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
public class GetProductsGroupsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetProductsGroupsNCTResultItem> productsGroups;

	/**
	 * default constructor for Get Products Groups NCT Result List
	 */
	public GetProductsGroupsNCTResultList() {
		super();
		productsGroups = new ArrayList<>();
	}

	/**
	 * Get Products Groups NCT Result List
	 * 
	 * @param productsGroups
	 * 				Products groups
	 */
	public GetProductsGroupsNCTResultList(List<GetProductsGroupsNCTResultItem> productsGroups) {
		super();
		this.productsGroups = productsGroups;
	}

	public List<GetProductsGroupsNCTResultItem> getProductsGroups() {
		return productsGroups;
	}

	public void setProductsGroups(List<GetProductsGroupsNCTResultItem> productsGroups) {
		this.productsGroups = productsGroups;
	}

	@Override
	public String toString() {
		return "GetProductsGroupsNCTResultList [productsGroups=" + productsGroups + "]";
	}

}

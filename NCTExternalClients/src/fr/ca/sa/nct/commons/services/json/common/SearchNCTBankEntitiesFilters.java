package fr.ca.sa.nct.commons.services.json.common;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.cities.GetBankEntitiesCitiesNCTResultList;
import fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.functions.GetBankEntitiesFunctionsNCTResultList;
import fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.productgroups.GetBankEntitiesProductGroupsNCTResultList;
import fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.regions.GetBankEntitiesRegionsNCTResultList;
import fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.types.GetBankEntitiesTypesNCTResultList;

/**
 * 
 * Response JSON wrapper for branch filters
 * 
 * 
 * @author Milivoj Bozic
 *
 */
public class SearchNCTBankEntitiesFilters implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetBankEntitiesCitiesNCTResultList cities;
	private GetBankEntitiesFunctionsNCTResultList functions;
	private GetBankEntitiesProductGroupsNCTResultList productGroups;
	private GetBankEntitiesRegionsNCTResultList regions;
	private GetBankEntitiesTypesNCTResultList types;

	/**
	 * default constructor for Bank Branch Merged Item
	 */
	public SearchNCTBankEntitiesFilters() {
		super();
	}

	public GetBankEntitiesCitiesNCTResultList getCities() {
		return cities;
	}

	public void setCities(GetBankEntitiesCitiesNCTResultList cities) {
		this.cities = cities;
	}

	public GetBankEntitiesFunctionsNCTResultList getFunctions() {
		return functions;
	}

	public void setFunctions(GetBankEntitiesFunctionsNCTResultList functions) {
		this.functions = functions;
	}

	public GetBankEntitiesProductGroupsNCTResultList getProductGroups() {
		return productGroups;
	}

	public void setProductGroups(GetBankEntitiesProductGroupsNCTResultList productGroups) {
		this.productGroups = productGroups;
	}

	public GetBankEntitiesRegionsNCTResultList getRegions() {
		return regions;
	}

	public void setRegions(GetBankEntitiesRegionsNCTResultList regions) {
		this.regions = regions;
	}

	public GetBankEntitiesTypesNCTResultList getTypes() {
		return types;
	}

	public void setTypes(GetBankEntitiesTypesNCTResultList types) {
		this.types = types;
	}

	

}

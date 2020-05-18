package fr.ca.sa.nct.commons.services.json.search;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for receiving filters for entity search
 * 
 * @author Milivoj Bozic
 *
 */

public class SearchEntityFilter implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String cityName;
	private String address;
	private String entityCode;
	private String region;
	private String firstName;
	private String lastName;
	private Integer functionId;
	private Integer entityTypeId;
	private Integer productGroupId;

	/**
	 * default constructor for Search Entity Filter
	 */
	public SearchEntityFilter() {
		super();
	}

	/**
	 * Search Entity Filter
	 * 
	 * @param cityName
	 * 				City name
	 * 
	 * @param address
	 * 				Address
	 * 
	 * @param entityCode
	 * 				Entity code
	 * 
	 * @param region
	 * 				Region
	 * 
	 * @param firstName
	 * 				First name
	 * 
	 * @param lastName
	 * 				Last name
	 * 
	 * @param functionId
	 * 				Function ID
	 * 
	 * @param entityTypeId
	 * 				Entity type ID
	 * 
	 * @param productGroupId
	 * 				Product group ID
	 */
	public SearchEntityFilter(String cityName, String address, String entityCode, String region, String firstName,
			String lastName, Integer functionId, Integer entityTypeId, Integer productGroupId) {
		super();

		this.cityName = cityName;
		this.address = address;
		this.entityCode = entityCode;
		this.region = region;
		this.firstName = firstName;
		this.lastName = lastName;
		this.functionId = functionId;
		this.entityTypeId = entityTypeId;
		this.productGroupId = productGroupId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	public Integer getEntityTypeId() {
		return entityTypeId;
	}

	public void setEntityTypeId(Integer entityTypeId) {
		this.entityTypeId = entityTypeId;
	}

	public Integer getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(Integer productGroupId) {
		this.productGroupId = productGroupId;
	}

}

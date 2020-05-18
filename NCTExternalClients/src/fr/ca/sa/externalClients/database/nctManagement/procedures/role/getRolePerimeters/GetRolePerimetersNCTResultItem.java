package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getRolePerimeters;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetRolePerimetersNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int perimeterId;
	private String perimeterName;
	private String perimeterDescription;

	/**
	 * default constructor for Get Role Perimeters NCT Result Item
	 */
	public GetRolePerimetersNCTResultItem() {
		super();
	}

	/**
	 * Get Role Perimeters NCT Result Item
	 * 
	 * @param perimeterId
	 * 				Perimeter ID
	 * 
	 * @param perimeterName
	 * 				Perimeter name
	 * 
	 * @param perimeterDescription
	 * 				Perimeter description
	 */
	public GetRolePerimetersNCTResultItem(int perimeterId, String perimeterName, String perimeterDescription) {
		super();
		this.perimeterId = perimeterId;
		this.perimeterName = perimeterName;
		this.perimeterDescription = perimeterDescription;
	}

	public int getPerimeterId() {
		return perimeterId;
	}

	public void setPerimeterId(int perimeterId) {
		this.perimeterId = perimeterId;
	}

	public String getPerimeterName() {
		return perimeterName;
	}

	public void setPerimeterName(String perimeterName) {
		this.perimeterName = perimeterName;
	}

	public String getPerimeterDescription() {
		return perimeterDescription;
	}

	public void setPerimeterDescription(String perimeterDescription) {
		this.perimeterDescription = perimeterDescription;
	}

	@Override
	public String toString() {
		return "GetRolePerimetersResultItem [perimeterId=" + perimeterId + ", perimeterName=" + perimeterName
				+ ", perimeterDescription=" + perimeterDescription + "]";
	}

}

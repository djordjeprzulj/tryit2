package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getRolePerimeters;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetRolePerimetersNCTResultList implements StoreProcedureResult {

	private List<GetRolePerimetersNCTResultItem> perimeters;

	/**
	 * default constructor for Get Role Perimeters NCT Result List
	 */
	public GetRolePerimetersNCTResultList() {
		super();
		this.perimeters = new ArrayList<GetRolePerimetersNCTResultItem>();
	}

	public List<GetRolePerimetersNCTResultItem> getPerimeters() {
		return perimeters;
	}

	public void setPerimeters(List<GetRolePerimetersNCTResultItem> perimeters) {
		this.perimeters = perimeters;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetRolePerimetersResultList [ ");
		if (this.perimeters != null) {
			for (GetRolePerimetersNCTResultItem perimeter : this.perimeters) {
				sbRetValue.append(perimeter.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetRolePerimetersResultList is empty!!!";
	}
}

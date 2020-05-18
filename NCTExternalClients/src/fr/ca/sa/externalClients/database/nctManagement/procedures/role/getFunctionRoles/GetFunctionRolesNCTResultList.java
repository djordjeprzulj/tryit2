package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getFunctionRoles;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Djordje Przulj
 *
 */
public class GetFunctionRolesNCTResultList implements StoreProcedureResult {

	private List<GetFunctionRolesNCTResultItem> functionRoles;

	/**
	 * default constructor for Get Roles NCT Result List
	 */
	public GetFunctionRolesNCTResultList() {
		super();
		this.functionRoles = new ArrayList<GetFunctionRolesNCTResultItem>();
	}

	public List<GetFunctionRolesNCTResultItem> getRoles() {
		return functionRoles;
	}

	public void setRoles(List<GetFunctionRolesNCTResultItem> roles) {
		this.functionRoles = roles;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetFunctionRolesNCTResultList [ ");
		if (this.functionRoles != null) {
			for (GetFunctionRolesNCTResultItem functionRole : this.functionRoles) {
				sbRetValue.append(functionRole.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetFunctionRolesNCTResultList is empty!!!";
	}

}

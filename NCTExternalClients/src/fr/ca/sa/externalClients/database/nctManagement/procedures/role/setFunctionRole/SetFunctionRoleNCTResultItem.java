package fr.ca.sa.externalClients.database.nctManagement.procedures.role.setFunctionRole;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Djordje Przulj
 *
 */
public class SetFunctionRoleNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;


	/**
	 * default constructor for Set Function Role NCT Result Item
	 */
	public SetFunctionRoleNCTResultItem() {
		super();
	}

	@Override
	public String toString() {
		return "SetFunctionRoleNCTResultItem [ void ]";
	}

}

package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowDirectionTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for all results from batch.spGetFlowDirectionTypes store
 * procedure
 * 
 * * @author Nemanja Ignjatov
 */

public class GetFlowDirectionTypesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetFlowDirectionTypesNCTResultItem> directions;

	/**
	 * default constructor for Get Flow Direction Types NCT Result List
	 */
	public GetFlowDirectionTypesNCTResultList() {
		super();
		directions = new ArrayList<GetFlowDirectionTypesNCTResultItem>();
	}

	/**
	 * Get Flow Direction Types NCT Result List
	 * 
	 * @param directions
	 * 				Directions of flow
	 */
	public GetFlowDirectionTypesNCTResultList(List<GetFlowDirectionTypesNCTResultItem> directions) {
		super();
		this.directions = directions;
	}

	public List<GetFlowDirectionTypesNCTResultItem> getDirections() {
		return directions;
	}

	public void setDirections(List<GetFlowDirectionTypesNCTResultItem> directions) {
		this.directions = directions;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetFlowDirectionTypesNCTResultList [ ");
		if (this.directions != null) {
			for (GetFlowDirectionTypesNCTResultItem directionItem : this.directions) {
				sbRetValue.append(directionItem.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetFlowDirectionTypesNCTResultList is empty!!!";
	}

}

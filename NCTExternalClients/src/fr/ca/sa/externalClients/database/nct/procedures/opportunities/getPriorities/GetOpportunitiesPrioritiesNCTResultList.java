package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getPriorities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * List of opportunities priorities fetches from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunitiesPrioritiesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOpportunitiesPrioritiesNCTResultItem> priorities;

	/**
	 * default constructor for Get Opportunities Priorities NCT Result List
	 */
	public GetOpportunitiesPrioritiesNCTResultList() {
		this.priorities = new ArrayList<GetOpportunitiesPrioritiesNCTResultItem>();
	}

	/**
	 * Get Opportunities Priorities NCT Result List
	 * 
	 * @param priorities
	 * 				Priorities
	 */
	public GetOpportunitiesPrioritiesNCTResultList(List<GetOpportunitiesPrioritiesNCTResultItem> priorities) {
		super();
		this.priorities = priorities;
	}

	public List<GetOpportunitiesPrioritiesNCTResultItem> getPriorities() {
		return priorities;
	}

	public void setPriorities(List<GetOpportunitiesPrioritiesNCTResultItem> priorities) {
		this.priorities = priorities;
	}

	@Override
	public String toString() {
		return "GetOpportunitiesPrioritiesNCTResultList [priorities=" + priorities + "]";
	}

}

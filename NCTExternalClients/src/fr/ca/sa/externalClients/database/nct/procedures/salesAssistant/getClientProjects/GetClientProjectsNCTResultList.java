package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientProjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for project list retrieved from database. Used in pair
 * with @GetClientProjectsNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientProjectsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetClientProjectsNCTResultItem> projects;

	/**
	 * default constructor for Get Client Projects NCT Result List
	 */
	public GetClientProjectsNCTResultList() {
		super();
		this.projects = new ArrayList<>();
	}

	/**
	 * Get Client Projects NCT Result List
	 * 
	 * @param projects
	 * 				Projects
	 */
	public GetClientProjectsNCTResultList(List<GetClientProjectsNCTResultItem> projects) {
		super();
		this.projects = projects;
	}

	public List<GetClientProjectsNCTResultItem> getProjects() {
		return projects;
	}

	public void setProjects(List<GetClientProjectsNCTResultItem> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "GetClientProjectsNCTResultList [projects=" + projects + "]";
	}

}

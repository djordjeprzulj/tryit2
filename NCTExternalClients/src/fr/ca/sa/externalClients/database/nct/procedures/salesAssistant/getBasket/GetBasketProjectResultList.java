package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketProjectResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetBasketProjectResultItem> projectList;

	/**
	 * Get Basket Project Result List
	 * 
	 * @param projectList
	 * 				List of basket projects
	 */
	public GetBasketProjectResultList(List<GetBasketProjectResultItem> projectList) {
		super();
		this.projectList = projectList;
	}

	/**
	 * default constructor for Get Basket Project Result List
	 */
	public GetBasketProjectResultList() {
		super();
		this.projectList = new ArrayList<>();
	}

	public List<GetBasketProjectResultItem> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<GetBasketProjectResultItem> projectList) {
		this.projectList = projectList;
	}

	@Override
	public String toString() {
		return "GetBasketProjectResultList [projectList=" + projectList + "]";
	}

}

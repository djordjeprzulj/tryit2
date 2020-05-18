package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNeedsCategoryProjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for needs subcat products list retrieved from database. Used in
 * pair with @GetNeedsCategoryProjectsNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetNeedsCategoryProjectsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetNeedsCategoryProjectsNCTResultItem> needsCatProjects;

	/**
	 * default constructor for Get Needs Category Projects NCT Result List
	 */
	public GetNeedsCategoryProjectsNCTResultList() {
		this.needsCatProjects = new ArrayList<GetNeedsCategoryProjectsNCTResultItem>();
	}

	/**
	 * Get Needs Category Projects NCT Result List
	 * 
	 * @param needsCatProjects
	 * 				Needs category projects
	 */
	public GetNeedsCategoryProjectsNCTResultList(List<GetNeedsCategoryProjectsNCTResultItem> needsCatProjects) {
		super();
		this.needsCatProjects = needsCatProjects;
	}

	public List<GetNeedsCategoryProjectsNCTResultItem> getNeedsCatProjects() {
		return needsCatProjects;
	}

	public void setNeedsCatProjects(List<GetNeedsCategoryProjectsNCTResultItem> needsCatProjects) {
		this.needsCatProjects = needsCatProjects;
	}

	@Override
	public String toString() {
		return "GetNeedsSubCatProductsNCTResultList [needsCatProjects=" + needsCatProjects + "]";
	}

}

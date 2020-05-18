package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getEntityByAdvisorId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.model.Entity;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetEntityByAdvisorIdItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private List<Entity> advisorEntityList;

	/**
	 * default constructor for Get Entity By Advisor Id Item List
	 */
	public GetEntityByAdvisorIdItemList() {
		super();
		this.advisorEntityList = new ArrayList<>();
	}

	/**
	 * Get Entity By Advisor Id Item List
	 * 
	 * @param advisorEntityList
	 * 				Advisor entity list
	 */
	public GetEntityByAdvisorIdItemList(List<Entity> advisorEntityList) {
		super();
		this.advisorEntityList = advisorEntityList;
	}

	/**
	 * @return the advisorEntityList
	 */
	public List<Entity> getAdvisorEntityList() {
		return advisorEntityList;
	}

	/**
	 * @param advisorEntityList
	 *            the advisorEntityList to set
	 */
	public void setAdvisorEntityList(List<Entity> advisorEntityList) {
		this.advisorEntityList = advisorEntityList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetEntityByAdvisorIdItemList [advisorEntityList=" + advisorEntityList + "]";
	}

}

package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNotIntReasons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author sasa.radovanovic
 *
 */
public class SANotIntReasonResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<SANotIntReasonItem> notIntReasonList;

	/**
	 * default constructor for Sales Assistant Not Interested Reason Result List
	 */
	public SANotIntReasonResultList() {
		super();
		this.notIntReasonList = new ArrayList<>();
	}

	/**
	 * Sales Assistant Not Interested Reason Result List
	 * 
	 * @param notIntReasonList
	 * 				Not interested reason list
	 */
	public SANotIntReasonResultList(List<SANotIntReasonItem> notIntReasonList) {
		super();
		this.notIntReasonList = notIntReasonList;
	}

	public List<SANotIntReasonItem> getNotIntReasonList() {
		return notIntReasonList;
	}

	public void setNotIntReasonList(List<SANotIntReasonItem> notIntReasonList) {
		this.notIntReasonList = notIntReasonList;
	}

	@Override
	public String toString() {
		return "SANotIntReasonResultList [notIntReasonList=" + notIntReasonList + "]";
	}

}

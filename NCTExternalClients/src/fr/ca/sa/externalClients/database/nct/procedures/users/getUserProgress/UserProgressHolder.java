package fr.ca.sa.externalClients.database.nct.procedures.users.getUserProgress;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class UserProgressHolder implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Double progress;

	/**
	 * default constructor for User Progress Holder
	 */
	public UserProgressHolder() {
		super();
	}

	/**
	 * User Progress Holder
	 * 
	 * @param progress
	 * 				Progress of user
	 */
	public UserProgressHolder(Double progress) {
		super();
		this.progress = progress;
	}

	public Double getProgress() {
		return progress;
	}

	public void setProgress(Double progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return "UserProgressHolder [progress=" + progress + "]";
	}

}

package fr.ca.sa.nct.commons.services.json.agenda;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.procedures.worktime.getWorktime.GetBankEntityWorkTimeNCTResultList;

/**
 * 
 * Return entity for retrieving specific entity work time NOTE: This entity will
 * hold both entity specific and entire bank worktime
 * 
 * @author Sasa Radovanovic
 *
 */
public class EntityWorkTimeInformationResponse implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetBankEntityWorkTimeNCTResultList> worktimes;

	/**
	 * default constructor for Entity WorkTime Information Response
	 */
	public EntityWorkTimeInformationResponse() {
		super();
	}

	/**
	 * Entity WorkTime Information Response
	 * 
	 * @param worktimes
	 * 				Work times
	 */
	public EntityWorkTimeInformationResponse(List<GetBankEntityWorkTimeNCTResultList> worktimes) {
		super();
		this.worktimes = worktimes;
	}

	public List<GetBankEntityWorkTimeNCTResultList> getWorktimes() {
		return worktimes;
	}

	public void setWorktimes(List<GetBankEntityWorkTimeNCTResultList> worktimes) {
		this.worktimes = worktimes;
	}

}

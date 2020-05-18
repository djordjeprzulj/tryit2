package fr.ca.sa.nct.commons.services.json.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * Request for audit data filtering
 * 
 * @author Nemanja Ignjatov
 *
 */
public class AuditDataRequest implements Target, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer entityId;

	private Integer advisorId;

	private int applicationId;

	private int transactionId;

	private Integer langCode;

	private String startTime;

	private String endTime;

	private ArrayList<TargetAction> taList = new ArrayList<>();

	/**
	 * default constructor for Audit Data Request
	 */
	public AuditDataRequest() {
		super();
	}

	/**
	 * Audit Data Request
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param applicationId
	 * 				Application ID
	 * 
	 * @param transactionId
	 * 				Transaction ID
	 * 
	 * @param langCode
	 * 				Language code
	 * 
	 * @param startTime
	 * 				Start time
	 * 
	 * @param endTime
	 * 				End time
	 */
	public AuditDataRequest(Integer entityId, Integer advisorId, Integer applicationId, Integer transactionId,
			Integer langCode, String startTime, String endTime) {
		super();
		this.entityId = entityId;
		this.advisorId = advisorId;
		this.applicationId = applicationId;
		this.transactionId = transactionId;
		this.langCode = langCode;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getLangCode() {
		return langCode;
	}

	public void setLangCode(Integer langCode) {
		this.langCode = langCode;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "AuditDataRequest [entityId=" + entityId + ", advisorId=" + advisorId + ", applicationId="
				+ applicationId + ", transactionId=" + transactionId + ", langCode=" + langCode + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		return taList;
	}

	@Override
	public void defineTargetActionObjects() {
	}

}

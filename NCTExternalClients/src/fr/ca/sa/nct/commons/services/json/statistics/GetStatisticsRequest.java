package fr.ca.sa.nct.commons.services.json.statistics;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * @author Stefan Djokic 
 *
 */
public class GetStatisticsRequest implements Target, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int entityId;
	private Integer advisorId;
	private String startDate;
	private String endDate;
	private int reportId;
	private Integer langId;

	private List<TargetAction> targetActionObjects;

	/**
	 * default constructor for Get Statistics Request
	 */
	public GetStatisticsRequest() {
		super();
	}

	/**
	 * Get Statistics Request
	 * 
	 * @param entityId
	 * 			Entity ID
	 * 
	 * @param advisorId
	 * 			Advisor ID
	 * 
	 * @param startDate
	 * 			Start date
	 * 
	 * @param endDate
	 * 			End date
	 * 
	 * @param reportId
	 * 			Report ID
	 * 
	 * @param langId
	 * 			Language ID
	 * 
	 * @param targetActionObjects
	 * 			Target action objects
	 */
	public GetStatisticsRequest(int entityId, Integer advisorId, String startDate, String endDate, int reportId,
			Integer langId, List<TargetAction> targetActionObjects) {
		super();
		this.entityId = entityId;
		this.advisorId = advisorId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reportId = reportId;
		this.langId = langId;
		this.targetActionObjects = targetActionObjects;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public Integer getLangId() {
		return langId;
	}

	public void setLangId(Integer langId) {
		this.langId = langId;
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		return targetActionObjects;
	}

	@Override
	public void defineTargetActionObjects() {
	}
}

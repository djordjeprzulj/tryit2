package fr.ca.sa.externalClients.database.common.procedures.worktime.setWorktime;

import java.io.Serializable;
import java.sql.Timestamp;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder for request in Set worktime operation
 * 
 * @author Sasa Radovanovic
 *
 */
public class SetWorktimeDataNCTRequest implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int userId;

	private Integer entityId;

	private int dayNumber;

	private Timestamp morningStart;

	private Timestamp morningEnd;

	private Timestamp afternoonStart;

	private Timestamp afternoonEnd;

	/**
	 * default constructor for Set Worktime Data NCT Request
	 */
	public SetWorktimeDataNCTRequest() {
		super();
	}

	/**
	 * Set Worktime Data NCT Request
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param dayNumber
	 * 				Day number
	 * 
	 * @param morningStart
	 * 				Morning shift start time
	 * 
	 * @param morningEnd
	 * 				Morning shift end time
	 * 
	 * @param afternoonStart
	 * 				Afternoon shift start time
	 * 
	 * @param afternoonEnd
	 * 				Afternoon shift end time
	 */
	public SetWorktimeDataNCTRequest(int userId, Integer entityId, int dayNumber, Timestamp morningStart,
			Timestamp morningEnd, Timestamp afternoonStart, Timestamp afternoonEnd) {
		super();
		this.userId = userId;
		this.entityId = entityId;
		this.dayNumber = dayNumber;
		this.morningStart = morningStart;
		this.morningEnd = morningEnd;
		this.afternoonStart = afternoonStart;
		this.afternoonEnd = afternoonEnd;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}

	public Timestamp getMorningStart() {
		return morningStart;
	}

	public void setMorningStart(Timestamp morningStart) {
		this.morningStart = morningStart;
	}

	public Timestamp getMorningEnd() {
		return morningEnd;
	}

	public void setMorningEnd(Timestamp morningEnd) {
		this.morningEnd = morningEnd;
	}

	public Timestamp getAfternoonStart() {
		return afternoonStart;
	}

	public void setAfternoonStart(Timestamp afternoonStart) {
		this.afternoonStart = afternoonStart;
	}

	public Timestamp getAfternoonEnd() {
		return afternoonEnd;
	}

	public void setAfternoonEnd(Timestamp afternoonEnd) {
		this.afternoonEnd = afternoonEnd;
	}

}

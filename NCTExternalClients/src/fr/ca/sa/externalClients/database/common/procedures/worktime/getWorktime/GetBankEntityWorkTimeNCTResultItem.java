package fr.ca.sa.externalClients.database.common.procedures.worktime.getWorktime;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Single Item in BankEntity worktime holder
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBankEntityWorkTimeNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int entityId;

	private String entityName;

	private int dayNumber;

	private String morningStart;

	private String morningEnd;

	private String afternoonStart;

	private String afternoonEnd;

	/**
	 * default constructor for Get Bank Entity WorkTime NCT Result Item
	 */
	public GetBankEntityWorkTimeNCTResultItem() {
		super();
	}

	/**
	 * Get Bank Entity WorkTime NCT Result Item
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param entityName
	 * 				Entity name
	 * 
	 * @param dayNumber
	 * 				Number of days
	 * 
	 * @param morningStart
	 * 				Morning shift start time
	 * 
	 * @param morningEnd
	 * 				Morning shift end time
	 * 
	 * @param afternoonEnd
	 * 				Afternoon shift end time
	 * 
	 * @param afternoonStart
	 * 				Afternoon shift start time
	 */
	public GetBankEntityWorkTimeNCTResultItem(int entityId, String entityName, int dayNumber, Timestamp morningStart,
			Timestamp morningEnd, Timestamp afternoonEnd, Timestamp afternoonStart) {
		super();
		this.entityId = entityId;
		this.entityName = entityName;
		this.dayNumber = dayNumber;
		DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.getBackboneWorktimeDatetimeFormat());
		if (morningStart != null) {
			this.morningStart = df.format(morningStart);
		}
		if (morningEnd != null) {
			this.morningEnd = df.format(morningEnd);
		}
		if (afternoonStart != null) {
			this.afternoonStart = df.format(afternoonStart);
		}
		if (afternoonEnd != null) {
			this.afternoonEnd = df.format(afternoonEnd);
		}
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}

	public String getMorningStart() {
		return morningStart;
	}

	public void setMorningStart(String morningStart) {
		this.morningStart = morningStart;
	}

	public String getMorningEnd() {
		return morningEnd;
	}

	public void setMorningEnd(String morningEnd) {
		this.morningEnd = morningEnd;
	}

	public String getAfternoonStart() {
		return afternoonStart;
	}

	public void setAfternoonStart(String afternoonStart) {
		this.afternoonStart = afternoonStart;
	}

	public String getAfternoonEnd() {
		return afternoonEnd;
	}

	public void setAfternoonEnd(String afternoonEnd) {
		this.afternoonEnd = afternoonEnd;
	}

	@Override
	public String toString() {
		return "GetBankEntityWorkTimeNCTResult [entityId=" + entityId + ", entityName=" + entityName + ", dayNumber="
				+ dayNumber + ", morningStart=" + morningStart + ", morningEnd=" + morningEnd + ", afternoonStart="
				+ afternoonStart + ", afternoonEnd=" + afternoonEnd + "]";
	}

}

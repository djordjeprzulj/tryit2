package fr.ca.sa.externalClients.database.nctManagement.procedures.nonWorkingDays.getBankNonWorkingDays;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetBankNonWorkingDaysNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int dayId;
	private String date;
	private String description;

	/**
	 * Get bank working days
	 * 
	 * @param dayId
	 * 				Day ID
	 * 
	 * @param date
	 * 				Date
	 * 
	 * @param description
	 * 				Description
	 */
	public GetBankNonWorkingDaysNCTResultItem(int dayId, Timestamp date, String description) {
		super();
		this.dayId = dayId;
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_ONLY_DATE_DATETIME_FORMAT);
		this.date = formatter.format(date);
		this.description = description;
	}

	public int getDayId() {
		return dayId;
	}

	public void setDayId(int dayId) {
		this.dayId = dayId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "NonWorkingDayNCTResultItem [dayId=" + dayId + ", date=" + date + ", description=" + description + "]";
	}

}

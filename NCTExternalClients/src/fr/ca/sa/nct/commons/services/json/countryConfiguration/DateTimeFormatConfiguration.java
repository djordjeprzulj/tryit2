package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response JSON wrapper for get date time formats
 * 
 * @author Nemanja Ignjatov
 *
 */
public class DateTimeFormatConfiguration implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String timeFormat;
	private String dateFormat;
	private String dateTimeFormat;

	/**
	 * default constructor for DateTime Format Configuration
	 */
	public DateTimeFormatConfiguration() {
		super();
	}

	/**
	 * DateTime Format Configuration
	 * 
	 * @param timeFormat	
	 * 				Time format
	 * 
	 * @param dateFormat
	 * 				Date format
	 * 
	 * @param dateTimeFormat
	 * 				Datetime format
	 */
	public DateTimeFormatConfiguration(String timeFormat, String dateFormat, String dateTimeFormat) {
		super();
		this.timeFormat = timeFormat;
		this.dateFormat = dateFormat;
		this.dateTimeFormat = dateTimeFormat;
	}

	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}

	@Override
	public String toString() {
		return "DateTimeFormatConfiguration [timeFormat=" + timeFormat + ", dateFormat=" + dateFormat
				+ ", dateTimeFormat=" + dateTimeFormat + "]";
	}

}

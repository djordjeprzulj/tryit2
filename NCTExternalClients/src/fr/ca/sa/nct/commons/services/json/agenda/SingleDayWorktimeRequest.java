package fr.ca.sa.nct.commons.services.json.agenda;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single day worktime request, used in pair with @SetWorktimeRequest
 * 
 * @author Sasa Radovanovic
 *
 */
public class SingleDayWorktimeRequest implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String firstShiftFromTime;

	private String firstShiftToTime;

	private String secondShiftFromTime;

	private String secondShiftToTime;

	private int dayNumber;

	/**
	 * default constructor for Single Day Worktime Request
	 */
	public SingleDayWorktimeRequest() {
		super();
	}

	/**
	 * Single Day Worktime Request
	 * 
	 * @param firstShiftFromTime
	 * 				First shift start time
	 * 
	 * @param firstShiftToTime
	 * 				First shift end time
	 * 
	 * @param secondShiftFromTime
	 * 				Second shift start time
	 * 
	 * @param secondShiftToTime
	 * 				Second shift end time
	 * 
	 * @param dayNumber
	 * 				Number of workdays
	 */
	public SingleDayWorktimeRequest(String firstShiftFromTime, String firstShiftToTime, String secondShiftFromTime,
			String secondShiftToTime, int dayNumber) {
		super();
		this.firstShiftFromTime = firstShiftFromTime;
		this.firstShiftToTime = firstShiftToTime;
		this.secondShiftFromTime = secondShiftFromTime;
		this.secondShiftToTime = secondShiftToTime;
		this.dayNumber = dayNumber;
	}

	public String getFirstShiftFromTime() {
		return firstShiftFromTime;
	}

	public void setFirstShiftFromTime(String firstShiftFromTime) {
		this.firstShiftFromTime = firstShiftFromTime;
	}

	public String getFirstShiftToTime() {
		return firstShiftToTime;
	}

	public void setFirstShiftToTime(String firstShiftToTime) {
		this.firstShiftToTime = firstShiftToTime;
	}

	public String getSecondShiftFromTime() {
		return secondShiftFromTime;
	}

	public void setSecondShiftFromTime(String secondShiftFromTime) {
		this.secondShiftFromTime = secondShiftFromTime;
	}

	public String getSecondShiftToTime() {
		return secondShiftToTime;
	}

	public void setSecondShiftToTime(String secondShiftToTime) {
		this.secondShiftToTime = secondShiftToTime;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}

	@Override
	public String toString() {
		return "SingleDayWorktimeRequest [firstShiftFromTime=" + firstShiftFromTime + ", firstShiftToTime="
				+ firstShiftToTime + ", secondShiftFromTime=" + secondShiftFromTime + ", secondShiftToTime="
				+ secondShiftToTime + ", dayNumber=" + dayNumber + "]";
	}
}

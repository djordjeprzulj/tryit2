package fr.ca.sa.externalClients.database.nctManagement.procedures.nonWorkingDays.setBankNonWorkingDays;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class SetBankNonWorkingDaysNCTResultItem implements StoreProcedureResult {

	private int dayId;

	/**
	 * default constructor for Set Bank NonWorking Days NCT Result Item
	 */
	public SetBankNonWorkingDaysNCTResultItem() {
		super();
	}

	/**
	 * Set Bank NonWorking Days NCT Result Item
	 * 
	 * @param dayId
	 * 				Day ID
	 */
	public SetBankNonWorkingDaysNCTResultItem(int dayId) {
		super();
		this.dayId = dayId;
	}

	public int getDayId() {
		return dayId;
	}

	public void setDayId(int dayId) {
		this.dayId = dayId;
	}

	@Override
	public String toString() {
		return "SetBankNonWorkingDaysResultItem [dayId=" + dayId + "]";
	}

}

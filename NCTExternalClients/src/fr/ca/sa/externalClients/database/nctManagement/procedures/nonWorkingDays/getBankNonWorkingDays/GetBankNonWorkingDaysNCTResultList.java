package fr.ca.sa.externalClients.database.nctManagement.procedures.nonWorkingDays.getBankNonWorkingDays;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetBankNonWorkingDaysNCTResultList implements StoreProcedureResult {

	private List<GetBankNonWorkingDaysNCTResultItem> nonWorkingDays;

	/**
	 * default constructor for Get Bank NonWorking Days NCT Result List
	 */
	public GetBankNonWorkingDaysNCTResultList() {
		super();
		this.nonWorkingDays = new ArrayList<GetBankNonWorkingDaysNCTResultItem>();
	}

	public List<GetBankNonWorkingDaysNCTResultItem> getNonWorkingDays() {
		return nonWorkingDays;
	}

	public void setNonWorkingDays(List<GetBankNonWorkingDaysNCTResultItem> nonWorkingDays) {
		this.nonWorkingDays = nonWorkingDays;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("NonWorkingDayNCTResultList [ ");
		if (this.nonWorkingDays != null) {
			for (GetBankNonWorkingDaysNCTResultItem day : this.nonWorkingDays) {
				sbRetValue.append(day.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "NonWorkingDayNCTResultList is empty!!!";
	}
}

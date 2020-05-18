package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.workingDays;

import java.io.Serializable;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NonWorkingDaysList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<String> nonWorking;

	/**
	 * default constructor for NonWorking Days List
	 */
	public NonWorkingDaysList() {
		super();
		nonWorking = new ArrayList<>();
	}

	/**
	 * NonWorking Days List
	 * 
	 * @param nonWorkingTSs
	 * 				Non working days time stamps
	 */
	public NonWorkingDaysList(List<Timestamp> nonWorkingTSs) {
		super();
		this.nonWorking = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.getBackboneOnlyDateDatetimeFormat());
		nonWorkingTSs.forEach(ts -> {
			this.nonWorking.add(formatter.format(ts));
		});
	}

	public List<String> getNonWorking() {
		return nonWorking;
	}

	public void setNonWorking(List<String> nonWorking) {
		this.nonWorking = nonWorking;
	}

	@Override
	public String toString() {
		return "NonWorkingDaysList [nonWorking=" + nonWorking + "]";
	}
}

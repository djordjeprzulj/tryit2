package fr.ca.sa.externalClients.database.common.procedures.worktime.getWorktime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Result list for Bank Entity worktime store procedure
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBankEntityWorkTimeNCTResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int entityId;

	private String entityName;

	private List<GetBankEntityWorkTimeNCTResultItem> dayList;

	private List<String> nonWorkingDays = new ArrayList<>();

	/**
	 * default constructor for Get Bank Entity WorkTime NCT Result List
	 */
	public GetBankEntityWorkTimeNCTResultList() {
		super();
		this.dayList = new ArrayList<>();
	}

	/**
	 * Get Bank Entity WorkTime NCT Result List
	 * 
	 * @param dayList
	 * 				Day list
	 */
	public GetBankEntityWorkTimeNCTResultList(List<GetBankEntityWorkTimeNCTResultItem> dayList) {
		super();
		this.dayList = dayList;
	}

	public List<GetBankEntityWorkTimeNCTResultItem> getDayList() {
		return dayList;
	}

	public void setDayList(List<GetBankEntityWorkTimeNCTResultItem> dayList) {
		this.dayList = dayList;
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

	public List<String> getNonWorkingDays() {
		return nonWorkingDays;
	}

	public void setNonWorkingDays(List<String> nonWorkingDays) {
		this.nonWorkingDays = nonWorkingDays;
	}

	@Override
	public String toString() {
		return "GetBankEntityWorkTimeNCTResultList [entityId=" + entityId + ", entityName=" + entityName + ", dayList="
				+ dayList + ", nonWorkingDays=" + nonWorkingDays + "]";
	}

}

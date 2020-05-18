package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityDetails;

import java.io.Serializable;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Milos Topalovic
 *
 */
public class GetOpportunityDetailsNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String optDescription;
	private String spd;
	private Integer cancel;
	private Integer treatOL;
	private Integer treatQCR;
	private String opportSubCatNameL1;
	private String opportSubCatNameL2;
	private String opportStartDate;
	private String opportExpirationDate;
	private Map<String, String> subcategoryNames;

	/**
	 * default constructor for Get Opportunity Details NCT Result Item
	 */
	public GetOpportunityDetailsNCTResultItem() {
		super();
	}

	

	/**
	 * Get Opportunity Details NCT Result Item
	 * 
	 * @param optDescription
	 * 				Opportunity description
	 * 
	 * @param spd
	 * 				SPD
	 * 
	 * @param cancel
	 * 				Cancel
	 * 
	 * @param treatOL
	 * 				Treat on opportunity list
	 * 
	 * @param treatQCR
	 * 				Treat on quick contact report
	 * 
	 * @param opportSubCatNameL1
	 * 				Opportunity subcategory name in first language
	 * 
	 * @param opportSubCatNameL2
	 * 				Opportunity subcategory name in second language
	 * 
	 * @param opportStartDate
	 * 				Opportunity start date
	 * 
	 * @param opportExpirationDate
	 * 				Opportunity expiration date
	 * 
	 * @param subcategoryNames
	 * 				Subcategory names
	 */
	public GetOpportunityDetailsNCTResultItem(String optDescription, String spd, Integer cancel, Integer treatOL,
			Integer treatQCR, String opportSubCatNameL1, String opportSubCatNameL2, String opportStartDate,
			String opportExpirationDate, Map<String, String> subcategoryNames) {
		super();
		this.optDescription = optDescription;
		this.spd = spd;
		this.cancel = cancel;
		this.treatOL = treatOL;
		this.treatQCR = treatQCR;
		this.opportSubCatNameL1 = opportSubCatNameL1;
		this.opportSubCatNameL2 = opportSubCatNameL2;
		this.opportStartDate = opportStartDate;
		this.opportExpirationDate = opportExpirationDate;
		this.subcategoryNames = subcategoryNames;
	}



	public String getOptDescription() {
		return optDescription;
	}

	public void setOptDescription(String optDescription) {
		this.optDescription = optDescription;
	}

	public String getSpd() {
		return spd;
	}

	public void setSpd(String spd) {
		this.spd = spd;
	}

	public Integer getCancel() {
		return cancel;
	}

	public void setCancel(Integer cancel) {
		this.cancel = cancel;
	}

	public Integer getTreatOL() {
		return treatOL;
	}

	public void setTreatOL(Integer treatOL) {
		this.treatOL = treatOL;
	}

	public Integer getTreatQCR() {
		return treatQCR;
	}

	public void setTreatQCR(Integer treatQCR) {
		this.treatQCR = treatQCR;
	}

	public String getOpportSubCatNameL1() {
		return opportSubCatNameL1;
	}

	public void setOpportSubCatNameL1(String opportSubCatNameL1) {
		this.opportSubCatNameL1 = opportSubCatNameL1;
	}

	public String getOpportSubCatNameL2() {
		return opportSubCatNameL2;
	}

	public void setOpportSubCatNameL2(String opportSubCatNameL2) {
		this.opportSubCatNameL2 = opportSubCatNameL2;
	}

	public String getOpportStartDate() {
		return opportStartDate;
	}

	public void setOpportStartDate(String opportStartDate) {
		this.opportStartDate = opportStartDate;
	}

	public String getOpportExpirationDate() {
		return opportExpirationDate;
	}

	public void setOpportExpirationDate(String opportExpirationDate) {
		this.opportExpirationDate = opportExpirationDate;
	}

	public Map<String, String> getSubcategoryNames() {
		return subcategoryNames;
	}

	public void setSubcategoryNames(Map<String, String> subcategoryNames) {
		this.subcategoryNames = subcategoryNames;
	}



	@Override
	public String toString() {
		return "GetOpportunityDetailsNCTResultItem [optDescription=" + optDescription + ", spd=" + spd + ", cancel="
				+ cancel + ", treatOL=" + treatOL + ", treatQCR=" + treatQCR + ", opportSubCatName_L1="
				+ opportSubCatNameL1 + ", opportSubCatName_L2=" + opportSubCatNameL2 + ", opportStartDate="
				+ opportStartDate + ", opportExpirationDate=" + opportExpirationDate + ", subcategoryNames="
				+ subcategoryNames + "]";
	}
	

}

package fr.ca.sa.externalClients.database.nct.procedures.reports.getExcelTestData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetExcelTestDataList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetExcelTestDataItem> templateList;

	/**
	 * default constructor for Get Excel Test Data List
	 */
	public GetExcelTestDataList() {
		super();
		this.templateList = new ArrayList<>();
	}

	/**
	 * Get Excel Test Data List
	 * 
	 * @param templateList
	 * 				Template list
	 */
	public GetExcelTestDataList(List<GetExcelTestDataItem> templateList) {
		super();
		this.templateList = templateList;
	}

	public List<GetExcelTestDataItem> getTemplateList() {
		return templateList;
	}

	public void setTemplateList(List<GetExcelTestDataItem> templateList) {
		this.templateList = templateList;
	}

	@Override
	public String toString() {
		return "GetExcelTestDataList";
	}

}

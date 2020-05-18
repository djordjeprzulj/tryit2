package fr.ca.sa.externalClients.database.nct.procedures.quickContact.getQCRTemplates;

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
public class QuickContactReportTemplateItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<QuickContactReportTemplateItem> templateList;

	/**
	 * default constructor for Quick Contact Report Template Item List
	 */
	public QuickContactReportTemplateItemList() {
		super();
		this.templateList = new ArrayList<>();
	}

	/**
	 * Quick Contact Report Template Item List
	 * 
	 * @param templateList
	 * 				Template list
	 */
	public QuickContactReportTemplateItemList(List<QuickContactReportTemplateItem> templateList) {
		super();
		this.templateList = templateList;
	}

	public List<QuickContactReportTemplateItem> getTemplateList() {
		return templateList;
	}

	public void setTemplateList(List<QuickContactReportTemplateItem> templateList) {
		this.templateList = templateList;
	}

	@Override
	public String toString() {
		return "QuickContactTemplateItemList [templateList=" + templateList + "]";
	}

}

package fr.ca.sa.externalClients.database.nct.procedures.quickContact.getQCRTemplates;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class QuickContactReportTemplateItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer templateId;
	private String templateName;
	private String templateTxt;
	private int messageTemplateTypeId;
	private Integer readOnly;
	/**
	 * default constructor for Quick Contact Report Template Item
	 */
	public QuickContactReportTemplateItem() {
		super();
	}

	/**
	 * Quick Contact Report Template Item
	 * 
	 * @param templateId
	 * 				Template ID
	 * 
	 * @param templateName
	 * 				Template name
	 * 
	 * @param templateTxt
	 * 				Template text
	 * 
	 * @param messageTemplateTypeId
	 * 				Message template type ID
	 * 
	 * @param readOnly
	 * 				If QCR template is read only
	 */
	public QuickContactReportTemplateItem(Integer templateId, String templateName, String templateTxt,
			int messageTemplateTypeId,Integer readOnly) {
		super();
		this.templateId = templateId;
		this.templateName = templateName;
		this.templateTxt = templateTxt;
		this.messageTemplateTypeId = messageTemplateTypeId;
		this.readOnly=readOnly;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateTxt() {
		return templateTxt;
	}

	public void setTemplateTxt(String templateTxt) {
		this.templateTxt = templateTxt;
	}

	public int getMessageTemplateTypeId() {
		return messageTemplateTypeId;
	}

	public void setMessageTemplateTypeId(int messageTemplateTypeId) {
		this.messageTemplateTypeId = messageTemplateTypeId;
	}

	/**
	 * @return the readOnly
	 */
	public Integer getReadOnly() {
		return readOnly;
	}

	/**
	 * @param readOnly the readOnly to set
	 */
	public void setReadOnly(Integer readOnly) {
		this.readOnly = readOnly;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuickContactReportTemplateItem [templateId=" + templateId + ", templateName=" + templateName
				+ ", templateTxt=" + templateTxt + ", messageTemplateTypeId=" + messageTemplateTypeId + ", readOnly="
				+ readOnly + "]";
	}

	

}

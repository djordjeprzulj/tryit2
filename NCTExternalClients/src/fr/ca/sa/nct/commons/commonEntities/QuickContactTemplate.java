package fr.ca.sa.nct.commons.commonEntities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class QuickContactTemplate implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer templateId;
	private int messageTypeId;
	private Integer readOnly;
	private Map<String, HashMap<String, String>> content;

	/**
	 * default constructor for Quick Contact Template
	 */
	public QuickContactTemplate() {
		super();
		this.content = new HashMap<>();
	}

	/**
	 * Quick Contact Template
	 * 
	 * @param readOnly
	 * 				Read only property for template
	 * 			
	 * @param templateId
	 * 				Template ID
	 * 
	 * @param messageTypeId
	 * 				Message type ID
	 * 
	 * @param content
	 * 				Content
	 */
	public QuickContactTemplate(Integer templateId, int messageTypeId,
			Map<String, HashMap<String, String>> content,Integer readOnly) {
		super();
		this.templateId = templateId;
		this.messageTypeId = messageTypeId;
		this.content = content;
		this.readOnly=readOnly;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public int getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(int messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public Map<String, HashMap<String, String>> getContent() {
		return content;
	}

	public void setContent(Map<String, HashMap<String, String>> content) {
		this.content = content;
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
	

}

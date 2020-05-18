package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaAttrsByType;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Retrieve agenda element attributes by type, single item
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetAgendaElementAttrsByTypeItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer elementTypeId;

	private String elementTypeName;

	private Integer fieldId;

	private String fieldName;

	private String fieldAliasName;

	private String description;

	private Integer isVisible;

	private Integer isMandatory;

	private String defaultValue;

	/**
	 * default constructor for Get Agenda Element Attributes By Type Item
	 */
	public GetAgendaElementAttrsByTypeItem() {
		super();
	}

	/**
	 * Get Agenda Element Attributes By Type Item
	 * 
	 * @param elementTypeId
	 * 				Element type ID
	 * 
	 * @param elementTypeName
	 * 				Element type name
	 * 
	 * @param fieldId
	 * 				Field ID
	 * 
	 * @param fieldName
	 * 				Field name
	 * 
	 * @param fieldAliasName
	 * 				Field alias name
	 * 
	 * @param description
	 * 				Description
	 * 
	 * @param isVisible
	 * 				Is element visible
	 * 
	 * @param isMandatory
	 * 				Is element mandatory
	 * 
	 * @param defaultValue
	 * 				Default value
	 */
	public GetAgendaElementAttrsByTypeItem(Integer elementTypeId, String elementTypeName, Integer fieldId,
			String fieldName, String fieldAliasName, String description, Integer isVisible, Integer isMandatory,
			String defaultValue) {
		super();
		this.elementTypeId = elementTypeId;
		this.elementTypeName = elementTypeName;
		this.fieldId = fieldId;
		this.fieldName = fieldName;
		this.fieldAliasName = fieldAliasName;
		this.description = description;
		this.isVisible = isVisible;
		this.isMandatory = isMandatory;
		this.defaultValue = defaultValue;
	}

	public String getElementTypeName() {
		return elementTypeName;
	}

	public void setElementTypeName(String elementTypeName) {
		this.elementTypeName = elementTypeName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldAliasName() {
		return fieldAliasName;
	}

	public void setFieldAliasName(String fieldAliasName) {
		this.fieldAliasName = fieldAliasName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getElementTypeId() {
		return elementTypeId;
	}

	public void setElementTypeId(Integer elementTypeId) {
		this.elementTypeId = elementTypeId;
	}

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public Integer getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}

	public Integer getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Integer isMandatory) {
		this.isMandatory = isMandatory;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public String toString() {
		return "GetAgendaElementAttrsByTypeItem [elementTypeId=" + elementTypeId + ", elementTypeName="
				+ elementTypeName + ", fieldId=" + fieldId + ", fieldName=" + fieldName + ", fieldAliasName="
				+ fieldAliasName + ", description=" + description + ", isVisible=" + isVisible + ", isMandatory="
				+ isMandatory + ", defaultValue=" + defaultValue + "]";
	}

}

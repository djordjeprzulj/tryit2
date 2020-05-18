package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class SetCodeTableMessageTemplateRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer id;
	private Integer typeId;
	private String nameL1;
	private String nameL2;
	private String textL1;
	private String textL2;
	private boolean readOnly;
	private boolean active;

	/**
	 * default constructor for Set Code Table Message Template Request
	 */
	public SetCodeTableMessageTemplateRequest() {
		super();
	}

	/**
	 * Set Code Table Message Template Request
	 * 
	 * @param id
	 * 				ID
	 * 
	 * @param typeId
	 * 				Type ID
	 * 
	 * @param nameL1
	 * 				Name in first language
	 * 
	 * @param nameL2
	 * 				Name in second language
	 * 
	 * @param textL1
	 * 				Text in first language
	 * 
	 * @param textL2
	 * 				Text in second language
	 * 
	 * @param readOnly
	 * 				Read only property
	 * 
	 * @param active
	 * 				Activity
	 */
	public SetCodeTableMessageTemplateRequest(Integer id, Integer typeId, String nameL1, String nameL2, String textL1, String textL2,
			boolean readOnly, boolean active) {
		super();
		this.id = id;
		this.typeId=typeId;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.textL1 = textL1;
		this.textL2 = textL2;
		this.readOnly = readOnly;
		this.active = active;
	}

	/**
	 * Set Code Table Message Template Request
	 * 
	 * @param update
	 * 				Update request
	 */
	public SetCodeTableMessageTemplateRequest(MessageTemplateCodeTableUpdateRequest update) {
		super();
		this.id = update.getId();
		this.typeId = update.getTypeId();
		this.nameL1 = update.getNameL1();
		this.nameL2 = update.getNameL2();
		this.textL1 = update.getTextL1();
		this.textL2 = update.getTextL2();
		this.readOnly = update.getIsReadOnly();
		this.active = update.getActive();
	}

	/**
	 * Set Code Table Message Template Request
	 * 
	 * @param insert
	 * 				Insert request
	 */
	public SetCodeTableMessageTemplateRequest(MessageTemplateCodeTableInsertRequest insert) {
		super();
		this.id = null;
		this.typeId=insert.getTypeId();
		this.nameL1 = insert.getNameL1();
		this.nameL2 = insert.getNameL2();
		this.textL1 = insert.getTextL1();
		this.textL2 = insert.getTextL2();
		this.readOnly = insert.getIsReadOnly();
		this.active = insert.getActive();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameL1() {
		return nameL1;
	}

	public void setNameL1(String nameL1) {
		this.nameL1 = nameL1;
	}

	public String getNameL2() {
		return nameL2;
	}

	public void setNameL2(String nameL2) {
		this.nameL2 = nameL2;
	}

	public String getTextL1() {
		return textL1;
	}

	public void setTextL1(String textL1) {
		this.textL1 = textL1;
	}

	public String getTextL2() {
		return textL2;
	}

	public void setTextL2(String textL2) {
		this.textL2 = textL2;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean isReadOnly) {
		this.readOnly = isReadOnly;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SetCodeTableMessageTemplateRequest [id=" + id + ", typeId=" + typeId + ", nameL1=" + nameL1
				+ ", nameL2=" + nameL2 + ", textL1=" + textL1 + ", textL2=" + textL2 + ", readOnly=" + readOnly
				+ ", active=" + active + "]";
	}


}

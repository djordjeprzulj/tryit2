package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class MessageTemplateCodeTableUpdateRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int id;
	private Integer typeId;
	private String nameL1;
	private String nameL2;
	private String textL1;
	private String textL2;
	private boolean isReadOnly;
	private boolean active;

	/**
	 * default constructor for Message Template CodeTable Update Request
	 */
	public MessageTemplateCodeTableUpdateRequest() {
		super();
	}

	/**
	 * Message Template CodeTable Update Request
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
	 * @param isReadOnly
	 * 				If it's read only
	 * 
	 * @param active
	 * 				Active
	 */
	public MessageTemplateCodeTableUpdateRequest(int id,Integer typeId, String nameL1, String nameL2, String textL1, String textL2,
			boolean isReadOnly, boolean active) {
		super();
		this.id = id;
		this.typeId=typeId;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.textL1 = textL1;
		this.textL2 = textL2;
		this.isReadOnly = isReadOnly;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public boolean getIsReadOnly() {
		return isReadOnly;
	}

	public void setIsReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	public boolean getActive() {
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
		return "MessageTemplateCodeTableUpdateRequest [id=" + id + ", typeId=" + typeId + ", nameL1=" + nameL1
				+ ", nameL2=" + nameL2 + ", textL1=" + textL1 + ", textL2=" + textL2 + ", isReadOnly=" + isReadOnly
				+ ", active=" + active + "]";
	}

	
}

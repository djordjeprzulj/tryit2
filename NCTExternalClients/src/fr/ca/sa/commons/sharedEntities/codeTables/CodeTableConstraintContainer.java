package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CodeTableConstraintContainer implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String dataType;
	private int maxLength;
	private boolean required;

	/**
	 * default constructor for CodeTable Constraint Container
	 */
	public CodeTableConstraintContainer() {
		super();
	}

	/**
	 * CodeTable Constraint Container
	 * 
	 * @param dataType
	 * 				Data type
	 * 
	 * @param maxLength
	 * 				Max length
	 * 
	 * @param required
	 * 				Required
	 */
	public CodeTableConstraintContainer(String dataType, int maxLength, boolean required) {
		super();
		this.dataType = dataType;
		this.maxLength = maxLength;
		this.required = required;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	@Override
	public String toString() {
		return "CodeTableValueConstraintContainer [dataType=" + dataType + ", maxLength=" + maxLength + ", required="
				+ required + "]";
	}

}

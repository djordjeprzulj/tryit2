package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CompetitorCodeTableInsertRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String name;
	private boolean active;

	/**
	 * default constructor for Competitor CodeTable Insert Request
	 */
	public CompetitorCodeTableInsertRequest() {
		super();
	}

	/**
	 * Competitor CodeTable Insert Request
	 * 
	 * @param name
	 * 				Name 
	 * 
	 * @param active
	 * 				Active
	 */
	public CompetitorCodeTableInsertRequest(String name, boolean active) {
		super();
		this.name = name;
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "CompetitorCodeTableInsertRequest [name=" + name + ", active=" + active + "]";
	}

}

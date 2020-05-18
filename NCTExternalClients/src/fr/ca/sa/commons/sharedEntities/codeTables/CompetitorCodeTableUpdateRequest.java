package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CompetitorCodeTableUpdateRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int id;
	private String name;
	private boolean active;

	/**
	 * default constructor for Competitor CodeTable Update Request
	 */
	public CompetitorCodeTableUpdateRequest() {
		super();
	}

	/**
	 * Competitor CodeTable Update Request
	 * 
	 * @param id
	 * 				ID
	 * 
	 * @param name
	 * 				Name
	 * 
	 * @param active
	 * 				Active
	 */
	public CompetitorCodeTableUpdateRequest(int id, String name, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "CompetitorCodeTableUpdateRequest [id=" + id + ", name=" + name + ", active=" + active + "]";
	}

}

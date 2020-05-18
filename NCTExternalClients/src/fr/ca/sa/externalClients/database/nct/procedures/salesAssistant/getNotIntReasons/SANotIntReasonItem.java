package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNotIntReasons;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author sasa.radovanovic
 *
 */
public class SANotIntReasonItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer id;

	private String name;

	/**
	 * default constructor for Sales Assistant Not Interested Reason Item
	 */
	public SANotIntReasonItem() {
		super();
	}

	/**
	 * Sales Assistant Not Interested Reason Item
	 * 
	 * @param id
	 * 				ID
	 * @param name
	 * 				Name
	 */
	public SANotIntReasonItem(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SANotIntReasonItem [id=" + id + ", name=" + name + "]";
	}

}

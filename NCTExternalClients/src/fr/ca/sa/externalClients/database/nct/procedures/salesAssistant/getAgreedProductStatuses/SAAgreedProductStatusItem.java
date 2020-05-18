package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getAgreedProductStatuses;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class SAAgreedProductStatusItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer id;

	private String name;

	/**
	 * default constructor for Sales Assistant Agreed Product Status Item
	 */
	public SAAgreedProductStatusItem() {
		super();
	}

	/**
	 * Sales Assistant Agreed Product Status Item
	 * 
	 * @param id
	 * 				ID
	 * 
	 * @param name
	 * 				Name
	 */
	public SAAgreedProductStatusItem(Integer id, String name) {
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
		return "SAAgreedProductStatusItem [id=" + id + ", name=" + name + "]";
	}

}

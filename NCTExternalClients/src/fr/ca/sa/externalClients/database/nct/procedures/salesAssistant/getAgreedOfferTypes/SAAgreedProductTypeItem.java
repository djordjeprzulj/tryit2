package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getAgreedOfferTypes;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class SAAgreedProductTypeItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer id;

	private String name;

	/**
	 * default constructor for Sales Assistant Agreed Product Type Item
	 */
	public SAAgreedProductTypeItem() {
		super();
	}

	/**
	 * Sales Assistant Agreed Product Type Item
	 * 
	 * @param id
	 * 				ID
	 * 
	 * @param name
	 * 				Name
	 */
	public SAAgreedProductTypeItem(Integer id, String name) {
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
		return "SAAgreedProductTypeItem [id=" + id + ", name=" + name + "]";
	}

}

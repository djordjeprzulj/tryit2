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
public class TranslatableElementConf implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int id;

	private Map<String, String> names;

	/**
	 * default constructor for Translatable Element Configuration
	 */
	public TranslatableElementConf() {
		super();
		this.names = new HashMap<String, String>();
	}

	/**
	 * Translatable Element Configuration
	 * 
	 * @param id
	 * 				ID
	 * 
	 * @param names
	 * 				Names
	 */
	public TranslatableElementConf(int id, Map<String, String> names) {
		super();
		this.id = id;
		this.names = names;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, String> getNames() {
		return names;
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

}

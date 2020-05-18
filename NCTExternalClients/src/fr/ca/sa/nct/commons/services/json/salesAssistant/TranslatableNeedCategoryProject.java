package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TranslatableNeedCategoryProject implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int projectCategoryId;
	private Map<String, String> names;

	/**
	 * default constructor for Translatable Need Category Project
	 */
	public TranslatableNeedCategoryProject() {
		super();
		this.names = new HashMap<String, String>();
	}

	/**
	 * Translatable Need Category Project
	 * 
	 * @param projectCategoryId
	 * 				Project category ID
	 */
	public TranslatableNeedCategoryProject(int projectCategoryId) {
		super();
		this.projectCategoryId = projectCategoryId;
		this.names = new HashMap<String, String>();
	}

	/**
	 * Translatable Need Category Project
	 * 
	 * @param projectCategoryId
	 * 				Project category ID
	 * 
	 * @param names
	 * 				Names
	 */
	public TranslatableNeedCategoryProject(int projectCategoryId, Map<String, String> names) {
		super();
		this.projectCategoryId = projectCategoryId;
		this.names = names;
	}

	public int getProjectCategoryId() {
		return projectCategoryId;
	}

	public void setProjectCategoryId(int projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}

	public Map<String, String> getNames() {
		return names;
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

}

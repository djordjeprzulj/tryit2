package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TranslatableNeedCategory implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int needCategoryId;
	private String needCategoryPicture;
	private String needCategoryIcon;
	private Map<String, String> needCategoryLongDescription;
	private String needCategoryTipsLink;
	private Map<String, String> needCategoryTipsDesc;
	private String needCategorySimulatorLink;

	private Map<String, String> names;

	private List<TranslatableNeedCategoryProject> projects;

	/**
	 * default constructor for Translatable Need Category
	 */
	public TranslatableNeedCategory() {
		super();
	}

	/**
	 * Translatable Need Category
	 * 
	 * @param needCategoryId
	 * 				Need Category ID
	 * 
	 * @param needCategoryPicture
	 * 				Need Category picture
	 * 
	 * @param needCategoryLongDescription
	 * 				Need Category long description
	 * 
	 * @param needCategoryTipsLink
	 * 				Need Category tips link
	 * 
	 * @param needCategoryTipsDesc
	 * 				Need Category tips description
	 * 
	 * @param needCategorySimulatorLink
	 * 				Need Category simulator link
	 * 
	 * @param names
	 * 				Names
	 * 
	 * @param needCategoryIcon
	 * 				Need Category icon
	 */
	public TranslatableNeedCategory(int needCategoryId, String needCategoryPicture,
			Map<String, String> needCategoryLongDescription, String needCategoryTipsLink,
			Map<String, String> needCategoryTipsDesc, String needCategorySimulatorLink,
			Map<String, String> names, String needCategoryIcon) {
		super();
		this.needCategoryId = needCategoryId;
		this.needCategoryPicture = needCategoryPicture;
		this.needCategoryLongDescription = needCategoryLongDescription;
		this.needCategoryTipsLink = needCategoryTipsLink;
		this.needCategoryTipsDesc = needCategoryTipsDesc;
		this.needCategorySimulatorLink = needCategorySimulatorLink;
		this.names = names;
		this.needCategoryIcon = needCategoryIcon;

		this.projects = new ArrayList<TranslatableNeedCategoryProject>();
	}

	public int getNeedCategoryId() {
		return needCategoryId;
	}

	public void setNeedCategoryId(int needCategoryId) {
		this.needCategoryId = needCategoryId;
	}

	public String getNeedCategoryPicture() {
		return needCategoryPicture;
	}

	public void setNeedCategoryPicture(String needCategoryPicture) {
		this.needCategoryPicture = needCategoryPicture;
	}

	public String getNeedCategoryTipsLink() {
		return needCategoryTipsLink;
	}

	public void setNeedCategoryTipsLink(String needCategoryTipsLink) {
		this.needCategoryTipsLink = needCategoryTipsLink;
	}

	public String getNeedCategorySimulatorLink() {
		return needCategorySimulatorLink;
	}

	public void setNeedCategorySimulatorLink(String needCategorySimulatorLink) {
		this.needCategorySimulatorLink = needCategorySimulatorLink;
	}

	public Map<String, String> getNames() {
		return names;
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

	public List<TranslatableNeedCategoryProject> getProjects() {
		return projects;
	}

	public void setProjects(List<TranslatableNeedCategoryProject> projects) {
		this.projects = projects;
	}

	public Map<String, String> getNeedCategoryLongDescription() {
		return needCategoryLongDescription;
	}

	public void setNeedCategoryLongDescription(Map<String, String> needCategoryLongDescription) {
		this.needCategoryLongDescription = needCategoryLongDescription;
	}

	public Map<String, String> getNeedCategoryTipsDesc() {
		return needCategoryTipsDesc;
	}

	public void setNeedCategoryTipsDesc(Map<String, String> needCategoryTipsDesc) {
		this.needCategoryTipsDesc = needCategoryTipsDesc;
	}

	public String getNeedCategoryIcon() {
		return needCategoryIcon;
	}

	public void setNeedCategoryIcon(String needCategoryIcon) {
		this.needCategoryIcon = needCategoryIcon;
	}

}

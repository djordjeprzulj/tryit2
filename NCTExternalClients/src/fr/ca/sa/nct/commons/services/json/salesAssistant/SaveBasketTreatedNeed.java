package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder for partial request
 * 
 * @author Sasa Radovanovic
 *
 */
public class SaveBasketTreatedNeed implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<Integer> treatedNeeds;

	/**
	 * default constructor for Save Basket Treated Need
	 */
	public SaveBasketTreatedNeed() {
		super();
	}

	/**
	 * Save Basket Treated Need
	 * 
	 * @param treatedNeeds
	 * 				Treated needs
	 */
	public SaveBasketTreatedNeed(List<Integer> treatedNeeds) {
		super();
		this.treatedNeeds = treatedNeeds;
	}

	public List<Integer> getTreatedNeeds() {
		return treatedNeeds;
	}

	public void setTreatedNeeds(List<Integer> treatedNeeds) {
		this.treatedNeeds = treatedNeeds;
	}

}

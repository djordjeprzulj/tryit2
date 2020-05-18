package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class OpportunitiesCancellationReasonsTranslatableItemList implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<OpportunitiesCancellationReasonsTranslatableItem> cancellationReasons;

	/**
	 * default constructor for Opportunities Cancellation Reasons Translatable Item List
	 */
	public OpportunitiesCancellationReasonsTranslatableItemList() {
		super();
		this.cancellationReasons = new ArrayList<OpportunitiesCancellationReasonsTranslatableItem>();
	}

	/**
	 * Opportunities Cancellation Reasons Translatable Item List
	 * 
	 * @param cancellationReasons
	 * 				Cancellation reasons
	 */
	public OpportunitiesCancellationReasonsTranslatableItemList(
			List<OpportunitiesCancellationReasonsTranslatableItem> cancellationReasons) {
		super();
		this.cancellationReasons = cancellationReasons;
	}

	public List<OpportunitiesCancellationReasonsTranslatableItem> getCancellationReasons() {
		return cancellationReasons;
	}

	public void setCancellationReasons(
			List<OpportunitiesCancellationReasonsTranslatableItem> cancellationReasons) {
		this.cancellationReasons = cancellationReasons;
	}

}

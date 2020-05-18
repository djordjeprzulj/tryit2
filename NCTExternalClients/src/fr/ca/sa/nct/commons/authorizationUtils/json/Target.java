package fr.ca.sa.nct.commons.authorizationUtils.json;

import java.util.List;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public interface Target {

	/**
	 * Get target action objects
	 */
	List<TargetAction> getTargetActionObjects();

	/**
	 * Set target action objects
	 */
	void defineTargetActionObjects();

}

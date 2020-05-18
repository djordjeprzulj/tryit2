package fr.ca.sa.nct.commons.authorizationUtils.json;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public abstract class AbstractTarget implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Get target action objects
	 */
	public abstract List<TargetAction> getTargetActionObjects();

	/**
	 * Set target action objects
	 */
	public abstract void defineTargetActionObjects();

}

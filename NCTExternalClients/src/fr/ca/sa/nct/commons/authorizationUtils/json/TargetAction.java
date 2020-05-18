package fr.ca.sa.nct.commons.authorizationUtils.json;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Abstract class to be extended in all action operations Purpose of this class
 * is to force all classes that extend it to implement targetId and
 * targetEntityId In their body
 * 
 * @author Sasa Radovanovic
 *
 */
public class TargetAction implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer targetEntityId;

	private Integer targetId;

	/**
	 * default constructor for Target Action
	 */
	public TargetAction() {
		super();
	}

	/**
	 * Target Action
	 * 
	 * @param targetEntityId
	 * 				Target entity ID
	 */
	public TargetAction(Integer targetEntityId) {
		super();
		this.targetEntityId = targetEntityId;
		this.targetId = null;
	}

	/**
	 * Target Action
	 * 
	 * @param targetEntityId
	 * 				Target entity ID
	 * 
	 * @param targetId
	 * 				Target ID
	 */
	public TargetAction(int targetEntityId, int targetId) {
		super();
		this.targetEntityId = targetEntityId;
		this.targetId = targetId;
	}

	public int getTargetEntityId() {
		return targetEntityId;
	}

	public void setTargetEntityId(int targetEntityId) {
		this.targetEntityId = targetEntityId;
	}

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
}

package fr.ca.sa.commons.sharedEntities.multipart;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SaveImageResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String imageId;
	private int objectIdentifier;

	/**
	 * default constructor for Save Image Response
	 */
	public SaveImageResponse() {
		super();
	}

	/**
	 * Save Image Response
	 * 
	 * @param imageId
	 * 				Image ID
	 */
	public SaveImageResponse(String imageId) {
		super();
		this.imageId = imageId;
	}

	/**
	 * Save Image Response
	 * 
	 * @param imageId
	 * 				Image ID
	 * 
	 * @param objectIdentifier
	 * 				Object identifier
	 */
	public SaveImageResponse(String imageId, int objectIdentifier) {
		super();
		this.imageId = imageId;
		this.objectIdentifier = objectIdentifier;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public int getObjectIdentifier() {
		return objectIdentifier;
	}

	public void setObjectIdentifier(int objectIdentifier) {
		this.objectIdentifier = objectIdentifier;
	}

	@Override
	public String toString() {
		return "SaveImageResponse [imageId=" + imageId + ", objectIdentifier=" + objectIdentifier + "]";
	}

}

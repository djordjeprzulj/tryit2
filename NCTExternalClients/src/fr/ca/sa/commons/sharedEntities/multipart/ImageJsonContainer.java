package fr.ca.sa.commons.sharedEntities.multipart;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ImageJsonContainer implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String imgContent;

	/**
	 * default constructor for Image Json Container
	 */
	public ImageJsonContainer() {
		super();
	}

	/**
	 * Image Json Container
	 * 
	 * @param imgContent
	 * 				Image content
	 * 
	 * @param imgType
	 * 				Image type
	 */
	public ImageJsonContainer(String imgContent, String imgType) {
		super();
		this.imgContent = this.addBase64ImgPrefix(imgContent, imgType);
	}

	public String getImgContent() {
		return imgContent;
	}

	/**
	 * Set Image Content
	 * 
	 * @param imgContent
	 * 				Image content
	 * 
	 * @param imgType
	 * 				Image type
	 */
	public void setImgContent(String imgContent, String imgType) {
		this.imgContent = this.addBase64ImgPrefix(imgContent, imgType);
	}

	private String addBase64ImgPrefix(String imgContent, String imgType) {
		return "data:image/" + imgType + ";base64," + imgContent;
	}

	@Override
	public String toString() {
		return "ImageJsonContainer [imgContent=" + imgContent + "]";
	}

}

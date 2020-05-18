package fr.ca.sa.commons.sharedEntities.multipart;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ImageInfoContainer implements Serializable {
	private static final Logger LOGGER = Logger.getLogger(ImageInfoContainer.class);

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String imageType;
	private transient BufferedImage imageContent;
	private long creationTime;

	/**
	 * default constructor for Image Info Container
	 */
	public ImageInfoContainer() {
		super();
	}

	/**
	 * Image Info Container
	 * 
	 * @param inputStream
	 * 				Input stream 
	 * 
	 * @throws IOException
	 * 				Throws IO Exception
	 */
	public ImageInfoContainer(InputStream inputStream) throws IOException {
		ImageInputStream imageStream = ImageIO.createImageInputStream(inputStream);
		Iterator<ImageReader> iter = ImageIO.getImageReaders(imageStream);
		if (iter.hasNext()) {
			ImageReader reader = iter.next();
			this.imageType = convertImageFormatToMimeType(reader.getFormatName());
		}
		imageContent = ImageIO.read(imageStream);
		creationTime = System.currentTimeMillis();
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public BufferedImage getImageContent() {
		return imageContent;
	}

	public void setImageContent(BufferedImage imageContent) {
		this.imageContent = imageContent;
	}

	public long getCreationTime() {
		return creationTime;
	}

	private String convertImageFormatToMimeType(String formatName) {
		// Differ between png and other image formats. BMP,GIF etc. are
		// considered as jpg
		String mimeType = ProjectConstants.DEFAULT_IMAGE_MIME_TYPE;
		if (formatName != null) {
			if (formatName.equalsIgnoreCase(ProjectConstants.IMAGE_MIME_TYPE_PNG)) {
				mimeType = ProjectConstants.IMAGE_MIME_TYPE_PNG;
			}
		}
		return mimeType;
	}

	public InputStream getStreamFromBufferedImage() {
		if (imageContent != null) {
			try {
				ByteArrayOutputStream os = new ByteArrayOutputStream();

				ImageIO.write(imageContent, imageType, os);

				return new ByteArrayInputStream(os.toByteArray());
			} catch (IOException ex) {
				LOGGER.error(ex);

				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "ImageInfoContainer [imageType=" + imageType + ", imageContent=" + imageContent + "]";
	}

}

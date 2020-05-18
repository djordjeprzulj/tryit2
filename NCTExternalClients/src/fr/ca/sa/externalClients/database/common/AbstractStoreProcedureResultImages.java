package fr.ca.sa.externalClients.database.common;

import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;

/**
 * 
 * Class which should be extended in case of all results from store procedure
 * which return data with images binary stream
 * 
 * @author Nemanja Ignjatov
 *
 */
public abstract class AbstractStoreProcedureResultImages implements StoreProcedureResult {

	protected HashMap<String, HashMap<String, ImageInfoContainer>> images;

	/**
	 * default constructor for Store Procedure Result Abstract Images
	 */
	public AbstractStoreProcedureResultImages() {
		this.initializeImageMaps();
	}

	protected void initializeImageMaps() {
		this.images = new HashMap<String, HashMap<String, ImageInfoContainer>>();
		String[] mapNames = getImagesMapsNames();
		for (String name : mapNames) {
			this.images.put(name, new HashMap<String, ImageInfoContainer>());
		}
	}

	/**
	 * Get images map by name
	 * 
	 * @param mapName
	 * @return images map by name
	 */
	public Map<String, ImageInfoContainer> getImagesMapByName(String mapName) {
		return this.images.get(mapName);
	}

	// Classname used for image uri hash mapping
	public abstract String getClassName();

	public abstract StoreProcedureResult getDataObject();

	public abstract String[] getImagesMapsNames();

	/**
	 * Merge picture URI
	 * 
	 * @param imageMapName
	 * @param key
	 * @param pictureURI
	 */
	public abstract void mergePictureURI(String imageMapName, String key, String pictureURI);

}

package fr.ca.sa.model;

import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.nct.commons.NCTSystemConstants;

public class BaseTranslatableProduct {

	private Integer id;
	private Map<String, String> name;
	
	private Map<String, String> shortDescription = new HashMap<String, String>();
	private Map<String, String> longDescription = new HashMap<String, String>();	
	private Map<String, String> tipsDesc = new HashMap<String, String>();
	
	private String longDescriptionLink;
	private String tipsLink;
	private String simulatorLink;
	
	private String color;
	private Boolean ownedByClient;
	
	private Boolean hasAmount;
	private Boolean hasPieces;
	private Integer idExt;
	
	private String picture;
	private String groupPicture;

	public BaseTranslatableProduct() {		
	}
	
	public BaseTranslatableProduct(Integer id, Map<String, String> name, Map<String, String> shortDescription,
			Map<String, String> longDescription, Map<String, String> tipsDesc, String longDescriptionLink,
			String tipsLink, String simulatorLink, String color, Boolean ownedByClient, Boolean hasAmount,
			Boolean hasPieces, Integer idExt, String picture, String groupPicture) {
		super();
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.tipsDesc = tipsDesc;
		this.longDescriptionLink = longDescriptionLink;
		this.tipsLink = tipsLink;
		this.simulatorLink = simulatorLink;
		this.color = color;
		this.ownedByClient = ownedByClient;
		this.hasAmount = hasAmount;
		this.hasPieces = hasPieces;
		this.idExt = idExt;
		this.picture = determineProductPicture(picture);
		this.groupPicture = groupPicture;
	}

	private String determineProductPicture(String picture) {
		if (picture == null || picture.isEmpty()) {
			return NCTSystemConstants.getProductDefaultImg();
		}

		return picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Map<String, String> getName() {
		return name;
	}

	public void setName(Map<String, String> name) {
		this.name = name;
	}

	public Map<String, String> getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(Map<String, String> shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Map<String, String> getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(Map<String, String> longDescription) {
		this.longDescription = longDescription;
	}

	public Map<String, String> getTipsDesc() {
		return tipsDesc;
	}

	public void setTipsDesc(Map<String, String> tipsDesc) {
		this.tipsDesc = tipsDesc;
	}

	public String getLongDescriptionLink() {
		return longDescriptionLink;
	}

	public void setLongDescriptionLink(String longDescriptionLink) {
		this.longDescriptionLink = longDescriptionLink;
	}

	public String getTipsLink() {
		return tipsLink;
	}

	public void setTipsLink(String tipsLink) {
		this.tipsLink = tipsLink;
	}

	public String getSimulatorLink() {
		return simulatorLink;
	}

	public void setSimulatorLink(String simulatorLink) {
		this.simulatorLink = simulatorLink;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getOwnedByClient() {
		return ownedByClient;
	}

	public void setOwnedByClient(Boolean ownedByClient) {
		this.ownedByClient = ownedByClient;
	}

	public Boolean getHasAmount() {
		return hasAmount;
	}

	public void setHasAmount(Boolean hasAmount) {
		this.hasAmount = hasAmount;
	}

	public Boolean getHasPieces() {
		return hasPieces;
	}

	public void setHasPieces(Boolean hasPieces) {
		this.hasPieces = hasPieces;
	}

	public Integer getIdExt() {
		return idExt;
	}

	public void setIdExt(Integer idExt) {
		this.idExt = idExt;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getGroupPicture() {
		return groupPicture;
	}

	public void setGroupPicture(String groupPicture) {
		this.groupPicture = groupPicture;
	}

	@Override
	public String toString() {
		return "TranslatableProduct [id=" + id + ", name=" + name + ", shortDescription=" + shortDescription
				+ ", longDescription=" + longDescription + ", tipsDesc=" + tipsDesc + ", longDescriptionLink="
				+ longDescriptionLink + ", tipsLink=" + tipsLink + ", simulatorLink=" + simulatorLink + ", color="
				+ color + ", ownedByClient=" + ownedByClient + ", hasAmount=" + hasAmount + ", hasPieces=" + hasPieces
				+ ", idExt=" + idExt + ", picture=" + picture + ", groupPicture=" + groupPicture + "]";
	}	
}

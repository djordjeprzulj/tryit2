package fr.ca.sa.model;

public class Product {

	private Integer id;
	private String code;
	private String nameL1;
	private String nameL2;
	
	private String shortDescriptionL1;
	private String shortDescriptionL2;

	private String longDescriptionL1;
	private String longDescriptionL2;
	
	private String tipsDescL1;
	private String tipsDescL2;
	
	private String longDescriptionLink;
	private String tipsLink;
	private String simulatorLink;
	
	private String color;
	
	private Boolean hasAmount;
	private Boolean hasPieces;
	private Integer idExt;
	
	private String picture;

	public Product(Integer id, String code, String nameL1, String nameL2, String shortDescriptionL1,
			String shortDescriptionL2, String longDescriptionLink, String longDescriptionL1, String longDescriptionL2,
			String tipsLink, String tipsDescL1, String tipsDescL2, String simulatorLink, String color,
			Boolean hasAmount, Boolean hasPieces, Integer idExt, String picture) {
		super();
		this.id = id;
		this.code = code;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.shortDescriptionL1 = shortDescriptionL1;
		this.shortDescriptionL2 = shortDescriptionL2;
		this.longDescriptionLink = longDescriptionLink;
		this.longDescriptionL1 = longDescriptionL1;
		this.longDescriptionL2 = longDescriptionL2;
		this.tipsLink = tipsLink;
		this.tipsDescL1 = tipsDescL1;
		this.tipsDescL2 = tipsDescL2;
		this.simulatorLink = simulatorLink;
		this.color = color;
		this.hasAmount = hasAmount;
		this.hasPieces = hasPieces;
		this.idExt = idExt;
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNameL1() {
		return nameL1;
	}

	public void setNameL1(String nameL1) {
		this.nameL1 = nameL1;
	}

	public String getNameL2() {
		return nameL2;
	}

	public void setNameL2(String nameL2) {
		this.nameL2 = nameL2;
	}

	public String getShortDescriptionL1() {
		return shortDescriptionL1;
	}

	public void setShortDescriptionL1(String shortDescriptionL1) {
		this.shortDescriptionL1 = shortDescriptionL1;
	}

	public String getShortDescriptionL2() {
		return shortDescriptionL2;
	}

	public void setShortDescriptionL2(String shortDescriptionL2) {
		this.shortDescriptionL2 = shortDescriptionL2;
	}

	public String getLongDescriptionLink() {
		return longDescriptionLink;
	}

	public void setLongDescriptionLink(String longDescriptionLink) {
		this.longDescriptionLink = longDescriptionLink;
	}

	public String getLongDescriptionL1() {
		return longDescriptionL1;
	}

	public void setLongDescriptionL1(String longDescriptionL1) {
		this.longDescriptionL1 = longDescriptionL1;
	}

	public String getLongDescriptionL2() {
		return longDescriptionL2;
	}

	public void setLongDescriptionL2(String longDescriptionL2) {
		this.longDescriptionL2 = longDescriptionL2;
	}

	public String getTipsLink() {
		return tipsLink;
	}

	public void setTipsLink(String tipsLink) {
		this.tipsLink = tipsLink;
	}

	public String getTipsDescL1() {
		return tipsDescL1;
	}

	public void setTipsDescL1(String tipsDescL1) {
		this.tipsDescL1 = tipsDescL1;
	}

	public String getTipsDescL2() {
		return tipsDescL2;
	}

	public void setTipsDescL2(String tipsDescL2) {
		this.tipsDescL2 = tipsDescL2;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", nameL1=" + nameL1 + ", nameL2=" + nameL2
				+ ", shortDescriptionL1=" + shortDescriptionL1 + ", shortDescriptionL2=" + shortDescriptionL2
				+ ", longDescriptionLink=" + longDescriptionLink + ", longDescriptionL1=" + longDescriptionL1
				+ ", longDescriptionL2=" + longDescriptionL2 + ", tipsLink=" + tipsLink + ", tipsDescL1=" + tipsDescL1
				+ ", tipsDescL2=" + tipsDescL2 + ", simulatorLink=" + simulatorLink + ", color=" + color
				+ ", hasAmount=" + hasAmount + ", hasPieces=" + hasPieces + ", idExt=" + idExt + ", picture=" + picture
				+ "]";
	}

	
	
}

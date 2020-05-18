package fr.ca.sa.model;

public class NeedCategory {

	private Integer id;
	private String nameL1;
	private String nameL2;
	
	private String longDescriptionL1;
	private String longDescriptionL2;
	
	private String tipsLink;
	
	private String tipsDescL1;
	private String tipsDescL2;
	
	private String simulatorLink;
	
	private String picture;
	private String icon;
	
	public NeedCategory(Integer id, String nameL1, String nameL2, String longDescriptionL1, String longDescriptionL2,
			String tipsLink, String tipsDescL1, String tipsDescL2, String simulatorLink, String picture, String icon) {
		super();
		this.id = id;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.longDescriptionL1 = longDescriptionL1;
		this.longDescriptionL2 = longDescriptionL2;
		this.tipsLink = tipsLink;
		this.tipsDescL1 = tipsDescL1;
		this.tipsDescL2 = tipsDescL2;
		this.simulatorLink = simulatorLink;
		this.picture = picture;
		this.icon = icon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "NeedCategory [id=" + id + ", nameL1=" + nameL1 + ", nameL2=" + nameL2 + ", longDescriptionL1="
				+ longDescriptionL1 + ", longDescriptionL2=" + longDescriptionL2 + ", tipsLink=" + tipsLink
				+ ", tipsDescL1=" + tipsDescL1 + ", tipsDescL2=" + tipsDescL2 + ", simulatorLink=" + simulatorLink
				+ ", picture=" + picture + ", icon=" + icon + "]";
	}
}

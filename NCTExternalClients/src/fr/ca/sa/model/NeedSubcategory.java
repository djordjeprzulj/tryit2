package fr.ca.sa.model;

public class NeedSubcategory {

	private Integer id;
	private String nameL1;
	private String nameL2;
	
	private NeedCategory needCategory;

	public NeedSubcategory(Integer id, String nameL1, String nameL2, NeedCategory needCategory) {
		super();
		this.id = id;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.needCategory = needCategory;
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

	public NeedCategory getNeedCategory() {
		return needCategory;
	}

	public void setNeedCategory(NeedCategory needCategory) {
		this.needCategory = needCategory;
	}

	@Override
	public String toString() {
		return "NeedSubcategory [id=" + id + ", nameL1=" + nameL1 + ", nameL2=" + nameL2 + ", needCategory="
				+ needCategory + "]";
	}
	
	
}

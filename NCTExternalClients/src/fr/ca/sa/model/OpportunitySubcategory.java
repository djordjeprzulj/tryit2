package fr.ca.sa.model;

public class OpportunitySubcategory {

	private Integer id;
	private Integer idExt;
	
	private String nameL1;
	private String nameL2;
	
	private OpportunityCategory opportunityCategory;
	
	public OpportunitySubcategory(Integer id, Integer idExt, String nameL1, String nameL2) {
		super();
		this.id = id;
		this.idExt = idExt;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdExt() {
		return idExt;
	}

	public void setIdExt(Integer idExt) {
		this.idExt = idExt;
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
	
	public OpportunityCategory getOpportunityCategory() {
		return opportunityCategory;
	}

	public void setOpportunityCategory(OpportunityCategory opportunityCategory) {
		this.opportunityCategory = opportunityCategory;
	}

	@Override
	public String toString() {
		return "OpportunitySubcategory [id=" + id + ", idExt=" + idExt + ", nameL1=" + nameL1 + ", nameL2=" + nameL2
				+ "]";
	}
	
}

package fr.ca.sa.model;

public class OpportunityCategory {

	private Integer id;
	private Integer idExt;
	
	private String nameL1;
	private String nameL2;
	
	private Boolean active;

	public OpportunityCategory(Integer id, Integer idExt, String nameL1, String nameL2, Boolean active) {
		super();
		this.id = id;
		this.idExt = idExt;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.active = active;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "OpportunityCategory [id=" + id + ", idExt=" + idExt + ", nameL1=" + nameL1 + ", nameL2=" + nameL2
				+ ", active=" + active + "]";
	}
}

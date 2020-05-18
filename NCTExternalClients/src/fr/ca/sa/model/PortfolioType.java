package fr.ca.sa.model;

public class PortfolioType {
	
	private Integer id;
	private String name;
	private Integer idExt;
	private String code;
	
	public PortfolioType() {
		
	}

	public PortfolioType(Integer id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdExt() {
		return idExt;
	}

	public void setIdExt(Integer idExt) {
		this.idExt = idExt;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "PortfolioType [id=" + id + ", name=" + name + ", idExt=" + idExt + ", code=" + code + "]";
	}
}

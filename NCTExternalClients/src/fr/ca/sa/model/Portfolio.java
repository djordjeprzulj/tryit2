package fr.ca.sa.model;

public class Portfolio {
	
	private Integer id;
	
	protected Integer rowId;
	protected String name;
	protected String code;

	private Integer size;
	private Integer fteSize;
	
	
	private PortfolioType portfolioType = new PortfolioType();
	private Entity entity = new Entity();
	private Collaborator advisor = new Collaborator();
	
	public Portfolio(Integer id, Integer rowId, String name, String code, Integer size, Integer fteSize,
			PortfolioType portfolioType, Entity entity, Collaborator advisor) {
		super();
		this.id = id;
		this.rowId = rowId;
		this.name = name;
		this.code = code;
		this.size = size;
		this.fteSize = fteSize;
		this.portfolioType = portfolioType;
		this.entity = entity;
		this.advisor = advisor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getFteSize() {
		return fteSize;
	}

	public void setFteSize(Integer fteSize) {
		this.fteSize = fteSize;
	}

	public PortfolioType getPortfolioType() {
		return portfolioType;
	}

	public void setPortfolioType(PortfolioType portfolioType) {
		this.portfolioType = portfolioType;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Collaborator getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Collaborator advisor) {
		this.advisor = advisor;
	}

	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", rowId=" + rowId + ", name=" + name + ", code=" + code + ", size=" + size
				+ ", fteSize=" + fteSize + ", portfolioType=" + portfolioType + ", entity=" + entity + ", advisor="
				+ advisor + "]";
	}	
}

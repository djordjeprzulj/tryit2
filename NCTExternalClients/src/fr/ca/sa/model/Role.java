package fr.ca.sa.model;

public class Role {

	private Integer id;
	private String name;
	private String  assignedBy;
	private String assignedDate;
	
	public Role(Integer id, String name, String assignedBy, String assignedDate) {
		super();
		this.id = id;
		this.name = name;
		this.assignedBy = assignedBy;
		this.assignedDate = assignedDate;
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

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", assignedBy=" + assignedBy + ", assignedDate=" + assignedDate
				+ "]";
	}
}

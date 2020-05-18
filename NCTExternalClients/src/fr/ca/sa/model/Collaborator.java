package fr.ca.sa.model;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

public class Collaborator implements Serializable {
	
	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String name;
	
	private Entity primaryEntity = new Entity();
	
	private Integer idExt;
	
	private Boolean active;
	private String code;
	
	public Collaborator() {
		super();
	}
			
	public Collaborator(Integer id, String firstName, String lastName, Entity primaryEntity) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.primaryEntity = primaryEntity;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Entity getPrimaryEntity() {
		return primaryEntity;
	}

	public void setPrimaryEntity(Entity primaryEntity) {
		this.primaryEntity = primaryEntity;
	}

	public Integer getIdExt() {
		return idExt;
	}

	public void setIdExt(Integer idExt) {
		this.idExt = idExt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Advisor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", name=" + name
				+ ", primaryEntity=" + primaryEntity + ", collaboratorIdExt=" + idExt + "]";
	}
	
}

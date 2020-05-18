package fr.ca.sa.model;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

public class IdName implements Serializable {
	
	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer id;
	private String name;
	
	public IdName() {
		super();
	}

	public IdName(Integer id) {
		super();
		this.id = id;
	}
	
	public IdName(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "IdName [id=" + id + ", name=" + name + "]";
	}
}

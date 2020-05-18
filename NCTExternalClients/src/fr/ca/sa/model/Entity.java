package fr.ca.sa.model;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

public class Entity implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer id;
	private IdName type = new IdName();
	private String code;
	private String name;
	
	public Entity() {
		
	}
	
	public Entity(Integer id, IdName type, String code, String name) {
		super();
		this.id = id;
		this.type = type;
		this.code = code;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IdName getType() {
		return type;
	}

	public void setType(IdName type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", type=" + type + ", code=" + code + ", name=" + name + "]";
	}
}

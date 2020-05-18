package fr.ca.sa.nct.commons.commonEntities;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Role entity
 * 
 * @author Sasa Radovanovic
 *
 */
public class Role implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String roleName;

	private int roleId;

	/**
	 * Role
	 * 
	 * @param roleName
	 * 				Role name
	 * 
	 * @param roleId
	 * 				Role ID
	 */
	public Role(String roleName, int roleId) {
		super();
		this.roleName = roleName;
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roleId;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Role other = null;
		if (obj instanceof Role) {
			other = (Role) obj;	
		}
		
		if (roleId != other.roleId) {
			return false;
		}
		if (roleName == null) {
			if (other.roleName != null) {
				return false;
			}
		} else if (!roleName.equals(other.roleName)) {
			return false;
		}
		return true;
	}

}

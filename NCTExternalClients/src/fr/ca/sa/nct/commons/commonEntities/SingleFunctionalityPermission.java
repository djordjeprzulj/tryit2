package fr.ca.sa.nct.commons.commonEntities;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class SingleFunctionalityPermission {

	private int pLevel;

	private String objectName;

	/**
	 * default constructor for Single Functionality Permission
	 * 
	 */
	public SingleFunctionalityPermission() {
		super();
	}

	/**
	 * Single Functionality Permission
	 * 
	 * @param pLevel
	 * 				Permission level
	 * 
	 * @param objectName
	 * 				Object name
	 */
	public SingleFunctionalityPermission(int pLevel, String objectName) {
		super();
		this.pLevel = pLevel;
		this.objectName = objectName;
	}

	public int getPLevel() {
		return pLevel;
	}

	public void setPLevel(int pLevel) {
		this.pLevel = pLevel;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((objectName == null) ? 0 : objectName.hashCode());
		result = prime * result + pLevel;
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
		SingleFunctionalityPermission other = null;
		if (obj instanceof SingleFunctionalityPermission) {
			other = (SingleFunctionalityPermission) obj;	
		}
		 
		if (objectName == null) {
			if (other.objectName != null) {
				return false;
			}
		} else if (!objectName.equalsIgnoreCase(other.objectName)) {
			return false;
		}
		return (pLevel == other.pLevel);
//		if (pLevel != other.pLevel) {
//			return false;
//		}
//		return true;
	}

}

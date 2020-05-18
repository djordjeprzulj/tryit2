package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SimpleCodeTablesConstraintContainer implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<SimpleCodeTableContainer> tables;
	private Map<String, CodeTableConstraintContainer> constraints;

	/**
	 * default constructor for Simple CodeTables Constraint Container
	 */
	public SimpleCodeTablesConstraintContainer() {
		super();
		this.tables = new ArrayList<SimpleCodeTableContainer>();
		this.constraints = new HashMap<String, CodeTableConstraintContainer>();
	}

	/**
	 * Simple CodeTables Constraint Container
	 * 
	 * @param tables
	 * 				List of tables
	 * 
	 * @param constraints
	 * 				Constraints
	 */
	public SimpleCodeTablesConstraintContainer(List<SimpleCodeTableContainer> tables,
			Map<String, CodeTableConstraintContainer> constraints) {
		super();
		this.tables = tables;
		this.constraints = constraints;

	}

	public List<SimpleCodeTableContainer> getTables() {
		return tables;
	}

	public void setTables(List<SimpleCodeTableContainer> tables) {
		this.tables = tables;
	}

	public Map<String, CodeTableConstraintContainer> getConstraints() {
		return constraints;
	}

	public void setConstraints(Map<String, CodeTableConstraintContainer> constraints) {
		this.constraints = constraints;
	}

	@Override
	public String toString() {
		return "SimpleCodeTablesConstraintContainer [tables=" + tables + ", constraints=" + constraints + "]";
	}

}

package fr.ca.sa.externalClients.database.nct.procedures.todoList.getToDoList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning list of TO DO items in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetToDoListNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetToDoListNCTResultItem> items;

	/**
	 * default constructor for Get ToDo List NCT Result List
	 */
	public GetToDoListNCTResultList() {
		items = new ArrayList<GetToDoListNCTResultItem>();
	}

	public List<GetToDoListNCTResultItem> getItems() {
		return items;
	}

	public void setItems(List<GetToDoListNCTResultItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "GetToDoListNCTResultList [items=" + items + "]";
	}

}

package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientDataByTaskIdRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private String taskId;

	/**
	 * Get Client Data By Task Id Request
	 * 
	 * @param taskId
	 * 			Task ID
	 */
	public GetClientDataByTaskIdRequest(String taskId) {
		super();
		this.taskId = taskId;
	}
	
	/**
	 * default constructor for client data by task id
	 */
	public GetClientDataByTaskIdRequest() {
		super();
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	@Override
	public String toString() {
		return "GetClientDataByTaskIdRequest [taskId=" + taskId + "]";
	}
	
}

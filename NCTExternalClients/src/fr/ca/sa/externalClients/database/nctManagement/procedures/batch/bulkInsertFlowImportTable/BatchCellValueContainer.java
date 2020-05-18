package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.bulkInsertFlowImportTable;

import java.io.InputStream;
import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Data container for cell value in batch import
 * 
 * @author Nemanja Ignjatov
 *
 */
public class BatchCellValueContainer implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private transient Object data;
	private boolean stream;

	/**
	 * @param default constructor
	 */
	public BatchCellValueContainer() {
		super();
	}
	/**
	 * 
	 * @param data
	 * @param stream
	 */
	public BatchCellValueContainer(Object data, boolean stream) {
		super();
		this.data = data;
		this.stream = stream;
	}
	/**
	 * 
	 * @param isStream
	 */
	public BatchCellValueContainer(boolean isStream) {
		super();
		this.stream = isStream;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setBinaryData(InputStream data) {
		this.data = data;
		this.stream = true;
	}
	
	public void setDataFromJMS(String data) {
		this.data = data;
	}

	public String getDataFromJMS() {
		return this.data != null ? String.valueOf(this.data) : null;
	}

	public boolean isStream() {
		return stream;
	}

	public void setStream(boolean stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "BatchCellValueContainer [data=" + data + ", stream=" + stream + "]";
	}

}

package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getDataSource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Result holder for data sources
 * 
 * @author Djordje Przulj
 *
 */
public class GetDataSourceResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetDataSourceResultItem> dataSources;

	/**
	 * default constructor for Get Client Contact History Result List
	 */
	public GetDataSourceResultList() {
		super();
		this.dataSources = new ArrayList<>();
	}

	/**
	 * Get Client Contact History Result List
	 * 
	 * @param contactHistory
	 * 				Contact history
	 */
	public GetDataSourceResultList(List<GetDataSourceResultItem> dataSources) {
		super();
		this.dataSources = dataSources;
	}

	public List<GetDataSourceResultItem> getDataSources() {
		return dataSources;
	}

	public void setDataSources(List<GetDataSourceResultItem> dataSources) {
		this.dataSources = dataSources;
	}

	@Override
	public String toString() {
		return "GetDataSourceResultList [dataSources=" + dataSources + "]";
	}

}

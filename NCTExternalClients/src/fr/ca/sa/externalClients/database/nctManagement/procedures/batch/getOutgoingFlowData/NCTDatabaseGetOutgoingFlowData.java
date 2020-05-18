package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getOutgoingFlowData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for retrieving outgoing flow data
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetOutgoingFlowData extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOutgoingFlowData.class);

	private int jobExecutionId;
	private Integer flowExecutionId;

	/**
	 * default constructor for NCT Database Get Outgoing Flow Data
	 */
	public NCTDatabaseGetOutgoingFlowData() {
		super();
	}

	/**
	 * NCT Database Get Outgoing Flow Data
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param flowExecutionId
	 * 				Flow execution ID
	 */
	public NCTDatabaseGetOutgoingFlowData(int jobExecutionId, Integer flowExecutionId) {
		super();
		this.jobExecutionId = jobExecutionId;
		this.flowExecutionId = flowExecutionId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batchFlow.spGetOutgoingFlowData ?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jobExecutionId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.flowExecutionId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetOutgoingFlowDataNCTResultList retValue = new GetOutgoingFlowDataNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getFileRows()
						.add(new GetOutgoingFlowDataNCTResultItem(this.getResultSet().getString("FileRow")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		LOGGER.error(ex);		
		throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
	}

}

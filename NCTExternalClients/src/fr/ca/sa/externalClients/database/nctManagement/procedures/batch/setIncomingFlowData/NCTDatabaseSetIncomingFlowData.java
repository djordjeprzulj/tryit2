package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.setIncomingFlowData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting incoming flow data
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetIncomingFlowData extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetIncomingFlowData.class);

	private int jobExecutionId;
	private int flowExecutionId;
	private int flowProcessTypeId;

	/**
	 * default constructor for NCT Database Set Incoming Flow Data
	 */
	public NCTDatabaseSetIncomingFlowData() {
		super();
	}

	/**
	 * NCT Database Set Incoming Flow Data
	 * 
	 * @param jobExecutionId    Job execution ID
	 * 
	 * @param flowExecutionId   Flow execution ID
	 * 
	 * @param flowProcessTypeId Flow process type ID
	 */
	public NCTDatabaseSetIncomingFlowData(int jobExecutionId, int flowExecutionId, int flowProcessTypeId) {
		super();
		this.jobExecutionId = jobExecutionId;
		this.flowExecutionId = flowExecutionId;
		this.flowProcessTypeId = flowProcessTypeId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {

		PreparedStatement ps = connection.prepareStatement("exec batchFlow.spSetIncomingFlowData ?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jobExecutionId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.flowExecutionId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.flowProcessTypeId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;

	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetIncomingFlowDataNCTResult retValue = null;
		try {
			if (this.getResultSet() == null) {
				return null;
			}
			while (this.getResultSet().next() && (retValue == null)) {
				Integer errorOccured = this.getResultSet().getInt("ErrorOccured");
				retValue = new SetIncomingFlowDataNCTResult(
						errorOccured == ProjectConstants.INTEGER_TRUE_VALUE ? true : false);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new BatchProcessingOperationException(ex.toString(), ex.getCause());
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchProcessingOperationException(ex.toString(), ex.getCause());
	}

}

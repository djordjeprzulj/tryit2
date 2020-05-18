package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowColumns;

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
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting flows for job
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetFlowColumns extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetFlowColumns.class);

	private int flowId;

	/**
	 * default constructor for NCT Database Get Flow Columns
	 */
	public NCTDatabaseGetFlowColumns() {
		super();
	}

	/**
	 * NCT Database Get Flow Columns
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param flowId
	 * 				Flow ID
	 */
	public NCTDatabaseGetFlowColumns(Integer userId, int flowId) {
		super(userId);
		this.flowId = flowId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetFlowColumns ?,?");
		try {
			setUser(ps);	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.flowId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}		
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetFlowColumnsNCTResultList retList = new GetFlowColumnsNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getFlowColumns().add(new GetFlowColumnsNCTResultItem(this.getResultSet().getInt("FLO_FLOW_ID"),
						this.getResultSet().getInt("ORDINAL_POSITION"), this.getResultSet().getString("COLUMN_NAME"),
						this.getResultSet().getInt("IS_NULLABLE"), this.getResultSet().getString("DATA_TYPE"),
						this.getResultSet().getInt("CHARACTER_MAXIMUM_LENGTH"), this.getResultSet().getString("CODE_TABLE_NAME")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		LOGGER.error(ex);
		throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
	}

}

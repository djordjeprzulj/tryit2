package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.setFlowProcessType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetFlowProcessType extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetFlowProcessType.class);

	private int flowId;
	private int processingTypeId;

	/**
	 * NCT Database Set Flow Process Type
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param flowId
	 * 				Flow ID
	 * 
	 * @param processingTypeId
	 * 				Processing type ID
	 */
	public NCTDatabaseSetFlowProcessType(int userId, int flowId, int processingTypeId) {
		super(userId);
		this.flowId = flowId;
		this.processingTypeId = processingTypeId;

	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spSetFlowProcessType ?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.flowId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.processingTypeId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetFlowProcessTypeNCTResultItem retValue = null;

		try {
			if (this.getResultSet().next()) {

				retValue = new SetFlowProcessTypeNCTResultItem(this.getResultSet().getInt("FlowId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

		}

		return retValue;

	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchProcessingOperationException(ex.toString(), ex.getCause());
	}

}

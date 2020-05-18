package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getJMSFlows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting jms flows
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetJMSFlows extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetJMSFlows.class);

	private Integer jmsId;

	/**
	 * default constructor for NCT Database Get JMS Flows
	 */
	public NCTDatabaseGetJMSFlows() {
		super();
	}

	/**
	 * NCT Database Get JMS Flows
	 * 
	 * @param jmsId
	 * 				JMS ID
	 */
	public NCTDatabaseGetJMSFlows(Integer jmsId) {
		super();
		this.jmsId = jmsId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetJmsFlows ?");
		try {
			if (this.jmsId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jmsId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_1, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetJMSFlowsNCTResultList retList = new GetJMSFlowsNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getFlows().add(new GetJMSFlowsNCTResultItem(this.getResultSet().getInt("FlowId"),
						this.getResultSet().getInt("FlowDirectionId"), this.getResultSet().getString("FlowName"),
						this.getResultSet().getInt("JmsId"), this.getResultSet().getString("JmsQueueName"),
						this.getResultSet().getInt("SkipLimit"), this.getResultSet().getInt("RetryLimit")));
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

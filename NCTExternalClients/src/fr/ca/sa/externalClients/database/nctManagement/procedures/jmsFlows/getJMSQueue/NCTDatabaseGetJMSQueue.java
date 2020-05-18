package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getJMSQueue;

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
 * Store procedure handler for getting flows for job
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetJMSQueue extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetJMSQueue.class);

	private String jmsQueueName;
	private String flowName;

	/**
	 * default constructor for NCT Database Get JMS Queue
	 */
	public NCTDatabaseGetJMSQueue() {
		super();
	}

	/**
	 * NCT Database Get JMS Queue
	 * 
	 * @param jmsQueueName
	 * 				JMS queue name
	 * 
	 * @param flowName
	 * 				Flow name
	 */
	public NCTDatabaseGetJMSQueue(String jmsQueueName, String flowName) {
		super();
		this.jmsQueueName = jmsQueueName;
		this.flowName = flowName;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetJmsQueue ?,?");
		try {
			if (this.jmsQueueName != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_1, this.jmsQueueName);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_1, Types.VARCHAR);
			}
	
			if (this.flowName != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.flowName);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.VARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetJMSQueueNCTResultList retList = new GetJMSQueueNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getQueues()
						.add(new GetJMSQueueNCTResultItem(this.getResultSet().getInt("JmsId"),
								this.getResultSet().getInt("JmsQueueId"), this.getResultSet().getString("JmsQueueName"),
								this.getResultSet().getInt("FlowId"), this.getResultSet().getString("FlowName"),
								this.getResultSet().getInt("FlowDirectionId")));
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

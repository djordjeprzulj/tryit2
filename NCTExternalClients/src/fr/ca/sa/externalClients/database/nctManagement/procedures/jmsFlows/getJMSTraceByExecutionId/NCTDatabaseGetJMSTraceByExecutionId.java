package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getJMSTraceByExecutionId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting jms flows execution traces
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetJMSTraceByExecutionId extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetJMSTraceByExecutionId.class);

	private int jmsExecutionId;

	/**
	 * default constructor for NCT Database Get JMS Flows
	 */
	public NCTDatabaseGetJMSTraceByExecutionId() {
		super();
	}

	/**
	 * NCT Database Get JMS Flows
	 * 
	 * @param jmsExecutionId
	 * 				JMS ID
	 */
	public NCTDatabaseGetJMSTraceByExecutionId(Integer jmsExecutionId) {
		super();
		this.jmsExecutionId = jmsExecutionId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batchTrace.spGetJMSTraceByExecutionId ?");
		try {
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jmsExecutionId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetJMSTraceNCTResultList retList = new GetJMSTraceNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getTraces().add(new GetJMSTraceNCTResultItem(this.getResultSet().getInt("JMSId"),
						this.getResultSet().getString("MessageId"), this.getResultSet().getString("CorrelationId"),
						this.getResultSet().getDate("TraceTimeStamp"), this.getResultSet().getString("TraceDescription")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new BatchProcessingOperationException(ex.toString(), ex.getCause());
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchProcessingOperationException(ex.toString(), ex.getCause());
	}

}

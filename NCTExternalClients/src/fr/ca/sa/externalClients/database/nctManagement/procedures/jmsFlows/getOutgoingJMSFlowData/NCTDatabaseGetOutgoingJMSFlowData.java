package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getOutgoingJMSFlowData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for retrieving outgoing flow data with JMS
 * 
 * @author Milivoj Bozic
 *
 */
public class NCTDatabaseGetOutgoingJMSFlowData extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOutgoingJMSFlowData.class);

	private int jmsExecutionId;
	private Integer flowExecutionId;
	private int outboundLimit;
	/**
	 * default constructor for NCT Database Get Outgoing JMS Flow Data
	 */
	public NCTDatabaseGetOutgoingJMSFlowData() {
		super();
	}

	/**
	 * NCT Database Get Outgoing JMS Flow Data
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param flowExecutionId
	 * 				Flow execution ID
	 * 
	 * @param outboundLimit
	 * 				Outbound Limit
	 */
	public NCTDatabaseGetOutgoingJMSFlowData(int jobExecutionId, Integer flowExecutionId, int outboundLimit) {
		super();
		this.jmsExecutionId = jobExecutionId;
		this.flowExecutionId = flowExecutionId;
		this.outboundLimit = outboundLimit;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batchFlow.spGetOutgoingJMSFlowData ?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jmsExecutionId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.flowExecutionId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.outboundLimit);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetOutgoingJMSFlowDataNCTResultList retValue = new GetOutgoingJMSFlowDataNCTResultList();
		try {
			while (this.getResultSet().next()) {
				GetOutgoingJMSFlowDataNCTResultItem data = new GetOutgoingJMSFlowDataNCTResultItem();

				ArrayList<String> content = new ArrayList<>();
				ArrayList<String> columns = new ArrayList<>();
				for (int i = 1; i <= this.getResultSet().getMetaData().getColumnCount(); i++) {
					content.add(this.getResultSet().getString(i));
					columns.add(this.getResultSet().getMetaData().getColumnName(i));
				}

				data.setData(content);
				retValue.setColumns(columns);
				retValue.getRows().add(data);
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

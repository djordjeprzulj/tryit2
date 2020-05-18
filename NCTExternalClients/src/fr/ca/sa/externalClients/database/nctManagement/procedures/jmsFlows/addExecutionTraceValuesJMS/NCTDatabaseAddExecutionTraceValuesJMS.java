package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.addExecutionTraceValuesJMS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for tracing jms flow processing summary
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseAddExecutionTraceValuesJMS extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseAddExecutionTraceValuesJMS.class);
	
	private int jmsExecutionId;
	private int jmsFlowExecutionId;
	private Integer messageRecordCound;
	private Integer readCount;
	private Integer writeCount;
	private Integer readSkipCount;
	private Integer writeSkipCount;

	/**
	 * default constructor for NCT Database Add Execution Trace Values JMS
	 */
	public NCTDatabaseAddExecutionTraceValuesJMS() {
		super();
	}

	/**
	 * NCT Database Add Execution Trace Values JMS
	 * 
	 * @param jmsExecutionId
	 * 				JMS execution ID
	 * 
	 * @param jmsFlowExecutionId
	 * 				JMS flow execution ID
	 * 
	 * @param messageRecordCound
	 * 				Message record count
	 * 
	 * @param readCount
	 * 				Read count
	 * 
	 * @param writeCount
	 * 				Write count
	 * 
	 * @param readSkipCount
	 * 				Read skip count
	 * 
	 * @param writeSkipCount
	 * 				Write skip count
	 */
	public NCTDatabaseAddExecutionTraceValuesJMS(int jmsExecutionId, int jmsFlowExecutionId, Integer messageRecordCound,
			Integer readCount, Integer writeCount, Integer readSkipCount, Integer writeSkipCount) {
		super();
		this.jmsExecutionId = jmsExecutionId;
		this.jmsFlowExecutionId = jmsFlowExecutionId;
		this.messageRecordCound = messageRecordCound;
		this.readCount = readCount;
		this.writeCount = writeCount;
		this.readSkipCount = readSkipCount;
		this.writeSkipCount = writeSkipCount;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement ps = connection.prepareCall("exec batchTrace.spAddExecutionTraceValuesJMS ?,?,?,?,?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jmsExecutionId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.jmsFlowExecutionId);
	
			if (this.messageRecordCound != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.messageRecordCound);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
	
			if (this.readCount != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.readCount);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.INTEGER);
			}
	
			if (this.writeCount != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.writeCount);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.INTEGER);
			}
	
			if (this.readSkipCount != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.readSkipCount);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.INTEGER);
			}
	
			if (this.writeSkipCount != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.writeSkipCount);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchProcessingOperationException(ex.getMessage(), ex.getCause());
	}

}

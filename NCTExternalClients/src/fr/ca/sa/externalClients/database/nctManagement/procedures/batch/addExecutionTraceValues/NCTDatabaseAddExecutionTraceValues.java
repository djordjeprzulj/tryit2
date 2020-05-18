package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.addExecutionTraceValues;

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
 * Store procedure handler for tracing batch processing summary
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseAddExecutionTraceValues extends AbstractStoreProcedureHandler {
	
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseAddExecutionTraceValues.class);

	private int jobExecutionId;
	private int flowExecutionId;
	private Integer fileRecordCount;
	private Integer readCount;
	private Integer writeCount;
	private Integer readSkipCount;
	private Integer writeSkipCount;
	private String filename;

	/**
	 * default constructor for NCT Database Add Execution Trace Values
	 */
	public NCTDatabaseAddExecutionTraceValues() {
		super();
	}

	/**
	 * NCT Database Add Execution Trace Values
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param flowExecutionId
	 * 				Flow execution ID
	 * 
	 * @param fileRecordCount
	 * 				File record count
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
	 * 
	 * @param filename
	 * 				Filename
	 */
	public NCTDatabaseAddExecutionTraceValues(int jobExecutionId, int flowExecutionId, Integer fileRecordCount,
			Integer readCount, Integer writeCount, Integer readSkipCount, Integer writeSkipCount, String filename) {
		super();
		this.jobExecutionId = jobExecutionId;
		this.flowExecutionId = flowExecutionId;
		this.fileRecordCount = fileRecordCount;
		this.readCount = readCount;
		this.writeCount = writeCount;
		this.readSkipCount = readSkipCount;
		this.writeSkipCount = writeSkipCount;
		this.filename = filename;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement ps = connection.prepareCall("exec batchTrace.spAddExecutionTraceValues ?,?,?,?,?,?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jobExecutionId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.flowExecutionId);
			
			if (this.fileRecordCount != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.fileRecordCount);
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
			
			if (this.filename != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_8, this.filename);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.NVARCHAR);
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
		throw new BatchProcessingOperationException(ex.getMessage(),ex.getCause());
	}

}

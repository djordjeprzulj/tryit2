package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobsByScheduleId;

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
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetJobsByScheduleId extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetJobsByScheduleId.class);

	private Integer scheduleId;

	/**
	 * default constructor for NCT Database Get Jobs By Schedule ID
	 */
	public NCTDatabaseGetJobsByScheduleId() {
		super();
	}

	/**
	 * NCT Database Get Jobs By Schedule ID
	 * 
	 * @param scheduleId
	 * 				Schedule ID
	 */
	public NCTDatabaseGetJobsByScheduleId(int scheduleId) {
		super();
		this.scheduleId = scheduleId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetJobsByScheduleId ?,?");
		try {
			ps.setNull(NCTDatabaseConstants.SP_ARG_NR_1, Types.INTEGER);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.scheduleId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}			
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		JobItemList jobItemList = new JobItemList();
		try {
			while (this.getResultSet().next()) {
				jobItemList.getJobList()
						.add(new JobItem(this.getResultSet().getInt("JOB_ID"), this.getResultSet().getString("NAME"),
								this.getResultSet().getString("DESCRIPTION"),
								this.getResultSet().getInt("JOB_JOB_SCHEDULE_ID")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
		}
		return jobItemList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		LOGGER.error(ex);
		throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
	}

}

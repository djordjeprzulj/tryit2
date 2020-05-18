package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getTodaysSchedules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobDailySchedules.JobDailyScheduleItem;
import fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobDailySchedules.JobDailyScheduleItemList;

/**
 * 
 * Store procedure handler for getting bank advisors
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetJobDailySchedule extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetJobDailySchedule.class);

	/**
	 * default constructor for NCT Database Get Job Daily Schedule
	 */
	public NCTDatabaseGetJobDailySchedule() {
		super();
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetTodaysSchedules ?");
		try {
			ps.setNull(NCTDatabaseConstants.SP_ARG_NR_1, Types.INTEGER);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		JobDailyScheduleItemList retList = new JobDailyScheduleItemList();
		try {
			while (this.getResultSet().next()) {
				retList.getJobDailyScheduleList()
						.add(new JobDailyScheduleItem(this.getResultSet().getInt("JOB_SCHEDULE_ID"),
								this.getResultSet().getString("NAME"), this.getResultSet().getString("DESCRIPTION"),
								this.getResultSet().getTime("OCCURS_ONCE_AT"),
								this.getResultSet().getInt("OCCURS_EVERY_MINUTES")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new LoadingConfigurationException();
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchProcessingOperationException(ex.toString(), ex.getCause());
	}

}

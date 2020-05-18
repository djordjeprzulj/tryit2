package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobDailySchedules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetJobDailySchedules extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetJobDailySchedules.class);

	/**
	 * default constructor for NCT Database Get Job Daily Schedules
	 */
	public NCTDatabaseGetJobDailySchedules() {
		super();
	}

	/**
	 * NCT Database Get Job Daily Schedules
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetJobDailySchedules(int userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetJobDailySchedules ?");
		try {
			setUser(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetJobDailySchedulesNCTResultList retList = new GetJobDailySchedulesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getJobDailySchedules().add(new GetJobDailySchedulesNCTResultItem(
						this.getResultSet().getInt("JOB_SCHEDULE_ID"),
						this.getResultSet().getInt("FLO_FLOW_PROCESS_PERIOD_TYPE_ID"),
						this.getResultSet().getString("NAME"), this.getResultSet().getString("DESCRIPTION"),
						this.getResultSet().getString("OCCURS_ONCE_AT"),
						this.getResultSet().getInt("OCCURS_EVERY_MINUTES"),
						this.getResultSet().getInt("OCCURS_ON_MONDAY"), this.getResultSet().getInt("OCCURS_ON_TUESDAY"),
						this.getResultSet().getInt("OCCURS_ON_WEDNESDAY"),
						this.getResultSet().getInt("OCCURS_ON_THURSDAY"),
						this.getResultSet().getInt("OCCURS_ON_FRIDAY"),
						this.getResultSet().getInt("OCCURS_ON_SATURDAY"),
						this.getResultSet().getInt("OCCURS_ON_SUNDAY"), this.getResultSet().getTimestamp("START_DATE"),
						this.getResultSet().getTimestamp("END_DATE")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new BatchCRUDException(ErrorConstants.ERROR_MSG_GET_JOB_DAILY_SCHEDULE);
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchCRUDException(ErrorConstants.ERROR_MSG_GET_JOB_DAILY_SCHEDULE);
	}

}

package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.setJobDailySchedules;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Types;
import java.text.ParseException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseSetJobDailySchedules extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetJobDailySchedules.class);

	private Integer jobScheduleId;
	private String name;
	private String description;
	private Time occursOnceAt;
	private Integer occursEveryMinutes;
	private Date startDate;
	private Date endDate;
	private Integer occursOnMonday;
	private Integer occursOnTuesday;
	private Integer occursOnWednesday;
	private Integer occursOnThursday;
	private Integer occursOnFriday;
	private Integer occursOnSaturday;
	private Integer occursOnSunday;

	/**
	 * default constructor for NCT Database Set Job Daily Schedules
	 */
	public NCTDatabaseSetJobDailySchedules() {
		super();
	}

	/**
	 * NCT Database Set Job Daily Schedules
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param jobScheduleId	
	 * 				Job schedule ID
	 * 
	 * @param name
	 * 				Name
	 * 
	 * @param description
	 * 				Description
	 * 
	 * @param occursOnceAt
	 * 				Occurs once at
	 * 
	 * @param occursEveryMinutes
	 * 				Occurs every x minutes
	 * 
	 * @param startDate
	 * 				Start date
	 * 
	 * @param endDate
	 * 				End date
	 * 
	 * @param occursOnMonday
	 * 				Occurs on Monday
	 * 
	 * @param occursOnTuesday
	 * 				Occurs on Tuesday
	 * 
	 * @param occursOnWednesday
	 * 				Occurs on Wednesday
	 * 
	 * @param occursOnThursday
	 * 				Occurs on Thursday
	 * 
	 * @param occursOnFriday
	 * 				Occurs on Friday
	 * 
	 * @param occursOnSaturday
	 * 				Occurs on Saturday
	 * 
	 * @param occursOnSunday
	 * 				Occurs on Sunday
	 * 
	 * @throws ParseException
	 * 				Throws parse exception
	 */
	public NCTDatabaseSetJobDailySchedules(int userId, Integer jobScheduleId, String name, String description,
			Time occursOnceAt, Integer occursEveryMinutes, Date startDate, Date endDate, int occursOnMonday,
			int occursOnTuesday, int occursOnWednesday, int occursOnThursday, int occursOnFriday, int occursOnSaturday,
			int occursOnSunday) throws ParseException {
		super(userId);
		this.jobScheduleId = jobScheduleId;
		this.name = name;
		this.description = description;
		this.occursOnceAt = occursOnceAt;
		this.occursEveryMinutes = occursEveryMinutes;
		this.startDate = startDate;
		this.endDate = endDate;

		this.occursOnMonday = occursOnMonday;
		this.occursOnTuesday = occursOnTuesday;
		this.occursOnWednesday = occursOnWednesday;
		this.occursOnThursday = occursOnThursday;
		this.occursOnFriday = occursOnFriday;
		this.occursOnSaturday = occursOnSaturday;
		this.occursOnSunday = occursOnSunday;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection
				.prepareStatement("exec batch.spSetJobDailySchedules ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
	
			if (this.jobScheduleId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.jobScheduleId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			if (this.name != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.name);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.VARCHAR);
			}
	
			if (this.description != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.description);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.VARCHAR);
			}
	
			if (this.occursOnceAt != null) {
				ps.setTime(NCTDatabaseConstants.SP_ARG_NR_5, this.occursOnceAt);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.VARCHAR);
			}
	
			if (this.occursEveryMinutes != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.occursEveryMinutes);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.INTEGER);
			}
	
			if (this.startDate != null) {
				ps.setDate(NCTDatabaseConstants.SP_ARG_NR_7, this.startDate);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.TIMESTAMP);
			}
	
			if (this.endDate != null) {
				ps.setDate(NCTDatabaseConstants.SP_ARG_NR_8, this.endDate);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.TIMESTAMP);
			}
	
			if (this.occursOnMonday != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_9, this.occursOnMonday);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, Types.INTEGER);
			}
	
			if (this.occursOnTuesday != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_10, this.occursOnTuesday);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_10, Types.INTEGER);
			}
	
			if (this.occursOnWednesday != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_11, this.occursOnWednesday);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_11, Types.INTEGER);
			}
	
			if (this.occursOnThursday != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_12, this.occursOnThursday);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_12, Types.INTEGER);
			}
	
			if (this.occursOnFriday != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_13, this.occursOnFriday);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_13, Types.INTEGER);
			}
	
			if (this.occursOnSaturday != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_14, this.occursOnSaturday);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_14, Types.INTEGER);
			}
	
			if (this.occursOnSunday != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_15, this.occursOnSunday);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_15, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetJobDailySchedulesNCTResultItem retValue = new SetJobDailySchedulesNCTResultItem();

		try {
			while (this.getResultSet().next()) {
				retValue = new SetJobDailySchedulesNCTResultItem(this.getResultSet().getInt("JobScheduleId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new BatchCRUDException(ErrorConstants.ERROR_MSG_SET_JOB_DAILY_SCHEDULE);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchCRUDException(ErrorConstants.ERROR_MSG_SET_JOB_DAILY_SCHEDULE);
	}

}

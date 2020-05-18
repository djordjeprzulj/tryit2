package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.setJobs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting batch job
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseSetJobs extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetJobs.class);

	private Integer jobId;
	private String name;
	private String description;
	private int jobScheduleId;
	private int flowDirectionTypeId;
	private int flowProcessPeriodTypeId;
	private int isActive;

	/**
	 * NCT Database Set Jobs
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param jobId
	 * 				Job ID
	 * 
	 * @param name
	 * 				Name of job
	 * 
	 * @param description
	 * 				Description of job
	 * 
	 * @param jobScheduleId
	 * 				Job schedule ID
	 * 
	 * @param flowDirectionTypeId
	 * 				Flow direction type ID
	 * 
	 * @param flowProcessPeriodTypeId
	 * 				Flow process period type ID
	 * 
	 * @param isActive
	 * 				Activity
	 */
	public NCTDatabaseSetJobs(int userId, Integer jobId, String name, String description, int jobScheduleId,
			int flowDirectionTypeId, int flowProcessPeriodTypeId, int isActive) {
		super(userId);
		this.jobId = jobId;
		this.name = name;
		this.description = description;
		this.jobScheduleId = jobScheduleId;
		this.flowDirectionTypeId = flowDirectionTypeId;
		this.flowProcessPeriodTypeId = flowProcessPeriodTypeId;
		this.isActive = isActive;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spSetJobs ?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
	
			if (this.jobId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.jobId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.jobScheduleId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.flowDirectionTypeId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.flowProcessPeriodTypeId);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.name);
	
			if (this.description != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_7, this.description);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.VARCHAR);
			}
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.isActive);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetJobsNCTResultItem retValue = new SetJobsNCTResultItem();

		try {
			while (this.getResultSet().next()) {
				retValue.setJobId(this.getResultSet().getInt("JobId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new BatchCRUDException(ErrorConstants.ERROR_MSG_SET_JOB);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchCRUDException(ErrorConstants.ERROR_MSG_SET_JOB);
	}
}

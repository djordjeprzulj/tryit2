package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobExecutionsByDate;

import java.sql.Connection;
import java.sql.Date;
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
 * Store procedure handler for getting job executions for date
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetJobExecutionsByDate extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetJobExecutionsByDate.class);

	private Date jobExecutionDate;

	/**
	 * default constructor for NCT Database Get Job Executions By Date
	 */
	public NCTDatabaseGetJobExecutionsByDate() {
		super();
	}

	/**
	 * NCT Database Get Job Executions By Date
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param jobExecutionDate
	 * 				Job execution date
	 */
	public NCTDatabaseGetJobExecutionsByDate(Integer userId, Date jobExecutionDate) {
		super(userId);		
		this.jobExecutionDate = jobExecutionDate;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batchTrace.spGetJobExecutionsByDate ?,?");
		try {
			setUser(ps);
			if (this.jobExecutionDate != null) {
				ps.setDate(NCTDatabaseConstants.SP_ARG_NR_2, this.jobExecutionDate);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.DATE);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetJobExecutionsByDateNCTResultList retList = new GetJobExecutionsByDateNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getJobExecutionsByDate().add(new GetJobExecutionsByDateNCTResultItem(
						this.getResultSet().getInt("JobId"), this.getResultSet().getString("JobName"),
						this.getResultSet().getInt("JobExecutionId"), this.getResultSet().getString("JobStartOrigin"),
						this.getResultSet().getDate("TransferDate"),
						this.getResultSet().getString("JobExecutionCurrentStatus"),
						this.getResultSet().getString("HostName"), this.getResultSet().getTimestamp("StartTime"),
						this.getResultSet().getTimestamp("EndTime"), this.getResultSet().getString("ExitMessage"),
						this.getResultSet().getInt("ErrorOccurred"), this.getResultSet().getInt("TransferInProgress"),
						this.getResultSet().getTimestamp("LastUpdate")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new BatchCRUDException(ErrorConstants.ERROR_MSG_GET_JOB_EXECUTIONS_BY_DATE);
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchCRUDException(ErrorConstants.ERROR_MSG_GET_JOB_EXECUTIONS_BY_DATE);
	}

}

package fr.ca.sa.externalClients.database.nctManagement.procedures.nonWorkingDays.setBankNonWorkingDays;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.NonWorkingDaysCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting (deleting) non working day
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseSetBankNonWorkingDays extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetBankNonWorkingDays.class);

	private Integer dayId;
	private Timestamp closedTime;
	private String closedDescription;

	/**
	 * NCT Database Set Bank NonWorking Days
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param dayId
	 * 				Day ID
	 * 
	 * @param closedTime
	 * 				Closed time
	 * 
	 * @param closedDescription
	 * 				Closed description
	 */
	public NCTDatabaseSetBankNonWorkingDays(int userId, Integer dayId, String closedTime, String closedDescription) {
		super(userId);
		this.dayId = dayId;
		this.closedTime = closedTime != null ? Timestamp.valueOf(closedTime) : null;
		this.closedDescription = closedDescription;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetBankNonWorkingDays ?,?,?,?");
		try {
			setUser(ps);
	
			if (this.dayId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.dayId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			if (this.closedTime != null) {
				ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_3, this.closedTime);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.TIMESTAMP);
			}
	
			if (this.closedDescription != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.closedDescription);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.VARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {

		SetBankNonWorkingDaysNCTResultItem retValue = new SetBankNonWorkingDaysNCTResultItem();

		try {
			while (this.getResultSet().next()) {
				retValue = new SetBankNonWorkingDaysNCTResultItem(this.getResultSet().getInt("DayId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new NonWorkingDaysCRUDException(ErrorConstants.ERROR_MSG_SET_NON_WORKING_DAYS);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new NonWorkingDaysCRUDException(ErrorConstants.ERROR_MSG_SET_NON_WORKING_DAYS);
	}
}

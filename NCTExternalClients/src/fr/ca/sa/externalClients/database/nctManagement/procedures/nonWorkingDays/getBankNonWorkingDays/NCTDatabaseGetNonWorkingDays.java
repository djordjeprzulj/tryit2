package fr.ca.sa.externalClients.database.nctManagement.procedures.nonWorkingDays.getBankNonWorkingDays;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.NonWorkingDaysCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetNonWorkingDays extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetNonWorkingDays.class);

	/**
	 * NCT Database Get NonWorking Days
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetNonWorkingDays(int userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetBankNonWorkingDays ?");
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
		GetBankNonWorkingDaysNCTResultList retList = new GetBankNonWorkingDaysNCTResultList();

		try {
			while (this.getResultSet().next()) {
				retList.getNonWorkingDays()
						.add(new GetBankNonWorkingDaysNCTResultItem(this.getResultSet().getInt("DAY_ID"),
								this.getResultSet().getTimestamp("CLOSED_DATE"),
								this.getResultSet().getString("DESCRIPTION")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new NonWorkingDaysCRUDException(ErrorConstants.ERROR_MSG_GET_NON_WORKING_DAYS);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new NonWorkingDaysCRUDException(ErrorConstants.ERROR_MSG_GET_NON_WORKING_DAYS);
	}

}

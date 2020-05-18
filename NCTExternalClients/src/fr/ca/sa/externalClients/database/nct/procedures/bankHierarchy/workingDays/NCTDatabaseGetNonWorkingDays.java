package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.workingDays;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetNonWorkingDays extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetNonWorkingDays.class);

	/**
	 * default constructor for NCT Database Get NonWorking Days
	 */
	public NCTDatabaseGetNonWorkingDays() {
		super();
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetBankNonWorkingDays");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		NonWorkingDaysList nWDaysList = new NonWorkingDaysList();
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.getBackboneOnlyDateDatetimeFormat());
		try {
			while (this.getResultSet().next()) {
				nWDaysList.getNonWorking().add(formatter.format(this.getResultSet().getTimestamp("CLOSED_DATE")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return nWDaysList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

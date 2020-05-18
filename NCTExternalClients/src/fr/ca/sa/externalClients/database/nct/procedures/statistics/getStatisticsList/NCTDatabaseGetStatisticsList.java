package fr.ca.sa.externalClients.database.nct.procedures.statistics.getStatisticsList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.PortfoliosCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for getting statistics list
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetStatisticsList extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetStatisticsList.class);

	/**
	 * NCT Database Get Statistics List
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetStatisticsList(Integer userId, int langId) {
		super(userId, langId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetStatisticsList ?,?");
		try {
			setUserAndLanguage(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}	
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetStatisticsListResultList retValue = new GetStatisticsListResultList();

		try {
			while (this.getResultSet().next()) {
				retValue.getStatisticsList().add(new GetStatisticsListResultItem(
						this.getResultSet().getInt("StatisticId"), this.getResultSet().getString("StatisticName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_STATISTICS_LIST);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_STATISTICS_LIST);
	}
}

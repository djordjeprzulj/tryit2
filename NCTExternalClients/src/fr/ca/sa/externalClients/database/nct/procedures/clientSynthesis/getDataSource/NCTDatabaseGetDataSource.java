package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Store procedure call for handling data sources
 * 
 * 
 * @author Djordje Przulj
 *
 */
public class NCTDatabaseGetDataSource extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetDataSource.class);

	/**
	 * NCT Database Get Data Source
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param languageId
	 * 				Language ID
	 */
	public NCTDatabaseGetDataSource(int userId, int languageId) {
		super(userId, languageId);	
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetDataSource ?,?");
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
		GetDataSourceResultList retValue = new GetDataSourceResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getDataSources().add(new GetDataSourceResultItem(
						this.getResultSet().getInt("DataSourceId"),
						this.getResultSet().getString("DataSourceName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new StatementExecutionException(ErrorConstants.DEFAULT_ERROR_MSG);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new StatementExecutionException(ErrorConstants.DEFAULT_ERROR_MSG);
	}

}

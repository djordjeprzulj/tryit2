package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.getCountries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting countries
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetCountries extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetCountries.class);

	/**
	 * NCT Database Get Countries
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetCountries(Integer userId, Integer langId) {
		super(userId, langId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetCountries ?,?");
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
		GetCountriesNCTResultList retList = new GetCountriesNCTResultList();

		try {
			while (this.getResultSet().next()) {
				retList.getCountries().add(new GetCountriesNCTResultItem(this.getResultSet().getInt("CountryId"),
						this.getResultSet().getString("CountryCode"), this.getResultSet().getString("CountryISOCode2"),
						this.getResultSet().getString("CountryISOCode3"),
						this.getResultSet().getString("CountryPhoneCode"),
						this.getResultSet().getString("CountryName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

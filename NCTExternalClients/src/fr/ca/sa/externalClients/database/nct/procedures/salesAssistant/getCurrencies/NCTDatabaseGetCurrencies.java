package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getCurrencies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting currencies from db catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetCurrencies extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetCurrencies.class);

	/**
	 * NCT Database Get Currencies
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetCurrencies(Integer userId) {
		super(userId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetCurrencies ?");
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
		GetCurrenciesNCTResultList retValue = new GetCurrenciesNCTResultList();
		try {
			while (this.getResultSet().next()) {

				retValue.getCurrencies().add(new GetCurrenciesNCTResultItem(this.getResultSet().getInt("CurrencyId"),
						this.getResultSet().getString("CurrencyName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}
}

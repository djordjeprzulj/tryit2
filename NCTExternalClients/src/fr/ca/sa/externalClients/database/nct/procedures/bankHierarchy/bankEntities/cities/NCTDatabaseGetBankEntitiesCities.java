package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.cities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting cities for bank entities
 * 
 * @author Milivoj Bozic
 *
 */
public class NCTDatabaseGetBankEntitiesCities extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankEntitiesCities.class);

	/**
	 * default constructor for NCT Database Get Bank Entities Cities
	 */
	public NCTDatabaseGetBankEntitiesCities() {
		super();
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetCity");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		ArrayList<String> items = new ArrayList<String>();
		try {
			while (this.getResultSet().next()) {
				items.add(this.getResultSet().getString("CityName"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return new GetBankEntitiesCitiesNCTResultList(items);
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

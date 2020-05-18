package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.regions;

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
 * Store procedure handler for getting regions for bank entities
 * 
 * @author Milivoj Bozic
 *
 */
public class NCTDatabaseGetBankEntitiesRegions extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankEntitiesRegions.class);

	/**
	 * default constructor for NCT Database Get Bank Entities Regions
	 */
	public NCTDatabaseGetBankEntitiesRegions() {
		super();
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetRegion");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		ArrayList<String> items = new ArrayList<String>();
		try {
			while (this.getResultSet().next()) {
				items.add(this.getResultSet().getString("RegionName"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return new GetBankEntitiesRegionsNCTResultList(items);
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.functions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting functions for bank entities
 * 
 * @author Milivoj Bozic
 *
 */
public class NCTDatabaseGetBankEntitiesFunctions extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankEntitiesFunctions.class);

	/**
	 * default constructor for NCT Database Get Bank Entities Functions
	 */
	public NCTDatabaseGetBankEntitiesFunctions() {
		super();
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetFunction");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		HashMap<Integer, String> items = new HashMap<Integer, String>();
		try {
			while (this.getResultSet().next()) {
				items.put(this.getResultSet().getInt("FunctionId"), this.getResultSet().getString("FunctionName"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return new GetBankEntitiesFunctionsNCTResultList(items);
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

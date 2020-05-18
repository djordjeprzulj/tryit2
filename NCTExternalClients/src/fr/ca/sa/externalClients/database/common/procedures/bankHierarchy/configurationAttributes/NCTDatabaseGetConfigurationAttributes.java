package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationAttributes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting bank configuration attributes
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetConfigurationAttributes extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetConfigurationAttributes.class);

	/**
	 * default constructor for NCT Database Get Configuration Attributes
	 */
	public NCTDatabaseGetConfigurationAttributes() {
		super();
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetCONFIGURATION_ATTRIBUTES");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetConfigurationAttributesNCTResultList retList = new GetConfigurationAttributesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getParameters()
						.add(new GetConfigurationAttributesNCTResultItem(
								this.getResultSet().getString("BANK_CONFIGURATION_TYPE_NAME"),
								this.getResultSet().getString("ATTRIBUT_NAME")));
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

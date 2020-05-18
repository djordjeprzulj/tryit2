package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.getBankHierarchy;

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
 * Store procedure handler for getting bank hierarchy
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetBankHierarchy extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankHierarchy.class);

	/**
	 * default constructor for NCT Database Get Bank Hierarchy
	 */
	public NCTDatabaseGetBankHierarchy() {
		super();
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetBankHierarchy");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetBankHierarchyNCTResultList retList = new GetBankHierarchyNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getEntities()
						.add(new GetBankHierarchyNCTResultItem(this.getResultSet().getInt("ENTITY_ID"),
								this.getResultSet().getString("ENTITY_NAME"), this.getResultSet().getInt("PARENT_ID"),
								this.getResultSet().getInt("LEVEL")));
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

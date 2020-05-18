package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.clientTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting bank client types
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetClientTypes extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientTypes.class);

	/**
	 * default constructor for NCT Database Get Client Types
	 */
	public NCTDatabaseGetClientTypes() {
		super();
	}

	/**
	 * NCT Database Get Client Types
	 * 
	 * @param userId
	 *            User ID
	 */
	public NCTDatabaseGetClientTypes(Integer userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetBankClientTypes ?");
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
		GetClientTypesNCTResultList retList = new GetClientTypesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getClientTypes()
						.add(new GetClientTypesNCTResultItem(this.getResultSet().getInt("CLIENT_TYPE_ID"),
								this.getResultSet().getString("CLIENT_TYPE_NAME")));
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

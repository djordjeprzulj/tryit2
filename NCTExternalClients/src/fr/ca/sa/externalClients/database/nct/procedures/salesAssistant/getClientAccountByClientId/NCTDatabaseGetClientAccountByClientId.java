package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientAccountByClientId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting client account by client ID 
 * 
 * @author Jelena Raca
 *
 */
public class NCTDatabaseGetClientAccountByClientId extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientAccountByClientId.class);
	
	private String clientId;

	/**
	 * NCT Database Get Client Account By Client ID
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseGetClientAccountByClientId(Integer userId, String clientId) {
		super(userId);
		this.clientId = clientId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetClientAccountByClientId ?,?");
		try {		
			setUser(ps);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.clientId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}		
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetClientAccountByClientIdNCTResultList retValue = new GetClientAccountByClientIdNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getClientAccounts()
						.add(new GetClientAccountByClientIdNCTResultItem(this.getResultSet().getString("AccountNb")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException();
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException();
	}
}
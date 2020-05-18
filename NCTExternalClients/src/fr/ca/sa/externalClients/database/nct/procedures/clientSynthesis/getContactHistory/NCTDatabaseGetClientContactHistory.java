package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getContactHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ClientCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure call for handling contact history
 * 
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetClientContactHistory extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientContactHistory.class);

	private int clientId;

	/**
	 * NCT Database Get Client Contact History
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param clientId
	 * 				Client ID
	 */
	public NCTDatabaseGetClientContactHistory(int userId, int clientId) {
		super(userId);
		this.clientId = clientId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetContactHistoryByClientId ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.clientId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetClientContactHistoryResultList retValue = new GetClientContactHistoryResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getContactHistory().add(new GetClientContactHistoryResultItem(
						this.getResultSet().getInt("ContactId"), this.getResultSet().getInt("ContactTypeId"),
						this.getResultSet().getTimestamp("ContactDate"), this.getResultSet().getInt("ChannelId"),
						this.getResultSet().getInt("NumberOfSoldProducts"),
						this.getResultSet().getString("ExternalLink"), 
						this.getResultSet().getString("C_L"),
						this.getResultSet().getInt("DataSource")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new ClientCRUDException(ErrorConstants.ERROR_MSG_GET_USER_INFO);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ClientCRUDException(ErrorConstants.ERROR_MSG_GET_USER_INFO);
	}

}

package fr.ca.sa.externalClients.database.nct.procedures.users.getUserMessagesAndAlerts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.UserCRUDException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Database procedure for delete user message from
 * Database
 * 
 * @author Milivoj Bozic
 *
 */
public class NCTDatabaseDeleteUserMessage extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseDeleteUserMessage.class);

	private Integer clientId;
	private Integer messageId;

	/**
	 * NCT Database Get User Messages And Alerts
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param messageId
	 * 				Message ID
	 */
	public NCTDatabaseDeleteUserMessage(int userId, Integer clientId, Integer messageId) {
		super(userId);
		this.clientId = clientId;
		this.messageId = messageId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spDeleteMessages ?,?,?");
		try {
			setUser(ps);
			if (this.messageId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.messageId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
			if (this.clientId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.clientId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		try {
			while (this.getResultSet().next()) {
				// not used, add later if needed
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new UserCRUDException(ErrorConstants.ERROR_MSG_DELETE_USER_MESSAGES);
		}

		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new UserCRUDException(ErrorConstants.ERROR_MSG_DELETE_USER_MESSAGES);
	}
}

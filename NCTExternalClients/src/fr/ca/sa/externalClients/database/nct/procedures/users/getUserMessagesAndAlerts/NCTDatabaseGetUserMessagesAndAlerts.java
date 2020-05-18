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
 * Database procedure for retrieving for all user messages and alerts from
 * Database
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetUserMessagesAndAlerts extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetUserMessagesAndAlerts.class);

	private Integer clientId;

	/**
	 * NCT Database Get User Messages And Alerts
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param clientId
	 * 				Client ID
	 */
	public NCTDatabaseGetUserMessagesAndAlerts(int userId, Integer clientId) {
		super(userId);
		this.clientId = clientId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetActiveMessagesByUser ?,?");
		try {
			setUser(ps);
			if (this.clientId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.clientId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetUserMessagesAndAlertsResultList retList = new GetUserMessagesAndAlertsResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getUserMessagesAndAlerts()
						.add(new GetUserMessagesAndAlertsItem(this.getResultSet().getInt("MessageId"),
								this.getResultSet().getString("MessageText"), this.getResultSet().getString("C_L"),
								this.getResultSet().getInt("ClientId"), this.getResultSet().getInt("ClientEntityId"),
								this.getResultSet().getInt("PortfolioId")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new UserCRUDException(ErrorConstants.ERROR_MSG_GET_USER_MESSAGES_AND_ALERTS);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new UserCRUDException(ErrorConstants.ERROR_MSG_GET_USER_MESSAGES_AND_ALERTS);
	}
}

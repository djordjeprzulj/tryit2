package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getGeneralClientOrigins;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ClientCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting client origins from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetClientOrigins extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientOrigins.class);

	/**
	 * NCT Database Get Client Origins
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetClientOrigins(Integer userId, Integer langId) {
		super(userId, langId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetClientOrigins ?,?");
		try {
			setUserAndLanguage(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetClientOriginsResultList retValue = new GetClientOriginsResultList();
		try {
			while (this.getResultSet().next()) {

				retValue.getOrigins().add(new GetClientOriginsResultItem(this.getResultSet().getInt("ClientOriginId"),
						this.getResultSet().getString("ClientOriginName")));
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

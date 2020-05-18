package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getClientDataByCoreId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ClientCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for getting user data based on core id from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetClientDataByCoreId extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientDataByCoreId.class);

	private long clientCoreId;

	/**
	 * NCT Database Get Client Data By Core ID
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param clientCoreId
	 * 				Client core ID
	 */
	public NCTDatabaseGetClientDataByCoreId(int userId, long clientCoreId) {
		super(userId);
		this.clientCoreId = clientCoreId;
	}

	public long getClientCoreId() {
		return clientCoreId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetClientDataByCoreId ?,?");
		try {
			setUser(ps);
			ps.setLong(NCTDatabaseConstants.SP_ARG_NR_2, this.clientCoreId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		StoreProcedureResult retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new GetClientDataByCoreIdNCTResult(this.getResultSet().getInt("ClientId"),
						this.getResultSet().getString("C_L"), this.getResultSet().getInt("ClientEntityId"),
						this.getResultSet().getInt("PortfolioId"));
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

package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getClientCodeTypeByClientId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ClientCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems.getCivilities.NCTDatabaseGetProspectClientCivilities;

/**
 *  Store procedure handler for getting client code type by client ID
 * 
 * @author Jelena Raca
 *
 */
public class NCTDatabaseGetClientCodeTypeByClientId extends AbstractUserStoreProcedureHandler  {
	
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetProspectClientCivilities.class);

	private Integer clientId;

	/**
	 * NCT Database Get Client Code Type By Client Id
	 * 
	 * @param userId
	 * 			ID of user
	 * 
	 * @param clientId
	 * 			Client ID
	 */
	public NCTDatabaseGetClientCodeTypeByClientId(Integer userId, Integer clientId) {
		super(userId);
		this.clientId = clientId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetClientCodeTypeByClientId ?,?");
		try {
			setUser(ps);
			if (this.clientId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.clientId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, java.sql.Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}


	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetClientCodeTypeByClientIdNCTResultItem retValue = new GetClientCodeTypeByClientIdNCTResultItem();
		try {
			while (this.getResultSet().next()) {
				retValue = new GetClientCodeTypeByClientIdNCTResultItem(this.getResultSet().getString("ClientCodeType"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new ClientCRUDException();
		}
		return retValue;
	}
	
	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ClientCRUDException();
		
	}
	

}

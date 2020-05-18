package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getClientDataByContactId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ClientCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting client data by taskId
 * 
 * @author Milos Topalovic
 *
 */
public class NCTDatabaseGetClientDataByContactId extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientDataByContactId.class);

	private Integer contactId;
	
	/**
	 * NCT Database Get Opportunities Categories
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param contactId
	 * 				Contact ID
	 */
	
	public NCTDatabaseGetClientDataByContactId(Integer userId, Integer contactId) {
		super(userId);
		this.contactId = contactId;
	}
	
	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetClientDataByContactId ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.contactId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetClientDataByContactIdNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue=new GetClientDataByContactIdNCTResultItem(this.getResultSet().getInt("ClientId"),
								this.getResultSet().getInt("ClientEntityId"), this.getResultSet().getInt("PortfolioId"),
								this.getResultSet().getString("C_L"), this.getResultSet().getInt("ContactTypeId"));
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

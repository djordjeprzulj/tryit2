package fr.ca.sa.externalClients.database.nct.procedures.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.OpportunitiesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.nct.commons.services.json.common.CancelOpportunity;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for canceling opportunities
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseCancelOpportunity extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseCancelOpportunity.class);
	
	private CancelOpportunity request;

	/**
	 * NCT Database Cancel Opportunity
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param request
	 * 				Request
	 */
	public NCTDatabaseCancelOpportunity(int userId, CancelOpportunity request) {
		super(userId);
		this.request = request;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		CallableStatement cs = connection.prepareCall("exec spAnnulOpportunity ?,?,?,?");
		try {
			setUser(cs);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.request.getOpportunityId());
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.request.getReasonId());
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.request.getCancelComment());
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_CANCEL_OPPORTUNITY);
	}
}

package fr.ca.sa.externalClients.database.nct.procedures.opportunities.reassignOpportunity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.OpportunitiesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.utilFunctions.TextUtilFunctions;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.nct.commons.services.json.event.ReassignOpportunity;

/**
 * 
 * Store procedure handler for reassigning opportunities
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseReassignOpportunity extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseReassignOpportunity.class);
	
	private ReassignOpportunity request;

	/**
	 * NCT Database Reassign Opportunity
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param request
	 * 				Request
	 */
	public NCTDatabaseReassignOpportunity(int userId, ReassignOpportunity request) {
		super(userId);
		this.request = request;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		CallableStatement cs = connection.prepareCall("exec spReassignOpportunity ?,?,?,?");
		try {
			setUser(cs);			
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.request.getBranchId());
			if (this.request.getCollaboratorId() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.request.getCollaboratorId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
			String idsString = TextUtilFunctions.convertIntArrayToSQLString(this.request.getOpportunityIds());
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_4, idsString);
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
		throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_REASSIGN_OPPORTUNITY);
	}
}

package fr.ca.sa.externalClients.database.nct.procedures.opportunities.setOpportunityTreatedReasons;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.OpportunitiesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting opportunity treated reason
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseSetOpportunityTreatedReasons extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetOpportunityTreatedReasons.class);
	
	private int opportunityId;
	private int opportunityTreatedReasonId;

	/**
	 * NCT Database Set Opportunity Treated Reasons
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 * @param opportunityTreatedReasonId
	 * 				Opportunity treated reason ID
	 */
	public NCTDatabaseSetOpportunityTreatedReasons(int userId, int opportunityId, int opportunityTreatedReasonId) {
		super(userId);
		this.opportunityId = opportunityId;
		this.opportunityTreatedReasonId = opportunityTreatedReasonId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		CallableStatement ps = connection.prepareCall("exec spSetOppReasonTreated ?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.opportunityId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.opportunityTreatedReasonId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_SET_OPPORTUNITIES_TREATED_REASONS);
	}
}

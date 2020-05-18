package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityTreatedReasons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.OpportunitiesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for getting opportunities treated reasons
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetOpportunityTreatedReasons extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOpportunityTreatedReasons.class);

	private int opportunityId;

	/**
	 * NCT Database Get Opportunity Treated Reasons
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetOpportunityTreatedReasons(int userId, int opportunityId, int langId) {
		super(userId, langId);		
		this.opportunityId = opportunityId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetOppReasonTreated ?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.opportunityId);
			setLanguage(ps, NCTDatabaseConstants.SP_ARG_NR_3);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetOpportunityTreatedReasonsNCTResultList retValue = new GetOpportunityTreatedReasonsNCTResultList();

		try {
			while (this.getResultSet().next()) {
				retValue.getOpportunityTreatedReasons()
						.add(new GetOpportunityTreatedReasonsNCTResultItem(
								this.getResultSet().getInt("OppReasonTreatedId"),
								this.getResultSet().getString("OppReasonTreatedName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_LOAD_OPPORTUNITIES_TREATED_REASONS);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_LOAD_OPPORTUNITIES_TREATED_REASONS);
	}
}

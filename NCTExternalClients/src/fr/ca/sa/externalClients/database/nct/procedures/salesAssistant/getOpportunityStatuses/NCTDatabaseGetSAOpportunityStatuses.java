package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getOpportunityStatuses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure for retrieving opportunity statuses
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetSAOpportunityStatuses extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetSAOpportunityStatuses.class);

	/**
	 * NCT Database Get Sales Assistant Opportunity Statuses
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param languageId
	 * 				Language ID
	 */
	public NCTDatabaseGetSAOpportunityStatuses(Integer userId, Integer languageId) {
		super(userId, languageId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssOpportStatuses ?,?");
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
		GetSAOpportunityStatusResultList resultList = new GetSAOpportunityStatusResultList();
		try {
			while (this.getResultSet().next()) {
				resultList.getOpportunityStatuses()
						.add(new GetSAOpportunityStatusResultItem(this.getResultSet().getInt("SalAssOpportStatusId"),
								this.getResultSet().getString("SalAssOpportStatusName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_OPP_STATUSES);
		}
		return resultList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_NEEDS);
	}
}

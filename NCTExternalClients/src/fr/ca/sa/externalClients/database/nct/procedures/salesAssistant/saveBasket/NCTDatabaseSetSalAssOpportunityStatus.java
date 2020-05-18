package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.saveBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.AbstractUserBasketStoreProcedureHandler;

/**
 * 
 * Store Procedure for setting sales assistant opportunity status
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetSalAssOpportunityStatus extends AbstractUserBasketStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetSalAssOpportunityStatus.class);
	
	private Integer opportunityId;

	private Integer salesAssOppStatusId;

	/**
	 * NCT Database Set Sale Assistant Opportunity Status
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param basketId
	 * 				Basket ID
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 * @param salesAssOppStatusId
	 * 				Sales assistant opportunity status ID
	 */
	public NCTDatabaseSetSalAssOpportunityStatus(int userId, Integer basketId, Integer opportunityId,
			Integer salesAssOppStatusId) {
		super(userId, basketId);
		this.opportunityId = opportunityId;
		this.salesAssOppStatusId = salesAssOppStatusId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spSetSalAssOpportList ?,?,?,?");
		try {
			setUserAndBasket(cs);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.opportunityId);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.salesAssOppStatusId);
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
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_SAVE_BASKET);
	}

}

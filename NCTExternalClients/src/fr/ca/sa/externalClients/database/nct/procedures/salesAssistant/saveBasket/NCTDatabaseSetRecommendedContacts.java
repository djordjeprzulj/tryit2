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
 * Store procedure for setting recommended contacts on the given basket
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetRecommendedContacts extends AbstractUserBasketStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetRecommendedContacts.class);
	
	private Integer prospectId;

	/**
	 * NCT Database Set Recommended Contacts
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param basketId
	 * 				Basket ID
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 */
	public NCTDatabaseSetRecommendedContacts(int userId, Integer basketId, Integer prospectId) {
		super(userId, basketId);
		this.prospectId = prospectId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetSalAssRecommendedList ?,?,?");		
		try {
			setUserAndBasket(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.prospectId);
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
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_SAVE_BASKET);
	}

}

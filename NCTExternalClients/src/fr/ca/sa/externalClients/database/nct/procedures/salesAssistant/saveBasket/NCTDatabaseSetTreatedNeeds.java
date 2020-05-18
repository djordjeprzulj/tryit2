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
 * Store procedure for setting treated needs for specific basket
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetTreatedNeeds extends AbstractUserBasketStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetTreatedNeeds.class);
	
	private Integer needCategoryId;

	/**
	 * NCT Database Set Treated Needs
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param basketId
	 * 				Basket ID
	 * 
	 * @param needCategoryId
	 * 				Need category ID
	 */
	public NCTDatabaseSetTreatedNeeds(int userId, Integer basketId, Integer needCategoryId) {
		super(userId, basketId);
		this.needCategoryId = needCategoryId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetSalAssTreatedNeedList ?,?,?");
		try {		
			setUserAndBasket(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.needCategoryId);
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

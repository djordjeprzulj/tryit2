package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.saveBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.AbstractUserBasketStoreProcedureHandler;

/**
 * 
 * Rollback procedure for deleting basket
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseRollbackBasket extends AbstractUserBasketStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseRollbackBasket.class);
	
	/**
	 * NCT Database Rollback Basket
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param basketId
	 * 				Basket ID
	 */
	public NCTDatabaseRollbackBasket(int userId, Integer basketId) {
		super(userId, basketId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spDeleteSalAssBasket ?,?");
		try {		
			setUserAndBasket(ps);
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

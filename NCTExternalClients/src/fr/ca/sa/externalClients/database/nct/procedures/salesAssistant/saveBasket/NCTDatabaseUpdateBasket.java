package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.saveBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.AbstractUserBasketStoreProcedureHandler;

/**
 * 
 * Update Basket store procedure handling
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseUpdateBasket extends AbstractUserBasketStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseUpdateBasket.class);

	private Integer originId;

	private String comment;

	private Integer channelId;

	/**
	 * NCT Database Update Basket
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param basketId
	 * 				Basket ID
	 * 
	 * @param originId
	 * 				Origin ID
	 * 
	 * @param comment
	 * 				Comment 
	 * 
	 * @param channelId
	 * 				Channel ID
	 */
	public NCTDatabaseUpdateBasket(int userId, int basketId, Integer originId, String comment, Integer channelId) {
		super(userId, basketId);
		this.originId = originId;
		this.comment = comment;
		this.channelId = channelId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetSalAssBasketDetails2 ?,?,?,?,?");
		try {
			setUserAndBasket(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.originId);
	
			if (this.channelId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.channelId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.INTEGER);
			}
	
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_5, this.comment);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}																						
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		CreateBasketResult retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new CreateBasketResult(this.getResultSet().getInt("SalAssBasketId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_SAVE_BASKET);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_SAVE_BASKET);
	}
}

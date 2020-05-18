package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.saveBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.Basket;

/**
 * 
 * Store Procedure for creating basket
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseCreateBasket extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseCreateBasket.class);

	private Basket basket;

	/**
	 * NCT Database Create Basket
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param basket
	 * 				Basket
	 * 
	 * 
	 * @throws ParseException
	 * 				Parse exception
	 */
	public NCTDatabaseCreateBasket(int userId, Basket basket) throws ParseException {
		super(userId);
		this.basket = basket;
/*
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
		this.basketDate = new Timestamp(formatter.parse(reportDate).getTime());
		*/
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetSalAssBasketDetails ?,?,?,?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
			SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			Timestamp tsBasketDate = new Timestamp(formatter.parse(basket.getBasketDate()).getTime());			
			ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_2, tsBasketDate);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.basket.getClient().getClientOrLead());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.basket.getClient().getId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.basket.getAdvisor().getPrimaryEntity().getId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.basket.getAdvisor().getId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.basket.getOriginId());
	
			if (this.basket.getChannelId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.basket.getChannelId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.INTEGER);
			}
	
			if (this.basket.getComment() != null && !this.basket.getComment().isEmpty()) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_9, this.basket.getComment());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, Types.VARCHAR);
			}
	
			if (this.basket.getAgendaElementId() != null && this.basket.getAgendaElementId() != -1) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_10, this.basket.getAgendaElementId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_10, Types.INTEGER);
			}
	
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_11, this.basket.getTimeSpent());
		} catch (Exception ex) {
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
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_PRODUCTS);
	}
}

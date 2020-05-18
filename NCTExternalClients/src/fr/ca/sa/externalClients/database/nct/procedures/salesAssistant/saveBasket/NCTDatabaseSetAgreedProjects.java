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
import fr.ca.sa.nct.commons.NCTSystemConstants;

/**
 * 
 * Store procedure for setting interested project for specific basket
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetAgreedProjects extends AbstractUserBasketStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetAgreedProjects.class);

	private Integer productId;
	private Double amount;
	private Integer numberOfPieces;
	private Integer currencyId;
	private Integer agreedOfferStatusId;
	private Integer agreedOfferTypeId;
	private Integer opportunityId;

	/**
	 * NCT Database Set Agreed Projects
	 * 
	 * @param userId              User ID
	 * 
	 * @param basketId            Basket ID
	 * 
	 * @param productId           Product ID
	 * 
	 * @param amount              Amount
	 * 
	 * @param numberOfPieces      Number of pieces
	 * 
	 * @param currencyId          Currency ID
	 * 
	 * @param agreedOfferStatusId Agreed offer status ID
	 * 
	 * @param agreedOfferTypeId   Agreed offer type ID
	 */
	public NCTDatabaseSetAgreedProjects(int userId, Integer basketId, Integer productId, Double amount,
			Integer numberOfPieces, Integer currencyId, Integer agreedOfferStatusId, Integer agreedOfferTypeId,
			Integer opportunityId) {
		super(userId, basketId);
		this.productId = productId;
		this.amount = amount;
		this.numberOfPieces = numberOfPieces;
		this.currencyId = currencyId;
		this.agreedOfferStatusId = agreedOfferStatusId;
		this.agreedOfferTypeId = agreedOfferTypeId;
		this.opportunityId = opportunityId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetSalAssOfferAgreedList ?,?,?,?,?,?,?,?,?");
		try {
			setUserAndBasket(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.productId);

			if (this.amount != null && this.amount != -1) {
				ps.setDouble(NCTDatabaseConstants.SP_ARG_NR_4, this.amount);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.DOUBLE);
			}

			if (this.currencyId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.currencyId);
			} else {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5,
						NCTSystemConstants.getCurrenciesConfig().getCurrencies().get(0).getCurrencyId());
			}

			if (this.numberOfPieces != null && this.numberOfPieces != -1) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.numberOfPieces);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.INTEGER);
			}
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.agreedOfferStatusId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.agreedOfferTypeId);

			if (this.opportunityId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_9, this.opportunityId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, Types.INTEGER);
			}
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

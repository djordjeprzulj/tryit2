package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetBasketAgreedOffers extends AbstractUserBasketDataSourceProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBasketAgreedOffers.class);

	/**
	 * Constructor for all fields initialization.
	 * 
	 * @param userId User ID
	 * @param basketId Basket ID
	 * @param dataSource Data source
	 */
	public NCTDatabaseGetBasketAgreedOffers(int userId, int basketId, String dataSource) {
		super(userId, basketId, dataSource);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssBasketAgreedOffers ?,?,?");
		try {
			setUserBasketAndDataSource(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetBasketAgreedOffersListImages returnList = new GetBasketAgreedOffersListImages();
		try {
			while (this.getResultSet().next()) {

				returnList.getImagesMapByName(GetBasketAgreedOffersListImages.PRODUCT_GROUP_PIC_MAP_NAME)
						.put(String.valueOf(this.getResultSet().getInt("ProductGroupId")), null);

				returnList.getAgreed().getAgreedList()
						.add(new GetBasketAgreedOffersItem(this.getResultSet().getInt("ProductId"),
								this.getResultSet().getString("ProductNameL1"),
								this.getResultSet().getString("ProductNameL2"), this.getResultSet().getDouble("Amount"),
								this.getResultSet().getInt("CurrencyId"), this.getResultSet().getInt("NumberOfPieces"),
								this.getResultSet().getInt("ProductOwnedByClient"),
								this.getResultSet().getInt("AgreedOfferStatusId"),
								this.getResultSet().getInt("AgreedOfferTypeId"),
								this.getResultSet().getInt("ProductGroupId")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_BASKET);
		}

		return returnList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_BASKET);
	}
}

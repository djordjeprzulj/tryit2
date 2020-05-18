package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.Basket;
import fr.ca.sa.model.Client;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetBasketDetails extends AbstractUserBasketDataSourceProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBasketDetails.class);	

	/**
	 * Constructor for all fields initialization.
	 * 
	 * @param userId User ID
	 * @param basketId Basket ID
	 * @param dataSource Data source
	 */
	public NCTDatabaseGetBasketDetails(int userId, int basketId, String dataSource) {
		super(userId, basketId, dataSource);		
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssBasketDetails ?,?,?");
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
		GetBasketDetailsResponse basketDetails = null;
		try {
			while (this.getResultSet().next()) {
				Collaborator advisor = new Collaborator(this.getResultSet().getInt("AdvisorId"), null, null, null);
				advisor.setName(this.getResultSet().getString("AdvisorName"));
				SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
				String basketDate = formatter.format(this.getResultSet().getTimestamp("BasketDate"));
				Timestamp tsModificationDate = this.getResultSet().getTimestamp("ModificationDate");
				String modifiedDate = null;
				if (tsModificationDate != null) {
					modifiedDate = formatter.format(tsModificationDate);
				}
				Timestamp tsCreationDate = this.getResultSet().getTimestamp("CreationDate");
				String createdDate = null;
				if (tsCreationDate != null) {
					createdDate = formatter.format(tsCreationDate);
				}
				
				Client client = new Client(null, null, null, this.getResultSet().getInt("ClientPortfolioId"), null);
				
				Basket basket = new Basket(this.getResultSet().getInt("OriginId"),
						advisor,
						client,
						basketDate,
						this.getResultSet().getString("TimeSpent"),
						this.getResultSet().getInt("ChannelId"),
						this.getResultSet().getString("Comment"),
						createdDate,
						modifiedDate);
				basketDetails = new GetBasketDetailsResponse(basket);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_BASKET);
		}
		return basketDetails;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_BASKET);
	}
}

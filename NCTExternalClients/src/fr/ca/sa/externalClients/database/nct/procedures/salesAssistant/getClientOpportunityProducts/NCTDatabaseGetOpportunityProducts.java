package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientOpportunityProducts;

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
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.nct.commons.services.json.salesAssistant.GetOpportunityProductsRequest;

/**
 * 
 * Store procedure handler for getting opportunity products from db catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetOpportunityProducts extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOpportunityProducts.class);

	private GetOpportunityProductsRequest req;

	/**
	 * NCT Database Get Opportunity Products
	 * 
	 * @param req
	 *            Request
	 * 
	 * @param userId
	 *            User ID
	 */
	public NCTDatabaseGetOpportunityProducts(GetOpportunityProductsRequest req, int userId) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssOpportProdByClientId ?,?,?");
		try {		
			setUser(ps);
			if (req.getOpportunityId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getOpportunityId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.req.getClientId());
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}				
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetOpportunityProductsNCTResultList retValue = new GetOpportunityProductsNCTResultList();
		try {
			while (this.getResultSet().next()) {

				Integer productGroupId = this.getResultSet().getInt("ProductGroupId");
				Integer productId = this.getResultSet().getInt("ProductId");

				retValue.getProducts()
						.add(new GetOpportunityProductsNCTResultItem(this.getResultSet().getInt("OpportunityId"),
								productId, this.getResultSet().getInt("ProductOwnedByClient"), productGroupId));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_PRODUCTS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_PRODUCTS);
	}
}

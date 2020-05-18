package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientProducts;

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
import fr.ca.sa.nct.commons.services.json.salesAssistant.GetClientProductsRequest;

/**
 * 
 * Store procedure handler for getting client products from db catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetClientProducts extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientProducts.class);

	private GetClientProductsRequest req;

	/**
	 * NCT Database Get Client Products
	 * 
	 * @param req
	 *            Request
	 * 
	 * @param userId
	 *            User ID
	 */
	public NCTDatabaseGetClientProducts(GetClientProductsRequest req, int userId) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssProductsByClientId ?,?,?");
		try {		
			setUser(ps);
			if (req.getProductGroupId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getProductGroupId());
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
		GetClientProductsNCTResultList retValue = new GetClientProductsNCTResultList();
		try {
			while (this.getResultSet().next()) {

				retValue.getProducts().add(new GetClientProductsNCTResultItem(
						this.getResultSet().getInt("ProductGroupId"),
						this.getResultSet().getInt("isBestOfferProductGroup"),
						this.getResultSet().getInt("ProductSubGroupId"),
						this.getResultSet().getString("ProductSubGroupName_L1"),
						this.getResultSet().getString("ProductSubGroupName_L2"),
						this.getResultSet().getInt("ProductId"), this.getResultSet().getInt("ProductOwnedByClient"),
						this.getResultSet().getString("BestOfferDescription")));
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

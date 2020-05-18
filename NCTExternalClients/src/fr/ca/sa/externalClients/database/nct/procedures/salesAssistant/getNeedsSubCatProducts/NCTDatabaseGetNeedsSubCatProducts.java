package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNeedsSubCatProducts;

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
import fr.ca.sa.nct.commons.services.json.salesAssistant.GetClientNeedsSubCatProductsRequest;

/**
 * 
 * Store procedure handler for getting needs subcategory products from db
 * catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetNeedsSubCatProducts extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetNeedsSubCatProducts.class);

	private GetClientNeedsSubCatProductsRequest req;

	/**
	 * NCT Database Get Needs Subcategory Products
	 * 
	 * @param userId
	 *            User ID
	 * 
	 * @param languageId
	 *            Language ID
	 * 
	 * @param req
	 *            Request
	 */
	public NCTDatabaseGetNeedsSubCatProducts(Integer userId, 
			GetClientNeedsSubCatProductsRequest req) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssNeedSCatPrByClientId ?,?,?");
		try {		
			setUser(ps);
	
			if (this.req.getNeedCategoryId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getNeedCategoryId());
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
		GetNeedsSubCatProductsNCTResultList retValue = new GetNeedsSubCatProductsNCTResultList();
		try {
			while (this.getResultSet().next()) {

				retValue.getNeedsSubCatProducts().add(new GetNeedsSubCatProductsNCTResultItem(
						this.getResultSet().getInt("NeedCategoryId"),
						this.getResultSet().getInt("NeedSubCategoryId"),
						this.getResultSet().getString("NeedSubCategoryName_L1"),
						this.getResultSet().getString("NeedSubCategoryName_L2"),
						this.getResultSet().getInt("ProductId"),
						this.getResultSet().getInt("ProductOwnedByClient"),
						this.getResultSet().getInt("ProductGroupId")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_NEEDS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_NEEDS);
	}
}

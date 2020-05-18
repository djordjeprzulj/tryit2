package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductsGroups;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting products groups from db catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetProductsGroups extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetProductsGroups.class);
	
	private int clientId;

	/**
	 * NCT Database Get Products Groups
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param clientId
	 * 				Client ID
	 */
	public NCTDatabaseGetProductsGroups(int userId, int clientId) {
		super(userId);
		this.clientId = clientId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssProductsGroups ?,?");
		try {		
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.clientId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}									
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetProductsGroupsNCTResultList retValue = new GetProductsGroupsNCTResultList();
		try {
			while (this.getResultSet().next()) {
				
				retValue.getProductsGroups()
						.add(new GetProductsGroupsNCTResultItem(this.getResultSet().getInt("ProductGroupId"),
								this.getResultSet().getString("ProductGroupCode"),
								this.getResultSet().getInt("isBestOffer")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_PRODUCTS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		LOGGER.error(ex);
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_PRODUCTS);
	}
}

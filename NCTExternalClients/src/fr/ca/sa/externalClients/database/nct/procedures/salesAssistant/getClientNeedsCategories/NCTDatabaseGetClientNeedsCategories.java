package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientNeedsCategories;

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
 * Store procedure handler for getting need categories from db catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetClientNeedsCategories extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientNeedsCategories.class);

	private int clientId;

	/**
	 * NCT Database Get Client Needs Categories
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param clientId
	 * 				Client ID
	 */
	public NCTDatabaseGetClientNeedsCategories(int userId, int clientId) {
		super(userId);
		this.clientId = clientId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssNeedCategByClientId ?,?");
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
		GetClientNeedsCategoriesNCTResultList retValue = new GetClientNeedsCategoriesNCTResultList();
		try {
			while (this.getResultSet().next()) {

				retValue.getNeedsCategories()
						.add(new GetClientNeedsCategoriesNCTResultItem(this.getResultSet().getInt("NeedCategoryId"),
								this.getResultSet().getInt("NumberOfProjects"),
								this.getResultSet().getInt("IsEligible")));
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

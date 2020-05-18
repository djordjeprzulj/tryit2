package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getGetOppCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.CodeTablesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting opportunity categories
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetOppCategory extends AbstractUserLanguageStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOppCategory.class);

	/**
	 * NCT Database Get Opportunity Category
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetOppCategory(Integer userId, Integer langId) {
		super(userId, langId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetOppCategory ?,?");
		try {
			setUserAndLanguage(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetOppCategoryNCTResultList retList = new GetOppCategoryNCTResultList();

		try {
			while (this.getResultSet().next()) {
				retList.getOpportunityCategories().add(new GetOppCategoryNCTResultItem(
						this.getResultSet().getInt("OppCategoryId"), this.getResultSet().getString("OppCategoryName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_GET_OPPORTUNITY_CATEGORY);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_GET_OPPORTUNITY_CATEGORY);
	}
}

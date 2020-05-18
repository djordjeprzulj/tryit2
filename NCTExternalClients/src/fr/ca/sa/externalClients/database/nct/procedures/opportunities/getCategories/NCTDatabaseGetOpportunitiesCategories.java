package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getCategories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.nct.commons.NCTSystemConstants;

/**
 * 
 * Store procedure handler for getting categories for opportunities in bank
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetOpportunitiesCategories extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOpportunitiesCategories.class);

	/**
	 * NCT Database Get Opportunities Categories
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetOpportunitiesCategories(int userId, int langId) {
		super(userId, langId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetActiveOpportCatByUserId ?,?");
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
		GetOpportunitiesCategoriesNCTResultList retValue = new GetOpportunitiesCategoriesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getCategories()
						.add(new GetOpportunitiesCategoriesNCTResultItem(this.getResultSet().getInt("CategoryId"),
								this.getResultSet().getString("CategoryName"), this.getResultSet().getInt("Count"),
								NCTSystemConstants.getOpportunityCategoriesPictures()
										.get(this.getResultSet().getInt("CategoryId"))));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}
}

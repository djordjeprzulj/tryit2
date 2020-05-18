package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getSubcategories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting subcategories for opportunities in bank
 * 
 * @author Milivoj Bozic
 *
 */
public class NCTDatabaseGetAllCategoryOpportunitiesSubcategories extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAllCategoryOpportunitiesSubcategories.class);

	Integer catId;
	
	/**
	 * NCT Database Get Opportunities Subcategories
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetAllCategoryOpportunitiesSubcategories(int userId, int catId, int langId) {
		super(userId, langId);
		this.catId = catId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetOppSubCategory ?,?,?");
		try {
			setUser(ps);
			if (this.catId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.catId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, java.sql.Types.INTEGER);
			}	
			
			if (this.langId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.langId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, java.sql.Types.INTEGER);
			}	
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetOpportunitiesSubcategoriesNCTResultList retValue = new GetOpportunitiesSubcategoriesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getSubcategories()
						.add(new GetOpportunitiesSubcategoriesNCTResultItem(this.getResultSet().getInt("OppCategoryId"),
								this.getResultSet().getInt("OppSubCategoryId"),
								this.getResultSet().getString("OppSubCategoryName")));
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

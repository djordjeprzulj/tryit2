package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getOppSubCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.CodeTablesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nct.procedures.opportunities.getSubcategories.GetOpportunitiesSubcategoriesNCTResultItem;
import fr.ca.sa.externalClients.database.nct.procedures.opportunities.getSubcategories.GetOpportunitiesSubcategoriesNCTResultList;

/**
 * 
 * Store procedure handler for getting opportunity categories
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetOppSubCategory extends AbstractUserLanguageStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOppSubCategory.class);

	private Integer oppCategoryId;

	/**
	 * NCT Database Get Opportunity SubCategory
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param oppCategoryId
	 * 				Opportunity category ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetOppSubCategory(Integer userId, Integer oppCategoryId, Integer langId) {
		super(userId, langId);
		this.oppCategoryId = oppCategoryId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetOppSubCategory ?,?,?");
		try {
			setUser(ps);
			if (this.oppCategoryId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.oppCategoryId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
			setLanguage(ps, NCTDatabaseConstants.SP_ARG_NR_3);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetOpportunitiesSubcategoriesNCTResultList retList = new GetOpportunitiesSubcategoriesNCTResultList();

		try {
			while (this.getResultSet().next()) {
				retList.getSubcategories()
						.add(new GetOpportunitiesSubcategoriesNCTResultItem(
								this.getResultSet().getInt("OppCategoryId"),
								this.getResultSet().getInt("OppSubCategoryId"),
								this.getResultSet().getString("OppSubCategoryName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_GET_OPPORTUNITY_SUB_CATEGORY);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_GET_OPPORTUNITY_SUB_CATEGORY);
	}
}

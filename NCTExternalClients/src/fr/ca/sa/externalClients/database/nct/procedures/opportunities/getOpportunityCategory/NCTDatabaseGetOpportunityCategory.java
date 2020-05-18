package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityCategory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.OpportunitiesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for getting opportunity categories
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetOpportunityCategory extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOpportunityCategory.class);

	/**
	 * NCT Database Get Opportunity Category
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetOpportunityCategory(Integer userId, Integer langId) {
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
		GetOpportunityCategoryNCTResultListImages retList = new GetOpportunityCategoryNCTResultListImages();

		try {
			while (this.getResultSet().next()) {

				InputStream tempPictureStream = this.getResultSet().getBinaryStream("OppCategoryIco");
				if (tempPictureStream != null) {
					ImageInfoContainer imageContainer = new ImageInfoContainer(tempPictureStream);
					retList.getImagesMapByName(
							GetOpportunityCategoryNCTResultListImages.OPPORTUNITY_CATEGORIES_PIC_MAP_NAME)
							.put(String.valueOf(this.getResultSet().getInt("OppCategoryId")), imageContainer);
					tempPictureStream.close();
				}

				retList.getOpportunityCategories().getOpportunityCategories()
						.add(new GetOpportunityCategoryNCTResultItem(this.getResultSet().getInt("OppCategoryId"),
								this.getResultSet().getString("OppCategoryName")));
			}
		} catch (SQLException | IOException ex) {
			LOGGER.error(ex);
			throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_LOAD_OPPORTUNITIES);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_LOAD_OPPORTUNITIES);
	}
}

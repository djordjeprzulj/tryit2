package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNeedsCategories;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;
import fr.ca.sa.model.NeedCategory;

/**
 * 
 * Store procedure handler for getting need categories from db catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetNeedsCategories extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetNeedsCategories.class);

	/**
	 * NCT Database Get Needs Categories
	 * 
	 * @param userId
	 *            User ID
	 */
	public NCTDatabaseGetNeedsCategories() {
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetSalAssNeedCategories");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetNeedsCategoriesNCTResultListImages retValue = new GetNeedsCategoriesNCTResultListImages();
		try {
			while (this.getResultSet().next()) {

				InputStream tempPictureStream = this.getResultSet().getBinaryStream("NeedCategoryPicture");
				if (tempPictureStream != null) {
					ImageInfoContainer imageContainer = new ImageInfoContainer(tempPictureStream);
					retValue.getImagesMapByName(GetNeedsCategoriesNCTResultListImages.NEED_CAT_PIC_MAP_NAME)
							.put(String.valueOf(this.getResultSet().getInt("NeedCategoryId")), imageContainer);
					tempPictureStream.close();
				}
				tempPictureStream = this.getResultSet().getBinaryStream("NeedCategoryIcon");
				if (tempPictureStream != null) {
					ImageInfoContainer imageContainerIcon = new ImageInfoContainer(tempPictureStream);
					retValue.getImagesMapByName(GetNeedsCategoriesNCTResultListImages.NEED_CAT_ICON_NAME)
							.put(String.valueOf(this.getResultSet().getInt("NeedCategoryId")), imageContainerIcon);
					tempPictureStream.close();
				}
				NeedCategory needCategory = new NeedCategory(this.getResultSet().getInt("NeedCategoryId"),
						this.getResultSet().getString("NeedCategoryName_L1"),
						this.getResultSet().getString("NeedCategoryName_L2"),
						this.getResultSet().getString("NeedCategoryLongDescription_L1"),
						this.getResultSet().getString("NeedCategoryLongDescription_L2"),
						this.getResultSet().getString("NeedCategoryTipsLink"),
						this.getResultSet().getString("NeedCategoryTipsDesc_L1"),
						this.getResultSet().getString("NeedCategoryTipsDesc_L2"),
						this.getResultSet().getString("NeedCategorySimulatorLink"), null, null);
				
				retValue.getNeedsCategories().getNeedsCategories().add(new GetNeedsCategoriesNCTResultItem(needCategory));
								
								
			}
		} catch (SQLException | IOException ex) {
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

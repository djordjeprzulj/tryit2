package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductGroup;

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

/**
 * 
 * Store procedure handler for getting products groups from db catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetProductGroup extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetProductGroup.class);

	/**
	 * NCT Database Get Products Groups
	 * 
	 * @param userId
	 * 			User ID
	 * 
	 * @param langId
	 * 			Language ID
	 */
	public NCTDatabaseGetProductGroup() {
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetProductGroup");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetProductGroupNCTResultListImages retValue = new GetProductGroupNCTResultListImages();
		try {
			while (this.getResultSet().next()) {

				InputStream tempPictureStream = this.getResultSet().getBinaryStream("ProductGroupPicture");
				if (tempPictureStream != null) {
					ImageInfoContainer imageContainer = new ImageInfoContainer(tempPictureStream);
					retValue.getImagesMapByName(GetProductGroupNCTResultListImages.PRODUCT_GROUP_PIC_MAP_NAME)
							.put(String.valueOf(this.getResultSet().getInt("ProductGroupId")), imageContainer);
					tempPictureStream.close();
				}

				retValue.getProductsGroups().getProductsGroups()
						.add(new GetProductGroupNCTResultItem(this.getResultSet().getInt("ProductGroupId"),
								this.getResultSet().getString("ProductGroupName_L1"),
								this.getResultSet().getString("ProductGroupName_L2"),
								this.getResultSet().getString("ProductGroupDescription_L1"),
								this.getResultSet().getString("ProductGroupDescription_L2")));
			}
		} catch (SQLException | IOException ex) {
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

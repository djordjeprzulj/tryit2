package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductCatalog;

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
import fr.ca.sa.model.Product;

/**
 * 
 * Store procedure handler for getting products from db catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetProductCatalog extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetProductCatalog.class);

	/**
	 * NCT Database Get Products
	 * 
	 */
	public NCTDatabaseGetProductCatalog() {
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetProductCatalog ");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetProductCatalogNCTResultListImages retValue = new GetProductCatalogNCTResultListImages();
		try {
			while (this.getResultSet().next()) {

				InputStream tempPictureStream = this.getResultSet().getBinaryStream("ProductPicture");
				if (tempPictureStream != null) {
					ImageInfoContainer imageContainer = new ImageInfoContainer(tempPictureStream);
					retValue.getImagesMapByName(GetProductCatalogNCTResultListImages.PRODUCT_PIC_MAP_NAME)
							.put(String.valueOf(this.getResultSet().getInt("ProductId")), imageContainer);
					tempPictureStream.close();
				}

				Product product = new Product(this.getResultSet().getInt("ProductId"),
						this.getResultSet().getString("ProductCode"),
						this.getResultSet().getString("ProductName_L1"),
						this.getResultSet().getString("ProductName_L2"),
						this.getResultSet().getString("ProductShortDescription_L1"),
						this.getResultSet().getString("ProductShortDescription_L2"),
						this.getResultSet().getString("ProductLongDescriptionLink"),
						this.getResultSet().getString("ProductLongDescription_L1"),
						this.getResultSet().getString("ProductLongDescription_L2"),
						this.getResultSet().getString("ProductTipsLink"),
						this.getResultSet().getString("ProductTipsDesc_L1"),
						this.getResultSet().getString("ProductTipsDesc_L2"),
						this.getResultSet().getString("ProductSimulatorLink"),
						this.getResultSet().getString("ProductColor"),
						this.getResultSet().getInt("ProductHasAmount") == 1,
						this.getResultSet().getInt("ProductHasPieces") == 1,
						this.getResultSet().getInt("ProductIdExt"), null); 
				
				retValue.getProducts().getProductsCatalog()
						.add(new GetProductCatalogNCTResultItem(product));
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

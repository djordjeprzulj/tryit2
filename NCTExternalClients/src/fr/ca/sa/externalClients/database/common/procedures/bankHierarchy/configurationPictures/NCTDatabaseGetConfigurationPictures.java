package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationPictures;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting configuration pictures
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetConfigurationPictures extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetConfigurationPictures.class);

	/**
	 * default constructor for NCT Database Get Configuration Pictures
	 */
	public NCTDatabaseGetConfigurationPictures() {
		super();
	}
	
	/**
	 * NCT Database Get Configuration Pictures
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetConfigurationPictures(int userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetCONFIGURATION_PICTURES");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetConfigurationPicturesNCTResultListImages retList = new GetConfigurationPicturesNCTResultListImages();
		try {
			while (this.getResultSet().next()) {
				InputStream tempPictureStream = this.getResultSet().getBinaryStream("PARAM_VALUE");
				if (tempPictureStream != null) {
					ImageInfoContainer imageContainer = new ImageInfoContainer(tempPictureStream);
					retList.getImagesMapByName(GetConfigurationPicturesNCTResultListImages.CONFIG_PIC_NAME)
							.put(String.valueOf(this.getResultSet().getInt("PARAM_ID")), imageContainer);
					tempPictureStream.close();
				}

				retList.getPictures().getPictures()
						.add(new GetConfigurationPicturesNCTResultItem(this.getResultSet().getInt("PARAM_ID"),
								this.getResultSet().getString("PARAM_NAME"),
								this.getResultSet().getString("DESCRIPTION")));
			}
		} catch (SQLException | IOException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}
}

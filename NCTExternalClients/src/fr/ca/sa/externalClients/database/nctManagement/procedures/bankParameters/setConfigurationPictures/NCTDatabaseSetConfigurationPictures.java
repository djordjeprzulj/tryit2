package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.setConfigurationPictures;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.imageio.ImageIO;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ParametersCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting bank parameters
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetConfigurationPictures extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetConfigurationPictures.class);

	private int paramId;
	private InputStream paramValue;

	SetConfigurationPicturesNCTResultListImages retValue = new SetConfigurationPicturesNCTResultListImages();

	/**
	 * NCT Database Set Configuration Pictures
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param paramId
	 * 				Parameter ID
	 * 
	 * @param paramValue
	 * 				Parameter value
	 */
	public NCTDatabaseSetConfigurationPictures(int userId, int paramId, InputStream paramValue) {
		super(userId);
		this.paramId = paramId;
		this.paramValue = paramValue;

		try {
			ImageInfoContainer imageContainer = new ImageInfoContainer(this.paramValue);
			retValue.getImagesMapByName(SetConfigurationPicturesNCTResultListImages.CONFIG_PIC_NAME).put(String.valueOf(this.paramId), imageContainer);

			// Rewrite image into stream
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(imageContainer.getImageContent(), imageContainer.getImageType(), os);
			this.paramValue = new ByteArrayInputStream(os.toByteArray());
		} catch (IOException ex) {
			LOGGER.error(ex);
			throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_BANK_PARAMETERS);
		}

	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement cs = connection.prepareCall("exec spSetCONFIGURATION_PICTURES ?,?,?");
		try {
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.userId);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.paramId);
	
			if (this.paramValue != null) {
				cs.setBinaryStream(NCTDatabaseConstants.SP_ARG_NR_3, this.paramValue);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.VARBINARY);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		try {
			this.paramValue.close();
		} catch (IOException ex) {
			LOGGER.error(ex);
			throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_BANK_PARAMETERS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_BANK_PARAMETERS);
	}
}

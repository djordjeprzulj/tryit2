package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankParameters;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ParametersCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting bank parameters
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetBankParameters extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankParameters.class);

	/**
	 * default constructor for NCT Database Get Bank Parameters
	 */
	public NCTDatabaseGetBankParameters() {
		super();
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetBankParameters");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetBankParametersNCTResultListImages retList = new GetBankParametersNCTResultListImages();
		try {
			while (this.getResultSet().next()) {
				InputStream tempPictureStream = this.getResultSet().getBinaryStream("LOGO_PICTURE");
				if (tempPictureStream != null) {
					ImageInfoContainer imageContainer = new ImageInfoContainer(tempPictureStream);
					retList.getImagesMapByName(GetBankParametersNCTResultListImages.LOGO_PIC_NAME)
							.put(String.valueOf(this.getResultSet().getInt("BANK_ID")), imageContainer);
					tempPictureStream.close();
				}

				tempPictureStream = this.getResultSet().getBinaryStream("LANGUAGE_FLAG_PICTURE");
				if (tempPictureStream != null) {
					ImageInfoContainer imageContainer = new ImageInfoContainer(tempPictureStream);
					retList.getImagesMapByName(GetBankParametersNCTResultListImages.FLAG_PIC_NAME)
							.put(String.valueOf(this.getResultSet().getInt("LANGUAGE_ID")), imageContainer);
					tempPictureStream.close();
				}

				String translationString = this.getResultSet().getString("LANGUAGE_TRANSLATION_FILE");

				String translationManagementString = this.getResultSet()
						.getString("LANGUAGE_TRANSLATION_FILE_MANAGAPP");

				retList.getParameters().getParameters().add(new GetBankParametersNCTResultItem(
						this.getResultSet().getInt("BANK_ID"), this.getResultSet().getString("BANK_NAME"),
						this.getResultSet().getInt("LANGUAGE_ID"), this.getResultSet().getInt("LANGUAGE_ORDER"),
						this.getResultSet().getString("LANGUAGE_NAME"), this.getResultSet().getString("LANGUAGE_CODE"),
						this.getResultSet().getInt("DEFAULT_LANGUAGE") == 1, translationString,
						translationManagementString));
			}
		} catch (SQLException | IOException ex) {
			LOGGER.error(ex);
			throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_GET_BANK_LANGUAGE_PARAMETERS);
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		LOGGER.error(ex);
		throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_GET_BANK_LANGUAGE_PARAMETERS);
	}
}

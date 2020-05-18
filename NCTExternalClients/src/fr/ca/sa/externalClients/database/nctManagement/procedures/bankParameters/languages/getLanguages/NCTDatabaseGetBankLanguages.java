package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.languages.getLanguages;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ParametersCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting bank parameters
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetBankLanguages extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankLanguages.class);

	/**
	 * NCT Database Get Bank Languages
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetBankLanguages(Integer userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetLanguages ?");
		try {
			setUser(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetLanguagesNCTResultListImages retList = new GetLanguagesNCTResultListImages();
		try {
			while (this.getResultSet().next()) {
				InputStream tempPictureStream = this.getResultSet().getBinaryStream("LanguageFlagPicture");
				if (tempPictureStream != null) {
					ImageInfoContainer imageContainer = new ImageInfoContainer(tempPictureStream);
					retList.getImagesMapByName(GetLanguagesNCTResultListImages.FLAG_PIC_NAME)
							.put(String.valueOf(this.getResultSet().getInt("LanguageId")), imageContainer);
					tempPictureStream.close();
				}

				String translationString = this.getResultSet().getString("LanguageTranslationFile");

				String translationManagementString = this.getResultSet().getString("LanguageTranslationFileManagApp");

				retList.getLanguages().getLanguages().add(new GetLanguagesNCTResultItem(
						this.getResultSet().getInt("LanguageId"), this.getResultSet().getString("LanguageCode"),
						this.getResultSet().getString("LanguageName"), translationString, translationManagementString));
			}
		} catch (SQLException | IOException ex) {
			LOGGER.error(ex);
			throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_GET_BANK_LANGUAGES);
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		LOGGER.error(ex);
		throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_GET_BANK_LANGUAGES);
	}
}

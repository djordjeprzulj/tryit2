package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.languages.setLanguage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ParametersCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting bank languages
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetLanguage extends AbstractUserLanguageStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetLanguage.class);

	private String languageCode;
	private String languageName;
	private int isActive;

	private InputStream flagPicture;

	SetLanguageNCTResultListImages retValue = new SetLanguageNCTResultListImages();

	/**
	 * NCT Database Set Language
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @param languageCode
	 * 				Language code
	 * 
	 * @param languageName
	 * 				Language name
	 * 
	 * @param flagPicture
	 * 				Flag picture
	 * 
	 * @param isActive
	 * 				Activity
	 */
	public NCTDatabaseSetLanguage(int userId, int langId, String languageCode, String languageName,
			InputStream flagPicture, int isActive) {
		super(userId, langId);		
		this.languageCode = languageCode;
		this.languageName = languageName;
		this.isActive = isActive;
		this.flagPicture = flagPicture;

		try {
			ImageInfoContainer imageContainer = new ImageInfoContainer(this.flagPicture);
			retValue.getImagesMapByName(SetLanguageNCTResultListImages.FLAG_PIC_NAME).put(String.valueOf(langId), imageContainer);

			// Rewrite image into stream
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(imageContainer.getImageContent(), imageContainer.getImageType(), os);
			this.flagPicture = new ByteArrayInputStream(os.toByteArray());
		} catch (IOException ex) {
			LOGGER.error(ex);

			throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_BANK_LANGUAGES);
		}

	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetLanguage ?,?,?,?,?,?");
		try {
			setUserAndLanguage(ps);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.languageCode);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.languageName);
			ps.setBinaryStream(NCTDatabaseConstants.SP_ARG_NR_5, this.flagPicture);
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.isActive);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}		
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		try {
			while (this.getResultSet().next()) {

				retValue.setParameter(new SetLanguageNCTResultItem(this.getResultSet().getInt("LanguageId")));
			}
			this.flagPicture.close();
		} catch (SQLException | IOException ex) {
			LOGGER.error(ex);

			throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_BANK_LANGUAGES);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_BANK_LANGUAGES);
	}
}

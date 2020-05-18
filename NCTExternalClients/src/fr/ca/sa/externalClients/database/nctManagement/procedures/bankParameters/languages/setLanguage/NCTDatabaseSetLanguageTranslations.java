package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.languages.setLanguage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ParametersCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting bank languages
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetLanguageTranslations extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetLanguageTranslations.class);
	
	private String paramName;
	private String translatedText;

	SetLanguageNCTResultListImages retValue = new SetLanguageNCTResultListImages();

	/**
	 * NCT Database Set Language Translations
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @param paramName
	 * 				Parameter name
	 * 
	 * @param translatedText
	 * 				Translated text
	 */
	public NCTDatabaseSetLanguageTranslations(int userId, int langId, String paramName, String translatedText) {
		super(userId, langId);
		this.paramName = paramName;
		this.translatedText = translatedText;

	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement cs = connection.prepareCall("exec spSetNCTParametersTranslation ?,?,?,?");
		try {
			setUserAndLanguage(cs);
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.paramName);
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.translatedText);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {

		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_BANK_LANGUAGES);
	}
}

package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.languages.setBankLangParameters;

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
 * Store procedure handler for setting bank language configuration parameters
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetBankLanguageParameters extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetBankLanguageParameters.class);
	
	private int bankId;
	private int langOrder;
	private int defaultLang;

	/**
	 * NCT Database Set Bank Language Parameters
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param bankId
	 * 				Bank ID
	 * 
	 * @param langOrder
	 * 				Language order
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @param defaultLang
	 * 				Default language
	 */
	public NCTDatabaseSetBankLanguageParameters(int userId, int bankId, int langOrder, int langId, int defaultLang) {
		super(userId, langId);
		this.bankId = bankId;
		this.langOrder = langOrder;
		this.defaultLang = defaultLang;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement cs = connection.prepareCall("exec spSetBankLangParameters ?,?,?,?,?");
		try {
			setUser(cs);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.bankId);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.langOrder);
			setLanguage(cs, NCTDatabaseConstants.SP_ARG_NR_4);			
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.defaultLang);
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
		throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_BANK_LANGUAGE_PARAMETERS);
	}
}

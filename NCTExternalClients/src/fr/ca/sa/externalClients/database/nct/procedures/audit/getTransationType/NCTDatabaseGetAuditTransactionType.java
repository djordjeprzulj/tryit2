package fr.ca.sa.externalClients.database.nct.procedures.audit.getTransationType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Retrieve list of audit application transaction types
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetAuditTransactionType extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAuditTransactionType.class);

	private int applicationId;

	/**
	 * NCT Database Get Audit Transaction Type
	 * 
	 * @param userId
	 * @param applicationId
	 * @param langId
	 */
	public NCTDatabaseGetAuditTransactionType(Integer userId, int applicationId, int langId) {
		super(userId, langId);
		this.applicationId = applicationId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetTransaction ?,?,?");
		try {
			setUser(cs);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.applicationId);
			setLanguage(cs, NCTDatabaseConstants.SP_ARG_NR_3);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAuditTransactionTypeList transTypes = new GetAuditTransactionTypeList();
		try {
			while (this.getResultSet().next()) {
				transTypes.getTransactions().add(new GetAuditTransactionTypeItem(
						this.getResultSet().getInt("TransactCode"), this.getResultSet().getString("TransactDesc")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return transTypes;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

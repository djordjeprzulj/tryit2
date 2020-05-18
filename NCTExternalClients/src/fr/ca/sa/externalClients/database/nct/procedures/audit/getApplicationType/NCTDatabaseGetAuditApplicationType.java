package fr.ca.sa.externalClients.database.nct.procedures.audit.getApplicationType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Retrieve list of audit application types
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetAuditApplicationType extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAuditApplicationType.class);

	/**
	 * NCT Database Get Audit Application Type
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetAuditApplicationType(Integer userId, int langId) {
		super(userId, langId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetTransApplication ?,?");
		try {
			setUserAndLanguage(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAuditApplicationTypeList appTypes = new GetAuditApplicationTypeList();
		try {
			while (this.getResultSet().next()) {
				appTypes.getApplications()
						.add(new GetAuditApplicationTypeItem(this.getResultSet().getInt("ApplicationCode"),
								this.getResultSet().getString("ApplicationName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return appTypes;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getCancelReasons;

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
 * Store procedure handler for getting cancellation reasons for opportunities in
 * bank
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetOpportunitiesCancelReasons extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOpportunitiesCancelReasons.class);

	/**
	 * NCT Database Get Opportunities Cancel Reasons
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetOpportunitiesCancelReasons(int userId, int langId) {
		super(userId, langId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetOpportReasonAnnul ?,?");
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
		GetOpportunitiesCancelReasonsNCTResultList retValue = new GetOpportunitiesCancelReasonsNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getCancelReasons().add(new GetOpportunitiesCancelReasonsNCTResultItem(
						this.getResultSet().getInt("ReasonId"), this.getResultSet().getString("ReasonName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}
}

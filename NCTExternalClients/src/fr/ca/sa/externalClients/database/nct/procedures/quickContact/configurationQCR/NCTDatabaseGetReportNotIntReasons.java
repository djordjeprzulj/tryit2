package fr.ca.sa.externalClients.database.nct.procedures.quickContact.configurationQCR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.QuickContactReportCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting report not interested reasons
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetReportNotIntReasons extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetReportNotIntReasons.class);

	/**
	 * NCT Database Get Report for Not Interested Reasons
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetReportNotIntReasons(Integer userId, Integer langId) {
		super(userId, langId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetQReportNotIntReasons ?,?");
		try {
			setUserAndLanguage(cs);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		QuickContactReportItemList retList = new QuickContactReportItemList();

		try {
			while (this.getResultSet().next()) {
				retList.getItemList()
						.add(new QuickContactReportItem(this.getResultSet().getInt("QuickReportNotIntReasonId"),
								this.getResultSet().getString("QuickReportNotIntReasonName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_GET_QCR_CONFIGURATION);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_GET_QCR_CONFIGURATION);
	}

}

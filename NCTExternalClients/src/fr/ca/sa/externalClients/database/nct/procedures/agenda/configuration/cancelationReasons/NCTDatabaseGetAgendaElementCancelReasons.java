package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.cancelationReasons;

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
 * Retrieve agenda element/item cancel reasons
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetAgendaElementCancelReasons extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaElementCancelReasons.class);

	/**
	 * NCT Database Get Agenda Element Cancel Reasons
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetAgendaElementCancelReasons(Integer userId, Integer langId) {
		super(userId, langId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetAgendaElementCancelReasons ?,?");
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
		AgendaCancelationReasonItemList agendaCancelReasonList = new AgendaCancelationReasonItemList();
		try {
			while (this.getResultSet().next()) {
				agendaCancelReasonList.getCancelReasonList()
						.add(new AgendaCancelationReasonItem(this.getResultSet().getInt("AgendaElementCancelReasonId"),
								this.getResultSet().getString("AgendaElementCancelReasonName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return agendaCancelReasonList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

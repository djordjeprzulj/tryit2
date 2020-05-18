package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaNotClosedItemsCount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Retrieve agenda data for unclosed appointments count
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetAgendaNotClosedItems extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaNotClosedItems.class);

	private int totalCount;

	/**
	 * NCT Database Get Agenda Not Closed Items
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetAgendaNotClosedItems(int userId,Integer langId) {
		super(userId, langId);
		this.totalCount = NCTDatabaseConstants.getNotClosedAgendaItemTotalCountId();
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetNotClosedAgendaAppointments ?,?,?");
		try {
			setUserAndLanguage(ps);
			
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.totalCount);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAgendaNotClosedItemsCountItem agendaNotClosedCount = new GetAgendaNotClosedItemsCountItem();

		try {
			while (this.getResultSet().next()) {
				agendaNotClosedCount.setNotClosedItemsCount(this.getResultSet().getInt("TotalCount"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_NOT_CLOSED_AGENDA_COUNT);
		}

		return agendaNotClosedCount;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_NOT_CLOSED_AGENDA_COUNT);
	}

}

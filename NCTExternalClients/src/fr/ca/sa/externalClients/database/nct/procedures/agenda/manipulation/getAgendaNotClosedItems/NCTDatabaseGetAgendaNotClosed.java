package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaNotClosedItems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.model.AgendaElement;
import fr.ca.sa.model.Client;
import fr.ca.sa.model.Entity;

/**
 * 
 * Retrieve agenda data for unclosed appointments
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetAgendaNotClosed extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaNotClosed.class);

	SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
	
	private int totalCount;

	/**
	 * NCT Database Get Agenda Not Closed
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetAgendaNotClosed(int userId, Integer langId) {
		super(userId, langId);
		this.totalCount = NCTDatabaseConstants.getNotClosedAgendaItemListId();
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
		GetAgendaNotClosedItemList agendaList = new GetAgendaNotClosedItemList();
		try {
			while (this.getResultSet().next()) {
				Client client = new Client(this.getResultSet().getInt("ClientId"),
											this.getResultSet().getString("ClientName"),
											new Entity(this.getResultSet().getInt("ClientEntityId"), null, null, null), null,
											this.getResultSet().getString("C_L"));
				
				AgendaElement agendaElement = new AgendaElement(this.getResultSet().getInt("AgendaElementId"),
						null,
						this.getResultSet().getTimestamp("AgendaElementStartTime"),
						this.getResultSet().getTimestamp("AgendaElementEndTime"));
				agendaElement.setTitle(this.getResultSet().getString("AgendaElementTitle"));
				agendaElement.setClient(client);
				
				agendaList.getAgendaElements().add(agendaElement);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
		}

		return agendaList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
	}

}

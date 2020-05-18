package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Set agenda element participants in database
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetAgendaElementParticipants extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetAgendaElementParticipants.class);
	
	private Integer advisorId;

	private Integer agendaElementId;

	private Integer participantId;

	/**
	 * NCT Database Set Agenda Element Participants
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param agendaElementId
	 * 				Agenda element ID
	 * 
	 * @param participantId
	 * 				Participant ID
	 */
	public NCTDatabaseSetAgendaElementParticipants(Integer advisorId, Integer agendaElementId, Integer participantId) {
		super();
		this.advisorId = advisorId;
		this.agendaElementId = agendaElementId;
		this.participantId = participantId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spSetAgendaElementParticipants ?,?,?");
		try {
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.advisorId);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.agendaElementId);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.participantId);
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
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_UPDATE_AGENDA_ITEM);
	}

}

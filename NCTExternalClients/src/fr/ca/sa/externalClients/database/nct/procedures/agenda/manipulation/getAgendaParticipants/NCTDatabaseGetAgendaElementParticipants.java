package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaParticipants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.Entity;
import fr.ca.sa.model.IdName;

/**
 * 
 * Retrieve specific agenda element participants
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetAgendaElementParticipants extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaElementParticipants.class);

	private Integer agendaElementId;

	/**
	 * NCT Database Get Agenda Element Participants
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param agendaElementId
	 * 				Agenda element ID
	 */
	public NCTDatabaseGetAgendaElementParticipants(Integer userId, Integer agendaElementId) {
		super(userId);
		this.agendaElementId = agendaElementId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetAgendaElementParticipants ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, agendaElementId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		AgendaElementParticipantList participantsList = new AgendaElementParticipantList();
		try {
			while (this.getResultSet().next()) {
				Collaborator participant = new Collaborator(this.getResultSet().getInt("ParticipantId"),
												this.getResultSet().getString("ParticipantName"),
												this.getResultSet().getString("ParticipantSurname"),
												new Entity(this.getResultSet().getInt("ParticipantEntityId"), 
															new IdName(null, this.getResultSet().getString("ParticipantEntityName")), 
															null, null));
				participantsList.getParticipantsList().add(participant);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
		}

		return participantsList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
	}

}

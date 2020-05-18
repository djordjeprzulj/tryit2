package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation;

import java.sql.CallableStatement;
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
 * Set agenda element participants notifications NOTE: This SP call is invoked
 * when there are advisors without agenda in the system Notification is stored
 * in separate table and is going to be handled by external modules
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetAgendaElementParticipantsNotifs extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetAgendaElementParticipantsNotifs.class);

	private Integer notificationType;

	private Integer participantId;

	private Integer agendaElementId;

	private Integer messageType;

	/**
	 * NCT Database Set Agenda Element Participants Notifications
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param notificationType
	 * 				Notification type
	 * 
	 * @param agendaElementId
	 * 				Agenda element ID
	 * 
	 * @param participantId
	 * 				Participant ID
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @param messageType
	 * 				Message ID
	 */
	public NCTDatabaseSetAgendaElementParticipantsNotifs(Integer userId, Integer notificationType,
			Integer agendaElementId, Integer participantId, Integer langId, Integer messageType) {
		super(userId, langId);
		this.notificationType = notificationType;
		this.participantId = participantId;
		this.agendaElementId = agendaElementId;
		this.messageType = messageType;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement cs = connection.prepareCall("exec spSetAgendaElementNotifs ?,?,?,?,?,?"); 		
		try {			
			setUser(cs);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.notificationType);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.agendaElementId);
	
			if (this.participantId != null && this.participantId != -1) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.participantId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_4, java.sql.Types.INTEGER);
			}
			setLanguage(cs, NCTDatabaseConstants.SP_ARG_NR_5);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.messageType);
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

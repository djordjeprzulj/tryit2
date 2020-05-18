package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.AgendaElement;
import fr.ca.sa.model.Client;
import fr.ca.sa.model.Entity;

/**
 * 
 * Retrieve agenda data based on specific time frame (either for advisor or
 * entity)
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetAgenda extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgenda.class);

	private Timestamp startTime;
	private Timestamp endTime;
	private Integer advisorEntityId;
	private Integer advisorId;

	/**
	 * NCT Database Get Agenda
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param language
	 * 				Language
	 * 
	 * @param startTime
	 * 				Start time
	 * 
	 * @param endTime
	 * 				End time
	 * 
	 * @param advisorEntityId
	 * 				Advisor entity ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetAgenda(Integer userId, Integer langId, Timestamp startTime, Timestamp endTime,
			Integer advisorEntityId, Integer advisorId) {
		super(userId, langId);
		this.startTime = startTime;
		this.endTime = endTime;
		this.advisorEntityId = advisorEntityId;
		this.advisorId = advisorId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetAgendaElements ?,?,?,?,?,?");
		try {
			setUserAndLanguage(ps);			
			
			ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_3, startTime);
			ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_4, endTime);
			if (this.advisorEntityId != null && this.advisorEntityId != -1) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.advisorEntityId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, java.sql.Types.INTEGER);
			}
			if (this.advisorId != null && this.advisorId != -1) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.advisorId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, java.sql.Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAgendaItemList agendaList = new GetAgendaItemList();
		try {
			while (this.getResultSet().next()) {
				Client client = new Client(this.getResultSet().getInt("ClientId"),
						this.getResultSet().getString("ClientName"), 
						new Entity(this.getResultSet().getInt("ClientEntityId"), null, null, null),
						this.getResultSet().getInt("ClientPortfolioId"), 
						this.getResultSet().getString("C_L"));
				Collaborator advisor = new Collaborator(this.getResultSet().getInt("AdvisorId"), null, null ,null);
				AgendaElement agendaElement = new AgendaElement(this.getResultSet().getInt("AgendaElementId"),
						this.getResultSet().getInt("AgendaElementTypeId"),
						this.getResultSet().getTimestamp("AgendaElementStartTime"),
						this.getResultSet().getTimestamp("AgendaElementEndTime"),
						this.getResultSet().getString("AgendaElementTitle"),
						this.getResultSet().getInt("AgendaId"),
						this.getResultSet().getString("AgendaElementTypeBackColor"),
						this.getResultSet().getInt("Available"), 
						this.getResultSet().getInt("Visible"), 
						this.getResultSet().getInt("AgendaParticipant"),
						this.getResultSet().getInt("StatusId"),
						this.getResultSet().getString("AgendaElementOwner"));
				agendaElement.setAdvisor(advisor);
				agendaElement.setClient(client);
				agendaList.getAgendaItems().add(new GetAgendaItem(agendaElement));
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

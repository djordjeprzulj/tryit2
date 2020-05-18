package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaDetailed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.AgendaElement;
import fr.ca.sa.model.Client;
import fr.ca.sa.model.Entity;

/**
 * 
 * Retrieve detailed data for specific agenda element
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetAgendaItemDetailed extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaItemDetailed.class);

	private Integer agendaItemId;
	
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);

	/**
	 * NCT Database Get Agenda Item Detailed
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param agendaItemId
	 * 				Agenda item ID
	 */
	public NCTDatabaseGetAgendaItemDetailed(Integer userId, Integer agendaItemId) {
		super(userId);
		this.agendaItemId = agendaItemId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetAgendaElementDetails ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, agendaItemId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAgendaItemDetailed agendaItem = null;
		try {
			while (this.getResultSet().next()) {
				Client client = new Client(this.getResultSet().getInt("ClientId"),
						this.getResultSet().getString("ClientFirstName"),
						this.getResultSet().getString("ClientLastName"),
						new Entity(this.getResultSet().getInt("ClientEntityId"), null, null, null),
						this.getResultSet().getInt("ClientPortfolioId"), 
						this.getResultSet().getString("C_L"),
						this.getResultSet().getString("ClientEmail"),
						this.getResultSet().getString("ClientMobilePhone"));
				
				Collaborator advisor = new Collaborator(this.getResultSet().getInt("AdvisorId"),
											null, null,
											new Entity(this.getResultSet().getInt("AdvisorEntityId"), null, null, null));
				
				AgendaElement agendaElement = new AgendaElement(agendaItemId,
																this.getResultSet().getInt("TypeId"),
																this.getResultSet().getTimestamp("StartTime"), 
																this.getResultSet().getTimestamp("EndTime"),
																null, 
																this.getResultSet().getInt("AgendaId"), 
																null, 
																this.getResultSet().getInt("AVAILABLE"),
																this.getResultSet().getInt("VISIBLE"), 
																null, 
																this.getResultSet().getInt("StatusId"),
																null);				
				agendaElement.setContactId(this.getResultSet().getInt("ContactId"));
				agendaElement.setMessageTypeId(this.getResultSet().getInt("MessageTypeId"));
				agendaElement.setMessageText(this.getResultSet().getString("MessageText"));
				agendaElement.setPurposeId(this.getResultSet().getInt("ObjectId"));
				agendaElement.setPlace(this.getResultSet().getString("PLACE"));
				agendaElement.setWeeklyFrequency(this.getResultSet().getInt("PERIODICITY"));
				agendaElement.setPreparationComment(this.getResultSet().getString("PREPARATION_COMMENT"));
				agendaElement.setReminderTime(this.getResultSet().getInt("RECALL_TIME"));
				agendaElement.setCloseReasonId(this.getResultSet().getInt("CloseReasonId"));
				agendaElement.setClosureComment(this.getResultSet().getString("CLOSURE_COMMENT"));
				agendaElement.setComment(this.getResultSet().getString("COMMENTS"));
				agendaElement.setLocationId(this.getResultSet().getInt("LocationId"));
				agendaElement.setOriginId(this.getResultSet().getInt("OriginId"));
				agendaElement.setCancelReasonId(this.getResultSet().getInt("CancelReasonId"));
				agendaElement.setCancelComment(this.getResultSet().getString("CANCEL_COMMENT"));
				agendaElement.setCreationDate(convertDate(this.getResultSet().getTimestamp("CreationDate"), DATE_FORMATTER));
				agendaElement.setCreatedBy(this.getResultSet().getString("CreatedBy"));
				agendaElement.setLastModificationDate(convertDate(this.getResultSet().getTimestamp("ModificationDate"), DATE_FORMATTER));
				agendaElement.setLastModifiedBy(this.getResultSet().getString("ModifiedBy"));
				agendaElement.setPurpose(this.getResultSet().getInt("PURPOSE"));
				agendaElement.setClient(client);
				agendaElement.setAdvisor(advisor);
				
				agendaItem = new GetAgendaItemDetailed(agendaElement);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
		}

		if (agendaItem == null) {
			throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
		}

		return agendaItem;
	}

	private String convertDate(Timestamp date, SimpleDateFormat formatter) {
		if (date == null) {
			return null;
		}

		Date tempDate = new Date(date.getTime());

		return formatter.format(tempDate);
	}
	
	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
	}

}

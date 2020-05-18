package fr.ca.sa.externalClients.database.nct.procedures.agenda.clientOperations;

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
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.AgendaElement;

/**
 * 
 * Retrieve agenda elements by client id
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetAgendaElementsByClientID extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaElementsByClientID.class);

	private Integer advisorId;

	private Integer clientId;

	/**
	 * NCT Database Get Agenda Elements By Client ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param clientId
	 * 				Client ID
	 */
	public NCTDatabaseGetAgendaElementsByClientID(Integer advisorId, Integer clientId) {
		super();
		this.advisorId = advisorId;
		this.clientId = clientId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetAgendaElementsByClientId ?,?");
		try {
			if (this.advisorId != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.advisorId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_1, java.sql.Types.INTEGER);
			}
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, clientId);	
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}		
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetClientsAgendaElementsItemList clientAgendas = new GetClientsAgendaElementsItemList();
		try {
			while (this.getResultSet().next()) {
				AgendaElement agendaElement = new AgendaElement(this.getResultSet().getInt("AgendaElementId"),
																this.getResultSet().getInt("TypeId"),
																this.getResultSet().getTimestamp("StartTime"),
																this.getResultSet().getTimestamp("EndTime"));
				agendaElement.setPreparationComment(this.getResultSet().getString("PREPARATION_COMMENT"));
				agendaElement.setComment(this.getResultSet().getString("COMMENTS"));
				Collaborator advisor = new Collaborator(this.getResultSet().getInt("AdvisorId"), 
												this.getResultSet().getString("AdvisorFirstName"),
												this.getResultSet().getString("AdvisorLastName"), null);
				agendaElement.setAdvisor(advisor);
				clientAgendas.getClientsAgendaItems().add(new GetClientsAgendaElementsItem(agendaElement));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
		}

		return clientAgendas;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
	}

}

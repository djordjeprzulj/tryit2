package fr.ca.sa.externalClients.database.nctAgendaAPI.procedures.getAgendaElement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaApiCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.utilFunctions.TextUtilFunctions;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.AgendaElement;
import fr.ca.sa.model.Client;
import fr.ca.sa.model.Entity;
import fr.ca.sa.model.IdName;
import fr.ca.sa.nctAgendaAPI.commons.services.json.agendaAPI.ReadAgendaRequest;

/**
 * 
 * @author Jelena Raca
 *
 */
public class NCTDatabaseGetAgendaElement extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaElement.class);

	private ReadAgendaRequest req;

	/**
	 * NCT Database Get Agenda Element
	 * 
	 * @param req
	 *            Request
	 */
	public NCTDatabaseGetAgendaElement(ReadAgendaRequest req) {
		this.req = req;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement cs = connection.prepareStatement("exec spGetAgendaAPIData ?,?,?,?,?,?,?,?");
		try {
			if (this.req.getAgendaElementIdList() != null) {
				if (!this.req.getAgendaElementIdList().isEmpty()) {
					String agendaElementIdList = TextUtilFunctions
							.convertIntArrayToSQLString(this.req.getAgendaElementIdList());
					cs.setString(NCTDatabaseConstants.SP_ARG_NR_1, agendaElementIdList);
				} else {
					cs.setNull(NCTDatabaseConstants.SP_ARG_NR_1, Types.INTEGER);
				}
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_1, Types.VARCHAR);
			}
	
			if (this.req.getClientId() != null) {
				cs.setLong(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getClientId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			if (this.req.getEntityId() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.req.getEntityId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
	
			if (this.req.getPeriod() != null) {
				if (this.req.getPeriod().size() > 1) {
					cs.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.req.getPeriod().get(0));
					cs.setString(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getPeriod().get(1));
				} else {
					cs.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.VARCHAR);
					cs.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.VARCHAR);
				}
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.VARCHAR);
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.VARCHAR);
			}
	
			if (this.req.getStatusList() != null) {
				if (!this.req.getStatusList().isEmpty()) {
					String agendaStatusList = TextUtilFunctions.convertIntArrayToSQLString(this.req.getStatusList());
					cs.setString(NCTDatabaseConstants.SP_ARG_NR_6, agendaStatusList);
				} else {
					cs.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.VARCHAR);
				}
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.VARCHAR);
			}
	
			if (this.req.getTypeList() != null) {
				if (!this.req.getTypeList().isEmpty()) {
					String agendaTypes = TextUtilFunctions.convertIntArrayToSQLString(this.req.getTypeList());
					cs.setString(NCTDatabaseConstants.SP_ARG_NR_7, agendaTypes);
				} else {
					cs.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.VARCHAR);
				}
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.VARCHAR);
			}
	
			if (this.req.getCollaboratorId() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.req.getCollaboratorId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}		
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAgendaElementResultList retValue = new GetAgendaElementResultList();
		try {
			while (this.getResultSet().next()) {
				AgendaElement agendaElement = new AgendaElement(this.getResultSet().getInt("AGENDA_ELEMENT_ID"),
																this.getResultSet().getInt("ELEMENT_TYPE_ID"), null, null);				
				agendaElement.setStartTime(this.getResultSet().getString("START_TIME"));
				agendaElement.setEndTime(this.getResultSet().getString("END_TIME"));
				agendaElement.setAgendaId(this.getResultSet().getInt("AGENDA_ID"));
				agendaElement.setPlace(this.getResultSet().getString("PLACE"));
				agendaElement.setPreparationComment(this.getResultSet().getString("PREPARATION_COMMENT"));
				agendaElement.setWeeklyFrequency(this.getResultSet().getInt("PERIODICITY"));
				agendaElement.setComment(this.getResultSet().getString("COMMENTS"));
				agendaElement.setCancelComment(this.getResultSet().getString("CANCEL_COMMENT"));
				agendaElement.setMessageText(this.getResultSet().getString("MESSAGE_TEXT"));
				agendaElement.setAvailable(this.getResultSet().getInt("AVAILABLE"));
				agendaElement.setVisible(this.getResultSet().getInt("VISIBLE") == 1);
				agendaElement.setClosureComment(this.getResultSet().getString("CLOSURE_COMMENT"));
				agendaElement.setStatusId(this.getResultSet().getInt("ELEMENT_STATUS_ID"));
				agendaElement.setCancelReasonId(this.getResultSet().getInt("ELE_ELEMENT_CANCELING_REASON_ID"));
				agendaElement.setReminderTime(this.getResultSet().getInt("RECALL_TIME"));
				agendaElement.setMessageTypeId(this.getResultSet().getInt("ELEMENT_MESSAGE_TYPE_ID"));
				agendaElement.setPurposeId(this.getResultSet().getInt("OBJECT_ELEMENT_ID"));
				agendaElement.setCloseReasonId(this.getResultSet().getInt("ELE_ELEMENT_CLOSING_REASON_ID"));
				agendaElement.setLastModificationDate(this.getResultSet().getString("MODIFICATION_DATE"));
				agendaElement.setLastModifiedBy(String.valueOf(this.getResultSet().getInt("MODIFIED_BY")));
				agendaElement.setCreationDate(this.getResultSet().getString("CREATION_DATE"));
				agendaElement.setCreatedBy(String.valueOf(this.getResultSet().getInt("CREATED_BY")));
				agendaElement.setLocationId(this.getResultSet().getInt("ELE_ELEMENT_LOCATION_ID"));
				agendaElement.setOriginId(this.getResultSet().getInt("ELE_ELEMENT_ORIGIN_ID"));
				agendaElement.setSalesbasketListId(this.getResultSet().getInt("SAL_SALASSBASKET_LIST_ID"));
				agendaElement.setParticipantList(this.getResultSet().getString("PARTICIPANT_LIST"));
				agendaElement.setPurpose(Integer.parseInt(this.getResultSet().getString("PURPOSE")));
				
				Collaborator advisor = new Collaborator();
				advisor.setIdExt(this.getResultSet().getInt("COLLABORATOR_ID_EXT"));
				agendaElement.setAdvisor(advisor);
				
				Entity entity = new Entity(this.getResultSet().getInt("ENTITY_ID_EXT"), null, null, null);
				agendaElement.setEntity(entity);
				
				Client client = new Client(null,
											null, 
											new IdName(0, this.getResultSet().getString("CUSTOMER_TYPE")), 
											null, null, null, null, 
											entity);
				client.setIdExt(this.getResultSet().getLong("CUSTOMER_ID_EXT"));
				agendaElement.setClient(client);
				
				retValue.getAgendaElementList().add(new GetAgendaElementResultItem(agendaElement));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaApiCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_ELEMENT);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaApiCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_ELEMENT);

	}

}

package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.setAgendaItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.utilFunctions.NullChecker;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.nct.commons.services.json.agenda.SetAgendaItemRequest;

/**
 * 
 * Saving agenda item/element in database
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetAgendaItem extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetAgendaItem.class);

	private SetAgendaItemRequest setAgendaRequest;

	private Timestamp fromTS;

	private Timestamp toTS;

	/**
	 * NCT Database Set Agenda Item
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param setAgendaRequest
	 * 				Set agenda request
	 */
	public NCTDatabaseSetAgendaItem(int userId, SetAgendaItemRequest setAgendaRequest) {
		super(userId);
		this.setAgendaRequest = setAgendaRequest;
		this.fromTS = Timestamp.valueOf(setAgendaRequest.getAgendaElement().getStartTime());
		this.toTS = Timestamp.valueOf(setAgendaRequest.getAgendaElement().getEndTime());
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetAgendaElementDetails ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getId())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.setAgendaRequest.getAgendaElement().getId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, java.sql.Types.INTEGER);
			}
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.setAgendaRequest.getAgendaElement().getAgendaId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.setAgendaRequest.getAgendaElement().getTypeId());
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getContactId())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.setAgendaRequest.getAgendaElement().getContactId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, java.sql.Types.INTEGER);
			}

			if (NullChecker.isNotNullAndEmpty(this.setAgendaRequest.getAgendaElement().getClient().getClientOrLead())) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.setAgendaRequest.getAgendaElement().getClient().getClientOrLead());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.VARCHAR);
			}
					
			if (NullChecker.isNotNullAndMinusOne(this.setAgendaRequest.getAgendaElement().getClient().getId())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.setAgendaRequest.getAgendaElement().getClient().getId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, java.sql.Types.INTEGER);
			}
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.setAgendaRequest.getAgendaElement().getAdvisor().getPrimaryEntity().getId());
	
			if (NullChecker.isNotNullAndMinusOne(this.setAgendaRequest.getAgendaElement().getStatusId())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_9, this.setAgendaRequest.getAgendaElement().getStatusId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, java.sql.Types.INTEGER);
			}
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getMessageTypeId())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_10, this.setAgendaRequest.getAgendaElement().getMessageTypeId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_10, java.sql.Types.INTEGER);
			}
	
			if (NullChecker.isNotNullAndEmpty(this.setAgendaRequest.getAgendaElement().getMessageText())) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_11, this.setAgendaRequest.getAgendaElement().getMessageText());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_11, java.sql.Types.VARCHAR);
			}
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getPurposeId())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_12, this.setAgendaRequest.getAgendaElement().getPurposeId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_12, java.sql.Types.INTEGER);
			}
	
			if (this.fromTS != null) {
				ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_13, this.fromTS);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_13, java.sql.Types.TIMESTAMP);
			}
	
			if (this.toTS != null) {
				ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_14, this.toTS);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_14, java.sql.Types.TIMESTAMP);
			}
	
			if (NullChecker.isNotNullAndEmpty(this.setAgendaRequest.getAgendaElement().getPlace())) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_15, this.setAgendaRequest.getAgendaElement().getPlace());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_15, java.sql.Types.VARCHAR);
			}
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getWeeklyFrequency())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_16, this.setAgendaRequest.getAgendaElement().getWeeklyFrequency());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_16, java.sql.Types.INTEGER);
			}
	
			if (NullChecker.isNotNullAndEmpty(this.setAgendaRequest.getAgendaElement().getPreparationComment())) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_17, this.setAgendaRequest.getAgendaElement().getPreparationComment());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_17, java.sql.Types.VARCHAR);
			}
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getReminderTime())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_18, this.setAgendaRequest.getAgendaElement().getReminderTime());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_18, java.sql.Types.INTEGER);
			}
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getCloseReasonId())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_19, this.setAgendaRequest.getAgendaElement().getCloseReasonId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_19, java.sql.Types.INTEGER);
			}
	
			if (NullChecker.isNotNullAndEmpty(this.setAgendaRequest.getAgendaElement().getClosureComment())) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_20, this.setAgendaRequest.getAgendaElement().getClosureComment());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_20, java.sql.Types.VARCHAR);
			}
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getCancelReasonId())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_21, this.setAgendaRequest.getAgendaElement().getCancelReasonId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_21, java.sql.Types.INTEGER);
			}
	
			if (NullChecker.isNotNullAndEmpty(this.setAgendaRequest.getAgendaElement().getCancelComment())) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_22, this.setAgendaRequest.getAgendaElement().getCancelComment());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_22, java.sql.Types.VARCHAR);
			}
	
			if (NullChecker.isNotNullAndEmpty(this.setAgendaRequest.getAgendaElement().getComment())) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_23, this.setAgendaRequest.getAgendaElement().getComment());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_23, java.sql.Types.VARCHAR);
			}
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getAvailable())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_24, this.setAgendaRequest.getAgendaElement().getAvailable());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_24, java.sql.Types.INTEGER);
			}
	
			if (NullChecker.isNotNullAndFalse(this.setAgendaRequest.getAgendaElement().getVisible())) {
				int visible = 0;
				if (this.setAgendaRequest.getAgendaElement().getVisible())
					visible = 1;
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_25, visible);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_25, java.sql.Types.INTEGER);
			}
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getLocationId())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_26, this.setAgendaRequest.getAgendaElement().getLocationId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_26, java.sql.Types.INTEGER);
			}
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getOriginId())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_27, this.setAgendaRequest.getAgendaElement().getOriginId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_27, java.sql.Types.INTEGER);
			}
			
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getLangId())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_28, this.setAgendaRequest.getLangId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_28, java.sql.Types.INTEGER);
			}
	
			if (NullChecker.isNotNullZeroAndMinusOne(this.setAgendaRequest.getAgendaElement().getPurpose())) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_29, this.setAgendaRequest.getAgendaElement().getPurpose());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_29, java.sql.Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}
	
	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetAgendaItem setAgendaItem = new SetAgendaItem();
		try {
			while (this.getResultSet().next()) {
				setAgendaItem = new SetAgendaItem(this.getResultSet().getInt("AgendaElementId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_UPDATE_AGENDA_ITEM);
		}

		return setAgendaItem;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_UPDATE_AGENDA_ITEM);
	}

}

package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.utilFunctions.NullChecker;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Cancel Agenda Item store procedure call
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseCancelAgendaItem extends AbstractUserLanguageStoreProcedureHandler {
	
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseCancelAgendaItem.class);

	private Integer agendaElementId;

	private Integer closeReasonId;

	private Integer cancelReasonId;

	private String comment;

	private Integer clientId;

	private Integer agendaElementTypeId;

	private Integer advisorId;

	/**
	 * NCT Database Cancel Agenda Item
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param agendaElementId
	 * 				Agenda element ID
	 * 
	 * @param closeReasonId
	 * 				Close reason ID
	 * 
	 * @param cancelReasonId
	 * 				Cancel reason ID
	 * 
	 * @param comment
	 * 				Comment
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param agendaElementTypeId
	 * 				Agenda element type ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseCancelAgendaItem(Integer userId, Integer agendaElementId, Integer closeReasonId,
			Integer cancelReasonId, String comment, Integer clientId, Integer agendaElementTypeId, Integer advisorId,
			Integer langId) {
		super(userId, langId);
		this.agendaElementId = agendaElementId;
		this.closeReasonId = closeReasonId;
		this.cancelReasonId = cancelReasonId;
		this.comment = comment;
		this.clientId = clientId;
		this.agendaElementTypeId = agendaElementTypeId;
		this.advisorId = advisorId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement cs = connection.prepareStatement("exec spAnnulCloseAgendaElement ?,?,?,?,?,?,?,?,?");		
		try {
			setUser(cs);

			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.agendaElementId);
			
			if (NullChecker.isNotNullAndMinusOne(this.agendaElementTypeId)) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.agendaElementTypeId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_3, java.sql.Types.INTEGER);
			}
			if (NullChecker.isNotNullAndMinusOne(this.closeReasonId)) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.closeReasonId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_4, java.sql.Types.INTEGER);
			}
			if (NullChecker.isNotNullAndMinusOne(this.cancelReasonId)) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.cancelReasonId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_5, java.sql.Types.INTEGER);
			}
			if (NullChecker.isNotNullAndEmpty(this.comment)) {
				cs.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.comment);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_6, java.sql.Types.VARCHAR);
			}
			if (NullChecker.isNotNullAndMinusOne(this.advisorId)) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.advisorId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_7, java.sql.Types.INTEGER);
			}
			if (NullChecker.isNotNullAndMinusOne(this.clientId)) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.clientId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_8, java.sql.Types.INTEGER);
			}
			
			setLanguage(cs, NCTDatabaseConstants.SP_ARG_NR_9);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}			
		return cs;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_CANCEL_AGENDA_ITEM);
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

}

package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation;

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
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.nct.commons.services.json.agenda.AgendaReassignRequest;

/**
 * 
 * Invoke store procedure for reassigning agenda element
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseReassignAgendaElement extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseReassignAgendaElement.class);
	
	private AgendaReassignRequest request;

	private Integer newAgendaId;
	
	private Timestamp fromTS;

	private Timestamp toTS;

	/**
	 * NCT Database Reassign Agenda Element
	 * 
	 * @param request
	 * 				Request
	 * 
	 * @param agendaId
	 * 				Agenda ID
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseReassignAgendaElement(AgendaReassignRequest request, Integer agendaId, Integer userId, String sdate, String edate) {
		super(userId);
		this.request = request;
		this.newAgendaId = agendaId;		
		this.fromTS = Timestamp.valueOf(sdate);
		this.toTS = Timestamp.valueOf(edate);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spReassignAgendaElement ?,?,?,?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.request.getAgendaElementId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.newAgendaId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.request.getAdvisorEntityId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.request.getLangId());
			
			if (this.fromTS != null) {
				ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_6, this.fromTS);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, java.sql.Types.TIMESTAMP);
			}
	
			if (this.toTS != null) {
				ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_7, this.toTS);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, java.sql.Types.TIMESTAMP);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
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

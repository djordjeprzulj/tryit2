package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaDataByAgendaElementId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting agenda data by agendaElementId
 * 
 * @author Jelena Raca
 *
 */

public class NCTDatabaseGetAgendaDataByAgendaElementId extends AbstractUserStoreProcedureHandler {
	
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaDataByAgendaElementId.class);
	
	private Integer agendaElementId;
	
	/**
	 * NCT Database Get Agenda Data By Agenda Element Id
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param agendaElementId
	 * 				Agenda Element ID
	 */
	
	public NCTDatabaseGetAgendaDataByAgendaElementId(Integer userId, Integer agendaElementId) {
		super(userId);
		this.agendaElementId = agendaElementId;
	}
	
	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetCalendarDataByAgeElemId ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.agendaElementId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAgendaDataByAgendaElementIdNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue=new GetAgendaDataByAgendaElementIdNCTResultItem(this.getResultSet().getInt("AdvisorId"),
								this.getResultSet().getInt("EntityId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaCRUDException();
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException();
	}

}

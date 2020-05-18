package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaAdvisors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Retrieve agenda mapping from database (advisor-agenda)
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetAdvisorsAgendaIDs extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAdvisorsAgendaIDs.class);

	/**
	 * NCT Database Get Advisors Agenda IDs
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetAdvisorsAgendaIDs(Integer userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetAgendaAdvisors ?");
		try {
			setUser(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}	
		return ps;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAgendaAdvisorAgendaIDItemList agendaList = new GetAgendaAdvisorAgendaIDItemList();
		try {
			while (this.getResultSet().next()) {
				agendaList.getAdvisorAgendaList().add(new GetAgendaAdvisorAgendaIDItem(
						this.getResultSet().getInt("AgendaId"), this.getResultSet().getInt("AdvisorId")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
		}

		return agendaList;
	}

}

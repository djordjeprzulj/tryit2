package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getExistsAppointments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.nct.commons.services.json.agenda.GetExistingAppointmentsRequest;

/**
 * 
 * Retrieve agenda data based on specific time frame (either for advisor or
 * entity)
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetExistsAppoinments extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetExistsAppoinments.class);

	private GetExistingAppointmentsRequest request;

	/**
	 * NCT Database Get Exists Appoinments
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param request
	 * 				Request
	 */
	public NCTDatabaseGetExistsAppoinments(int userId, GetExistingAppointmentsRequest request) {
		super(userId);
		this.request = request;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetExistsAppointments ?,?,?,?");
		try {
			setUser(ps);			
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, request.getClientId());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, request.getStartTime());
			if (this.request.getAgendaElementId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.request.getAgendaElementId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, java.sql.Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetExistsAppointmentsList agendaList = new GetExistsAppointmentsList();
		try {
			while (this.getResultSet().next()) {
				agendaList.getAppointments().add(new GetExistsAppointmentsItem(this.getResultSet().getInt("AdvisorId"),
						this.getResultSet().getString("AdvisorFirstName"),
						this.getResultSet().getString("AdvisorLastName"), this.getResultSet().getString("StartTime")));
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

package fr.ca.sa.externalClients.database.common.procedures.worktime.setWorktime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.WorkTimeCRUDException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure for setting specific entity work time information
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetWorktime extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetWorktime.class);
	
	SetWorktimeDataNCTRequest setWorktimeRequest;

	/**
	 * NCT Database Set Worktime
	 * 
	 * @param request
	 * 				Request
	 */
	public NCTDatabaseSetWorktime(SetWorktimeDataNCTRequest request) {
		super();
		this.setWorktimeRequest = request;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetEntityDayWorkTimeByEntityId ?,?,?,?,?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, setWorktimeRequest.getUserId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, setWorktimeRequest.getDayNumber());
			if (setWorktimeRequest.getEntityId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, setWorktimeRequest.getEntityId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
			ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_4, setWorktimeRequest.getMorningStart());
			ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_5, setWorktimeRequest.getMorningEnd());
			ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_6, setWorktimeRequest.getAfternoonStart());
			ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_7, setWorktimeRequest.getAfternoonEnd());
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
		throw new WorkTimeCRUDException();
	}

}

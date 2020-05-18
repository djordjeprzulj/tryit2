package fr.ca.sa.externalClients.database.common.procedures.worktime.getWorktime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.WorkTimeCRUDException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure call for retrieving Bank entity work time information
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetBankEntityWorktimeInfo extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankEntityWorktimeInfo.class);

	private Integer entityId;

	/**
	 * NCT DatabaseGet Bank Entity Worktime Info
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param entityId
	 * 				Entity ID
	 */
	public NCTDatabaseGetBankEntityWorktimeInfo(Integer userId, Integer entityId) {
		super(userId);
		this.entityId = entityId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetEntityWorkTimeByEntityId ?,?");
		try {
			setUser(ps);

			if (this.entityId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.entityId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, java.sql.Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetBankEntityWorkTimeNCTResultList retList = new GetBankEntityWorkTimeNCTResultList();
		if (this.entityId != null) {
			retList.setEntityId(this.entityId);
		}
		try {
			while (this.getResultSet().next()) {
				retList.getDayList()
						.add(new GetBankEntityWorkTimeNCTResultItem(this.getResultSet().getInt("ENTITY_ID"),
								this.getResultSet().getString("ENTITY_NAME"), this.getResultSet().getInt("DAY_NUMBER"),
								this.getResultSet().getTimestamp("MORNING_START"),
								this.getResultSet().getTimestamp("MORNING_END"),
								this.getResultSet().getTimestamp("AFTERNOON_END"),
								this.getResultSet().getTimestamp("AFTERNOON_START")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new WorkTimeCRUDException();
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new WorkTimeCRUDException();
	}

}

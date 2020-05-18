package fr.ca.sa.externalClients.database.nct.procedures.audit.getAuditDataCount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.nct.commons.services.json.audit.AuditDataRequest;

/**
 * 
 * Retrieve list of audit data
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetAuditDataCount extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAuditDataCount.class);

	private AuditDataRequest req;

	/**
	 * NCT Database Get Audit Data Count
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseGetAuditDataCount(int userId, AuditDataRequest req) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetAuditLogCount ?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
	
			if (this.req.getAdvisorId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getAdvisorId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, java.sql.Types.INTEGER);
			}
	
			if (this.req.getEntityId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.req.getEntityId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, java.sql.Types.INTEGER);
			}
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.req.getApplicationId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getTransactionId());
	
			if (this.req.getLangCode() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.req.getLangCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, java.sql.Types.INTEGER);
			}
	
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_7, this.req.getStartTime());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_8, this.req.getEndTime());
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}

		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAuditDataCount logCount = new GetAuditDataCount();
		try {
			while (this.getResultSet().next()) {
				logCount = new GetAuditDataCount(this.getResultSet().getInt("RecordCount"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return logCount;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

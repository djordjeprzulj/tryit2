package fr.ca.sa.externalClients.database.nct.procedures.audit.getAuditData;

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
public class NCTDatabaseGetAuditData extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAuditData.class);

	private AuditDataRequest req;
	private int resultLimit;

	/**
	 * NCT Database Get Audit Data
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param req
	 * 				Request
	 * 
	 * @param resultLimit
	 * 				Result limit
	 */
	public NCTDatabaseGetAuditData(int userId, AuditDataRequest req, int resultLimit) {
		super(userId);
		this.req = req;
		this.resultLimit = resultLimit;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetAuditLog ?,?,?,?,?,?,?,?,?");
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
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_9, this.resultLimit);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}

		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAuditDataList auditData = new GetAuditDataList();
		try {
			while (this.getResultSet().next()) {
				auditData.getLogs().add(new GetAuditDataItem(this.getResultSet().getInt("CollaboratorId"),
						this.getResultSet().getString("ResultString"), this.getResultSet().getDate("TransDate")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return auditData;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

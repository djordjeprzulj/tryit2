package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankSegments.NCTDatabaseGetBankSegments;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting flows for job
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetFlows extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankSegments.class);

	private Integer jobId;

	/**
	 * default constructor for NCT Database Get Flows
	 */
	public NCTDatabaseGetFlows() {
		super();
	}

	/**
	 * NCT Database Get Flows
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param jobId
	 * 				Job ID
	 */
	public NCTDatabaseGetFlows(Integer userId, Integer jobId) {
		super(userId);
		this.jobId = jobId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetFlows ?,?");
		try {
			setUser(ps);
			if (this.jobId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.jobId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetFlowsNCTResultList retList = new GetFlowsNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getFlows()
						.add(new GetFlowsNCTResultItem(this.getResultSet().getInt("FLOW_ID"),
								this.getResultSet().getString("FILE_NAME"),
								this.getResultSet().getInt("FLO_FLOW_DIRECTION_TYPE_ID"),
								this.getResultSet().getInt("FLO_FLOW_PROCESS_PERIOD_TYPE_ID"),
								this.getResultSet().getInt("JOB_JOB_ID"), this.getResultSet().getInt("LEVEL"),
								this.getResultSet().getInt("PARENT_FLOW_ID"), this.getResultSet().getString("NAME"),
								this.getResultSet().getString("DESCRIPTION"), this.getResultSet().getInt("SKIP_LIMIT"),
								this.getResultSet().getInt("RETRY_LIMIT"), this.getResultSet().getInt("ACTIVE")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		LOGGER.error(ex);
		throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
	}

}

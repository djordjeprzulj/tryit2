package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getActiveBankFlowDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetActiveBankDetail extends AbstractUserStoreProcedureHandler{

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetActiveBankDetail.class);

	/**
	 * default constructor for NCT Database Get Active Bank Detail
	 */
	public NCTDatabaseGetActiveBankDetail() {
		super();
	}

	/**
	 * NCT Database Get Active Bank Detail
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetActiveBankDetail(Integer userId) {
		super(userId);
	}
	
	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetActiveBankFlowDetail ?");
		try {
			setUser(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}
	
	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetActiveBankFlowDetailNCTResultList retList = new GetActiveBankFlowDetailNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getActiveBankFlowDetails().add(new GetActiveBankFlowDetailNCTResultItem(this.getResultSet().getInt("bankId"),
						this.getResultSet().getInt("flowId"), this.getResultSet().getString("flowName"),
						this.getResultSet().getString("flowDirection"), this.getResultSet().getInt("activeProcessingTypeId"),
						this.getResultSet().getInt("flowProcessingTypeID"),this.getResultSet().getString("flowProcessingTypeName"),
						this.getResultSet().getInt("jobID"),this.getResultSet().getString("jobName")));
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

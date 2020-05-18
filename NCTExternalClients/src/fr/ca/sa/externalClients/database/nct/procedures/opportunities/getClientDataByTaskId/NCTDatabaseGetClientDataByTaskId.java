package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getClientDataByTaskId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.OpportunitiesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting client data by taskId
 * 
 * @author Milos Topalovic
 *
 */
public class NCTDatabaseGetClientDataByTaskId extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientDataByTaskId.class);

	private String taskId;
	
	/**
	 * NCT Database Get Opportunities Categories
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param taskId
	 * 				Task ID
	 */
	
	public NCTDatabaseGetClientDataByTaskId(Integer userId, String taskId) {
		super(userId);
		this.taskId = taskId;
	}
	
	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetClientDataByTaskId ?,?");
		try {
			setUser(ps);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.taskId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetClientDataByTaskIdNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue=new GetClientDataByTaskIdNCTResultItem(this.getResultSet().getInt("ClientId"),
								this.getResultSet().getInt("ClientEntityId"), this.getResultSet().getInt("PortfolioId"),
								this.getResultSet().getString("C_L"), this.getResultSet().getInt("OpportunityId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new OpportunitiesCRUDException();
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new OpportunitiesCRUDException();
	}
}

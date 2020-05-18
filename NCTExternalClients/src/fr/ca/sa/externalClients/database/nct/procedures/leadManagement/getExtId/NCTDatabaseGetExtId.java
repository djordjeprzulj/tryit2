package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.getExtId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure call for retrieving competitors
 * 
 *
 *
 */
public class NCTDatabaseGetExtId extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetExtId.class);

	private Integer nctId;
	private String tableName;

	

	/**
	 * NCT Database Get External ID
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param nctId
	 * 				NCT ID
	 * 
	 * @param tableName
	 * 				Table name
	 */
	public NCTDatabaseGetExtId(Integer userId, Integer nctId, String tableName) {
		super(userId);
		this.nctId = nctId;
		this.tableName = tableName;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetExtId ?,?,?");
		try {
			setUser(ps);			
			if (this.nctId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.nctId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, java.sql.Types.INTEGER);
			}
			
			if (this.tableName != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.tableName);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, java.sql.Types.NVARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetExtIdNCTResultItem result=new GetExtIdNCTResultItem();
		try {
			while (this.getResultSet().next()) {
				result.setExtId(this.getResultSet().getString("ExtId"));
						
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return result;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

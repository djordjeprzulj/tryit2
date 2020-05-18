package fr.ca.sa.externalClients.database.nct.procedures.getNctId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ParametersCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems.getCivilities.NCTDatabaseGetProspectClientCivilities;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetNctId extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetProspectClientCivilities.class);

	private Integer extId;
	private String tableName;

	/**
	 * 
	 * @param userId
	 * @param req
	 */
	public NCTDatabaseGetNctId(Integer userId, Integer extId, String tableName) {
		super(userId);
		this.extId = extId;
		this.tableName = tableName;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetNctId ?,?");
		try {
			
			ps.setLong(NCTDatabaseConstants.SP_ARG_NR_1, this.extId);
		
			if (this.tableName != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.tableName);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, java.sql.Types.NVARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetNctIdNCTResultItem retValue = new GetNctIdNCTResultItem();
		try {
			while (this.getResultSet().next()) {

				retValue = new GetNctIdNCTResultItem(this.getResultSet().getInt("NctId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new ParametersCRUDException();
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ParametersCRUDException();
	}

}

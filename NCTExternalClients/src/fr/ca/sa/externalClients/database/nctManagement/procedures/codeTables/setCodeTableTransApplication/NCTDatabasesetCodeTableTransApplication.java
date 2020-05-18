package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.setCodeTableTransApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.CodeTablesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.codeTables.SetCodeTableTransApplicationRequest;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.SetCodeTableNCTResultItem;

/**
 * 
 * Store procedure handler for setting competitor code table data for
 * transApplication
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabasesetCodeTableTransApplication extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabasesetCodeTableTransApplication.class);

	private SetCodeTableTransApplicationRequest request;

	/**
	 * NCT Database set Code Table Transaction Application
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param request
	 * 				Request
	 */
	public NCTDatabasesetCodeTableTransApplication(int userId, SetCodeTableTransApplicationRequest request) {
		super(userId);
		this.request = request;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetTransApplication ?,?,?,?,?");
		try {
			setUser(ps);
		
			if (this.request.getApplicationCode() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.request.getApplicationCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
		
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.request.getApplicationNameL1());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.request.getApplicationNameL2());
		
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.request.isActive() ? NCTDatabaseConstants.ACTIVE_INTEGER_VALUE : NCTDatabaseConstants.INACTIVE_INTEGER_VALUE);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetCodeTableNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new SetCodeTableNCTResultItem(this.getResultSet().getInt("ApplicationCode"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_SET_CODE_TABLE_DATA);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_SET_CODE_TABLE_DATA);
	}
}

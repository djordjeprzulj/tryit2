package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.setCodeTableReasonTreated;

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
import fr.ca.sa.commons.sharedEntities.codeTables.SetCodeTableReasonTreatedRequest;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.SetCodeTableNCTResultItem;

/**
 * 
 * Store procedure handler for setting competitor code table data for treated
 * reasons
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabasesetCodeTableReasonTreated extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabasesetCodeTableReasonTreated.class);

	private SetCodeTableReasonTreatedRequest request;

	/**
	 * NCT Database set CodeTable Reason Treated
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param request
	 * 				Request
	 */
	public NCTDatabasesetCodeTableReasonTreated(int userId, SetCodeTableReasonTreatedRequest request) {
		super(userId);
		this.request = request;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetOppSubCatReasonTreated ?,?,?,?,?,?,?");
		try {
			setUser(ps);
	
			if (this.request.getReasonId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.request.getReasonId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.request.getOppSubCategoryId());
	
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.request.getNameL1());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_5, this.request.getNameL2());
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.request.getReasonOrder());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.request.isActive() ? NCTDatabaseConstants.ACTIVE_INTEGER_VALUE : NCTDatabaseConstants.INACTIVE_INTEGER_VALUE);
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
				retValue = new SetCodeTableNCTResultItem(this.getResultSet().getInt("ReasonId"));
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

package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.setCodeTableStringAudit;

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
import fr.ca.sa.commons.sharedEntities.codeTables.SetCodeTableStringAuditRequest;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.SetCodeTableNCTResultItem;

/**
 * 
 * Store procedure handler for setting competitor code table data for string
 * audit
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabasesetCodeTableStringAudit extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabasesetCodeTableStringAudit.class);

	private SetCodeTableStringAuditRequest request;

	/**
	 * NCT Database set Code Table String Audit
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param request
	 * 				Request
	 */
	public NCTDatabasesetCodeTableStringAudit(int userId, SetCodeTableStringAuditRequest request) {
		super(userId);
		this.request = request;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetStringAudit ?,?,?,?,?");
		try {
			setUser(ps);
	
			if (this.request.getStringId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.request.getStringId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.request.getParamValueL1());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.request.getParamValueL2());
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.request.isActive() ? NCTDatabaseConstants.ACTIVE_INTEGER_VALUE
					: NCTDatabaseConstants.INACTIVE_INTEGER_VALUE);
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
				retValue = new SetCodeTableNCTResultItem(this.getResultSet().getInt("StringId"));
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

package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.setClientCodeType;

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
import fr.ca.sa.commons.sharedEntities.codeTables.SetCodeTableClientCodeTypeRequest;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.SetCodeTableNCTResultItem;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetClientCodeType extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetClientCodeType.class);

	private SetCodeTableClientCodeTypeRequest req;

	/**
	 * NCT Database Set Client Code Type
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseSetClientCodeType(int userId, SetCodeTableClientCodeTypeRequest req) {
		super(userId);
		this.req = req;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetClientCodeType ?,?,?,?,?,?");
		try {
			setUser(ps);
	
			if (this.req.getClientCodeTypeId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getClientCodeTypeId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
			if (this.req.getExternalId() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.req.getExternalId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.NVARCHAR);
			}
			if (this.req.getNameL1() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.req.getNameL1());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.NVARCHAR);
			}
			if (this.req.getNameL2() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getNameL2());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.NVARCHAR);
			}
			if (this.req.getActive() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.req.getActive() ? NCTDatabaseConstants.ACTIVE_INTEGER_VALUE
						: NCTDatabaseConstants.INACTIVE_INTEGER_VALUE);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_SET_CODE_TABLE_DATA);
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetCodeTableNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new SetCodeTableNCTResultItem(this.getResultSet().getInt("ClientCodeTypeId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_SET_CODE_TABLE_DATA);
		}
		return retValue;
	}
}

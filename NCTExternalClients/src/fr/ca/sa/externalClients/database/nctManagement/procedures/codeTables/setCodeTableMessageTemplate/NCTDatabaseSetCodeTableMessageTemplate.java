package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.setCodeTableMessageTemplate;

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
import fr.ca.sa.commons.sharedEntities.codeTables.SetCodeTableMessageTemplateRequest;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.SetCodeTableNCTResultItem;

/**
 * 
 * Store procedure handler for setting message template code tables data
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetCodeTableMessageTemplate extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetCodeTableMessageTemplate.class);

	private SetCodeTableMessageTemplateRequest request;

	/**
	 * NCT Database Set Code Table Message Template
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param request
	 * 				Request
	 */
	public NCTDatabaseSetCodeTableMessageTemplate(int userId, SetCodeTableMessageTemplateRequest request) {
		super(userId);
		this.request = request;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetMessageTemplate ?,?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
	
			if (this.request.getId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.request.getId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
			if (this.request.getTypeId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.request.getTypeId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.request.getNameL1());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_5, this.request.getNameL2());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.request.getTextL1());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_7, this.request.getTextL2());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8,
					this.request.isReadOnly() ? NCTDatabaseConstants.ACTIVE_INTEGER_VALUE : NCTDatabaseConstants.INACTIVE_INTEGER_VALUE);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_9, this.request.isActive() ? NCTDatabaseConstants.ACTIVE_INTEGER_VALUE : NCTDatabaseConstants.INACTIVE_INTEGER_VALUE);
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
				retValue = new SetCodeTableNCTResultItem(this.getResultSet().getInt("MessageTemplateId"));
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

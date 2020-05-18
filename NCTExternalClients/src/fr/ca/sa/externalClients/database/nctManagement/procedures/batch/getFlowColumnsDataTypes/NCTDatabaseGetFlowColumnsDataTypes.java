package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowColumnsDataTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.BatchCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for getting flow column data types
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetFlowColumnsDataTypes extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetFlowColumnsDataTypes.class);

	/**
	 * default constructor for NCT Database Get Flow Columns Data Types
	 */
	public NCTDatabaseGetFlowColumnsDataTypes() {
		super();
	}

	/**
	 * NCT Database Get Flow Columns Data Types
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetFlowColumnsDataTypes(Integer userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetFlowColumnsDataTypes ?");
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
		GetFlowColumnsDataTypesNCTResultList retList = new GetFlowColumnsDataTypesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getColumnDataTypes().add(new GetFlowColumnsDataTypesNCTResultItem(
						this.getResultSet().getInt("DATA_TYPE_ID"), this.getResultSet().getString("NAME")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new BatchCRUDException(ErrorConstants.ERROR_MSG_GET_FLOW_CONFIGURATION);
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchCRUDException(ErrorConstants.ERROR_MSG_GET_FLOW_CONFIGURATION);
	}

}

package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowProcessPeriodTypes;

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
 * Store procedure handler for flows process period times
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetFlowProcessPeriodTypes extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetFlowProcessPeriodTypes.class);

	/**
	 * defauolt constructor for NCT Database Get Flow Process Period Types
	 */
	public NCTDatabaseGetFlowProcessPeriodTypes() {
		super();
	}

	/**
	 * NCT Database Get Flow Process Period Types
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetFlowProcessPeriodTypes(Integer userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetFlowProcessPeriodTypes ?");
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
		GetFlowProcessPeriodTypesNCTResultList retList = new GetFlowProcessPeriodTypesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getFlowPeriodTypes()
						.add(new GetFlowProcessPeriodTypesNCTResultItem(
								this.getResultSet().getInt("FLOW_PROCESS_PERIOD_TYPE_ID"),
								this.getResultSet().getString("NAME")));
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

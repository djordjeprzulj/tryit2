package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowDirectionTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for flows direction
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetFlowDirectionTypes extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetFlowDirectionTypes.class);

	/**
	 * default constructor for NCT Database Get Flow Direction Types
	 */
	public NCTDatabaseGetFlowDirectionTypes() {
		super();
	}

	/**
	 * NCT Database Get Flow Direction Types
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetFlowDirectionTypes(Integer userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetFlowDirectionTypes ?");
		try {
			if (this.userId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.userId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_1, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}		
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetFlowDirectionTypesNCTResultList retList = new GetFlowDirectionTypesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getDirections().add(new GetFlowDirectionTypesNCTResultItem(
						this.getResultSet().getInt("FLOW_DIRECTION_TYPE_ID"), this.getResultSet().getString("NAME")));
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

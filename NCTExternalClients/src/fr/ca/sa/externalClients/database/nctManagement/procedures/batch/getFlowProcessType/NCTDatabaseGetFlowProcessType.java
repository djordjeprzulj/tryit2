package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowProcessType;

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
 * Store procedure handler for flows types
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetFlowProcessType extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetFlowProcessType.class);

	/**
	 * default constructor for NCT Database Get Flow Process Type
	 */
	public NCTDatabaseGetFlowProcessType() {
		super();
	}

	/**
	 * NCT Database Get Flow Process Type
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetFlowProcessType(Integer userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spGetFlowProcessType ?");
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
		GetFlowProcessTypeNCTResultList retList = new GetFlowProcessTypeNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getTypes().add(new GetFlowProcessTypeNCTResultItem(
						this.getResultSet().getInt("flowProcessingTypeId"), this.getResultSet().getString("flowProcessingTypeName")));
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

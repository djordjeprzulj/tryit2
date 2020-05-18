package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.setCodeTableAgendaWorkingSituation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.codeTables.SetCodeTableAgendaWorkingSituationRequest;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.SetCodeTableNCTResultItem;

/**
 * 
 * Store procedure handler for setting competitor code table data
 * 
 * @author Milos Topalovic
 *
 */
public class NCTDatabasesetCodeTableSetAgendaWorkingSituation extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabasesetCodeTableSetAgendaWorkingSituation.class);

	private SetCodeTableAgendaWorkingSituationRequest request;

	/**
	 * 
	 * @param userId
	 * @param request
	 */
	public NCTDatabasesetCodeTableSetAgendaWorkingSituation(int userId, SetCodeTableAgendaWorkingSituationRequest request) {
		super(userId);
		this.request = request;

	}
 
	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetAgendaWorkingSituation ?,?,?,?,?");
		try {
			setUser(ps);
			if (this.request.getElementObjectTypeCode() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.request.getElementObjectTypeCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.request.getNameL1());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.request.getNameL2());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5,
					this.request.getActive() ? NCTDatabaseConstants.ACTIVE_INTEGER_VALUE
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
				retValue = new SetCodeTableNCTResultItem(this.getResultSet().getInt("ElementObjectTypeCode"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new LoadingConfigurationException();
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}
}

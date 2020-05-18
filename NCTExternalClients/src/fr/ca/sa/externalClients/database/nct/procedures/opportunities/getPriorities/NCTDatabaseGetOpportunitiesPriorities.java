package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getPriorities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting priorities for opportunities in bank
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetOpportunitiesPriorities extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOpportunitiesPriorities.class);

	/**
	 * NCT Database Get Opportunities Priorities
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetOpportunitiesPriorities(int userId) {
		super(userId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetBankOpportPriorities ?");
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
		GetOpportunitiesPrioritiesNCTResultList retValue = new GetOpportunitiesPrioritiesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getPriorities().add(new GetOpportunitiesPrioritiesNCTResultItem(
						this.getResultSet().getInt("PriorityId"), this.getResultSet().getString("PriorityName")));
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

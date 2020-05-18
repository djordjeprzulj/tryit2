package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getBankEntitiesByUserId;

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
 * Store procedure handler for getting categories for opportunities in bank
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetBankEntitiesByUserId extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankEntitiesByUserId.class);

	/**
	 * NCT Database Get Opportunities Categories
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetBankEntitiesByUserId(int userId) {
		super(userId);
		
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetBankEntitiesByUserId ?");
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
		GetBankEntitiesByUserIdNCTResultList retValue = new GetBankEntitiesByUserIdNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getEntities()
						.add(new GetBankEntitiesByUserIdNCTResultItem(this.getResultSet().getInt("ENTITY_ID"),
								this.getResultSet().getString("ENTITY_NAME")));
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

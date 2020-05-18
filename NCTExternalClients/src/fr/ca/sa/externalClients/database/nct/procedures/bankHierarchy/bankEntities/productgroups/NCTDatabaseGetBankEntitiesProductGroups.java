package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.productgroups;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting bank entities product groups
 * 
 * @author Milivoj Bozic
 *
 */
public class NCTDatabaseGetBankEntitiesProductGroups extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankEntitiesProductGroups.class);

	/**
	 * default constructor for NCT Database Get Bank Entities Product Groups
	 */
	public NCTDatabaseGetBankEntitiesProductGroups() {
		super();
	}

	/**
	 * NCT Database Get Bank Entities Product Groups
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetBankEntitiesProductGroups(Integer userId, Integer langId) {
		super(userId, langId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetProductGroupByEnt ?,?");
		try {
			setUserAndLanguage(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}		
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		HashMap<Integer, String> items = new HashMap<Integer, String>();
		try {
			while (this.getResultSet().next()) {
				items.put(this.getResultSet().getInt("ProductGroupId"),
						this.getResultSet().getString("ProductGroupName"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return new GetBankEntitiesProductGroupsNCTResultList(items);
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

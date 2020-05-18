package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems.getActiveSectors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems.LeadManagementNCTResultItem;
import fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems.LeadManagementNCTResultList;

/**
 * 
 * Store procedure call for retrieving prospect activity sectors
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetProspectClientActSectors extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetProspectClientActSectors.class);

	/**
	 * NCT Database Get Prospect Client Active Sectors
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetProspectClientActSectors(Integer userId, Integer langId) {
		super();
		this.userId = userId;
		this.langId = langId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetProspectClientActSectors ?,?");
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
		LeadManagementNCTResultList retList = new LeadManagementNCTResultList();

		try {
			while (this.getResultSet().next()) {
				retList.getItemList()
						.add(new LeadManagementNCTResultItem(this.getResultSet().getInt("ActivitySectorId"),
								this.getResultSet().getString("ActivitySectorName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}

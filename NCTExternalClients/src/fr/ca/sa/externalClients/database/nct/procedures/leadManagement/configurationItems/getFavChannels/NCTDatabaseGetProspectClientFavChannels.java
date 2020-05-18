package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems.getFavChannels;

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
 * Store procedure call for retrieving prospect client favorite channels
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetProspectClientFavChannels extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetProspectClientFavChannels.class);

	/**
	 * NCT Database Get Prospect Client Fav Channels
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetProspectClientFavChannels(Integer userId, Integer langId) {
		super(userId, langId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetProspectClientFavChannels ?,?");
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
						.add(new LeadManagementNCTResultItem(this.getResultSet().getInt("FavoriteChannelId"),
								this.getResultSet().getString("FavoriteChannelName")));
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

package fr.ca.sa.externalClients.database.nctManagement.procedures.campaigns.setHomepageCampaigns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.CampaignsCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting homepage campaign
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetHomepageCampaign extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetHomepageCampaign.class);

	private int campaignId;
	private int campaignOrder;
	private String campaignUrl;
	private int isActive;

	/**
	 * NCT Database Set Homepage Campaign
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param campaignId
	 * 				Campaign ID
	 * 
	 * @param campaignOrder
	 * 				Campaign order
	 * 
	 * @param campaignUrl
	 * 				Campaign URL
	 * 
	 * @param isActive
	 * 				Activity
	 */
	public NCTDatabaseSetHomepageCampaign(int userId, int campaignId, int campaignOrder, String campaignUrl,
			int isActive) {
		super(userId);
		this.campaignId = campaignId;
		this.campaignOrder = campaignOrder;
		this.campaignUrl = campaignUrl;
		this.isActive = isActive;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetAppHomePageCampaign ?,?,?,?,?");
		try {
			setUser(ps);
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.campaignId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.campaignOrder);
	
			if (this.campaignUrl != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.campaignUrl);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.VARCHAR);
			}
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.isActive);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetHomepageCampaignNCTResultItem retValue = new SetHomepageCampaignNCTResultItem();
		try {
			while (this.getResultSet().next()) {

				retValue.setCampaignId(this.getResultSet().getInt("CampaignId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new CampaignsCRUDException(ErrorConstants.ERROR_MSG_SET_CAMPAIGNS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new CampaignsCRUDException(ErrorConstants.ERROR_MSG_SET_CAMPAIGNS);
	}
}

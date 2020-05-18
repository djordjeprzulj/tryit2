package fr.ca.sa.externalClients.database.common.procedures.campaigns.getHomepageCampaigns;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting homepage campaigns
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetHomepageCampaigns extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetHomepageCampaigns.class);

	/**
	 * NCT Database Get Homepage Campaigns
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetHomepageCampaigns(Integer userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetAppHomePageCampaigns ?");
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
		GetHomepageCampaignsNCTResultListImages retList = new GetHomepageCampaignsNCTResultListImages();
		try {
			while (this.getResultSet().next()) {
				InputStream tempPictureStream = this.getResultSet().getBinaryStream("CampaignPicture");
				if (tempPictureStream != null) {
					ImageInfoContainer imageContainer = new ImageInfoContainer(tempPictureStream);
					retList.getImagesMapByName(GetHomepageCampaignsNCTResultListImages.CAMPAIGN_PIC_NAME)
							.put(String.valueOf(this.getResultSet().getInt("CampaignOrder")), imageContainer);
					tempPictureStream.close();
				}

				retList.getParameters().getCampaigns()
						.add(new GetHomepageCampaignsNCTResultItem(this.getResultSet().getInt("CampaignId"),
								this.getResultSet().getInt("CampaignOrder"),
								this.getResultSet().getString("CampaignUrl"), this.getResultSet().getInt("isActive")));
			}
		} catch (SQLException | IOException ex) {
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

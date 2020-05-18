package fr.ca.sa.externalClients.database.nctManagement.procedures.campaigns.setHomepageCampaignPicture;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.imageio.ImageIO;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.CampaignsCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for setting homepage campaign picture
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetHomepageCampaignPicture extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetHomepageCampaignPicture.class);

	private int campaignId;
	private InputStream campaignPicture;

	SetHomepageCampaignPictureNCTResultListImages retValue = new SetHomepageCampaignPictureNCTResultListImages();

	/**
	 * NCT Database Set Homepage Campaign Picture
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param campaignId
	 * 				Campaign ID
	 * 
	 * @param campaignPicture
	 * 				Campaign picture
	 */
	public NCTDatabaseSetHomepageCampaignPicture(int userId, int campaignId, InputStream campaignPicture) {
		super(userId);
		this.campaignId = campaignId;
		this.campaignPicture = campaignPicture;
		try {
			if (campaignPicture != null) {
				ImageInfoContainer imageContainer = new ImageInfoContainer(this.campaignPicture);
				retValue.getImagesMapByName(SetHomepageCampaignPictureNCTResultListImages.CAMPAIGN_PIC_NAME).put(String.valueOf(campaignId), imageContainer);

				// Rewrite image into stream
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				ImageIO.write(imageContainer.getImageContent(), imageContainer.getImageType(), os);
				this.campaignPicture = new ByteArrayInputStream(os.toByteArray());
			}
		} catch (IOException ex) {
			LOGGER.error(ex);
			throw new CampaignsCRUDException(ErrorConstants.ERROR_MSG_SET_CAMPAIGNS);
		}

	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetAppHomePageCampaignPicture ?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.campaignId);
	
			if (this.campaignPicture != null) {
				ps.setBinaryStream(NCTDatabaseConstants.SP_ARG_NR_3, this.campaignPicture);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.VARBINARY);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		try {
			while (this.getResultSet().next()) {

				retValue.setCampaign(
						new SetHomepageCampaignPictureNCTResultItem(this.getResultSet().getInt("CampaignId")));
			}
			if (this.campaignPicture != null) {
				this.campaignPicture.close();
			}
		} catch (SQLException | IOException ex) {
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

package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientOpportunities;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.model.Opportunity;
import fr.ca.sa.model.OpportunitySubcategory;
import fr.ca.sa.nct.commons.NCTSystemConstants;
import fr.ca.sa.nct.commons.services.json.salesAssistant.GetClientOpportunitiesRequest;

/**
 * 
 * Store procedure handler for getting client opportunities from db catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetClientOpportunities extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientOpportunities.class);

	private GetClientOpportunitiesRequest req;

	/**
	 * NCT Database Get Client Opportunities
	 * 
	 * @param req
	 * 				Request
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetClientOpportunities(GetClientOpportunitiesRequest req, int userId, int langId) {
		super(userId, langId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetSalAssOpportByClientId ?,?,?");
		try {		
			setUser(cs);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getClientId());
			setLanguage(cs, NCTDatabaseConstants.SP_ARG_NR_3);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}				
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetClientOpportunitiesNCTResultListImages retValue = new GetClientOpportunitiesNCTResultListImages();
		try {
			while (this.getResultSet().next()) {
				InputStream tempPictureStream = this.getResultSet().getBinaryStream("OpportPicture");
				if (tempPictureStream != null) {
					ImageInfoContainer imageContainer = new ImageInfoContainer(tempPictureStream);
					retValue.getImagesMapByName(GetClientOpportunitiesNCTResultListImages.OPPORTUNITY_PIC_MAP_NAME)
							.put(String.valueOf(this.getResultSet().getInt("OpportunityId")), imageContainer);
					tempPictureStream.close();
				}

				Opportunity opportunity = new Opportunity(this.getResultSet().getInt("OpportunityId"), this.getResultSet().getInt("OpportTypeId"), null);
				opportunity.setSubcategory(new OpportunitySubcategory(this.getResultSet().getInt("OpportStateId"), 
						null, this.getResultSet().getString("OpportSubCatName"), null));
				
				DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
				Timestamp tsStartDate = this.getResultSet().getTimestamp("OpportStartDate");
				String strStartDate = null;

				if (tsStartDate != null) {
					strStartDate = df.format(tsStartDate);
				}
				opportunity.setStartDate(strStartDate);

				Timestamp tsExpirationDate = this.getResultSet().getTimestamp("OpportExpirationDate");
				String strExpirationDate = null;
				if (tsExpirationDate != null) {
					strExpirationDate = df.format(tsExpirationDate);
				}
				opportunity.setExpirationDate(strExpirationDate);
				
				opportunity.setTreatmentPeriod(this.getResultSet().getString("TreatmentPeriod"));
				opportunity.setLongDescription(this.getResultSet().getString("OpportLongDescription"));
				opportunity.setTipsLink(this.getResultSet().getString("OpportTipsLink"));
				opportunity.setTipsDesc(this.getResultSet().getString("OpportTipsDesc"));
				opportunity.setSimulatorLink(this.getResultSet().getString("OpportSimulatorLink"));
				opportunity.setCategoryPictureUri(NCTSystemConstants.getOpportunityCategoriesPictures().get(this.getResultSet().getInt("OpportTypeId")));
				
				retValue.getOpportunities().getOpportunities().add(new GetClientOpportunitiesNCTResultItem(opportunity));
						
						
						
						
						
			}
		} catch (SQLException | IOException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_PRODUCTS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_PRODUCTS);
	}
}

package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.getProspects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LeadManagementCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.Entity;
import fr.ca.sa.model.IdName;
import fr.ca.sa.model.PhoneInfo;
import fr.ca.sa.model.Prospect;

/**
 * 
 * Store procedure handler for getting prospect in bank
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetProspect extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetProspect.class);

	private int prospectId;

	/**
	 * NCT Database Get Prospect
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 */
	public NCTDatabaseGetProspect(int userId, int prospectId) {
		super(userId);
		this.prospectId = prospectId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetProspect ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.prospectId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetProspectNCTResultItem retValue = new GetProspectNCTResultItem();
		try {
			while (this.getResultSet().next()) {
				PhoneInfo professional = new PhoneInfo(this.getResultSet().getString("ProfesionalPhone"),
						this.getResultSet().getString("ProfesionalPhoneCountryCode"),
						this.getResultSet().getString("ProfesionalPhoneCallNumber"),
						this.getResultSet().getString("ProfesionalPhoneNumber"));
				PhoneInfo mobile = new PhoneInfo(this.getResultSet().getString("MobilePhone"),
						this.getResultSet().getString("MobilePhoneCountryCode"),
						this.getResultSet().getString("MobilePhoneCallNumber"),
						this.getResultSet().getString("MobilePhoneNumber"));
				PhoneInfo personal = new PhoneInfo(this.getResultSet().getString("PersonalPhone"),
						this.getResultSet().getString("PersonalPhoneCountryCode"),
						this.getResultSet().getString("PersonalPhoneCallNumber"),
						this.getResultSet().getString("PersonalPhoneNumber"));
				String strBirthDate = null;
				
				if (this.getResultSet().getDate("BirthDate") != null) {
					DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
					strBirthDate = df.format(this.getResultSet().getDate("BirthDate"));
				}
				
				retValue = new GetProspectNCTResultItem(new Prospect(
						this.getResultSet().getInt("ProspectId"),
						this.getResultSet().getString("ProspectCode"), 
						new IdName(this.getResultSet().getInt("ProspectTypeId"), this.getResultSet().getString("ProspectType")),
						new IdName(this.getResultSet().getInt("SegmentId"), this.getResultSet().getString("Segment")),
						new IdName(this.getResultSet().getInt("PortfolioId"), this.getResultSet().getString("PortfolioName")),
						new Entity(this.getResultSet().getInt("EntityId"), null, null, null),
						this.getResultSet().getString("CompanyName"), 
						this.getResultSet().getString("FirstName"),
						this.getResultSet().getString("LastName"), 
						this.getResultSet().getInt("CivilityId"),
						this.getResultSet().getInt("MaritalStatusId"), 
						this.getResultSet().getInt("ChildrenNumber"),
						this.getResultSet().getInt("CSPId"), 
						this.getResultSet().getInt("ActivitySectorId"),
						this.getResultSet().getInt("FavotiteChannelId"),
						strBirthDate,
						this.getResultSet().getString("BirthPlace"), 
						this.getResultSet().getString("Nationality"),
						this.getResultSet().getString("Address"), 
						this.getResultSet().getString("AdditionalAddress"),
						this.getResultSet().getString("Postcode"), 
						this.getResultSet().getString("City"),
						this.getResultSet().getInt("CountryId"),
						this.getResultSet().getInt("OriginId"),
						this.getResultSet().getString("EmailAddress"), 
						this.getResultSet().getString("Comment"),
						this.getResultSet().getInt("StatusId"),
						this.getResultSet().getInt("ClientCodeType"),
						professional, personal, mobile));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_GET_PROSPECT_DATA);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_GET_PROSPECT_DATA);
	}
}

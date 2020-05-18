package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.setProspect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LeadManagementCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.nct.commons.services.json.leadManagement.SetProspectRequest;

/**
 * 
 * Store procedure handler for setting prospect in bank
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetProspect extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetProspect.class);

	private SetProspectRequest req;
	private Long prospectExtId;
	private String clientCodeType;

	/**
	 * NCT Database Set Prospect
	 * 
	 * @param userId        User ID
	 * 
	 * @param req           Request
	 * 
	 * @param prospectExtId Prospect external ID
	 */
	public NCTDatabaseSetProspect(int userId, SetProspectRequest req, Long prospectExtId, String clientCodeType) {
		super(userId);
		this.req = req;
		this.prospectExtId = prospectExtId;
		this.clientCodeType = clientCodeType;
	}

	/**
	 * NCT Database Set Prospect
	 * 
	 * @param userId User ID
	 * 
	 * @param req    Request
	 */
	public NCTDatabaseSetProspect(int userId, SetProspectRequest req, String clientCodeType) {
		super(userId);
		this.req = req;
		this.clientCodeType = clientCodeType;

	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(
				"exec spSetProspect ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
		try {
			setUser(ps);

			if (this.req.getProspect().getId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getProspect().getId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}

			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.req.getProspect().getEntity().getId());

			if (this.req.getProspect().getOriginId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.req.getProspect().getOriginId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.INTEGER);
			}

			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getProspect().getEntryOrigin());

			if (this.req.getProspect().getCode() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.req.getProspect().getCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.VARCHAR);
			}

			if (this.req.getProspect().getPortfolio() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.req.getProspect().getPortfolio().getId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.INTEGER);
			}

			if (this.req.getProspect().getSegment() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.req.getProspect().getSegment().getId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.INTEGER);
			}

			if (this.req.getProspect().getType() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_9, this.req.getProspect().getType().getId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, Types.INTEGER);
			}

			if (this.req.getProspect().getCompanyName() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_10, this.req.getProspect().getCompanyName());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_10, Types.VARCHAR);
			}

			if (this.req.getProspect().getFirstName() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_11, this.req.getProspect().getFirstName());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_11, Types.VARCHAR);
			}

			if (this.req.getProspect().getLastName() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_12, this.req.getProspect().getLastName());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_12, Types.VARCHAR);
			}

			if (this.req.getProspect().getCivilityId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_13, this.req.getProspect().getCivilityId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_13, Types.INTEGER);
			}

			if (this.req.getProspect().getMaritalStatusId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_14, this.req.getProspect().getMaritalStatusId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_14, Types.INTEGER);
			}

			if (this.req.getProspect().getChildrenNumber() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_15, this.req.getProspect().getChildrenNumber());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_15, Types.INTEGER);
			}

			if (this.req.getProspect().getCspId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_16, this.req.getProspect().getCspId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_16, Types.INTEGER);
			}

			if (this.req.getProspect().getActivitySectorId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_17, this.req.getProspect().getActivitySectorId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_17, Types.INTEGER);
			}

			if (this.req.getProspect().getFavoriteChannelId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_18, this.req.getProspect().getFavoriteChannelId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_18, Types.INTEGER);
			}

			if (this.req.getProspect().getBirthDate() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_19, this.req.getProspect().getBirthDate());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_19, Types.DATE);
			}

			if (this.req.getProspect().getBirthPlace() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_20, this.req.getProspect().getBirthPlace());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_20, Types.VARCHAR);
			}

			if (this.req.getProspect().getNationality() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_21, this.req.getProspect().getNationality());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_21, Types.VARCHAR);
			}

			if (this.req.getProspect().getAddress() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_22, this.req.getProspect().getAddress());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_22, Types.VARCHAR);
			}

			if (this.req.getProspect().getAdditionalAddress() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_23, this.req.getProspect().getAdditionalAddress());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_23, Types.VARCHAR);
			}

			if (this.req.getProspect().getPostCode() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_24, this.req.getProspect().getPostCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_24, Types.VARCHAR);
			}

			if (this.req.getProspect().getCity() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_25, this.req.getProspect().getCity());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_25, Types.VARCHAR);
			}

			if (this.req.getProspect().getCountryId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_26, this.req.getProspect().getCountryId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_26, Types.INTEGER);
			}

			if (this.req.getProspect().getProfessional().getPhone() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_27, this.req.getProspect().getProfessional().getPhone());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_27, Types.VARCHAR);
			}

			if (this.req.getProspect().getProfessional().getPhoneCountryCode() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_28, this.req.getProspect().getProfessional().getPhoneCountryCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_28, Types.VARCHAR);
			}

			if (this.req.getProspect().getProfessional().getPhoneCallNumber() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_29, this.req.getProspect().getProfessional().getPhoneCallNumber());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_29, Types.VARCHAR);
			}

			if (this.req.getProspect().getProfessional().getPhoneNumber() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_30, this.req.getProspect().getProfessional().getPhoneNumber());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_30, Types.VARCHAR);
			}

			if (this.req.getProspect().getPersonal().getPhone() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_31, this.req.getProspect().getPersonal().getPhone());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_31, Types.VARCHAR);
			}

			if (this.req.getProspect().getPersonal().getPhoneCountryCode() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_32, this.req.getProspect().getPersonal().getPhoneCountryCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_32, Types.VARCHAR);
			}

			if (this.req.getProspect().getPersonal().getPhoneCallNumber() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_33, this.req.getProspect().getPersonal().getPhoneCallNumber());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_33, Types.VARCHAR);
			}

			if (this.req.getProspect().getPersonal().getPhoneNumber() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_34, this.req.getProspect().getPersonal().getPhoneNumber());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_34, Types.VARCHAR);
			}

			if (this.req.getProspect().getMobile().getPhone() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_35, this.req.getProspect().getMobile().getPhone());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_35, Types.VARCHAR);
			}

			if (this.req.getProspect().getMobile().getPhoneCountryCode() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_36, this.req.getProspect().getMobile().getPhoneCountryCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_36, Types.VARCHAR);
			}

			if (this.req.getProspect().getMobile().getPhoneCallNumber() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_37, this.req.getProspect().getMobile().getPhoneCallNumber());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_37, Types.VARCHAR);
			}

			if (this.req.getProspect().getMobile().getPhoneNumber() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_38, this.req.getProspect().getMobile().getPhoneNumber());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_38, Types.VARCHAR);
			}

			if (this.req.getProspect().getEmailAddress() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_39, this.req.getProspect().getEmailAddress());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_39, Types.VARCHAR);
			}

			if (this.req.getProspect().getComment() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_40, this.req.getProspect().getComment());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_40, Types.VARCHAR);
			}
			if (this.req.getProspect().getStatusId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_41, this.req.getProspect().getStatusId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_41, Types.INTEGER);
			}
			if (this.prospectExtId != null) {
				ps.setLong(NCTDatabaseConstants.SP_ARG_NR_42, this.prospectExtId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_42, Types.BIGINT);
			}
			if (this.clientCodeType != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_43, this.clientCodeType);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_43, Types.VARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetProspectNCTResultItem retValue = new SetProspectNCTResultItem();
		try {
			while (this.getResultSet().next()) {
				retValue = new SetProspectNCTResultItem(this.getResultSet().getInt("ProspectId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_SET_PROSPECT);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_SET_PROSPECT);
	}
}

package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.checkProspectDuplicate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LeadManagementCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.utilFunctions.NullChecker;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.nct.commons.services.json.leadManagement.CheckProspectDuplicatesRequest;

/**
 * 
 * Routine for checking if given data from @CheckProspectDuplicatesRequest
 * produces similar results in database
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseCheckProspectDuplicates extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseCheckProspectDuplicates.class);

	private CheckProspectDuplicatesRequest checkProspectDuplicates;
	private Timestamp birthDate;
	private String clientCode;

	/**
	 * NCT Database Check Prospect Duplicates
	 * 
	 * @param userId
	 *            User ID
	 * 
	 * @param request
	 *            Request
	 * 
	 * @throws ParseException
	 *             Throws parse exception
	 */
	public NCTDatabaseCheckProspectDuplicates(int userId, CheckProspectDuplicatesRequest request) throws ParseException {
		super(userId);
		this.checkProspectDuplicates = request;
		if (request.getBirthDate() != null && !request.getBirthDate().isEmpty()) {
			SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.getBackboneOnlyDateDatetimeFormat());
			birthDate = new Timestamp(formatter.parse(request.getBirthDate()).getTime());
		} else {
			this.birthDate = null;
		}

		this.clientCode = request.getClientCode();
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spCheckProspectDuplicates ?,?,?,?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.checkProspectDuplicates.getIsIndividual());
	
			if (this.checkProspectDuplicates.getFirstName().isEmpty()) {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.VARCHAR);
			} else {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.checkProspectDuplicates.getFirstName());
			}
	
			if (this.checkProspectDuplicates.getLastName().isEmpty()) {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.VARCHAR);
			} else {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.checkProspectDuplicates.getLastName());
			}
	
			if (this.birthDate != null) {
				ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_5, this.birthDate);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.TIMESTAMP);
			}
	
			if (this.checkProspectDuplicates.getCompanyName().isEmpty()) {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.VARCHAR);
			} else {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.checkProspectDuplicates.getCompanyName());
			}
	
			if (this.checkProspectDuplicates.getEmailAddress() != null
					&& !this.checkProspectDuplicates.getEmailAddress().isEmpty()) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_7, this.checkProspectDuplicates.getEmailAddress());
			} else {
	
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.VARCHAR);
			}
	
			if (this.clientCode != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_8, this.clientCode);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.VARCHAR);
			}
			if (NullChecker.isNotNullAndEmpty(this.checkProspectDuplicates.getProfesionalPhone())) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_9, this.checkProspectDuplicates.getProfesionalPhone());
			} else {
	
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, Types.VARCHAR);
			}
			if (NullChecker.isNotNullAndEmpty(this.checkProspectDuplicates.getPersonalPhone())) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_10, this.checkProspectDuplicates.getPersonalPhone());
			} else {
	
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_10, Types.VARCHAR);
			}
			if (NullChecker.isNotNullAndEmpty(this.checkProspectDuplicates.getMobilePhone())) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_11, this.checkProspectDuplicates.getMobilePhone());
			} else {
	
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_11, Types.VARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}

		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		CheckProspectDuplicatesResult retValue = null;

		try {
			while (this.getResultSet().next()) {
				retValue = new CheckProspectDuplicatesResult(this.getResultSet().getInt("NumberOfDuplicates"),
						this.getResultSet().getInt("EmailIsDuplicate"),
						this.getResultSet().getInt("ClientCodeIsDuplicate"),
						this.getResultSet().getInt("ProfesionalPhoneIsDuplicate"),
						this.getResultSet().getInt("PersonalPhoneIsDuplicate"),
						this.getResultSet().getInt("MobilePhoneIsDuplicate"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_PROSPECT_DUPLICATE);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_PROSPECT_DUPLICATE);
	}
}

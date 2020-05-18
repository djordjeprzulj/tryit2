package fr.ca.sa.externalClients.database.nct.procedures.quickContact.updateQCRItems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.QuickContactReportCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.QuickContactReport;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseQuickContactCreate extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseQuickContactCreate.class);
	
	private QuickContactReport quickContactReport;

	/**
	 * NCT Database Quick Contact Create
	 * 
	 * @param quickContactReport
	 * 				Quick Contact Report
	 * 
	 */
	public NCTDatabaseQuickContactCreate(Integer userId, QuickContactReport quickContactReport) {
		super(userId);
		this.quickContactReport = quickContactReport;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetQReportDetails ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.quickContactReport.getClient().getClientOrLead());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.quickContactReport.getClient().getId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.quickContactReport.getEntityId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.quickContactReport.getAdvisorId());
			if (this.quickContactReport.getRequestId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.quickContactReport.getRequestId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, java.sql.Types.INTEGER);
			}
			if (this.quickContactReport.getChannelId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.quickContactReport.getChannelId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, java.sql.Types.INTEGER);
			}
			if (this.quickContactReport.getReasonId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.quickContactReport.getReasonId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, java.sql.Types.INTEGER);
			}
			if (this.quickContactReport.getClaimReasonId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_9, this.quickContactReport.getClaimReasonId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, java.sql.Types.INTEGER);
			}
			if (this.quickContactReport.getUnreachableReasonId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_10, this.quickContactReport.getUnreachableReasonId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_10, java.sql.Types.INTEGER);
			}
			if (this.quickContactReport.getNotIntReasonId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_11, this.quickContactReport.getNotIntReasonId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_11, java.sql.Types.INTEGER);
			}
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_12, this.quickContactReport.getResultId());
			
			ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_13, this.quickContactReport.getTsReportDate());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_14, this.quickContactReport.getComment());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_15, this.quickContactReport.getEmailText());
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		UpdateQCRResultItem setResponse = new UpdateQCRResultItem();

		try {
			while (this.getResultSet().next()) {
				setResponse.setQcrId(this.getResultSet().getInt("QCReportId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_CREATE_QCR);
		}

		return setResponse;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_CREATE_QCR);
	}

}

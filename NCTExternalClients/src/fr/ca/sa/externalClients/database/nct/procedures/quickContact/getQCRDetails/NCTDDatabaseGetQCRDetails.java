package fr.ca.sa.externalClients.database.nct.procedures.quickContact.getQCRDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.QuickContactReportCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.Client;
import fr.ca.sa.model.Entity;
import fr.ca.sa.model.QuickContactReport;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDDatabaseGetQCRDetails extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDDatabaseGetQCRDetails.class);

	private Integer qcrReportId;
	private String dataSource;	

	/**
	 * NCTD Database Get QCR Details
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param qcrReportId
	 * 				QCR report ID
	 */
	public NCTDDatabaseGetQCRDetails(Integer userId, Integer qcrReportId, String dataSource) {
		super(userId);
		this.qcrReportId = qcrReportId;
		this.dataSource = dataSource;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetQReportDetails ?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.qcrReportId);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.dataSource);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetQCRDetailsNCTResultItem qcrDetails = null;

		try {
			while (this.getResultSet().next()) {
				Client client = new Client(this.getResultSet().getInt("ClientId"), 
											new Entity(this.getResultSet().getInt("ClientEntityId"), null, null, null),
											this.getResultSet().getString("C_L"));
				client.setPortfolioId(this.getResultSet().getInt("ClientPortfolioId"));
				client.setAdvisorId(this.getResultSet().getInt("ClientAdvisorId"));
				
				SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
				Timestamp tsReportDate = this.getResultSet().getTimestamp("ReportDate");
				String strReportDate = formatter.format(tsReportDate);
				
				QuickContactReport qcr = new QuickContactReport(client, 
						this.getResultSet().getInt("EntityId"),
						this.getResultSet().getInt("AdvisorId"),
						this.getResultSet().getInt("RequestId"), 
						this.getResultSet().getInt("ChannelId"),
						this.getResultSet().getInt("ReasonId"), 
						this.getResultSet().getInt("ClaimReasonId"),
						this.getResultSet().getInt("UnReachableReasonId"), 
						this.getResultSet().getInt("NotintReasonId"),
						this.getResultSet().getInt("ResultId"), 
						this.getResultSet().getString("Comment"),
						this.getResultSet().getString("EmailText"), 
						strReportDate, tsReportDate);
				
				qcrDetails = new GetQCRDetailsNCTResultItem(qcr);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_GET_QCR_DETAILS);
		}

		return qcrDetails;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_GET_QCR_DETAILS);
	}
}

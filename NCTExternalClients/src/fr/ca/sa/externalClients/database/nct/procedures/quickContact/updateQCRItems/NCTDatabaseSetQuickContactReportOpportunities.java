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

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetQuickContactReportOpportunities extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetQuickContactReportOpportunities.class);

	private Integer qcrReportId;

	private Integer opportunityId;

	private Integer oldStateId;

	private Integer newStateId;

	/**
	 * NCT Database Set Quick Contact Report Opportunities
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param qcrReportId
	 * 				QC report ID
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 * @param oldStateId
	 * 				Old state ID
	 * 
	 * @param newStateId
	 * 				New state ID
	 */
	public NCTDatabaseSetQuickContactReportOpportunities(Integer userId, Integer qcrReportId, Integer opportunityId,
			Integer oldStateId, Integer newStateId) {
		super(userId);
		this.qcrReportId = qcrReportId;
		this.opportunityId = opportunityId;
		this.oldStateId = oldStateId;
		this.newStateId = newStateId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spAddQReportOpportunities ?,?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.qcrReportId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.opportunityId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.oldStateId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.newStateId);
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
				setResponse.setQcrId(this.getResultSet().getInt("Error"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_UPDATE_QCR);
		}

		return setResponse;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_UPDATE_QCR);
	}

}

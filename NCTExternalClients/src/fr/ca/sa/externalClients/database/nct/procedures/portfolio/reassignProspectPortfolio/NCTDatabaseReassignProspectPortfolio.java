package fr.ca.sa.externalClients.database.nct.procedures.portfolio.reassignProspectPortfolio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.PortfoliosCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for reassigning prospect to portfolio
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseReassignProspectPortfolio extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseReassignProspectPortfolio.class);

	private int prospectId;
	private int portfolioId;

	/**
	 * NCT Database Reassign Prospect Portfolio
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 */
	public NCTDatabaseReassignProspectPortfolio(int userId, int prospectId, int portfolioId) {
		super(userId);
		this.prospectId = prospectId;
		this.portfolioId = portfolioId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spAssignProspPortf ?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.prospectId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.portfolioId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		ReassignProspectPortfolioNCTResultItem retValue = new ReassignProspectPortfolioNCTResultItem();

		try {
			while (this.getResultSet().next()) {
				retValue.setPortfolioId(this.getResultSet().getInt("PortfolioId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_REASSIGN_PORTFOLIOS);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_REASSIGN_PORTFOLIOS);
	}
}

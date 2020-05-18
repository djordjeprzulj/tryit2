package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioCalc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.PortfoliosCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting portfolios calculations for user ID and
 * portfolio ID
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetPortfolioCalc extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetPortfolioCalc.class);

	private int portfolioId;

	/**
	 * NCT Database Get Portfolio Calc
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 */
	public NCTDatabaseGetPortfolioCalc(int userId, int portfolioId) {
		super(userId);
		this.portfolioId = portfolioId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetPortfolioCalc ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.portfolioId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetPortfolioCalcNCTResultItem retValue = new GetPortfolioCalcNCTResultItem();
		try {
			while (this.getResultSet().next()) {
				retValue.setClientCount(this.getResultSet().getInt("ClientCount"));
				retValue.setProspectCount(this.getResultSet().getInt("ProspectCount"));
				retValue.setSize(this.getResultSet().getInt("Size"));
				retValue.setFillRate(this.getResultSet().getInt("FillRate"));
				retValue.setQuality(this.getResultSet().getInt("Quality"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_PORTFOLIOS);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_PORTFOLIOS);
	}
}

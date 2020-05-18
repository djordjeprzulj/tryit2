package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioDetailsCount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.PortfoliosCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioDataCount.GetPortfolioDataCountNCTResult;

/**
 * 
 * Get count of clients in portfolio
 * 
 * @author Sasa Radovanovic
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetPortfolioDetailsCount extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetPortfolioDetailsCount.class);

	private int portfolioId;
	private Integer clientTypeId;
	private Integer clientSegmentId;
	private String clientCode;

	/**
	 * NCT Database Get Portfolio Details Count
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 * 
	 * @param clientTypeId
	 * 				Client type ID
	 * 
	 * @param clientSegmentId
	 * 				Client segment ID
	 * 
	 * @param clientCode
	 * 				Client code
	 */
	public NCTDatabaseGetPortfolioDetailsCount(int portfolioId, Integer clientTypeId, Integer clientSegmentId, String clientCode) {
		super();
		this.portfolioId = portfolioId;
		this.clientTypeId = clientTypeId;
		this.clientSegmentId = clientSegmentId;
		this.clientCode=clientCode;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spPagingRetrievePortfDetsCount ?,?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.portfolioId);
	
			if (this.clientTypeId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.clientTypeId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			if (this.clientSegmentId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.clientSegmentId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
			if (this.clientCode != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.clientCode);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.NVARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetPortfolioDataCountNCTResult retValue = null;
		try {
			while (this.getResultSet().next()) {
				if (retValue == null) {
					retValue = new GetPortfolioDataCountNCTResult(this.getResultSet().getInt("RecordCount"));
				}
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

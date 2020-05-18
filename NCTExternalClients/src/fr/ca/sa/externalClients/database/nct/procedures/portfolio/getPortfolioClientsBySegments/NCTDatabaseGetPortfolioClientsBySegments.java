package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioClientsBySegments;

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
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure call for retrieving portfolio clients by segment
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetPortfolioClientsBySegments extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetPortfolioClientsBySegments.class);

	private Integer portfolioId;

	/**
	 * NCT Database Get Portfolio Clients By Segments
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 */
	public NCTDatabaseGetPortfolioClientsBySegments(int userId, Integer portfolioId) {
		super(userId); 
		this.portfolioId = portfolioId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetPortfolioClientsBySegment ?,?");
		try {
			setUser(ps);
	
			if (this.portfolioId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.portfolioId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetPortfolioClientsBySegmetsNCTResultList retValue = new GetPortfolioClientsBySegmetsNCTResultList();
		try {
			while (this.getResultSet().next()) {

				retValue.getPortfolioClientBySegments()
						.add(new GetPortfolioClientsBySegmetsNCTResultItem(this.getResultSet().getInt("SegmentId"),
								this.getResultSet().getString("ClientSegment"),
								this.getResultSet().getInt("ClientNUmber"), this.getResultSet().getInt("GreenColour")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_PORTFOLIOS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex
			) throws StatementExecutionException {
		throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_PORTFOLIOS);
	}
}

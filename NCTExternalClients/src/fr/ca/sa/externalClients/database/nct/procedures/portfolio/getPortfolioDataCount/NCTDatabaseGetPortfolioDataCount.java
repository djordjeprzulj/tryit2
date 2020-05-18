package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioDataCount;

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
import fr.ca.sa.nct.commons.services.json.portfolioManagement.GetPortfoliosRequest;

/**
 * 
 * Store procedure handler for getting portfolios count for entity and advisor
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetPortfolioDataCount extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetPortfolioDataCount.class);

	private GetPortfoliosRequest req;

	/**
	 * NCT Database Get Portfolio Data Count
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseGetPortfolioDataCount(GetPortfoliosRequest req) {
		super();
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spPagingRetrievePortfolioCount ?,?,?");
		try {
			if (this.req.getEntityId() != null && this.req.getEntityId() != -1) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.req.getEntityId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_1, Types.INTEGER);
			}
	
			if (this.req.getAdvisorId() != null && this.req.getAdvisorId() != -1) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getAdvisorId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
			
			if (this.req.getPortfolioTypeId() != null && this.req.getPortfolioTypeId() != -1) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.req.getPortfolioTypeId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
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

package fr.ca.sa.externalClients.database.common.procedures.users.getUserPortfolio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.UserCRUDException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure call for retrieving User portfolios
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetUserPortfolios extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetUserPortfolios.class);

	/**
	 * NCT Database Get User Portfolios
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetUserPortfolios(int userId) {
		super(userId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetUserPortfoliosByUserId ?");
		try {
			setUser(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		UserPortfolioList userPortfolios = new UserPortfolioList();
		try {
			while (this.getResultSet().next()) {
				userPortfolios.getUserPortfolios()
						.add(new UserPortfolioItem(this.getResultSet().getString("PORTFOLIO_CODE"),
								this.getResultSet().getString("PORTFOLIO_NAME"),
								this.getResultSet().getInt("PORTFOLIO_ID")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new UserCRUDException(ErrorConstants.ERROR_MSG_GET_USER_DATA);
		}

		return userPortfolios;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new UserCRUDException(ErrorConstants.ERROR_MSG_GET_USER_DATA);
	}

}

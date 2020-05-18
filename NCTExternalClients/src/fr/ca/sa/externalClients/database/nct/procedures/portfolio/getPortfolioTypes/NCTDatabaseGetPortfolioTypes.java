package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.PortfoliosCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting portfolio types for entity and advisor
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetPortfolioTypes extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetPortfolioTypes.class);

	/**
	 * NCT Database Get Portfolio Types
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetPortfolioTypes(Integer userId) {
		super(userId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 

		PreparedStatement ps = connection.prepareStatement("exec spGetPortfolioTypes ?");
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
		GetPortfolioTypesNCTResultList retValue = new GetPortfolioTypesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getTypes().add(new GetPortfolioTypesNCTResultItem(this.getResultSet().getInt("TypeId"),
						this.getResultSet().getString("TypeName"), this.getResultSet().getString("TypeCode")));
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

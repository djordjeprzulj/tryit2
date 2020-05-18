package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getRolePerimeters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.RoleCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for getting role perimeters
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetRolePerimeters extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetRolePerimeters.class);

	/**
	 * NCT Database Get Role Perimeters
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetRolePerimeters(Integer userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetRolePerimeters ?");
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
		GetRolePerimetersNCTResultList retList = new GetRolePerimetersNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getPerimeters()
						.add(new GetRolePerimetersNCTResultItem(this.getResultSet().getInt("PerimeterId"),
								this.getResultSet().getString("PerimeterName"),
								this.getResultSet().getString("PerimeterDescription")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new RoleCRUDException(ErrorConstants.ERROR_MSG_GET_ROLE_PERIMETER);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new RoleCRUDException(ErrorConstants.ERROR_MSG_GET_ROLE_PERIMETER);
	}
}

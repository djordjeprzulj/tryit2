package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getCodeTableNames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.CodeTablesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting code tables names
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetCodeTableNames extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetCodeTableNames.class);

	/**
	 * NCT Database Get CodeTable Names
	 * 
	 * @param userId
	 */
	public NCTDatabaseGetCodeTableNames(Integer userId) {
		super();
		this.userId = userId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetCodeTableNames ?");
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
		GetCodeTableNamesNCTResultList retList = new GetCodeTableNamesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getNames().add(new GetCodeTableNamesNCTResultItem(this.getResultSet().getInt("CodeTableId"),
						this.getResultSet().getString("CodeTableName"), this.getResultSet().getInt("isSimpleStructure"),
						this.getResultSet().getInt("isReadOnly"),this.getResultSet().getString("TableAlias")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_GET_CODE_TABLE_CONFIG);
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_GET_CODE_TABLE_CONFIG);
	}
}

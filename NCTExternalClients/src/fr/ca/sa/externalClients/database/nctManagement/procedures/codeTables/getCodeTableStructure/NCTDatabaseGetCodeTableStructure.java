package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getCodeTableStructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
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
public class NCTDatabaseGetCodeTableStructure extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetCodeTableStructure.class);

	private String tableName;

	/**
	 * NCT Database Get Code Table Structure
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param tableName
	 * 				Table name
	 */
	public NCTDatabaseGetCodeTableStructure(int userId, String tableName) {
		super(userId);
		this.tableName = tableName;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetTableStructure ?,?");
		try {
			setUser(ps);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.tableName);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetCodeTableStructureNCTResultList retList = new GetCodeTableStructureNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getStructures()
						.add(new GetCodeTableStructureNCTResultItem(this.getResultSet().getString("ColumnName"),
								this.getResultSet().getString("DataType"), this.getResultSet().getInt("maxLength"),
								this.getResultSet().getInt("isNullable")));
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

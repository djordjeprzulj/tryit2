package fr.ca.sa.externalClients.database.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.DatabaseConnectionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.PreparedStatementBatchBuilderI;
import fr.ca.sa.externalClients.database.common.PreparedStatementBuilderI;

/**
 * 
 * Class for executing previously created prepared statements using connection
 * from DatasourceProxy
 * 
 * @author Nemanja Ignjatov
 *
 */
public class PreparedStatementExecutor extends DatasourceProxy {

	private static final Logger LOGGER = Logger.getLogger(PreparedStatementExecutor.class);

	private ResultSet rs = null;

	public PreparedStatementExecutor() throws DatabaseConnectionException {
		super();
	}

	/**
	 * Execute Statement
	 * 
	 * @param statementBuilder
	 * 				Statement builder
	 * 
	 * @return resultset
	 * 				Returns result set
	 * 
	 * @throws StatementExecutionException
	 * 				Throws Statement Execution Exception
	 */
	public ResultSet executeStatement(PreparedStatementBuilderI statementBuilder) throws StatementExecutionException {
		ResultSet rs = null;
		try {
			if (statementBuilder instanceof PreparedStatementBatchBuilderI) {
				// In case of bulk, connection commit should be controlled
				Connection conn = createConnection();
				PreparedStatementBatchBuilderI psbb = null;
				if (statementBuilder instanceof PreparedStatementBatchBuilderI) {
					psbb = (PreparedStatementBatchBuilderI) statementBuilder; 
				}
				// Set commit settings for connection
				psbb.setConnectionAutoCommit(conn);
				// Create bulk statement
				Statement st = statementBuilder.buildPreparedStatement(createConnection());
				// Execute batch and commit to DB
				PreparedStatement ps = null;
				if (st instanceof PreparedStatement) {
					ps = (PreparedStatement) st;
				}
				psbb.commitBatchBulk(ps, conn);
			} else {
				Statement st = statementBuilder.buildPreparedStatement(createConnection());
				if (st instanceof CallableStatement) {
					((CallableStatement) st).execute();
				} else if (st instanceof PreparedStatement) {
					rs = ((PreparedStatement) st).executeQuery();
				}
			}
		} catch (SQLException ex) {
			LOGGER.error("Exception in SQL");
			LOGGER.error(ex);
			statementBuilder.throwFailedStatementExeption(ex);
		}

		return rs;
	}

	/**
	 * Clean Up
	 * 
	 * @throws SQLException
	 * 				Throws SQL Exception
	 */
	public void cleanUp() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		closeConnection();
	}

}

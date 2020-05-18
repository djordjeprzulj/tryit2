package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.cancelClientProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for canceling project
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseCancelClientProject extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseCancelClientProject.class);

	private int projectId;
	private String comment;

	/**
	 * NCT Database Cancel Client Project
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param projectId
	 * 				Project ID
	 * 
	 * @param comment
	 * 				Comment
	 */
	public NCTDatabaseCancelClientProject(int userId, int projectId, String comment) {
		super(userId);
		this.projectId = projectId;
		this.comment = comment;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spAnnulProject ?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.projectId);
	
			if (this.comment != null && !this.comment.isEmpty()) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.comment);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.VARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		CancelClientProjectNCTResultItem retValue = new CancelClientProjectNCTResultItem();

		try {
			while (this.getResultSet().next()) {
				retValue.setProjectId(this.getResultSet().getInt("ProjectId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_PROJECTS);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_PROJECTS);
	}
}

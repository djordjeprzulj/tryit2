package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientProjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting client projects from db catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetClientProjects extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientProjects.class);

	private int clientId;

	private Integer needCategoryId;

	/**
	 * NCT Database Get Client Projects
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param needCategoryId
	 * 				Need category ID
	 */
	public NCTDatabaseGetClientProjects(int userId, int clientId, Integer needCategoryId) {
		super(userId);
		this.clientId = clientId;
		this.needCategoryId = needCategoryId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssProjectsByClient ?,?,?");
		try {		
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.clientId);
			if (needCategoryId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.needCategoryId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}								
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetClientProjectsNCTResultList retValue = new GetClientProjectsNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getProjects()
						.add(new GetClientProjectsNCTResultItem(this.getResultSet().getInt("ProjectId"),
								this.getResultSet().getInt("ProjectCategoryId"),
								this.getResultSet().getString("ProjectCategoryNameL1"),
								this.getResultSet().getString("ProjectCategoryNameL2"),
								this.getResultSet().getInt("NeedCategoryId"), this.getResultSet().getDate("TargetDate"),
								this.getResultSet().getDouble("Amount"), this.getResultSet().getInt("CurrencyId"),
								this.getResultSet().getString("Comment")));
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

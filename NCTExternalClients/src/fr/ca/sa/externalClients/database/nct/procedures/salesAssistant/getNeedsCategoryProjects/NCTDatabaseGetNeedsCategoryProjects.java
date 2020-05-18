package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNeedsCategoryProjects;

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
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.nct.commons.services.json.salesAssistant.GetClientNeedsCategoryProjectsRequest;

/**
 * 
 * Store procedure handler for getting needs category projects from db catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetNeedsCategoryProjects extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetNeedsCategoryProjects.class);

	private GetClientNeedsCategoryProjectsRequest req;

	/**
	 * NCT Database Get Needs Category Projects
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param languageId
	 * 				Language ID
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseGetNeedsCategoryProjects(Integer userId, Integer languageId,
			GetClientNeedsCategoryProjectsRequest req) {
		super(userId, languageId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetSalAssNeedCatProjects ?,?,?");
		try {		
			setUser(cs);
			if ((this.req != null) && (this.req.getNeedCategoryId() != null)) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getNeedCategoryId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
			setLanguage(cs, NCTDatabaseConstants.SP_ARG_NR_3);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}		
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetNeedsCategoryProjectsNCTResultList retValue = new GetNeedsCategoryProjectsNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getNeedsCatProjects()
						.add(new GetNeedsCategoryProjectsNCTResultItem(this.getResultSet().getInt("NeedCategoryId"),
								this.getResultSet().getString("NeedCategoryName"),
								this.getResultSet().getInt("ProjectCategoryId"),
								this.getResultSet().getString("ProjectCategoryName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_NEEDS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_NEEDS);
	}
}

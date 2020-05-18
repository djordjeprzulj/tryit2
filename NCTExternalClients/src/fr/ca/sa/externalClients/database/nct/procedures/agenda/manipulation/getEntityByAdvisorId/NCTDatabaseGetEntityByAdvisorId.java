package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getEntityByAdvisorId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;
import fr.ca.sa.model.Entity;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetEntityByAdvisorId extends AbstractStoreProcedureHandler {

	private Integer advisorId;

	/**
	 * NCT Database Get Entity By Advisor Id
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 */
	public NCTDatabaseGetEntityByAdvisorId(Integer advisorId) {
		super();
		this.advisorId = advisorId;
	}

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetEntityByAdvisorId.class);

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement cs = connection.prepareStatement("exec spGetEntityByAdvisorId ?");
		try {
			if (this.advisorId != null && this.advisorId != -1) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.advisorId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_1, java.sql.Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}	
		return cs;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_ADVISOR_ENTITY);

	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetEntityByAdvisorIdItemList entityList = new GetEntityByAdvisorIdItemList();
		try {
			while (this.getResultSet().next()) {
				entityList.getAdvisorEntityList()
						.add(new Entity(this.getResultSet().getInt("ENTITY_ID"), null, null,
								this.getResultSet().getString("ENTITY_NAME")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_ADVISOR_ENTITY);
		}
		return entityList;
	}

}

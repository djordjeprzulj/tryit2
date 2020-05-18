package fr.ca.sa.externalClients.database.nct.procedures.todoList.updateToDoItem;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.ToDoListCRUDException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.nct.commons.services.json.event.UpdateToDoItem;

/**
 * Store procedure handler for updating ToDo list item in DB
 * 
 * @author Jelena Stankovski
 *
 */
public class NCTDatabaseUpdateToDoItem extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseUpdateToDoItem.class);
	
	private UpdateToDoItem item;

	/**
	 * NCT Database Update ToDo Item
	 * 
	 * @param item
	 * 				Item
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseUpdateToDoItem(UpdateToDoItem item, int userId) {
		super(userId);
		this.item = item;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement cs = connection.prepareCall("exec spUpdateToDoEvent ?,?,?,?,?,?,?");
		try {
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.item.getEventId());
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.userId);
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.item.getSubject());
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.item.getReminderDate());
			if (this.item.getClientId() == null) {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.INTEGER);
			} else {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.item.getClientId());
			}
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.item.getComment());
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.item.getStatus());
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}				
		return cs;
	}

	public UpdateToDoItem getItem() {
		return item;
	}

	public void setItem(UpdateToDoItem item) {
		this.item = item;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ToDoListCRUDException(ErrorConstants.ERROR_MSG_UPDATE_TODO_ITEM);
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

}
